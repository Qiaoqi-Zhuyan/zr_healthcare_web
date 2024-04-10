package com.xq.spring_backend_init.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResidentQueryRequest {

    private Integer residentId;

    private String firstName;

    private String lastName;

}
