package com.xiri.uchatserver.model.bo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class SkinDetailBo implements Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 8073662434406951441L;

    @ApiModelProperty(value = "皮肤ID")
    private String sid;

    @ApiModelProperty(value = "皮肤名称")
    private String skinName;

    @ApiModelProperty(value = "价格")
    private String price;}
