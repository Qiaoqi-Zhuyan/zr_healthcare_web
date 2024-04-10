package com.xq.spring_backend_init.model.dto.residents;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResidentQueryRequest {

    private Integer residentId;

    private String nationalId;

    private String firstName;

    private String lastName;

    private Integer age;

}
