package com.xq.spring_backend_init.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalStaffLoginRequest {

    /**
     * 登录请求
     */
    private String userName;

    private String password;

    public String getUserName(){
        return this.userName;
    }
    public String getPassword() {
        return this.password;
    }

}
