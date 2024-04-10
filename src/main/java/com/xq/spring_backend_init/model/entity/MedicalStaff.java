package com.xq.spring_backend_init.model.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class MedicalStaff implements Serializable {

    private Integer id;

    private String staffName;

    private String userName;

    private String password;

    private String phone;

    private String level;


}
