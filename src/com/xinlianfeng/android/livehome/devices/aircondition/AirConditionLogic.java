package com.xinlianfeng.android.livehome.devices.aircondition;

import com.xinlianfeng.android.livehome.devices.base.DevicesLogic;

public class AirConditionLogic extends DevicesLogic {

	/** 空调设备类型 */
	private static final int AIRCONDITION_TYPE = 0x1;
	/** 空调设备地址 */
	private static final int AIRCONDITION_ADDRESS = 0x1;

	// 空调 命 令 key:
	/** 查询 */
	private static final String QUERY_KEY = "ACQUERY";
	/** 模式 */
	private static final String MODE_KEY = "Mode";
	/** 风速 */
	private static final String WIND_SPEED_KEY = "WindSpeed";
	/** 温度 */
	private static final String TEMPERATURE_KEY = "SetTemp";
	/** 温度 室内 */
	private static final String TEMPERATURE_INDOOR_KEY = "InTemp";
	/** 温度 室内温度设置 */
	private static final String TEMPERATURE_INDOOR_SET_KEY = "InTempSet";
	/** 温度 室外 */
	private static final String TEMPERATURE_OUTDOOR_KEY = "OutTemp";
	/** 定时有效 */
	private static final String TIMING_VALID_KEY = "Timing";
	/** 定时值 */
	private static final String TIMING_VALUE_KEY = "TimingVal";
	/** 实时时间小时值 */
	private static final String REAL_TIME_HOUR_KEY = "RTHour";
	/** 实时时间分钟值 */
	private static final String REAL_TIME_MINUTE_KEY = "RTMins";
	/** 实时开机 */
	private static final String REAL_TIME_POWER_ON_KEY = "RTPowerOn";
	/** 实时开机小时值 */
	private static final String REAL_TIME_POWER_ON_HOUR_KEY = "RTPowerOnHour";
	/** 实时开机分钟值 */
	private static final String REAL_TIME_POWER_ON_MINUTE_KEY = "RTPowerOnMins";
	/** 实时关机 */
	private static final String REAL_TIME_POWER_OFF_KEY = "RTPowerOff";
	/** 实时关机小时值 */
	private static final String REAL_TIME_POWER_OFF_HOUR_KEY = "RTPowerOffHour";
	/** 实时关机分钟值 */
	private static final String REAL_TIME_POWER_OFF_MINUTE_KEY = "RTPowerOffMins";
	/** 睡眠 */
	private static final String SLEEP_MODE_KEY = "SleepMode";
	/** 节能 */
	private static final String ENERGY_SAVING_KEY = "ECO";
	/** 背景灯 */
	private static final String BACKGROUND_LIGHT_KEY = "BKLight";
	/** 显示屏发光 */
	private static final String SCREEN_LIGHT_KEY = "PanelLight";
	/** LED灯 */
	private static final String LED_LIGHT_KEY = "LED";
	/** 电加热 */
	private static final String ELECTRICAL_HEATING_KEY = "EHeating";
	/** 快速冷热 高效 强力 */
	private static final String HIGH_EFFICIENT_KEY = "Turbo";
	// 新增 key
	/** 并用节电 */
	private static final String AND_POWER_SAVING_KEY = "ShareECO";
	/** 除烟（净化） */
	private static final String CLEAN_SMOKE_KEY = "CleanFog";
	/** 双模 */
	private static final String DUAL_MODE_KEY = "DualMode";
	/** 清新 */
	private static final String FRESH_AIR_KEY = "Fresh";
	/** 语音 */
	private static final String VOICE_KEY = "VoiceCtl";
	/** 静音 */
	private static final String MUTE_KEY = "Quiet";
	/** 除湿 */
	private static final String DEHUMIDIFY_MODE_KEY = "HumiMode";
	/** 自然风 */
	private static final String NATURAL_WIND_KEY = "NWindSet";
	/** 左风摆 */
	private static final String LEFT_WIND_SWING_KEY = "LSwept";
	/** 右风摆 */
	private static final String RIGHT_WIND_SWING_KEY = "RSwept";
	/** 风向 */
	private static final String WIND_DIRECTION_KEY = "WindDir";
	/** 换风控制 */
	private static final String AIR_EXCHANGE_CONTROL_KEY = "CWindCtl";
	/** 换风 */
	private static final String AIR_EXCHANGE_KEY = "ChangeWind";
	/** 亮度 */
	private static final String BRIGHTNESS_KEY = "Brightness";
	/** 智慧眼 */
	private static final String SMART_EYE_KEY = "SmartEye";
	/** 体感控制 */
	private static final String SOMATOSENSORY_CONTROL_KEY = "HumSenCtl";
	/** 体感室内温度 */
	private static final String SOMATOSENSORY_INDOOR_TEMPERATURE_KEY = "HumInnerTemp";
	// /** 体感室内温度 */
	// private static final String SOMATOSENSORY_INDOOR_TEMPERATURE_VALUE_KEY = "ABSHumTempMKP";
	/** 华氏/摄氏切换 */
	private static final String FAHRENHEIT_OR_CELSIUS_SWITCH_KEY = "FahOrCenti";
	/** 室内外温度切换显示 */
	private static final String IN_OUT_SWITCH_SHOW_KEY = "InOutSwhShow";
	/** 室内清洁控制 */
	private static final String INDOOR_CLEAN_CONTROL_KEY = "InCleanCtl";
	/** 室内清洁 */
	private static final String INDOOR_CLEAN_KEY = "InClean";
	/** 室外清洁控制 */
	private static final String OUTDOOR_CLEAN_CONTROL_KEY = "OutCleanCtl";
	/** 室外清洁 */
	private static final String OUTDOOR_CLEAN_KEY = "OutClean";
	/** 室内过滤网清洁复位控制(净化) */
	private static final String INDOOR_FILTER_CLEAN_KEY = "RSTIndrFilter";
	/** 自动和除湿温度补偿 */
	private static final String AUTO_DEHUMI_TEMP_COMPENSATION_KEY = "AutoDehumiTempMKP";
	/** 自动和除湿温度补偿 值 */
	private static final String AUTO_DEHUMI_TEMP_COMPENSATION_VALUE_KEY = "ABSAutoDehumiTempMKP";
	/** 上下风门位置[sweep/auto/#1/#2/#3/#4/#5/#6] */
	private static final String AIR_DOOR_POSITION_KEY = "VSweptMode";

	// 查询 key:
	/** 帧内序号 */
	private static final String SEQUENCE_KEY = "Sequence";
	/** 操作结果 */
	private static final String RESULT_KEY = "Result";
	/** 开关机 功能 key */
	private static final String POWER_FN_KEY = "KeyCtl";
	/** 湿度 */
	private static final String HUMIDITY_KEY = "Humi";
	/** 湿度 设置 */
	private static final String HUMIDITY_SET_KEY = "SetHumi";
	/** 室内实际温度 */
	private static final String INDOOR_REALITY_TEMPERATURE_KEY = "InTemp";
	/** 室内实际湿度 */
	private static final String INDOOR_REALITY_HUMIDITY_KEY = "InHumi";
	/** 室内盘管温度 */
	private static final String INDOOR_COILER_TEMPERATURE_KEY = "InCoilerTemp";
	/** 垂直(上下)导风板位置 */
	private static final String VERTICAL_WIND_POSITION_KEY = "VSweptMode";
	/** 上下风模式 */
	private static final String VERTICAL_WIND_MODE_KEY = "VSweptMode";
	/** 上下风开停控制 */
	private static final String VERTICAL_WIND_POWER_KEY = "VWindSet";
	/** 左右风开停控制 */
	private static final String HORIZONTAL_WIND_POWER_KEY = "HWindSet";
	/** 室内电量板 */
	private static final String INDOOR_ECLECTRIC_QUALITY_BOARD_KEY = "InPwr";
	/** 本次命令之前是否有过红外遥控与按键控制过 */
	private static final String HAD_IR_CONTROL_KEY = "HasIRCtl";
	/** 本次命令之前是否有WIFI控制过 */
	private static final String HAD_WIFI_CONTROL_KEY = "HasWIFICtl";
	/** 室内EEPROM在线升级 */
	private static final String INDOOR_UPDATE_EPM_KEY = "InUpdateEPM";
	/** 室内温度传感器故障 */
	private static final String INDOOR_TEMPERATURE_SENSOR_ERROR_KEY = "InTempSnrErr";
	/** 室内盘管温度传感器故障 */
	private static final String INDOOR_COILER_TEMPERATURE_SENSOR_ERROR_KEY = "InCoilerSnrErr";
	/** 室内湿度传感器故障 */
	private static final String INDOOR_HUMIDITY_SENSOR_ERROR_KEY = "InHumiSnrErr";
	/** 室内排水泵故障 */
	private static final String INDOOR_PUMP_ERROR_KEY = "InPumpSnrErr";
	/** 室内风机电机运转异常故障 */
	private static final String INDOOR_WIND_MOTOR_ERROR_KEY = "InWindMotorErr";
	/** 柜机格栅保护告警 */
	private static final String GRATING_PROTECTED_ERROR_KEY = "GratingProtectErr";
	/** 室内电压过零检测故障 */
	private static final String INDOOR_VOLTAGE_ERROR_KEY = "VZeroErr";
	/** 室内外通信故障 */
	private static final String INDOOR_OUTDOOR_COMMUNICATION_ERROR_KEY = "OutDoorCommErr";
	/** 室内控制板与显示板通信故障 */
	private static final String SHOW_PANEL_COMMUNICATION_ERROR_KEY = "ShwPanelCommErr";
	/** 室内控制板与按键板通信故障 */
	private static final String KEY_PANEL_COMMUNICATION_ERROR_KEY = "KeyPanelCommErr";
	/** WIFI控制板与室内控制板通信故障 */
	private static final String WIFI_COMMUNICATION_ERROR_KEY = "KeyPanelCommErr";
	/** 室内控制板与室内电量板通信故障 */
	private static final String POWER_COMMUNICATION_ERROR_KEY = "PwrCommErr";
	/** 室内控制板EEPROM出错 */
	private static final String INDOOR_EEPROM_ERROR_KEY = "EPMErr";
	/** 运行频率 */
	private static final String RUN_RATE_KEY = "RunRate";
	/** 目标频率 */
	private static final String TARGET_RATE_KEY = "TGTRate";
	/** 发给驱动器频率 */
	private static final String SEND_TO_DRIVER_RATE_KEY = "DrvRate";
	/** 冷凝器(Condensator )温度 */
	private static final String TEMPERATURE_CONDENSATOR_KEY = "CndnstrTemp";
	/** 排气温度 */
	private static final String TEMPERATURE_VENTING_KEY = "VentingTemp";
	/** 目标排气温度 */
	private static final String TEMPERATURE_TARGET_VENTING_KEY = "TGTVentingTemp";

	// 功能初始化相关
	/** 功能 键 数组 */
	public static String[] airConditionerFunctionsKeyArray = { "WindLevelS", "SleepModes", "SColdOrWarm", "KeyCtl",
			"InWindDirCtl", "InTempSet", "InHumiSet", "InHumTempRecv", "InHumTempMKP", "AutoDehumiTempMKP",
			"ABSHumTempMKP", "ABSAutoDehumiTempMKP", "FCSwitch", "TimingCtl", "RTTimingCtl", "WindGatePos6",
			"WindUpDown", "WindLeftRight", "NaturalWindCtl", "EHeatCtl", "DehumiModes", "ECOCtl", "ShareECO",
			"TurboCtl", "DualModeCtl", "FreshCtl", "CWindCtl", "InCleanCtl", "OutCleanCtl", "SmartEyeCtl", "QuietCtl",
			"VoiceCtl", "CleanFog", "BGKCtl", "PanelLight", "LedCtl", "InOutSwhShow", "RSTIndrFilter", "LSwept",
			"RSwept", "HisenseKelonSwh" };

	/** 功能 值 数组 */
	public static String airConditionerFunctionsValueString = "4,4,1,1,1,1,0,1,0,0,0,0,0,0,1,1,1,1,0,1,1,0,1,1,1,1,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0";

	public AirConditionLogic() {
		CMD_SET_KEY = "ACSET";
		CMD_QUERY_STATUS_KEY = "ACQUERY";
		CMD_QUERY_FUNCTION_KEY = "ACQUERYFUN";
		DEVICE_TYPE = AIRCONDITION_TYPE;
		DEVICE_SUB_ADDRESS = AIRCONDITION_ADDRESS;
		// 初始化空调功能
		// initAirConditionerFunctions();
		functionsKeyArray = airConditionerFunctionsKeyArray;
		setInitDeviceFunctions(airConditionerFunctionsValueString);
	}

	/*************************************** 初始化空调功能 *************************************************/
	/**
	 * 拆分 功能 值 并保存到deviceAllFunctions
	 */
	@Override
	public void setInitDeviceFunctions(String functionsValueString) {
		functionsKeyLength = functionsKeyArray.length;
		// Log.d(TAG, "functionsKeyLength ： " + functionsKeyLength);
		if (functionsValueString != null) {
			functionsValueString = functionsValueString.replace(" ", "");
			functionsValueStringArray = functionsValueString.split(",");
			functionsValueLength = functionsValueStringArray.length;
			functionsValueIntArray = new int[functionsValueLength];
			for (int i = 0; i < functionsKeyLength; i++) {
				functionsValueIntArray[i] = Integer.parseInt(functionsValueStringArray[i]);
			}
			// 功能键、值匹配
			for (int i = 0; i < functionsKeyLength - 1; i++) {
				setDeviceFunctionEnable(functionsKeyArray[i], functionsValueIntArray[i]);
			}
			setDeviceFunctionEnable(functionsKeyArray[functionsKeyLength - 1], functionsValueIntArray[43]);
			// 将 功能对象使能 赋值给 功能
			deviceAllFunctions = deviceFunctionEnable;
			// Log.d(TAG, "deviceAllFunctions : " + deviceAllFunctions);
		}
	}

