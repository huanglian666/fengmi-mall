package com.fengmi.controller;

import com.fengmi.entity.dto.SearchDto;
import com.fengmi.entity.vo.ResultVo;
import com.fengmi.service.EsGoodsService;
import org.elasticsearch.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: SearchController
 * @Description: //TODO
 * @Author: huanglian
 * @Date: 2022/7/29 11:38
 **/
@RestController
@RequestMapping("/search")
public class SearchController {
    public static int index=0;
    @Autowired
    private EsGoodsService esGoodsService;
    @RequestMapping("/init")
    public ResultVo init(){
        return esGoodsService.init();
    }
    @RequestMapping("/search")
    public ResultVo search(@RequestBody SearchDto searchDto){
        if(index==0){
            this.esGoodsService.init();
            index=index+1;
            System.out.println(index);
        }
        return esGoodsService.search(searchDto);
    }
}
