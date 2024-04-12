package com.xq.spring_backend_init.controller;

import com.xq.spring_backend_init.common.BaseResponse;
import com.xq.spring_backend_init.service.RoomEnvironmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/RoomData")
public class RoomController {

    @Autowired
    private RoomEnvironmentService roomEnvironmentService;

    /**
     * 根据staffId获取房间环境信息
     */
    @GetMapping("/getRoomEnvironment/{id}")
    public void getRoomEnvironment(@PathVariable("id") Integer id){
        roomEnvironmentService.getEnvironment(id);
    }


}
