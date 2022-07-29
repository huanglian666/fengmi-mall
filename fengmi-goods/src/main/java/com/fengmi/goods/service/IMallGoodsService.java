package com.fengmi.goods.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.fengmi.entity.goods.MallGoods;
import com.fengmi.entity.vo.CatHotGoodsVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huanglian
 * @since 2022-07-25
 */
public interface IMallGoodsService extends IService<MallGoods> {
    List<CatHotGoodsVo> findAllCatHotGoods(Integer topn);
    List<MallGoods> findAllEsGoods();
}
