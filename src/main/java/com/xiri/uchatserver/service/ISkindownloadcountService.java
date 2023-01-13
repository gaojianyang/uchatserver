package com.xiri.uchatserver.service;

import com.xiri.uchatserver.model.entity.Skindownloadcount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gjy
 * @since 2023-01-12
 */
public interface ISkindownloadcountService extends IService<Skindownloadcount> {

    void countAdd(long sid);

}
