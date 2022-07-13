package com.xiri.uchatserver.model.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@ApiModel("用户详情BO类")
public class UserLoginBO implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 8073662434406951441L;

    @ApiModelProperty(value = "用户信息")
    private UserDetailBO userDetailBO;

    @ApiModelProperty(value = "token")
    private String token;

//    @ApiModelProperty(value = "token时效")
//    private Date tokenTime;

}