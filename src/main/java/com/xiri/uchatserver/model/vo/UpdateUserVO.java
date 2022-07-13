package com.xiri.uchatserver.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("修改用户信息传入VO类")
public class UpdateUserVO implements Serializable {

    /**
     * 序列化
     */
    private static final long serialVersionUID = 8073662434406951441L;

    @ApiModelProperty(value = "用户ID")
    private String uid;

    @ApiModelProperty(value = "用户密码")
    private String password;

}
