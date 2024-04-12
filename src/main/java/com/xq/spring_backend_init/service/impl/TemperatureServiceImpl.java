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

    /**
     * 统计15天的体温数据
     * @param residentId
     * @return
     */
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


    /**
     * 获取近15天每天的体温数据平均值
     * @param residentId
     * @return
     */
    @Override
    public List<TemperatureVO> getTemperatureVOAvgList(Integer residentId) {
        List<TemperatureVO> temperatureVOList = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for(int day = 0; day < 15; day++){
            try{
                List<TemperatureSeconds> temperatureSecondsList = temperatureSecondsMapper.getTemperature(residentId, day);
                if (temperatureSecondsList.size() == 0)
                    continue;
                double temperatureCount = 0;
                for (TemperatureSeconds temperatureSeconds : temperatureSecondsList)
                    temperatureCount += temperatureSeconds.getBodyTemperature();
                double averageTemperature = temperatureCount / temperatureSecondsList.size();
                TemperatureVO temperatureVO = new TemperatureVO();
                temperatureVO.setBodyTemperature(averageTemperature);
                temperatureVO.setTime(formatter.format(temperatureSecondsList.get(0).getTime()));
                temperatureVOList.add(temperatureVO);
            }catch (DataAccessException ex){
                ex.printStackTrace();
            }
        }

        return temperatureVOList;
    }


}
