package com.xq.spring_backend_init.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomTemperature {
    Double roomTemperature;
    Integer id;
    Integer residentId;
    Date time;
}
