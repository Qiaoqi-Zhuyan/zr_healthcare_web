package com.xq.spring_backend_init.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MedicalStaffLoginRequest {

    /**
     * 登录请求
     */
    private String userName;

    private String password;

}
