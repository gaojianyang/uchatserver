package com.xiri.uchatserver.model.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;

@Data
@ApiModel("上传皮肤传入VO类")
public class UploadSkinVO {

    private long sid;
    private String skinData;
    private long authorId;
    private int createWidth;
    private int createHeight;
    private float price;
    private String desPath;
    private String coverPath;
    private String skinName;
    private int dataType;
    private int changeType;
    private String descript;
    private long referId;


}
