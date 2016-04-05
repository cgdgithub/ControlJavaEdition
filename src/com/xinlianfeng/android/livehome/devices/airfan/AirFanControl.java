package com.xinlianfeng.android.livehome.devices.airfan;

import com.xinlianfeng.android.livehome.devices.base.DevicesControl;

public class AirFanControl extends DevicesControl implements IAirFanControl {

	private static final String TAG = "AirFanControl";
	/** 逻辑类 */
	private AirFanLogic airFanLogic = null;

	public AirFanControl() {
		airFanLogic = new AirFanLogic();
		super.devicesLogic = airFanLogic;
	}

	/*********************************** Box设置 *******************************************/
	/** Box 设置功能:开关机[0/1], 模式[fullheat/direct/indoor/auto]，风量[weak/middle/strong/auto]，提示声[0/1] */
	@Override
	public byte[] setBoxAirFan(int power, String mode, String windSpeed, int soundSet) {
		if (null != airFanLogic) {
			byte[] command = airFanLogic.setBoxAirFan(power, mode, windSpeed, soundSet);
			return command;
		}
		return errorByte;
	}

	/*********************************** 功能设置 *******************************************/
	/** 电源 power : 0关，1开 soundSet : 0无声音，1开声音 */
	@Override
	public byte[] setPower(int power, int soundSet) {
		if (null != airFanLogic) {
			return airFanLogic.setPower(power, soundSet);
		}
		return errorByte;
	}

	/** 风速 设置功能:风量[weak/middle/strong/auto]，提示声[0/1] */
	@Override
	public byte[] setWindSpeed(String windSpeed, int soundSet) {
		if (null != airFanLogic) {
			return airFanLogic.setWindSpeed(windSpeed, soundSet);
		}
		return errorByte;
	}

	/** 模式 设置功能:模式[fullheat/direct/indoor/auto]，提示声[0/1] */
	@Override
	public byte[] setMode(String mode, int soundSet) {
		if (null != airFanLogic) {
			return airFanLogic.setMode(mode, soundSet);
		}
		return errorByte;
	}

	/**
	 * 定时开关机 设置功能:普通定时开关机[0.5h-23h],普通定时有效位[0/1]，提示声[0/1]
	 * 定时时间格式严格为[1.0h,2.0h,3.0h,4.0h,5.0h,6.0h,7.0h,8.0h,9.0h,10h,11h,12h,13h,14,15h,16,17h,18h,19h,20h,21h,22,23h],
	 */
	@Override
	public byte[] setTimingSwitchMachine(int timingEnable, int timingValue, int soundSet) {
		if (null != airFanLogic) {
			return airFanLogic.setTimingSwitchMachine(timingEnable, timingValue, soundSet);
		}
		return errorByte;
	}

	/*********************************** 状态查询 *******************************************/
	// 盒子用
	/** 获取 设置开关机后，持续时间 */
	@Override
	public long getSetPowerOnDuration() {
		if (null != airFanLogic) {
			return airFanLogic.getSetPowerOnDuration();
		}
		return errorInt;
	}

	// 盒子用
	/** 获取 设置关机后，持续时间 */
	@Override
	public long getSetPowerOffDuration() {
		if (null != airFanLogic) {
			return airFanLogic.getSetPowerOffDuration();
		}
		return errorInt;
	}

	// 盒子用
	/** 获取 设置模式后，持续时间 */
	@Override
	public long getSetModeDuration() {
		if (null != airFanLogic) {
			return airFanLogic.getSetModeDuration();
		}
		return errorInt;
	}

	/** 获取 帧内序号 0~15 */
	@Override
	public int getSequence() {
		if (null != airFanLogic) {
			return airFanLogic.getSequence();
		}
		return errorInt;
	}

	/** 获取 操作结果 */
	@Override
	public String getResult() {
		if (null != airFanLogic) {
			return airFanLogic.getResult();
		}
		return errorString;
	}

	// 盒子用到
	/** 获取 风速 [weak/middle/strong/auto] */
	@Override
	public String getWindSpeed() {
		if (null != airFanLogic) {
			return airFanLogic.getWindSpeed();
		}
		return errorString;
	}

	// 盒子用到
	/** 获取 模式 [fullheat/direct/indoor/auto] */
	@Override
	public String getMode() {
		if (null != airFanLogic) {
			return airFanLogic.getMode();
		}
		return errorString;
	}

	// 盒子用到
	/** 获取电源 0 关，1 开 */
	@Override
	public int getPower() {
		if (null != airFanLogic) {
			return airFanLogic.getPower();
		}
		return errorInt;
	}

	// 盒子用到
	/** 室内湿度值 */
	@Override
	public int getHumidityIndoor() {
		if (null != airFanLogic) {
			return airFanLogic.getHumidityIndoor();
		}
		return errorInt;
	}

	// 盒子用到
	/** 室外湿度值 */
	@Override
	public int getHumidityOutdoor() {
		if (null != airFanLogic) {
			return airFanLogic.getHumidityOutdoor();
		}
		return errorInt;
	}

	// 盒子用到
	/** 室内温度值 */
	@Override
	public int getTemperatureIndoor() {
		if (null != airFanLogic) {
			return airFanLogic.getTemperatureIndoor();
		}
		return errorInt;
	}

	// 盒子用到
	/** 室外温度值 */
	@Override
	public int getTemperatureOutdoor() {
		if (null != airFanLogic) {
			return airFanLogic.getTemperatureOutdoor();
		}
		return errorInt;
	}

	// 盒子用到
	/** 室内CO2浓度 */
	@Override
	public int getCO2Indoor() {
		if (null != airFanLogic) {
			return airFanLogic.getCO2Indoor();
		}
		return errorInt;
	}

