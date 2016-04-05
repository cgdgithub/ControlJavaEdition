package com.xinlianfeng.android.livehome.devicesctrl;

import org.json.JSONObject;

import com.xinlianfeng.android.livehome.devicesctrl.DevicesControlManager.DeviceInfo;

//import android.os.Handler;

public interface IDevicesCtrlMethod {
	/*********************************** 控制类和socket操作接口 *******************************************/
//	public boolean initDevicesSocket(String deviceId, String ip, int port, boolean ifNeedReconnect, String userName);
//	public void closeDevicesSocket(String deviceId);
//	public void startSmartBoxNetConnect();
//	public void closeSmartBoxNetConnect();
	public void initDevicesControl(String deviceId, String deviceType);
	public void delDevicesControl(String deviceId);
	public void cleanAllControl();
	
	/**
	 * 创建mqtt客户端
	 * 
	 * @param host mqtt服务端地址
	 * @param id  mqtt客户端id
	 * @param userName 连接mqtt服务端的用户名
	 * @param password 连接mqtt服务端的密码
	 * @return true表示创建成功，false表示创建失败
	 */
//	public boolean initMqttClient(String host, String id, String userName, String password);
	/**
	 * 关闭mqtt客户端
	 * 
	 * @param id mqtt客户端id
	 */
//	public void closeMqttClient(String id);
	/**
	 * mqtt客户端订阅指定的主题
	 * 
	 * @param id mqtt客户端id
	 * @param topic 主题名称
	 * @param qos 发布质量（0，1，2）
	 * @return true表示订阅成功，false表示订阅失败
	 */
//	public boolean mqttClientSubscribeTopic(String id, String topic, int qos);
	/**
	 * mqtt客户端订阅主题列表里的所有主题
	 * 
	 * @param id mqtt客户端id
	 * @param qos 发布质量（0，1，2）
	 * @return true表示订阅成功，false表示订阅失败
	 */
//	public boolean mqttClientSubscribeAll(String id, int qos);
	/**
	 * mqtt客户端取消订阅指定的主题
	 * 
	 * @param id mqtt客户端id
	 * @param topic 主题名称
	 * @return true表示取消订阅成功，false表示取消订阅失败
	 */
//	public boolean mqttClientUnsubscribeTopic(String id, String topic);
	/**
	 * mqtt客户端向指定的主题发布消息
	 * 
	 * @param id mqtt客户端id
	 * @param topic 主题名称
	 * @param qos 发布质量（0，1，2）
	 * @param message 要发布的消息
	 * @return true表示发布成功，false表示发布失败
	 */
//	public boolean mqttPulishMessage(String id, String topic, int qos, byte[] message);
	/**
	 * 指定的主题是否已经订阅
	 * 
	 * @param id mqtt客户端id
	 * @param topic 主题名称
	 * @return 返回true表示主题已经订阅，false表示没有订阅
	 */
//	public boolean isTopicSubscribed(String id, String topic);
//	public void setHandler(Handler handler);
//	public void setDevicesOnlineStatus(String deviceId, boolean isOnline);
	public void setDevicesInfo(String deviceId, DeviceInfo info);
	public DeviceInfo getDevicesInfo(String deviceId);
//	public void parseSocketData(String deviceId, byte[] result);


	/*********************************** 设备公共函数 *******************************************/
	/** 设备的socket是否连接正常 */
	public boolean isDevicesExist(String deviceId);
	/** 空调的socket是否连接正常 */
	public boolean isAirconditionExist(String deviceId);
	/** 除湿机的socket是否连接正常 */
	public boolean isDehumidifierExist(String deviceId);
	/** 空气净化器的socket是否连接正常 */
	public boolean isAircleanerExist(String deviceId);
	/** 新风机的socket是否连接正常 */
	public boolean isAirfanExist(String deviceId);
	/** 传感器的socket是否连接正常 */
	public boolean isSensorsExist(String deviceId);
	/** wifi模块的socket是否连接正常 */
//	public boolean isWifiModuleExist(String deviceId);
	/** 窗帘的socket是否连接正常 */
	public boolean isSmartcurtainExist(String deviceId);
	/** 氛围灯的socket是否连接正常 */
	public boolean isSmartlightExist(String deviceId);
	/** 电量计的socket是否连接正常 */
	public boolean isVoltameterExist(String deviceId);
	/**
	 * 通用开、关机
	 * @param power [0/1]
	 * @param soundSet [0/1]
	 * @return
	 */
	public byte[] setDevicePowerCommon(String deviceId, int power, int soundSet);
	/**
	 * 查询设备所有状态
	 * @param soundSet [0/1]
	 * @return
	 */
	public byte[] setQueryDeviceAllStatus(String deviceId, int soundSet);
	/**
	 * 获取所有状态的json字符串
	 * @return String
	 */
	public String getDeviceAllStatusString(String deviceId);
	/**
	 * 获取所有状态的json对象
	 * @return JSONObject
	 */
	public JSONObject getDeviceAllStatusJSONObject(String deviceId);
	/**
	 * 设置 状态刷新 间隔时间 单位 秒
	 * @param seconds 时间间隔秒数
	 * @return 设置成功与否
	 */
	public boolean setIntervalTimeOfStatusRefresh(String deviceId, long seconds);
	/**
	 * 查询 状态刷新 是否超时
	 * 
	 * @return true超时，false不超时
	 */
	public boolean getIntervalTimeOfStatusRefreshIsOverTime(String deviceId);
	/**
	 * 查询设备所有状态
	 * @param soundSet [0/1]
	 * @return byte[]
	 */
	public byte[] setQueryDeviceAllFunctions(String deviceId, int soundSet);
	/**
	 * 保存设备所有功能
	 * @param deviceFunctions 设备功能
	 * @return boolean
	 */
	public boolean setSaveDeviceAllFunctions(String deviceId, JSONObject deviceFunctions);
	/**
	 * 获取 设备所有功能 String
	 * @return String
	 */
	public String getDeviceAllFunctionsString(String deviceId);
	/**
	 * 获取 设备所有功能 JSONObject
	 * @return JSONObject
	 */
	public JSONObject getDeviceAllFunctionsJSONObject(String deviceId);
	/**
	 * 设备状态 保存
	 * @param key 键
	 * @param value 值
	 * @return boolean
	 */
	public boolean setDeviceStatusSave(String deviceId, String key, Object value);
	/**
	 * 获取状态 String类型
	 * @param key 键
	 * @return String
	 */
	public String getDeviceStatusString(String deviceId, String key);
	/**
	 * 获取状态 Int类型
	 * @param key 键
	 * @return int
	 */
	public int getDeviceStatusInt(String deviceId, String key);
	/**
	 * 设备功能 保存
	 * @param key 键
	 * @param value 值
	 * @return boolean
	 */
	public boolean setDeviceFunction(String deviceId, String key, Object value);

	/**
	 * 获取功能 Int类型
	 * @param key 键
	 * @return int
	 */
	public int getDeviceFunction(String deviceId, String key);
	/**
	 * 设备功能使能 保存
	 * @param key 键
	 * @param value 值
	 * @return
	 */
	public boolean setDeviceFunctionEnable(String deviceId, String key, Object value);
	/**
	 * 获取功能 Int类型
	 * @param key 键
	 * @return int
	 */
	public int getDeviceFunctionEnable(String deviceId, String key);
	/**
	 * 获取控制类版本号
	 * @return String
	 */
	public String getVersionNumberOfDevicesControl(String deviceId);
	/**
	 * 获取so库版本号
	 * @return String
	 */
	public String getVersionNumberOfSoLibrary(String deviceId);
	/**
	 * 获取4004版本号
	 * @return String
	 */
	public String getVersionNumberOf4004(String deviceId);
	/**
	 * 设置家电功能表
	 * @param functionsValueString 功能值字符串
	 */
	public void setInitDeviceFunctions(String deviceId, String functionsValueString);	
	/**
	 * 解析方法 收到的byte[] 转化成字符串
	 * @param recv 返回的byte[]
	 * @return String
	 */
	public String parseByteToJSON(String deviceId, byte[] recv);
	
	
	/*********************************** 空调 *******************************************/
	/** Box  设置功能:开关机[0/1], 模式[heat/auto/cool/dehumidify/blow],风门控制位[0/1],风量[auto/strong/middle/weak],设置温度[-64/64]，
	 * 静音[0/1],强力[0/1],LED[0/1],提示声[0/1]*/
	public byte[] setAircondition(String deviceId, int power, String mode, String windSpeed, int temperature, 
			int upDownAirDoorControl, String airDoorPosition, int isMute, int isHighEfficient, int isBackgroundLight, 
			int soundSet);

	/** 设置空调专家模式可控状态 */
	public byte[] setAirconditionSmartStatus(String deviceId, String smartStatus);

	/** 1 电源 power : 0关，1开 soundSet : 0无声音，1开声音 */
	public byte[] setAirconditionPower(String deviceId, int power, int soundSet);

	/** 1 模式 取值：”0”，”1”，”2”，”3”，”4” 说明： ”0”送风， ”1”制热， ”2”制冷， ”3”除湿， ”4”自动 */
	public byte[] setAirconditionMode(String deviceId, String mode, int soundSet);

	/** 1 温度 取值：”16”~”32” 说明：16℃~32℃ */
	public byte[] setAirconditionTemperature(String deviceId, int temperature, int soundSet);

