package com.xq.spring_backend_init.model.vo;

import lombok.Data;

import java.sql.Date;

@Data
public class TemperatureVO {

    /**
     * 返回每日平均体温
     */
    private Double bodyTemperature;

    private Date time;

}
