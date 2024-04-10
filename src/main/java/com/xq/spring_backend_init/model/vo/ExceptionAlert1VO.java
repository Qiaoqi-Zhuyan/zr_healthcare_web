package com.xq.spring_backend_init.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionAlert1VO {
    /**
     *
     * 主页警报信息
     */
    private String firstName;

    private String lastName;

    private String roomNumber;

    private Integer residentId;

    private String exceptionStartTime;

    private String exceptionInfo;

    private String exceptionEndTime;

    private Boolean isCurrent;
}
