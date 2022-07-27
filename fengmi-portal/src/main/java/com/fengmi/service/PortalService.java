package com.fengmi.service;

import com.fengmi.entity.cms.Content;
import com.fengmi.entity.vo.CatVo;

import java.util.List;

public interface PortalService {
    List<Content> getContentListByTpid(String tpid);
    List<CatVo> findListCatVo();
}
