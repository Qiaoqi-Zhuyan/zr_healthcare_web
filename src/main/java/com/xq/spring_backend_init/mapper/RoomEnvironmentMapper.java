package com.xq.spring_backend_init.mapper;

import com.xq.spring_backend_init.model.entity.RoomHunidity;
import com.xq.spring_backend_init.model.entity.RoomTemperature;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoomEnvironmentMapper {
    @Insert("INSERT into room_temperature (room_temperature,room_number,time) values (#{temperature}, #{room},CURRENT_TIME)")
    void insertTemperature(Double temperature, String room);

    @Insert("INSERT into room_hunidity (room_humidity,room_number,time) values (#{humidity}, #{room},CURRENT_TIME)")
    void insertHumidity(Double humidity, String room);

    @Select("select room_temperature from room_temperature where ")
    RoomTemperature getRoomTemperatureById(Integer id);

    @Select("select room_humidity from room_hunidity where ")
    RoomHunidity getRoomHumiById(Integer id);

    @Select("")
    void getResidentInfoById(Integer id);


    /**
     * 根据房间号实时更新湿度信息
     * @param RoomNumber
     * @return
     */
    public RoomHunidity getLeastRoomHumity(String RoomNumber);


    /**
     *
     * 根据房间号实时更新房间温度信息
     *
     */
    public RoomTemperature getLeastTemperature(String RoomNumber);

}
