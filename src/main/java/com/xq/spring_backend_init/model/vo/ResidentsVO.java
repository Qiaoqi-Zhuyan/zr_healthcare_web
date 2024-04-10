package com.xq.spring_backend_init.model.vo;


import lombok.Data;

@Data
public class ResidentsVO {
    private Integer residentId;

    private String nationalId;

    private String firstName;

    private String lastName;

    private Integer age;
}
