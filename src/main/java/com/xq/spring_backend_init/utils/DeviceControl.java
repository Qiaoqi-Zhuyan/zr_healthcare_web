package com.xq.spring_backend_init.utils;

public class DeviceControl {

    /**
     * 设备管理器
     */
    private static class DeviceControlHolder{
        private static DeviceMap devices = new DeviceMap();
    }

    /**
     * 获取设备
     * @return
     */
    public static DeviceMap getInstance(){
        return DeviceControlHolder.devices;
    }


}
