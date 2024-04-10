package com.xq.spring_backend_init.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class RoomInfoVO {

    /**
     *
     * 单独房间的信息
     *
     */
    private Integer temperature;

    private Integer humidity;

    private List<RoomResidentSInfoVO> roomResidentSInfoVOList;


}
