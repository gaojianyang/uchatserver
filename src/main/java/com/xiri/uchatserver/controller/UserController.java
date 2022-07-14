package com.xiri.uchatserver.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.xiri.uchatserver.model.bo.UserDetailBO;
import com.xiri.uchatserver.model.bo.UserLoginBO;
import com.xiri.uchatserver.model.entity.User;
import com.xiri.uchatserver.model.vo.GetUserVO;
import com.xiri.uchatserver.model.vo.UpdateUserVO;
import com.xiri.uchatserver.response.BaseResponse;
import com.xiri.uchatserver.response.RespGenerator;
import com.xiri.uchatserver.service.IUserService;
import com.xiri.uchatserver.utils.TokenUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api(tags = "用户接口")
@RestController
@RequestMapping("userController")
public class UserController {
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "修改用户信息")
    @PostMapping("/updateUserMessage")
    public BaseResponse<String> updateUserMessage(@RequestBody UpdateUserVO updateUserVO) {
        return RespGenerator.returnOK("成功");
    }

    @ApiOperation(value = "获取用户列表信息")
    @PostMapping("/getUserList")
    public BaseResponse<IPage<UserDetailBO>> getUserList(GetUserVO getUserVO) {
        return RespGenerator.returnOK(userService.getUserList(getUserVO));
    }

    @ApiOperation(value = "登录")
    @GetMapping("/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", paramType = "String"),
            @ApiImplicitParam(name = "passWord", value = "密码", paramType = "String")
    })
    public BaseResponse<UserLoginBO> login(@RequestParam(value = "phone") String phone, @RequestParam(value = "passWord") String passWord) throws JsonProcessingException {

        return RespGenerator.returnOK(userService.login(phone, passWord));
    }


}
