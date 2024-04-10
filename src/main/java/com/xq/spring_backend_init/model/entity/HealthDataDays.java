package com.xq.spring_backend_init.model.entity;


import lombok.Data;
import java.sql.Date;

import java.io.Serializable;

@Data
public class HealthDataDays implements Serializable {

    private Integer id;

    private Integer residentId;

    private Double avgHeartRate;

    private Double avgOxygenLevel;

    private Double avgBodyTemperature;

    private Date time;

}
