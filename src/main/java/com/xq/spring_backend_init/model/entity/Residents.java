package com.xq.spring_backend_init.model.entity;


import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class Residents implements Serializable {
    private Integer residentId;

    private String nationalId;

    private String firstName;

    private String lastName;

    private String gender;

    private Date dataOfBirth;

    private String phone;

    private String emergencyContactName;

    private String emergencyContactPhone;

    private String roomNumber;

    private Date admissionDate;

    private String notes;

    private Integer staffId;



}
