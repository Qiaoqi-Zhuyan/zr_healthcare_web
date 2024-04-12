package com.xq.spring_backend_init.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomEnvironmentInfoVO {

    /**
     * 房间环境温湿度
     *
     */
    private Double temperature;

    private Double humidity;


}
