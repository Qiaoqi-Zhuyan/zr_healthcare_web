package com.xq.spring_backend_init.mqtt;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONException;
import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.xq.spring_backend_init.mapper.RoomEnvironmentMapper;
import com.xq.spring_backend_init.model.dto.HardwareDataDTO;
import com.xq.spring_backend_init.utils.DeviceControl;
import com.xq.spring_backend_init.utils.DeviceMap;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.text.SimpleDateFormat;

import static jdk.internal.org.objectweb.asm.Type.getType;

@Slf4j
@Component
public class MqttAcceptCallBack implements MqttCallbackExtended {

    @Autowired
    private MqttAcceptClient mqttAcceptClient;

    @Autowired
    private RoomEnvironmentMapper roomEnvironmentMapper;

    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
    * 连接emqx 服务器后触发
    *
    * @param b
    * @param s
    */
   @Override
   public void connectComplete(boolean b, String s) {
       System.out.println("s: " + s);
       log.info("[mqtt consumer] connected");
       String[] topics = {
               "A410/env_pub",
               "env_pub2",
               "$SYS/brokers/+/clients/#"
       };
       int[] qos = {
               0, 0, 0
       };
       MqttClient mqttClient = mqttAcceptClient.getMqttClinet();
       try {
           mqttClient.subscribe(topics, qos);
       } catch (MqttException e) {
           throw new RuntimeException(e);
       }
//       mqttAcceptClient.subscribe("env_pub",0);

   }

   /**
    * 客户端断开后触发
    * @param throwable
    */
   @Override
   public void connectionLost(Throwable throwable) {
       log.info("[mqtt-consumer] connect lost, reconnect");
       if (MqttAcceptClient.getMqttClient() == null || !MqttAcceptClient.getMqttClient().isConnected()){
           log.info("[mqtt-consumer]: mqtt reconnect");
            mqttAcceptClient.reconnection();
        }
    }

/*# topic: "/env_pub" 环境信息
    {
        "id": "0x1A",
            "data": {
        "temp": ""
        }
    }

    {
        "id": "0x2B",
            "data": {
        "temp": "",
        "humi": "",
        }
    }


    {
        "id": "0x3A",
            "data": {
        "humi": ""
        }
    }*/
    /**
     * 客户端收到信息触发
     * @param topic
     * @param mqttMessage
     * @throws Exception
     */

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        String message = new String(mqttMessage.getPayload());
        try{
            JSONObject jsonObject = JSON.parseObject(message);
            // 设备下线
            if (topic.endsWith("disconnect")){
                String clientId = jsonObject.getString("clientid");
                if (DeviceMap.getDeviceMapInstance().containDevice(clientId)){
                    DeviceMap.getDeviceMapInstance().removeDevice(clientId);
                }
            }
            // 设备上线
            if (topic.endsWith("connect")){
                String clientId = jsonObject.getString("clientid");
                if (clientId.contains("RoomDet")){
                    if (!DeviceMap.getDeviceMapInstance().containDevice(clientId)){
                    DeviceMap.getDeviceMapInstance().addDevice(clientId, 200);
                    }
                }
            }

            if (topic.equals("A410/env_pub")){
                String roomNumber = jsonObject.getString("room");
                String clientid = "RoomDet/" + roomNumber;
                if(!DeviceMap.getDeviceMapInstance().containDevice(clientid)){
                    DeviceMap.getDeviceMapInstance().addDevice(clientid, 200);
                }else{
                    insertRoomData(jsonObject, roomNumber);
                }
            }
        }catch (JSONException e){
            log.error("Json error", e);
        }


//        HardwareDataDTO hardwareDataDTO = objectMapper.readValue(message, HardwareDataDTO.class);
//        switch (hardwareDataDTO.getId()){
////            case 26:
////                double temperature = Double.parseDouble(hardwareDataDTO.getData().getTemp());
////                System.out.println(temperature);
////                roomEnvironmentMapper.insertTemperature(temperature);
////                break;
//            case 43:
//                System.out.println(hardwareDataDTO);
//                double temperature = Double.parseDouble(hardwareDataDTO.getData().getTemp());
//                double humidity = Double.parseDouble(hardwareDataDTO.getData().getHumi());
////                System.out.println(hardwareDataDTO);
//
//                roomEnvironmentMapper.insertHumidity(humidity, hardwareDataDTO.getRoom());
//                roomEnvironmentMapper.insertTemperature(temperature, hardwareDataDTO.getRoom());
//                break;
//
//            default:
//                break;
//        }
    }

    private void insertRoomData(JSONObject jsonObject, String roomNumber) {
        Integer id = jsonObject.getInteger("id");
        HardwareDataDTO data = jsonObject.getObject("data", HardwareDataDTO.class);
        if(id == 43){
            double temperature = data.getTemp();
            double humidity = data.getHumi();
            roomEnvironmentMapper.insertHumidity(humidity, roomNumber);
            roomEnvironmentMapper.insertTemperature(temperature, roomNumber);
            System.out.println(jsonObject);
        }
    }

    /**
     * 发布消息成功
     *
     * @param iMqttDeliveryToken
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        String[] topics = iMqttDeliveryToken.getTopics();
        for (String topic : topics){
            log.info("mqtt-consumer: " + topic + "send messgage succeed");
        }try{
            MqttMessage message = iMqttDeliveryToken.getMessage();
            byte[] payload = message.getPayload();
            String s = new String(payload, StandardCharsets.UTF_8);
            log.info("mqtt-consumer message: " + s);
        }catch (MqttException ex){
            ex.printStackTrace();
        }
    }
}
