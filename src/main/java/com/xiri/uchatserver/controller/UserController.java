package com.xiri.uchatserver.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.xiri.uchatserver.config.OperationAnnotation;
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

import javax.servlet.http.HttpServletRequest;
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
    public BaseResponse<IPage<UserDetailBO>> getUserList(@RequestBody GetUserVO getUserVO) {
        return RespGenerator.returnOK(userService.getUserList(getUserVO));
    }

    @ApiOperation(value = "登录")
    @GetMapping("/login")
    @OperationAnnotation(content="用户登录",sysType=1,opType=0,action="登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", paramType = "String"),
            @ApiImplicitParam(name = "passWord", value = "密码", paramType = "String")
    })
    public BaseResponse<UserLoginBO> login(@RequestParam(value = "phone") String phone, @RequestParam(value = "passWord") String passWord, HttpServletRequest request) {

        return RespGenerator.returnOK(userService.login(phone, passWord,request));
    }

    @ApiOperation(value = "注册")
    @PostMapping("/register")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", paramType = "String"),
            @ApiImplicitParam(name = "passWord", value = "密码", paramType = "String"),
            @ApiImplicitParam(name = "verifyCode", value = "验证码", paramType = "String")

    })
    public BaseResponse<String> register(@RequestParam(value = "phone") String phone, @RequestParam(value = "passWord") String passWord, @RequestParam(value = "verifyCode") String verifyCode) throws JsonProcessingException {

        return RespGenerator.returnOK(userService.register(phone, passWord, verifyCode));
    }
    @ApiOperation(value = "获取验证码")
    @GetMapping("/getVerifyCode")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", paramType = "String"),
    })
    public BaseResponse<String> getVerifyCode(@RequestParam(value = "phone") String phone) throws JsonProcessingException {

        return RespGenerator.returnOK(userService.getVerifyCode(phone));
    }
}
