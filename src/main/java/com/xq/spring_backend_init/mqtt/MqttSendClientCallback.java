package com.xq.spring_backend_init.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class MqttSendClientCallback implements MqttCallbackExtended {

    private static final Logger logger = LoggerFactory.getLogger(MqttSendClientCallback.class);


    /**
     * 连接服务器后触发
     * @param b
     * @param s
     */
    @Override
    public void connectComplete(boolean b, String s) {
        logger.info("[mqttSendClient]: "+" connect to Service complete");
    }


    /**
     * 服务器断开后触发
     * @param throwable
     */
    @Override
    public void connectionLost(Throwable throwable) {
        logger.info("[mqttSendClient]: connection lost, reconnect...");
    }

    /**
     * 客户都收到消息后触发
     * @param topic
     * @param mqttMessage
     * @throws Exception
     */
    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        String message = new String(mqttMessage.getPayload());
    }


    /**
     * 客户都发布消息成功
     * @param iMqttDeliveryToken
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        String[] topics = iMqttDeliveryToken.getTopics();
        for(String topic : topics){
            logger.info("[mqttSendClient]: " + "send Topic \"" + topic + "\"" + " message");
        }
        try{
            MqttMessage message = iMqttDeliveryToken.getMessage();
            byte[] payload = message.getPayload();
            String s = new String(payload, StandardCharsets.UTF_8);
            logger.info("[mqttSendClient]: " + "send message: " + s);
        }catch (MqttException e){
            e.printStackTrace();
        }
    }
}
