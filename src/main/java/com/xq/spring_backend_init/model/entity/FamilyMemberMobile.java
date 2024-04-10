package com.xq.spring_backend_init.model.entity;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class FamilyMemberMobile implements Serializable {
    private Integer memberId;

    private Integer residentId;

    private String  userName;

    private String password;

    private String relation;

    private String phone;

    private String email;

    private Date createTime;

}
