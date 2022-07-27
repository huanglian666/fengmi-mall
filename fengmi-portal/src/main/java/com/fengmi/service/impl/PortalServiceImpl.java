package com.fengmi.service.impl;

import cn.hutool.json.JSONUtil;
import com.fengmi.cms.CMSApi;
import com.fengmi.entity.cms.Content;
import com.fengmi.service.PortalService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

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
}
