package com.xq.spring_backend_init.model.entity;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class HealthDataSeconds implements Serializable {

    private Integer id;

    private Integer residentId;

    private Double heartRate;

    private Double oxygenLevel;

    private Double bodyTemperature;

    private Date time;

}