	/** 1 温度 取值：”16”~”32” 说明：16℃~32℃ */
	public byte[] setAirconditionTemperatureExportSales(String deviceId, int temperature, int soundSet);
	
	/** 1 风速 取值：0~63 说明： ”0”自动， ”1”静音风速， ”2”低风风速， ”3”中风风速， ”4”高风风速，“5”1档风， “6” 2档风 ，其他值，越高风速越大 */
	public byte[] setAirconditionWindSpeed(String deviceId, String windSpeed, int soundSet);

	/** 水平导风板开停 取值：”0”，”1” 说明： ”0”左右风关，”1”左右风开； 设置功能:左右风门控制[0/1],左风摆[0/1],右风摆[0/1],提示声[0/1]*/
	public byte[] setAirconditionHorizontalWind(String deviceId, int horizontalWindControl, int leftWindSwing, int rightWindSwing, int soundSet);

	/** 垂直导风板开停 取值：”0”，”1” 说明： ”0”垂直风关，”1”垂直风开 */
	public byte[] setAirconditionVerticalWind(String deviceId, String airDoorPosition, int airDoorControl, int soundSet);

	/** 定时开、关设定 timingValid : 取值示例： 说明： 1 表示设置有效， 0表示设置无效 timingValue :Val=0,取消定时， val[1~20],定时val*0.5小时,val=[21~34]定时10+(val-20) 小时*/
	public byte[] setAirconditionTiming(String deviceId, int timingValid, int timingValue, int soundSet);

	/** ? 实时开机 power : 说明： 1 表示设置实时开机， 0表示取消实时开机。 h=[0~23],min=[0~59] realTimePowerOnHour : 设定范围：0~23 realTimeMinute :
	 * 设定范围：0~59, 实时时钟的小时值[0-24],实时时钟的分钟值[0-60] */
	public byte[] setAirconditionRealTimePowerOn(String deviceId, int power, int minuteValue, int soundSet);

	/** ? 实时关机 power : 说明： 1 表示设置实时开机， 0表示取消实时开机。 h=[0~23],min=[0~59] realTimePowerOnHour : 设定范围：0~23 realTimeMinute :
	 * 设定范围：0~59 */
	public byte[] setAirconditionRealTimePowerOff(String deviceId, int power, int minuteValue, int soundSet);
	
	/** 睡眠设定 取值：”0”，”1”，”2”，”3”，”4”， 说明：”0” "off"，”1” "general"，”2” "aged"，”3”"younger", "4" "child"*/
	public byte[] setAirconditionSleepMode(String deviceId, String sleepMode, int soundSet);

	/** 节能 取值：”0”，”1” 说明：”0”节能关，”1”节能开 */
	public byte[] setAirconditionEnergySaving(String deviceId, int energySaving, int soundSet);

	/** 背景灯 取值：”0”，”1” 说明：”0”灯光关，”1”灯光开 */
	public byte[] setAirconditionBackgroundLight(String deviceId, int light, int soundSet);

	/** 显示屏发光 取值：”0”，”1” 说明：”0”灯光关，”1”灯光开 */
	public byte[] setAirconditionScreenLight(String deviceId, int light, int soundSet);

	/** LED灯 取值：”0”，”1” 说明：”0”灯光关，”1”灯光开 */
	public byte[] setAirconditionLEDLight(String deviceId, int light, int soundSet);

	/** 电加热 取值：0，1 说明：0电加热关，”1”电加热开 */
	public byte[] setAirconditionElectricalHeating(String deviceId, int electricalHeating, int soundSet);

	/** 1 强力设定（快速冷热） 取值：”0”，”1” 说明：”0”强力设定关，”1”强力设定开 */
	public byte[] setAirconditionEfficient(String deviceId, int fastCooling, int soundSet);

	/** 1 强力设定（快速冷热） 取值：”0”，”1” 说明：”0”强力设定关，”1”强力设定开 */
	public byte[] setAirconditionEfficientExportSales(String deviceId, int fastCooling, int soundSet);
	
	/** ？ 静音 取值：”0”，”1” 说明：”0”静音设定关，”1”静音设定开 */
	public byte[] setAirconditionMuteMode(String deviceId, int isMuteModeOn, int soundSet);

	/** ？ 风向 取值：”0”，”1” 说明：”0”风向设定关，”1”风向设定开 */
	public byte[] setAirconditionWindDirection(String deviceId, int isWindDirectionOn, int soundSet);

	/** ？ 湿度 取值：”0”，”1” 说明：”0”风向设定关，”1”风向设定开 */
	public byte[] setAirconditionHumidity(String deviceId, int humidity, int soundSet);

	/** ？ 华氏 摄氏 温度切换显示 取值：”0”，”1” 说明：”0”切换关，”1”切换开 */
	public byte[] setAirconditionFahrenheitOrCelsiusSwitch(String deviceId, int isSwitch, int soundSet);

	/** ？ 并用节电 设置功能:并用节电[0/1],提示声[0/1] */
	public byte[] setAirconditionAndPowerSavingMode(String deviceId, int isAndPowerSavingMode, int soundSet);

	/** ？双模 设置功能:双模[0/1],提示声[0/1] */
	public byte[] setAirconditionDualMode(String deviceId, int isDualMode, int soundSet);

	/** ？室内清洁 设置功能:室内清洁[0/1],提示声[0/1] */
	public byte[] setAirconditionIndoorClean(String deviceId, int isIndoorClean, int soundSet);
	
	/** ？室外清洁 设置功能:室内清洁[0/1],提示声[0/1] */
	public byte[] setAirconditionOutdoorClean(String deviceId, int isOutdoorClean, int soundSet);

	/** ？设置除烟 设置功能:除烟[0/1],提示声[0/1] */
	public byte[] setAirconditionCleanSmoke(String deviceId, int isCleanSmoke, int soundSet);

	/** ？显示亮度 设置功能:显示屏亮度值[0-255],提示声[0/1] */
	public byte[] setAirconditionBrightness(String deviceId, int brightness, int soundSet);

	/** ？除湿模式 设置功能:除湿模式[auto/1#/2#/3#/4#/5#/6#/7#],提示声[0/1] */
	public byte[] setAirconditionDehumidifyMode(String deviceId, String isDehumidifyMode, int soundSet);

	/** ？自然风 设置功能:自然风[0/1],提示声[0/1] */
	public byte[] setAirconditionNaturalWind(String deviceId, int isNaturalWind, int soundSet);
	
	/** ？清新 设置功能:清新[0/1],提示声[0/1] */
	public byte[] setAirconditionFreshAir(String deviceId, int isFreshAir, int soundSet);

	/** ？室内外温度切换显示 设置功能:室内外温度切换显示[0/1],提示声[0/1] */
	public byte[] setAirconditionIndoorOrOutdoorTemperatureDisplaySwitch(String deviceId, int isSwitch, int soundSet);

	/** ？换风 设置功能:换风[0/1],提示声[0/1] */
	public byte[] setAirconditionAirExchange(String deviceId, int isAirExchange, int soundSet);

	/** ？智慧眼 设置功能:智慧眼[0/1],提示声[0/1] */
	public byte[] setAirconditionSmartEye(String deviceId, int isSmartEye, int soundSet);

	/** ？室内过滤网清洁复位控制(净化) 设置功能:室内过滤网清洁复位控制[0/1],提示声[0/1] */
	public byte[] setAirconditionIndoorFilterCleanReset(String deviceId, int isReset, int soundSet);

	/** ？设置语音 设置功能:语音[0/1],提示声[0/1] */
	public byte[] setAirconditionVoice(String deviceId, int isVoice, int soundSet);
	
	/** 获取空调在线状态，表示设备当前是否socket连接正常 */
	public boolean getAirconditionOnlineStatus(String deviceId);

	/** 获取空调专家模式可控状态 */
	public String getAirconditionSmartStatus(String deviceId);

	/** 获取 设置开机后，持续时间 */
	public long getAirconditionSetPowerOnDuration(String deviceId);
	
	/** 获取 设置关机后，持续时间 */
	public long getAirconditionSetPowerOffDuration(String deviceId);	

	/** 获取 设置模式后，持续时间 */
	public long getAirconditionSetModeDuration(String deviceId);

	/** 获取 设置强力后，持续时间 */
	public long getAirconditionSetHighEfficientDuration(String deviceId);
	
	/** 获取 帧内序号 0~15 */
	public int getAirconditionSequence(String deviceId);

	/** 获取 操作结果 */
	public String getAirconditionResult(String deviceId);

	/** 获取 风速 auto/strong/middle/weak/mute */
	public String getAirconditionWindSpeed(String deviceId);

	/** 获取 模式 heat/auto/cool/dehumidify/blow */
	public String getAirconditionMode(String deviceId);

	/** 获取 睡眠 off/aged/younger/child/general */
	public String getAirconditionSleepMode(String deviceId);

	/** 获取电源 0 关，1 开 */
	public int getAirconditionPower(String deviceId);
	
	/** 获取 温度值 设置 */
	public int getAirconditionSetTemperature(String deviceId);

	/** 获取 温度值 室内 */
	public int getAirconditionTemperatureIndoor(String deviceId);

	/** 获取 温度值 室外 */
	public int getAirconditionTemperatureOutdoor(String deviceId);

	/** 获取 是否静音 */
	public int getAirconditionMute(String deviceId);

	/** 获取 强力状态 */
	public int getAirconditionHighEfficient(String deviceId);

	/** 获取 风门位置 */
	public String getAirconditionAirDoorPosition(String deviceId);

