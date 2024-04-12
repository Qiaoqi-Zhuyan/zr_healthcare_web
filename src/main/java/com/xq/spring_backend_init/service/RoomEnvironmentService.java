package com.xq.spring_backend_init.service;

import com.xq.spring_backend_init.model.vo.RoomEnvironmentInfoVO;

public interface RoomEnvironmentService {

    /**
     * 获得房间最新的温湿度信息
     * @param staff_id
     * @return
     */
    public RoomEnvironmentInfoVO getLeastInfo(Integer staff_id);

}
