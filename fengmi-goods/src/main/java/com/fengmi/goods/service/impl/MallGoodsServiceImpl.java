package com.fengmi.goods.service.impl;

import com.fengmi.entity.goods.MallGoods;
import com.fengmi.entity.goods.MallGoodsCat;
import com.fengmi.entity.vo.CatHotGoodsVo;
import com.fengmi.goods.mapper.MallGoodsMapper;
import com.fengmi.goods.service.IMallGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huanglian
 * @since 2022-07-25
 */
@Service
public class MallGoodsServiceImpl extends ServiceImpl<MallGoodsMapper, MallGoods> implements IMallGoodsService {


    @Override
    public List<CatHotGoodsVo> findAllCatHotGoods(Integer topn) {
        ArrayList<CatHotGoodsVo> catHotGoodsVos = new ArrayList<>();
        List<MallGoodsCat> allCat = this.baseMapper.findAllCat();
        for (MallGoodsCat cat : allCat) {
            List<MallGoods> hotGoods = this.baseMapper.findHotGoods(cat.getId()+"", topn);
            int len = hotGoods.size();
            if(len<6){
                MallGoods mallGoods = hotGoods.get(len - 1);
                for(int i=0;i<6-len;i++){
                    hotGoods.add(mallGoods);
                }
            }
            CatHotGoodsVo catHotGoodsVo = new CatHotGoodsVo();
            catHotGoodsVo.setCat(cat);
            catHotGoodsVo.setGoods(hotGoods);
            catHotGoodsVos.add(catHotGoodsVo);
        }
        return catHotGoodsVos;
    }

    @Override
    public List<MallGoods> findAllEsGoods() {
        return this.baseMapper.findAllEsGoods();
    }
}
