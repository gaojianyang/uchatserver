package com.xiri.uchatserver.service;

import com.xiri.uchatserver.model.bo.SkinDetailBo;
import com.xiri.uchatserver.model.entity.Skin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiri.uchatserver.model.vo.UploadSkinVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gjy
 * @since 2022-08-22
 */
public interface ISkinService extends IService<Skin> {

    SkinDetailBo getSkinDetailById(long id);

    List<SkinDetailBo> getHotSkinList(int page);

    SkinDetailBo uploadSkin(UploadSkinVO uploadSkinVO);

}
