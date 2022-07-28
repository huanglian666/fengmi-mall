package com.fengmi.goods;

import com.fengmi.entity.vo.CatHotGoodsVo;
import com.fengmi.entity.vo.CatVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("fengmi-goods")
@RequestMapping("/goods")
public interface GoodsApi {
    @RequestMapping("/cat/findListCatVo")
    List<CatVo> findListCatVo();
    @RequestMapping("/findAllCatHotGoods")
    List<CatHotGoodsVo> findAllCatHotGoods();
}
