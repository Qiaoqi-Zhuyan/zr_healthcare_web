package com.xq.spring_backend_init.controller;

import com.xq.spring_backend_init.common.BaseResponse;
import com.xq.spring_backend_init.common.ResultUtils;
import com.xq.spring_backend_init.model.entity.Residents;
import com.xq.spring_backend_init.model.vo.HealthDataVO;
import com.xq.spring_backend_init.model.vo.RoomEnvironmentInfoVO;
import com.xq.spring_backend_init.model.vo.RoomHealthDataVO;
import com.xq.spring_backend_init.model.vo.RoomResidentInfoVO;
import com.xq.spring_backend_init.service.ResidentsService;
import com.xq.spring_backend_init.service.RoomEnvironmentService;
import com.xq.spring_backend_init.service.RoomResidentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/RoomData")
public class RoomController {

    @Autowired
    private RoomEnvironmentService roomEnvironmentService;

    @Autowired
    private ResidentsService residentsService;

    @Autowired
    private RoomResidentService roomResidentService;

    /**
     * 根据staffId获取最新房间环境信息
     */
    @PostMapping("/getRoomEnvironment/{staffId}")
    public BaseResponse<RoomEnvironmentInfoVO> getRoomEnvironment(@PathVariable("staffId") Integer staffId){
        RoomEnvironmentInfoVO roomEnvironmentInfoVO = roomEnvironmentService.getLeastInfo(staffId);
        return ResultUtils.success(roomEnvironmentInfoVO);
    }

    /**
     * 通过护工id获取房间里所有老年人的id, 姓名
     * @param staffId
     * @return
     */
    @PostMapping("/getRoomResidentInfo/{staffId}")
    public BaseResponse<List<RoomResidentInfoVO>> getRoomResidentInfo(@PathVariable("staffId")Integer staffId){
        Residents residentsWrapper = new Residents();
        residentsWrapper.setStaffId(staffId);
        List<Residents> residentsList = residentsService.selectAllResidents(residentsWrapper);
        List<RoomResidentInfoVO> residentInfoVOS = new ArrayList<>();
        for(Residents resident : residentsList){
            RoomResidentInfoVO residentInfoVO = new RoomResidentInfoVO();
            BeanUtils.copyProperties(resident, residentInfoVO);
            residentInfoVOS.add(residentInfoVO);
        }
        return ResultUtils.success(residentInfoVOS);
    }

    /**
     * 通过老年人的id获取最新的身体数据
     *
     */
    @PostMapping("/getResidentHealthData/{residentId}")
    public BaseResponse<RoomHealthDataVO> getLeastRoomResidentHealthData(@PathVariable("residentId")Integer residentId){
        RoomHealthDataVO roomHealthDataVO = roomResidentService.getLeastResidentHealthData(residentId);
        return ResultUtils.success(roomHealthDataVO);
    }



}
