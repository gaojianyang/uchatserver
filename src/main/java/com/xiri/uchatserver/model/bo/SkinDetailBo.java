package com.xiri.uchatserver.model.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
@ApiModel("皮肤详情BO类")
public class SkinDetailBo implements Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 8073662434406951441L;

    @ApiModelProperty(value = "皮肤ID")
    private long sid;

    @ApiModelProperty(value = "皮肤名称")
    private String skinname;

    @ApiModelProperty(value = "价格")
    private float price;

    @ApiModelProperty(value = "预览图片地址")
    private String despath;

    @ApiModelProperty(value = "数据类型")
    private  Integer datatype;
}
