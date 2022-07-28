package com.fengmi.service.impl;

import cn.hutool.json.JSONUtil;
import com.fengmi.cms.CMSApi;
import com.fengmi.entity.cms.Content;
import com.fengmi.entity.vo.CatHotGoodsVo;
import com.fengmi.entity.vo.CatVo;
import com.fengmi.goods.GoodsApi;
import com.fengmi.service.PortalService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: PortalServiceImpl
 * @Description: //TODO
 * @Author: huanglian
 * @Date: 2022/7/26 9:37
 **/
@Service
public class PortalServiceImpl implements PortalService {
    @Autowired
    private GoodsApi goodsApi;

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private CMSApi cmsApi;
    @Override
    public List<Content> getContentListByTpid(String tpid) {
        BoundHashOperations<String, String, String> ops = redisTemplate.boundHashOps("protal:content");
        String s = ops.get(tpid);
        if(StringUtils.isEmpty(s)){
            synchronized (this){
                s=ops.get(tpid);
                if(StringUtils.isEmpty(s)){
                    List<Content> contentListByTpid = cmsApi.getContentListByTpid(tpid);
                    String jsonStr = JSONUtil.toJsonStr(contentListByTpid);
                    ops.put(tpid,jsonStr);
                    return contentListByTpid;
                }else{
                    List<Content> contents = JSONUtil.toList(s, Content.class);
                    return contents;
                }
            }

        }
        List<Content> contents = JSONUtil.toList(s, Content.class);
        return contents;
    }

    @Override
    public List<CatVo> findListCatVo() {
        BoundValueOperations<String, String> ops = redisTemplate.boundValueOps("portal:mallCat");
        String s = ops.get();
        if(StringUtils.isEmpty(s)){
            synchronized (this){
                s=ops.get();
                if(StringUtils.isEmpty(s)){
                    List<CatVo> catVos = goodsApi.findListCatVo();
                    String jsonStr = JSONUtil.toJsonStr(catVos);
                    ops.set(jsonStr);
                    return catVos;
                }else{
                    List<CatVo> catVos = JSONUtil.toList(s, CatVo.class);
                    return catVos;
                }
            }
        }
        return JSONUtil.toList(s,CatVo.class);

    }

    @Override
    public List<CatHotGoodsVo> findAllCatHotGoods() {
        BoundHashOperations<String, String, String> ops = redisTemplate.boundHashOps("portal:hotGoods");
        List<String> values = ops.values();
        ArrayList<CatHotGoodsVo> list = new ArrayList<>();
        if(values==null||values.size()<=0){
            synchronized (this){
                values=ops.values();
                if(values==null||values.size()<=0){
                    List<CatHotGoodsVo> allCatHotGoods = goodsApi.findAllCatHotGoods();
                    for (CatHotGoodsVo CatHotGood : allCatHotGoods) {
                        String s = JSONUtil.toJsonStr(CatHotGood);
                        ops.put(CatHotGood.getCat().getId()+"",s);
                    }
                    return allCatHotGoods;
                }
            }
        }
        values=ops.values();
        for (String value : values) {
            CatHotGoodsVo catHotGoodsVo = JSONUtil.toBean(value, CatHotGoodsVo.class);
            list.add(catHotGoodsVo);
        }
        return list;
    }
}
