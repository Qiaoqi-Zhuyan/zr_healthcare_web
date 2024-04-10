package com.xq.spring_backend_init.model.vo;

import com.xq.spring_backend_init.model.entity.HealthDataSeconds;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class HealthDataVO {
    /**
     * 返回平均的 spo2 heartbeat
     */

    private Double heartRate;

    private Double oxygenLevel;

    private Date time;

}