	/*********************************** Box设置 *******************************************/
	/**
	 * Box 设置功能:开关机[0/1],模式[heat/auto/cool/dehumidify/blow],风量[auto/strong/middle/weak/mute],设置温度[18/32],
	 * 风门控制位[0/1],,风门[sweep/auto/#1/#2/#3/#4/#5/#6], 静音[0/1],强力[0/1],LED[ 0/1],提示声[0/1]
	 * 
	 * @param power
	 *            [0/1]
	 * @param mode
	 *            [heat/auto/cool/dehumidify/blow]
	 *            约束关系备注：
	 *            dehumidify模式下：风量强制为auto
	 *            auto模式下：不能操作快速冷热，不能设置静音
	 *            auto模式下，风速不能设置为mute，如遇到此互斥情况，风速默认auto
	 *            blow模式下，不能操作快速冷热，不能调节温度，此条综合指令，温度又需设置，默认25
	 *            blow模式下，风量不能设置为auto，若违背此条约束,风量默认middle
	 * @param windSpeed
	 *            [auto/strong/middle/weak/mute]
	 * @param temperature
	 *            [18/32]
	 * @param upDownAirDoorControl
	 *            [0/1]
	 * @param airDoorPosition
	 *            [sweep/auto/#1/#2/#3/#4/#5/#6]
	 * @param isMute
	 *            [0/1]
	 * @param isHighEfficient
	 *            [0/1]
	 *            约束关系备注：
	 *            设置高效时，cool模式下温度为16，heat模式下，温度为32
	 * @param isBackgroundLight
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setBoxAirConditioner(int power, String mode, String windSpeed, int temperature,
			int upDownAirDoorControl, String airDoorPosition, int isMute, int isHighEfficient, int isBackgroundLight,
			int soundSet) {
		// dehumidify模式下：风量强制为auto
		if (mode.equals("dehumidify")) {
			windSpeed = "auto";
		}
		// auto模式下：不能操作快速冷热，不能设置静音
		if (mode.equals("auto")) {
			isMute = 0;
			isHighEfficient = 0;
		}
		// auto模式下，风量不能设置为mute，若违背此条约束，风量默认auto
		if (mode.equals("auto") && windSpeed.equals("mute")) {
			windSpeed = "auto";
		}
		// blow模式下，不能操作快速冷热，不能调节温度，此条综合指令，温度又需设置，默认25
		if (mode.equals("blow")) {
			temperature = 25;
			isHighEfficient = 0;
		}
		// blow模式下，风量不能设置为auto，若违背此条约束,风量默认middle
		if (mode.equals("blow") && windSpeed.equals("auto")) {
			windSpeed = "middle";
		}
		// 设置高效时，cool模式下温度为16，heat模式下，温度为32
		if (isHighEfficient == 1) {
			if (mode.equals("cool")) {
				temperature = 18; // 内销18 ~ 32，
			} else if (mode.equals("heat")) {
				temperature = 32;
			}
		}
		String command = formatStringToJSONSetCmd(POWER_KEY, power, MODE_KEY, mode, WIND_SPEED_KEY, windSpeed,
				TEMPERATURE_KEY, temperature, VERTICAL_WIND_POWER_KEY, upDownAirDoorControl, AIR_DOOR_POSITION_KEY,
				airDoorPosition, MUTE_KEY, isMute, HIGH_EFFICIENT_KEY, isHighEfficient, BACKGROUND_LIGHT_KEY,
				isBackgroundLight, SOUND_KEY, soundSet);
		setStatusSave(POWER_KEY, power);
		setStatusSave(MODE_KEY, mode);
		setStatusSave(WIND_SPEED_KEY, windSpeed);
		setStatusSave(TEMPERATURE_KEY, temperature);
		setStatusSave(VERTICAL_WIND_POWER_KEY, upDownAirDoorControl);
		setStatusSave(AIR_DOOR_POSITION_KEY, airDoorPosition);
		setStatusSave(MUTE_KEY, isMute);
		setStatusSave(HIGH_EFFICIENT_KEY, isHighEfficient);
		setStatusSave(BACKGROUND_LIGHT_KEY, isBackgroundLight);
		setStatusSave(SOUND_KEY, soundSet);
		return createNetBytes(command);
	}

	/*************************************** 功能设置 *************************************************/
	/**
	 * 电源 power : 0关，1开 soundSet : 0无声音，1开声音
	 * 设置功能:开机[0/1],提示声[0/1],普通定时开关机[0.5h-23h],实时关机控制[0/1],高效[0/1],睡眠[off/aged/younger/child/general],电热[0/1],节能[0/1],
	 * 并用节电[0/1],除烟净化[0/1],双模[0/1]
	 */
	public byte[] setPower(int power, int soundSet) {
		String command = "";
		if (1 == power) {
			command = formatStringToJSONSetCmd(POWER_KEY, power, SOUND_KEY, soundSet);
		} else if (0 == power) {
			command = formatStringToJSONSetCmd(POWER_KEY, power, SOUND_KEY, soundSet, TIMING_VALID_KEY, 0,
					REAL_TIME_POWER_OFF_KEY, 0, HIGH_EFFICIENT_KEY, 0, SLEEP_MODE_KEY, "off", ELECTRICAL_HEATING_KEY,
					0, ENERGY_SAVING_KEY, 0, AND_POWER_SAVING_KEY, 0, CLEAN_SMOKE_KEY, 0, DUAL_MODE_KEY, 0);
			setStatusSave(TIMING_VALID_KEY, 0); // 取消普通定时关机 定时有效位[0]
			setStatusSave(REAL_TIME_POWER_OFF_KEY, 0); // 取消 实时关机
			setStatusSave(HIGH_EFFICIENT_KEY, 0); // 取消高效 强力 快速冷热
			setStatusSave(SLEEP_MODE_KEY, "off"); // 取消睡眠
			setStatusSave(ELECTRICAL_HEATING_KEY, 0); // 取消电热
			setStatusSave(ENERGY_SAVING_KEY, 0); // 取消节能
			setStatusSave(AND_POWER_SAVING_KEY, 0); // 取消并用节电
			setStatusSave(CLEAN_SMOKE_KEY, 0); // 除烟(净化)
			setStatusSave(DUAL_MODE_KEY, 0); // 取消双模
		}
		setStatusSave(POWER_KEY, power); // 设置电源状态
		return createNetBytes(command);
	}

	/**
	 * 模式 设置功能:模式[heat/auto/cool/dehumidify/blow],风量[auto/strong/middle/weak],设置温度[-64/64],静音[0/1],高效[0/1],睡眠[off/aged/
	 * younger/child/general],电热[0/1],除湿[auto], 提示声[0/1]
	 */
	public byte[] setMode(String mode, int soundSet) {
		int isSwitchDiaplay = getTemperatureValueSwitch();
		int temperature = 26;
		if (isSwitchDiaplay == 1) {
			temperature = 77;
		} else {
			temperature = 25;
		}
		String windSpeed = "auto";
		/* 自动/(送风模式)中风,温度25/(制冷)26/(制热)23,取消静音,取消快速冷热,取消睡眠,上下风自动,左右停止，取消电热 */
		if (getPower() == 1) {
			// 单冷机型，不支持制热
			if ((mode.equals("heat")) && getCoolModeFN() == 0) {
				return errorByte;
			}
			setDehumidificationModeFN(0);
			setWindSpeedFN(1);
			setSleepModeFN(0);
			setElectricalHeatingFN(0);
			setDualModeFN(1);
			setTemperatureFN(1);
			setEfficientFN(1);
			setEnergyConservationFN(1);
			setShareFN(1);
			setMuteFN(1);
			if (mode.equals("cool")) {
				if (isSwitchDiaplay == 1) {
					temperature = 79;
				} else {
					temperature = 26;
				}
				setSleepModeFN(1);
			}
			if ((mode.equals("heat")) && getCoolModeFN() > 0) {
				if (isSwitchDiaplay == 1) {
					temperature = 73;
				} else {
					temperature = 23;
				}
				setSleepModeFN(1);
				setElectricalHeatingFN(1);
			}
			if (mode.equals("blow")) {
				windSpeed = "middle";
				setDualModeFN(0);
				setTemperatureFN(0);
				setEfficientFN(0);
				setEnergyConservationFN(0);
				setShareFN(0);
			}
			if (mode.equals("dehumidify")) {
				setDehumidificationModeFN(1);
				setSleepModeFN(1);
				setWindSpeedFN(0);
			}
			if (mode.equals("auto")) {
				setMuteFN(0);
				setEfficientFN(0);
			}
		} else {
			if (mode.equals("cool")) {
				if (isSwitchDiaplay == 1) {
					temperature = 79;
				} else {
					temperature = 26;
				}
			}
			if ((mode.equals("heat")) && getCoolModeFN() > 0) {
				if (isSwitchDiaplay == 1) {
					temperature = 73;
				} else {
					temperature = 23;
				}
			}
			if (mode.equals("blow")) {
				windSpeed = "middle";
			}
		}
		String command = formatStringToJSONSetCmd(MODE_KEY, mode, WIND_SPEED_KEY, windSpeed, TEMPERATURE_KEY,
				temperature, MUTE_KEY, 0, HIGH_EFFICIENT_KEY, 0, SLEEP_MODE_KEY, "off", ELECTRICAL_HEATING_KEY, 0,
				DEHUMIDIFY_MODE_KEY, "auto", SOUND_KEY, soundSet);
		setStatusSave(MODE_KEY, mode);
		setStatusSave(WIND_SPEED_KEY, windSpeed);
		setStatusSave(TEMPERATURE_KEY, temperature);
		setStatusSave(MUTE_KEY, 0);
		setStatusSave(HIGH_EFFICIENT_KEY, 0);
		setStatusSave(SLEEP_MODE_KEY, "off");
		setStatusSave(ELECTRICAL_HEATING_KEY, 0);
		setStatusSave(DEHUMIDIFY_MODE_KEY, "auto");
		return createNetBytes(command);
	}

	/** 温度 取值：”18”~”32” 说明：18℃~32℃ 设置温度[-64/64],提示声[0/1] */
	public byte[] setTemperature(int temperature, int soundSet) {
		// 送风模式下无效
		if (getMode().equals("blow")) {
			setTemperatureFN(0);
			setStatusSave(TEMPERATURE_KEY, 25);
			return errorByte;
		}
		String command = formatStringToJSONSetCmd(TEMPERATURE_KEY, temperature, SOUND_KEY, soundSet);
		setStatusSave(TEMPERATURE_KEY, temperature);
		return createNetBytes(command);
	}

	/**
	 * 风速 取值：0~63 说明： ”0”自动， ”1”静音风速， ”2”低风风速， ”3”中风风速， ”4”高风风速 5 1档风 6 2档风 其他值，越高风速越大
	 * 设置功能:风量[auto/strong/middle/weak/mute],睡眠[off/aged/younger/child/general],高效[0/1], 静音[0/1],提示声[0/1]
	 */
	public byte[] setWindSpeed(String windSpeed, int soundSet) {
		/* 取消快速冷热,取消睡眠 */
		int slientmode = 0;
		// 除湿模式下，只能设置自动
		if (getMode().equals("dehumidify")) {
			windSpeed = "auto";
			setWindSpeedFN(0);
		}
		// 当模式为自动，不能设置静音，目前还未能配置
		if (getMode().equals("auto") && windSpeed.equals("mute")) {
			return errorByte;
		}
		// 当模式为通风，不能设置自动，目前还未能配置
		if (getMode().equals("blow") && windSpeed.equals("auto")) {
			return errorByte;
		}
		if (windSpeed.equals("mute")) {
			slientmode = 1;
		}
		String command = formatStringToJSONSetCmd(WIND_SPEED_KEY, windSpeed, SLEEP_MODE_KEY, "off", HIGH_EFFICIENT_KEY,
				0, MUTE_KEY, slientmode, SOUND_KEY, soundSet);
		setStatusSave(WIND_SPEED_KEY, windSpeed);
		setStatusSave(SLEEP_MODE_KEY, "off");
		setStatusSave(HIGH_EFFICIENT_KEY, 0);
		setStatusSave(MUTE_KEY, slientmode);
		return createNetBytes(command);
	}

	/** 水平导风板开停 (左右风控制)取值：”0”，”1” 说明： ”0”左右风关，”1”左右风开 设置功能:左右风门控制[0/1],左风摆[0/1],右风摆[0/1],提示声[0/1] */
	public byte[] setHorizontalWind(int horizontalWindControl, int leftWindSwing, int rightWindSwing, int soundSet) {
		if (getHorizontalWindFN() > 0) {
			if (getLeftFanContrlFN() == 0) {
				leftWindSwing = 0;
			}
			if (getRightFanContrlFN() == 0) {
				rightWindSwing = 0;
			}
			String command = formatStringToJSONSetCmd(HORIZONTAL_WIND_POWER_KEY, horizontalWindControl,
					LEFT_WIND_SWING_KEY, leftWindSwing, RIGHT_WIND_SWING_KEY, rightWindSwing, SOUND_KEY, soundSet);
			setStatusSave(HORIZONTAL_WIND_POWER_KEY, horizontalWindControl);
			setStatusSave(LEFT_WIND_SWING_KEY, leftWindSwing);
			setStatusSave(RIGHT_WIND_SWING_KEY, rightWindSwing);
			return createNetBytes(command);
		}
		return errorByte;
	}

