package com.xiri.uchatserver.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.ArrayList;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author gjy
 * @since 2022-08-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Skin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sid", type = IdType.AUTO)
    private Long sid;

    @TableField(value = "skindata")
    private String skinData;

    @TableField("authorid")
    private Long authorId;

    @TableField("createdate")
    private LocalDate createdate;

    @TableField("updatedate")
    private LocalDate updatedate;

    @TableField("descript")
    private String descript;

    @TableField("createscreenwidth")
    private Integer createWidth;

    @TableField("createscreenheight")
    private Integer createHeight;

    @TableField("price")
    private Float price;

    @TableField(value = "despath", typeHandler = JacksonTypeHandler.class)
    private ArrayList<String> desPaths;

    @TableField("skinstatus")
    private Integer skinstatus;

    @TableField("datatype")
    private Integer dataType;

    @TableField("changetype")
    private Integer changeType;

    @TableField("skinname")
    private String skinName;


}
