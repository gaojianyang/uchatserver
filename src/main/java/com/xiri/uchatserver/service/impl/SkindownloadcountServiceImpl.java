package com.xiri.uchatserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiri.uchatserver.mapper.SkinMapper;
import com.xiri.uchatserver.model.entity.Skin;
import com.xiri.uchatserver.model.entity.Skindownloadcount;
import com.xiri.uchatserver.mapper.SkindownloadcountMapper;
import com.xiri.uchatserver.service.ISkindownloadcountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author gjy
 * @since 2023-01-12
 */
@Service
public class SkindownloadcountServiceImpl extends ServiceImpl<SkindownloadcountMapper, Skindownloadcount> implements ISkindownloadcountService {
    private static final Log logger = LogFactory.getLog(SkindownloadcountServiceImpl.class);
    @Resource
    private SkindownloadcountMapper skindownloadcountMapper;

    @Override
    public void countAdd(long sid) {
        QueryWrapper<Skindownloadcount> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sid", sid);
        Skindownloadcount count = skindownloadcountMapper.selectOne(queryWrapper);
        if (count == null) {
            Skindownloadcount insertCount = new Skindownloadcount();
            insertCount.setSid(sid);
            insertCount.setCount(1);
            skindownloadcountMapper.insert(insertCount);
        } else {
            int number = count.getCount();
            number += 1;
            count.setCount(number);
            skindownloadcountMapper.updateById(count);
        }

    }
}
