package com.fengmi.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengmi.entity.goods.MallGoodsCat;
import com.fengmi.entity.vo.CatVo;

import java.util.List;

/**
 * <p>
 * 商品类目 服务类
 * </p>
 *
 * @author huanglian
 * @since 2022-07-27
 */
public interface IMallGoodsCatService extends IService<MallGoodsCat> {
    List<CatVo> findListCatVo();
}
