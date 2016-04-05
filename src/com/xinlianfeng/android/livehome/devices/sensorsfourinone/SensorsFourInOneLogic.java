package com.xinlianfeng.android.livehome.devices.sensorsfourinone;

import com.xinlianfeng.android.livehome.devices.base.DevicesLogic;

public class SensorsFourInOneLogic extends DevicesLogic {

	/** 四合一传感器 设备类型 */
	private static final int SENSORS_FOUR_IN_ONE_TYPE = 0x53;
	/** 四合一传感器 设备地址 */
	private static final int SENSORS_FOUR_IN_ONE_ADDRESS = 0x01;

	/** 设置PM25 key */
	private static final String SET_PM25_POWER = "SetPm25";
	/** 传感器ID号 key */
	private static final String SENSOR_ID = "senserID";

	/** 温度传感器ID key */
	private static final String TEMPERATURE_SENSOR_ID = "TempID";
	/** 温度值是否有效 key */
	private static final String TEMPERATURE_VALUE_VALID = "Tempvalid";
	/** 温度传感器电源状态 key */
	private static final String TEMPERATURE_POWER_STATUS = "TempPower";
	/** 上次读温度值时间 key */
	private static final String TEMPERATURE_INTERVAL = "TempInterval";
	/** 温度值 key */
	private static final String TEMPERATURE_VALUE = "TempVal";

	/** 湿度传感器ID key */
	private static final String HUMIDITY_SENSOR_ID = "HumiID";
	/** 湿度值是否有效 key */
	private static final String HUMIDITY_VALUE_VALID = "Humivalid";
	/** 湿度传感器电源状态 key */
	private static final String HUMIDITY_POWER_STATUS = "HumiPower";
	/** 上次读湿度值时间 key */
	private static final String HUMIDITY_INTERVAL = "HumiInterval";
	/** 湿度值 key */
	private static final String HUMIDITY_VALUE = "HumiVal";

	/** 甲醛传感器ID key */
	private static final String H2CO_SENSOR_ID = "H2COID";
	/** 甲醛值是否有效 key */
	private static final String H2CO_VALUE_VALID = "H2COvalid";
	/** 甲醛传感器电源状态 key */
	private static final String H2CO_POWER_STATUS = "H2COPower";
	/** 上次读甲醛值时间 key */
	private static final String H2CO_INTERVAL = "H2COInterval";
	/** 甲醛值 key */
	private static final String H2CO_VALUE = "H2COVal";

	/** PM2.5传感器ID key */
	private static final String PM2_5_SENSOR_ID = "Pm25ID";
	/** PM2.5是否有效 key */
	private static final String PM2_5_VALUE_VALID = "Pm25valid";
	/** PM2.5传感器电源状态 key */
	private static final String PM2_5_POWER_STATUS = "Pm25Power";
	/** 上次读PM2.5值时间 key */
	private static final String PM2_5_INTERVAL = "Pm25Interval";
	/** PM2.5值 key */
	private static final String PM2_5_VALUE = "Pm25Val";

	/** CO2传感器ID key */
	private static final String CO2_SENSOR_ID = "C02ID";
	/** CO2是否有效 key */
	private static final String CO2_VALUE_VALID = "C02valid";
	/** CO2传感器电源状态 key */
	private static final String CO2_POWER_STATUS = "C02Power";
	/** 上次读CO2值时间 key */
	private static final String CO2_INTERVAL = "C02Interval";
	/** CO2值 key */
	private static final String CO2_VALUE = "C02Val";

	// 新增key
	/** 是否设置上报频率 */
	private static final String RESPONSE_FREQUENCY_VALID = "RepFreqSet";
	/** 要上报的sensor ID,255表示所有的 */
	private static final String RESPONSE_FREQUENCY_ID = "RepID";
	/** 上报频率 单位(秒) */
	private static final String RESPONSE_FREQUENCY = "RepFreq";
	// 新增 2015.11.20
	/** 转换板通信错误 */
	private static final String COMMUNICATION_ERROR_KEY = "PeriComErr";

	public SensorsFourInOneLogic() {
		CMD_SET_KEY = "SenserSet";
		CMD_QUERY_STATUS_KEY = "SenserQuery";
		DEVICE_TYPE = SENSORS_FOUR_IN_ONE_TYPE;
		DEVICE_SUB_ADDRESS = SENSORS_FOUR_IN_ONE_ADDRESS;
	}

	/*************************************** 功能设置 *************************************************/
	/** PM2.5开关设置 设置功能：power[1] */
	public byte[] setPM2_5Power(int power) {
		String command = formatStringToJSONSetCmd(SET_PM25_POWER, power);
		return createNetBytes(command);
	}

	/** 传感器电源控制 切断 上电 电源控制：power[0/1] 传感器ID sensorID : [1 温度, 2湿度, 3 甲醛, 4 PM2.5, 5 CO2] */
	public byte[] setSensorsPower(int power, int sensorID) {
		String command = formatStringToJSONSetCmd(POWER_KEY, power, SENSOR_ID, sensorID);
		return createNetBytes(command);
	}

