package com.xq.spring_backend_init.mqtt;


import com.xq.spring_backend_init.properties.MqttProperties;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MqttSendClient {

    private static final Logger logger = LoggerFactory.getLogger(MqttSendClient.class);

    @Autowired
    private MqttSendClientCallback mqttSendClientCallback;

    @Autowired
    private MqttProperties mqttProperties;

    /**
     * 连接服务器
     * @return
     */
    public MqttClient connect(){
        MqttClient client = null;
        try{
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            // 创建客户端
            client = new MqttClient(mqttProperties.getHostUrl(), uuid, new MemoryPersistence());
            // 设置基本参数
            MqttConnectOptions options = new MqttConnectOptions();
            options.setUserName(mqttProperties.getUsername());
            options.setPassword(mqttProperties.getPassword().toCharArray());
            options.setConnectionTimeout(mqttProperties.getTimeout());
            options.setKeepAliveInterval(mqttProperties.getKeepAlive());
            options.setCleanSession(true);
            options.setAutomaticReconnect(false);

            // 设置回调
            try{
                client.setCallback(mqttSendClientCallback);
                client.connect(options);
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return client;
    }

    /**
     * 关闭连接
     * @param mqttClient
     */
    public static void disconnect(MqttClient mqttClient){
        try{
            if (mqttClient != null) mqttClient.disconnect();
        }catch (MqttException e){
            e.printStackTrace();
        }
    }

    /**
     * 释放
     * @param mqttClient
     */
    public static void close(MqttClient mqttClient){
        try{
            if (mqttClient != null) mqttClient.close();
        }catch (MqttException e){
            e.printStackTrace();
        }
    }

    /**
     * 发布消息
     * @param retained
     * @param topic
     * @param pushMessage
     */
    public void publish(boolean retained, String topic, String pushMessage){
        MqttMessage message = new MqttMessage();
        message.setQos(mqttProperties.getQos());
        message.setRetained(retained);
        message.setPayload(pushMessage.getBytes());
        MqttDeliveryToken token;
        MqttClient mqttClient = connect();
        try{
            mqttClient.publish(topic, message);
        }catch (MqttException exception){
            exception.printStackTrace();
        } finally {
            disconnect(mqttClient);
            close(mqttClient);
        }
    }


}
