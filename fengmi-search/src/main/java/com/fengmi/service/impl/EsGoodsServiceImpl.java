package com.fengmi.service.impl;

import com.fengmi.entity.ESGoods;
import com.fengmi.entity.dto.SearchDto;
import com.fengmi.entity.goods.MallGoods;
import com.fengmi.entity.vo.ResultVo;
import com.fengmi.goods.GoodsApi;
import com.fengmi.service.EsGoodsService;
import org.apache.lucene.util.QueryBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: EsGoodsServiceImpl
 * @Description: //TODO
 * @Author: huanglian
 * @Date: 2022/7/29 11:40
 **/
@Service
public class EsGoodsServiceImpl implements EsGoodsService {
    @Autowired
    private GoodsApi goodsApi;
    @Autowired
    private ElasticsearchRestTemplate elastic;

    @Override
    public ResultVo init() {
        elastic.deleteIndex(ESGoods.class);
        elastic.createIndex(ESGoods.class);
        elastic.putMapping(ESGoods.class);
        List<MallGoods> goodsList = goodsApi.findAllEsGoods();
        List<ESGoods> esGoods = goodsList.stream().map(good -> {
            ESGoods esGood = new ESGoods();
            esGood.setSpuId(good.getSpuId());
            esGood.setBrandId(good.getBrand().getId());
            esGood.setBrandName(good.getBrand().getName());
            esGood.setCid1id(good.getCat1().getId());
            esGood.setCat1name(good.getCat1().getName());
            esGood.setCid2id(good.getCat2().getId());
            esGood.setCat2name(good.getCat2().getName());
            esGood.setCid3id(good.getCat3().getId());
            esGood.setCat3name(good.getCat3().getName());
            esGood.setCreateTime(new Date());
            esGood.setGoodsName(good.getGoodsName());
            esGood.setImageUrl(good.getAlbumPics());
            esGood.setPrice(good.getPrice().doubleValue());
            return esGood;
        }).collect(Collectors.toList());
        elastic.save(esGoods);
        return new ResultVo("初始化成功",esGoods,true);
    }

    @Override
    public ResultVo search(SearchDto searchdto) {
        NativeSearchQuery build=null;
        if(searchdto.getKeyword().equals("")){
            MatchAllQueryBuilder matchallquery = QueryBuilders.matchAllQuery();
            build= new NativeSearchQueryBuilder()
                    .withQuery(matchallquery)
                    .build();

        }else{
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            MatchQueryBuilder goodsName = QueryBuilders.matchQuery("goodsName", searchdto.getKeyword());
            MatchQueryBuilder brandName = QueryBuilders.matchQuery("brandName", searchdto.getKeyword());
            MatchQueryBuilder cat3name = QueryBuilders.matchQuery("cat3name", searchdto.getKeyword());
            boolQueryBuilder.should(goodsName).should(brandName).should(cat3name);

            build= new NativeSearchQueryBuilder()
                    .withQuery(boolQueryBuilder)
                    .build();
        }


        SearchHits<ESGoods> esGoodsSearchHits = elastic.search(build, ESGoods.class);

        List<ESGoods> list = esGoodsSearchHits.getSearchHits().stream().map(esGoodsSearchHit -> {
            return esGoodsSearchHit.getContent();
        }).collect(Collectors.toList());


        return new ResultVo("查询成功",list,true);
    }

}
