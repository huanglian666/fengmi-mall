package com.fengmi.cms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fengmi.entity.cms.Content;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huanglian
 * @since 2022-07-25
 */
public interface IContentService extends IService<Content> {
    List<Content> getContentListByTpid(String tpid);

}
