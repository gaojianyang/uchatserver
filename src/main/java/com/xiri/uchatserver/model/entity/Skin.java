package com.xiri.uchatserver.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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

    @TableField("skindata")
    private String skindata;

    @TableField("authorid")
    private Long authorid;

    @TableField("createdate")
    private LocalDate createdate;

    @TableField("updatedate")
    private LocalDate updatedate;

    @TableField("descript")
    private String descript;

    @TableField("createscreenwidth")
    private Integer createscreenwidth;

    @TableField("createscreenheight")
    private Integer createscreenheight;

    @TableField("price")
    private Float price;

    @TableField("despath")
    private String despath;

    @TableField("skinstatus")
    private Integer skinstatus;

    @TableField("datatype")
    private Integer datatype;

    @TableField("changetype")
    private Integer changetype;

    @TableField("skinname")
    private String skinname;
}
