package com.xq.spring_backend_init.mapper;

import com.xq.spring_backend_init.model.entity.HealthDataSeconds;
import com.xq.spring_backend_init.model.entity.TemperatureSeconds;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.util.List;

/**
 * 体温数据库操作
 */
@Mapper
public interface TemperatureSecondsMapper {

    /**
     * 根据老登信息得到相关体温数据
     *
     * @param residentId
     * @return
     */
    public List<TemperatureSeconds> selectTemeratureDataById(Integer residentId);

    /**
     *
     * 根据老登信息和时间段获得
     *
     */
    public List<TemperatureSeconds> selectTemeratureDataByTime(Integer residentId, Date StartTime, Date endTime);

}
