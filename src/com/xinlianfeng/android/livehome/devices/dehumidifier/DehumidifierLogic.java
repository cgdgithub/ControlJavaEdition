package com.xinlianfeng.android.livehome.devices.dehumidifier;

import com.xinlianfeng.android.livehome.devices.base.DevicesLogic;

public class DehumidifierLogic extends DevicesLogic {

	/** 除湿机设备类型 */
	private static final int DEHUMIDIFIER_TYPE = 0x15;
	/** 除湿机设备地址 */
	private static final int DEHUMIDIFIER_ADDRESS = 0x01;

	// 除湿机 命 令 key:
	/** 模式 */
	private static final String MODE_KEY = "Mode";
	/** 风速 */
	private static final String WIND_SPEED_KEY = "WindSpeed";
	/** 温度 */
	private static final String TEMPERATURE_KEY = "SetTemp";
	/** 定时有效 */
	private static final String TIMING_VALID_KEY = "Timing";
	/** 定时值 */
	private static final String TIMING_VALUE_KEY = "TimingVal";
	/** 电加热 */
	private static final String ELECTRICAL_HEATING_KEY = "EHeating";
	// 新增 key
	/** 除湿 */
	private static final String DEHUMIDIFY_KEY = "HumiMode";
	/** 湿度值 设置 */
	private static final String HUMIDITY_VALUE_SET_KEY = "HumidifyVal";
	/** 湿度值 室内 */
	private static final String HUMIDITY_VALUE_INDOOR_KEY = "InHumi";
	/** 水泵 设置 */
	private static final String WATER_PUMP_KEY = "PumpSet";
	/** 负离子 设置 */
	private static final String ANION_KEY = "Anion";

	// 功能初始化相关
	/** 功能 键 数组 */
	public static String[] dehumidifierFunctionsKeyArray = { "WAuto", "WStrong", "WMid", "WWeak", "MContinue",
			"MNormal", "MAuto", "FTimer", "FEHeat", "FEHeatTemp", "FInHumi", "FPump", "FAnoon", "FQCeck", "FPower",
			"FEPPROM" };

	/** 功能 值 数组 */
	public static String dehumidifierFunctionsValueString = "1,1,0,1,1,1,1,1,0,0,1,0,0,0,1,1,0,0";

	public DehumidifierLogic() {
		CMD_SET_KEY = "DHSet";
		CMD_QUERY_STATUS_KEY = "DHQuery";
		CMD_QUERY_FUNCTION_KEY = "DHFctn";
		DEVICE_TYPE = DEHUMIDIFIER_TYPE;
		DEVICE_SUB_ADDRESS = DEHUMIDIFIER_ADDRESS;
		// 初始化空调功能
		// initDehumidifierFunctions(); // 初始化除湿机功能
		functionsKeyArray = dehumidifierFunctionsKeyArray;
		setInitDeviceFunctions(dehumidifierFunctionsValueString);
	}

	/*************************************** 初始化c除湿机功能 *************************************************/
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
	public byte[] setBoxAirDehumidifier(int power, String mode, String windSpeed, int humidity, int soundSet) {
		// auto 模式下 风速auto 湿度50
		if (mode.equals("auto")) {
			windSpeed = "auto";
			humidity = 50;
		}
		// continue 模式下 设置湿度无效
		if (mode.equals("continue")) {
			humidity = 50;
		}
		// 湿度范围：30-80
		if (humidity < 30 || humidity > 80) {
			humidity = 50;
		}
		String command = formatStringToJSONSetCmd(POWER_KEY, power, MODE_KEY, mode, WIND_SPEED_KEY, windSpeed,
				HUMIDITY_VALUE_SET_KEY, humidity, SOUND_KEY, soundSet);
		setStatusSave(POWER_KEY, power);
		setStatusSave(MODE_KEY, mode);
		setStatusSave(WIND_SPEED_KEY, windSpeed);
		setStatusSave(HUMIDITY_VALUE_SET_KEY, humidity);
		setStatusSave(SOUND_KEY, soundSet);
		return createNetBytes(command);
	}

	/*********************************** 功能设置 *******************************************/
	/** 电源 power 设置功能:开机[0/1]，提示声[0/1] */
	public byte[] setPower(int power, int soundSet) {
		if (getCheckedError()) {
			return errorByte;
		}
		String command = formatStringToJSONSetCmd(POWER_KEY, power, SOUND_KEY, soundSet);
		setStatusSave(POWER_KEY, power); // 设置电源状态
		return createNetBytes(command);
	}