	/**
	 * 上下风控制 取值：”0”，”1”，”2”，”3”，”4” ，”5”，”6” 说明：”0”扫掠， ”1”自动， ”2”位置1， ”3”位置2， ”4”位置3， ”5”位置4， ”6”位置5 ”7”位置6
	 * 设置功能:上下风门模式[sweep/auto/#1/#2/#3/#4/#5/#6],上下风门控制[0/1],提示声[0/1] #1/#2/#3/#4/#5/#6
	 */
	public byte[] setVerticalWind(String airDoorMode, int airDoorControl, int soundSet) {
		if (getVerticalWindFN() > 0) {
			String command = formatStringToJSONSetCmd(VERTICAL_WIND_MODE_KEY, airDoorMode, VERTICAL_WIND_POWER_KEY,
					airDoorControl, SOUND_KEY, soundSet);
			setStatusSave(VERTICAL_WIND_MODE_KEY, airDoorMode);
			setStatusSave(VERTICAL_WIND_POWER_KEY, airDoorControl);
			return createNetBytes(command);
		}
		return errorByte;
	}

	/**
	 * 定时 开、关机 设定 timingValid : 取值示例： 说明： 1 表示设置有效， 0表示设置无效 timingValue : Val=0,取消定时，
	 * val[1~20],定时val*0.5小时,val=[21~34]定时10+(val-20)小时 设置功能:普通定时开关机[0.5h-23h],普通定时有效[0/1],提示声[0/1]
	 */
	public byte[] setTiming(int timingValid, int timingValue, int soundSet) {
		if (getGeneralTimingShutdownFN() > 0) {
			String command = formatStringToJSONSetCmd(TIMING_VALID_KEY, timingValid, TIMING_VALUE_KEY, timingValue,
					SOUND_KEY, soundSet);
			setStatusSave(TIMING_VALID_KEY, timingValid);
			setStatusSave(TIMING_VALUE_KEY, timingValue);
			return createNetBytes(command);
		}
		return errorByte;
	}

	// 此条指令 livehome没用到
	// 暂时没找到对应的at指令
	// /** 设置实时时间 realTimeHour : 说明：设置空调时间为当前时间小时，用来校准 设定范围：0~23 realTimeMinute : 说明：设置空调时间为当前时间分钟，用来校准 设定范围：0~59 */
	// public byte[] setRealTime(int realTimeHour, int realTimeMinute, int soundSet) {
	// String command = formatStringToJSONSetCmd(REAL_TIME_HOUR_KEY, realTimeHour, REAL_TIME_MINUTE_KEY,
	// realTimeMinute, SOUND_KEY, soundSet);
	// setStatusSave(REAL_TIME_HOUR_KEY, realTimeHour);
	// setStatusSave(REAL_TIME_MINUTE_KEY, realTimeMinute);
	// return createNetBytes(command);
	// }

	// 此条指令做了参数调整
	// /** 实时开机 power : 说明： 1 表示设置实时开机， 0表示取消实时开机。 h=[0~23],min=[0~59] realTimePowerOnHour : 设定范围：0~23 realTimeMinute :
	// * 设定范围：0~59 设置功能:实时开机控制[0/1],实时开机小时值[0-24],实时开机分钟值[0-60],实时时钟的小时值[0-24],实时时钟的分钟值[0-60],提示声[0/1] */
	// public byte[] setRealTimePowerOn(int power, int realTimePowerOnHour, int realTimePowerOnMinute, int realTimeHour,
	// int realTimeMinute, int soundSet) {
	// String command = formatStringToJSONSetCmd(REAL_TIME_POWER_ON_KEY, power, REAL_TIME_POWER_ON_HOUR_KEY,
	// realTimePowerOnHour, REAL_TIME_POWER_ON_MINUTE_KEY, realTimePowerOnMinute, REAL_TIME_HOUR_KEY,
	// realTimeHour, REAL_TIME_MINUTE_KEY, realTimeMinute, SOUND_KEY, soundSet);
	// setStatusSave(REAL_TIME_POWER_ON_KEY, power);
	// setStatusSave(REAL_TIME_POWER_ON_HOUR_KEY, realTimePowerOnHour);
	// setStatusSave(REAL_TIME_POWER_ON_MINUTE_KEY, realTimePowerOnMinute);
	// return createNetBytes(command);
	// }

	/**
	 * 实时开机 power : 说明： 1 表示设置实时开机， 0表示取消实时开机。 h=[0~23],min=[0~59] realTimePowerOnHour : 设定范围：0~23 realTimeMinute :
	 * 设定范围：0~59 设置功能:实时开机控制[0/1],实时开机小时值[0-24],实时开机分钟值[0-60],实时时钟的小时值[0-24],实时时钟的分钟值[0-60],提示声[0/1]
	 */
	public byte[] setRealTimePowerOn(int power, int realHour, int realMinute, int bootHour, int bootMinute, int soundSet) {
		if (getRealityTimeFN() > 0) {
			String command = formatStringToJSONSetCmd(REAL_TIME_POWER_ON_KEY, power, REAL_TIME_HOUR_KEY, realHour,
					REAL_TIME_MINUTE_KEY, realMinute, REAL_TIME_POWER_ON_HOUR_KEY, bootHour,
					REAL_TIME_POWER_ON_MINUTE_KEY, bootMinute, SOUND_KEY, soundSet);
			setStatusSave(REAL_TIME_POWER_ON_KEY, power);
			setStatusSave(REAL_TIME_HOUR_KEY, realHour);
			setStatusSave(REAL_TIME_MINUTE_KEY, realMinute);
			setStatusSave(REAL_TIME_POWER_ON_HOUR_KEY, bootHour);
			setStatusSave(REAL_TIME_POWER_ON_MINUTE_KEY, bootMinute);
			return createNetBytes(command);
		}
		return errorByte;
	}

	/**
	 * 实时关机 power : 说明： 1 表示设置实时开机， 0表示取消实时开机。 h=[0~23],min=[0~59] realTimePowerOnHour : 设定范围：0~23 realTimeMinute :
	 * 设定范围：0~59 设置功能:实时关机控制[0/1],实时关机小时值[0-24],实时关机分钟值[0-60],实时时钟的小时值[0-24],实时时钟的分钟值[0-60] ,提示声[0/1]
	 */
	public byte[] setRealTimePowerOff(int power, int realHour, int realMinute, int bootHour, int bootMinute,
			int soundSet) {
		if (getRealityTimeFN() > 0) {
			String command = formatStringToJSONSetCmd(REAL_TIME_POWER_OFF_KEY, power, REAL_TIME_HOUR_KEY, realHour,
					REAL_TIME_MINUTE_KEY, realMinute, REAL_TIME_POWER_OFF_HOUR_KEY, bootHour,
					REAL_TIME_POWER_OFF_MINUTE_KEY, bootMinute, SOUND_KEY, soundSet);
			setStatusSave(REAL_TIME_POWER_OFF_KEY, power);
			setStatusSave(REAL_TIME_HOUR_KEY, realHour);
			setStatusSave(REAL_TIME_MINUTE_KEY, realMinute);
			setStatusSave(REAL_TIME_POWER_ON_HOUR_KEY, bootHour);
			setStatusSave(REAL_TIME_POWER_ON_MINUTE_KEY, bootMinute);
			return createNetBytes(command);
		}
		return errorByte;
	}

	/** 睡眠设定 设置功能:睡眠[off/aged/younger/child/general],风量[auto/strong/middle/weak],静音[0/1],高效[0/1],提示声[0/1] */
	public byte[] setSleepMode(String sleepMode, int soundSet) {
		/* 当前温度,低风,取消静音,取消快速冷热 */
		String windSpeed = "auto";
		if (getSleepModeFN() > 0) {
			// 当模式为自动，不能设置睡眠
			if (getMode().equals("auto")) {
				setSleepModeFN(0);
				sleepMode = "off";
				return errorByte;
			}
			// 当模式为送风，不能设置睡眠
			if (getMode().equals("blow")) {
				setSleepModeFN(0);
				sleepMode = "off";
				return errorByte;
			}
			setWindSpeedFN(0);
			if (sleepMode.equals("off")) {
				setWindSpeedFN(0);
			} else {
				windSpeed = "weak";
			}
			String command = formatStringToJSONSetCmd(SLEEP_MODE_KEY, sleepMode, WIND_SPEED_KEY, windSpeed, MUTE_KEY,
					0, HIGH_EFFICIENT_KEY, 0, SOUND_KEY, soundSet);
			setStatusSave(SLEEP_MODE_KEY, sleepMode);
			setStatusSave(WIND_SPEED_KEY, windSpeed);
			setStatusSave(MUTE_KEY, 0);
			setStatusSave(HIGH_EFFICIENT_KEY, 0);
			return createNetBytes(command);
		}
		return errorByte;
	}

	// /** 26℃键设定 取值：2 说明：快速切换模式为“制冷、26℃” 设置制冷模式就是制冷26度 */
	// public byte[] set26Celsius(int mode, int soundSet) {
	// String command = formatStringToJSONSetCmd(MODE_KEY, mode, SOUND_KEY, soundSet);
	// setStatusSave(MODE_KEY, mode);
	// return createNetBytes(command);
	// }

	/** 节能 取值：”0”，”1” 说明：”0”节能关，”1”节能开 设置功能:节能[0/1],高效[0/1],提示声[0/1] */
	public byte[] setEnergySaving(int energySaving, int soundSet) {
		// 取消快速冷热
		if (getEnergyConservationFN() > 0) {
			// 节能在送风模式下无效
			if (getMode().equals("blow")) {
				setEnergyConservationFN(0);
				setShareFN(0);
				setStatusSave(ENERGY_SAVING_KEY, 0);
				return errorByte;
			}
			// 节能在双模下无效
			if (getDualMode() == 1) {
				setEnergyConservationFN(0);
				setShareFN(0);
				setStatusSave(ENERGY_SAVING_KEY, 0);
				return errorByte;
			}
			String command = formatStringToJSONSetCmd(ENERGY_SAVING_KEY, energySaving, HIGH_EFFICIENT_KEY, 0,
					SOUND_KEY, soundSet);
			setStatusSave(ENERGY_SAVING_KEY, energySaving);
			setStatusSave(HIGH_EFFICIENT_KEY, 0);
			return createNetBytes(command);
		}
		return errorByte;
	}

	/** 背景灯 取值：”0”，”1” 说明：”0”灯光关，”1”灯光开 */
	public byte[] setBackgroundLight(int light, int soundSet) {
		if (getBackgroundLampFN() > 0) {
			String command = formatStringToJSONSetCmd(BACKGROUND_LIGHT_KEY, light, SOUND_KEY, soundSet);
			setStatusSave(BACKGROUND_LIGHT_KEY, light);
			return createNetBytes(command);
		}
		return errorByte;
	}

	// 此条指令 livehome没用到
	/** 显示屏发光 取值：”0”，”1” 说明：”0”灯光关，”1”灯光开 */
	public byte[] setScreenLight(int light, int soundSet) {
		if (getScreenFN() > 0) {
			String command = formatStringToJSONSetCmd(SCREEN_LIGHT_KEY, light, SOUND_KEY, soundSet);
			setStatusSave(SCREEN_LIGHT_KEY, light);
			return createNetBytes(command);
		}
		return errorByte;
	}

	// 此条指令 livehome没用到
	/** LED灯 取值：”0”，”1” 说明：”0”灯光关，”1”灯光开 */
	public byte[] setLEDLight(int light, int soundSet) {
		if (getLEDFN() > 0) {
			String command = formatStringToJSONSetCmd(LED_LIGHT_KEY, light, SOUND_KEY, soundSet);
			setStatusSave(LED_LIGHT_KEY, light);
			return createNetBytes(command);
		}
		return errorByte;
	}

	/** 电加热 取值：0，1 说明：0电加热关，”1”电加热开 设置功能:电热[0/1],提示声[0/1] */
	public byte[] setElectricalHeating(int electricalHeating, int soundSet) {
		if (getElectricalHeatingFN() > 0) {
			if (!getMode().equals("heat")) {
				setDehumidificationModeFN(0);
				setStatusSave(ELECTRICAL_HEATING_KEY, 0);
				return errorByte;
			}
			String command = formatStringToJSONSetCmd(ELECTRICAL_HEATING_KEY, electricalHeating, SOUND_KEY, soundSet);
			setStatusSave(ELECTRICAL_HEATING_KEY, electricalHeating);
			return createNetBytes(command);
		}
		return errorByte;
	}

