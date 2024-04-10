package com.xq.spring_backend_init.model.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class TemperatureSeconds implements Serializable {

    private Integer id;

    private Integer residentId;

    private Double bodyTemperature;

    private Date time;


}
