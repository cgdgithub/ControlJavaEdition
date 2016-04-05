package com.xinlianfeng.android.livehome.devices.airfan;

import com.xinlianfeng.android.livehome.devices.base.DevicesLogic;

public class AirFanLogic extends DevicesLogic {

	/** 新风机设备类型 */
	private static final int AIRFAN_TYPE = 0x19;
	/** 新风机设备地址 */
	private static final int AIRFAN_ADDRESS = 0x01;

	// 新风机 命 令 key:
	/** 查询 */
	/** 模式 */
	private static final String MODE_KEY = "Mode";
	/** 风速 */
	private static final String WIND_SPEED_KEY = "WindSpeed";
	/** 室内湿度 */
	private static final String HUMIDITY_INDOOR_KEY = "InHumi";
	/** 室内温度 */
	private static final String TEMPERATURE_INDOOR_KEY = "InTemp";
	/** 室外温度 */
	private static final String TEMPERATURE_OUTDOOR_KEY = "OutTemp";
	/** 室外湿度 */
	private static final String HUMIDITY_OUTDOOR_KEY = "OutHumi";
	/** 室内CO2浓度 */
	private static final String CO2_INDOOR_KEY = "Co2Val";
	/** 定时有效 */
	private static final String TIMING_VALID_KEY = "Timing";
	/** 定时值 */
	private static final String TIMING_VALUE_KEY = "TimingVal";

	public AirFanLogic() {
		CMD_SET_KEY = "FanSet";
		CMD_QUERY_STATUS_KEY = "FanQuery";
		CMD_QUERY_FUNCTION_KEY = "FanFctn";
		DEVICE_TYPE = AIRFAN_TYPE;
		DEVICE_SUB_ADDRESS = AIRFAN_ADDRESS;
	}

	/*********************************** Box设置 *******************************************/
	/** Box 设置功能:开关机[0/1], 模式[fullheat/direct/indoor/auto]，风量[weak/middle/strong/auto]，提示声[0/1] */
	public byte[] setBoxAirFan(int power, String mode, String windSpeed, int soundSet) {
		String command = formatStringToJSONSetCmd(POWER_KEY, power, MODE_KEY, mode, WIND_SPEED_KEY, windSpeed,
				SOUND_KEY, soundSet);
		if (power != getPower()) { // 与当前状态不同，重新计时
			setPowerOnCurrentTime = System.currentTimeMillis(); // 设置开关机 当前时间
		}
		setStatusSave(POWER_KEY, power);
		setStatusSave(MODE_KEY, mode);
		setStatusSave(WIND_SPEED_KEY, windSpeed);
		setStatusSave(SOUND_KEY, soundSet);
		return createNetBytes(command);
	}

	/********************************** 功能设置 *******************************************/
	/** 电源 power : 设置功能:开机[0/1]，提示声[0/1] */
	public byte[] setPower(int power, int soundSet) {
		String command = formatStringToJSONSetCmd(POWER_KEY, power, SOUND_KEY, soundSet);
		setStatusSave(POWER_KEY, power); // 设置电源状态
		return createNetBytes(command);
	}

	/** 风速 设置功能:风量[weak/middle/strong/auto]，提示声[0/1] */
	public byte[] setWindSpeed(String windSpeed, int soundSet) {
		String command = formatStringToJSONSetCmd(WIND_SPEED_KEY, windSpeed, SOUND_KEY, soundSet);
		setStatusSave(WIND_SPEED_KEY, windSpeed);
		return createNetBytes(command);
	}

	/** 模式 设置功能:模式[fullheat/direct/indoor/auto]，提示声[0/1] */
	public byte[] setMode(String mode, int soundSet) {
		String command = formatStringToJSONSetCmd(MODE_KEY, mode, SOUND_KEY, soundSet);
		setStatusSave(MODE_KEY, mode);
		return createNetBytes(command);
	}

	/**
	 * 定时开关机 设置功能:普通定时开关机[0.5h-23h],普通定时有效位[0/1]，提示声[0/1]
	 * 定时时间格式严格为[1.0h,2.0h,3.0h,4.0h,5.0h,6.0h,7.0h,8.0h,9.0h,10h,11h,12h,13h,14,15h,16,17h,18h,19h,20h,21h,22,23h],
	 */
	public byte[] setTimingSwitchMachine(int timingEnable, int timingValue, int soundSet) {
		String command = formatStringToJSONSetCmd(TIMING_VALID_KEY, timingEnable, TIMING_VALUE_KEY, timingValue,
				SOUND_KEY, soundSet);
		setStatusSave(TIMING_VALID_KEY, timingEnable);
		setStatusSave(TIMING_VALUE_KEY, timingValue);
		return createNetBytes(command);
	}

