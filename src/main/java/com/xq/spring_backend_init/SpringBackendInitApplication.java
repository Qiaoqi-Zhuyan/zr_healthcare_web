package com.xq.spring_backend_init;

import com.xq.spring_backend_init.utils.DeviceMap;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xq.spring_backend_init.mapper")
public class SpringBackendInitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBackendInitApplication.class, args);
        DeviceMap.clearCache();
    }

}