	/** 风向 */
	public int getAirconditionWindDirection(String deviceId);

	/** 湿度 */
	public int getAirconditionHumidity(String deviceId);

	/** 体感室内温度 */
	public int getAirconditionSomatosensoryRealityTemperature(String deviceId);

	/** 室内实际温度 */
	public int getAirconditionIndoorRealityTemperature(String deviceId);

	/** 室内盘管温度 */
	public int getAirconditionIndoorPipeTemperature(String deviceId);

	/** 室内实际湿度值 */
	public int getAirconditionIndoorRealityHumidity(String deviceId);

	/** 体感室内温度补偿 */
	public int getAirconditionSomatosensoryCompensation(String deviceId);

	/** 体感控制 */
	public int getAirconditionSomatosensoryContrl(String deviceId);

	/** 自动工作模式和除湿模式的温度补偿 */
	public int getAirconditionTemperatureCompensation(String deviceId);

	/** 华氏/摄氏温度显示设置 */
	public int getAirconditionTemperatureValueSwitch(String deviceId);

	/** 普通定时开关机是否设置 */
	public int getAirconditionGeneralTimingShutdownValue(String deviceId);

	/** 实时时钟的小时值 */
	public int getAirconditionRealityHour(String deviceId);

	/** 实时时钟的分钟值 */
	public int getAirconditionRealityMinute(String deviceId);

	/** 实时开机控制 */
	public int getAirconditionRealityBootContrl(String deviceId);

	/** 实时开机小时 */
	public int getAirconditionRealityBootHour(String deviceId);

	/** 实时开机分钟 */
	public int getAirconditionRealityBootMinute(String deviceId);

	/** 实时关机控制 */
	public int getAirconditionRealityShutdownContrl(String deviceId);

	/** 实时关机小时 */
	public int getAirconditionRealityShutdownHour(String deviceId);

	/** 实时关机分钟 */
	public int getAirconditionRealityShutdownMinute(String deviceId);

	/** 除湿模式 */
	public String getAirconditionDehumidificationMode(String deviceId);

	/** 上下风门 位置 垂直(上下)导风板位置 */
	public String getAirconditionVerticalWindMode(String deviceId);

	/** 上下风开停控制 */
	public int getAirconditionVerticalWindContrl(String deviceId);

	/** 左右风开停控制 */
	public int getAirconditionHorizontalWindContrl(String deviceId);

	/** 自然风开停控制 */
	public int getAirconditionNatureWindContrl(String deviceId);

	/** 电热 */
	public int getAirconditionElectricalHeating(String deviceId);

	/** 节能 */
	public int getAirconditionEnergyConservation(String deviceId);

	/** 并用节电 */
	public int getAirconditionShare(String deviceId);

	/** 双模 */
	public int getAirconditionDualMode(String deviceId);

	/** 清新 */
	public int getAirconditionFreshness(String deviceId);

	/** 换风 */
	public int getAirconditionFreshAir(String deviceId);

	/** 室内清洁 */
	public int getAirconditionCleanIndoor(String deviceId);

	/** 室外清洁 */
	public int getAirconditionCleanOutdoor(String deviceId);

	/** 智慧眼 */
	public int getAirconditionSmartEye(String deviceId);

	/** 语音 */
	public int getAirconditionVoice(String deviceId);

	/** 除烟 */
	public int getAirconditionCleanSmoke(String deviceId);

	/** 背景灯 */
	public int getAirconditionBackgroundLamp(String deviceId);

	/** 显示屏发光 */
	public int getAirconditionScreen(String deviceId);

	/** LED指示灯 */
	public int getAirconditionLED(String deviceId);

	/** 室内外温度切换显示 */
	public int getAirconditionIndoorOutdoorSwitch(String deviceId);

	/** 室内过滤网清洁复位控制 */
	public int getAirconditionIndoorFilterClear(String deviceId);

	/** 左风摆 */
	public int getAirconditionLeftWind(String deviceId);

	/** 右风摆 */
	public int getAirconditionRightWind(String deviceId);

	/** 室内电量板 */
	public int getAirconditionChargeBorad(String deviceId);

	/** 本次命令之前是否有过红外遥控与按键控制过 */
	public int getAirconditionHaveIRContrl(String deviceId);

	/** 本次命令之前是否有过WIFI控制过 */
	public int getAirconditionHaveWIFIContrl(String deviceId);

	/** 室内EEPROM在线升级 */
	public int getAirconditionEEPROMUpdate(String deviceId);

	/** 室内温度传感器故障 */
	public int getAirconditionIndoorTemperatureSensorTrouble(String deviceId);

	/** 室内盘管温度传感器故障 */
	public int getAirconditionIndoorPipeTemperatureSensorTrouble(String deviceId);

	/** 室内湿度传感器故障 */
	public int getAirconditionIndoorHumiditySensorTrouble(String deviceId);

	/** 室内排水泵故障 */
	public int getAirconditionIndoorDrainsWaterPumpTrouble(String deviceId);

	/** 室内风机电机运转异常故障 */
	public int getAirconditionIndoorFanMotorTrouble(String deviceId);

	/** 柜机格栅保护告警 */
	public int getAirconditionPioneerGrillingProtectTrouble(String deviceId);

	/** 室内电压过零检测故障 */
	public int getAirconditionIndoorVoltageZeroCrossDetectionTrouble(String deviceId);

	/** 室内外通信故障 */
	public int getAirconditionIndoorOutdoorCommunicationTrouble(String deviceId);

	/** 室内控制板与显示板通信故障 */
	public int getAirconditionIndoorContrlScreenCommunicationTrouble(String deviceId);

	/** 室内控制板与按键板通信故障 */
	public int getAirconditionIndoorContrlKeypadCommunicationTrouble(String deviceId);

	/** WIFI控制板与室内控制板通信故障 */
	public int getAirconditionIndoorContrlWIFICommunicationTrouble(String deviceId);

	/** 室内控制板与室内电量板通信故障 */
	public int getAirconditionIndoorContrlChargeCommunicationTrouble(String deviceId);

	/** 室内控制板EEPROM出错 */
	public int getAirconditionIndoorContrlEEPROMTrouble(String deviceId);

	/** 运行频率 */
	public int getAirconditionRunFrequency(String deviceId);

	/** 目标频率 */
	public int getAirconditionTargetFrequency(String deviceId);

	/** 发给驱动器的频率 */
	public int getAirconditionDriveFrequency(String deviceId);

	/** 室外环境温度 */
	public int getAirconditionEnvironmentTemperature(String deviceId);

	/** 冷凝器温度 */
	public int getAirconditionCondenserTemperature(String deviceId);

	/** 排气温度 */
	public int getAirconditionExhaustTemperature(String deviceId);

	/** 目标排气温度 */
	public int getAirconditionTargetExhaustTemperature(String deviceId);

	/** 室外电子膨胀阀开度 */
	public int getAirconditionOutdoorElectronicExpansion(String deviceId);

	/** UABH */
	public int getAirconditionUABH(String deviceId);

	/** UABL */
	public int getAirconditionUABL(String deviceId);

	/** UBCH */
	public int getAirconditionUBCH(String deviceId);

	/** UBCL */
	public int getAirconditionUBCL(String deviceId);

	/** UCAH */
	public int getAirconditionUCAH(String deviceId);

	/** UCAL */
	public int getAirconditionUCAL(String deviceId);

	/** IAB */
	public int getAirconditionIAB(String deviceId);

	/** IBC */
	public int getAirconditionIBC(String deviceId);

	/** ICA */
	public int getAirconditionICA(String deviceId);

	/** IUV */
	public int getAirconditionIUV(String deviceId);

	/** 直流母线电压H */
	public int getAirconditionCocurrentBusVoltageH(String deviceId);

	/** 直流母线电压L */
	public int getAirconditionCocurrentBusVoltageL(String deviceId);

	/** 四通阀状态 */
	public int getAirconditionFourWayLimen(String deviceId);

	/** 室外机实际工作状态 */
	public int getAirconditionOutdoorRealityRuning(String deviceId);

	/** 风机运行状态 */
	public int getAirconditionFanRuning(String deviceId);

	/** 室外机强制室内机风门位置 */
	public int getAirconditionOutdoorForceIndoorWindPosition(String deviceId);

	/** 室外机强制室内机风速 */
	public int getAirconditionOutdoorForceIndoorWindSpeed(String deviceId);

	/** 室外机强制室内机停 */
	public int getAirconditionOutdoorForceIndoorStop(String deviceId);

	/** 温控关机 */
	public int getAirconditionShutdownByTemperatureContrl(String deviceId);

	/** 一拖多标志 */
	public int getAirconditionOne4All(String deviceId);

	/** 除湿阀标志 */
	public int getAirconditionDehumidifierLimen(String deviceId);

	/** 室外机化霜 */
	public int getAirconditionOutdoorDefrosting(String deviceId);

	/** 室外旁通化霜 */
	public int getAirconditionOutdoorBypassDefrosting(String deviceId);

	/** 回油标志 */
	public int getAirconditionOilReturn(String deviceId);

	/** 室外故障显示标志 */
	public int getAirconditionOutdoorTroubleDisplay(String deviceId);

	/** 室外机EEPROM在线下载标志 */
	public int getAirconditionOutdoorEEPROMDownload(String deviceId);

	/** 室外机电量板 是否有 */
	public int getAirconditionOutdoorChargeBoard(String deviceId);

