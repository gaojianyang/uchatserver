package com.xiri.uchatserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiri.uchatserver.model.bo.UserDetailBO;
import com.xiri.uchatserver.model.bo.UserLoginBO;
import com.xiri.uchatserver.model.entity.User;
import com.xiri.uchatserver.mapper.UserMapper;
import com.xiri.uchatserver.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiri.uchatserver.utils.TokenUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    @Resource
    private UserMapper userMapper;

    @Override
    public UserLoginBO login(String phone, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        queryWrapper.eq("password", password);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            return null;
        } else {
            UserDetailBO userDetailBO = new UserDetailBO();
            BeanUtils.copyProperties(user, userDetailBO);
            UserLoginBO userLoginBO = new UserLoginBO();
            userLoginBO.setUserDetailBO(userDetailBO);
            //包装token
            String token = TokenUtils.sign(user);
            userLoginBO.setToken(token);
            return userLoginBO;
        }
    }
}
