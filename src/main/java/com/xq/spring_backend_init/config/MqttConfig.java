package com.xq.spring_backend_init.config;

import com.xq.spring_backend_init.mqtt.MqttAcceptClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfig {
    @Autowired
    private MqttAcceptClient mqttAcceptClient;

    @Conditional(MqttCondition.class)
    @Bean
    public MqttAcceptClient getMqttAcceptClient(){
        mqttAcceptClient.connect();
//        mqttAcceptClient.subscribe("env_pub", 10);
        return mqttAcceptClient;
    }

}

