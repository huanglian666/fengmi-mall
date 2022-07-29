package com.fengmi.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fengmi.entity.goods.MallGoods;
import com.fengmi.entity.goods.MallGoodsCat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huanglian
 * @since 2022-07-25
 */
public interface MallGoodsMapper extends BaseMapper<MallGoods> {
    List<MallGoodsCat> findAllCat();
    List<MallGoods> findHotGoods(@Param("catId") String catId, @Param("topn") Integer topn);
    List<MallGoods> findAllEsGoods();
}
