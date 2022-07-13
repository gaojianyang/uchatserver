package com.xiri.uchatserver.controller;

import com.xiri.uchatserver.model.bo.UserDetailBO;
import com.xiri.uchatserver.model.vo.UpdateUserVO;
import com.xiri.uchatserver.response.BaseResponse;
import com.xiri.uchatserver.response.RespGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "用户接口")
@RestController
@RequestMapping("userController")
public class UserController {
    @ApiOperation(value = "修改用户信息")
    @PostMapping("/updateUserMessage")
    public BaseResponse<Integer> updateUserMessage(@RequestBody UpdateUserVO updateUserVO) {
        return RespGenerator.returnOK("成功");
    }

    @ApiOperation(value = "获取用户列表信息")
    @PostMapping("/getUserList")
    public BaseResponse<List<UserDetailBO>> getUserList() {
        return RespGenerator.returnOK("成功");
    }
}
