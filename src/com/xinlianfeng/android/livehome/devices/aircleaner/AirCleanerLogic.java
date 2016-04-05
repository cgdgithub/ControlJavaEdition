package com.xinlianfeng.android.livehome.devices.aircleaner;

import com.xinlianfeng.android.livehome.devices.base.DevicesLogic;

public class AirCleanerLogic extends DevicesLogic {

	/** 清新机设备类型 */
	private static final int AIRCLEANER_TYPE = 0x18;
	/** 清新机设备地址 */
	private static final int AIRCLEANER_ADDRESS = 0x01;

	/** 清新机 风速 字符串 */
	public static final String WIND_SPEED_WEAK = "weak";
	public static final String WIND_SPEED_MIDDLE = "middle";
	public static final String WIND_SPEED_STRONG = "strong";
	public static final String WIND_SPEED_CLEAR = "clear";
	public static final String WIND_SPEED_AUTO = "auto";

	/** 清新机 模式 字符串 */
	public static final String MODE_CLEARDUST = "cleardust";
	public static final String MODE_CLEARSMELL = "clearsmell";
	public static final String MODE_SMART = "smart";
	public static final String MODE_MUTE = "mute";
	public static final String MODE_SLEEP = "sleep";

	// 清新机 命 令 key:
	/** 查询 */
	private static final String QUERY_KEY = "ACQUERY";
	/** 模式 */
	private static final String MODE_KEY = "Mode";
	/** 风速 净化速度 */
	private static final String WIND_SPEED_KEY = "CleanSpeed";
	/** 儿童锁 */
	private static final String CHILD_LOCK_KEY = "ChildLock";
	/** 水离子 */
	private static final String WATER_ION_KEY = "WaterIons";
	/** 加湿 开关 */
	private static final String HUMIDIFIER_POWER_KEY = "HumidifySet";
	/** 湿度值 设置 */
	private static final String HUMIDITY_VALUE_SET_KEY = "HumidifyVal";
	/** 湿度值 室内 */
	private static final String HUMIDITY_VALUE_INDOOR_KEY = "Humi";
	/** 定时有效 */
	private static final String TIMING_VALID_KEY = "Timing";
	/** 定时值 */
	private static final String TIMING_VALUE_KEY = "TimingVal";
	/** 负离子开关 */
	private static final String ANION_POWER_KEY = "WaterIons";

	// 查询 key:
	/** 空气质量等级 */
	private static final String AIR_QUALITY_DEGREE_KEY = "AirCnd";
	/** 空气质量百分比 */
	private static final String AIR_QUALITY_KEY = "AirCndPcnt";
	/** 风机转速 */
	private static final String MOTOR_SPEED_KEY = "MotorSpeed";

	// Box相关
	/** 加湿 当前时间 */
	private long setHumidityCurrentTime = 0;
	/** 加湿时间更新标志位 */
	private boolean timeHumidityUpdateFlag = true;
	/** 负离子时间更新标志位 */
	private boolean timeAnionUpdateFlag = true;
	/** 除尘 PM2.5 cleardust更新标志位 */
	private boolean timeClearDustUpdateFlag = true;
	/** 除尘 PM2.5 cleardust当前时间 */
	private long setClearDustCurrentTime = 0;
	/** 负离子开关 当前时间 */
	private long setAnionCurrentTime = 0;

	// 功能初始化相关
	/** 功能 键 数组 */
	public static String[] airCleanerFunctionsKeyArray = { "FAuto", "FCSmoke", "WStrong", "WMid", "WWeak", "FSleep",
			"FMute", "FSmart", "FCSmell", "FCDust", "FTiming", "ChildLock", "WaterIons", "HumidifySet", "Power",
			"FEPPROM", "FQCeck" };

	/** 功能 值 数组 */
	public static String airCleanerFunctionsValueString = "1,1,0,1,1,1,1,1,0,0,1,0,0,0,1,1,0,0";