	/** 风速 设置功能:风量[weak/strong/auto]，提示声[0/1] */
	public byte[] setWindSpeed(String windSpeed, int soundSet) {
		if (getCheckedError() || getMode().equals("auto")) {
			return errorByte;
		}
		String command = formatStringToJSONSetCmd(WIND_SPEED_KEY, windSpeed, SOUND_KEY, soundSet);
		setStatusSave(WIND_SPEED_KEY, windSpeed);
		return createNetBytes(command);
	}

	/** 模式 设置功能:模式[continue/normal/auto]，提示声[0/1] */
	public byte[] setMode(String mode, int soundSet) {
		if (getCheckedError()) {
			return errorByte;
		}
		setElectricHeatSetTemperatureFN(0);
		setIndoorHumidityFN(0);
		setSmartWindFN(1);
		setHighWindFN(1);
		setMediumWindFN(1);
		setLowWindFN(1);
		if (getEletricalHeating() == 1) {
			return errorByte;
		} else {
			if (mode.equals("auto")) {
				setSmartWindFN(0);
				setHighWindFN(0);
				setMediumWindFN(0);
				setLowWindFN(0);
			} else if (mode.equals("normal")) {
				setIndoorHumidityFN(1);
			}
		}
		String command = formatStringToJSONSetCmd(MODE_KEY, mode, SOUND_KEY, soundSet);
		setStatusSave(MODE_KEY, mode);
		return createNetBytes(command);
	}

	/** 定时开关机 设置功能：定时有效位[0/1],Val=0,取消定时,val[1~20],定时val*0.5小时,val=[21~34]定时10+(val-20) 小时,提示声[0/1] */
	public byte[] setTimingSwitchMachine(int timingEnable, int timingValue, int soundSet) {
		if (getCheckedError()) {
			return errorByte;
		}
		String command = formatStringToJSONSetCmd(TIMING_VALID_KEY, timingEnable, TIMING_VALUE_KEY, timingValue,
				SOUND_KEY, soundSet);
		setStatusSave(TIMING_VALID_KEY, timingEnable);
		setStatusSave(TIMING_VALUE_KEY, timingValue);
		return createNetBytes(command);
	}

	/** 湿度 湿度值 设置功能:加湿机设置[30/80]，提示声[0/1] */
	public byte[] setHumidityValue(int humidityValue, int soundSet) {
		if (getMode().equals("continue") || getMode().equals("auto")) {
			return errorByte;
		}
		if (humidityValue < 30 || humidityValue > 80) {
			return errorByte;
		}
		String command = formatStringToJSONSetCmd(HUMIDITY_VALUE_SET_KEY, humidityValue, SOUND_KEY, soundSet);
		setStatusSave(HUMIDITY_VALUE_SET_KEY, humidityValue);
		return createNetBytes(command);
	}

	/** 温度 设置功能 ：温度值[18-30]，提示声[0/1] */
	public byte[] setTemperature(int temperature, int soundSet) {
		if (temperature < 16 || temperature > 32) {
			return errorByte;
		}
		if (getElectricHeatFN() == 2) {
			return errorByte;
		}
		String command = formatStringToJSONSetCmd(TEMPERATURE_KEY, temperature, SOUND_KEY, soundSet);
		setStatusSave(TEMPERATURE_KEY, temperature);
		return createNetBytes(command);
	}

	/** 电加热 开关 设置功能:电加热[0/1]，提示声[0/1] */
	public byte[] setElectricalHeating(int electricalHeating, int soundSet) {
		if (getCheckedError()) {
			return errorByte;
		}
		if (electricalHeating == 1) {
			setContinueModeFN(0);
			setAutoModeFN(0);
			setNormalModeFN(0);
			setIndoorHumidityFN(0);
			setElectricHeatSetTemperatureFN(1);
		} else {
			setContinueModeFN(1);
			setAutoModeFN(1);
			setNormalModeFN(1);
			setIndoorHumidityFN(1);
		}
		String command = formatStringToJSONSetCmd(ELECTRICAL_HEATING_KEY, electricalHeating, SOUND_KEY, soundSet);
		setStatusSave(ELECTRICAL_HEATING_KEY, electricalHeating);
		return createNetBytes(command);
	}

	/** 水泵 开关 设置功能:水泵[0/1]，提示声[0/1] */
	public byte[] setWaterPumpPower(int waterPump, int soundSet) {
		if (getCheckedError()) {
			return errorByte;
		}
		if (getPower() == 0 || getWaterPumpWarning() == 1) {
			return errorByte;
		}
		String command = formatStringToJSONSetCmd(WATER_PUMP_KEY, waterPump, SOUND_KEY, soundSet);
		setStatusSave(WATER_PUMP_KEY, waterPump);
		return createNetBytes(command);
	}

