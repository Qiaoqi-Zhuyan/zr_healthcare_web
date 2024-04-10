package com.xq.spring_backend_init.model.entity;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class HealthDataHours implements Serializable {

    private Integer id;

    private Integer residentId;

    private Double avgHeartRate;

    private Double avgOxygenLevel;

    private Double avgBodyTemperature;

    private Date time;


}
