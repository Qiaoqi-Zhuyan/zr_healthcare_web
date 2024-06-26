package com.xq.spring_backend_init.controller;

import com.xq.spring_backend_init.common.BaseResponse;
import com.xq.spring_backend_init.common.ResultUtils;
import com.xq.spring_backend_init.constant.DeviceStatus;
import com.xq.spring_backend_init.model.entity.Residents;
import com.xq.spring_backend_init.model.vo.HealthDataVO;
import com.xq.spring_backend_init.model.vo.RoomEnvironmentInfoVO;
import com.xq.spring_backend_init.model.vo.RoomHealthDataVO;
import com.xq.spring_backend_init.model.vo.RoomResidentInfoVO;
import com.xq.spring_backend_init.mqtt.MqttSendClient;
import com.xq.spring_backend_init.service.ResidentsService;
import com.xq.spring_backend_init.service.RoomEnvironmentService;
import com.xq.spring_backend_init.service.RoomResidentService;
import com.xq.spring_backend_init.utils.DeviceMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private MqttSendClient mqttSendClient;

    /**
     * 根据staffId获取最新房间环境信息
     */
    @PostMapping("/getRoomEnvironment/{staffId}")
    public BaseResponse<RoomEnvironmentInfoVO> getRoomEnvironment(@PathVariable("staffId") Integer staffId){
        if (DeviceMap.getDeviceMapInstance().containDevice("RoomDet/A410")) {
            RoomEnvironmentInfoVO roomEnvironmentInfoVO = roomEnvironmentService.getLeastInfo(staffId);
            return ResultUtils.success(roomEnvironmentInfoVO);
        }
        else{
            RoomEnvironmentInfoVO roomEnvironmentInfoVO = new RoomEnvironmentInfoVO(200.0, 200.0);
            return ResultUtils.success(roomEnvironmentInfoVO);
        }
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



    /**
     * 空调开
     * @return
     */
    @GetMapping(value = "/SwitchAirConditionerON")
    public BaseResponse<String> SwitchAirConditionON(){
        if(DeviceMap.getDeviceMapInstance().containDevice("RoomDet/A410")) {
            mqttSendClient.publish(false, "A410/device_sub", DeviceStatus.AIR_CONDITION_ON);
            return ResultUtils.success("Air conditioner on");
        }
        else {
            return ResultUtils.error(101, "设备离线");
        }
    }

    /**
     * 关闭空调
     * @return
     */
    @GetMapping(value = "/SwitchAirConditionerOFF")
    public BaseResponse<String> SwitchAirConditionerOFF(){
        mqttSendClient.publish(false, "A410/device_sub", DeviceStatus.AIR_CONDITION_OFF);
        return ResultUtils.success("Air conditioner off");
    }

    /**
     * 更改温度
     * @param temperature
     * @return
     */
    @GetMapping(value = "/TemperatureChange/{temperature}")
    public BaseResponse<String> TemperatureChange(@PathVariable("temperature")Integer temperature){
        mqttSendClient.publish(false, "A410/device_sub", DeviceStatus.TEMPERATURE_SWITCH);
        return ResultUtils.success("Temperature Change " + temperature);
    }

    /**
     * 开启加湿器
     * @return
     */
    @GetMapping(value = "/HumidifierON")
    public BaseResponse<String> HumidifierON(){
        mqttSendClient.publish(false, "A410/device_sub", DeviceStatus.HUMIDIFIER_ON);
        return ResultUtils.success("Humidifier on");
    }

    /**
     * 关闭加湿器
     * @return
     */
    @GetMapping(value = "/HumidifierOFF")
    public BaseResponse<String> HumidifierOFF(){
        mqttSendClient.publish(false, "A410/device_sub", DeviceStatus.HUMIDIFIER_OFF);
        return ResultUtils.success("Humidifier off");
    }

}
