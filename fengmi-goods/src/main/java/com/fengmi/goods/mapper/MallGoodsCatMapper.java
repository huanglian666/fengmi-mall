package com.fengmi.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fengmi.entity.goods.MallGoodsCat;
import com.fengmi.entity.vo.CatVo;

import java.util.List;

/**
 * <p>
 * 商品类目 Mapper 接口
 * </p>
 *
 * @author huanglian
 * @since 2022-07-27
 */
public interface MallGoodsCatMapper extends BaseMapper<MallGoodsCat> {
    List<CatVo> findListCatVo();

}
