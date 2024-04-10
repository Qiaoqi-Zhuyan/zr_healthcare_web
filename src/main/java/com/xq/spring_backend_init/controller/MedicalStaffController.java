package com.xq.spring_backend_init.controller;

import com.xq.spring_backend_init.common.BaseResponse;
import com.xq.spring_backend_init.common.ErrorCode;
import com.xq.spring_backend_init.common.ResultUtils;
import com.xq.spring_backend_init.model.dto.MedicalStaffLoginRequest;
import com.xq.spring_backend_init.model.vo.ExceptionAlert1VO;
import com.xq.spring_backend_init.model.vo.ExceptionAlertVO;
import com.xq.spring_backend_init.model.vo.MedicalStaffVO;
import com.xq.spring_backend_init.service.MedicalStaffLoginService;
import com.xq.spring_backend_init.service.ResidentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/MedicalStaff")
public class MedicalStaffController {
    @Autowired
    MedicalStaffLoginService medicalStaffLoginService;
    @Autowired
    ResidentsService residentsService;


    /**
     * 网页staff登录接口
     * @param medicalStaffLoginRequest
     * @return
     */
    @PostMapping("/login")
    public BaseResponse<MedicalStaffVO> login(@RequestBody MedicalStaffLoginRequest medicalStaffLoginRequest){
        MedicalStaffVO medicalStaffVO = medicalStaffLoginService.login(medicalStaffLoginRequest.getUserName(), medicalStaffLoginRequest.getPassword());
        if(medicalStaffVO!=null){
            return ResultUtils.success(medicalStaffVO);
        }else return ResultUtils.error(ErrorCode.USER_NOTFOUND);
    }

    /**
     * 获取所有历史异常信息
     * @param staffId
     * @return
     */
    @GetMapping("/exception/{id}")
    public BaseResponse<List<ExceptionAlert1VO>> getAllSigns(@PathVariable("id") int staffId){
        List<ExceptionAlert1VO> list = residentsService.getAllExceptions(staffId);
        return ResultUtils.success(list);
    }
}
