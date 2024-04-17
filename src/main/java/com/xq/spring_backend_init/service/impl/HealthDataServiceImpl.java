package com.xq.spring_backend_init.service.impl;

import com.xq.spring_backend_init.mapper.HealthDataSecondsMapper;
import com.xq.spring_backend_init.model.entity.HealthDataSeconds;
import com.xq.spring_backend_init.model.vo.HealthDataVO;
import com.xq.spring_backend_init.service.HealthDataService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class HealthDataServiceImpl implements HealthDataService {

    @Autowired
    private HealthDataSecondsMapper healthDataSecondsMapper;

    /**
     * 获得所有的健康信息
     * @param residentId
     * @return
     */
    @Override
    public List<HealthDataVO> getAllHealthDataVO(Integer residentId) {
        List<HealthDataVO> healthDataVOS = new ArrayList<>();
        try {
            List<HealthDataSeconds> healthDataSecondsList = healthDataSecondsMapper.selectHealthDataByResidentId(residentId);
            for(HealthDataSeconds healthDataSecond : healthDataSecondsList){
                HealthDataVO healthDataVO = new HealthDataVO();
                BeanUtils.copyProperties(healthDataSecond, healthDataVO);
                healthDataVOS.add(healthDataVO);
            }
        }catch (DataAccessException ex){
            ex.printStackTrace();
        }
        return healthDataVOS;
    }


    /**
     * 获得近15天的健康信息
     * @param residentId
     * @return
     */
    @Override
    public List<HealthDataVO> getHealthDataVOList(Integer residentId) {
        List<HealthDataVO> healthDataVOS = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            List<HealthDataSeconds> healthDataSecondsList = healthDataSecondsMapper.selectHealthDataList(residentId);
            for(HealthDataSeconds healthDataSecond : healthDataSecondsList){
                HealthDataVO healthDataVO = new HealthDataVO();
                BeanUtils.copyProperties(healthDataSecond, healthDataVO);
                healthDataVO.setTime(formatter.format(healthDataSecond.getTime()));
                healthDataVOS.add(healthDataVO);
            }
        }catch (DataAccessException ex){
            ex.printStackTrace();
        }
        return healthDataVOS;
    }

    /**
     * 获取近15天每天的健康数据平均值
     * @param residentId
     * @return
     */
    @Override
    public List<HealthDataVO> getHealthDataVOAvgList(Integer residentId) {
        List<HealthDataVO> healthDataVOS = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (int day = 0; day < 15; day++){
            try{
                List<HealthDataSeconds> healthDataSecondsList = healthDataSecondsMapper.getHealthDate(residentId, day);
                if(healthDataSecondsList.size() == 0)
                    continue;
                double heartRateCount = 0, oxygenLevel = 0;
                for (HealthDataSeconds healthDataSeconds : healthDataSecondsList){
                    heartRateCount += healthDataSeconds.getHeartRate();
                    oxygenLevel += healthDataSeconds.getOxygenLevel();
                }
                double averageHeartRate = heartRateCount / healthDataSecondsList.size(), averageOxygenLevel = oxygenLevel / healthDataSecondsList.size();
                HealthDataVO healthDataVO = new HealthDataVO();
                healthDataVO.setTime(formatter.format(healthDataSecondsList.get(0).getTime()));
                healthDataVO.setHeartRate(averageHeartRate);
                healthDataVO.setOxygenLevel(averageOxygenLevel);
                healthDataVOS.add(healthDataVO);
            }catch (DataAccessException ex){
                ex.printStackTrace();
            }
        }

        return healthDataVOS;
    }


}