	/***************************************** 解析方法 ******************************************/
	/** 解析查询的状态/功能 */
	public String parseByteToJSON(byte[] recv) {
		String parseResult = super.parseByteToJSON(recv);
		// 计时相关处理
		if (getPower() == 1) { // 与当前状态不同，重新计时
			if (timePowerOnUpdateFlag) {
				setPowerOnCurrentTime = System.currentTimeMillis(); // 设置开机 当前时间
				timePowerOnUpdateFlag = false;
				setPowerOffCurrentTime = 0; //
			}
		} else {
			if (!timePowerOnUpdateFlag) {
				setPowerOnCurrentTime = 0; //
				setPowerOffCurrentTime = System.currentTimeMillis(); // 设置关机 当前时间
				timePowerOnUpdateFlag = true;
			}
		}
		// 获取 模式[cleardust/clearsmell/smart/mute/sleep]
		if (getMode().equals("cleardust")) {
			if (!lastMode.equals("cleardust")) {
				lastMode = getMode();
				setModeCurrentTime = System.currentTimeMillis(); // 设置模式 当前时间
			}
		} else if (getMode().equals("clearsmell")) {
			if (!lastMode.equals("clearsmell")) {
				lastMode = getMode();
				setModeCurrentTime = System.currentTimeMillis(); // 设置模式 当前时间
			}
		} else if (getMode().equals("smart")) {
			if (!lastMode.equals("smart")) {
				lastMode = getMode();
				setModeCurrentTime = System.currentTimeMillis(); // 设置模式 当前时间
			}
		} else if (getMode().equals("mute")) {
			if (!lastMode.equals("mute")) {
				lastMode = getMode();
				setModeCurrentTime = System.currentTimeMillis(); // 设置模式 当前时间
			}
		} else if (getMode().equals("sleep")) {
			if (!lastMode.equals("sleep")) {
				lastMode = getMode();
				setModeCurrentTime = System.currentTimeMillis(); // 设置模式 当前时间
			}
		}
		return parseResult;
	}

	/********************************** 状态查询 *******************************************/
	// 盒子用
	/** 获取 设置开关机后，持续时间 */
	public long getSetPowerOnDuration() {
		if (setPowerOnCurrentTime == 0) {
			return durationTimeError;
		}
		durationTime = System.currentTimeMillis() - setPowerOnCurrentTime;
		return durationTime;
	}

	// 盒子用
	/** 获取 设置关机后，持续时间 */
	public long getSetPowerOffDuration() {
		if (setPowerOffCurrentTime == 0) {
			return durationTimeError;
		}
		durationTime = System.currentTimeMillis() - setPowerOffCurrentTime;
		return durationTime;
	}

	// 盒子用
	/** 获取 设置模式后，持续时间 */
	public long getSetModeDuration() {
		if (setModeCurrentTime == 0) {
			return durationTimeError;
		}
		durationTime = System.currentTimeMillis() - setModeCurrentTime;
		return durationTime;
	}

	/** 获取 帧内序号 0~15 */
	public int getSequence() {
		return getStatusInt(SEQUENCE_KEY);
	}

	/** 获取 操作结果 */
	public String getResult() {
		return getStatusString(RESULT_KEY);
	}

	// 盒子用到
	/** 获取 风速 [weak/middle/strong/auto] */
	public String getWindSpeed() {
		return getStatusString(WIND_SPEED_KEY);
	}

	// 盒子用到
	/** 获取 模式 [fullheat/direct/indoor/auto] */
	public String getMode() {
		return getStatusString(MODE_KEY);
	}

	// 盒子用到
	/** 获取电源 0 关，1 开 */
	public int getPower() {
		return getStatusInt(POWER_KEY);
	}

	// 盒子用到
	/** 室内湿度值 */
	public int getHumidityIndoor() {
		return getStatusInt(HUMIDITY_INDOOR_KEY);
	}

	// 盒子用到
	/** 室外湿度值 */
	public int getHumidityOutdoor() {
		return getStatusInt(HUMIDITY_OUTDOOR_KEY);
	}

	// 盒子用到
	/** 室内温度值 */
	public int getTemperatureIndoor() {
		return getStatusInt(TEMPERATURE_INDOOR_KEY);
	}

	// 盒子用到
	/** 室外温度值 */
	public int getTemperatureOutdoor() {
		return getStatusInt(TEMPERATURE_OUTDOOR_KEY);
	}

	// 盒子用到
	/** 室内CO2浓度 */
	public int getCO2Indoor() {
		return getStatusInt(CO2_INDOOR_KEY);
	}

	/** 是否待机 */
	public int getSuspendMode() {
		return getStatusInt("StandBy");
	}

