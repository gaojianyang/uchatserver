package com.xiri.uchatserver.model.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("上传皮肤传入VO类")
public class UploadSkinVO {

    private long sid;
    private String skinData;
    private long authorId;
    private int cWidth;
    private int cHeight;
    private float price;
    private String desPath;
    private String skinName;
    private int dataType;
    private int changeType;


}
