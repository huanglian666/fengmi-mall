package com.fengmi.cms.controller;


import com.fengmi.cms.service.IContentService;
import com.fengmi.entity.cms.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/cms/content")
public class ContentController {
    @Autowired
    private IContentService contentService;
    @RequestMapping("/getContentListByTpid/{tpid}")
    public List<Content> getContentListByTpid(@PathVariable("tpid") String tpid){
        return contentService.getContentListByTpid(tpid);
    }

}