	/** 压缩机电热带 */
	public int getAirconditionCompressorRibbonHeater(String deviceId);

	/** 压缩机预加热 */
	public int getAirconditionCompressorBeforeHandheat(String deviceId);

	/*** 补气增晗 */
	public int getAirconditionReinflation(String deviceId);

	/** 室内外机模式冲突 */
	public int getAirconditionOutdoorModeClash(String deviceId);

	/** 室外EEPROM出错 */
	public int getAirconditionOutdoorEEPROMTrouble(String deviceId);

	/** 室外盘管温度传感器故障 */
	public int getAirconditionOutdoorPipeTemperatureSensorTrouble(String deviceId);

	/** 排气温度传感器故障 */
	public int getAirconditionOutdoorExhausTemperatureSensorTrouble(String deviceId);

	/** 室外环境温度传感器故障 */
	public int getAirconditionOutdoorEnvironmentTemperatureSensorTrouble(String deviceId);

	/** 电压变压器故障 */
	public int getAirconditionVoltageTransformerTrouble(String deviceId);

	/** 电流互感器故障 */
	public int getAirconditionCurrentTransformerTrouble(String deviceId);

	/** 室外控制与驱动通信故障 */
	public int getAirconditionOutdoorContrlDriveCommunicationTrouble(String deviceId);

	/** IPM模块过流保护 */
	public int getAirconditionIPMOvercurrentProtect(String deviceId);

	/** IPM模块过热保护 */
	public int getAirconditionIPMOverheatingProtect(String deviceId);

	/** 交流电过电压保护 */
	public int getAirconditionAlternatingCurrentOvervoltageProtect(String deviceId);

	/** 交流电欠电压保护 */
	public int getAirconditionAlternatingCurrentUndervoltageProtect(String deviceId);

	/** 母线电压过电压保护 */
	public int getAirconditionBusbarVoltageOvervoltageProtect(String deviceId);

	/** 母线电压欠电压保护 */
	public int getAirconditionBusbarVoltageUndervoltageProtect(String deviceId);

	/** PFC过电流保护 */
	public int getAirconditionPFCOvercurrentProtect(String deviceId);

	/** 室外机最大电流保护 */
	public int getAirconditionOutdoorMaximumCurrentProtect(String deviceId);

	/** 室外环境温度过低保护 */
	public int getAirconditionOutdoorEnvironmentOvertemperatureProtect(String deviceId);

	/** 排气温度过高保护 */
	public int getAirconditionExhaustOvertemperatureProtect(String deviceId);

	/** 压缩机管壳温度保护 */
	public int getAirconditionCompressoPipeShellTemperatureProtect(String deviceId);

	/** 室内防冻结或防过载保护 */
	public int getAirconditionIndoorAntiFreezingProtect(String deviceId);

	/** 室外机PFC保护 */
	public int getAirconditionOutdoorPFCProtect(String deviceId);

	/** 压缩机启动失败 */
	public int getAirconditionCompressoBootFail(String deviceId);

	/** 压缩机失步 */
	public int getAirconditionCompressoStepOut(String deviceId);

	/** 室外风机堵转 */
	public int getAirconditionOutdoorFanLockRotor(String deviceId);

	/** 室外盘管防过载保护 */
	public int getAirconditionOutdoorPieOverloadProtect(String deviceId);

	/** 冷媒泄漏 */
	public int getAirconditionRefrigerantLeakage(String deviceId);

	/** 压缩机型号匹配错误 */
	public int getAirconditionCompressoModelMismatch(String deviceId);

	/** 系统低频振动保护 */
	public int getAirconditionSystemLowFrequencyVibrationProtect(String deviceId);

	/** 室外散热器温度过高保护 */
	public int getAirconditionOutdoorRadiatorOvertemperatureProtect(String deviceId);

	/** 系统压力过高保护 */
	public int getAirconditionSystemHypertonusProtect(String deviceId);

	/** 逆变器直流过电压故障 */
	public int getAirconditionInverterCocurrentOvervoltageTrouble(String deviceId);

	/** 逆变器直流低电压故障 */
	public int getAirconditionInverterCocurrentUndervoltageTrouble(String deviceId);

	/** 逆变器交流过电流故障 */
	public int getAirconditionInverterCocurrentOvercurrentTrouble(String deviceId);

	/** 失步检出 */
	public int getAirconditionStepOutDetection(String deviceId);

	/** 逆变器IPM故障-边沿 */
	public int getAirconditionInverterEdgeFault(String deviceId);

	/** 逆变器IPM故障-电平 */
	public int getAirconditionInverterLevelFault(String deviceId);

	/** PFC_IPM故障-边沿 */
	public int getAirconditionPFC_IPMEdgeFault(String deviceId);

	/** PFC_IPM故障-电平 */
	public int getAirconditionPFC_IPMLevelFault(String deviceId);

	/** PFC停电检出故障 */
	public int getAirconditionPFCPowerCutFault(String deviceId);

	/** PFC过电流检出故障 */
	public int getAirconditionPFCOvercurrentFault(String deviceId);

	/** 直流电压检出异常 */
	public int getAirconditionDCVException(String deviceId);

	/** PFC低电压（有效值）检出故障 */
	public int getAirconditionPFCLowVoltageFault(String deviceId);

	/** AD偏置异常检出故障 */
	public int getAirconditionADOffsetAnomaliesFault(String deviceId);

	/** 逆变器PWM逻辑设置故障 */
	public int getAirconditionInverterPWMLogicFault(String deviceId);

	/** 逆变器PWM初始化故障 */
	public int getAirconditionInverterPWMInitFault(String deviceId);

	/** PFC_PWM逻辑设置故障 */
	public int getAirconditionPFCPWMLogicFault(String deviceId);

	/** PFC_PWM初始化故障 */
	public int getAirconditionPFC_PWMInitFault(String deviceId);

	/** 温度异常 */
	public int getAirconditionTemperatureAnomaly(String deviceId);

	/** 电机参数设置故障 */
	public int getAirconditionMotorDataFault(String deviceId);

	/** MCE故障 */
	public int getAirconditionMCEFault(String deviceId);

	/** 驱动EEPROM故障 */
	public int getAirconditionEEPROMFault(String deviceId);

	/** 室外盘管过载禁升频 */
	public int getAirconditionOutdoorCoilOverloadUpFrequency(String deviceId);

	/** 室外盘管过载降频 */
	public int getAirconditionOutdoorCoilOverloadDownFrequency(String deviceId);

	/** 室内盘管过载禁升频 */
	public int getAirconditionIndoorCoilOverloadUpFrequency(String deviceId);

	/** 室内盘管过载降频 */
	public int getAirconditionIndoorCoilOverloadDownFrequency(String deviceId);

	/** 压降排气过载禁升频 */
	public int getAirconditionPressureUpFrequency(String deviceId);

	/** 压降排气过载降频 */
	public int getAirconditionPressureDownFrequency(String deviceId);

	/** 室内盘管冻结禁升频 */
	public int getAirconditionIndoorCoilFreezingUpFrequency(String deviceId);

	/** 室内盘管冻结降频 */
	public int getAirconditionIndoorCoilFreezingDownFrequency(String deviceId);

	/** 室内外通信降频 */
	public int getAirconditionCommunicationDownFrequency(String deviceId);

	/** 模块温度过载限频 */
	public int getAirconditionModuleTemperaturelimitFrequency(String deviceId);

	/** 变调率限频 */
	public int getAirconditionModulationRatelimitFrequency(String deviceId);

	/** 相电流限频 */
	public int getAirconditionPhaseCurrentlimitFrequency(String deviceId);

	/** 并用节电保护禁升频 */
	public int getAirconditionPowerSaveUpFrequency(String deviceId);

	/** 并用节电保护降频 */
	public int getAirconditionPowerSaveDownFrequency(String deviceId);

	/** 过电流保护禁升频 */
	public int getAirconditionOvercurrentUpFrequency(String deviceId);

	/** 过电流保护降频 */
	public int getAirconditionOvercurrentDownFrequency(String deviceId);

	/** 室内风机转速xx */
	public int getAirconditionIndoorFanSpeedH(String deviceId);

	/** 室外风机转速00xx */
	public int getAirconditionIndoorFanSpeed00L(String deviceId);

	/** 有否PM2.5检测功能 */
	public int getAirconditionPM25(String deviceId);

	/** PM2.5污染程度 */
	public int getAirconditionPM25Level(String deviceId);

	/** 空气PM2.5质量百分比表示 */
	public int getAirconditionPM25Percent(String deviceId);

	/** 显示屏亮度值 */
	public int getAirconditionScreenLuminance(String deviceId);

	/** 普通定时开关机有效 */
	public int getAirconditionGeneralTimingShutdown(String deviceId);
	
	//功能使能查询
	/** 获取 室内风量支持档位数 */
	public int getAirconditionWindSpeedNumFN(String deviceId);

	/** 设置睡眠模式 */
	public int getAirconditionSleepModeFN(String deviceId);

	/** 设置模式 */
	/** 单冷/冷暖 机型 */
	public int getAirconditionCoolModeFN(String deviceId);

	/** 开/关机 */
	public int getAirconditionPowerFN(String deviceId);

	/** 室内单个风向控制功能 */
	public int getAirconditionWindDirectionFN(String deviceId);

	/** 设置温度 */
	public int getAirconditionTemperatureFN(String deviceId);

	/** 设置湿度 */
	public int getAirconditionHumidityFN(String deviceId);