	/** 是否待机 */
	@Override
	public int getSuspendMode() {
		if (null != airFanLogic) {
			return airFanLogic.getSuspendMode();
		}
		return errorInt;
	}

	/** 是否有定时开关 */
	@Override
	public int getIsTiming() {
		if (null != airFanLogic) {
			return airFanLogic.getIsTiming();
		}
		return errorInt;
	}

	/** 定时开关时间 */
	@Override
	public int getTimingTime() {
		if (null != airFanLogic) {
			return airFanLogic.getTimingTime();
		}
		return errorInt;
	}

	/** 室外风机转速*10为实际转速，无此项时为1 */
	@Override
	public int getOuterFanSpeed() {
		if (null != airFanLogic) {
			return airFanLogic.getOuterFanSpeed();
		}
		return errorInt;
	}

	/** 室内风机转速*10为实际转速，无此项时为1 */
	@Override
	public int getInnerFanSpeed() {
		if (null != airFanLogic) {
			return airFanLogic.getInnerFanSpeed();
		}
		return errorInt;
	}

	/** 室内实际温度有效 */
	@Override
	public int getInnerTempratureValid() {
		if (null != airFanLogic) {
			return airFanLogic.getInnerTempratureValid();
		}
		return errorInt;
	}

	/** 室内实际湿度有效 */
	@Override
	public int getInnerHumidityValid() {
		if (null != airFanLogic) {
			return airFanLogic.getInnerHumidityValid();
		}
		return errorInt;
	}

	/** 室内侧二氧化碳 值 有效 */
	@Override
	public int getInnerco2DensityValid() {
		if (null != airFanLogic) {
			return airFanLogic.getInnerco2DensityValid();
		}
		return errorInt;
	}

	/** 室外侧温度有效 */
	@Override
	public int getOuterTempratureValid() {
		if (null != airFanLogic) {
			return airFanLogic.getOuterTempratureValid();
		}
		return errorInt;
	}

	/** 室外侧湿度有效 */
	@Override
	public int getOuterHumidityValid() {
		if (null != airFanLogic) {
			return airFanLogic.getOuterHumidityValid();
		}
		return errorInt;
	}

	/** 过滤网更换提示 */
	@Override
	public int getFilterIfReplace() {
		if (null != airFanLogic) {
			return airFanLogic.getFilterIfReplace();
		}
		return errorInt;
	}

	/** 室外风机故障 */
	@Override
	public int getOuterFanIfFault() {
		if (null != airFanLogic) {
			return airFanLogic.getOuterFanIfFault();
		}
		return errorInt;
	}

	/** 室内风机故障 */
	@Override
	public int getInnerFanIfFault() {
		if (null != airFanLogic) {
			return airFanLogic.getInnerFanIfFault();
		}
		return errorInt;
	}

	/** 室外侧温度传感器故障 */
	@Override
	public int getOuterTemperatureSensorIfFault() {
		if (null != airFanLogic) {
			return airFanLogic.getOuterTemperatureSensorIfFault();
		}
		return errorInt;
	}

	/** 室外侧湿度传感器故障 */
	@Override
	public int getOuterHumiditySensorIfFault() {
		if (null != airFanLogic) {
			return airFanLogic.getOuterHumiditySensorIfFault();
		}
		return errorInt;
	}

	/** 二氧化碳传感器故障 */
	@Override
	public int getCo2SensorIfFault() {
		if (null != airFanLogic) {
			return airFanLogic.getCo2SensorIfFault();
		}
		return errorInt;
	}

	/** 室内侧温度传感器故障 */
	@Override
	public int getInnerTemperatureSensorFault() {
		if (null != airFanLogic) {
			return airFanLogic.getInnerTemperatureSensorFault();
		}
		return errorInt;
	}

	/** 室内侧湿度传感器故障 */
	@Override
	public int getInnerHumiditySensorFault() {
		if (null != airFanLogic) {
			return airFanLogic.getInnerHumiditySensorFault();
		}
		return errorInt;
	}

	/******************************** 功能使能查询及设置 ********************************************/
	// *************************** getFNEN ***************************
	/** 风量支持档位数 */
	@Override
	public int getSpeedSupportNumberFN() {
		if (null != airFanLogic) {
			return airFanLogic.getSpeedSupportNumberFN();
		}
		return errorInt;
	}

	/** 全热换气模式 */
	@Override
	public int getfullheatModeFN() {
		if (null != airFanLogic) {
			return airFanLogic.getfullheatModeFN();
		}
		return errorInt;
	}

	/** 直通换气模式 */
	@Override
	public int getDirectModeFN() {
		if (null != airFanLogic) {
			return airFanLogic.getDirectModeFN();
		}
		return errorInt;
	}

	/** 室内回旋模式 */
	@Override
	public int getIndoorModeFN() {
		if (null != airFanLogic) {
			return airFanLogic.getIndoorModeFN();
		}
		return errorInt;
	}

	/** 普通定时模式 */
	@Override
	public int getTiming() {
		if (null != airFanLogic) {
			return airFanLogic.getTiming();
		}
		return errorInt;
	}

	/** 开关机控制位 */
	@Override
	public int getPowerFN() {
		if (null != airFanLogic) {
			return airFanLogic.getPowerFN();
		}
		return errorInt;
	}

	/** EPPROM */
	@Override
	public int getIfUpdateEEPROM() {
		if (null != airFanLogic) {
			return airFanLogic.getIfUpdateEEPROM();
		}
		return errorInt;
	}

	/** 电量检测 */
	@Override
	public int getbatteryIFdetection() {
		if (null != airFanLogic) {
			return airFanLogic.getbatteryIFdetection();
		}
		return errorInt;
	}
}
