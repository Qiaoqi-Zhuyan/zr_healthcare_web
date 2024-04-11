package com.xq.spring_backend_init.controller;

import com.alibaba.excel.util.IntUtils;
import com.xq.spring_backend_init.common.BaseResponse;
import com.xq.spring_backend_init.common.ErrorCode;
import com.xq.spring_backend_init.common.ResultUtils;
import com.xq.spring_backend_init.mapper.HealthDataSecondsMapper;
import com.xq.spring_backend_init.model.dto.MedicalStaffLoginRequest;
import com.xq.spring_backend_init.model.entity.Residents;
import com.xq.spring_backend_init.model.vo.HealthDataVO;
import com.xq.spring_backend_init.model.vo.MedicalStaffVO;
import com.xq.spring_backend_init.model.vo.ResidentDetailVO;
import com.xq.spring_backend_init.model.vo.ResidentsVO;
import com.xq.spring_backend_init.service.HealthDataService;
import com.xq.spring_backend_init.service.ResidentsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/HealthData")
public class HealthDataController {

    @Autowired
   private HealthDataService healthDataService;
//    /**
//     * 测试
//     * @return
//     */
//    @PostMapping("/test")
//    public BaseResponse<List<ResidentDetailVO>> login(){
//        List<Residents> residentsList = residentsService.selectAllResidents(null);
//        List<ResidentDetailVO> residentsVOList = new ArrayList<>();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        for(Residents resident : residentsList){
//            ResidentDetailVO residentsVO = new ResidentDetailVO();
//            BeanUtils.copyProperties(resident, residentsVO);
//            residentsVO.setDateOfBirth(formatter.format(resident.getDateOfBirth()));
//            residentsVOList.add(residentsVO);
//        }
//        return ResultUtils.success(residentsVOList);
//    }


    /**
     * 根据老年人的id获取近15天的身体数据 (血氧, 心率)
     *
     * @return
     */
    @PostMapping("/getHealthDataList/{id}")
    public BaseResponse<List<HealthDataVO>> getHealthDataList(@PathVariable("id")Integer residentId){
        List<HealthDataVO> healthDataVOList = healthDataService.getHealthDataVOList(residentId);
        return healthDataVOList.isEmpty() ? ResultUtils.error(202, "无数据"): ResultUtils.success(healthDataVOList);
    }

}
