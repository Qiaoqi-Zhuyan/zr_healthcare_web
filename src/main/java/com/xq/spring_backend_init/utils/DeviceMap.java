package com.xq.spring_backend_init.utils;

import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import com.alibaba.fastjson2.JSON;
import lombok.Data;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class DeviceMap {

    private static volatile Map<String, Integer> deviceHashMap = new ConcurrentHashMap<>();

    private static class DeviceMapHolder{
        private static DeviceMap deviceMap = new DeviceMap();

    }

    /**
     * 添加设备 (上线)
     * @param Key
     * @param status
     */
    public  void addDevice(String Key, Integer status) {
        deviceHashMap.put(Key ,status);
    }

    /**
     * 获取设备
     * @param key
     * @return
     */
    public  Integer getDevice(String key){
        return deviceHashMap.get(key);
    }

    /**
     * 删除设备 设备下线
     * @param key
     */
    public void removeDevice(String key){
        deviceHashMap.remove(key);
    }

    public boolean containDevice(String key){
        return deviceHashMap.containsKey(key);
    }

    public static final DeviceMap getDeviceMapInstance(){
        return DeviceMapHolder.deviceMap;
    }

    public static void clearCache(){
        CronUtil.schedule("*/30 * * * * *", new Task() {
            @Override
            public void execute() {
                deviceHashMap.clear();
            }
        });

        CronUtil.setMatchSecond(true);
        CronUtil.start();
    }

}
