package com.xq.spring_backend_init.mapper;

import com.xq.spring_backend_init.model.entity.MedicalStaff;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MedicalStaffMapper {

    /**
     * 查询
     * @param userName
     * @param password
     * @return
     */
    public MedicalStaff selectMedicalStaff(String userName, String password);

}
