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
 * @since 2022-07-13
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("user_name")
    private String userName;

    @TableField("avatar")
    private String avatar;

    @TableField("phone")
    private String phone;

    @TableField("pwd")
    private String pwd;

    @TableField("bind_peer")
    private Long bindPeer;

    @TableField("bind_skin")
    private Long bindSkin;

    @TableField("user_description")
    private String userDescription;

    @TableField("is_deleted")
    private Integer isDeleted;

    @TableField("visible")
    private Integer visible;

    @TableField("created_at")
    private LocalDate createdAt;

    @TableField("update_at")
    private LocalDate updateAt;


}
