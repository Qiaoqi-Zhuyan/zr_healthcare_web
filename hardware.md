# HI3861硬件端数据文档

## 房间环境检测开发板 - zr_env_det
用于检测房间中的气温、湿度数据, 并反馈给后端分别存入数据库的`room_temperature`和`room_hunidity`中。

接受后端传回的控制指令, 控制房间里的空调开关, 温度调节和加湿器的开关, 在led板上进行模拟显示控制结果。

### 联网:
在`zr_env_det_ver2`项目中`config.h`文件中修改配置

`SSID`: 连接wifi的名称
`PASSWORD`: wifi密码
`HOST_ADDR`: emqx服务器地址
`ROOM_ID`: 设备对应的房间号(例: "A410")
`BORAD_ID`: 设备id

### 数据收发格式:
#### 1. 开发板发送房间温湿度数据

设备ID: `RoomDet/{ROOM_ID}`

发送主题: `{ROOM_ID}/env_pub`

JSON格式:

```json
{
  "id": 43,
  "room": "A410",
  "data":
      {
        "temp": 26.27,
        "humi": 65.81
      }
}
```

后端处理id号为0x2B (43) 的数据, 为处理房间温湿度的数据。

id (uint8_t) : 处理房间温湿度数据开发板的id号为0x2B。

room (string) : 检测的房间号。

temp (float) : 房间里检测到的温度, 小数点后两位。

humi (float) : 房间里检测到的湿度, 小数点后两位。



#### 2. 开发板接受后端控制指令
订阅主题: `{ROOM_ID}device_sub`

后端发送指令, int32类型

```json
100: 空调开启, led亮红灯
101: 空调关闭, led红灯关闭
200: 温度调节, led绿灯闪烁
300: 加湿器开启, led黄灯亮起
301: 加湿器关闭, led黄灯关闭
```

## 手环健康检测开发板 - zr_intel_brec
用于检测病房中老人年的健康数据, 每个老人单独一个 

用于检测病房中老人的心率、血氧, 并在oled屏幕上显示老人信息的二维码

### 联网:
在`zr_intel_brec_ver2`项目中`config.h`文件中修改配置

`SSID`: 连接wifi的名称

`PASSWORD`: wifi密码

`HOST_ADDR`: emqx服务器地址

`DEVICE_ID`: 设备号id (例如: 0x01)

### 数据收发格式:

客户端id: `intel_brec_dev/{DEVICE_ID}`

#### 1. 体温信息发送

发布主题: `brec_pub/{DEVICE_ID}`

JSON 格式:

```json
{
  "id": 4,
  "device_id": 1,
  "data":
    {
      "temperature": 37
    }
}
```

id (uint8_t) : 后端处理 id为4的数据, id为5的为处理身体血氧和心率的数据

device_id (int) : 开发板的id

temperature (int) : 体温数据

#### 2. 血氧心率信息发送

发布主题: `brec_pub/{DEVICE_ID}`

JSON 格式:

```json
{
  "id": 5,
  "device_id": 1,
  "data":
    {
      "spo2": 97.27,
      "heart": 87
    }
}
```

id (uint8_t) : 后端处理 id为5的数据, id为5的为处理身体血氧和心率的数据

device_id (int) : 开发板的id

spo2 (float) : 血氧数据, 小数点后两位

heart (int) : 心率数据