	/** 体感控制,体感室内温度,体感室内温度补偿 */
	public int getAirconditionSomatosensoryRealityTemperatureFN(String deviceId);

	/** 自动工作模式和除湿模式的温度补偿 */
	public int getAirconditionTemperatureCompensationFN(String deviceId);

	/** 华氏/摄氏温度显示设置 */
	public int getAirconditionTemperatureValueSwitchFN(String deviceId);

	/** 普通定时关机,普通定时关机时间 */
	public int getAirconditionGeneralTimingShutdownFN(String deviceId);

	/** 实时开机控制,实时时钟的小时值,实时时钟的分钟值,实时开机小时,实时开机分钟 */
	public int getAirconditionRealityTimeFN(String deviceId);

	/** 6位置可定室内风门位置控制 */
	public int getAirconditionVerticalWindModeNum(String deviceId);

	/** 上下风门模式,上下风开停控制 */
	public int getAirconditionVerticalWindFN(String deviceId);

	/** 左右风开停控制,左风摆,右风摆 */
	public int getAirconditionHorizontalWindFN(String deviceId);

	/** 自然风开停 */
	public int getAirconditionNatureWindFN(String deviceId);

	/** 设置电加热 */
	public int getAirconditionElectricalHeatingFN(String deviceId);

	/** 除湿模式 */
	public int getAirconditionDehumidificationModeFN(String deviceId);

	/** 设置节能 */
	public int getAirconditionEnergyConservationFN(String deviceId);

	/** 设置并用节电 */
	public int getAirconditionShareFN(String deviceId);

	/** 设置高效/强力/快速冷热 */
	public int getAirconditionEfficientFN(String deviceId);

	/** 设置双模 */
	public int getAirconditionDualModeFN(String deviceId);

	/** 设置清新 */
	public int getAirconditionFreshnessFN(String deviceId);

	/** 设置换风 */
	public int getAirconditionFreshAirFN(String deviceId);

	/** 设置室内清洁 */
	public int getAirconditionCleanIndoorFN(String deviceId);

	/** 设置室外清洁 */
	public int getAirconditionCleanOutdoorFN(String deviceId);

	/** 设置室智能眼 */
	public int getAirconditionSmartEyeFN(String deviceId);

	/** 设置室静音 功能使能 */
	public int getAirconditionMuteFN(String deviceId);

	/** 设置室静音 功能 */
	public int getAirconditionMuteFN(String deviceId, boolean isFunction);

	/** 设置语音 */
	public int getAirconditionVoiceFN(String deviceId);

	/** 设置除烟 */
	public int getAirconditionCleanSmokeFN(String deviceId);

	/** 背景灯 */
	public int getAirconditionBackgroundLampFN(String deviceId);

	/** 显示屏发光 */
	public int getAirconditionScreenFN(String deviceId);

	/** LED指示灯 */
	public int getAirconditionLEDFN(String deviceId);

	/** 室内外温度切换显示 */
	public int getAirconditionIndoorOutdoorSwitchFN(String deviceId);

	/** 室内过滤网清洁复位控制 */
	public int getAirconditionIndoorFilterClearFN(String deviceId);

	/** 左风摆开停控制 */
	public int getAirconditionLeftFanContrlFN(String deviceId);

	/** 右风摆开停控制 */
	public int getAirconditionRightFanContrlFN(String deviceId);

	/** 控制规则 */
	public int getAirconditionContrlRate(String deviceId);
	
	
	/*********************************** 除湿机 *******************************************/
	/** Box 设置功能:开关机[0/1], 模式[continue/normal/auto]，风量[weak/strong/auto]，湿度[0-100]，提示声[0/1] */
	public byte[] setDehumidifier(String deviceId, int power, String mode, String windSpeed, int humidity, int soundSet);
	
	/** 电源 power : 0关，1开 soundSet : 0无声音，1开声音 */
	public byte[] setDehumidifierPower(String deviceId, int power, int soundSet);

	/** 设置除湿机专家模式可控状态 */
	public byte[] setDehumidifierSmartStatus(String deviceId, String smartStatus);

	/** 风速 设置功能:风量[weak/strong/auto]，提示声[0/1] */
	public byte[] setDehumidifierWindSpeed(String deviceId, String windSpeed, int soundSet);

	/** 模式 设置功能:模式[continue/normal/auto]，提示声[0/1] */
	public byte[] setDehumidifierMode(String deviceId, String mode, int soundSet);

	/** 定时开关机 设置功能：定时有效位[0/1],定时时间[0.5h-23h],提示声[0/1] */
	public byte[] setDehumidifierTimingSwitchMachine(String deviceId, int timingEnable, int timingValue, int soundSet);

	/** 湿度 湿度值 设置功能:加湿机设置[40/80]，提示声[0/1] */
	public byte[] setDehumidifierHumidityValue(String deviceId, int humidityValue, int soundSet);

	/** 温度 设置功能 ：温度值[18-30]，提示声[0/1] */
	public byte[] setDehumidifierTemperature(String deviceId, int temperature, int soundSet);

	/** 电加热 开关 设置功能:电加热[0/1]，提示声[0/1] */
	public byte[] setDehumidifierElectricalHeating(String deviceId, int electricalHeating, int soundSet);

	/** 水泵 开关 设置功能:水泵[0/1]，提示声[0/1] */
	public byte[] setDehumidifierWaterPumpPower(String deviceId, int waterPump, int soundSet);

	/** 负离子 开关 设置功能:负离子 开关[0/1]，提示声[0/1] */
	public byte[] setDehumidifierAnionPower(String deviceId, int anionPower, int soundSet);

	/** 获取除湿机在线状态，表示设备当前是否socket连接正常 */
	public boolean getDehumidifierOnlineStatus(String deviceId);

	/** 获取除湿机专家模式可控状态 */
	public String getDehumidifierSmartStatus(String deviceId);

	/** 获取 设置开机后，持续时间 */ // 盒子用
	public long getDehumidifierSetPowerOnDuration(String deviceId);

	/** 获取 设置关机后，持续时间 */ // 盒子用
	public long getDehumidifierSetPowerOffDuration(String deviceId);

	/** 获取 设置模式后，持续时间 */	// 盒子用到
	public long getDehumidifierSetModeDuration(String deviceId);

	/** 获取 帧内序号 0~15 */
	public int getDehumidifierSequence(String deviceId);

	/** 获取 操作结果 */
	public String getDehumidifierResult(String deviceId);

	/** 获取 风量[weak/strong/auto] */ // 盒子用到
	public String getDehumidifierWindSpeed(String deviceId);

	/** 获取 模式[continue/normal/auto] */ // 盒子用到
	public String getDehumidifierMode(String deviceId);

	/** 获取电源 0 关，1 开 */ // 盒子用到
	public int getDehumidifierPower(String deviceId);
	
	/** 湿度 设置值 */ // 盒子用到
	public int getDehumidifierHumidityValueSet(String deviceId);
	
	/** 室内湿度值 */ // 盒子用到
	public int getDehumidifierHumidityValueIndoor(String deviceId);
	
	/** 定时开关机是否有效 */
	public int getDehumidifierTimeValid(String deviceId);

	/** 定时开关机时间 */
	public String getDehumidifierTimerValue(String deviceId);

	/** 电加热 开关设定 */
	public int getDehumidifierEletricalHeating(String deviceId);

	/** 室内实际温度 */
	public int getDehumidifierIndoorTempStatus(String deviceId);

	/** 水泵开关 */
	public int getDehumidifierWaterPumpStatus(String deviceId);

	/** 负离子开关 */
	public int getDehumidifierAnionStatus(String deviceId);

	/** 过滤网清洁告警 */
	public int getDehumidifierFilterNetCleanWarning(String deviceId);

	/** 湿度传感器故障 */
	public int getDehumidifierHumidSensorError(String deviceId);

	/** 管温传感器故障 */
	public int getDehumidifierPumpTempratureError(String deviceId);

	/** 室内温度传感器故障 */
	public int getDehumidifierIndoorTempratureError(String deviceId);

	/** 水满警告 */
	public int getDehumidifierWaterFullWarning(String deviceId);

	/** 水泵故障 */
	public int getDehumidifierWaterPumpWarning(String deviceId);

	//功能使能
	/** 智慧风 */
	public int getDehumidifierSmartWindFN(String deviceId);

	/** 高风 */
	public int getDehumidifierHighWindFN(String deviceId);

	/** 中风 */
	public int getDehumidifierMediumWindFN(String deviceId);

	/** 低风 */
	public int getDehumidifierLowWindFN(String deviceId);

	/** 运行模式 持续运行 */
	public int getDehumidifierContinueModeFN(String deviceId);

	/** 运行模式 正常运行 */
	public int getDehumidifierNormalModeFN(String deviceId);

	/** 运行模式 自动运行 */
	public int getDehumidifierAutoModeFN(String deviceId);

	/** 定时 */
	public int getDehumidifierTimerControlFN(String deviceId);

	/** 电加热 */
	public int getDehumidifierElectricHeatFN(String deviceId);

	/** 电加热 温度 */
	public int getDehumidifierElectricHeatSetTemperatureFN(String deviceId);

	/** 室内湿度 */
	public int getDehumidifierIndoorHumidityFN(String deviceId);

	/** 水泵 */
	public int getDehumidifierWaterPumpFN(String deviceId);

	/** 负离子 */
	public int getDehumidifierAnionFN(String deviceId);

