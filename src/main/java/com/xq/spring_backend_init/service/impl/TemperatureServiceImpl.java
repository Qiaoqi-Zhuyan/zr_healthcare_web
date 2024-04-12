package com.xq.spring_backend_init.service.impl;

import com.xq.spring_backend_init.mapper.TemperatureSecondsMapper;
import com.xq.spring_backend_init.model.entity.TemperatureSeconds;
import com.xq.spring_backend_init.model.vo.HealthDataVO;
import com.xq.spring_backend_init.model.vo.TemperatureVO;
import com.xq.spring_backend_init.service.TemperatureService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class TemperatureServiceImpl implements TemperatureService {

    @Autowired
    private TemperatureSecondsMapper temperatureSecondsMapper;

    @Override
    public List<TemperatureVO> getTemperatureVOList(Integer residentId) {
        List<TemperatureVO> temperatureVOS = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try{
            List<TemperatureSeconds> temperatureSecondsList = temperatureSecondsMapper.selectHealthDataList(residentId);
            for(TemperatureSeconds temperatureSeconds : temperatureSecondsList){
                TemperatureVO temperatureVO = new TemperatureVO();
                BeanUtils.copyProperties(temperatureSeconds, temperatureVO);
                temperatureVO.setTime(formatter.format(temperatureSeconds.getTime()));
                temperatureVOS.add(temperatureVO);
            }
        }catch (DataAccessException ex){
            ex.printStackTrace();
        }

        return temperatureVOS;
    }
}
