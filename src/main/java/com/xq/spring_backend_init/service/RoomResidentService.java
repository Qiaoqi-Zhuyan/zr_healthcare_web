package com.xq.spring_backend_init.service;

import com.xq.spring_backend_init.model.vo.RoomHealthDataVO;

public interface RoomResidentService {

    /**
     * 获取最新的房间里老年人的信息
     * @param residentId
     * @return
     */
    public RoomHealthDataVO getLeastResidentHealthData(Integer residentId);

}