	/** 电量检测 */
	public int getDehumidifierElectronicDetectFN(String deviceId);

	/** 电源 */
	public int getDehumidifierPowerFN(String deviceId);

	/** EEPROM可改写功能 */
	public int getDehumidifierEEPROMWriteFN(String deviceId);
	
	
	/*********************************** 空气净化器 *******************************************/
	/** Box 设置功能:开关机[0/1], 模式[cleardust/clearsmell/smart/mute/sleep]，风量[weak/middle/strong/clear/auto]， 负离子开关[0/1], 加湿机开关[0/1]，设置湿度[40/80],提示声[0/1] */
	public byte[] setAircleaner(String deviceId, int power, String mode, String windSpeed, int anionPower, int humidifierPower, int humidity, int soundSet);

	/** 设置空气净化器专家模式可控状态 */
	public byte[] setAircleanerSmartStatus(String deviceId, String smartStatus);

	/** 电源 power : 0关，1开 soundSet : 0无声音，1开声音 */
	public byte[] setAircleanerPower(String deviceId, int power, int soundSet);

	/** 风速 设置功能:风量[weak/middle/strong/clear/auto]，提示声[0/1] */
	public byte[] setAircleanerWindSpeed(String deviceId, String windSpeed, int soundSet);

	/** 模式 设置功能:模式[cleardust/clearsmell/smart/mute/sleep]，提示声[0/1] */
	public byte[] setAircleanerMode(String deviceId, String mode, int soundSet);

	/** 定时开关机 设置功能:普通定时开关机[1-23],普通定时有效位[0/1]，提示声[0/1]
	 * 定时时间格式严格为[1.0h,2.0h,3.0h,4.0h,5.0h,6.0h,7.0h,8.0h,9.0h,10h,11h,12h,13h,14,15h,16,17h,18h,19h,20h,21h,22,23h], */
	public byte[] setAircleanerTimingSwitchMachine(String deviceId, int timingEnable, int timingValue, int soundSet);

	/** 儿童锁 开关 设置功能:儿童锁[0/1]，提示声[0/1] */
	public byte[] setAircleanerChildClockPower(String deviceId, int childClockPower, int soundSet);

	/** 水离子 开关 设置功能:儿童锁[0/1]，提示声[0/1] */
	public byte[] setAircleanerWaterIonPower(String deviceId, int waterIonPower, int soundSet);

	/** 加湿器开关 设置功能:加湿机开关[0/1]，提示声[0/1] */
	public byte[] setAircleanerHumidifierPower(String deviceId, int humidifierPower, int soundSet);

	/** 加湿 湿度值 设置功能:加湿机设置[40/80]，提示声[0/1] */
	public byte[] setAircleanerHumidityValue(String deviceId, int humidityValue, int soundSet);

	/** 获取空气净化器在线状态，表示设备当前是否socket连接正常 */
	public boolean getAircleanerOnlineStatus(String deviceId);

	/** 获取空气净化器专家模式可控状态 */
	public String getAircleanerSmartStatus(String deviceId);

	/** 获取 设置开机后，持续时间 */ // 盒子用
	public long getAircleanerSetPowerOnDuration(String deviceId);

	/** 获取 设置关机后，持续时间 */ // 盒子用
	public long getAircleanerSetPowerOffDuration(String deviceId);

	/** 获取 设置模式后，持续时间 */ 	// 盒子用
	public long getAircleanerSetModeDuration(String deviceId);
	
	/** 获取 加湿，持续时间 */ // 盒子用
	public long getAircleanerHumidifyDuration(String deviceId);
	
	/** 获取 负离子开关，持续时间 */ // 盒子用
	public long getAircleanerAnionDuration(String deviceId);

	/** 获取 帧内序号 0~15 */
	public int getAircleanerSequence(String deviceId);

	/** 获取 操作结果 */
	public String getAircleanerResult(String deviceId);

	/** 获取  风量[weak/middle/strong/clear/auto] */ // 盒子用到
	public String getAircleanerWindSpeed(String deviceId);

	/** 获取 模式[cleardust/clearsmell/smart/mute/sleep] */ // 盒子用到
	public String getAircleanerMode(String deviceId);

	/** 湿度 设置值 */ // 盒子用到
	public int getAircleanerHumidityValueSet(String deviceId);
	
	/** 加湿状态 */ // 盒子用到
	public int getAircleanerHumidityPower(String deviceId);
	
	/** 负离子开关状态 */ // 盒子用到
	public int getAircleanerAnionPower(String deviceId);
	
	/** 室内湿度 */ // 盒子用到
	public int getAircleanerHumidifyIndoor(String deviceId);
	
	/** 2定时开关机控制 是否有效 */
	public int getAircleanerTimeStatus(String deviceId);

	/** 3定时开关机时间, */
	public String getAircleanerTimerValue(String deviceId);

	/** 4风机转速, */
	public int getAircleanerMotorSpeed(String deviceId);

	// 盒子用到
	/** 5空气质量, 洁净度 空气质量 */
	public int getAircleanerAirQuality(String deviceId);

	/** 6空气质量百分比, */
	public int getAircleanerAirQualityPercent(String deviceId);

	/** 7相对湿度, */
	public int getAircleanerRelativeHumidityValue(String deviceId);

	// 盒子用到
	/** 8开停净化机, 获取电源 0 关，1 开 */
	public int getAircleanerPower(String deviceId);

	/** 9儿童锁开关控制, */
	public int getAircleanerChildLockStatus(String deviceId);

	/** 10水离子开停控制, */
	public int getAircleanerWaterionStatus(String deviceId);

	/** 11加湿机开停控制, */
	public int getAircleanerHumidityStatus(String deviceId);

	/** 12过滤网更换提示, */
	public int getAircleanerChangeFilterError(String deviceId);

	/** 15加湿转轮不动, */
	public int getAircleanerHumidityWheelError(String deviceId);

	/** 16水箱空, */
	public int getAircleanerWaterSinkEmptyError(String deviceId);

	/** 17水箱未装好, */
	public int getAircleanerWaterSinkNotSetup(String deviceId);

	/** 18湿度传感器故障, */
	public int getAircleanerHumiditySensorError(String deviceId);

	/** 19风机故障, */
	public int getAircleanerMotorError(String deviceId);

	/** 20风尘传感器故障, */
	public int getAircleanerDustSensorError(String deviceId);

	/** 21气味传感器故障, */
	public int getAircleanerSmellSensorError(String deviceId);

	/** 22机器倾斜故障 */
	public int getAircleanerLeanError(String deviceId);

	/** 23湿度设置值 */
	public int getAircleanerSettingHumid(String deviceId);

	// 功能使能
	/** 1净化速度状态-自动功能， */
	public int getAircleanerCleanSpeedAutoFN(String deviceId);

	/** 2净化速度状态-净烟功能 ， */
	public int getAircleanerCleanSpeedDelSmokeFN(String deviceId);

	/** 3净化速度状态-高风功能 */
	public int getAircleanerCleanSpeedHighFN(String deviceId);

	/** 4净化速度状态-中风功能， */
	public int getAircleanerCleanSpeedMiddleFN(String deviceId);

	/** 5净化速度状态-低风功能， */
	public int getAircleanerCleanSpeedLowFN(String deviceId);

	/** 6净化模式状态-睡眠功能， */
	public int getAircleanerCleanModeSleepFN(String deviceId);

	/** 7净化模式状态-静音功能， */
	public int getAircleanerCleanModeMuteFN(String deviceId);

	/** 8净化模式状态-智能功能， */
	public int getAircleanerCleanModeSmartFN(String deviceId);

	/** 9净化模式状态-除味功能， */
	public int getAircleanerCleanModeDelTasteFN(String deviceId);

	/** 10净化模式状态-除烟功能， */
	public int getAircleanerCleanModeDelSmokeFN(String deviceId);

	/** 11普通定时功能， */
	public int getAircleanerGeneralTimingFN(String deviceId);

	/** 12儿童锁功能， */
	public int getAircleanerChildLockFN(String deviceId);

	/** 13水离子开停， */
	public int getAircleanerWaterIonFN(String deviceId);

	/** 14加湿机开停功能， */
	public int getAircleanerDehumidifierFN(String deviceId);

	/** 15净化机开停功能 */
	public int getAircleanerCleanMachineFN(String deviceId);

	/** 16 EEPROM可改写功能, */
	public int getAircleanerEEpromReadWriteFN(String deviceId);

	/** 17电量检测功能, */
	public int getAircleanerPowerDetectFN(String deviceId);
	
	
	/*********************************** 新风机 *******************************************/
	/** Box 设置功能:开关机[0/1], 模式[fullheat/direct/indoor/auto]，风量[weak/middle/strong/auto]，提示声[0/1] */
	public byte[] setAirfan(String deviceId, int power, String mode, String windSpeed, int soundSet);

	/** 设置新风机专家模式可控状态 */
	public byte[] setAirfanSmartStatus(String deviceId, String smartStatus);

	/** 电源 power : 0关，1开 soundSet : 0无声音，1开声音 */
	public byte[] setAirfanPower(String deviceId, int power, int soundSet);

	/** 风速 设置功能:风量[weak/middle/strong/auto]，提示声[0/1] */
	public byte[] setAirfanWindSpeed(String deviceId, String windSpeed, int soundSet);

	/** 模式 设置功能:模式[fullheat/direct/indoor/auto]，提示声[0/1] */
	public byte[] setAirfanMode(String deviceId, String mode, int soundSet);

