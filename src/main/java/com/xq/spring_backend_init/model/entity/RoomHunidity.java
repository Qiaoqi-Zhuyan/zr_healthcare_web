package com.xq.spring_backend_init.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomHunidity {
    private Double roomHumidity;
    private Integer id;
    private String roomNumber;
    private Date time;
}