	/** 是否有定时开关 */
	public int getIsTiming() {
		return getStatusInt(TIMING_VALID_KEY);
	}

	/** 定时开关时间 */
	public int getTimingTime() {
		return getStatusInt(TIMING_VALUE_KEY);
	}

	/** 室外风机转速*10为实际转速，无此项时为1 */
	public int getOuterFanSpeed() {
		return getStatusInt("OutMotorSpeed");
	}

	/** 室内风机转速*10为实际转速，无此项时为1 */
	public int getInnerFanSpeed() {
		return getStatusInt("InMotorSpeed");
	}

	/** 室内实际温度有效 */
	public int getInnerTempratureValid() {
		return getStatusInt("InTempValid");
	}

	/** 室内实际湿度有效 */
	public int getInnerHumidityValid() {
		return getStatusInt("InHumiValid");
	}

	/** 室内侧二氧化碳 值 有效 */
	public int getInnerco2DensityValid() {
		return getStatusInt("Co2ValValid");
	}

	/** 室外侧温度有效 */
	public int getOuterTempratureValid() {
		return getStatusInt("OutTempValid");
	}

	/** 室外侧湿度有效 */
	public int getOuterHumidityValid() {
		return getStatusInt("OutHumiValid");
	}

	/** 过滤网更换提示 */
	public int getFilterIfReplace() {
		return getStatusInt("steamStrainer");
	}

	/** 室外风机故障 */
	public int getOuterFanIfFault() {
		return getStatusInt("OutWindMotorErr");
	}

	/** 室内风机故障 */
	public int getInnerFanIfFault() {
		return getStatusInt("InWindMotorErr");
	}

	/** 室外侧温度传感器故障 */
	public int getOuterTemperatureSensorIfFault() {
		return getStatusInt("OutTempSnrErr");
	}

	/** 室外侧湿度传感器故障 */
	public int getOuterHumiditySensorIfFault() {
		return getStatusInt("OutHumiSnrErr");
	}

	/** 二氧化碳传感器故障 */
	public int getCo2SensorIfFault() {
		return getStatusInt("Co2SnrErr");
	}

	/** 室内侧温度传感器故障 */
	public int getInnerTemperatureSensorFault() {
		return getStatusInt("TempSnrErr");
	}

	/** 室内侧湿度传感器故障 */
	public int getInnerHumiditySensorFault() {
		return getStatusInt("HumiSnrErr");
	}

	/******************************** 功能使能查询及设置 ********************************************/
	// *************************** getFNEN ***************************
	/** 风量支持档位数 */
	public int getSpeedSupportNumberFN() {
		return getDeviceFunctionEnable("FWOpt");
	}

	/** 全热换气模式 */
	public int getfullheatModeFN() {
		return getDeviceFunctionEnable("FFullheat");
	}

	/** 直通换气模式 */
	public int getDirectModeFN() {
		return getDeviceFunctionEnable("FDirect");
	}

	/** 室内回旋模式 */
	public int getIndoorModeFN() {
		return getDeviceFunctionEnable("FIndoor");
	}

	/** 普通定时模式 */
	public int getTiming() {
		return getDeviceFunctionEnable("FTimer");
	}

	/** 开关机控制位 */
	public int getPowerFN() {
		return getDeviceFunctionEnable("FPower");
	}

	/** EPPROM */
	public int getIfUpdateEEPROM() {
		return getDeviceFunctionEnable("FEPPROM");
	}

	/** 电量检测 */
	public int getbatteryIFdetection() {
		return getDeviceFunctionEnable("FQCeck");
	}

	// *************************** setFNEN ***************************
	/** 风量支持档位数 */
	public void setSpeedSupportNumberFN(int value) {
		setDeviceFunctionEnable("FWOpt", value);
	}

	/** 全热换气模式 */
	public void setfullheatModeFN(int value) {
		setDeviceFunctionEnable("FFullheat", value);
	}

	/** 直通换气模式 */
	public void setDirectModeFN(int value) {
		setDeviceFunctionEnable("FDirect", value);
	}

	/** 室内回旋模式 */
	public void setIndoorModeFN(int value) {
		setDeviceFunctionEnable("FIndoor", value);
	}

	/** 普通定时模式 */
	public void setTiming(int value) {
		setDeviceFunctionEnable("FTimer", value);
	}

	/** 开关机控制位 */
	public void setPowerFN(int value) {
		setDeviceFunctionEnable("FPower", value);
	}

	/** EPPROM */
	public void setIfUpdateEEPROM(int value) {
		setDeviceFunctionEnable("FEPPROM", value);
	}

	/** 电量检测 */
	public void setbatteryIFdetection(int value) {
		setDeviceFunctionEnable("FQCeck", value);
	}
}
