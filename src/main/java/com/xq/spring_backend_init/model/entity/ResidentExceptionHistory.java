package com.xq.spring_backend_init.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class ResidentExceptionHistory implements Serializable {
    private Integer id;

    private Integer residentId;

    private Date exceptionStartTime;

    private String exceptionInfo;

    private Date exceptionEndTime;


}
