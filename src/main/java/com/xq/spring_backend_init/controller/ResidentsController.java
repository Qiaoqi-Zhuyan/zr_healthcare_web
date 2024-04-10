package com.xq.spring_backend_init.controller;


import com.xq.spring_backend_init.common.BaseResponse;
import com.xq.spring_backend_init.common.ResultUtils;
import com.xq.spring_backend_init.model.dto.ResidentQueryRequest;
import com.xq.spring_backend_init.model.entity.Residents;
import com.xq.spring_backend_init.model.vo.ResidentsVO;
import com.xq.spring_backend_init.service.ResidentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Resident")
public class ResidentsController {
    @Autowired
    private ResidentsService residentsService;


    @PostMapping("/getResidentInfo/")
    public BaseResponse<Residents> listResident(@RequestBody ResidentQueryRequest residentQueryRequest){
        return null;
    }

    @PostMapping("/getAll")
    public BaseResponse<List<Residents>> getAllResidentList(){
        List<Residents> residentsList = residentsService.selectAllResidents(null);
        return ResultUtils.success(residentsList);
    }

    @PostMapping("/pageSelect/{page}")
    public BaseResponse<List<ResidentsVO>> pageSelect(@PathVariable("page") Integer page){
        return null;
    }

    @PostMapping("/getDetailInfo")
    public BaseResponse<ResidentsVO> getDetailInfo(@RequestBody ResidentQueryRequest request){
        return null;
    }




}
