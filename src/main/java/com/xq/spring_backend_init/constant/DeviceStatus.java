package com.xq.spring_backend_init.constant;

public class DeviceStatus {

    /**
     * 空调: (红灯)
     *      100(int): 开 , 101(int): 关
     * 调节温度 (绿灯闪烁)
     *      200(int)
     * 加湿器 (黄灯)
     *      300(int): 开, 301(int): 关
     */

    public final static String AIR_CONDITION_ON = "100";

    public final static String AIR_CONDITION_OFF = "101";

    public final static String TEMPERATURE_SWITCH = "200";

    public final static String HUMIDIFIER_ON = "300";

    public final static String HUMIDIFIER_OFF = "301";

}
