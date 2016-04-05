package com.xinlianfeng.android.livehome.devices.dehumidifier;

import com.xinlianfeng.android.livehome.devices.base.DevicesControl;

public class DehumidifierControl extends DevicesControl implements IDehumidifierControl {

	private static final String TAG = "DehumidifierControl";
	/** 逻辑类 */
	private DehumidifierLogic dehumidifierLogic = null;

	public DehumidifierControl() {
		dehumidifierLogic = new DehumidifierLogic();
		super.devicesLogic = dehumidifierLogic;
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
	@Override
	public byte[] setBoxAirDehumidifier(int power, String mode, String windSpeed, int humidity, int soundSet) {
		if (null != dehumidifierLogic) {
			byte[] command = dehumidifierLogic.setBoxAirDehumidifier(power, mode, windSpeed, humidity, soundSet);
			return command;
		}
		return errorByte;
	}

	/*********************************** 功能设置 *******************************************/
	/** 1 电源 power : 0关，1开 soundSet : 0无声音，1开声音 */
	@Override
	public byte[] setPower(int power, int soundSet) {
		if (null != dehumidifierLogic) {
			byte[] command = dehumidifierLogic.setPower(power, soundSet);
			return command;
		}
		return errorByte;
	}

	/** 风速 设置功能:风量[weak/strong/auto]，提示声[0/1] */
	@Override
	public byte[] setWindSpeed(String windSpeed, int soundSet) {
		if (null != dehumidifierLogic) {
			byte[] command = dehumidifierLogic.setWindSpeed(windSpeed, soundSet);
			return command;
		}
		return errorByte;
	}

	/** 模式 设置功能:模式[continue/normal/auto]，提示声[0/1] */
	@Override
	public byte[] setMode(String mode, int soundSet) {
		if (mode.equals("heat")) {
			return errorByte;
		}
		if (null != dehumidifierLogic) {
			byte[] command = dehumidifierLogic.setMode(mode, soundSet);
			return command;
		}
		return errorByte;
	}

	/** 定时开关机 设置功能：定时有效位[0/1],Val=0,取消定时,val[1~20],定时val*0.5小时,val=[21~34]定时10+(val-20) 小时,提示声[0/1] */
	@Override
	public byte[] setTimingSwitchMachine(int timingEnable, int timingValue, int soundSet) {
		if (null != dehumidifierLogic) {
			byte[] command = dehumidifierLogic.setTimingSwitchMachine(timingEnable, timingValue, soundSet);
			return command;
		}
		return errorByte;
	}

	/** 湿度 湿度值 设置功能:加湿机设置[30/80]，提示声[0/1] */
	@Override
	public byte[] setHumidityValue(int humidityValue, int soundSet) {
		if (null != dehumidifierLogic) {
			byte[] command = dehumidifierLogic.setHumidityValue(humidityValue, soundSet);
			return command;
		}
		return errorByte;
	}

	/** 温度 设置功能 ：温度值[18-30]，提示声[0/1] */
	@Override
	public byte[] setTemperature(int temperature, int soundSet) {
		if (null != dehumidifierLogic) {
			byte[] command = dehumidifierLogic.setTemperature(temperature, soundSet);
			return command;
		}
		return errorByte;
	}

	/** 电加热 开关 设置功能:电加热[0/1]，提示声[0/1] */
	@Override
	public byte[] setElectricalHeating(int electricalHeating, int soundSet) {
		if (null != dehumidifierLogic) {
			byte[] command = dehumidifierLogic.setElectricalHeating(electricalHeating, soundSet);
			return command;
		}
		return errorByte;
	}

	/** 水泵 开关 设置功能:水泵[0/1]，提示声[0/1] */
	@Override
	public byte[] setWaterPumpPower(int waterPump, int soundSet) {
		if (null != dehumidifierLogic) {
			byte[] command = dehumidifierLogic.setWaterPumpPower(waterPump, soundSet);
			return command;
		}
		return errorByte;
	}

	/** 负离子 开关 设置功能:负离子 开关[0/1]，提示声[0/1] */
	@Override
	public byte[] setAnionPower(int anionPower, int soundSet) {
		if (null != dehumidifierLogic) {
			byte[] command = dehumidifierLogic.setAnionPower(anionPower, soundSet);
			return command;
		}
		return errorByte;
	}

	/*********************************** 状态查询 *******************************************/
	// 暂时只有盒子用
	/** 获取 设置开机后，持续时间 */
	@Override
	public long getSetPowerOnDuration() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getSetPowerOnDuration();
		}
		return errorInt;
	}

	// 盒子用
	/** 获取 设置关机后，持续时间 */
	@Override
	public long getSetPowerOffDuration() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getSetPowerOffDuration();
		}
		return errorInt;
	}

	// 盒子用
	/** 获取 设置模式后，持续时间 */
	@Override
	public long getSetModeDuration() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getSetModeDuration();
		}
		return errorInt;
	}

	/** 获取 帧内序号 0~15 */
	@Override
	public int getSequence() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getSequence();
		}
		return errorInt;
	}

	/** 获取 操作结果 */
	@Override
	public String getResult() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getResult();
		}
		return errorString;
	}

	// 盒子用到
	/** 获取 风量[weak/strong/auto] */
	@Override
	public String getWindSpeed() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getWindSpeed();
		}
		return errorString;
	}

	// 盒子用到
	/** 获取 模式[continue/normal/auto] */
	@Override
	public String getMode() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getMode();
		}
		return errorString;
	}

	// 盒子用到
	/** 获取电源 0 关，1 开 */
	@Override
	public int getPower() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getPower();
		}
		return errorInt;
	}

	// 盒子用到
	/** 湿度 设置值 */
	@Override
	public int getHumidityValueSet() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getHumidityValueSet();
		}
		return errorInt;
	}

	// 盒子用到
	/** 室内湿度值 */
	@Override
	public int getHumidityValueIndoor() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getHumidityValueIndoor();
		}
		return errorInt;
	}

	/** 定时开关机是否有效 */
	@Override
	public int getTimeValid() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getTimeValid();
		}
		return errorInt;
	}

	/** 定时开关机时间 */
	@Override
	public String getTimerValue() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getTimerValue();
		}
		return errorString;
	}

	/** 电加热 开关设定 */
	@Override
	public int getEletricalHeating() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getEletricalHeating();
		}
		return errorInt;
	}

	/** 室内实际温度 */
	@Override
	public int getIndoorTempStatus() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getIndoorTempStatus();
		}
		return errorInt;
	}

	/** 水泵开关 */
	@Override
	public int getWaterPumpStatus() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getWaterPumpStatus();
		}
		return errorInt;
	}

	/** 负离子开关 */
	@Override
	public int getAnionStatus() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getAnionStatus();
		}
		return errorInt;
	}

	/** 过滤网清洁告警 */
	@Override
	public int getFilterNetCleanWarning() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getFilterNetCleanWarning();
		}
		return errorInt;
	}

	/** 湿度传感器故障 */
	@Override
	public int getHumidSensorError() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getHumidSensorError();
		}
		return errorInt;
	}

	/** 管温传感器故障 */
	@Override
	public int getPumpTempratureError() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getPumpTempratureError();
		}
		return errorInt;
	}

	/** 室内温度传感器故障 */
	@Override
	public int getIndoorTempratureError() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getIndoorTempratureError();
		}
		return errorInt;
	}

	/** 水满警告 */
	@Override
	public int getWaterFullWarning() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getWaterFullWarning();
		}
		return errorInt;
	}

	/** 水泵故障 */
	@Override
	public int getWaterPumpWarning() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getWaterPumpWarning();
		}
		return errorInt;
	}

	/******************************** 功能使能查询及设置 ********************************************/
	// *************************** getFNEN ***************************
	/** 智慧风 */
	@Override
	public int getSmartWindFN() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getSmartWindFN();
		}
		return errorInt;
	}

	/** 高风 */
	@Override
	public int getHighWindFN() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getHighWindFN();
		}
		return errorInt;
	}

	/** 中风 */
	@Override
	public int getMediumWindFN() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getMediumWindFN();
		}
		return errorInt;
	}

	/** 低风 */
	@Override
	public int getLowWindFN() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getLowWindFN();
		}
		return errorInt;
	}

	/** 运行模式 持续运行 */
	@Override
	public int getContinueModeFN() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getContinueModeFN();
		}
		return errorInt;
	}

	/** 运行模式 正常运行 */
	@Override
	public int getNormalModeFN() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getNormalModeFN();
		}
		return errorInt;
	}

	/** 运行模式 自动运行 */
	@Override
	public int getAutoModeFN() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getAutoModeFN();
		}
		return errorInt;
	}

	/** 定时 */
	@Override
	public int getTimerControlFN() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getTimerControlFN();
		}
		return errorInt;
	}

	/** 电加热 */
	@Override
	public int getElectricHeatFN() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getElectricHeatFN();
		}
		return errorInt;
	}

	/** 电加热 温度 */
	@Override
	public int getElectricHeatSetTemperatureFN() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getElectricHeatSetTemperatureFN();
		}
		return errorInt;
	}

	/** 室内湿度 */
	@Override
	public int getIndoorHumidityFN() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getIndoorHumidityFN();
		}
		return errorInt;
	}

	/** 水泵 */
	@Override
	public int getWaterPumpFN() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getWaterPumpFN();
		}
		return errorInt;
	}

	/** 负离子 */
	@Override
	public int getAnionFN() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getAnionFN();
		}
		return errorInt;
	}

	/** 电量检测 */
	@Override
	public int getElectronicDetectFN() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getElectronicDetectFN();
		}
		return errorInt;
	}

	/** 电源 */
	@Override
	public int getPowerFN() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getPowerFN();
		}
		return errorInt;
	}

	/** EEPROM可改写功能 */
	@Override
	public int getEEPROMWriteFN() {
		if (null != dehumidifierLogic) {
			return dehumidifierLogic.getEEPROMWriteFN();
		}
		return errorInt;
	}
}
