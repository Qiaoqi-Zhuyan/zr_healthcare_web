package com.xq.spring_backend_init.mapper;

import com.xq.spring_backend_init.model.entity.RoomHumidity;
import com.xq.spring_backend_init.model.entity.RoomTemperature;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoomEnvironmentMapper {
    @Insert("INSERT into room_temperature (room_temperature,resident_id,time) values (#{temperature},2,CURRENT_TIME)")
    void insertTemperature(double temperature);

    @Insert("INSERT into room_humidity (humidity,resident_id,time) values (#{humidity},2,CURRENT_TIME)")
    void insertHumidity(double humidity);

    @Select("select room_temperature from room_temperature where ")
    RoomTemperature getRoomTemperatureById(Integer id);

    @Select("select room_humidity from room_hunidity where ")
    RoomHumidity getRoomHumiById(Integer id);

    @Select("")
    void getResidentInfoById(Integer id);
}
