package com.fengmi.goods.service.impl;

import com.fengmi.entity.goods.MallGoodsCat;
import com.fengmi.entity.vo.CatVo;
import com.fengmi.goods.mapper.MallGoodsCatMapper;
import com.fengmi.goods.service.IMallGoodsCatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品类目 服务实现类
 * </p>
 *
 * @author huanglian
 * @since 2022-07-27
 */
@Service
public class MallGoodsCatServiceImpl extends ServiceImpl<MallGoodsCatMapper, MallGoodsCat> implements IMallGoodsCatService {
    @Autowired
    private MallGoodsCatMapper mallGoodsCatMapper;
    @Override
    public List<CatVo> findListCatVo() {
        return mallGoodsCatMapper.findListCatVo();
    }
}
