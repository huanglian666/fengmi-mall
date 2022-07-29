package com.fengmi.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @ClassName: ResultVo
 * @Description: //TODO
 * @Author: huanglian
 * @Date: 2022/7/29 11:38
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo {
    private String msg;
    private Object data;
    private boolean flag;


}
