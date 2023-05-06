package com.xiri.uchatserver.controller;

import com.xiri.uchatserver.model.bo.SkinDetailBo;
import com.xiri.uchatserver.model.vo.UploadSkinVO;
import com.xiri.uchatserver.response.BaseResponse;
import com.xiri.uchatserver.response.RespGenerator;
import com.xiri.uchatserver.service.ISkinService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "皮肤接口")
@RestController
@RequestMapping("/skinController")
public class SkinController {
    @Autowired
    private ISkinService skinService;

    @ApiOperation(value = "获取皮肤详情信息")
    @GetMapping("/getProductDetail")
    @ApiImplicitParam(name = "sid", value = "皮肤id", paramType = "String")
    public BaseResponse<SkinDetailBo> getProductDetail(@RequestParam(value = "sid") long sid) {
        return RespGenerator.returnOK(skinService.getSkinDetailById(sid));
    }

    @ApiOperation(value = "获取皮肤列表信息")
    @GetMapping("/getSkinList")
    public BaseResponse<String> getSkinList(@RequestParam(value = "type") int type,@RequestParam(value = "page")int page,@RequestParam(value = "pageLine")int pageLine) {
        return RespGenerator.returnOK("成功");
    }

    @ApiOperation(value = "上传皮肤")
    @PostMapping("/uploadSkin")
    public BaseResponse<SkinDetailBo> uploadSkin(@RequestBody UploadSkinVO uploadSkinVO) {
        return RespGenerator.returnOK(skinService.uploadSkin(uploadSkinVO));
    }

    @ApiOperation(value = "下载皮肤")
    @PostMapping("/downloadSkin")
    public BaseResponse<String> downloadSkin(@RequestParam(value = "sid") long sid) {
        return RespGenerator.returnOK(skinService.downloadSkin(sid));
    }


//    @ApiOperation(value = "删除产品")
//    @PostMapping("/deleteProductList")
//    public BaseResponse<Integer> deleteProductList(@RequestBody DeleteProductVO deleteProductVO) {
//        return RespGenerator.returnOK("成功");
//    }
}
