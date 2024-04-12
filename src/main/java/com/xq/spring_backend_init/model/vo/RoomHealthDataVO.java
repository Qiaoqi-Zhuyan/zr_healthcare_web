package com.xq.spring_backend_init.model.vo;

import lombok.Data;

@Data
public class RoomHealthDataVO {

    /**
     *
     * 实时反馈老人身体信息
     *
     */
    private Integer temperature;

    private Double heartRate;

    private Double oxygenLevel;

    private String time;

}
