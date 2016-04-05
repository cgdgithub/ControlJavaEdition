package com.xinlianfeng.android.livehome.devices.aircleaner;

public interface IAirCleanerControl {

	/*********************************** 盒子调用 *******************************************/
	/**
	 * Box 设置功能:开关机[0/1], 模式[cleardust/clearsmell/smart/mute/sleep]，风量[weak/middle /strong/clear/auto]，
	 * 负离子开关[0/1],加湿机开关[0/1]，设置湿度[40/80],提示声[0/1]
	 * 
	 * @param power
	 *            [0/1]
	 * @param mode
	 *            [cleardust/clearsmell/smart/mute/sleep]
	 *            约束关系备注：
	 *            smart/mute/sleep任一模式下，风速不能操作，默认为auto
	 * @param windSpeed
	 *            [weak/middle /strong/clear/auto]
	 * @param anionPower
	 *            [0/1]
	 * @param humidifierPower
	 *            [0/1]
	 * @param humidity
	 *            [40/80]
	 *            约束关系备注：
	 *            湿度值设定只能在40~80之间，超出此范围位错误设定，默认50
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setBoxAirPurifier(int power, String mode, String windSpeed, int anionPower, int humidifierPower,
			int humidity, int soundSet);

	/*********************************** 功能设置 *******************************************/
	/**
	 * 电源 power : 0关，1开 soundSet : 0无声音，1开声音
	 * 
	 * @param power
	 *            0关，1开
	 * @param soundSet
	 *            0无声音，1开声音
	 * @return byte[]
	 */
	public byte[] setPower(int power, int soundSet);

	/**
	 * 风速 设置功能:风量[weak/middle/strong/clear/auto]，提示声[0/1]
	 * 
	 * @param windSpeed
	 *            [weak/middle/strong/clear/auto]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setWindSpeed(String windSpeed, int soundSet);

	/**
	 * 模式 设置功能:模式[cleardust/clearsmell/smart/mute/sleep]，提示声[0/1]
	 * 
	 * @param mode
	 *            [cleardust/clearsmell/smart/mute/sleep]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setMode(String mode, int soundSet);

	/**
	 * 定时开关机 设置功能:普通定时开关机[1-23],普通定时有效位[0/1]，提示声[0/1]
	 * 
	 * @param timingEnable
	 *            [0/1]
	 * @param timingValue
	 *            定时时间格式严格为[0-23]小时，以整小时为单位,0表示取消
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setTimingSwitchMachine(int timingEnable, int timingValue, int soundSet);

	/**
	 * 儿童锁 开关 设置功能:儿童锁[0/1]，提示声[0/1]
	 * 
	 * @param childClockPower
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setChildClockPower(int childClockPower, int soundSet);

	/**
	 * 水离子 开关 设置功能:水离子[0/1]，提示声[0/1]
	 * 
	 * @param waterIonPower
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setWaterIonPower(int waterIonPower, int soundSet);

	/**
	 * 加湿器开关 设置功能:加湿机开关[0/1]，提示声[0/1]
	 * 
	 * @param humidifierPower
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setHumidifierPower(int humidifierPower, int soundSet);

	/**
	 * 加湿 湿度值 设置功能:加湿机设置[40/80]，提示声[0/1]
	 * 
	 * @param humidityValue
	 *            [40/80]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setHumidityValue(int humidityValue, int soundSet);

	/*********************************** 状态查询 *******************************************/
	// 盒子用
	/**
	 * 获取 设置开机后，持续时间
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
	 * 获取 设置模式后，持续时间
	 * 
	 * @return long
	 */
	public long getSetClearDustModeDuration();

	// 盒子用
	/**
	 * 获取 设置模式后，持续时间
	 * 
	 * @return long
	 */
	public long getSetModeDuration();

	// 盒子用
	/**
	 * 获取 加湿，持续时间
	 * 
	 * @return long
	 */
	public long getHumidifyDuration();

	// 盒子用
	/**
	 * 获取 负离子开关，持续时间
	 * 
	 * @return long
	 */
	public long getAnionDuration();

	/**
	 * 获取 帧内序号 0~15
	 * 
	 * @return int
	 */
	public int getSequence();

	/**
	 * 获取 操作结果 SUCCEED
	 * 
	 * @return String
	 */
	public String getResult();

	// 盒子用到
	/**
	 * 获取 风量[weak/middle/strong/clear/auto]
	 * 
	 * @return [weak/middle/strong/clear/auto]
	 */
	public String getWindSpeed();

	// 盒子用到
	/**
	 * 获取 模式[cleardust/clearsmell/smart/mute/sleep]
	 * 
	 * @return [cleardust/clearsmell/smart/mute/sleep]
	 */
	public String getMode();

	// 盒子用到
	/**
	 * 湿度 设置值
	 * 
	 * @return int
	 */
	public int getHumidityValueSet();

	// 盒子用到
	/**
	 * 加湿状态
	 * 
	 * @return int
	 */
	public int getHumidityPower();

