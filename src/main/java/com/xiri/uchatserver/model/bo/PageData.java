package com.xiri.uchatserver.model.bo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class PageData<T> {
    @ApiModelProperty(value = "数据")
    private List<T> data;

    @ApiModelProperty(value = "当前页")
    private Integer currentPage ;

    @ApiModelProperty(value = "每页显示条数")
    private Integer pageSize ;



}
