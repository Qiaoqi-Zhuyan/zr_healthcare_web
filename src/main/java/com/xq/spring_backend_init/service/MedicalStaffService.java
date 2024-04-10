package com.xq.spring_backend_init.service;

import com.xq.spring_backend_init.model.dto.MedicalStaffLoginRequest;
import com.xq.spring_backend_init.model.vo.MedicalStaffVO;

public interface MedicalStaffService {

    /**
     * 获取医护人员信息
     * @param request
     * @return
     */
    public MedicalStaffVO getMedicalInfo(MedicalStaffLoginRequest request);


}