	/** 定时开关机 设置功能:普通定时开关机[0.5h-23h],普通定时有效位[0/1]，提示声[0/1]
	 * 定时时间格式严格为[1.0h,2.0h,3.0h,4.0h,5.0h,6.0h,7.0h,8.0h,9.0h,10h,11h,12h,13h,14,15h,16,17h,18h,19h,20h,21h,22,23h], */
	public byte[] setAirfanTimingSwitchMachine(String deviceId, int timingEnable, int timingValue, int soundSet);

	/** 获取新风机在线状态，表示设备当前是否socket连接正常 */
	public boolean getAirfanOnlineStatus(String deviceId);

	/** 获取新风机专家模式可控状态 */
	public String getAirfanSmartStatus(String deviceId);

	/** 获取 设置开机后，持续时间 */ // 盒子用
	public long getAirfanSetPowerOnDuration(String deviceId);

	/** 获取 设置关机后，持续时间 */ // 盒子用
	public long getAirfanSetPowerOffDuration(String deviceId);

	/** 获取 设置开关机后，持续时间 */	// 盒子用
	public long getAirfanSetModeDuration(String deviceId);

	/** 获取 帧内序号 0~15 */
	public int getAirfanSequence(String deviceId);

	/** 获取 操作结果 */
	public String getAirfanResult(String deviceId);

	/** 获取 风速 [weak/middle/strong/auto] */ // 盒子用到
	public String getAirfanWindSpeed(String deviceId);

	/** 获取 模式 [fullheat/direct/indoor/auto]*/ // 盒子用到
	public String getAirfanMode(String deviceId);

	/** 获取电源 0 关，1 开 */ // 盒子用到
	public int getAirfanPower(String deviceId);
	
	/** 室内湿度值 */ // 盒子用到
	public int getAirfanHumidityIndoor(String deviceId);
	
	/** 室外湿度值 */ // 盒子用到
	public int getAirfanHumidityOutdoor(String deviceId);
	
	/** 室内温度值 */ // 盒子用到
	public int getAirfanTemperatureIndoor(String deviceId);
	
	/** 室外温度值 */ // 盒子用到
	public int getAirfanTemperatureOutdoor(String deviceId);
	
	/** 室内CO2浓度 */ // 盒子用到
	public int getAirfanCO2Indoor(String deviceId);
	
	/** 是否待机 */
	public int getAirfanSuspendMode(String deviceId);

	/** 是否有定时开关 */
	public int getAirfanIsTiming(String deviceId);

	/** 定时开关时间 */
	public int getAirfanTimingTime(String deviceId);

	/** 室外风机转速*10为实际转速，无此项时为1 */
	public int getAirfanOuterFanSpeed(String deviceId);

	/** 室内风机转速*10为实际转速，无此项时为1 */
	public int getAirfanInnerFanSpeed(String deviceId);

	/** 室内实际温度有效 */
	public int getAirfanInnerTempratureValid(String deviceId);

	/** 室内实际湿度有效 */
	public int getAirfanInnerHumidityValid(String deviceId);

	/** 室内侧二氧化碳 值 有效 */
	public int getAirfanInnerco2DensityValid(String deviceId);

	/** 室外侧温度有效 */
	public int getAirfanOuterTempratureValid(String deviceId);

	/** 室外侧湿度有效 */
	public int getAirfanOuterHumidityValid(String deviceId);

	/** 过滤网更换提示 */
	public int getAirfanFilterIfReplace(String deviceId);

	/** 室外风机故障 */
	public int getAirfanOuterFanIfFault(String deviceId);

	/** 室内风机故障 */
	public int getAirfanInnerFanIfFault(String deviceId);

	/** 室外侧温度传感器故障 */
	public int getAirfanOuterTemperatureSensorIfFault(String deviceId);

	/** 室外侧湿度传感器故障 */
	public int getAirfanOuterHumiditySensorIfFault(String deviceId);

	/** 二氧化碳传感器故障 */
	public int getAirfanCo2SensorIfFault(String deviceId);

	/** 室内侧温度传感器故障 */
	public int getAirfanInnerTemperatureSensorFault(String deviceId);

	/** 室内侧湿度传感器故障 */
	public int getAirfanInnerHumiditySensorFault(String deviceId);

	//功能使能
	/** 风量支持档位数 */
	public int getAirfanSpeedSupportNumberFN(String deviceId);

	/** 全热换气模式 */
	public int getAirfanfullheatModeFN(String deviceId);

	/** 直通换气模式 */
	public int getAirfanDirectModeFN(String deviceId);

	/** 室内回旋模式 */
	public int getAirfanIndoorModeFN(String deviceId);

	/** 普通定时模式 */
	public int getAirfanTiming(String deviceId);

	/** 开关机控制位 */
	public int getAirfanPowerFN(String deviceId);

	/** EPPROM */
	public int getAirfanIfUpdateEEPROM(String deviceId);

	/** 电量检测 */
	public int getAirfanBatteryIFdetection(String deviceId);
	
	
	/*********************************** 四合一传感器 *******************************************/

	/** 设置新风机专家模式可控状态 */
	public byte[] setSensorsSmartStatus(String deviceId, String smartStatus);
	
	/** PM2.5开关设置 设置功能：power[1] */
	public byte[] setSensorsPM25Power(String deviceId, int power);
	
	/** 传感器电源控制 切断 上电 电源控制：power[0/1] 传感器ID: [1 温度、2湿度、3 甲醛、4 PM2.5] */
	public byte[] setSensorsPower(String deviceId, int power, int sensorID);

	/** 主动上报频率设置 是否设置上报频率：responseFrequencyValid[0/1] 传感器ID responseID : [1 温度、2湿度、3 甲醛、4 PM2.5] 上报频率(单位 秒)：responseFrequency */
	public byte[] setResponseFrequency(String deviceId, int responseFrequencyValid, int responseID, int responseFrequency);

	/** 获取四合一传感器在线状态，表示设备当前是否socket连接正常 */
	public boolean getSensorsOnlineStatus(String deviceId);

	/** 获取新风机专家模式可控状态 */
	public String getSensorsSmartStatus(String deviceId);

	/** 获取 温度传感器ID */
	public int getSensorsTemperatureSensorID(String deviceId);

	/** 获取 温度值是否有效 */
	public int getSensorsTemperatureValueValid(String deviceId);

	/** 获取 温度传感器电源状态 */
	public int getSensorsTemperatureSensorPowerStatus(String deviceId);

	/** 获取 上次读温度值时间 */
	public int getSensorsTemperatureInterval(String deviceId);

	/** 获取 温度值 */
	public float getSensorsTemperatureValue(String deviceId);

	/** 获取 湿度传感器ID */
	public int getSensorsHumiditySensorID(String deviceId);

	/** 获取 湿度值是否有效 */
	public int getSensorsHumidityValueValid(String deviceId);

	/** 获取 湿度传感器电源状态 */
	public int getSensorsHumiditySensorPowerStatus(String deviceId);

	/** 获取 上次读湿度值时间 */
	public int getSensorsHumidityInterval(String deviceId);

	/** 获取 湿度值 */
	public int getSensorsHumidityValue(String deviceId);

	/** 获取 甲醛传感器ID */
	public int getSensorsH2COSensorID(String deviceId);

	/** 获取 甲醛值是否有效 */
	public int getSensorsH2COValueValid(String deviceId);

	/** 获取 甲醛传感器电源状态 */
	public int getSensorsH2COSensorPowerStatus(String deviceId);

	/** 获取 上次读甲醛值时间 */
	public int getSensorsH2COInterval(String deviceId);

	/** 获取 甲醛值 */
	public float getSensorsH2COValue(String deviceId);

	/** 获取 PM2.5传感器ID */
	public int getSensorsPM25SensorID(String deviceId);

	/** 获取 PM2.5值是否有效 */
	public int getSensorsPM25ValueValid(String deviceId);

	/** 获取 PM2.5传感器电源状态 */
	public int getSensorsPM25SensorPowerStatus(String deviceId);

	/** 获取 上次读PM2.5值时间 */
	public int getSensorsPM25Interval(String deviceId);

	/** 获取 PM2.5值 */
	public float getSensorsPM25Value(String deviceId);

	/** 获取 CO2传感器ID */
	public int getSensorsCO2SensorID(String deviceId);

	/** 获取 CO2值是否有效 */
	public int getSensorsCO2ValueValid(String deviceId);

	/** 获取 CO2传感器电源状态 */
	public int getSensorsCO2SensorPowerStatus(String deviceId);

	/** 获取 上次读CO2值时间 */
	public int getSensorsCO2Interval(String deviceId);

	/** 获取 CO2值 */
	public int getSensorsCO2Value(String deviceId);

