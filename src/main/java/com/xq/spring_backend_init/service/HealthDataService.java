package com.xq.spring_backend_init.service;


import com.xq.spring_backend_init.model.vo.HealthDataVO;
import com.xq.spring_backend_init.model.vo.TemperatureVO;

import java.util.List;

public interface HealthDataService {

    /**
     * 获得所有的健康信息
     * @param residentId
     * @return
     */
    public List<HealthDataVO> getAllHealthDataVO(Integer residentId);

    /**
     * 获得近15天的健康信息
     * @param residentId
     * @return
     */
    public List<HealthDataVO> getHealthDataVOList(Integer residentId);

    /**
     * 获取近15天每天的健康数据平均值
     * @param residentId
     * @return
     */
    public List<HealthDataVO> getHealthDataVOAvgList(Integer residentId);

}
