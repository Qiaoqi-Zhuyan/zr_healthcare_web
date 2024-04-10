package com.xq.spring_backend_init.controller;

import com.xq.spring_backend_init.common.BaseResponse;
import com.xq.spring_backend_init.common.ErrorCode;
import com.xq.spring_backend_init.common.ResultUtils;
import com.xq.spring_backend_init.model.dto.MedicalStaffLoginRequest;
import com.xq.spring_backend_init.model.vo.MedicalStaffVO;
import com.xq.spring_backend_init.service.MedicalStaffLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MedicalStaff")
public class MedicalStaffController {
    @Autowired
    MedicalStaffLoginService medicalStaffLoginService;

    @PostMapping("/login")
    public BaseResponse<MedicalStaffVO> login(@RequestBody MedicalStaffLoginRequest medicalStaffLoginRequest){
        MedicalStaffVO medicalStaffVO = medicalStaffLoginService.login(medicalStaffLoginRequest.getUserName(), medicalStaffLoginRequest.getPassword());
        if(medicalStaffVO!=null){
            return ResultUtils.success(medicalStaffVO);
        }else return ResultUtils.error(ErrorCode.USER_NOTFOUND);
    }
}
