package com.fengmi.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: CatVo
 * @Description: //TODO
 * @Author: huanglian
 * @Date: 2022/7/27 15:18
 **/
@Data
public class CatVo {
    private String name;
    private String id;
    private List<CatVo> children;
}