	/** 强力设定（快速冷热、高效） 取值：”0”，”1” 说明：”0”强力设定关，”1”强力设定开 设置功能:高效[0/1],静音[0/1],风量[auto],睡眠[off],节能[0/1],并用节电[0/1],提示声[0/1] */
	public byte[] setEfficient(int fastCooling, int soundSet) {
		/* 自动风/（关）高风,取消静音,取消睡眠,取消节能 */
		int isSwitchDiaplay = getTemperatureValueSwitch();
		if (getEfficientFN() > 0) {
			if (getMode().equals("blow")) {
				setEfficientFN(0);
				setStatusSave(HIGH_EFFICIENT_KEY, 0);
				return errorByte;
			}
			if (getMode().equals("auto")) {
				setEfficientFN(0);
				setStatusSave(HIGH_EFFICIENT_KEY, 0);
				return errorByte;
			}
			String command = formatStringToJSONSetCmd(HIGH_EFFICIENT_KEY, fastCooling, MUTE_KEY, 0, WIND_SPEED_KEY,
					"auto", SLEEP_MODE_KEY, "off", ENERGY_SAVING_KEY, 0, AND_POWER_SAVING_KEY, 0, SOUND_KEY, soundSet);
			setStatusSave(HIGH_EFFICIENT_KEY, fastCooling);
			setStatusSave(MUTE_KEY, 0);
			setStatusSave(WIND_SPEED_KEY, "auto");
			setStatusSave(SLEEP_MODE_KEY, "off");
			setStatusSave(ENERGY_SAVING_KEY, 0);
			setStatusSave(AND_POWER_SAVING_KEY, 0);
			return createNetBytes(command);
		}
		return errorByte;
	}

	// 此设置温度接口 外销用
	/** 强力设定（快速冷热、高效） 取值：”0”，”1” 说明：”0”强力设定关，”1”强力设定开 设置功能:高效[0/1],静音[0/1],风量[auto],睡眠[off],节能[0/1],并用节电[0/1],提示声[0/1] */
	public byte[] setEfficientExportSales(int fastCooling, int soundSet) {
		int isSwitchDiaplay = getTemperatureValueSwitch();
		if (getEfficientFN() == 1) {
			if (getMode().equals("blow")) {
				setEfficientFN(0);
				setStatusSave(HIGH_EFFICIENT_KEY, 0);
				return errorByte;
			}
			if (getMode().equals("auto")) {
				setEfficientFN(0);
				setStatusSave(HIGH_EFFICIENT_KEY, 0);
				return errorByte;
			}
			if (fastCooling == 1) {
				if (getMode().equals("cool")) {
					if (isSwitchDiaplay == 1) {
						setStatusSave(TEMPERATURE_KEY, 61);
					} else {
						setStatusSave(TEMPERATURE_KEY, 16);
					}
				} else if (getMode().equals("heat")) {
					if (isSwitchDiaplay == 1) {
						setStatusSave(TEMPERATURE_KEY, 90);
					} else {
						setStatusSave(TEMPERATURE_KEY, 32);
					}
				}
			}
			String command = formatStringToJSONSetCmd(HIGH_EFFICIENT_KEY, fastCooling, MUTE_KEY, 0, WIND_SPEED_KEY,
					"auto", SLEEP_MODE_KEY, "off", ENERGY_SAVING_KEY, 0, AND_POWER_SAVING_KEY, 0, SOUND_KEY, soundSet);
			setStatusSave(HIGH_EFFICIENT_KEY, fastCooling);
			setStatusSave(MUTE_KEY, 0);
			setStatusSave(WIND_SPEED_KEY, "auto");
			setStatusSave(SLEEP_MODE_KEY, "off");
			setStatusSave(ENERGY_SAVING_KEY, 0);
			setStatusSave(AND_POWER_SAVING_KEY, 0);
			return createNetBytes(command);
		}
		return errorByte;
	}

	/** 静音 设置功能:静音[0/1],高效[0/1],睡眠[off],风量[mute],提示声[0/1] */
	public byte[] setMuteMode(int isMuteModeOn, int soundSet) {
		// 取消快速冷热，取消睡眠
		if (getMuteFN() > 0) {
			if (getMode().equals("auto")) {
				setMuteFN(0);
				setStatusSave(MUTE_KEY, 0);
				return errorByte;
			}
			String command = formatStringToJSONSetCmd(MUTE_KEY, isMuteModeOn, HIGH_EFFICIENT_KEY, 0, SLEEP_MODE_KEY,
					"off", WIND_SPEED_KEY, "mute", SOUND_KEY, soundSet);
			setStatusSave(MUTE_KEY, isMuteModeOn);
			setStatusSave(HIGH_EFFICIENT_KEY, 0);
			setStatusSave(SLEEP_MODE_KEY, "off");
			setStatusSave(WIND_SPEED_KEY, "mute");
			return createNetBytes(command);
		}
		return errorByte;
	}

	/** 风向 取值：”0”，”1” 说明：”0”风向设定关，”1”风向设定开 */
	public byte[] setWindDirection(int isWindDirectionOn, int soundSet) {
		if (getWindDirectionFN() == 1) {
			String command = formatStringToJSONSetCmd(WIND_DIRECTION_KEY, isWindDirectionOn, SOUND_KEY, soundSet);
			setStatusSave(WIND_DIRECTION_KEY, isWindDirectionOn);
			return createNetBytes(command);
		}
		return errorByte;
	}

	/** 湿度 取值：[30-80] */
	public byte[] setHumidity(int humidity, int soundSet) {
		if (getHumidityFN() > 0) {
			String command = formatStringToJSONSetCmd(HUMIDITY_SET_KEY, humidity, SOUND_KEY, soundSet);
			setStatusSave(HUMIDITY_SET_KEY, humidity);
			return createNetBytes(command);
		}
		return errorByte;
	}

	/** 华氏 摄氏 温度切换显示 取值：”0”，”1” 说明：”0”切换关，”1”切换开 */
	public byte[] setFahrenheitOrCelsiusSwitch(int isSwitch, int soundSet) {
		if (getTemperatureValueSwitchFN() > 0) {
			String command = formatStringToJSONSetCmd(FAHRENHEIT_OR_CELSIUS_SWITCH_KEY, isSwitch, SOUND_KEY, soundSet);
			setStatusSave(FAHRENHEIT_OR_CELSIUS_SWITCH_KEY, isSwitch);
			return createNetBytes(command);
		}
		return errorByte;
	}

	/** 并用节电 设置功能:并用节电[0/1], 高效[0/1],提示声[0/1] */
	public byte[] setAndPowerSavingMode(int isAndPowerSavingMode, int soundSet) {
		if (getShareFN() > 0) {
			// 节能在并用节电模式下无效
			if (getMode().equals("blow")) {
				setEnergyConservationFN(0);
				setShareFN(0);
				setStatusSave(AND_POWER_SAVING_KEY, 0);
				return errorByte;
			}
			// 并用节电在双模下无效
			if (getDualMode() == 1) {
				setEnergyConservationFN(0);
				setShareFN(0);
				setStatusSave(AND_POWER_SAVING_KEY, 0);
				return errorByte;
			}
			String command = formatStringToJSONSetCmd(AND_POWER_SAVING_KEY, isAndPowerSavingMode, HIGH_EFFICIENT_KEY,
					0, SOUND_KEY, soundSet);
			setStatusSave(AND_POWER_SAVING_KEY, isAndPowerSavingMode);
			setStatusSave(HIGH_EFFICIENT_KEY, 0);
			return createNetBytes(command);
		}
		return errorByte;
	}

	/** 双模 设置功能:双模[0/1],节能[0/1],并用节电[0/1],提示声[0/1] */
	public byte[] setDualMode(int isDualMode, int soundSet) {
		/* 取消快速冷热 */
		if (getDualModeFN() > 0) {
			if (getMode().equals("blow")) {
				setDualModeFN(0);
				setStatusSave(DUAL_MODE_KEY, 0);
				return errorByte;
			}
			if (getEnergyConservationFN() > 0 && isDualMode == 1) {
				setEnergyConservationFN(0);
				setStatusSave(ENERGY_SAVING_KEY, 0);
			}
			if (getShareFN() > 0 && isDualMode == 1) {
				setShareFN(0);
				setStatusSave(AND_POWER_SAVING_KEY, 0);
			}
			if (isDualMode == 0) {
				setEnergyConservationFN(1);
				setShareFN(1);
			}
			String command = formatStringToJSONSetCmd(DUAL_MODE_KEY, isDualMode, ENERGY_SAVING_KEY, 0,
					AND_POWER_SAVING_KEY, 0, SOUND_KEY, soundSet);
			setStatusSave(DUAL_MODE_KEY, isDualMode);
			setStatusSave(ENERGY_SAVING_KEY, 0);
			setStatusSave(AND_POWER_SAVING_KEY, 0);
			return createNetBytes(command);
		}
		return errorByte;
	}

	/** 室内清洁 设置功能:室内清洁[0/1],提示声[0/1] */
	public byte[] setIndoorClean(int isIndoorClean, int soundSet) {
		if (getCleanIndoorFN() > 0) {
			String command = formatStringToJSONSetCmd(INDOOR_CLEAN_CONTROL_KEY, isIndoorClean, SOUND_KEY, soundSet);
			setStatusSave(INDOOR_CLEAN_CONTROL_KEY, isIndoorClean);
			return createNetBytes(command);
		}
		return errorByte;
	}

	/** 室外清洁 设置功能:室内清洁[0/1],提示声[0/1] */
	public byte[] setOutdoorClean(int isOutdoorClean, int soundSet) {
		if (getCleanOutdoorFN() > 0) {
			String command = formatStringToJSONSetCmd(OUTDOOR_CLEAN_CONTROL_KEY, isOutdoorClean, SOUND_KEY, soundSet);
			setStatusSave(INDOOR_CLEAN_CONTROL_KEY, isOutdoorClean);
			return createNetBytes(command);
		}
		return errorByte;
	}

	// 此条命令livehome代码里没用到
	/** 除湿 设置功能:除湿模式[auto/1#/2#/3#/4#/5#/6#/7#],提示声[0/1] */
	public byte[] setDehumidifyMode(String isDehumidifyMode, int soundSet) {
		if (getDehumidificationModeFN() > 0) {
			// 只在除湿模式下有效
			if (!getMode().equals("dehumidify")) {
				setDehumidificationModeFN(0);
				setStatusSave(DEHUMIDIFY_MODE_KEY, 0); // 暂时没弄清楚 ZD[24]="0" 什么意思
				return errorByte;
			}
			String command = formatStringToJSONSetCmd(DEHUMIDIFY_MODE_KEY, isDehumidifyMode, SOUND_KEY, soundSet);
			setStatusSave(DEHUMIDIFY_MODE_KEY, isDehumidifyMode);
			return createNetBytes(command);
		}
		return errorByte;
	}

	// 此条指令 livehome没用到
	/** 自然风 设置功能:双模[0/1],节能[0/1],并用节电[0/1],提示声[0/1] */
	public byte[] setNaturalWind(int isNaturalWind, int soundSet) {
		if (getNatureWindFN() > 0) {
			String command = formatStringToJSONSetCmd(NATURAL_WIND_KEY, isNaturalWind, SOUND_KEY, soundSet);
			setStatusSave(NATURAL_WIND_KEY, isNaturalWind);
			return createNetBytes(command);
		}
		return errorByte;
	}

	// 此条指令 livehome没用到
	/** 清新 设置功能:清新[0/1],提示声[0/1] */
	public byte[] setFreshAir(int isFreshAir, int soundSet) {
		if (getFreshnessFN() > 0) {
			String command = formatStringToJSONSetCmd(FRESH_AIR_KEY, isFreshAir, SOUND_KEY, soundSet);
			setStatusSave(FRESH_AIR_KEY, isFreshAir);
			return createNetBytes(command);
		}
		return errorByte;
	}

	// 此条命令livehome代码里没用到
	/** 室内外温度切换显示 设置功能:室内外温度切换显示[0/1],提示声[0/1] */
	public byte[] setIndoorOrOutdoorTemperatureDisplaySwitch(int isSwitch, int soundSet) {
		if (getIndoorOutdoorSwitchFN() > 0) {
			String command = formatStringToJSONSetCmd(IN_OUT_SWITCH_SHOW_KEY, isSwitch, SOUND_KEY, soundSet);
			setStatusSave(IN_OUT_SWITCH_SHOW_KEY, isSwitch);
			return createNetBytes(command);
		}
		return errorByte;
	}

	// 此条命令livehome代码里没用到
	/** 换风 设置功能:换风[0/1],提示声[0/1] */
	public byte[] setAirExchange(int isAirExchange, int soundSet) {
		if (getFreshAirFN() > 0) {
			String command = formatStringToJSONSetCmd(AIR_EXCHANGE_CONTROL_KEY, isAirExchange, SOUND_KEY, soundSet);
			setStatusSave(AIR_EXCHANGE_CONTROL_KEY, isAirExchange);
			return createNetBytes(command);
		}
		return errorByte;
	}

	/** 智慧眼 设置功能:智慧眼[0/1],提示声[0/1] */
	public byte[] setSmartEye(int isSmartEye, int soundSet) {
		if (getSmartEyeFN() > 0) {
			String command = formatStringToJSONSetCmd(SMART_EYE_KEY, isSmartEye, SOUND_KEY, soundSet);
			setStatusSave(SMART_EYE_KEY, isSmartEye);
			return createNetBytes(command);
		}
		return errorByte;
	}

	// 此条命令livehome代码里没用到
	/** 室内过滤网清洁复位控制(净化) 设置功能:室内过滤网清洁复位控制[0/1],提示声[0/1] */
	public byte[] setIndoorFilterCleanReset(int isReset, int soundSet) {
		if (getIndoorFilterClearFN() > 0) {
			String command = formatStringToJSONSetCmd(INDOOR_FILTER_CLEAN_KEY, isReset, SOUND_KEY, soundSet);
			setStatusSave(INDOOR_FILTER_CLEAN_KEY, isReset);
			return createNetBytes(command);
		}
		return errorByte;
	}

