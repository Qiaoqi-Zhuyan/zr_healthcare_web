package com.xq.spring_backend_init.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionAlertVO {
    /**
     *
     * 主页警报信息
     */
    private String firstName;

    private String lastName;

    private String roomNumber;

    private Integer residentId;

    private Timestamp exceptionStartTime;

    private String exceptionInfo;

    private Timestamp exceptionEndTime;

    private Boolean isCurrent;
}
