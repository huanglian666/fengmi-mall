package com.fengmi.cms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fengmi.cms.mapper.ContentMapper;
import com.fengmi.cms.service.IContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengmi.entity.cms.Content;
import org.springframework.stereotype.Service;

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
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements IContentService {

    @Override
    public List<Content> getContentListByTpid(String tpid) {
        QueryWrapper<Content> wrapper = new QueryWrapper<>();
        wrapper.eq("category_id",tpid);
        return this.baseMapper.selectList(wrapper);
    }


}
