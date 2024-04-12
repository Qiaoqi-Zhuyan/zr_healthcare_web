package com.xq.spring_backend_init.model.vo;

import lombok.Data;

@Data
public class RoomResidentSInfoVO {

    private Integer residentId;

    private String firstName;

    private String lastName;

    private Double heartRate;

    private Double oxygenLevel;

    private Double bodyTemperature;

}
