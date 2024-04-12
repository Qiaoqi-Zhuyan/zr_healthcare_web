package com.xq.spring_backend_init.service.impl;

import com.xq.spring_backend_init.mapper.RoomEnvironmentMapper;
import com.xq.spring_backend_init.model.entity.RoomHumidity;
import com.xq.spring_backend_init.model.entity.RoomTemperature;
import com.xq.spring_backend_init.model.vo.RoomResidentSInfoVO;
import com.xq.spring_backend_init.service.RoomEnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomEnvironmentServiceImpl implements RoomEnvironmentService {

    @Autowired
    private RoomEnvironmentMapper roomEnvironmentMapper;
    @Override
    public void getEnvironment(Integer id) {
        RoomTemperature roomTemperature = roomEnvironmentMapper.getRoomTemperatureById(id);
        RoomHumidity roomHumi = roomEnvironmentMapper.getRoomHumiById(id);
        List<RoomResidentSInfoVO>  list =  roomEnvironmentMapper.getResidentInfoById(id);
        return new
    }
}
