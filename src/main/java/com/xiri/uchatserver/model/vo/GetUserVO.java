package com.xiri.uchatserver.model.vo;

import com.xiri.uchatserver.model.entity.PageParam;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetUserVO extends PageParam implements Serializable {
    private static final long serialVersionUID = 8073662434406951441L;

    @ApiModelProperty(value = "用户名称")
    private String userName;
}
