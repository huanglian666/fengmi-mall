package com.fengmi.cms;

import com.fengmi.entity.cms.Content;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("fengmi-cms")
@RequestMapping("/cms/content")
public interface CMSApi {
    @RequestMapping("/getContentListByTpid/{tpid}")
    public List<Content> getContentListByTpid(@PathVariable("tpid") String tpid);
}
