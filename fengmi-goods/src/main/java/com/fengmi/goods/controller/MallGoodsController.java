package com.fengmi.goods.controller;


import com.fengmi.entity.vo.CatHotGoodsVo;
import com.fengmi.goods.service.IMallGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huanglian
 * @since 2022-07-25
 */
@RestController
@RequestMapping("/goods")
public class MallGoodsController {
    @Autowired
    private IMallGoodsService iMallGoodsService;
    @Value("${goods.page.topn}")
    private Integer topn;
    @RequestMapping("/findAllCatHotGoods")
    public List<CatHotGoodsVo> findAllCatHotGoods() {
        List<CatHotGoodsVo> allCatHotGoods = iMallGoodsService.findAllCatHotGoods(topn);
        return allCatHotGoods;
    }

}
