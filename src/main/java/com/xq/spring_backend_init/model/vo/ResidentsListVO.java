package com.xq.spring_backend_init.model.vo;

import com.xq.spring_backend_init.model.entity.MedicalStaff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentsListVO {

    private String firstName;

    private String lastName;

    private ResidentMedicalStaffVO residentMedicalStaffVO;

    private String roomNumber;


}
