package com.xiri.uchatserver.mapper;

import com.xiri.uchatserver.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gjy
 * @since 2022-07-13
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
