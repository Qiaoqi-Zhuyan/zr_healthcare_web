package com.xq.spring_backend_init.service;

import com.xq.spring_backend_init.common.BaseResponse;
import com.xq.spring_backend_init.mapper.MedicalStaffMapper;
import com.xq.spring_backend_init.model.vo.MedicalStaffVO;
import org.springframework.beans.factory.annotation.Autowired;

public interface MedicalStaffLoginService {
    MedicalStaffVO login(String userName,String password);
}