	/**
	 * 转换板通信错误
	 * @return 0为正常，1为通信错误
	 */
	public int getSensorsIsPeripheralsCommunicationError(String deviceId);


//	/*********************************** 4004模组 *******************************************/
//	public int getSmartSwitchPowerStatus(String deviceId);
//
//	public int getSmartSwitchCurrent(String deviceId);
//
//	public int getSmartSwitchVoltage(String deviceId);
//
//	public long getSmartSwitchPowerConsum(String deviceId);
//
//	/**
//	 * 获取家电受控状态（遥控器或红外控制）
//	 * 
//	 * @Method: getWifiModuleSmartControlStatus 
//	 * @param deviceId
//	 * @return 家电受控状态
//	 */
//	public int getWifiModuleSmartControlStatus(String deviceId);
//	
//	/**
//	 * 设置设备是否支持主动上报
//	 * 
//	 * @param deviceId 模块id
//	 * @param autoReport 0表示设备不支持，1表示设备支持
//	 * @return 设置成功返回true，失败返回false
//	 */
//	public boolean setDeviceAutoReportFlag(String deviceId, String autoReport);
//	
//	/**
//	 * 设置设备可控	
//	 * 
//	 * @param deviceId 模块id
//	 * @param cmd "QUERY"查询受控状态，"UNLOCK"解锁受控
//	 * @return 设置成功返回true，失败返回false
//	 */
//	public boolean setDeviceControllable(String deviceId, String cmd);
//	
//	/** query module: WHO */
//	public boolean queryWifiModuleModuleID(String deviceId);
//	
//	/** query module fireware version: WFV */
//	public boolean queryWifiModuleVersion(String deviceId);
//	
//	/** query module wifi parameters: WFR */
//	public boolean queryWifiModuleStatus(String deviceId);
//	
//	/** clear wifi config parameters: WFCLS */
//	public boolean clearWifiConfigPars(String deviceId);
//	
//	/** clear wifi config parameters: WFMAC */
//	public boolean queryWifiModuleMac(String deviceId);
//	
//	/** query module connect cdn information: WFQRS */
//	public boolean queryWifiModuleRSInfo(String deviceId);
//	
//	/** set module connect cdn information: WFSRS */
//	public boolean setWifiModuleRSInfo(String deviceId, String domainname, String port);
//	
//	/** query module connect router information: WFQAP */
//	public boolean queryWifiRouterInfo(String deviceId);
//	
//	/** set module connect cdn information: WFSAP */
//	public boolean setWifiRouterInfo(String deviceId, String ssid, String password);
//	
//	/** request module connect remote: WFCR */
//	public boolean setWifiToStationMode(String deviceId);
//	
//	/** query module tcp server ip in station mode: WFSIP */
//	public boolean queryWifiModuleServerIp(String deviceId);
//	
//	/** switch to AP mode: WFLC */
//	public boolean setWifiToApMode(String deviceId);
//	
//	/** set local flag: WFLOCFLAG */
//	public boolean setWifiModuleLocalFlag(String deviceId, String flag);
//	
//	/** set protocol version: WFSPV */
//	public boolean setWifiProtocolVersion(String deviceId, String version);
//	
//	/** http ota method: WFHOTA */
//	public boolean setHttpUpdateWifiModule(String deviceId, String url);
//
//	//查询电量计的值   开关状态、当前电压、当前电流、累积电量
//	public boolean querySmartSwitchValue(String deviceId);
//
//	//累积电量清零
//	public boolean clearSmartSwitchValue(String deviceId);
//
//	//设置计电器开关 1开0关
//	public boolean setSmartSwitchPower(String deviceId, String enflag);


	/*********************************** 窗帘 *******************************************/	
	/**
	 * 模式：Mode : 设置功能:0打开、1 关闭、2、重启、3 定点控制
	 * @param mode 0打开、1 关闭、2、重启、3 定点控制
	 * @return 成功或失败
	 */
	public byte[] setSmartcurtainMode(String deviceId, int mode);
	
	/**
	 * 定点控制：Pos : 设置功能:设置的定点位置(0~16)
	 * @param position [0~16]
	 * @return 成功或失败
	 */
	
	public byte[] setSmartcurtainPosition(String deviceId, int position);
	
	/**
	 * 获取窗帘在线状态，表示设备当前是否socket连接正常
	 * @return 成功或失败
	 */
	public boolean getSmartcurtainOnlineStatus(String deviceId);
	
	/**
	 * Open or Close state 参数是否有效
	 * @return int
	 */
	public int getSmartcurtainPowerStatusParameterIsValid(String deviceId);

	/**
	 * Open or Close state 开关状态
	 * @return int
	 */
	
	public int getSmartcurtainPowerStatus(String deviceId);
	/**
	 * 定点位置 参数是否有效
	 * @return int
	 */
	
	public int getSmartcurtainPositionParameterIsValid(String deviceId);
	
	/**
	 * 当前的定点位置
	 * @return int
	 */
	public int getSmartcurtainPositionStatus(String deviceId);
	
	/**
	 * 转换板通信错误
	 * @return 0为正常，1为通信错误
	 */
	public int getSmartcurtainIsPeripheralsCommunicationError(String deviceId);


	/*********************************** 氛围灯 *******************************************/
	/**
	 * 电源设置 此方法未实现
	 * @param power [0/1]
	 * @return 成功或失败
	 */
	public byte[] setSmartlightPower(String deviceId, int power);
	
	/**
	 * 亮度设置：0~100
	 * @param brightnessValue 0~100
	 * @return 成功或失败
	 */
	public byte[] setSmartlightBrightness(String deviceId, int brightnessValue);

	/**
	 * R G B 三元色设置 取值范围均为[0-255]
	 * @param redValue [0-255]
	 * @param greenValue [0-255]
	 * @param blueValue [0-255]
	 * @return 成功或失败
	 */
	public byte[] setSmartlightRGB(String deviceId, int redValue, int greenValue, int blueValue);

	/**
	 * 空气状况 3 优、2 良、1 一般
	 * @param airQualityLevel 3 优、2 良、1 一般
	 * @return 成功或失败
	 */
	public byte[] setSmartlightAirQualityLevel(String deviceId, int airQualityLevel);

	/**
	 * 色温设置(0~65535) 此方法未实现
	 * @param colorTemperatureValue (0~65535)
	 * @return 成功或失败
	 */
	public byte[] setSmartlightColorTemperature(String deviceId, int colorTemperatureValue);

	/**
	 * 设备状态 0 为正常，1 为掉线
	 * @param deviceStatus 0 为正常，1 为掉线
	 * @return 成功或失败
	 */
	public byte[] setSmartlightDeviceStatus(String deviceId, int deviceStatus);

	/**
	 * 获取氛围灯的在线状态 此方法未实现
	 * @param deviceId:设备ID
	 * @return 成功或失败
	 */
	public boolean getSmartlightOnlineStatus(String deviceId);

	/**
	 * 开关状态 此方法未实现
	 * @return int
	 */
	public int getSmartlightPower(String deviceId);

	/**
	 * RGB 值是否有效
	 * @return int
	 */
	public int getSmartlightRGBSetValid(String deviceId);

	/**
	 * 红色值
	 * @return int
	 */
	public int getSmartlightRedValue(String deviceId);

	/**
	 * 绿色值
	 * @return int
	 */
	public int getSmartlightGreenValue(String deviceId);

	/**
	 * 蓝色值
	 * @return int
	 */
	public int getSmartlightBlueValue(String deviceId);

	/**
	 * 色温值是否有效 此方法未实现
	 * @return int
	 */
	public int getSmartlightColorTemperatureValid(String deviceId);

	/**
	 * 色温值(0~65535) 此方法未实现
	 * @return int
	 */
	public int getSmartlightColorTemperatureValue(String deviceId);

	/**
	 * 亮度值是否有效
	 * @return int
	 */
	public int getSmartlightBrightnessValid(String deviceId);

	/**
	 * 亮度
	 * @return int
	 */
	public int getSmartlightBrightnessValue(String deviceId);

	/**
	 * 设备状态 0 为有效，1 为无效
	 * @return 0 为有效，1 为无效
	 */
	public int getSmartlightDeviceStatusValid(String deviceId);

	/**
	 * 设备状态 0 为正常，1 为掉线
	 * @return 0 为正常，1 为掉线
	 */
	public int getSmartlightDeviceStatus(String deviceId);

	/**
	 * 空气状况是否有效 0 为有效，1 为无效
	 * @return 0 为有效，1 为无效
	 */
	public int getSmartlightAirStatusValid(String deviceId);

	/**
	 * 空气状况 3 优、2 良、1 一般
	 * @return 3 优、2 良、1 一般
	 */
	public int getSmartlightAirStatus(String deviceId);

	/**
	 * 转换板通信错误
	 * @return 0为正常，1为通信错误
	 */
	public int getSmartlightIsPeripheralsCommunicationError(String deviceId);


	/*********************************** 电量计 *******************************************/
	/**
	 * 总的电源开关
	 * 
	 * @param power
	 *            [0/1]
	 * @return boolean
	 */
	public byte[] setVoltameterPower(String deviceId, int power);

	/**
	 * 电量统计清0
	 * 
	 * @param isResetCount
	 *            [0/1]
	 * @return boolean
	 */
	public byte[] setVoltameterResetCount(String deviceId, int isResetCount);

	/**
	 * 总电源开关状态
	 * 
	 * @return int
	 */
	public int getVoltameterPower(String deviceId);

	/**
	 * 电流值uA
	 * 
	 * @return int
	 */
	public int getVoltameterCurrentValue(String deviceId);

	/**
	 * 电压值mV
	 * 
	 * @return int
	 */
	public int getVoltameterVoltageValue(String deviceId);

	/**
	 * 电量值的统计
	 * 
	 * @return long
	 */
	public long getVoltameterQuantityValue(String deviceId);

	/**
	 * 转换板通信错误
	 * @return 0为正常，1为通信错误
	 */
	public int getVoltameterIsPeripheralsCommunicationError(String deviceId);


	/***********************************设备控制接口 end****************************************/


}
