package com.xq.spring_backend_init.service.impl;

import com.xq.spring_backend_init.mapper.HealthDataSecondsMapper;
import com.xq.spring_backend_init.mapper.TemperatureSecondsMapper;
import com.xq.spring_backend_init.model.entity.HealthDataSeconds;
import com.xq.spring_backend_init.model.entity.TemperatureSeconds;
import com.xq.spring_backend_init.model.vo.RoomEnvironmentInfoVO;
import com.xq.spring_backend_init.model.vo.RoomHealthDataVO;
import com.xq.spring_backend_init.service.RoomEnvironmentService;
import com.xq.spring_backend_init.service.RoomResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RoomResidentServiceImpl implements RoomResidentService {

    @Autowired
    private HealthDataSecondsMapper healthDataSecondsMapper;

    @Autowired
    private TemperatureSecondsMapper temperatureSecondsMapper;

    /**
     *
     * 获取最新的房间里老年人的信息
     * @param residentId
     * @return
     */
    @Override
    public RoomHealthDataVO getLeastResidentHealthData(Integer residentId) {

        HealthDataSeconds healthDataSeconds = healthDataSecondsMapper.getLeastHealthData(residentId);
        TemperatureSeconds temperatureSeconds = temperatureSecondsMapper.getLeastTemperature(residentId);

        RoomHealthDataVO roomHealthDataVO = new RoomHealthDataVO();

        roomHealthDataVO.setResidentId(residentId);
        roomHealthDataVO.setTemperature(temperatureSeconds.getBodyTemperature());
        roomHealthDataVO.setHeartRate(healthDataSeconds.getHeartRate());
        roomHealthDataVO.setOxygenLevel(healthDataSeconds.getOxygenLevel());

        return roomHealthDataVO;
    }
}