	/** 负离子 开关 设置功能:负离子 开关[0/1]，提示声[0/1] */
	public byte[] setAnionPower(int anionPower, int soundSet) {
		if (getCheckedError()) {
			return errorByte;
		}
		if (getPower() == 0 || getWaterPumpWarning() == 1) {
			return errorByte;
		}
		String command = formatStringToJSONSetCmd(ANION_KEY, anionPower, SOUND_KEY, soundSet);
		setStatusSave(ANION_KEY, anionPower);
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
		// 获取 模式[continue/normal/auto]
		if (getMode().equals("auto")) {
			if (!lastMode.equals("auto")) {
				lastMode = getMode();
				setModeCurrentTime = System.currentTimeMillis(); // 设置模式 当前时间
			}
		} else if (getMode().equals("normal")) {
			if (!lastMode.equals("normal")) {
				lastMode = getMode();
				setModeCurrentTime = System.currentTimeMillis(); // 设置模式 当前时间
			}
		} else if (getMode().equals("continue")) {
			if (!lastMode.equals("continue")) {
				lastMode = getMode();
				setModeCurrentTime = System.currentTimeMillis(); // 设置模式 当前时间
			}
		}
		return parseResult;
	}

	/*********************************** 状态查询 *******************************************/
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
	/** 获取 风量[weak/strong/auto] */
	public String getWindSpeed() {
		return getStatusString(WIND_SPEED_KEY);
	}

	// 盒子用到
	/** 获取 模式[continue/normal/auto] */
	public String getMode() {
		return getStatusString(MODE_KEY);
	}

	// 盒子用到
	/** 获取电源 0 关，1 开 */
	public int getPower() {
		return getStatusInt(POWER_KEY);
	}

	// 盒子用到
	/** 湿度 设置值 */
	public int getHumidityValueSet() {
		return getStatusInt(HUMIDITY_VALUE_SET_KEY);
	}

	// 盒子用到
	/** 室内湿度值 */
	public int getHumidityValueIndoor() {
		return getStatusInt(HUMIDITY_VALUE_INDOOR_KEY);
	}

	/** 定时开关机是否有效 */
	public int getTimeValid() {
		return getStatusInt(TIMING_VALID_KEY);
	}

	/** 定时开关机时间 */
	public String getTimerValue() {
		return getStatusString(TIMING_VALUE_KEY);
	}

	/** 电加热 开关设定 */
	public int getEletricalHeating() {
		return getStatusInt(ELECTRICAL_HEATING_KEY);
	}

	/** 室内实际温度 */
	public int getIndoorTempStatus() {
		return getStatusInt("InTemp");
	}

	/** 水泵开关 */
	public int getWaterPumpStatus() {
		return getStatusInt(WATER_PUMP_KEY);
	}

	/** 负离子开关 */
	public int getAnionStatus() {
		return getStatusInt(ANION_KEY);
	}

	/** 过滤网清洁告警 */
	public int getFilterNetCleanWarning() {
		return getStatusInt("SteamStrainer");
	}

	/** 湿度传感器故障 */
	public int getHumidSensorError() {
		return getStatusInt("HumiSnrErr");
	}

	/** 管温传感器故障 */
	public int getPumpTempratureError() {
		return getStatusInt("PipeTempSnrErr");
	}

	/** 室内温度传感器故障 */
	public int getIndoorTempratureError() {
		return getStatusInt("TempSnrErr");
	}

	/** 水满警告 */
	public int getWaterFullWarning() {
		return getStatusInt("TankFull");
	}

	/** 水泵故障 */
	public int getWaterPumpWarning() {
		return getStatusInt("PumpErr");
	}

	/** 检测是否有 水满警告 */
	private boolean getCheckedError() {
		if (1 == getWaterFullWarning()) { // 水满
			return true;
		} else {
			return false;
		}
	}

	/******************************** 功能使能查询及设置 ********************************************/
	// *************************** getFNEN ***************************
	/** 智慧风 */
	public int getSmartWindFN() {
		return getDeviceFunctionEnable("WAuto");
	}

	/** 高风 */
	public int getHighWindFN() {
		return getDeviceFunctionEnable("WStrong");
	}

	/** 中风 */
	public int getMediumWindFN() {
		return getDeviceFunctionEnable("WMid");
	}

	/** 低风 */
	public int getLowWindFN() {
		return getDeviceFunctionEnable("WWeak");
	}

	/** 运行模式 持续运行 */
	public int getContinueModeFN() {
		return getDeviceFunctionEnable("MContinue");
	}

	/** 运行模式 正常运行 */
	public int getNormalModeFN() {
		return getDeviceFunctionEnable("MNormal");
	}

	/** 运行模式 自动运行 */
	public int getAutoModeFN() {
		return getDeviceFunctionEnable("MAuto");
	}

