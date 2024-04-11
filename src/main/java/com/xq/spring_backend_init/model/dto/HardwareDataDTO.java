package com.xq.spring_backend_init.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HardwareDataDTO {
    int id;
    private HealthDTO data;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class HealthDTO {
        String temp;
        String humi;
    }

}
