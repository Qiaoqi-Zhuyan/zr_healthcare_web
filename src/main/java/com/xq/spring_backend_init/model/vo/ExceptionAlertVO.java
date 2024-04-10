package com.xq.spring_backend_init.model.vo;

import lombok.Data;

import java.sql.Date;

@Data
public class ExceptionAlertVO {

    /**
     *
     * 主页警报信息
     */
    private String firstName;

    private String lastName;

    private String roomNumber;

    private Integer residentId;

    private Date exceptionStartTime;

    private String exceptionInfo;

    private Date exceptionEndTime;

    private Boolean isCurrent;



}
