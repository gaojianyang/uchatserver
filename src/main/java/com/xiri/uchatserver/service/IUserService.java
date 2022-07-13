package com.xiri.uchatserver.service;

import com.xiri.uchatserver.model.bo.UserLoginBO;
import com.xiri.uchatserver.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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

}
