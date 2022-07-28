package com.fengmi.entity.vo;

import com.fengmi.entity.goods.MallGoods;
import com.fengmi.entity.goods.MallGoodsCat;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: CatHotGoodsVo
 * @Description: //TODO
 * @Author: huanglian
 * @Date: 2022/7/28 10:13
 **/
@Data
public class CatHotGoodsVo {
    private MallGoodsCat cat;
    private List<MallGoods> goods;
}
