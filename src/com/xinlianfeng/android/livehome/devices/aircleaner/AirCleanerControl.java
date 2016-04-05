package com.xinlianfeng.android.livehome.devices.aircleaner;

import com.xinlianfeng.android.livehome.devices.base.DevicesControl;

public class AirCleanerControl extends DevicesControl implements IAirCleanerControl {

	private static final String TAG = "AirCleanerControl";
	/** 逻辑类 */
	private AirCleanerLogic airCleanerLogic = null;

	public AirCleanerControl() {
		airCleanerLogic = new AirCleanerLogic();
		super.devicesLogic = airCleanerLogic;
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
	@Override
	public byte[] setBoxAirPurifier(int power, String mode, String windSpeed, int anionPower, int humidifierPower,
			int humidity, int soundSet) {
		if (null != airCleanerLogic) {
			byte[] command = airCleanerLogic.setBoxAirPurifier(power, mode, windSpeed, anionPower, humidifierPower,
					humidity, soundSet);
			return command;
		}
		return errorByte;
	}

	/*********************************** 功能设置 *******************************************/
	/** 电源 power : 0关，1开 soundSet : 0无声音，1开声音 */
	@Override
	public byte[] setPower(int power, int soundSet) {
		if (null != airCleanerLogic) {
			return airCleanerLogic.setPower(power, soundSet);
		}
		return errorByte;
	}

	/** 风速 设置功能:风量[weak/middle/strong/clear/auto]，提示声[0/1] */
	@Override
	public byte[] setWindSpeed(String windSpeed, int soundSet) {
		if (null != airCleanerLogic) {
			return airCleanerLogic.setWindSpeed(windSpeed, soundSet);
		}
		return errorByte;
	}

	/** 模式 设置功能:模式[cleardust/clearsmell/smart/mute/sleep]，提示声[0/1] */
	@Override
	public byte[] setMode(String mode, int soundSet) {
		if (null != airCleanerLogic) {
			return airCleanerLogic.setMode(mode, soundSet);
		}
		return errorByte;
	}

	/**
	 * 定时开关机 设置功能:普通定时开关机[1-23],普通定时有效位[0/1]，提示声[0/1]
	 * 定时时间格式严格为Val=0,取消定时,val[1~20],定时val*0.5小时,val=[21~34]定时10+(val-20) 小时
	 * 
	 * 注意：清新机不支持以半小时为单位的定时设置，如 不支持timingValue=3,3*0.5=1.5，
	 * 
	 * 定时时间格式严格为[0-23]小时，以整小时为单位,0表示取消
	 */
	@Override
	public byte[] setTimingSwitchMachine(int timingEnable, int timingValue, int soundSet) {
		if (null != airCleanerLogic) {
			return airCleanerLogic.setTimingSwitchMachine(timingEnable, timingValue, soundSet);
		}
		return errorByte;
	}

	/** 儿童锁 开关 设置功能:儿童锁[0/1]，提示声[0/1] */
	@Override
	public byte[] setChildClockPower(int childClockPower, int soundSet) {
		if (null != airCleanerLogic) {
			return airCleanerLogic.setChildClockPower(childClockPower, soundSet);
		}
		return errorByte;
	}

	/** 水离子 开关 设置功能:水离子[0/1]，提示声[0/1] */
	@Override
	public byte[] setWaterIonPower(int waterIonPower, int soundSet) {
		if (null != airCleanerLogic) {
			return airCleanerLogic.setWaterIonPower(waterIonPower, soundSet);
		}
		return errorByte;
	}

	/** 加湿器开关 设置功能:加湿机开关[0/1]，提示声[0/1] */
	@Override
	public byte[] setHumidifierPower(int humidifierPower, int soundSet) {
		if (null != airCleanerLogic) {
			return airCleanerLogic.setHumidifierPower(humidifierPower, soundSet);
		}
		return errorByte;
	}

	/** 加湿 湿度值 设置功能:加湿机设置[40/80]，提示声[0/1] */
	@Override
	public byte[] setHumidityValue(int humidityValue, int soundSet) {
		if (null != airCleanerLogic) {
			return airCleanerLogic.setHumidityValue(humidityValue, soundSet);
		}
		return errorByte;
	}

	/*********************************** 状态查询 *******************************************/
	// 盒子用
	/** 获取 设置开机后，持续时间 */
	@Override
	public long getSetPowerOnDuration() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getSetPowerOnDuration();
		}
		return errorInt;
	}

	// 盒子用
	/** 获取 设置关机后，持续时间 */
	@Override
	public long getSetPowerOffDuration() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getSetPowerOffDuration();
		}
		return errorInt;
	}

	// 盒子用
	/** 获取 设置模式后，持续时间 */
	@Override
	public long getSetModeDuration() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getSetModeDuration();
		}
		return errorInt;
	}

	// 盒子用
	/** 获取 加湿，持续时间 */
	@Override
	public long getHumidifyDuration() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getHumidifyDuration();
		}
		return errorInt;
	}

	// 盒子用
	/** 获取 除尘 PM2.5 cleardust持续时间 */
	@Override
	public long getSetClearDustModeDuration() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getSetClearDustModeDuration();
		}
		return errorInt;
	}

	// 盒子用
	/** 获取 负离子开关，持续时间 */
	@Override
	public long getAnionDuration() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getAnionDuration();
		}
		return errorInt;
	}

	/** 获取 帧内序号 0~15 */
	@Override
	public int getSequence() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getSequence();
		}
		return errorInt;
	}

	/** 获取 操作结果 */
	@Override
	public String getResult() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getResult();
		}
		return errorString;
	}

	// 盒子用到
	/** 获取 风量[weak/middle/strong/clear/auto] */
	@Override
	public String getWindSpeed() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getWindSpeed();
		}
		return errorString;
	}

	// 盒子用到
	/** 获取 模式[cleardust/clearsmell/smart/mute/sleep] */
	@Override
	public String getMode() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getMode();
		}
		return errorString;
	}

	// 盒子用到
	/** 湿度 设置值 */
	@Override
	public int getHumidityValueSet() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getHumidityValueSet();
		}
		return errorInt;
	}

	// 盒子用到
	/** 加湿状态 */
	@Override
	public int getHumidityPower() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getHumidityPower();
		}
		return errorInt;
	}

	// 盒子用到
	/** 负离子开关状态 */
	@Override
	public int getAnionPower() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getAnionPower();
		}
		return errorInt;
	}

	// 盒子用到
	/** 室内湿度 */
	@Override
	public int getHumidifyIndoor() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getHumidifyIndoor();
		}
		return errorInt;
	}

	/** 定时开关机控制 是否有效 */
	@Override
	public int getTimeStatus() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getTimeStatus();
		}
		return errorInt;
	}

	/** 定时开关机时间, */
	@Override
	public String getTimerValue() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getTimerValue();
		}
		return errorString;
	}

	/** 风机转速, */
	@Override
	public int getMotorSpeed() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getMotorSpeed();
		}
		return errorInt;
	}

	// 盒子用到
	/** 空气质量, 洁净度 空气质量 */
	@Override
	public int getAirQuality() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getAirQuality();
		}
		return errorInt;
	}

	/** 空气质量百分比, */
	@Override
	public int getAirQualityPercent() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getAirQualityPercent();
		}
		return errorInt;
	}

	/** 相对湿度, */
	@Override
	public int getRelativeHumidityValue() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getRelativeHumidityValue();
		}
		return errorInt;
	}

	// 盒子用到
	/** 开停净化机, 获取电源 0 关，1 开 */
	@Override
	public int getPower() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getPower();
		}
		return errorInt;
	}

	/** 儿童锁开关控制, */
	@Override
	public int getChildLockStatus() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getChildLockStatus();
		}
		return errorInt;
	}

	/** 水离子开停控制, */
	@Override
	public int getWaterionStatus() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getWaterionStatus();
		}
		return errorInt;
	}

	/** 加湿机开停控制, */
	@Override
	public int getHumidityStatus() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getHumidityStatus();
		}
		return errorInt;
	}

	/** 过滤网更换提示, */
	@Override
	public int getChangeFilterError() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getChangeFilterError();
		}
		return errorInt;
	}

	/** 加湿转轮不动, */
	@Override
	public int getHumidityWheelError() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getHumidityWheelError();
		}
		return errorInt;
	}

	/** 水箱空, */
	@Override
	public int getWaterSinkEmptyError() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getWaterSinkEmptyError();
		}
		return errorInt;
	}

	/** 水箱未装好, */
	@Override
	public int getWaterSinkNotSetup() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getWaterSinkNotSetup();
		}
		return errorInt;
	}

	/** 湿度传感器故障, */
	@Override
	public int getHumiditySensorError() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getHumiditySensorError();
		}
		return errorInt;
	}

	/** 风机故障, */
	@Override
	public int getMotorError() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getMotorError();
		}
		return errorInt;
	}

	/** 风尘传感器故障, */
	@Override
	public int getDustSensorError() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getDustSensorError();
		}
		return errorInt;
	}

	/** 气味传感器故障, */
	@Override
	public int getSmellSensorError() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getSmellSensorError();
		}
		return errorInt;
	}

	/** 机器倾斜故障 */
	@Override
	public int getLeanError() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getLeanError();
		}
		return errorInt;
	}

	/** 湿度设置值 */
	@Override
	public int getSettingHumid() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getSettingHumid();
		}
		return errorInt;
	}

	/******************************** 功能使能查询及设置 ********************************************/
	// getFNEN
	/** 1净化速度状态-自动功能， */
	@Override
	public int getCleanSpeedAutoFN() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getCleanSpeedAutoFN();
		}
		return errorInt;
	}

	/** 2净化速度状态-净烟功能 ， */
	@Override
	public int getCleanSpeedDelSmokeFN() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getCleanSpeedDelSmokeFN();
		}
		return errorInt;
	}

	/** 3净化速度状态-高风功能 */
	@Override
	public int getCleanSpeedHighFN() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getCleanSpeedHighFN();
		}
		return errorInt;
	}

	/** 4净化速度状态-中风功能， */
	@Override
	public int getCleanSpeedMiddleFN() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getCleanSpeedMiddleFN();
		}
		return errorInt;
	}

	/** 5净化速度状态-低风功能， */
	@Override
	public int getCleanSpeedLowFN() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getCleanSpeedLowFN();
		}
		return errorInt;
	}

	/** 6净化模式状态-睡眠功能， */
	@Override
	public int getCleanModeSleepFN() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getCleanModeSleepFN();
		}
		return errorInt;
	}

	/** 7净化模式状态-静音功能， */
	@Override
	public int getCleanModeMuteFN() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getCleanModeMuteFN();
		}
		return errorInt;
	}

	/** 8净化模式状态-智能功能， */
	@Override
	public int getCleanModeSmartFN() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getCleanModeSmartFN();
		}
		return errorInt;
	}

	/** 9净化模式状态-除味功能， */
	@Override
	public int getCleanModeDelTasteFN() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getCleanModeDelTasteFN();
		}
		return errorInt;
	}

	/** 10净化模式状态-除烟功能， */
	@Override
	public int getCleanModeDelSmokeFN() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getCleanModeDelSmokeFN();
		}
		return errorInt;
	}

	/** 11普通定时功能， */
	@Override
	public int getGeneralTimingFN() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getGeneralTimingFN();
		}
		return errorInt;
	}

	/** 12儿童锁功能， */
	@Override
	public int getChildLockFN() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getChildLockFN();
		}
		return errorInt;
	}

	/** 13水离子开停， */
	@Override
	public int getWaterIonFN() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getWaterIonFN();
		}
		return errorInt;
	}

	/** 14加湿机开停功能， */
	@Override
	public int getDehumidifierFN() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getDehumidifierFN();
		}
		return errorInt;
	}

	/** 15净化机开停功能 */
	@Override
	public int getCleanMachineFN() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getCleanMachineFN();
		}
		return errorInt;
	}

	/** 16 EEPROM可改写功能, */
	@Override
	public int getEEpromReadWriteFN() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getEEpromReadWriteFN();
		}
		return errorInt;
	}

	/** 17电量检测功能, */
	@Override
	public int getPowerDetectFN() {
		if (null != airCleanerLogic) {
			return airCleanerLogic.getPowerDetectFN();
		}
		return errorInt;
	}

}
