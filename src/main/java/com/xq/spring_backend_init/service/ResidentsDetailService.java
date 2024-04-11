package com.xq.spring_backend_init.service;


import com.xq.spring_backend_init.model.vo.HealthDataVO;
import com.xq.spring_backend_init.model.vo.ResidentDetailVO;
import com.xq.spring_backend_init.model.vo.ResidentsVO;

import java.util.List;

public interface ResidentsDetailService {


    /**
     * 获得老年人详细信息
     * @param resident_id
     * @return
     */
    public ResidentDetailVO getResidentDetailInfo(Integer resident_id);

    /**
     * 获得老年人详细信息
     * @param firstName
     * @return
     */
    public List<ResidentDetailVO> getResidentDetailInfo(String firstName);

}
