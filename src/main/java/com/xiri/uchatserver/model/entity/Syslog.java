package com.xiri.uchatserver.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author gjy
 * @since 2022-07-19
 */
@Data
@TableName(value = "syslog")
@Accessors(chain = true)
public class Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("operationUser")
    private String operationUser;

    @TableField("path")
    private String path;

    @TableField("time")
    private String time;

    @TableField("parameter")
    private String parameter;

    @TableField("title")
    private String title;

    @TableField("action")
    private String action;

    @TableField("sysType")
    private Integer sysType;

    @TableField("opType")
    private Integer opType;

    public Syslog(String operationUser, String path, String time,
                  String parameter, String title, String action, Integer sysType, Integer opType) {
        super();
        this.operationUser = operationUser;
        this.path = path;
        this.time = time;
        this.parameter = parameter;
        this.title = title;
        this.action = action;
        this.sysType = sysType;
        this.opType = opType;
    }

}
