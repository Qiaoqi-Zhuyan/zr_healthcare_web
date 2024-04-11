package com.xq.spring_backend_init.model.vo;

import com.xq.spring_backend_init.model.entity.HealthDataSeconds;
import com.xq.spring_backend_init.model.entity.Residents;
import com.xq.spring_backend_init.model.entity.TemperatureSeconds;
import lombok.Data;

import java.util.Date;

/**
 * 老登详细信息视图
 */
@Data
public class ResidentDetailVO {

    private Integer residentId;

    private String firstName;

    private String lastName;

    private String gender;

    private String dateOfBirth;

    private String phone;

    /**
     * 查询FamilyMemeberMobile中的关系
     */
    private String relationship;

    private String emergencyContactPhone;

    private String roomNumber;

    /**
     *  过往病史
     */
    private String notes;

    private String habit;

}