	/** 定时 */
	public int getTimerControlFN() {
		return getDeviceFunctionEnable("FTimer");
	}

	/** 电加热 */
	public int getElectricHeatFN() {
		return getDeviceFunctionEnable("FEHeat");
	}

	/** 电加热 温度 */
	public int getElectricHeatSetTemperatureFN() {
		return getDeviceFunctionEnable("FEHeatTemp");
	}

	/** 室内湿度 */
	public int getIndoorHumidityFN() {
		return getDeviceFunctionEnable("FInHumi");
	}

	/** 水泵 */
	public int getWaterPumpFN() {
		return getDeviceFunctionEnable("FPump");
	}

	/** 负离子 */
	public int getAnionFN() {
		return getDeviceFunctionEnable("FAnoon");
	}

	/** 电量检测 */
	public int getElectronicDetectFN() {
		return getDeviceFunctionEnable("FQCeck");
	}

	/** 电源 */
	public int getPowerFN() {
		return getDeviceFunctionEnable("FPower");
	}

	/** EEPROM可改写功能 */
	public int getEEPROMWriteFN() {
		return getDeviceFunctionEnable("FEPPROM");
	}

	// *************************** setFNEN ***************************
	/** 智慧风 */
	public void setSmartWindFN(int value) {
		setDeviceFunctionEnable("WAuto", value);
	}

	/** 高风 */
	public void setHighWindFN(int value) {
		setDeviceFunctionEnable("WStrong", value);
	}

	/** 中风 */
	public void setMediumWindFN(int value) {
		setDeviceFunctionEnable("WMid", value);
	}

	/** 低风 */
	public void setLowWindFN(int value) {
		setDeviceFunctionEnable("WWeak", value);
	}

	/** 运行模式 持续运行 */
	public void setContinueModeFN(int value) {
		setDeviceFunctionEnable("MContinue", value);
	}

	/** 运行模式 正常运行 */
	public void setNormalModeFN(int value) {
		setDeviceFunctionEnable("MNormal", value);
	}

	/** 运行模式 自动运行 */
	public void setAutoModeFN(int value) {
		setDeviceFunctionEnable("MAuto", value);
	}

	/** 定时 */
	public void setTimerControlFN(int value) {
		setDeviceFunctionEnable("FTimer", value);
	}

	/** 电加热 */
	public void setElectricHeatFN(int value) {
		setDeviceFunctionEnable("FEHeat", value);
	}

	/** 电加热 温度 */
	public void setElectricHeatSetTemperatureFN(int value) {
		setDeviceFunctionEnable("FEHeatTemp", value);
	}

	/** 室内湿度 */
	public void setIndoorHumidityFN(int value) {
		setDeviceFunctionEnable("FInHumi", value);
	}

	/** 水泵 */
	public void setWaterPumpFN(int value) {
		setDeviceFunctionEnable("FPump", value);
	}

	/** 负离子 */
	public void setAnionFN(int value) {
		setDeviceFunctionEnable("FAnoon", value);
	}

	/** 电量检测 */
	public void setElectronicDetectFN(int value) {
		setDeviceFunctionEnable("FQCeck", value);
	}

	/** 电源 */
	public void setPowerFN(int value) {
		setDeviceFunctionEnable("FPower", value);
	}

	/** EEPROM可改写功能 */
	public void setEEPROMWriteFN(int value) {
		setDeviceFunctionEnable("FEPPROM", value);
	}

	/******************************** 初始化除湿机功能 ********************************************/
	/** 初始化除湿机功能 */
	private void initDehumidifierFunctions() {
		/** 智慧风 */
		setSmartWindFN(1);
		/** 高风 */
		setHighWindFN(1);
		/** 中风 */
		setMediumWindFN(0);
		/** 低风 */
		setLowWindFN(1);
		/** 运行模式 持续运行 */
		setContinueModeFN(1);
		/** 运行模式 正常运行 */
		setNormalModeFN(1);
		/** 运行模式 自动运行 */
		setAutoModeFN(1);
		/** 定时 */
		setTimerControlFN(1);
		/** 电加热 */
		setElectricHeatFN(0);
		/** 电加热 温度 */
		setElectricHeatSetTemperatureFN(0);
		/** 室内湿度 */
		setIndoorHumidityFN(1);
		/** 水泵 */
		setWaterPumpFN(0);
		/** 负离子 */
		setAnionFN(1);
		/** 电量检测 */
		setElectronicDetectFN(0);
		/** 电源 */
		setPowerFN(1);
		/** EEPROM可改写功能 */
		setEEPROMWriteFN(1);

		/** 将设置好的功能使能赋给功能 保存 */
		setInitFunctions();
	}
}
