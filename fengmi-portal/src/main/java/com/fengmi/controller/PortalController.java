package com.fengmi.controller;

import com.fengmi.entity.cms.Content;
import com.fengmi.service.PortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: PortalController
 * @Description: //TODO
 * @Author: huanglian
 * @Date: 2022/7/26 10:15
 **/
@RestController
@RequestMapping("/portal")
public class PortalController {
    @Autowired
    private PortalService portalService;
    @RequestMapping("/getContentListByTpid/{tpid}")
    public List<Content> getContentListByTpid(@PathVariable("tpid") String tpid){
        return portalService.getContentListByTpid(tpid);
    }
}
