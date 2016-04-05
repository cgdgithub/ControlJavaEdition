package com.xinlianfeng.android.livehome.devices.sensorsfourinone;

public interface ISensorsFourInOneControl {

	/**
	 * PM2.5开关设置 设置功能：power[1]
	 * 
	 * @param power
	 *            [1]
	 * @return byte[]
	 */
	public byte[] setPM2_5Power(int power);

	/**
	 * 传感器电源控制 切断 上电 电源控制：power[0/1] 传感器ID: [1 温度, 2湿度, 3 甲醛, 4 PM2.5, 5 CO2]
	 * 
	 * @param power
	 *            [0/1]
	 * @param sensorID
	 *            [1 温度、2湿度、3 甲醛、4 PM2.5]
	 * @return byte[]
	 */
	public byte[] setSensorsPower(int power, int sensorID);

	/**
	 * 主动上报频率设置 是否设置上报频率：responseFrequencyValid[0/1] 传感器ID responseID : [1 温度、2湿度、3 甲醛、4 PM2.5] 上报频率(单位
	 * 秒)：responseFrequency
	 * 
	 * @param responseFrequencyValid
	 *            [0/1]
	 * @param responseID
	 *            [1 温度、2湿度、3 甲醛、4 PM2.5]
	 * @param responseFrequency
	 *            上报频率(单位 秒)
	 * @return byte[]
	 */
	public byte[] setResponseFrequency(int responseFrequencyValid, int responseID, int responseFrequency);

	/*************************************** 状态查询 *************************************************/
	/**
	 * 获取 温度传感器ID
	 * 
	 * @return int
	 */
	public int getTemperatureSensorID();

	/**
	 * 获取 温度值是否有效
	 * 
	 * @return int
	 */
	public int getTemperatureValueValid();

	/**
	 * 获取 温度传感器电源状态
	 * 
	 * @return int
	 */
	public int getTemperatureSensorPowerStatus();

	/**
	 * 获取 上次读温度值时间
	 * 
	 * @return int
	 */
	public int getTemperatureInterval();

	/**
	 * 获取 温度值
	 * 
	 * @return int
	 */
	public float getTemperatureValue();

	/**
	 * 获取 湿度传感器ID
	 * 
	 * @return int
	 */
	public int getHumiditySensorID();

	/**
	 * 获取 湿度值是否有效
	 * 
	 * @return int
	 */
	public int getHumidityValueValid();

	/**
	 * 获取 湿度传感器电源状态
	 * 
	 * @return int
	 */
	public int getHumiditySensorPowerStatus();

	/**
	 * 获取 上次读湿度值时间
	 * 
	 * @return int
	 */
	public int getHumidityInterval();

	/**
	 * 获取 湿度值
	 * 
	 * @return int
	 */
	public int getHumidityValue();

	/**
	 * 获取 甲醛传感器ID
	 * 
	 * @return int
	 */
	public int getH2COSensorID();

	/**
	 * 获取 甲醛值是否有效
	 * 
	 * @return int
	 */
	public int getH2COValueValid();

	/**
	 * 获取 甲醛传感器电源状态
	 * 
	 * @return int
	 */
	public int getH2COSensorPowerStatus();

	/**
	 * 获取 上次读甲醛值时间
	 * 
	 * @return int
	 */
	public int getH2COInterval();

	/**
	 * 获取 甲醛值
	 * 
	 * @return float
	 */
	public float getH2COValue();

	/**
	 * 获取 PM2.5传感器ID
	 * 
	 * @return int
	 */
	public int getPM2_5SensorID();

	/**
	 * 获取 PM2.5值是否有效
	 * 
	 * @return int
	 */
	public int getPM2_5ValueValid();

	/**
	 * 获取 PM2.5传感器电源状态
	 * 
	 * @return int
	 */
	public int getPM2_5SensorPowerStatus();

	/**
	 * 获取 上次读PM2.5值时间
	 * 
	 * @return int
	 */
	public int getPM2_5Interval();

	/**
	 * 获取 PM2.5值
	 * 
	 * @return float
	 */
	public float getPM2_5Value();

	/**
	 * 获取 CO2传感器ID
	 * 
	 * @return int
	 */
	public int getCO2SensorID();

	/**
	 * 获取 CO2值是否有效
	 * 
	 * @return int
	 */
	public int getCO2ValueValid();

	/**
	 * 获取 CO2传感器电源状态
	 * 
	 * @return int
	 */
	public int getCO2SensorPowerStatus();

	/**
	 * 获取 上次读CO2值时间
	 * 
	 * @return int
	 */
	public int getCO2Interval();

	/**
	 * 获取 CO2值
	 * 
	 * @return int
	 */
	public int getCO2Value();

	/**
	 * 转换板通信错误
	 * 
	 * @return
	 *         0为正常，1为通信错误
	 */
	public int getIsPeripheralsCommunicationError();
}
