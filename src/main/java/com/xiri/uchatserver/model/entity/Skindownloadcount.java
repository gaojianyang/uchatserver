package com.xiri.uchatserver.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2023-01-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Skindownloadcount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("sid")
    private Long sid;

    @TableField("count")
    private Integer count;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


}
