package com.fengmi.goods.controller;


import com.fengmi.entity.vo.CatVo;
import com.fengmi.goods.service.IMallGoodsCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商品类目 前端控制器
 * </p>
 *
 * @author huanglian
 * @since 2022-07-27
 */
@RestController
@RequestMapping("/goods/cat")
public class MallGoodsCatController {
    @Autowired
    private IMallGoodsCatService mallGoodsCatService;
    @RequestMapping("/findListCatVo")
    public List<CatVo> findListCatVo(){
        return mallGoodsCatService.findListCatVo();
    }

}