	// 盒子用到
	/**
	 * 负离子开关状态
	 * 
	 * @return int
	 */
	public int getAnionPower();

	// 盒子用到
	/**
	 * 室内湿度
	 * 
	 * @return int
	 */
	public int getHumidifyIndoor();

	/**
	 * 定时开关机控制 是否有效
	 * 
	 * @return int
	 */
	public int getTimeStatus();

	/**
	 * 定时开关机时间
	 * 
	 * @return String
	 */
	public String getTimerValue();

	/**
	 * 风机转速
	 * 
	 * @return int
	 */
	public int getMotorSpeed();

	// 盒子用到
	/**
	 * 空气质量, 洁净度 空气质量
	 * 
	 * @return int
	 */
	public int getAirQuality();

	/**
	 * 空气质量百分比
	 * 
	 * @return int
	 */
	public int getAirQualityPercent();

	/**
	 * 相对湿度
	 * 
	 * @return int
	 */
	public int getRelativeHumidityValue();

	// 盒子用到
	/**
	 * 开停净化机, 获取电源 0 关，1 开
	 * 
	 * @return int
	 */
	public int getPower();

	/**
	 * 儿童锁开关控制
	 * 
	 * @return int
	 */
	public int getChildLockStatus();

	/**
	 * 水离子开停控制
	 * 
	 * @return int
	 */
	public int getWaterionStatus();

	/**
	 * 加湿机开停控制
	 * 
	 * @return int
	 */
	public int getHumidityStatus();

	/**
	 * 过滤网更换提示
	 * 
	 * @return int
	 */
	public int getChangeFilterError();

	/**
	 * 加湿转轮故障
	 * 
	 * @return int
	 */
	public int getHumidityWheelError();

	/**
	 * 水箱空
	 * 
	 * @return int
	 */
	public int getWaterSinkEmptyError();

	/**
	 * 水箱未装好
	 * 
	 * @return int
	 */
	public int getWaterSinkNotSetup();

	/**
	 * 湿度传感器故障
	 * 
	 * @return int
	 */
	public int getHumiditySensorError();

	/**
	 * 风机故障
	 * 
	 * @return int
	 */
	public int getMotorError();

	/**
	 * 风尘传感器故障
	 * 
	 * @return int
	 */
	public int getDustSensorError();

	/**
	 * 气味传感器故障
	 * 
	 * @return int
	 */
	public int getSmellSensorError();

	/**
	 * 机器倾斜故障
	 * 
	 * @return int
	 */
	public int getLeanError();

	/**
	 * 湿度设置值
	 * 
	 * @return int
	 */
	public int getSettingHumid();

	/******************************** 功能使能查询及设置 ********************************************/
	// getFNEN
	/**
	 * 净化速度状态-自动功能
	 * 
	 * @return int
	 */
	public int getCleanSpeedAutoFN();

	/**
	 * 净化速度状态-净烟功能
	 * 
	 * @return int
	 */
	public int getCleanSpeedDelSmokeFN();

	/**
	 * 净化速度状态-高风功能
	 * 
	 * @return int
	 */
	public int getCleanSpeedHighFN();

	/**
	 * 净化速度状态-中风功能
	 * 
	 * @return int
	 */
	public int getCleanSpeedMiddleFN();

	/**
	 * 净化速度状态-低风功能
	 * 
	 * @return int
	 */
	public int getCleanSpeedLowFN();

	/**
	 * 净化模式状态-睡眠功能
	 * 
	 * @return int
	 */
	public int getCleanModeSleepFN();

	/**
	 * 净化模式状态-静音功能
	 * 
	 * @return int
	 */
	public int getCleanModeMuteFN();

	/**
	 * 净化模式状态-智能功能
	 * 
	 * @return int
	 */
	public int getCleanModeSmartFN();

	/**
	 * 净化模式状态-除味功能
	 * 
	 * @return int
	 */
	public int getCleanModeDelTasteFN();

	/**
	 * 净化模式状态-除烟功能
	 * 
	 * @return int
	 */
	public int getCleanModeDelSmokeFN();

	/**
	 * 普通定时功能
	 * 
	 * @return int
	 */
	public int getGeneralTimingFN();

	/**
	 * 儿童锁功能
	 * 
	 * @return int
	 */
	public int getChildLockFN();

	/**
	 * 水离子开停
	 * 
	 * @return int
	 */
	public int getWaterIonFN();

	/**
	 * 加湿机开停功能
	 * 
	 * @return int
	 */
	public int getDehumidifierFN();

	/**
	 * 净化机开停功能
	 * 
	 * @return int
	 */
	public int getCleanMachineFN();

	/**
	 * EEPROM可改写功能
	 * 
	 * @return int
	 */
	public int getEEpromReadWriteFN();

	/**
	 * 电量检测功能
	 * 
	 * @return int
	 */
	public int getPowerDetectFN();
}
