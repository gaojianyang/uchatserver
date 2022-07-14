package com.xiri.uchatserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiri.uchatserver.model.bo.UserDetailBO;
import com.xiri.uchatserver.model.bo.UserLoginBO;
import com.xiri.uchatserver.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiri.uchatserver.model.vo.GetUserVO;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author gjy
 * @since 2022-07-13
 */
public interface IUserService extends IService<User> {

    /**
     * 登录
     *
     * @param phone
     * @param password
     * @return
     */
    UserLoginBO login(String phone, String password);

    /**
     * 分页查询用户信息
     *
     * @param getUserVO
     * @return
     */
    IPage<UserDetailBO> getUserList(GetUserVO getUserVO);

}
