package com.xq.spring_backend_init.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 护工登录返回
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalStaffVO {

    private Integer id;

    private String staffName;

    private String userName;

    private String password;

    private String phone;

    private String level;

}
