package com.xq.spring_backend_init.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class TemperatureVO {

    /**
     * 返回每日平均体温
     */
    private Double bodyTemperature;

    private String time;

}
