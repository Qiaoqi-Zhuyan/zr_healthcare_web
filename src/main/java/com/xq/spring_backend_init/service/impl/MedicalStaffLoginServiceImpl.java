package com.xq.spring_backend_init.service.impl;

import com.xq.spring_backend_init.mapper.MedicalStaffMapper;
import com.xq.spring_backend_init.model.entity.MedicalStaff;
import com.xq.spring_backend_init.model.vo.MedicalStaffVO;
import com.xq.spring_backend_init.service.MedicalStaffLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MedicalStaffLoginServiceImpl implements MedicalStaffLoginService {

    @Autowired
    MedicalStaffMapper medicalStaffMapper;

    @Override
    public MedicalStaffVO login(String userName, String password) {
        MedicalStaff medicalStaff = null;
        medicalStaff = medicalStaffMapper.selectMedicalStaff(userName, password);

        return medicalStaff != null?
                new MedicalStaffVO(medicalStaff.getId(), medicalStaff.getStaffName(), medicalStaff.getUserName(), medicalStaff.getPassword(), medicalStaff.getPhone(), medicalStaff.getPhone())
                :null;

    }
}