	// 此条指令 livehome没用到
	/** 设置语音 设置功能:语音[0/1],提示声[0/1] */
	public byte[] setVoice(int isVoice, int soundSet) {
		if (getVoiceFN() > 0) {
			String command = formatStringToJSONSetCmd(VOICE_KEY, isVoice, SOUND_KEY, soundSet);
			setStatusSave(VOICE_KEY, isVoice);
			return createNetBytes(command);
		}
		return errorByte;
	}

	/** 设置除烟 设置功能:除烟[0/1],提示声[0/1] */
	public byte[] setCleanSmoke(int CleanSmoke, int soundSet) {
		if (getCleanSmokeFN() > 0) {
			String command = formatStringToJSONSetCmd(CLEAN_SMOKE_KEY, CleanSmoke, SOUND_KEY, soundSet);
			setStatusSave(CLEAN_SMOKE_KEY, CleanSmoke);
			return createNetBytes(command);
		}
		return errorByte;
	}

	/** 显示屏亮度 设置功能:显示屏亮度值[0-255],提示声[0/1] */
	public byte[] setBrightness(int brightness, int soundSet) {
		if (getScreenFN() > 0) {
			String command = formatStringToJSONSetCmd(BRIGHTNESS_KEY, brightness, SOUND_KEY, soundSet);
			setStatusSave(BRIGHTNESS_KEY, brightness);
			return createNetBytes(command);
		}
		return errorByte;
	}

	// // 此条先不做，感觉at指令有点乱
	// /** 自动工作模式和除湿模式的温度补偿 设置功能:模式[heat/auto/cool/dehumidify/blow],自动工作模式和除湿模式的温度补偿[0-16],提示声[0/1]*/
	// public byte[] setTemperatureCompensation(int isCompensation, int soundSet) {
	// String command = formatStringToJSONSetCmd(AUTO_DEHUMI_TEMP_COMPENSATION_KEY, isCompensation, SOUND_KEY,
	// soundSet);
	// return createNetBytes(command);
	// }

	// 此条先不做，感觉at指令有点乱
	// /** 体感控制,体感室内温度,体感室内温度补偿 设置功能:室内过滤网清洁复位控制[0/1],提示声[0/1]*/
	// public byte[] setSomatosensory(int isSomatosensory, int temperature, int compensation, int soundSet) {
	// String command = formatStringToJSONSetCmd(SOMATOSENSORY_CONTROL_KEY,
	// isSomatosensory,SOMATOSENSORY_INDOOR_TEMPERATURE_KEY, temperature,
	// SOUND_KEY, soundSet);
	// return createNetBytes(command);
	// }

	/*************************************** 华氏 摄氏温度切换显示相关 *************************************************/
	/** 华氏转摄氏对应数组 */
	public final int[] fahrenheit = { 16, 18, 20, 22, 23, 25, 27, 29, 31, 32, 34, 36, 37, 39, 41, 43, 45, 46, 48, 50,
			52, 54, 55, 57, 59, 61, 63, 64, 66, 68, 70, 72, 73, 75, 77, 79, 81, 82, 84, 86, 88, 90, 91, 93, 95, 97, 99 };

	public final int[] celsius = { -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
			14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37 };

	/** 华氏转摄氏 */
	private int fahrenheitConvertToCelsius(int temperature) {
		if (temperature < 16) {
			temperature = -9;
		} else if (temperature > 99) {
			temperature = 37;
		} else {
			for (int i = 0; i < fahrenheit.length; i++) {
				if (fahrenheit[i] == temperature) {
					temperature = celsius[i];
				}
			}
		}
		return temperature;
	}

	/** 摄氏转华氏 */
	private int celsiusConvertToFahrenheit(int temperature) {
		if (temperature < -9) {
			temperature = 16;
		} else if (temperature > 37) {
			temperature = 99;
		} else {
			for (int i = 0; i < celsius.length; i++) {
				if (celsius[i] == temperature) {
					temperature = fahrenheit[i];
				}
			}
		}
		return temperature;
	}

	/** 华氏切换到摄氏时，温度值转换显示对应数组 */
	public final int[] fahrenheitSwitch = { 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79,
			80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 };
	public final int[] celsiusSwitch = { 16, 16, 17, 18, 18, 19, 19, 20, 20, 21, 21, 22, 23, 23, 24, 24, 25, 25, 26,
			26, 27, 28, 28, 29, 29, 30, 30, 31, 31, 32

	};

	/** 华氏切换摄氏显示温度 */
	private int fahrenheitSwitchCelsiusDisplay(int temperature) {
		if (temperature < 61) {
			temperature = 16;
		} else if (temperature > 90) {
			temperature = 32;
		} else {
			for (int i = 0; i < fahrenheitSwitch.length; i++) {
				if (fahrenheitSwitch[i] == temperature) {
					temperature = celsiusSwitch[i];
				}
			}
		}
		return temperature;
	}

	/** 摄氏切换华氏显示温度 */
	private int celsiusSwitchFahrenheitDisplay(int temperature) {
		if (temperature < 16) {
			temperature = 61;
		} else if (temperature > 32) {
			temperature = 90;
		} else {
			for (int i = 0; i < celsius.length; i++) {
				if (celsius[i] == temperature) {
					temperature = fahrenheit[i];
				}
			}
		}
		return temperature;
	}

	/** 华氏与摄氏切换显示 */
	public int temperatureSwitchDisplay(int temperatureDispaly) {
		int temperature;
		if (getTemperatureValueSwitch() == 1) {
			temperature = celsiusSwitchFahrenheitDisplay(temperatureDispaly);
			return temperature;
		} else if (getTemperatureValueSwitch() == 0) {
			temperature = fahrenheitSwitchCelsiusDisplay(temperatureDispaly);
			return temperature;
		}
		return -1;
	}

	/*************************************** 开 关机 功能约束关系处理 *************************************************/
	public void setPowerStatus(boolean power) {
		if (power) {
			setWindSpeedFN(0);
			if (getMode().equals("dehumidify") || !getSleepMode().equals("off")) {
				setWindSpeedFN(0);
			}
			setSleepModeFN(1);
			if (getMode().equals("auto") || getMode().equals("blow")) {
				setSleepModeFN(0);
			}
			setCoolModeFN(1);
			setTemperatureFN(1);
			setHumidityFN(1);
			setSomatosensoryRealityTemperatureFN(1);
			setTemperatureCompensationFN(1);
			setTemperatureValueSwitchFN(1);
			setGeneralTimingShutdownFN(1);
			setRealityTimeFN(1);
			setVerticalWindFN(1);
			setHorizontalWindFN(1);
			setNatureWindFN(1);
			if (getMode().equals("heat") && getCoolModeFN() > 0) {
				setElectricalHeatingFN(1);
			}
			if (getMode().equals("dehumidify")) {
				setDehumidificationModeFN(1);
			}

			setEnergyConservationFN(1);
			setShareFN(1);

			if (getMode().equals("blow") || (getDualMode() == 1)) {
				setEnergyConservationFN(0);
				setShareFN(0);
			}
			setEfficientFN(1);
			// if(getShare().equals("1") ||
			// getEnergyConservation().equals("1")||getMode().equals("blow")||getMode().equals("auto")){
			// modified by caogeng for chenweiguo's need
			if ((getEnergyConservation() == 1) || getMode().equals("blow") || getMode().equals("auto")) {
				setEfficientFN(0);
			}
			setDualModeFN(1);
			if ((getShare() == 1) || (getEnergyConservation() == 1) || getMode().equals("blow")) {
				setDualModeFN(0);
			}
			setFreshnessFN(1);
			setFreshAirFN(1);
			setClernIndoorFN(1);
			setClernOutdoorFN(1);
			setSmartEyeFN(1);
			setMuteFN(1);
			setVoiceFN(1);
			setClernSmokeFN(1);
			setBackgroundLampFN(1);
			setScreenFN(1);
			setLEDFN(1);
			setIndoorOutdoorSwitchFN(1);
		} else {
			setWindSpeedFN(0);
			setSleepModeFN(0);
			setHumidityFN(0);
			setTemperatureValueSwitchFN(1);// modify by xujiewen,for display degree Fahrenheit
			setGeneralTimingShutdownFN(0);
			// 此处暂时设置为0
			setRealityTimeFN(0);// modify by mujian;3 means close KTGT KTKT;4 means close only KTGT;half enable;
			setHorizontalWindFN(0);
			setNatureWindFN(0);
			setElectricalHeatingFN(0);
			setDehumidificationModeFN(0);
			setEnergyConservationFN(0);
			setShareFN(0);
			setEfficientFN(0);
			setDualModeFN(0);
			setFreshnessFN(0);
			setFreshAirFN(0);
			setClernIndoorFN(0);
			setClernOutdoorFN(0);
			setSmartEyeFN(0);
			setMuteFN(0);
			setVoiceFN(0);
			setClernSmokeFN(0);
			setBackgroundLampFN(0);
			setScreenFN(0);
			setLEDFN(0);
			setIndoorOutdoorSwitchFN(0);
		}
	}

	/***************************************** 解析方法 ******************************************/
	/** 解析查询的状态/功能 */
	public String parseByteToJSON(byte[] recv) {
		int oldPower = getPower();
		if(oldPower == -1) {
			setPowerOnCurrentTime = System.currentTimeMillis();
			setPowerOffCurrentTime = System.currentTimeMillis();
		}
		String parseResult = super.parseByteToJSON(recv);
		// 计时相关处理
		if (getPower() == 1) { // 与当前状态不同，重新计时
			if (timePowerOnUpdateFlag) {
				setPowerOnCurrentTime = System.currentTimeMillis(); // 设置开机 当前时间
				timePowerOnUpdateFlag = false;
			}
		} else {
			if (!timePowerOnUpdateFlag) {
				setPowerOffCurrentTime = System.currentTimeMillis(); // 设置关机 当前时间
				timePowerOnUpdateFlag = true;
			}
		}
		// 获取 模式 heat/auto/cool/dehumidify/blow
		if (getMode().equals("cool")) {
			if (!lastMode.equals("cool")) {
				lastMode = getMode();
				setModeCurrentTime = System.currentTimeMillis(); // 设置模式 当前时间
			}
		} else if (getMode().equals("blow")) {
			if (!lastMode.equals("blow")) {
				lastMode = getMode();
				setModeCurrentTime = System.currentTimeMillis(); // 设置模式 当前时间
			}
		} else if (getMode().equals("dehumidify")) {
			if (!lastMode.equals("dehumidify")) {
				lastMode = getMode();
				setModeCurrentTime = System.currentTimeMillis(); // 设置模式 当前时间
			}
		} else if (getMode().equals("auto")) {
			if (!lastMode.equals("auto")) {
				lastMode = getMode();
				setModeCurrentTime = System.currentTimeMillis(); // 设置模式 当前时间
			}
		} else if (getMode().equals("heat")) {
			if (!lastMode.equals("heat")) {
				lastMode = getMode();
				setModeCurrentTime = System.currentTimeMillis(); // 设置模式 当前时间
			}
		} else {
			setModeCurrentTime = 0;
		}
		if (getHighEfficient() == 1) {
			if (timeHighEfficientUpdateFlag) {
				setHighEfficientCurrentTime = System.currentTimeMillis(); // 设置强力 当前时间
				timeHighEfficientUpdateFlag = false;
			}
		} else {
			timeHighEfficientUpdateFlag = true;
		}
		return parseResult;
	}

	/*************************************** 状态查询 *************************************************/
	// 盒子用
	/** 获取 设置开机后，持续时间 */
	public long getSetPowerOnDuration() {
		if(getPower() == 1) {
			if (setPowerOnCurrentTime == 0) {
				return durationTimeError;
			}
			durationTime = System.currentTimeMillis() - setPowerOnCurrentTime;
			return durationTime;
		}
		return 0;
	}