	/**
	 * 主动上报频率设置 是否设置上报频率：responseFrequencyValid[0/1] 传感器ID responseID : [1 温度、2湿度、3 甲醛、4 PM2.5] 上报频率(单位
	 * 秒)：responseFrequency
	 */
	public byte[] setResponseFrequency(int responseFrequencyValid, int responseID, int responseFrequency) {
		String command = formatStringToJSONSetCmd(RESPONSE_FREQUENCY_VALID, responseFrequencyValid,
				RESPONSE_FREQUENCY_ID, responseID, RESPONSE_FREQUENCY, RESPONSE_FREQUENCY);
		return createNetBytes(command);
	}

	/*************************************** 状态查询 *************************************************/
	/** 获取 温度传感器ID */
	public int getTemperatureSensorID() {
		return getStatusInt(TEMPERATURE_SENSOR_ID);
	}

	/** 获取 温度值是否有效 */
	public int getTemperatureValueValid() {
		return getStatusInt(TEMPERATURE_VALUE_VALID);
	}

	/** 获取 温度传感器电源状态 */
	public int getTemperatureSensorPowerStatus() {
		return getStatusInt(TEMPERATURE_POWER_STATUS);
	}

	/** 获取 上次读温度值时间 */
	public int getTemperatureInterval() {
		return getStatusInt(TEMPERATURE_INTERVAL);
	}

	/** 获取 温度值 除以100 */
	public float getTemperatureValue() {
		float temperatureValue = (float) getStatusInt(TEMPERATURE_VALUE);
		return temperatureValue == -1 ? -1 : (temperatureValue / 100);
	}

	/** 获取 湿度传感器ID */
	public int getHumiditySensorID() {
		return getStatusInt(HUMIDITY_SENSOR_ID);
	}

	/** 获取 湿度值是否有效 */
	public int getHumidityValueValid() {
		return getStatusInt(HUMIDITY_VALUE_VALID);
	}

	/** 获取 湿度传感器电源状态 */
	public int getHumiditySensorPowerStatus() {
		return getStatusInt(HUMIDITY_POWER_STATUS);
	}

	/** 获取 上次读湿度值时间 */
	public int getHumidityInterval() {
		return getStatusInt(HUMIDITY_INTERVAL);
	}

	/** 获取 湿度值 */
	public int getHumidityValue() {
		return getStatusInt(HUMIDITY_VALUE);
	}

	/** 获取 甲醛传感器ID */
	public int getH2COSensorID() {
		return getStatusInt(H2CO_SENSOR_ID);
	}

	/** 获取 甲醛值是否有效 */
	public int getH2COValueValid() {
		return getStatusInt(H2CO_VALUE_VALID);
	}

	/** 获取 甲醛传感器电源状态 */
	public int getH2COSensorPowerStatus() {
		return getStatusInt(H2CO_POWER_STATUS);
	}

	/** 获取 上次读甲醛值时间 */
	public int getH2COInterval() {
		return getStatusInt(H2CO_INTERVAL);
	}

	/** 获取 甲醛值 除以1000 */
	public float getH2COValue() {
		float H2COValue = (float) getStatusInt(H2CO_VALUE);
		return H2COValue == -1 ? -1 : (H2COValue / 1000);
	}

	/** 获取 PM2.5传感器ID */
	public int getPM2_5SensorID() {
		return getStatusInt(PM2_5_SENSOR_ID);
	}

	/** 获取 PM2.5值是否有效 */
	public int getPM2_5ValueValid() {
		return getStatusInt(PM2_5_VALUE_VALID);
	}

	/** 获取 PM2.5传感器电源状态 */
	public int getPM2_5SensorPowerStatus() {
		return getStatusInt(PM2_5_POWER_STATUS);
	}

	/** 获取 上次读PM2.5值时间 */
	public int getPM2_5Interval() {
		return getStatusInt(PM2_5_INTERVAL);
	}

	/** 获取 PM2.5值 除以100 */
	public float getPM2_5Value() {
		float PM2_5Value = (float) getStatusInt(PM2_5_VALUE);
		return PM2_5Value == -1 ? -1 : (PM2_5Value / 100);
	}

	/** 获取 CO2传感器ID */
	public int getCO2SensorID() {
		return getStatusInt(CO2_SENSOR_ID);
	}

	/** 获取 CO2值是否有效 */
	public int getCO2ValueValid() {
		return getStatusInt(CO2_VALUE_VALID);
	}

	/** 获取 CO2传感器电源状态 */
	public int getCO2SensorPowerStatus() {
		return getStatusInt(CO2_POWER_STATUS);
	}

	/** 获取 上次读CO2值时间 */
	public int getCO2Interval() {
		return getStatusInt(CO2_INTERVAL);
	}

	/** 获取 CO2值 */
	public int getCO2Value() {
		return getStatusInt(CO2_VALUE);
	}

	/**
	 * 转换板通信错误
	 * 
	 * @return
	 *         0为正常，1为通信错误
	 */
	public int getIsPeripheralsCommunicationError() {
		return getStatusInt(COMMUNICATION_ERROR_KEY);
	}

}
