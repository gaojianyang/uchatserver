package com.xiri.uchatserver.controller;

import com.xiri.uchatserver.model.bo.SkinDetailBo;
import com.xiri.uchatserver.response.BaseResponse;
import com.xiri.uchatserver.response.RespGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "皮肤接口")
@RestController
@RequestMapping("/skinController")
public class SkinController {
    @ApiOperation(value = "获取皮肤详情信息")
    @GetMapping("/getProductDetail")
    @ApiImplicitParam(name = "sid", value = "皮肤id", paramType = "String")
    public BaseResponse<String> getProductDetail(@RequestParam(value = "sid") String sid) {
        return RespGenerator.returnOK("成功");
    }

    @ApiOperation(value = "获取皮肤列表信息")
    @PostMapping("/getSkinList")
    public BaseResponse<String> getSkinList() {
        return RespGenerator.returnOK("成功");
    }

//    @ApiOperation(value = "删除产品")
//    @PostMapping("/deleteProductList")
//    public BaseResponse<Integer> deleteProductList(@RequestBody DeleteProductVO deleteProductVO) {
//        return RespGenerator.returnOK("成功");
//    }
}
