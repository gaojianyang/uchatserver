package com.xiri.uchatserver.model.vo;

import com.xiri.uchatserver.model.entity.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("获取皮肤列表传入类")
public class GetSkinVO extends PageParam implements Serializable {
    private static final long serialVersionUID = 8073662434406951441L;

    @ApiModelProperty(value = "皮肤列表类型")
    private Integer listType;

    @ApiModelProperty(value = "内容类型")
    private Integer contentType;

}
