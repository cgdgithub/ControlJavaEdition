package com.xinlianfeng.android.livehome.devices.dehumidifier;

public interface IDehumidifierControl {

	/*********************************** Box设置 *******************************************/
	/**
	 * Box 设置功能:开关机[0/1], 模式[continue/normal/auto]，风量[weak/strong/auto]，湿度[0-100]，提示声[0/1]
	 * 
	 * @param power
	 *            [0/1]
	 * @param mode
	 *            [continue/normal/auto]
	 *            约束关系备注：
	 *            1、auto模式下 风速auto 湿度50
	 *            2、continue模式下 湿度设置无效，暂时 湿度默认50
	 * @param windSpeed
	 *            [weak/strong/auto]
	 * @param humidity
	 *            [0-100]
	 *            约束关系备注：
	 *            1、湿度范围：30-80
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setBoxAirDehumidifier(int power, String mode, String windSpeed, int humidity, int soundSet);

	/*********************************** 功能设置 *******************************************/
	/**
	 * 1 电源 power : 0关，1开 soundSet : 0无声音，1开声音
	 * 
	 * @param power
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setPower(int power, int soundSet);

	/**
	 * 风速 设置功能:风量[weak/strong/auto]，提示声[0/1]
	 * 
	 * @param windSpeed
	 *            [weak/strong/auto]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setWindSpeed(String windSpeed, int soundSet);

	/**
	 * 模式 设置功能:模式[continue/normal/auto]，提示声[0/1]
	 * 
	 * @param mode
	 *            [continue/normal/auto]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setMode(String mode, int soundSet);

	/**
	 * 定时开关机 设置功能：定时有效位[0/1],Val=0,取消定时,val[1~20],定时val*0.5小时,val=[21~34]定时10+(val-20) 小时,提示声[0/1]
	 * 
	 * @param timingEnable
	 *            [0/1]
	 * @param timingValue
	 *            Val=0,取消定时,val[1~20],定时val*0.5小时,val=[21~34]定时10+(val-20) 小时
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setTimingSwitchMachine(int timingEnable, int timingValue, int soundSet);

	/**
	 * 湿度 湿度值 设置功能:加湿机设置[40/80]，提示声[0/1]
	 * 
	 * @param humidityValue
	 *            [30/80]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setHumidityValue(int humidityValue, int soundSet);

	/**
	 * 温度 设置功能 ：温度值[18-30]，提示声[0/1]
	 * 
	 * @param temperature
	 *            [18-30]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setTemperature(int temperature, int soundSet);

	/**
	 * 电加热 开关 设置功能:电加热[0/1]，提示声[0/1]
	 * 
	 * @param electricalHeating
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setElectricalHeating(int electricalHeating, int soundSet);

	/**
	 * 水泵 开关 设置功能:水泵[0/1]，提示声[0/1]
	 * 
	 * @param waterPump
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setWaterPumpPower(int waterPump, int soundSet);

	/**
	 * 负离子 开关 设置功能:负离子 开关[0/1]，提示声[0/1]
	 * 
	 * @param anionPower
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setAnionPower(int anionPower, int soundSet);

	/*********************************** 状态查询 *******************************************/
	// 暂时只有盒子用
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

	// 盒子用到
	/**
	 * 获取 设置模式后，持续时间
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

	// 盒子用到
	/**
	 * 获取 风量[weak/strong/auto]
	 * 
	 * @return
	 */
	public String getWindSpeed();

	// 盒子用到
	/**
	 * 获取 模式[continue/normal/auto]
	 * 
	 * @return
	 */
	public String getMode();

	// 盒子用到
	/**
	 * 获取电源 0 关，1 开
	 * 
	 * @return
	 */
	public int getPower();

	// 盒子用到
	/**
	 * 湿度 设置值
	 * 
	 * @return int
	 */
	public int getHumidityValueSet();

	// 盒子用到
	/**
	 * 室内湿度值
	 * 
	 * @return int
	 */
	public int getHumidityValueIndoor();

	/**
	 * 定时开关机是否有效
	 * 
	 * @return int
	 */
	public int getTimeValid();

	/**
	 * 定时开关机时间
	 * 
	 * @return String
	 */
	public String getTimerValue();

	/**
	 * 电加热 开关设定
	 * 
	 * @return int
	 */
	public int getEletricalHeating();

	/**
	 * 室内实际温度
	 * 
	 * @return int
	 */
	public int getIndoorTempStatus();

	/**
	 * 水泵开关
	 * 
	 * @return int
	 */
	public int getWaterPumpStatus();

	/**
	 * 负离子开关
	 * 
	 * @return int
	 */
	public int getAnionStatus();

	/**
	 * 过滤网清洁告警
	 * 
	 * @return int
	 */
	public int getFilterNetCleanWarning();

	/**
	 * 湿度传感器故障
	 * 
	 * @return int
	 */
	public int getHumidSensorError();

	/**
	 * 管温传感器故障
	 * 
	 * @return int
	 */
	public int getPumpTempratureError();

	/**
	 * 室内温度传感器故障
	 * 
	 * @return int
	 */
	public int getIndoorTempratureError();

	/**
	 * 水满警告
	 * 
	 * @return int
	 */
	public int getWaterFullWarning();

	/**
	 * 水泵故障
	 * 
	 * @return int
	 */
	public int getWaterPumpWarning();

	/******************************** 功能使能查询及设置 ********************************************/
	// *************************** getFNEN ***************************
	/**
	 * 智慧风
	 * 
	 * @return int
	 */
	public int getSmartWindFN();

	/**
	 * 高风
	 * 
	 * @return int
	 */
	public int getHighWindFN();

	/**
	 * 中风
	 * 
	 * @return int
	 */
	public int getMediumWindFN();

	/**
	 * 低风
	 * 
	 * @return int
	 */
	public int getLowWindFN();

	/**
	 * 运行模式 持续运行
	 * 
	 * @return int
	 */
	public int getContinueModeFN();

	/**
	 * 运行模式 正常运行
	 * 
	 * @return int
	 */
	public int getNormalModeFN();

	/**
	 * 运行模式 自动运行
	 * 
	 * @return int
	 */
	public int getAutoModeFN();

	/**
	 * 定时
	 * 
	 * @return int
	 */
	public int getTimerControlFN();

	/**
	 * 电加热
	 * 
	 * @return int
	 */
	public int getElectricHeatFN();

	/**
	 * 电加热 温度
	 * 
	 * @return int
	 */
	public int getElectricHeatSetTemperatureFN();

	/**
	 * 室内湿度
	 * 
	 * @return int
	 */
	public int getIndoorHumidityFN();

	/**
	 * 水泵
	 * 
	 * @return int
	 */
	public int getWaterPumpFN();

	/**
	 * 负离子
	 * 
	 * @return int
	 */
	public int getAnionFN();

	/**
	 * 电量检测
	 * 
	 * @return int
	 */
	public int getElectronicDetectFN();

	/**
	 * 电源
	 * 
	 * @return int
	 */
	public int getPowerFN();

	/**
	 * EEPROM可改写功能
	 * 
	 * @return int int
	 */
	public int getEEPROMWriteFN();
}
