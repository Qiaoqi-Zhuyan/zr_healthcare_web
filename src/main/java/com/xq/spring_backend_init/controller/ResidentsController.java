package com.xq.spring_backend_init.controller;


import cn.hutool.http.server.HttpServerRequest;
import com.xq.spring_backend_init.common.BaseResponse;
import com.xq.spring_backend_init.common.ResultUtils;
import com.xq.spring_backend_init.model.dto.residents.ResidentQueryRequest;
import com.xq.spring_backend_init.model.entity.Residents;
import com.xq.spring_backend_init.service.ResidentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/Resident")
public class ResidentsController {
    @Autowired
    private ResidentsService residentsService;


    @PostMapping("/getResidentList")
    public BaseResponse<Residents> listResident(@RequestBody ResidentQueryRequest residentQueryRequest,
                                                HttpServerRequest request){
        return null;
    }

    @PostMapping("/getAllResidentList")
    public BaseResponse<List<Residents>> getAllResidentList(){
        List<Residents> residentsList = residentsService.selectAllResidents(null);
        return ResultUtils.success(residentsList);
    }



}
