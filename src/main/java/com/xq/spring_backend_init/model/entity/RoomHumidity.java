package com.xq.spring_backend_init.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomHumidity {
    Double roomHumidity;
    Integer id;
    Integer residentId;
    Date time;
}
