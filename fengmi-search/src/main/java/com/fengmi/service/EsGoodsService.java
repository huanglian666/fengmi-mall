package com.fengmi.service;

import com.fengmi.entity.dto.SearchDto;
import com.fengmi.entity.vo.ResultVo;

public interface EsGoodsService {
    ResultVo init();
    ResultVo search(SearchDto searchdto);


}
