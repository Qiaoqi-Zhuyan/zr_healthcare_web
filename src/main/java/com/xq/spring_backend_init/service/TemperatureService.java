package com.xq.spring_backend_init.service;

import com.xq.spring_backend_init.model.vo.HealthDataVO;
import com.xq.spring_backend_init.model.vo.TemperatureVO;

import java.util.List;

public interface TemperatureService {

    /**
     * 获得近15天的体温信息
     * @param residentId
     * @return
     */
    public List<TemperatureVO> getTemperatureVOList(Integer residentId);

}