	public AirCleanerLogic() {
		CMD_SET_KEY = "PFSet";
		CMD_QUERY_STATUS_KEY = "PFQuery";
		CMD_QUERY_FUNCTION_KEY = "PFFctn";
		DEVICE_TYPE = AIRCLEANER_TYPE;
		DEVICE_SUB_ADDRESS = AIRCLEANER_ADDRESS;
		// 初始化空调功能
		// initAirCleanerFunctions(); // 初始化清新机功能
		functionsKeyArray = airCleanerFunctionsKeyArray;
		setInitDeviceFunctions(airCleanerFunctionsValueString);
		initAirCleanerStatus(); // 初始化清新机状态 屏蔽错误报警
	}

	/*************************************** 初始化清新机功能 *************************************************/
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
			for (int i = 0; i < functionsKeyLength; i++) {
				setDeviceFunctionEnable(functionsKeyArray[i], functionsValueIntArray[i]);
			}
			// 将 功能对象使能 赋值给 功能
			deviceAllFunctions = deviceFunctionEnable;
			// Log.d(TAG, "deviceAllFunctions : " + deviceAllFunctions);
		}
	}

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
			int humidity, int soundSet) {
		// smart/mute/sleep任一模式下，风速不能操作，默认为auto
		if (mode.equals(MODE_MUTE) || mode.equals(MODE_SLEEP) || mode.equals(MODE_SMART)) {
			windSpeed = WIND_SPEED_AUTO;
		}

		if (humidity < 40 || humidity > 80) {
			humidity = 50;
		}
		String command = formatStringToJSONSetCmd(POWER_KEY, power, MODE_KEY, mode, WIND_SPEED_KEY, windSpeed,
				WATER_ION_KEY, anionPower, HUMIDIFIER_POWER_KEY, humidifierPower, HUMIDITY_VALUE_SET_KEY, humidity,
				SOUND_KEY, soundSet);
		setStatusSave(POWER_KEY, power);
		setStatusSave(MODE_KEY, mode);
		setStatusSave(WIND_SPEED_KEY, windSpeed);
		setStatusSave(ANION_POWER_KEY, anionPower);
		setStatusSave(HUMIDIFIER_POWER_KEY, humidifierPower);
		setStatusSave(HUMIDITY_VALUE_SET_KEY, humidity);
		setStatusSave(SOUND_KEY, soundSet);
		return createNetBytes(command);
	}

	/******************************** 功能设置 ********************************************/
	/** 电源 power : 设置功能:开机[0/1]，提示声[0/1] */
	public byte[] setPower(int power, int soundSet) {
		if (getCheckedError()) {
			return errorByte;
		}
		String command = formatStringToJSONSetCmd(POWER_KEY, power, SOUND_KEY, soundSet);
		setStatusSave(POWER_KEY, power); // 设置电源状态
		return createNetBytes(command);
	}

	/** 风速 设置功能:风量[weak/middle/strong/clear/auto]，提示声[0/1] */
	public byte[] setWindSpeed(String windSpeed, int soundSet) {
		if (getCheckedError()) {
			return errorByte;
		}
		if (getMode().equals(MODE_SMART) || getMode().equals(MODE_SLEEP) || getMode().equals(MODE_MUTE)) {
			return errorByte;
		}
		String command = formatStringToJSONSetCmd(WIND_SPEED_KEY, windSpeed, SOUND_KEY, soundSet);
		setStatusSave(WIND_SPEED_KEY, windSpeed);
		return createNetBytes(command);
	}

	/** 模式 设置功能:模式[cleardust/clearsmell/smart/mute/sleep]，提示声[0/1] */
	public byte[] setMode(String mode, int soundSet) {
		if (getCheckedError()) {
			return errorByte;
		}
		if (mode.equals(MODE_SLEEP) || mode.equals(MODE_SMART) || mode.equals(MODE_MUTE)) {
			setCleanSpeedAutoFN(0);
		} else {
			setCleanSpeedAutoFN(1);
		}
		String command = formatStringToJSONSetCmd(MODE_KEY, mode, SOUND_KEY, soundSet);
		setStatusSave(MODE_KEY, mode);
		return createNetBytes(command);
	}

	/**
	 * 定时开关机 设置功能:普通定时开关机[1-23],普通定时有效位[0/1]，提示声[0/1]
	 * 定时时间格式严格为Val=0,取消定时,val[1~20],定时val*0.5小时,val=[21~34]定时10+(val-20) 小时
	 * 
	 * 注意：清新机不支持以半小时为单位的定时设置，如 不支持timingValue=3,3*0.5=1.5
	 * 
	 * 定时时间格式严格为[0-23]小时，以整小时为单位,0表示取消
	 */
	public byte[] setTimingSwitchMachine(int timingEnable, int timingValue, int soundSet) {
		if (getCheckedError()) {
			return errorByte;
		}
		if (timingValue >= 0 && timingValue <= 10) {
			timingValue = timingValue * 2;
		} else if (timingValue > 10 && timingValue < 24) {
			timingValue = timingValue + 10;
		}
		String command = formatStringToJSONSetCmd(TIMING_VALID_KEY, timingEnable, TIMING_VALUE_KEY, timingValue,
				SOUND_KEY, soundSet);
		setStatusSave(TIMING_VALID_KEY, timingEnable);
		setStatusSave(TIMING_VALUE_KEY, timingValue);
		return createNetBytes(command);
	}

	/** 儿童锁 开关 设置功能:儿童锁[0/1]，提示声[0/1] */
	public byte[] setChildClockPower(int childClockPower, int soundSet) {
		if (getCheckedError()) {
			return errorByte;
		}
		String command = formatStringToJSONSetCmd(CHILD_LOCK_KEY, childClockPower, SOUND_KEY, soundSet);
		setStatusSave(CHILD_LOCK_KEY, childClockPower);
		return createNetBytes(command);
	}

	/** 水离子 开关 设置功能:水离子[0/1]，提示声[0/1] */
	public byte[] setWaterIonPower(int waterIonPower, int soundSet) {
		if (getCheckedError()) {
			return errorByte;
		}
		String command = formatStringToJSONSetCmd(WATER_ION_KEY, waterIonPower, SOUND_KEY, soundSet);
		setStatusSave(WATER_ION_KEY, waterIonPower);
		return createNetBytes(command);
	}

	/** 加湿器开关 设置功能:加湿机开关[0/1]，提示声[0/1] */
	public byte[] setHumidifierPower(int humidifierPower, int soundSet) {
		if (getCheckedError()) {
			return errorByte;
		}
		String command = formatStringToJSONSetCmd(HUMIDIFIER_POWER_KEY, humidifierPower, SOUND_KEY, soundSet);
		setStatusSave(HUMIDIFIER_POWER_KEY, humidifierPower);
		return createNetBytes(command);
	}

	/** 加湿 湿度值 设置功能:加湿机设置[40/80]，提示声[0/1] */
	public byte[] setHumidityValue(int humidityValue, int soundSet) {
		if (getCheckedError()) {
			return errorByte;
		}
		if (humidityValue < 40 || humidityValue > 80) {
			return errorByte;
		}
		String command = formatStringToJSONSetCmd(HUMIDITY_VALUE_SET_KEY, humidityValue, SOUND_KEY, soundSet);
		setStatusSave(HUMIDITY_VALUE_SET_KEY, humidityValue);
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
		// 加湿，持续时间
		if (getHumidityPower() == 1) { // 与当前状态不同，重新计时
			if (timeHumidityUpdateFlag) {
				setHumidityCurrentTime = System.currentTimeMillis(); // 设置开机 当前时间
				timeHumidityUpdateFlag = false;
			}
		} else {
			setHumidityCurrentTime = 0; //
			timeHumidityUpdateFlag = true;
		}
		// 负离子，持续时间
		if (getAnionPower() == 1) { // 与当前状态不同，重新计时
			if (timeAnionUpdateFlag) {
				setAnionCurrentTime = System.currentTimeMillis(); // 设置开机 当前时间
				timeAnionUpdateFlag = false;
			}
		} else {
			setAnionCurrentTime = 0; //
			timeAnionUpdateFlag = true;
		}
		// 除尘 PM2.5 cleardust持续时间
		if (getMode().equals("cleardust")) { // 与当前状态不同，重新计时
			if (timeClearDustUpdateFlag) {
				setClearDustCurrentTime = System.currentTimeMillis(); // 设置开机 当前时间
				timeClearDustUpdateFlag = false;
			}
		} else {
			setClearDustCurrentTime = 0; //
			timeClearDustUpdateFlag = true;
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

	/******************************** 状态查询 ********************************************/
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
	/** 获取 加湿，持续时间 */
	public long getHumidifyDuration() {
		if (setHumidityCurrentTime == 0) {
			return durationTimeError;
		}
		durationTime = System.currentTimeMillis() - setHumidityCurrentTime;
		return durationTime;
	}

	// 盒子用
	/** 获取 除尘 PM2.5 cleardust持续时间 */
	public long getSetClearDustModeDuration() {
		if (setClearDustCurrentTime == 0) {
			return durationTimeError;
		}
		durationTime = System.currentTimeMillis() - setClearDustCurrentTime;
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

	// 盒子用
	/** 获取 负离子开关，持续时间 */
	public long getAnionDuration() {
		if (setAnionCurrentTime == 0) {
			return durationTimeError;
		}
		durationTime = System.currentTimeMillis() - setAnionCurrentTime;
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
	/** 获取 模式[cleardust/clearsmell/smart/mute/sleep] */
	public String getMode() {
		return getStatusString(MODE_KEY);
	}

	// 盒子用到
	/** 获取 风量[weak/middle/strong/clear/auto] */
	public String getWindSpeed() {
		return getStatusString(WIND_SPEED_KEY);
	}

	// 盒子用到
	/** 湿度 设置值 */
	public int getHumidityValueSet() {
		return getStatusInt(HUMIDITY_VALUE_SET_KEY);
	}

	// 盒子用到
	/** 加湿状态 */
	public int getHumidityPower() {
		return getStatusInt(HUMIDIFIER_POWER_KEY);
	}

	// 盒子用到
	/** 负离子开关状态 */
	public int getAnionPower() {
		return getStatusInt(ANION_POWER_KEY);
	}

	// 盒子用到
	/** 室内湿度 */
	public int getHumidifyIndoor() {
		return getStatusInt(HUMIDITY_VALUE_INDOOR_KEY);
	}

	/** 定时开关机控制 是否有效 */
	public int getTimeStatus() {
		return getStatusInt(TIMING_VALID_KEY);
	}

	/** 定时开关机时间, */
	public String getTimerValue() {
		return getStatusString(TIMING_VALUE_KEY);
	}

	/** 风机转速, */
	public int getMotorSpeed() {
		return getStatusInt(MOTOR_SPEED_KEY);
	}

	// 盒子用到
	/** 空气质量, 洁净度 空气质量 */
	public int getAirQuality() {
		return getStatusInt(AIR_QUALITY_DEGREE_KEY);
	}

	/** 空气质量百分比, */
	public int getAirQualityPercent() {
		return getStatusInt("AirCndPcnt");
	}

	/** 相对湿度, */
	public int getRelativeHumidityValue() {
		return getStatusInt("Humi");
	}

	// 盒子用到
	/** 开停净化机, 获取电源 0 关，1 开 */
	public int getPower() {
		return getStatusInt(POWER_KEY);
	}

	/** 儿童锁开关控制, */
	public int getChildLockStatus() {
		return getStatusInt(CHILD_LOCK_KEY);
	}

	/** 水离子开停控制, */
	public int getWaterionStatus() {
		return getStatusInt(WATER_ION_KEY);
	}

	/** 加湿机开停控制, */
	public int getHumidityStatus() {
		return getStatusInt(HUMIDIFIER_POWER_KEY);
	}

	/** 过滤网更换提示, */
	public int getChangeFilterError() {
		return getStatusInt("steamStrainer");
	}

	/** 加湿转轮不动, */
	public int getHumidityWheelError() {
		return getStatusInt("HumiWellErr");
	}

	/** 水箱空, */
	public int getWaterSinkEmptyError() {
		return getStatusInt("TankEmpty");
	}

	/** 水箱未装好, */
	public int getWaterSinkNotSetup() {
		return getStatusInt("TankPosErr");
	}

	/** 湿度传感器故障, */
	public int getHumiditySensorError() {
		return getStatusInt("InHumiSnrErr");
	}

	/** 风机故障, */
	public int getMotorError() {
		return getStatusInt("InWindMotorErr");
	}

	/** 风尘传感器故障, */
	public int getDustSensorError() {
		return getStatusInt("DustSnrErr");
	}

	/** 气味传感器故障, */
	public int getSmellSensorError() {
		return getStatusInt("SmellSnrErr");
	}

	/** 机器倾斜故障 */
	public int getLeanError() {
		return getStatusInt("MachineLeanErr");
	}

	/** 湿度设置值 */
	public int getSettingHumid() {
		return getStatusInt("HumidifyVal");
	}

	/** 检测是否有 风机 倾斜故障 滤网更换提示 */
	public boolean getCheckedError() {
		if (getMotorError() == 1 || getLeanError() == 1 || getChangeFilterError() == 1) {
			return true;
		} else {
			return false;
		}
	}

	/******************************** 功能使能查询及设置 ********************************************/
	// *************************** getFNEN ***************************
	/** 1净化速度状态-自动功能， */
	public int getCleanSpeedAutoFN() {
		return getDeviceFunctionEnable("FAuto");
	}

	/** 2净化速度状态-净烟功能 ， */
	public int getCleanSpeedDelSmokeFN() {
		return getDeviceFunctionEnable("FCSmoke");
	}

	/** 3净化速度状态-高风功能 */
	public int getCleanSpeedHighFN() {
		return getDeviceFunctionEnable("WStrong");
	}

	/** 4净化速度状态-中风功能， */
	public int getCleanSpeedMiddleFN() {
		return getDeviceFunctionEnable("WMid");
	}

	/** 5净化速度状态-低风功能， */
	public int getCleanSpeedLowFN() {
		return getDeviceFunctionEnable("WWeak");
	}

	/** 6净化模式状态-睡眠功能， */
	public int getCleanModeSleepFN() {
		return getDeviceFunctionEnable("FSleep");
	}

	/** 7净化模式状态-静音功能， */
	public int getCleanModeMuteFN() {
		return getDeviceFunctionEnable("FMute");
	}

	/** 8净化模式状态-智能功能， */
	public int getCleanModeSmartFN() {
		return getDeviceFunctionEnable("FSmart");
	}

	/** 9净化模式状态-除味功能， */
	public int getCleanModeDelTasteFN() {
		return getDeviceFunctionEnable("FCSmell");
	}

	/** 10净化模式状态-除烟功能， */
	public int getCleanModeDelSmokeFN() {
		return getDeviceFunctionEnable("FCDust");
	}

	/** 11普通定时功能， */
	public int getGeneralTimingFN() {
		return getDeviceFunctionEnable("FTiming");
	}

	/** 12儿童锁功能， */
	public int getChildLockFN() {
		return getDeviceFunctionEnable("ChildLock");
	}

	/** 13水离子开停， */
	public int getWaterIonFN() {
		return getDeviceFunctionEnable("WaterIons");
	}

	/** 14加湿机开停功能， */
	public int getDehumidifierFN() {
		return getDeviceFunctionEnable("HumidifySet");
	}

	/** 15净化机开停功能 */
	public int getCleanMachineFN() {
		return getDeviceFunctionEnable("Power");
	}

	/** 16 EEPROM可改写功能, */
	public int getEEpromReadWriteFN() {
		return getDeviceFunctionEnable("FEPPROM");
	}

	/** 17电量检测功能, */
	public int getPowerDetectFN() {
		return getDeviceFunctionEnable("FQCeck");
	}

	// setFNEN
	/** 1净化速度状态-自动功能， */
	public void setCleanSpeedAutoFN(int value) {
		setDeviceFunctionEnable("FAuto", value);
	}

	/** 2净化速度状态-净烟功能 ， */
	public void setCleanSpeedDelSmokeFN(int value) {
		setDeviceFunctionEnable("FCSmoke", value);
	}

	/** 3净化速度状态-高风功能 */
	public void setCleanSpeedHighFN(int value) {
		setDeviceFunctionEnable("WStrong", value);
	}

	/** 4净化速度状态-中风功能， */
	public void setCleanSpeedMiddleFN(int value) {
		setDeviceFunctionEnable("WMid", value);
	}

	/** 5净化速度状态-低风功能， */
	public void setCleanSpeedLowFN(int value) {
		setDeviceFunctionEnable("WWeak", value);
	}

	/** 6净化模式状态-睡眠功能， */
	public void setCleanModeSleepFN(int value) {
		setDeviceFunctionEnable("FSleep", value);
	}

	/** 7净化模式状态-静音功能， */
	public void setCleanModeMuteFN(int value) {
		setDeviceFunctionEnable("FMute", value);
	}

	/** 8净化模式状态-智能功能， */
	public void setCleanModeSmartFN(int value) {
		setDeviceFunctionEnable("FSmart", value);
	}

	/** 9净化模式状态-除味功能， */
	public void setCleanModeDelTasteFN(int value) {
		setDeviceFunctionEnable("FCSmell", value);
	}

	/** 10净化模式状态-除烟功能， */
	public void setCleanModeDelSmokeFN(int value) {
		setDeviceFunctionEnable("FCDust", value);
	}

	/** 11普通定时功能， */
	public void setGeneralTimingFN(int value) {
		setDeviceFunctionEnable("FTiming", value);
	}

	/** 12儿童锁功能， */
	public void setChildLockFN(int value) {
		setDeviceFunctionEnable("ChildLock", value);
	}

	/** 13水离子开停， */
	public void setWaterIonFN(int value) {
		setDeviceFunctionEnable("WaterIons", value);
	}

	/** 14加湿机开停功能， */
	public void setDehumidifierFN(int value) {
		setDeviceFunctionEnable("HumidifySet", value);
	}

	/** 15净化机开停功能 */
	public void setCleanMachineFN(int value) {
		setDeviceFunctionEnable("Power", value);
	}

	/** 16 EEPROM可改写功能, */
	public void setEEpromReadWriteFN(int value) {
		setDeviceFunctionEnable("FEPPROM", value);
	}

	/** 17电量检测功能, */
	public void setPowerDetectFN(int value) {
		setDeviceFunctionEnable("FQCeck", value);
	}

	/******************************** 初始化清新机功能 ********************************************/
	/** 初始化清新机功能 */
	private void initAirCleanerFunctions() {
		// setFNEN
		/** 1净化速度状态-自动功能， */
		setCleanSpeedAutoFN(1);
		/** 2净化速度状态-净烟功能 ， */
		setCleanSpeedDelSmokeFN(1);
		/** 3净化速度状态-高风功能 */
		setCleanSpeedHighFN(1);
		/** 4净化速度状态-中风功能， */
		setCleanSpeedMiddleFN(1);
		/** 5净化速度状态-低风功能， */
		setCleanSpeedLowFN(1);
		/** 6净化模式状态-睡眠功能， */
		setCleanModeSleepFN(1);
		/** 7净化模式状态-静音功能， */
		setCleanModeMuteFN(1);
		/** 8净化模式状态-智能功能， */
		setCleanModeSmartFN(1);
		/** 9净化模式状态-除味功能， */
		setCleanModeDelTasteFN(1);
		/** 10净化模式状态-除烟功能， */
		setCleanModeDelSmokeFN(1);
		/** 11普通定时功能， */
		setGeneralTimingFN(1);
		/** 12儿童锁功能， */
		setChildLockFN(1);
		/** 13水离子开停， */
		setWaterIonFN(1);
		/** 14加湿机开停功能， */
		setDehumidifierFN(1);
		/** 15净化机开停功能 */
		setCleanMachineFN(1);
		/** 16 EEPROM可改写功能, */
		setEEpromReadWriteFN(0);
		/** 17电量检测功能, */
		setPowerDetectFN(0);
		/** 将设置好的功能使能赋给功能 保存 */
		setInitFunctions();
	}

	/******************************** 初始化清新机状态 ********************************************/
	/** 初始化清新机功能 */
	private void initAirCleanerStatus() {
		setStatusSave("InWindMotorErr", 0);
		setStatusSave("MachineLeanErr", 0);
		setStatusSave("steamStrainer", 0);
	}

}