	// 盒子用
	/** 获取 设置关机后，持续时间 */
	public long getSetPowerOffDuration() {
		if(getPower() == 0) {
			if (setPowerOffCurrentTime == 0) {
				return durationTimeError;
			}
			durationTime = System.currentTimeMillis() - setPowerOffCurrentTime;
			return durationTime;
		}
		return 0;
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

	// 盒子用
	/** 获取 设置强力后，持续时间 */
	public long getSetHighEfficientDuration() {
		if (setHighEfficientCurrentTime == 0) {
			return durationTimeError;
		}
		durationTime = System.currentTimeMillis() - setHighEfficientCurrentTime;
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
	/** 获取 温度值 室内 */
	public int getTemperatureIndoor() {
		return getStatusInt(TEMPERATURE_INDOOR_KEY);
	}

	// 盒子用到
	/** 获取 温度值 室外 */
	public int getTemperatureOutdoor() {
		return getStatusInt(TEMPERATURE_OUTDOOR_KEY);
	}

	// 盒子用到
	/** 获取 强力状态 高效/快速冷热 */
	public int getHighEfficient() {
		return getStatusInt(HIGH_EFFICIENT_KEY);
	}

	// 盒子用到
	/** 获取 风门位置[sweep/auto/#1/#2/#3/#4/#5/#6] */
	public String getAirDoorPosition() {
		return getStatusString(AIR_DOOR_POSITION_KEY);
	}

	// 按.c文件的顺序
	// 盒子用到
	/** 获取 风速 auto/strong/middle/weak/mute */
	public String getWindSpeed() {
		return getStatusString(WIND_SPEED_KEY);
	}

	/** 获取 睡眠 off/aged/younger/child/general */
	public String getSleepMode() {
		return getStatusString(SLEEP_MODE_KEY);
	}

	// 盒子用到
	/** 获取 模式 heat/auto/cool/dehumidify/blow */
	public String getMode() {
		return getStatusString(MODE_KEY);
	}

	// 盒子用到
	/** 获取电源 0 关，1 开 */
	public int getPower() {
		return getStatusInt(POWER_KEY);
	}

	/** 风向 */
	public int getWindDirection() {
		return getStatusInt(WIND_DIRECTION_KEY);
	}

	/** 获取 温度值 设置 */
	public int getSetTemperature() {
		return getStatusInt(TEMPERATURE_KEY);
	}

	/** 湿度 */
	public int getHumidity() {
		return getStatusInt(HUMIDITY_KEY);
	}

	/** 体感室内温度 */
	public int getSomatosensoryRealityTemperature() {
		return getStatusInt(SOMATOSENSORY_INDOOR_TEMPERATURE_KEY);
	}

	/** 室内实际温度 跟盒子用到的那条一样 */
	public int getIndoorRealityTemperature() {
		return getStatusInt(INDOOR_REALITY_TEMPERATURE_KEY);
	}

	/** 室内盘管温度 */
	public int getIndoorPipeTemperature() {
		return getStatusInt(INDOOR_COILER_TEMPERATURE_KEY);
	}

	/** 室内实际湿度值 */
	public int getIndoorRealityHumidity() {
		return getStatusInt(INDOOR_REALITY_HUMIDITY_KEY);
	}

	/** 体感室内温度补偿 */
	public int getSomatosensoryCompensation() {
		return getStatusInt(SOMATOSENSORY_INDOOR_TEMPERATURE_KEY);
	}

	/** 体感控制 */
	public int getSomatosensoryContrl() {
		return getStatusInt(SOMATOSENSORY_CONTROL_KEY);
	}

	/** 自动工作模式和除湿模式的温度补偿 */
	public int getTemperatureCompensation() {
		return getStatusInt(AUTO_DEHUMI_TEMP_COMPENSATION_VALUE_KEY);
	}

	/** 华氏/摄氏温度显示设置 */
	public int getTemperatureValueSwitch() {
		return getStatusInt(FAHRENHEIT_OR_CELSIUS_SWITCH_KEY);
	}

	/** 普通定时开关机时间 */
	public int getGeneralTimingShutdownValue() {
		return getStatusInt(TIMING_VALID_KEY);
	}

	/** 实时时钟的小时值 */
	public int getRealityHour() {
		return getStatusInt(REAL_TIME_HOUR_KEY);
	}

	/** 实时时钟的分钟值 */
	public int getRealityMinute() {
		return getStatusInt(REAL_TIME_MINUTE_KEY);
	}

	/** 实时开机控制 */
	public int getRealityBootContrl() {
		return getStatusInt(REAL_TIME_POWER_ON_KEY);
	}

	/** 实时开机小时 */
	public int getRealityBootHour() {
		return getStatusInt(REAL_TIME_POWER_ON_HOUR_KEY);
	}

	/** 实时开机分钟 */
	public int getRealityBootMinute() {
		return getStatusInt(REAL_TIME_POWER_ON_MINUTE_KEY);
	}

	/** 实时关机控制 */
	public int getRealityShutdownContrl() {
		return getStatusInt(REAL_TIME_POWER_OFF_KEY);
	}

	/** 实时关机小时 */
	public int getRealityShutdownHour() {
		return getStatusInt(REAL_TIME_POWER_OFF_HOUR_KEY);
	}

	/** 实时关机分钟 */
	public int getRealityShutdownMinute() {
		return getStatusInt(REAL_TIME_POWER_OFF_MINUTE_KEY);
	}

	/** 除湿模式 */
	public String getDehumidificationMode() {
		return getStatusString(DEHUMIDIFY_MODE_KEY);
	}

	/** 上下风门 位置 垂直(上下)导风板位置 */
	public String getVerticalWindMode() {
		return getStatusString(VERTICAL_WIND_POSITION_KEY);
	}

	/** 上下风开停控制 */
	public int getVerticalWindContrl() {
		return getStatusInt(VERTICAL_WIND_POWER_KEY);
	}

	/** 左右风开停控制 */
	public int getHorizontalWindContrl() {
		return getStatusInt(HORIZONTAL_WIND_POWER_KEY);
	}

	/** 自然风开停控制 */
	public int getNatureWindContrl() {
		return getStatusInt(NATURAL_WIND_KEY);
	}

	/** 电加热 */
	public int getElectricalHeating() {
		return getStatusInt(ELECTRICAL_HEATING_KEY);
	}

	/** 节能 */
	public int getEnergyConservation() {
		return getStatusInt(ENERGY_SAVING_KEY);
	}

	/** 并用节电 */
	public int getShare() {
		return getStatusInt(AND_POWER_SAVING_KEY);
	}

	/** 双模 */
	public int getDualMode() {
		return getStatusInt(DUAL_MODE_KEY);
	}

	/** 清新 */
	public int getFreshness() {
		return getStatusInt(FRESH_AIR_KEY);
	}

	/** 换风 */
	public int getFreshAir() {
		return getStatusInt(AIR_EXCHANGE_CONTROL_KEY);
	}

	/** 室内清洁 */
	public int getCleanIndoor() {
		return getStatusInt(INDOOR_CLEAN_KEY);
	}

	/** 室外清洁 */
	public int getCleanOutdoor() {
		return getStatusInt(OUTDOOR_CLEAN_KEY);
	}

	/** 智慧眼 */
	public int getSmartEye() {
		return getStatusInt(SMART_EYE_KEY);
	}

	// 盒子用到
	/** 静音 */
	public int getMute() {
		return getStatusInt(MUTE_KEY);
	}

	/** 语音 */
	public int getVoice() {
		return getStatusInt(VOICE_KEY);
	}

	/** 除烟 */
	public int getCleanSmoke() {
		return getStatusInt(CLEAN_SMOKE_KEY);
	}

	/** 背景灯 */
	public int getBackgroundLamp() {
		return getStatusInt(BACKGROUND_LIGHT_KEY);
	}

	/** 显示屏发光 */
	public int getScreen() {
		return getStatusInt(SCREEN_LIGHT_KEY);
	}

	// 盒子用到
	/** LED指示灯 */
	public int getLED() {
		return getStatusInt(LED_LIGHT_KEY);
	}

	/** 室内外温度切换显示 这里so库状态查询没有和设置的键保持一致 */
	public int getIndoorOutdoorSwitch() {
		return getStatusInt("TempSwhShow");
	}

	/** 室内过滤网清洁复位控制 */
	public int getIndoorFilterClear() {
		return getStatusInt(INDOOR_FILTER_CLEAN_KEY);
	}

	/** 左风摆 */
	public int getLeftWind() {
		return getStatusInt(LEFT_WIND_SWING_KEY);
	}

	/** 右风摆 */
	public int getRightWind() {
		return getStatusInt(RIGHT_WIND_SWING_KEY);
	}

	/** 室内电量板 */
	public int getChargeBorad() {
		return getStatusInt(INDOOR_ECLECTRIC_QUALITY_BOARD_KEY);
	}

	/** 本次命令之前是否有过红外遥控与按键控制过 */
	public int getHaveIRContrl() {
		return getStatusInt(HAD_IR_CONTROL_KEY);
	}

	/** 本次命令之前是否有过WIFI控制过 */
	public int getHaveWIFIContrl() {
		return getStatusInt(HAD_WIFI_CONTROL_KEY);
	}

	/** 空调正常机型与测试机型 */
	// 暂未找到键
	// public int getModel() {
	// return ZD[52];
	// }

	/** 室内EEPROM在线升级 */
	public int getEEPROMUpdate() {
		return getStatusInt(INDOOR_UPDATE_EPM_KEY);
	}

	/** 室内温度传感器故障 */
	public int getIndoorTemperatureSensorTrouble() {
		return getStatusInt(INDOOR_TEMPERATURE_SENSOR_ERROR_KEY);
	}

	/** 室内盘管温度传感器故障 */
	public int getIndoorPipeTemperatureSensorTrouble() {
		return getStatusInt(INDOOR_COILER_TEMPERATURE_SENSOR_ERROR_KEY);
	}

	/** 室内湿度传感器故障 */
	public int getIndoorHumiditySensorTrouble() {
		return getStatusInt(INDOOR_COILER_TEMPERATURE_SENSOR_ERROR_KEY);
	}

	/** 室内排水泵故障 */
	public int getIndoorDrainsWaterPumpTrouble() {
		return getStatusInt(INDOOR_PUMP_ERROR_KEY);
	}

	/** 室内风机电机运转异常故障 */
	public int getIndoorFanMotorTrouble() {
		return getStatusInt(INDOOR_WIND_MOTOR_ERROR_KEY);
	}

	/** 柜机格栅保护告警 */
	public int getPioneerGrillingProtectTrouble() {
		return getStatusInt(GRATING_PROTECTED_ERROR_KEY);
	}

	/** 室内电压过零检测故障 */
	public int getIndoorVoltageZeroCrossDetectionTrouble() {
		return getStatusInt(INDOOR_VOLTAGE_ERROR_KEY);
	}

	/** 室内外通信故障 */
	public int getIndoorOutdoorCommunicationTrouble() {
		return getStatusInt(INDOOR_OUTDOOR_COMMUNICATION_ERROR_KEY);
	}

	/** 室内控制板与显示板通信故障 */
	public int getIndoorContrlScreenCommunicationTrouble() {
		return getStatusInt(SHOW_PANEL_COMMUNICATION_ERROR_KEY);
	}

	/** 室内控制板与按键板通信故障 */
	public int getIndoorContrlKeypadCommunicationTrouble() {
		return getStatusInt(KEY_PANEL_COMMUNICATION_ERROR_KEY);
	}

	/** WIFI控制板与室内控制板通信故障 */
	public int getIndoorContrlWIFICommunicationTrouble() {
		return getStatusInt(WIFI_COMMUNICATION_ERROR_KEY);
	}

	/** 室内控制板与室内电量板通信故障 */
	public int getIndoorContrlChargeCommunicationTrouble() {
		return getStatusInt(POWER_COMMUNICATION_ERROR_KEY);
	}

	/** 室内控制板EEPROM出错 */
	public int getIndoorContrlEEPROMTrouble() {
		return getStatusInt(INDOOR_EEPROM_ERROR_KEY);
	}

	/** 运行频率 */
	public int getRunFrequency() {
		return getStatusInt(RUN_RATE_KEY);
	}

	/** 目标频率 */
	public int getTargetFrequency() {
		return getStatusInt(TARGET_RATE_KEY);
	}

	/** 发给驱动器的频率 */
	public int getDriveFrequency() {
		return getStatusInt(SEND_TO_DRIVER_RATE_KEY);
	}

	/** 室外环境温度 */
	public int getEnvironmentTemperature() {
		return getStatusInt(TEMPERATURE_OUTDOOR_KEY);
	}

	/** 冷凝器温度 */
	public int getCondenserTemperature() {
		return getStatusInt(TEMPERATURE_CONDENSATOR_KEY);
	}

	/** 排气温度 */
	public int getExhaustTemperature() {
		return getStatusInt(TEMPERATURE_VENTING_KEY);
	}

	/** 目标排气温度 */
	public int getTargetExhaustTemperature() {
		return getStatusInt(TEMPERATURE_TARGET_VENTING_KEY);
	}

	/** 室外电子膨胀阀开度 */
	public int getOutdoorElectronicExpansion() {
		return getStatusInt("OutESwellTemp");
	}

	/** UABH */
	public int getUABH() {
		return getStatusInt("UABH");
	}

	/** UABL */
	public int getUABL() {
		return getStatusInt("UABL");
	}

	/** UBCH */
	public int getUBCH() {
		return getStatusInt("UBCH");
	}

	/** UBCL */
	public int getUBCL() {
		return getStatusInt("UBCL");
	}

	/** UCAH */
	public int getUCAH() {
		return getStatusInt("UCAH");
	}

	/** UCAL */
	public int getUCAL() {
		return getStatusInt("UCAL");
	}

	/** IAB */
	public int getIAB() {
		return getStatusInt("IAB");
	}

	/** IBC */
	public int getIBC() {
		return getStatusInt("IBC");
	}

	/** ICA */
	public int getICA() {
		return getStatusInt("ICA");
	}

	/** IUV */
	public int getIUV() {
		return getStatusInt("IUV");
	}

	/** 直流母线电压H */
	public int getCocurrentBusVoltageH() {
		return getStatusInt("IBusH");
	}

	/** 直流母线电压L */
	public int getCocurrentBusVoltageL() {
		return getStatusInt("IBusL");
	}

	/** 四通阀状态 */
	public int getFourWayLimen() {
		return getStatusInt("Gate4");
	}

	/** 室外机实际工作状态 */
	public int getOutdoorRealityRuning() {
		return getStatusInt("OutRWork");
	}

	/** 风机运行状态 */
	public int getFanRuning() {
		return getStatusInt("WindMWork");
	}

	/** 室外机强制室内机风门位置 */
	public int getOutdoorForceIndoorWindPosition() {
		return getStatusInt("OutFoceInWGate");
	}

	/** 室外机强制室内机风速 */
	public int getOutdoorForceIndoorWindSpeed() {
		return getStatusInt("OutFoceInWRate");
	}

	/** 室外机强制室内机停 */
	public int getOutdoorForceIndoorStop() {
		return getStatusInt("OutFoceInPOff");
	}

	/** 温控关机 */
	public int getShutdownByTemperatureContrl() {
		return getStatusInt("TempCtlPOff");
	}

	/** 一拖多标志 */
	public int getOne4All() {
		return getStatusInt("OneDrvMuti");
	}

	/** 除湿阀标志 */
	public int getDehumidifierLimen() {
		return getStatusInt("DhumiGate");
	}

	/** 室外机化霜 */
	public int getOutdoorDefrosting() {
		return getStatusInt("OutDefrost");
	}

	/** 室外旁通化霜 */
	public int getOutdoorBypassDefrosting() {
		return getStatusInt("OutSideDefrost");
	}

	/** 回油标志 */
	public int getOilReturn() {
		return getStatusInt("RefluxOil");
	}

	/** 室外故障显示标志 */
	public int getOutdoorTroubleDisplay() {
		return getStatusInt("ShowOutErr");
	}

	/** 室外机EEPROM在线下载标志 */
	public int getOutdoorEEPROMDownload() {
		return getStatusInt("OutEPMDL");
	}

	/** 室外机电量板 是否有 */
	public int getOutdoorChargeBoard() {
		return getStatusInt("HasOutPwr");
	}

	/** 压缩机电热带 */
	public int getcompressorRibbonHeater() {
		return getStatusInt("CompressEHeat");
	}

	/** 压缩机预加热 */
	public int getcompressorBeforeHandheat() {
		return getStatusInt("PerHeatCompress");
	}

	/*** 补气增晗 */
	public int getReinflation() {
		return getStatusInt("PumpAir");
	}

	/** 室内外机模式冲突 */
	public int getOutdoorModeClash() {
		return getStatusInt("OutConflictErr");
	}

	/** 室外EEPROM出错 */
	public int getOutdoorEEPROMTrouble() {
		return getStatusInt("OutEPMErr");
	}

	/** 室外盘管温度传感器故障 */
	public int getOutdoorPipeTemperatureSensorTrouble() {
		return getStatusInt("OutCoilerSnrErr");
	}

	/** 排气温度传感器故障 */
	public int getOutdoorExhausTemperatureSensorTrouble() {
		return getStatusInt("VentingTempSnrErr");
	}

	/** 室外环境温度传感器故障 */
	public int getOutdoorEnvironmentTemperatureSensorTrouble() {
		return getStatusInt("OutTempSnrErr");
	}

	/** 电压变压器故障 */
	public int getVoltageTransformerTrouble() {
		return getStatusInt("TransformerSnrErr");
	}

	/** 电流互感器故障 */
	public int getCurrentTransformerTrouble() {
		return getStatusInt("CTSnrErr");
	}

	/** 室外控制与驱动通信故障 */
	public int getOutdoorContrlDriveCommunicationTrouble() {
		return getStatusInt("OutCtlDrvCommErr");
	}

	/** IPM模块过流保护 */
	public int getIPMOvercurrentProtect() {
		return getStatusInt("IPMOverT");
	}

	/** IPM模块过热保护 */
	public int getIPMOverheatingProtect() {
		return getStatusInt("IPMOverT");
	}

	/** 交流电过电压保护 */
	public int getAlternatingCurrentOvervoltageProtect() {
		return getStatusInt("ACOverV");
	}

	/** 交流电欠电压保护 */
	public int getAlternatingCurrentUndervoltageProtect() {
		return getStatusInt("ACUnderV");
	}

	/** 母线电压过电压保护 */
	public int getBusbarVoltageOvervoltageProtect() {
		return getStatusInt("BusOverV");
	}

	/** 母线电压欠电压保护 */
	public int getBusbarVoltageUndervoltageProtect() {
		return getStatusInt("BusUnderV");
	}

	/** PFC过电流保护 */
	public int getPFCOvercurrentProtect() {
		return getStatusInt("PFCOverC");
	}

	/** 室外机最大电流保护 */
	public int getOutdoorMaximumCurrentProtect() {
		return getStatusInt("OutMaxC");
	}

	/** 室外环境温度过低保护 */
	public int getOutdooEnvironmentOvertemperatureProtect() {
		return getStatusInt("OutUnderTemp");
	}

	/** 排气温度过高保护 */
	public int getExhaustOvertemperatureProtect() {
		return getStatusInt("VentingTempOver");
	}

	/** 压缩机管壳温度保护 */
	public int getCompressoPipeShellTemperatureProtect() {
		return getStatusInt("CompressPipeTemp");
	}

	/** 室内防冻结或防过载保护 */
	public int getIndoorAntiFreezingProtect() {
		return getStatusInt("InFreezeOrOL");
	}

	/** 室外机PFC保护 */
	public int getOutdoorPFCProtect() {
		return getStatusInt("OutPFC");
	}

	/** 压缩机启动失败 */
	public int getCompressoBootFail() {
		return getStatusInt("CompressStartFail");
	}

	/** 压缩机失步 */
	public int getCompressoStepOut() {
		return getStatusInt("CompressStepOut");
	}

	/** 室外风机堵转 */
	public int getOutdoorFanLockRotor() {
		return getStatusInt("OutWindMotorLR");
	}

	/** 室外盘管防过载保护 */
	public int getOutdoorPieOverloadProtect() {
		return getStatusInt("OutCoilerOL");
	}

	/** 冷媒泄漏 */
	public int getRefrigerantLeakage() {
		return getStatusInt("RefrigerantLeak");
	}

	/** 压缩机型号匹配错误 */
	public int getCompressoModelMismatch() {
		return getStatusInt("MatchCompressType");
	}

	/** 系统低频振动保护 */
	public int getSystemLowFrequencyVibrationProtect() {
		return getStatusInt("OSLowFreq");
	}

	/** 室外散热器温度过高保护 */
	public int getOutdoorRadiatorOvertemperatureProtect() {
		return getStatusInt("OutRadiatorHTemp");
	}

	/** 系统压力过高保护 */
	public int getSystemHypertonusProtect() {
		return getStatusInt("OSPressH");
	}

	/** 逆变器直流过电压故障 */
	public int getInverterCocurrentOvervoltageTrouble() {
		return getStatusInt("InverterDCOverVErr");
	}

	/** 逆变器直流低电压故障 */
	public int getInverterCocurrentUndervoltageTrouble() {
		return getStatusInt("InverterDCLowVErr");
	}

	/** 逆变器交流过电流故障 */
	public int getInverterCocurrentOvercurrentTrouble() {
		return getStatusInt("InverterACOverCErr");
	}

	/** 失步检出 */
	public int getStepOutDetection() {
		return getStatusInt("StepOutCheck");
	}

	// 暂未找到 键
	// /** 速度推定脉冲检出法检出欠相故障 */
	// public int getSpeedPulseFault() {
	// return getStatusInt("StepOutCheck");
	// }
	//
	// /** 电流推定脉冲检出法检出欠相故障 */
	// public int getCurrentPulseFault() {
	// return ZD[140];
	// }

	/** 逆变器IPM故障-边沿 */
	public int getInverterEdgeFault() {
		return getStatusInt("InverterIPMEdgErr");
	}

	/** 逆变器IPM故障-电平 */
	public int getInverterLevelFault() {
		return getStatusInt("InverterIPMLevErr");
	}

	/** PFC_IPM故障-边沿 */
	public int getPFC_IPMEdgeFault() {
		return getStatusInt("PFCIPMEdgErr");
	}

	/** PFC_IPM故障-电平 */
	public int getPFC_IPMLevelFault() {
		return getStatusInt("PFCIPMLevErr");
	}

	/** PFC停电检出故障 */
	public int getPFCPowerCutFault() {
		return getStatusInt("PFCPOffCheckErr");
	}

	/** PFC过电流检出故障 */
	public int getPFCOvercurrentFault() {
		return getStatusInt("PFCOverCCheckErr");
	}

	/** 直流电压检出异常 */
	public int getDCVException() {
		return getStatusInt("DCVCheckErr");
	}

	/** PFC低电压（有效值）检出故障 */
	public int getPFCLowVoltageFault() {
		return getStatusInt("PFCLowVCheckErr");
	}

	/** AD偏置异常检出故障 */
	public int getADOffsetAnomaliesFault() {
		return getStatusInt("ADOffsetCheckErr");
	}

	/** 逆变器PWM逻辑设置故障 */
	public int getInverterPWMLogicFault() {
		return getStatusInt("InverterPWMLgcSetErr");
	}

	/** 逆变器PWM初始化故障 */
	public int getInverterPWMInitFault() {
		return getStatusInt("InverterPWMInitErr");
	}

	/** PFC_PWM逻辑设置故障 */
	public int getPFCPWMLogicFault() {
		return getStatusInt("PFCPWMLgcSetErr");
	}

	/** PFC_PWM初始化故障 */
	public int getPFC_PWMInitFault() {
		return getStatusInt("PFCPWMInitErr");
	}

	/** 温度异常 */
	public int getTemperatureAnomaly() {
		return getStatusInt("TempErr");
	}

	// 暂未找到键
	// /** 电流采样电阻不平衡调整故障 */
	// public int getCurrentSamplingFault() {
	// return ZD[155];
	// }

	/** 电机参数设置故障 */
	public int getMotorDataFault() {
		return getStatusInt("MotorParamSetErr");
	}

	/** MCE故障 */
	public int getMCEFault() {
		return getStatusInt("MCEErr");
	}

	/** 驱动EEPROM故障 */
	public int getEEPROMFault() {
		return getStatusInt("EPMDrvErr");
	}

	/** 室外盘管过载禁升频 */
	public int getOutdoorCoilOverloadUpFrequency() {
		return getStatusInt("OutCoilerOLNoUp");
	}

	/** 室外盘管过载降频 */
	public int getOutdoorCoilOverloadDownFrequency() {
		return getStatusInt("OutCoilerOLToDown");
	}

	/** 室内盘管过载禁升频 */
	public int getIndoorCoilOverloadUpFrequency() {
		return getStatusInt("InCoilerOLNoUp");
	}

	/** 室内盘管过载降频 */
	public int getIndoorCoilOverloadDownFrequency() {
		return getStatusInt("InCoilerOLToDown");
	}

	/** 压降排气过载禁升频 */
	public int getPressureUpFrequency() {
		return getStatusInt("LowPressOLNoUp");
	}

	/** 压降排气过载降频 */
	public int getPressureDownFrequency() {
		return getStatusInt("LowPressOLToDown");
	}

	/** 室内盘管冻结禁升频 */
	public int getIndoorCoilFreezingUpFrequency() {
		return getStatusInt("InCoilerFreezeOLToUp");
	}

	/** 室内盘管冻结降频 */
	public int getIndoorCoilFreezingDownFrequency() {
		return getStatusInt("InCoilerFreezeOLToDown");
	}

	/** 室内外通信降频 */
	public int getCommunicationDownFrequency() {
		return getStatusInt("InCommOutToDown");
	}

	/** 模块温度过载限频 */
	public int getModuleTemperaturelimitFrequency() {
		return getStatusInt("AdustLimit");
	}

	/** 变调率限频 */
	public int getModulationRatelimitFrequency() {
		return getStatusInt("ModuleTempOLLimit");
	}

	/** 相电流限频 */
	public int getPhaseCurrentlimitFrequency() {
		return getStatusInt("PhaseCLimit");
	}

	/** 并用节电保护禁升频 */
	public int getPowerSaveUpFrequency() {
		return getStatusInt("ShareECONoUp");
	}

	/** 并用节电保护降频 */
	public int getPowerSaveDownFrequency() {
		return getStatusInt("ShareECOLimit");
	}

	/** 过电流保护禁升频 */
	public int getOvercurrentUpFrequency() {
		return getStatusInt("OverCNoUp");
	}

	/** 过电流保护降频 */
	public int getOvercurrentDownFrequency() {
		return getStatusInt("OverCToDown");
	}

	/** 室内风机转速xx */
	public int getIndoorFanSpeedH() {
		return getStatusInt("InWindMotorSpeed");
	}

	/** 室外风机转速00xx */
	public int getIndoorFanSpeed00L() {
		return getStatusInt("OutWindMotorSpeed");
	}

	/** 有否PM2.5检测功能 */
	public int getPM25() {
		return getStatusInt("HasPM25Detect");
	}

	/** PM2.5污染程度 */
	public int getPM25Level() {
		return getStatusInt("PM25Level");
	}

	/** 空气PM2.5质量百分比表示 */
	public int getPM25Percent() {
		return getStatusInt("AirQualityLevel");
	}

	/** 显示屏亮度值 */
	public int getScreenLuminance() {
		return getStatusInt("Brightness");
	}

	/** 普通定时开关机有效 */
	public int getGeneralTimingShutdown() {
		return getStatusInt(TIMING_VALID_KEY);
	}

	/*************************************** 功能使能查询及设置 *************************************************/
	// 功能表
	// getFNEN
	/** 获取 室内风量支持档位数 */
	public int getWindSpeedNumFN() {
		return getDeviceFunctionEnable("WindLevelS");
	}

	/** 设置睡眠模式 */
	public int getSleepModeFN() {
		return getDeviceFunctionEnable("SleepModes");
	}

	/** 单冷/冷暖 机型 */
	public int getCoolModeFN() {
		return getDeviceFunctionEnable("SColdOrWarm");
	}

	/** 开/关机 */
	public int getPowerFN() {
		return getDeviceFunctionEnable("KeyCtl");
	}

	/** 室内单个风向控制功能 */
	public int getWindDirectionFN() {
		return getDeviceFunctionEnable("InWindDirCtl");
	}

	/** 设置温度 */
	public int getTemperatureFN() {
		return getDeviceFunctionEnable("InTempSet");
	}

	/** 设置湿度 */
	public int getHumidityFN() {
		return getDeviceFunctionEnable("InHumiSet");
	}

	/** 体感控制,体感室内温度,体感室内温度补偿 */
	public int getSomatosensoryRealityTemperatureFN() {
		return getDeviceFunctionEnable("InHumTempMKP");
	}

	/** 自动工作模式和除湿模式的温度补偿 */
	public int getTemperatureCompensationFN() {
		return getDeviceFunctionEnable("ABSAutoDehumiTempMKP");
	}

	/** 华氏/摄氏温度显示设置 */
	public int getTemperatureValueSwitchFN() {
		return getDeviceFunctionEnable("FCSwitch");
	}

	/** 普通定时关机,普通定时关机时间 */
	public int getGeneralTimingShutdownFN() {
		return getDeviceFunctionEnable("TimingCtl");
	}

	/** 实时开机控制,实时时钟的小时值,实时时钟的分钟值,实时开机小时,实时开机分钟 */
	public int getRealityTimeFN() {
		return getDeviceFunctionEnable("RTTimingCtl");
	}

	/** 6位置可定室内风门位置控制 */
	public int getVerticalWindModeNum() {
		return getDeviceFunctionEnable("WindGatePos6");
	}

	/** 上下风门模式,上下风开停控制 */
	public int getVerticalWindFN() {
		return getDeviceFunctionEnable("WindUpDown");
	}

	/** 左右风开停控制,左风摆,右风摆 */
	public int getHorizontalWindFN() {
		return getDeviceFunctionEnable("WindLeftRight");
	}

	/** 自然风开停 */
	public int getNatureWindFN() {
		return getDeviceFunctionEnable("NaturalWindCtl");
	}

	/** 设置电加热 */
	public int getElectricalHeatingFN() {
		return getDeviceFunctionEnable("EHeatCtl");
	}

	/** 除湿模式 */
	public int getDehumidificationModeFN() {
		return getDeviceFunctionEnable("DehumiModes");
	}

	/** 设置节能 */
	public int getEnergyConservationFN() {
		return getDeviceFunctionEnable("ECOCtl");
	}

	/** 设置并用节电 */
	public int getShareFN() {
		return getDeviceFunctionEnable("ShareECO");
	}

	/** 设置高效/强力/快速冷热 */
	public int getEfficientFN() {
		return getDeviceFunctionEnable("TurboCtl");
	}

	/** 设置双模 */
	public int getDualModeFN() {
		return getDeviceFunctionEnable("DualModeCtl");
	}

	/** 设置清新 */
	public int getFreshnessFN() {
		return getDeviceFunctionEnable("FreshCtl");
	}

	/** 设置换风 */
	public int getFreshAirFN() {
		return getDeviceFunctionEnable("CWindCtl");
	}

	/** 设置室内清洁 */
	public int getCleanIndoorFN() {
		return getDeviceFunctionEnable("InCleanCtl");
	}

	/** 设置室外清洁 */
	public int getCleanOutdoorFN() {
		return getDeviceFunctionEnable("OutCleanCtl");
	}

	/** 设置室智能眼 */
	public int getSmartEyeFN() {
		return getDeviceFunctionEnable("SmartEyeCtl");
	}

	/** 设置室静音 功能使能 */
	public int getMuteFN() {
		return getDeviceFunctionEnable("QuietCtl");
	}

	/** 设置室静音 功能 */
	public int getMuteFN(boolean isFunction) {
		return getDeviceFunction("QuietCtl");
	}

	/** 设置语音 */
	public int getVoiceFN() {
		return getDeviceFunctionEnable("VoiceCtl");
	}

	/** 设置除烟 */
	public int getCleanSmokeFN() {
		return getDeviceFunctionEnable("CleanFog");
	}

	/** 背景灯 */
	public int getBackgroundLampFN() {
		return getDeviceFunctionEnable("BGKCtl");
	}

	/** 显示屏发光 */
	public int getScreenFN() {
		return getDeviceFunctionEnable("PanelLight");
	}

	/** LED指示灯 */
	public int getLEDFN() {
		return getDeviceFunctionEnable("LedCtl");
	}

	/** 室内外温度切换显示 */
	public int getIndoorOutdoorSwitchFN() {
		return getDeviceFunctionEnable("InOutSwhShow");
	}

	/** 室内过滤网清洁复位控制 */
	public int getIndoorFilterClearFN() {
		return getDeviceFunctionEnable("RSTIndrFilter");
	}

	/** 左风摆开停控制 */
	public int getLeftFanContrlFN() {
		return getDeviceFunctionEnable("LSwept");
	}

	/** 右风摆开停控制 */
	public int getRightFanContrlFN() {
		return getDeviceFunctionEnable("RSwept");
	}

	/** 控制规则 */
	public int getContrlRate() {
		return getDeviceFunctionEnable("HisenseKelonSwh");
	}

	// setFNEN
	/** 设置 风量 */
	private void setWindSpeedFN(int value) {
		setDeviceFunctionEnable("WindLevelS", value);
	}

	/** 设置睡眠模式 */
	private void setSleepModeFN(int value) {
		setDeviceFunctionEnable("SleepModes", value);
	}

	// 设置模式
	/** 单冷/冷暖 机型 */
	private void setCoolModeFN(int value) {
		setDeviceFunctionEnable("SColdOrWarm", value);
	}

	/** 开/关机 */
	private void setPowerFN(int value) {
		setDeviceFunctionEnable("KeyCtl", value);
	}

	/** 设置温度 */
	private void setTemperatureFN(int value) {
		setDeviceFunctionEnable("InTempSet", value);
	}

	/** 设置湿度 */
	private void setHumidityFN(int value) {
		setDeviceFunctionEnable("InHumiSet", value);
	}

	/** 体感控制,体感室内温度,体感室内温度补偿 */
	private void setSomatosensoryRealityTemperatureFN(int value) {
		setDeviceFunctionEnable("InHumTempMKP", value);
	}

	/** 自动工作模式和除湿模式的温度补偿 */
	private void setTemperatureCompensationFN(int value) {
		setDeviceFunctionEnable("ABSAutoDehumiTempMKP", value);
	}

	/** 华氏/摄氏温度显示设置 */
	private void setTemperatureValueSwitchFN(int value) {
		setDeviceFunctionEnable("FCSwitch", value);
	}

	/** 普通定时关机,普通定时关机时间 */
	private void setGeneralTimingShutdownFN(int value) {
		setDeviceFunctionEnable("TimingCtl", value);
	}

	/** 实时开机控制,实时时钟的小时值,实时时钟的分钟值,实时开机小时,实时开机分钟 */
	private void setRealityTimeFN(int value) {
		setDeviceFunctionEnable("RTTimingCtl", value);
	}

	/** 上下风门模式,上下风开停控制 */
	private void setVerticalWindFN(int value) {
		setDeviceFunctionEnable("WindUpDown", value);
	}

	/** 左右风开停控制,左风摆,右风摆 */
	private void setHorizontalWindFN(int value) {
		setDeviceFunctionEnable("WindLeftRight", value);
	}

	/** 自然风开停 */
	private void setNatureWindFN(int value) {
		setDeviceFunctionEnable("NaturalWindCtl", value);
	}

	/** 设置电加热 */
	private void setElectricalHeatingFN(int value) {
		setDeviceFunctionEnable("EHeatCtl", value);
	}

	/** 除湿模式 */
	private void setDehumidificationModeFN(int value) {
		setDeviceFunctionEnable("DehumiModes", value);
	}

	/** 设置节能 */
	private void setEnergyConservationFN(int value) {
		setDeviceFunctionEnable("ECOCtl", value);
	}

	/** 设置并用节电 */
	private void setShareFN(int value) {
		setDeviceFunctionEnable("ShareECO", value);
	}

	/** 设置高效/强力/快速冷热 */
	private void setEfficientFN(int value) {
		setDeviceFunctionEnable("TurboCtl", value);
	}

	/** 设置双模 */
	private void setDualModeFN(int value) {
		setDeviceFunctionEnable("DualModeCtl", value);
	}

	/** 设置清新 */
	private void setFreshnessFN(int value) {
		setDeviceFunctionEnable("FreshCtl", value);
	}

	/** 设置换风 */
	private void setFreshAirFN(int value) {
		setDeviceFunctionEnable("CWindCtl", value);
	}

	/** 设置室内清洁 */
	private void setClernIndoorFN(int value) {
		setDeviceFunctionEnable("InCleanCtl", value);
	}

	/** 设置室外清洁 */
	private void setClernOutdoorFN(int value) {
		setDeviceFunctionEnable("OutCleanCtl", value);
	}

	/** 设置室智能眼 */
	private void setSmartEyeFN(int value) {
		setDeviceFunctionEnable("SmartEyeCtl", value);
	}

	/** 设置室静音 */
	private void setMuteFN(int value) {
		setDeviceFunctionEnable("QuietCtl", value);
	}

	/** 设置语音 */
	private void setVoiceFN(int value) {
		setDeviceFunctionEnable("VoiceCtl", value);
	}

	/** 设置除烟 */
	private void setClernSmokeFN(int value) {
		setDeviceFunctionEnable("CleanFog", value);
	}

	/** 背景灯 */
	private void setBackgroundLampFN(int value) {
		setDeviceFunctionEnable("BGKCtl", value);
	}

	/** 显示屏发光 */
	private void setScreenFN(int value) {
		setDeviceFunctionEnable("PanelLight", value);
	}

	/** LED指示灯 */
	private void setLEDFN(int value) {
		setDeviceFunctionEnable("LedCtl", value);
	}

	/** 室内外温度切换显示 */
	private void setIndoorOutdoorSwitchFN(int value) {
		setDeviceFunctionEnable("InOutSwhShow", value);
	}

	/** 室内过滤网清洁复位控制 */
	private void setIndoorFilterClearFN(int value) {
		setDeviceFunctionEnable("RSTIndrFilter", value);
	}

	/** 左风摆开停控制 */
	private void setLeftAirDoorControlFN(int value) {
		setDeviceFunctionEnable("LSwept", value);
	}

	/** 右风摆开停控制 */
	private void setRightAirDoorControlFN(int value) {
		setDeviceFunctionEnable("RSwept", value);
	}

	/** 海信/科龙控制规则 */
	private void setKelonOrHisenseControlRuleFN(int value) {
		setDeviceFunctionEnable("HisenseKelonSwh", value);
	}

	/******************************** 初始化空调功能 ********************************************/
	/** 初始化空调功能 */
	private void initAirConditionerFunctions() {
		// setFNEN
		/** 1设置 风量 */
		setWindSpeedFN(1);
		/** 2设置睡眠模式 */
		setSleepModeFN(1);
		/** 3单冷/冷暖 机型 */
		// setCoolModeFN(0); // 默认不可设置
		/** 4开/关机 */
		setPowerFN(1);
		/** 5室内单个风向控制功能 */
		setDeviceFunctionEnable("InWindDirCtl", 0);
		/** 6设置温度 */
		setTemperatureFN(1);
		/** 7设置湿度 */
		setHumidityFN(0);
		/** 8体感控制,体感室内温度,体感室内温度补偿 */
		setSomatosensoryRealityTemperatureFN(0);
		/** 9自动工作模式和除湿模式的温度补偿 */
		setTemperatureCompensationFN(0);
		/** 10华氏/摄氏温度显示设置 */
		setTemperatureValueSwitchFN(0);
		/** 11普通定时关机,普通定时关机时间 */
		setGeneralTimingShutdownFN(0);
		/** 12实时定时开关机 */
		setRealityTimeFN(1);
		/** 13 6位置可定室内风门位置控制KTVFM */
		setDeviceFunctionEnable("WindGatePos6", 0);
		/** 14上下风门模式,上下风开停控制 */
		setVerticalWindFN(1);
		/** 15左右风开停控制,左风摆,右风摆 */
		setHorizontalWindFN(1);
		/** 16自然风开停 */
		setNatureWindFN(1);
		/** 17设置电加热 */
		setElectricalHeatingFN(1);
		/** 18除湿模式 */
		setDehumidificationModeFN(0);
		/** 设置节能 */
		setEnergyConservationFN(0);
		/** 设置并用节电 */
		setShareFN(0);
		/** 设置高效/强力/快速冷热 */
		setEfficientFN(1);
		/** 设置双模 */
		setDualModeFN(1);
		/** 设置清新 */
		setFreshnessFN(10);
		/** 设置换风 */
		setFreshAirFN(0);
		/** 设置室内清洁 */
		setClernIndoorFN(1);
		/** 设置室外清洁 */
		setClernOutdoorFN(1);
		/** 设置室智能眼 */
		setSmartEyeFN(0);
		/** 设置室静音 */
		setMuteFN(1);
		/** 设置语音 */
		setVoiceFN(0);
		/** 设置除烟 */
		setClernSmokeFN(0);
		/** 背景灯 */
		setBackgroundLampFN(1);
		/** 显示屏发光 */
		setScreenFN(0);
		/** LED指示灯 */
		setLEDFN(0);
		/** 室内外温度切换显示 */
		setIndoorOutdoorSwitchFN(0);
		/** 室内过滤网清洁复位控制 */
		setIndoorFilterClearFN(0);
		/** 左风摆开停控制 */
		setLeftAirDoorControlFN(0);
		/** 右风摆开停控制 */
		setRightAirDoorControlFN(0);
		/** 海信/科龙控制规则 */
		setKelonOrHisenseControlRuleFN(0);

		/** 将设置好的功能使能赋给功能 保存 */
		setInitFunctions();
	}
}
