package com.xinlianfeng.android.livehome.devices.airfan;

public interface IAirFanControl {

	/*********************************** Box设置 *******************************************/
	/**
	 * Box 设置功能:开关机[0/1], 模式[fullheat/direct/indoor/auto]，风量[weak/middle/strong/auto]，提示声[0/1]
	 * 
	 * @param power
	 *            [0/1]
	 * @param mode
	 *            [fullheat/direct/indoor/auto]
	 * @param windSpeed
	 *            [weak/middle/strong/auto]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setBoxAirFan(int power, String mode, String windSpeed, int soundSet);

	/*********************************** 功能设置 *******************************************/
	/**
	 * 电源 power : 0关，1开 soundSet : 0无声音，1开声音
	 * 
	 * 请注意：新风机固件暂时只实现了开、关机，状态查询（开 关机，室内、室外的温度，室内室外的湿度，室内CO2的浓度）
	 * 
	 * @param power
	 *            0关 ，1开
	 * @param soundSet
	 *            0无声音 ，1开声音
	 * @return byte[]
	 */
	public byte[] setPower(int power, int soundSet);

	/**
	 * 风速 设置功能:风量[weak/middle/strong/auto]，提示声[0/1]
	 * 
	 * @param windSpeed
	 *            [weak/middle/strong/auto]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setWindSpeed(String windSpeed, int soundSet);

	/**
	 * 模式 设置功能:模式[fullheat/direct/indoor/auto]，提示声[0/1]
	 * 
	 * @param mode
	 *            [fullheat/direct/indoor/auto]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setMode(String mode, int soundSet);

	/**
	 * 定时开关机 设置功能:普通定时开关机[0.5h-23h],普通定时有效位[0/1]，提示声[0/1],
	 * 定时时间格式严格为[1.0h,2.0h,3.0h,4.0h,5.0h,6.0h,7.0h,8.0h,9.0h,10h,11h,12h,13h,14,15h,16,17h,18h,19h,20h,21h,22,23h],
	 * 
	 * @param timingEnable
	 *            普通定时有效位[0/1]
	 * @param timingValue
	 *            Val=0,取消定时,val[1~20],定时val*0.5小时,val=[21~34]定时10+(val-20) 小时
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setTimingSwitchMachine(int timingEnable, int timingValue, int soundSet);

	/*********************************** 状态查询 *******************************************/
	// 盒子用
	/**
	 * 获取 设置开关机后，持续时间
	 * 
	 * @return long
	 */
	public long getSetPowerOnDuration();

	// 盒子用
	/**
	 * 获取 设置关机后，持续时间
	 * 
	 * @return long
	 */
	public long getSetPowerOffDuration();

	// 盒子用
	/**
	 * 获取 设置开关机后，持续时间
	 * 
	 * @return long
	 */
	public long getSetModeDuration();

	/**
	 * 获取 帧内序号 0~15
	 * 
	 * @return int
	 */
	public int getSequence();

	/**
	 * 获取 操作结果
	 * 
	 * @return String
	 */
	public String getResult();

	/**
	 * 获取 风速 [weak/middle/strong/auto]
	 * 
	 * @return String
	 */
	// 盒子用到
	public String getWindSpeed();

	/**
	 * 获取 模式 [fullheat/direct/indoor/auto]
	 * 
	 * @return String
	 */
	// 盒子用到
	public String getMode();

	/**
	 * 获取电源 0 关，1 开
	 * 
	 * @return int
	 */
	// 盒子用到
	public int getPower();

	/**
	 * 室内湿度值
	 * 
	 * @return int
	 */
	// 盒子用到
	public int getHumidityIndoor();

	/**
	 * 室外湿度值
	 * 
	 * @return int
	 */
	// 盒子用到
	public int getHumidityOutdoor();

	/**
	 * 室内温度值
	 * 
	 * @return int
	 */
	// 盒子用到
	public int getTemperatureIndoor();

	/**
	 * 室外温度值
	 * 
	 * @return int
	 */
	// 盒子用到
	public int getTemperatureOutdoor();

	/**
	 * 室内CO2浓度
	 * 
	 * @return int
	 */
	// 盒子用到
	public int getCO2Indoor();

	/**
	 * 是否待机
	 * 
	 * @return int
	 */
	public int getSuspendMode();

	/**
	 * 是否有定时开关
	 * 
	 * @return int
	 */
	public int getIsTiming();

	/**
	 * 定时开关时间
	 * 
	 * @return int
	 */
	public int getTimingTime();

	/**
	 * 室外风机转速*10为实际转速，无此项时为1
	 * 
	 * @return int
	 */
	public int getOuterFanSpeed();

	/**
	 * 室内风机转速*10为实际转速，无此项时为1
	 * 
	 * @return int
	 */
	public int getInnerFanSpeed();

	/**
	 * 室内实际温度有效
	 * 
	 * @return int
	 */
	public int getInnerTempratureValid();

	/**
	 * 室内实际湿度有效
	 * 
	 * @return int
	 */
	public int getInnerHumidityValid();

	/**
	 * 室内侧二氧化碳 值 有效
	 * 
	 * @return int
	 */
	public int getInnerco2DensityValid();

	/**
	 * 室外侧温度有效
	 * 
	 * @return int
	 */
	public int getOuterTempratureValid();

	/**
	 * 室外侧湿度有效
	 * 
	 * @return int
	 */
	public int getOuterHumidityValid();

	/**
	 * 过滤网更换提示
	 * 
	 * @return int
	 */
	public int getFilterIfReplace();

	/**
	 * 室外风机故障
	 * 
	 * @return int
	 */
	public int getOuterFanIfFault();

	/**
	 * 室内风机故障
	 * 
	 * @return int
	 */
	public int getInnerFanIfFault();

	/**
	 * 室外侧温度传感器故障
	 * 
	 * @return int
	 */
	public int getOuterTemperatureSensorIfFault();

	/**
	 * 室外侧湿度传感器故障
	 * 
	 * @return int
	 */
	public int getOuterHumiditySensorIfFault();

	/**
	 * 二氧化碳传感器故障
	 * 
	 * @return int
	 */
	public int getCo2SensorIfFault();

	/**
	 * 室内侧温度传感器故障
	 * 
	 * @return int
	 */
	public int getInnerTemperatureSensorFault();

	/**
	 * 室内侧湿度传感器故障
	 * 
	 * @return int
	 */
	public int getInnerHumiditySensorFault();

	/******************************** 功能使能查询及设置 ********************************************/
	// *************************** getFNEN ***************************
	/**
	 * 风量支持档位数
	 * 
	 * @return int
	 */
	public int getSpeedSupportNumberFN();

	/**
	 * 全热换气模式
	 * 
	 * @return int
	 */
	public int getfullheatModeFN();

	/**
	 * 直通换气模式
	 * 
	 * @return int
	 */
	public int getDirectModeFN();

	/**
	 * 室内回旋模式
	 * 
	 * @return int
	 */
	public int getIndoorModeFN();

	/**
	 * 普通定时模式
	 * 
	 * @return int
	 */
	public int getTiming();

	/**
	 * 开关机控制位
	 * 
	 * @return int
	 */
	public int getPowerFN();

	/**
	 * EPPROM
	 * 
	 * @return int
	 */
	public int getIfUpdateEEPROM();

	/**
	 * 电量检测
	 * 
	 * @return int
	 */
	public int getbatteryIFdetection();
}
