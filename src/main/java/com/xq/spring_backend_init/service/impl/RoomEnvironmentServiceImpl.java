package com.xq.spring_backend_init.service.impl;

import com.xq.spring_backend_init.mapper.ResidentsMapper;
import com.xq.spring_backend_init.mapper.RoomEnvironmentMapper;
import com.xq.spring_backend_init.model.entity.RoomHunidity;
import com.xq.spring_backend_init.model.entity.RoomTemperature;
import com.xq.spring_backend_init.model.vo.RoomEnvironmentInfoVO;
import com.xq.spring_backend_init.service.ResidentsService;
import com.xq.spring_backend_init.service.RoomEnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomEnvironmentServiceImpl implements RoomEnvironmentService {
    @Autowired
    private ResidentsMapper residentsMapper;

    @Autowired
    private  RoomEnvironmentMapper roomEnvironmentMapper;

    @Override
    public RoomEnvironmentInfoVO getLeastInfo(Integer staffId) {

        String roomNumber = residentsMapper.getRoomNumberByStaffId(staffId);
        RoomTemperature roomTemperature = roomEnvironmentMapper.getLeastTemperature(roomNumber);
        RoomHunidity roomHunidity = roomEnvironmentMapper.getLeastRoomHumity(roomNumber);
        return new RoomEnvironmentInfoVO(roomTemperature.getRoomTemperature(), roomHunidity.getRoomHumidity());
    }
}
