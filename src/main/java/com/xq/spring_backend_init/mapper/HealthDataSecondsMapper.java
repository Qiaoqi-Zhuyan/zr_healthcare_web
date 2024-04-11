package com.xq.spring_backend_init.mapper;

import com.xq.spring_backend_init.model.entity.HealthDataSeconds;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.util.List;

/**
 *  老登血氧心率查询
 */
@Mapper
public interface HealthDataSecondsMapper {

    /**
     * 根据老登信息得到相关健康数据
     *
     * @param residentId
     * @return
     */
    public List<HealthDataSeconds> selectHealthDataByResidentId(Integer residentId);

    /**
     *
     * 根据老登信息和时间段获得
     *
     */
    public List<HealthDataSeconds> selectHealthDataByTime(Integer residentId, Date startTime, Date endTime);

    /**
     *
     * 获取最近15天的信息
     *
     * @param residentId
     * @return
     */
    public List<HealthDataSeconds> selectHealthDataList(Integer residentId);

}
