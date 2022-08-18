package com.xiri.uchatserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiri.uchatserver.config.BaseErrorEnum;
import com.xiri.uchatserver.config.BaseException;
import com.xiri.uchatserver.model.bo.UserDetailBO;
import com.xiri.uchatserver.model.bo.UserLoginBO;
import com.xiri.uchatserver.model.entity.User;
import com.xiri.uchatserver.mapper.UserMapper;
import com.xiri.uchatserver.model.vo.GetUserVO;
import com.xiri.uchatserver.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiri.uchatserver.utils.RedisUtils;
import com.xiri.uchatserver.utils.TokenUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.xiri.uchatserver.config.BaseErrorEnum.PHONE_REGISTER_ERROR;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author gjy
 * @since 2022-07-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
//    @Resource
//    private UserMapper userMapper;
//
//    @Override
//    public UserLoginBO login(String phone, String password) {
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("phone", phone);
//        queryWrapper.eq("pwd", password);
//        User user = userMapper.selectOne(queryWrapper);
//        if (user == null) {
//            return null;
//        } else {
//            UserDetailBO userDetailBO = new UserDetailBO();
//            BeanUtils.copyProperties(user, userDetailBO);
//            UserLoginBO userLoginBO = new UserLoginBO();
//            userLoginBO.setUserDetailBO(userDetailBO);
//            //包装token
//            String token = TokenUtils.sign(user);
//            userLoginBO.setToken(token);
//            return userLoginBO;
//        }
//    }
    /**
     * 静态变量：系统日志
     */
    private static final Log logger = LogFactory.getLog(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisUtils redisUtils;

    /**
     * 什么时候被锁定
     */
    private final static Integer LOCKEDNUMBER = 3;

    @Override
    public UserLoginBO login(String username, String password, HttpServletRequest request) {

        //判断该账户是否被锁定
        String errorNumber;
        if (redisUtils.get("errorNumber") != null) {
            errorNumber = redisUtils.get("errorNumber");
        } else {
            errorNumber = "0";
        }
        if (Integer.parseInt(errorNumber) >= LOCKEDNUMBER) {
            logger.info(username + "账户已被锁定");
            throw new BaseException(BaseErrorEnum.USER_NAME_LOCK);
        }
        //查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            logger.info(username + "用户登录失败");
            throw new BaseException(BaseErrorEnum.USER_NOT_EXISTS);
        } else if (!Objects.equals(user.getPwd(), password)) {
            //密码错误
            Integer result = Integer.parseInt(errorNumber) + 1;
            errorNumber = result.toString();
            if (redisUtils.get("errorNumber") != null) {
                redisUtils.getAndSet("errorNumber", errorNumber);
            } else {
                redisUtils.set("errorNumber", errorNumber);
            }
            throw new BaseException(BaseErrorEnum.PASSWORD_ERROR);
        } else {
            UserDetailBO userDetailBO = new UserDetailBO();
            BeanUtils.copyProperties(user, userDetailBO);
            UserLoginBO userLoginBO = new UserLoginBO();
            userLoginBO.setUserDetailBO(userDetailBO);
            //包装token
            String token = TokenUtils.sign(user);
            //token存入redis
            redisUtils.set("token", token, 30, TimeUnit.MINUTES);
            userLoginBO.setToken(token);
            logger.info(username + "用户登录成功");
            HttpSession session = request.getSession();
            session.setAttribute("userName", username);
            return userLoginBO;
        }
    }

    @Override
    public String register(String phone, String password, String verifyCode) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        User user = userMapper.selectOne(queryWrapper);
        if (user != null) {
            throw new BaseException(BaseErrorEnum.PHONE_HAS_REGISTER);
        } else {
            User newUser = new User();
            newUser.setPhone(phone);
            newUser.setPwd(password);
            int insert = userMapper.insert(newUser);
            if (insert > 0) {
                logger.info(phone + "用户注册成功");

                return "注册成功";
            } else {
                throw new BaseException(PHONE_REGISTER_ERROR);
            }
        }

    }

    @Override
    public String getVerifyCode(String phone) {
        return "发送成功";
    }

    @Override
    public IPage<UserDetailBO> getUserList(GetUserVO getUserVO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", getUserVO.getUserName());
        Page<User> p = new Page<>(getUserVO.getCurrentPage(), getUserVO.getPageSize());
        IPage<User> userIPage = userMapper.selectPage(p, queryWrapper);
        IPage<UserDetailBO> page = new Page<>();
        List<UserDetailBO> userDetailBOList = new ArrayList<>();
        for (User user : userIPage.getRecords()) {
            UserDetailBO userDetailBO = new UserDetailBO();
            BeanUtils.copyProperties(user, userDetailBO);
            userDetailBOList.add(userDetailBO);
        }
        page.setRecords(userDetailBOList);
        page.setCurrent(userIPage.getCurrent());
        page.setPages(userIPage.getPages());
        page.setSize(userIPage.getSize());
        page.setTotal(userIPage.getTotal());

        return page;
    }
}
