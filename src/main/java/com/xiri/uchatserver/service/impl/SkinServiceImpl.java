package com.xiri.uchatserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiri.uchatserver.config.BaseErrorEnum;
import com.xiri.uchatserver.config.BaseException;
import com.xiri.uchatserver.mapper.UserMapper;
import com.xiri.uchatserver.model.bo.SkinDetailBo;
import com.xiri.uchatserver.model.entity.Skin;
import com.xiri.uchatserver.mapper.SkinMapper;

import com.xiri.uchatserver.model.entity.User;
import com.xiri.uchatserver.model.vo.UploadSkinVO;
import com.xiri.uchatserver.service.ISkinService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author gjy
 * @since 2022-08-22
 */
@Service
public class SkinServiceImpl extends ServiceImpl<SkinMapper, Skin> implements ISkinService {

    private static final Log logger = LogFactory.getLog(SkinServiceImpl.class);
    @Resource
    private SkinMapper skinMapper;

    @Override
    public SkinDetailBo getSkinDetailById(long id) {
        QueryWrapper<Skin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sid", id);
        Skin skin = skinMapper.selectOne(queryWrapper);
        if (skin == null) {
            logger.info(id + "皮肤查询失败");
            throw new BaseException(BaseErrorEnum.RESOURCE_NOT_EXISTS);
        }
        return null;
    }

    @Override
    public List<SkinDetailBo> getHotSkinList(int page) {
        return null;
    }

    @Override
    public SkinDetailBo uploadSkin(UploadSkinVO uploadSkinVO) {
        Skin skin = new Skin();
        skin.setSkindata(uploadSkinVO.getSkinData());
        skinMapper.insert(skin);
        return null;
    }
}
