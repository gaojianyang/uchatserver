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
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

import static com.xiri.uchatserver.config.BaseErrorEnum.INSERT_WRONG;
import static com.xiri.uchatserver.config.BaseErrorEnum.PHONE_REGISTER_ERROR;

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
        SkinDetailBo skinDetailBo = new SkinDetailBo();
        BeanUtils.copyProperties(skin, skinDetailBo);
        return skinDetailBo;
    }

    @Override
    public List<SkinDetailBo> getHotSkinList(int page) {
        return null;
    }

    @Override
    public SkinDetailBo uploadSkin(UploadSkinVO uploadSkinVO) {
        Skin skin = new Skin();
        skin.setSkindata(uploadSkinVO.getSkinData());
        skin.setCreatescreenwidth(uploadSkinVO.getCWidth());
        skin.setCreatescreenheight(uploadSkinVO.getCHeight());
        skin.setAuthorid(uploadSkinVO.getAuthorId());
        skin.setSkinname(uploadSkinVO.getSkinName());
        skin.setPrice(uploadSkinVO.getPrice());
        skin.setCreatedate(LocalDate.now());
        skin.setUpdatedate(skin.getCreatedate());
        int result = skinMapper.insert(skin);
        if (result > 0) {
            logger.info("插入皮肤" + result + " id" + skin.getSid());
            SkinDetailBo detailBo = new SkinDetailBo();
            BeanUtils.copyProperties(skin, detailBo);
            return detailBo;
        } else {
            throw new BaseException(INSERT_WRONG);
        }
    }

    @Override
    public SkinDetailBo updateSkin(UploadSkinVO uploadSkinVO) {
        long sid = uploadSkinVO.getSid();
        QueryWrapper<Skin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sid", sid);
        queryWrapper.eq("authorid", uploadSkinVO.getAuthorId());
        Skin skin = skinMapper.selectOne(queryWrapper);
        if (skin != null) {
            if (StringUtils.hasText(uploadSkinVO.getSkinData()))
                skin.setSkindata(uploadSkinVO.getSkinData());
            if (uploadSkinVO.getPrice() != 0)
                skin.setPrice(uploadSkinVO.getPrice());
            skin.setUpdatedate(LocalDate.now());
            int result = skinMapper.updateById(skin);
            if (result > 0) {
                return new SkinDetailBo();
            } else {
                throw new BaseException(BaseErrorEnum.UPDATE_WRONG);
            }
        } else {
            logger.info(sid + "皮肤更新失败");
            throw new BaseException(BaseErrorEnum.RESOURCE_NOT_EXISTS);
        }

    }

    @Override
    public String downloadSkin(long id) {
        QueryWrapper<Skin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sid", id);
        Skin skin = skinMapper.selectOne(queryWrapper);
        if (skin != null) {
            return skin.getSkindata();
        } else {
            throw new BaseException(BaseErrorEnum.RESOURCE_NOT_EXISTS);
        }

    }
}
