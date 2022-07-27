package com.fengmi.service;

import com.fengmi.entity.cms.Content;

import java.util.List;

public interface PortalService {
    List<Content> getContentListByTpid(String tpid);
}
