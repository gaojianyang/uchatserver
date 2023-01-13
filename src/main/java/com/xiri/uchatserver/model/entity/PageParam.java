package com.xiri.uchatserver.model.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageParam {
    @ApiModelProperty(value = "当前页", required = true)
    private Integer currentPage = 1;

    @ApiModelProperty(value = "每页显示条数", required = true)
    private Integer pageSize = 10;


}
