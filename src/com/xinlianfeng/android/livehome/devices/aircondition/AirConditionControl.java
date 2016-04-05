package com.xinlianfeng.android.livehome.devices.aircondition;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.xinlianfeng.android.livehome.devices.base.DevicesControl;

public class AirConditionControl extends DevicesControl implements IAirConditionControl {

	private static final String TAG = "AirConditionControl";
	/** 空调逻辑类 */
	private AirConditionLogic airConditionLogic = null;

	public AirConditionControl() {
		airConditionLogic = new AirConditionLogic();
		super.devicesLogic = airConditionLogic;
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
	 *             约束关系备注：
	 *             设置高效时，cool模式下温度为16，heat模式下，温度为32
	 * @param isBackgroundLight
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	@Override
	public byte[] setBoxAirConditioner(int power, String mode, String windSpeed, int temperature,
			int upDownAirDoorControl, String airDoorPosition, int isMute, int isHighEfficient, int isBackgroundLight,
			int soundSet) {
		if (null != airConditionLogic) {
			return airConditionLogic.setBoxAirConditioner(power, mode, windSpeed, temperature, upDownAirDoorControl,
					airDoorPosition, isMute, isHighEfficient, isBackgroundLight, soundSet);
		}
		return errorByte;
	}

	/*********************************** 功能设置 *******************************************/
	/** 电源 power : 0关，1开 soundSet : 0无声音，1开声音 */
	@Override
	public byte[] setPower(int power, int soundSet) {
		if (null != airConditionLogic) {
			if (getPower() == power) {
				return errorByte;
			}
			byte[] command = airConditionLogic.setPower(power, soundSet);
			return command;
		}
		return errorByte;
	}

	/** 模式 设置功能:模式[heat/auto/cool/dehumidify/blow] */
	@Override
	public byte[] setMode(String mode, int soundSet) {
		if (null != airConditionLogic) {
			if (getMode() == mode) {
				return errorByte;
			}
			return airConditionLogic.setMode(mode, soundSet);
		}
		return errorByte;
	}

	/** 温度 取值：”18”~”32” 说明：18℃~32℃ */
	@Override
	public byte[] setTemperature(int temperature, int soundSet) {
		if (null != airConditionLogic) {
			if (getSetTemperature() == temperature) {
				return errorByte;
			}
			return airConditionLogic.setTemperature(temperature, soundSet);
		}
		return errorByte;
	}

	// 此设置温度接口 外销用
	/** 温度 取值：”16”~”32” 说明：16℃~32℃ */
	@Override
	public byte[] setTemperatureExportSales(int temperature, int soundSet) {
		if (null != airConditionLogic) {
			if (temperature == airConditionLogic.getSetTemperature()) {
				return errorByte;
			}
			if (airConditionLogic.getHighEfficient() == 1) { // 温度重置，快速冷热如果为开，关闭
				setEfficientExportSales(1, 1);
			}
			return airConditionLogic.setTemperature(temperature, soundSet);
		}
		return errorByte;
	}

	/** 风速 风量[auto/strong/middle/weak/mute] */
	@Override
	public byte[] setWindSpeed(String windSpeed, int soundSet) {
		if (null != airConditionLogic) {
			if (getWindSpeed() == windSpeed) {
				return errorByte;
			}
			return airConditionLogic.setWindSpeed(windSpeed, soundSet);
		}
		return errorByte;
	}

	/** 水平导风板开停 取值：”0”，”1” 说明： ”0”左右风关，”1”左右风开 设置功能:左右风门控制[0/1],左风摆[0/1],右风摆[0/1],提示声[0/1] */
	@Override
	public byte[] setHorizontalWind(int horizontalWindControl, int leftWindSwing, int rightWindSwing, int soundSet) {
		if (null != airConditionLogic) {
			if (getLeftWind() == leftWindSwing && getRightWind() == rightWindSwing
					&& getHorizontalWindContrl() == horizontalWindControl) {
				return errorByte;
			}
			return airConditionLogic.setHorizontalWind(horizontalWindControl, leftWindSwing, rightWindSwing, soundSet);
		}
		return errorByte;
	}

	/** 上下风控制 设置功能:上下风门模式[sweep/auto/1#/2#/3#/4#/5#/6#],上下风门控制[0/1],提示声[0/1] */
	@Override
	public byte[] setVerticalWind(String airDoorMode, int airDoorControl, int soundSet) {
		if (null != airConditionLogic) {
			if (getVerticalWindMode().equals(airDoorMode) && getVerticalWindContrl() == airDoorControl) {
				return errorByte;
			}
			return airConditionLogic.setVerticalWind(airDoorMode, airDoorControl, soundSet);
		}
		return errorByte;
	}

	// 这条测试不对， 待查
	/**
	 * 定时开、关设定 timingValid : 取值示例： 说明： 1 表示设置有效， 0表示设置无效 timingValue : Val=0,取消定时，
	 * val[1~20],定时val*0.5小时,val=[21~34]定时10+(val-20) 小时
	 */
	@Override
	public byte[] setTiming(int timingValid, int timingValue, int soundSet) {
		if (null != airConditionLogic) {
			return airConditionLogic.setTiming(timingValid, timingValue, soundSet);
		}
		return errorByte;
	}

	// 暂时没找到对应的at指令
	// /** 设置实时时间 realTimeHour : 说明：设置空调时间为当前时间小时，用来校准 设定范围：0~23 realTimeMinute : 说明：设置空调时间为当前时间分钟，用来校准 设定范围：0~59 */
	// public byte[] setRealTime(int realTimeHour, int realTimeMinute, int soundSet) {
	// if (null != airConditionerLogic) {
	// return airConditionerLogic.setRealTime(realTimeHour, realTimeMinute, soundSet);
	// }
	// return errorByte;
	// }

	/**
	 * 实时开机 power : 说明： 1 表示设置实时开机， 0表示取消实时开机，  realTimePowerOnHour : 设定范围：0~23 realTimeMinute :
	 * 设定范围：0~59, 实时时钟的小时值[0-24],实时时钟的分钟值[0-60]
	 */
	@Override
	public byte[] setRealTimePowerOn(int power, int minuteValue, int soundSet) {
		if (null != airConditionLogic) {
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = simpleDateFormat.format(date);
			int realHour = Integer.valueOf(dateString.substring(11, 13));
			int realMinute = Integer.valueOf(dateString.substring(14, 16));
			long mTime = (date.getTime() / 1000) + minuteValue * 60;
			date.setTime(mTime * 1000);
			dateString = simpleDateFormat.format(date);
			int bootHour = Integer.valueOf(dateString.substring(11, 13));
			int bootMinute = Integer.valueOf(dateString.substring(14, 16));
			return airConditionLogic.setRealTimePowerOn(power, realHour, realMinute, bootHour, bootMinute, soundSet);
		}
		return errorByte;
	}

	/**
	 * 实时关机 power : 说明： 1 表示设置实时开机， 0表示取消实时开机，realTimePowerOnHour : 设定范围：0~23 realTimeMinute :
	 * 设定范围：0~59
	 */
	@Override
	public byte[] setRealTimePowerOff(int power, int minuteValue, int soundSet) {
		if (null != airConditionLogic) {
			Date date = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = simpleDateFormat.format(date);
			int realHour = Integer.valueOf(dateString.substring(11, 13));
			int realMinute = Integer.valueOf(dateString.substring(14, 16));
			long mTime = (date.getTime() / 1000) + minuteValue * 60;
			date.setTime(mTime * 1000);
			dateString = simpleDateFormat.format(date);
			int bootHour = Integer.valueOf(dateString.substring(11, 13));
			int bootMinute = Integer.valueOf(dateString.substring(14, 16));
			return airConditionLogic.setRealTimePowerOff(power, realHour, realMinute, bootHour, bootMinute, soundSet);
		}
		return errorByte;
	}

	/** 睡眠设定 睡眠[off/aged/younger/child/general] */
	@Override
	public byte[] setSleepMode(String sleepMode, int soundSet) {
		if (null != airConditionLogic) {
			if (getSleepMode() == sleepMode) {
				return errorByte;
			}
			return airConditionLogic.setSleepMode(sleepMode, soundSet);
		}
		return errorByte;
	}

	/** 节能 取值：”0”，”1” 说明：”0”节能关，”1”节能开 */
	@Override
	public byte[] setEnergySaving(int energySaving, int soundSet) {
		if (null != airConditionLogic) {
			if (getEnergyConservation() == energySaving) {
				return errorByte;
			}
			return airConditionLogic.setEnergySaving(energySaving, soundSet);
		}
		return errorByte;
	}

	/** 背景灯 取值：”0”，”1” 说明：”0”灯光关，”1”灯光开 */
	@Override
	public byte[] setBackgroundLight(int light, int soundSet) {
		if (null != airConditionLogic) {
			if (getBackgroundLamp() == light) {
				return errorByte;
			}
			return airConditionLogic.setBackgroundLight(light, soundSet);
		}
		return errorByte;
	}

	/** 显示屏发光 取值：”0”，”1” 说明：”0”灯光关，”1”灯光开 */
	@Override
	public byte[] setScreenLight(int light, int soundSet) {
		if (null != airConditionLogic) {
			if (getScreen() == light) {
				return errorByte;
			}
			return airConditionLogic.setScreenLight(light, soundSet);
		}
		return errorByte;
	}

	/** LED灯 取值：”0”，”1” 说明：”0”灯光关，”1”灯光开 */
	@Override
	public byte[] setLEDLight(int light, int soundSet) {
		if (null != airConditionLogic) {
			if (getLED() == light) {
				return errorByte;
			}
			return airConditionLogic.setLEDLight(light, soundSet);
		}
		return errorByte;
	}

	/** 电加热 取值：0，1 说明：0电加热关，”1”电加热开 */
	@Override
	public byte[] setElectricalHeating(int electricalHeating, int soundSet) {
		if (null != airConditionLogic) {
			if (getElectricalHeating() == electricalHeating) {
				return errorByte;
			}
			return airConditionLogic.setElectricalHeating(electricalHeating, soundSet);
		}
		return errorByte;
	}

	/** 强力设定（快速冷热） 取值：”0”，”1” 说明：”0”强力设定关，”1”强力设定开 */
	@Override
	public byte[] setEfficient(int fastCooling, int soundSet) {
		if (null != airConditionLogic) {
			if (getHighEfficient() == fastCooling) {
				return errorByte;
			}
			return airConditionLogic.setEfficient(fastCooling, soundSet);
		}
		return errorByte;
	}

	// 此设置温度接口 外销用
	/** 强力设定（快速冷热） 取值：”0”，”1” 说明：”0”强力设定关，”1”强力设定开 */
	@Override
	public byte[] setEfficientExportSales(int fastCooling, int soundSet) {
		if (null != airConditionLogic) {
			if (fastCooling == airConditionLogic.getHighEfficient()) {
				return errorByte;
			}
			return airConditionLogic.setEfficientExportSales(fastCooling, soundSet);
		}
		return errorByte;
	}

	/** 静音 取值：”0”，”1” 说明：”0”静音设定关，”1”静音设定开 */
	@Override
	public byte[] setMuteMode(int isMuteModeOn, int soundSet) {
		if (null != airConditionLogic) {
			if (getMute() == isMuteModeOn) {
				return errorByte;
			}
			return airConditionLogic.setMuteMode(isMuteModeOn, soundSet);
		}
		return errorByte;
	}

	// 此条风向命令livehome代码里没用到
	/** 风向 取值：”0”，”1” 说明：”0”风向设定关，”1”风向设定开 */
	@Override
	public byte[] setWindDirection(int isWindDirectionOn, int soundSet) {
		if (null != airConditionLogic) {
			if (getWindDirection() == isWindDirectionOn) {
				return errorByte;
			}
			return airConditionLogic.setWindDirection(isWindDirectionOn, soundSet);
		}
		return errorByte;
	}

	// 此条湿度命令livehome代码里没用到
	/** 湿度 取值：[30-80] */
	@Override
	public byte[] setHumidity(int humidity, int soundSet) {
		if (null != airConditionLogic) {
			if (getHumidity() == humidity) {
				return errorByte;
			}
			return airConditionLogic.setHumidity(humidity, soundSet);
		}
		return errorByte;
	}

	/** 华氏 摄氏 温度切换显示 取值：”0”，”1” 说明：”0”切换关，”1”切换开 */
	@Override
	public byte[] setFahrenheitOrCelsiusSwitch(int isSwitch, int soundSet) {
		if (null != airConditionLogic) {
			if (isSwitch == airConditionLogic.getTemperatureValueSwitch()) {
				return errorByte;
			}
			byte[] switchCommandByteArray = airConditionLogic.setFahrenheitOrCelsiusSwitch(isSwitch, soundSet);
			// 摄氏 、华氏 切换后，重新设置温度
			int temperatureSwitchDisplay = airConditionLogic.temperatureSwitchDisplay(getTemperatureIndoor());
			setTemperatureExportSales(temperatureSwitchDisplay, 0);
			return switchCommandByteArray;
		}
		return errorByte;
	}

	/** 并用节电 设置功能:并用节电[0/1],提示声[0/1] */
	@Override
	public byte[] setAndPowerSavingMode(int isAndPowerSavingMode, int soundSet) {
		if (null != airConditionLogic) {
			if (getShare() == isAndPowerSavingMode) {
				return errorByte;
			}
			return airConditionLogic.setAndPowerSavingMode(isAndPowerSavingMode, soundSet);
		}
		return errorByte;
	}

	/** 双模 设置功能:双模[0/1],提示声[0/1] */
	@Override
	public byte[] setDualMode(int isDualMode, int soundSet) {
		if (null != airConditionLogic) {
			if (getDualMode() == isDualMode) {
				return errorByte;
			}
			return airConditionLogic.setDualMode(isDualMode, soundSet);
		}
		return errorByte;
	}

	/** 室内清洁 设置功能:室内清洁[0/1],提示声[0/1] */
	@Override
	public byte[] setIndoorClean(int isIndoorClean, int soundSet) {
		if (null != airConditionLogic) {
			if (getCleanIndoor() == isIndoorClean) {
				return errorByte;
			}
			return airConditionLogic.setIndoorClean(isIndoorClean, soundSet);
		}
		return errorByte;
	}

	/** 室外清洁 设置功能:室内清洁[0/1],提示声[0/1] */
	@Override
	public byte[] setOutdoorClean(int isOutdoorClean, int soundSet) {
		if (null != airConditionLogic) {
			if (getCleanOutdoor() == isOutdoorClean) {
				return errorByte;
			}
			return airConditionLogic.setOutdoorClean(isOutdoorClean, soundSet);
		}
		return errorByte;
	}

	/** 设置除烟 设置功能:除烟[0/1],提示声[0/1] */
	@Override
	public byte[] setCleanSmoke(int isCleanSmoke, int soundSet) {
		if (null != airConditionLogic) {
			if (getCleanSmoke() == isCleanSmoke) {
				return errorByte;
			}
			return airConditionLogic.setCleanSmoke(isCleanSmoke, soundSet);
		}
		return errorByte;
	}

	/** 显示屏亮度 设置功能:显示屏亮度值[0-255],提示声[0/1] */
	@Override
	public byte[] setBrightness(int brightness, int soundSet) {
		if (null != airConditionLogic) {
			if (getScreenLuminance() == brightness) {
				return errorByte;
			}
			return airConditionLogic.setBrightness(brightness, soundSet);
		}
		return errorByte;
	}

	// 此条 命令livehome代码里没用到
	/** 除湿模式 设置功能:除湿模式[auto/1#/2#/3#/4#/5#/6#/7#],提示声[0/1] */
	@Override
	public byte[] setDehumidifyMode(String isDehumidifyMode, int soundSet) {
		if (null != airConditionLogic) {
			if (getDehumidificationMode().equals(isDehumidifyMode)) {
				return errorByte;
			}
			return airConditionLogic.setDehumidifyMode(isDehumidifyMode, soundSet);
		}
		return errorByte;
	}

	// 此条 命令livehome代码里没用到
	/** 自然风 设置功能:自然风[0/1],提示声[0/1] */
	@Override
	public byte[] setNaturalWind(int isNaturalWind, int soundSet) {
		if (null != airConditionLogic) {
			if (getNatureWindContrl() == isNaturalWind) {
				return errorByte;
			}
			return airConditionLogic.setNaturalWind(isNaturalWind, soundSet);
		}
		return errorByte;
	}

	// 此条 命令livehome代码里没用到
	/** 清新 设置功能:清新[0/1],提示声[0/1] */
	@Override
	public byte[] setFreshAir(int isFreshAir, int soundSet) {
		if (null != airConditionLogic) {
			if (getFreshness() == isFreshAir) {
				return errorByte;
			}
			return airConditionLogic.setFreshAir(isFreshAir, soundSet);
		}
		return errorByte;
	}

	// 此条 命令livehome代码里没用到
	/** 室内外温度切换显示 设置功能:室内外温度切换显示[0/1],提示声[0/1] */
	@Override
	public byte[] setIndoorOrOutdoorTemperatureDisplaySwitch(int isSwitch, int soundSet) {
		if (null != airConditionLogic) {
			if (getIndoorOutdoorSwitch() == isSwitch) {
				return errorByte;
			}
			return airConditionLogic.setIndoorOrOutdoorTemperatureDisplaySwitch(isSwitch, soundSet);
		}
		return errorByte;
	}

	// 此条 命令livehome代码里没用到
	/** 换风 设置功能:换风[0/1],提示声[0/1] */
	@Override
	public byte[] setAirExchange(int isAirExchange, int soundSet) {
		if (null != airConditionLogic) {
			if (getFreshAir() == isAirExchange) {
				return errorByte;
			}
			return airConditionLogic.setAirExchange(isAirExchange, soundSet);
		}
		return errorByte;
	}

	// 此条 命令livehome代码里没用到
	/** 智慧眼 设置功能:智慧眼[0/1],提示声[0/1] */
	@Override
	public byte[] setSmartEye(int isSmartEye, int soundSet) {
		if (null != airConditionLogic) {
			if (getSmartEye() == isSmartEye) {
				return errorByte;
			}
			return airConditionLogic.setSmartEye(isSmartEye, soundSet);
		}
		return errorByte;
	}

	// 此条 命令livehome代码里没用到
	/** 室内过滤网清洁复位控制(净化) 设置功能:室内过滤网清洁复位控制[0/1],提示声[0/1] */
	@Override
	public byte[] setIndoorFilterCleanReset(int isReset, int soundSet) {
		if (null != airConditionLogic) {
			if (getIndoorFilterClear() == isReset) {
				return errorByte;
			}
			return airConditionLogic.setIndoorFilterCleanReset(isReset, soundSet);
		}
		return errorByte;
	}

	// 此条 命令livehome代码里没用到
	/** 设置语音 设置功能:语音[0/1],提示声[0/1] */
	@Override
	public byte[] setVoice(int isVoice, int soundSet) {
		if (null != airConditionLogic) {
			if (getVoice() == isVoice) {
				return errorByte;
			}
			return airConditionLogic.setVoice(isVoice, soundSet);
		}
		return errorByte;
	}

	// // 此条 命令livehome代码里没用到
	// /**？自动工作模式和除湿模式的温度补偿 设置功能:模式[heat/auto/cool/dehumidify/blow],自动工作模式和除湿模式的温度补偿[0-16],提示声[0/1]*/
	// public byte[] setTemperatureCompensation(int compensation, int soundSet) {
	// if (null != airConditionerLogic) {
	// return airConditionerLogic.setTemperatureCompensation(compensation, soundSet);
	// }
	// return errorByte;
	// }

	// 此条先不做，感觉at指令有点乱
	// 此条 命令livehome代码里没用到
	// /**？体感控制,体感室内温度,体感室内温度补偿 设置功能:室内过滤网清洁复位控制[0/1],提示声[0/1]*/
	// public byte[] setSomatosensory(int isSomatosensory, int temperature, int compensation, int soundSet) {
	// if (null != airConditionerLogic) {
	// return airConditionerLogic.setSomatosensory(isSomatosensory, temperature, compensation, soundSet);
	// }
	// return errorByte;
	// }

	/*********************************** 状态查询 *******************************************/
	// 盒子用
	/** 获取 设置开机后，持续时间 */
	@Override
	public long getSetPowerOnDuration() {
		if (null != airConditionLogic) {
			return airConditionLogic.getSetPowerOnDuration();
		}
		return errorInt;
	}
	
	// 盒子用
	/** 获取 设置关机后，持续时间 */
	@Override
	public long getSetPowerOffDuration() {
		if (null != airConditionLogic) {
			return airConditionLogic.getSetPowerOffDuration();
		}
		return errorInt;
	}

	// 盒子用
	/** 获取 设置模式后，持续时间 */
	@Override
	public long getSetModeDuration() {
		if (null != airConditionLogic) {
			return airConditionLogic.getSetModeDuration();
		}
		return errorInt;
	}

	// 盒子用
	/** 获取 设置强力后，持续时间 */
	@Override
	public long getSetHighEfficientDuration() {
		if (null != airConditionLogic) {
			return airConditionLogic.getSetHighEfficientDuration();
		}
		return errorInt;
	}

	/** 获取 帧内序号 0~15 */
	@Override
	public int getSequence() {
		if (null != airConditionLogic) {
			return airConditionLogic.getSequence();
		}
		return errorInt;
	}

	/** 获取 操作结果 */
	@Override
	public String getResult() {
		if (null != airConditionLogic) {
			return airConditionLogic.getResult();
		}
		return errorString;
	}

	// 盒子用到
	/** 获取 风速 auto/strong/middle/weak/mute */
	@Override
	public String getWindSpeed() {
		if (null != airConditionLogic) {
			return airConditionLogic.getWindSpeed();
		}
		return errorString;
	}

	/** 获取 模式 heat/auto/cool/dehumidify/blow */
	@Override
	public String getMode() {
		if (null != airConditionLogic) {
			return airConditionLogic.getMode();
		}
		return errorString;
	}

	/** 获取 睡眠 off/aged/younger/child/general */
	@Override
	public String getSleepMode() {
		if (null != airConditionLogic) {
			return airConditionLogic.getSleepMode();
		}
		return errorString;
	}

	// 盒子用到
	/** 获取电源 0 关，1 开 */
	@Override
	public int getPower() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPower();
		}
		return errorInt;
	}

	/** 获取 温度值 设置 */
	@Override
	public int getSetTemperature() {
		if (null != airConditionLogic) {
			return airConditionLogic.getSetTemperature();
		}
		return errorInt;
	}

	// 盒子用到
	/** 获取 温度值 室内 */
	@Override
	public int getTemperatureIndoor() {
		if (null != airConditionLogic) {
			return airConditionLogic.getTemperatureIndoor();
		}
		return errorInt;
	}

	// 盒子用到
	/** 获取 温度值 室外 */
	@Override
	public int getTemperatureOutdoor() {
		if (null != airConditionLogic) {
			return airConditionLogic.getTemperatureOutdoor();
		}
		return errorInt;
	}

	// 盒子用到
	/** 获取 是否静音 */
	@Override
	public int getMute() {
		if (null != airConditionLogic) {
			return airConditionLogic.getMute();
		}
		return errorInt;
	}

	// 盒子用到
	/** 获取 强力状态 高效/快速冷热 */
	@Override
	public int getHighEfficient() {
		if (null != airConditionLogic) {
			return airConditionLogic.getHighEfficient();
		}
		return errorInt;
	}

	// 盒子用到
	/** 获取 风门位置[sweep/auto/#1/#2/#3/#4/#5/#6]*/
	@Override
	public String getAirDoorPosition() {
		if (null != airConditionLogic) {
			return airConditionLogic.getAirDoorPosition();
		}
		return errorString;
	}

	/** 风向 */
	@Override
	public int getWindDirection() {
		if (null != airConditionLogic) {
			return airConditionLogic.getWindDirection();
		}
		return errorInt;
	}

	/** 湿度 */
	@Override
	public int getHumidity() {
		if (null != airConditionLogic) {
			return airConditionLogic.getHumidity();
		}
		return errorInt;
	}

	/** 体感室内温度 */
	@Override
	public int getSomatosensoryRealityTemperature() {
		if (null != airConditionLogic) {
			return airConditionLogic.getSomatosensoryRealityTemperature();
		}
		return errorInt;
	}

	/** 室内实际温度 */
	@Override
	public int getIndoorRealityTemperature() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorRealityTemperature();
		}
		return errorInt;
	}

	/** 室内盘管温度 */
	@Override
	public int getIndoorPipeTemperature() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorPipeTemperature();
		}
		return errorInt;
	}

	/** 室内实际湿度值 */
	@Override
	public int getIndoorRealityHumidity() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorRealityHumidity();
		}
		return errorInt;
	}

	/** 体感室内温度补偿 */
	@Override
	public int getSomatosensoryCompensation() {
		if (null != airConditionLogic) {
			return airConditionLogic.getSomatosensoryCompensation();
		}
		return errorInt;
	}

	/** 体感控制 */
	@Override
	public int getSomatosensoryContrl() {
		if (null != airConditionLogic) {
			return airConditionLogic.getSomatosensoryContrl();
		}
		return errorInt;
	}

	/** 自动工作模式和除湿模式的温度补偿 */
	@Override
	public int getTemperatureCompensation() {
		if (null != airConditionLogic) {
			return airConditionLogic.getTemperatureCompensation();
		}
		return errorInt;
	}

	/** 华氏/摄氏温度显示设置 */
	@Override
	public int getTemperatureValueSwitch() {
		if (null != airConditionLogic) {
			return airConditionLogic.getTemperatureValueSwitch();
		}
		return errorInt;
	}

	/** 普通定时开关机时间 */
	@Override
	public int getGeneralTimingShutdownValue() {
		if (null != airConditionLogic) {
			return airConditionLogic.getGeneralTimingShutdownValue();
		}
		return errorInt;
	}

	/** 实时时钟的小时值 */
	@Override
	public int getRealityHour() {
		if (null != airConditionLogic) {
			return airConditionLogic.getRealityHour();
		}
		return errorInt;
	}

	/** 实时时钟的分钟值 */
	@Override
	public int getRealityMinute() {
		if (null != airConditionLogic) {
			return airConditionLogic.getRealityMinute();
		}
		return errorInt;
	}

	/** 实时开机控制 */
	@Override
	public int getRealityBootContrl() {
		if (null != airConditionLogic) {
			return airConditionLogic.getRealityBootContrl();
		}
		return errorInt;
	}

	/** 实时开机小时 */
	@Override
	public int getRealityBootHour() {
		if (null != airConditionLogic) {
			return airConditionLogic.getRealityBootHour();
		}
		return errorInt;
	}

	/** 实时开机分钟 */
	@Override
	public int getRealityBootMinute() {
		if (null != airConditionLogic) {
			return airConditionLogic.getRealityBootMinute();
		}
		return errorInt;
	}

	/** 实时关机控制 */
	@Override
	public int getRealityShutdownContrl() {
		if (null != airConditionLogic) {
			return airConditionLogic.getRealityShutdownContrl();
		}
		return errorInt;
	}

	/** 实时关机小时 */
	@Override
	public int getRealityShutdownHour() {
		if (null != airConditionLogic) {
			return airConditionLogic.getRealityShutdownHour();
		}
		return errorInt;
	}

	/** 实时关机分钟 */
	@Override
	public int getRealityShutdownMinute() {
		if (null != airConditionLogic) {
			return airConditionLogic.getRealityShutdownMinute();
		}
		return errorInt;
	}

	/** 除湿模式 */
	@Override
	public String getDehumidificationMode() {
		if (null != airConditionLogic) {
			return airConditionLogic.getDehumidificationMode();
		}
		return errorString;
	}

	/** 上下风门 位置 垂直(上下)导风板位置 */
	@Override
	public String getVerticalWindMode() {
		if (null != airConditionLogic) {
			return airConditionLogic.getVerticalWindMode();
		}
		return errorString;
	}

	/** 上下风开停控制 */
	@Override
	public int getVerticalWindContrl() {
		if (null != airConditionLogic) {
			return airConditionLogic.getVerticalWindContrl();
		}
		return errorInt;
	}

	/** 左右风开停控制 */
	@Override
	public int getHorizontalWindContrl() {
		if (null != airConditionLogic) {
			return airConditionLogic.getHorizontalWindContrl();
		}
		return errorInt;
	}

	/** 自然风开停控制 */
	@Override
	public int getNatureWindContrl() {
		if (null != airConditionLogic) {
			return airConditionLogic.getNatureWindContrl();
		}
		return errorInt;
	}

	/** 电加热 */
	@Override
	public int getElectricalHeating() {
		if (null != airConditionLogic) {
			return airConditionLogic.getElectricalHeating();
		}
		return errorInt;
	}

	/** 节能 */
	@Override
	public int getEnergyConservation() {
		if (null != airConditionLogic) {
			return airConditionLogic.getEnergyConservation();
		}
		return errorInt;
	}

	/** 并用节电 */
	@Override
	public int getShare() {
		if (null != airConditionLogic) {
			return airConditionLogic.getShare();
		}
		return errorInt;
	}

	/** 双模 */
	@Override
	public int getDualMode() {
		if (null != airConditionLogic) {
			return airConditionLogic.getDualMode();
		}
		return errorInt;
	}

	/** 清新 */
	@Override
	public int getFreshness() {
		if (null != airConditionLogic) {
			return airConditionLogic.getFreshness();
		}
		return errorInt;
	}

	/** 换风 */
	@Override
	public int getFreshAir() {
		if (null != airConditionLogic) {
			return airConditionLogic.getFreshAir();
		}
		return errorInt;
	}

	/** 室内清洁 */
	@Override
	public int getCleanIndoor() {
		if (null != airConditionLogic) {
			return airConditionLogic.getCleanIndoor();
		}
		return errorInt;
	}

	/** 室外清洁 */
	@Override
	public int getCleanOutdoor() {
		if (null != airConditionLogic) {
			return airConditionLogic.getCleanOutdoor();
		}
		return errorInt;
	}

	/** 智慧眼 */
	@Override
	public int getSmartEye() {
		if (null != airConditionLogic) {
			return airConditionLogic.getSmartEye();
		}
		return errorInt;
	}

	/** 语音 */
	@Override
	public int getVoice() {
		if (null != airConditionLogic) {
			return airConditionLogic.getVoice();
		}
		return errorInt;
	}

	/** 除烟 */
	@Override
	public int getCleanSmoke() {
		if (null != airConditionLogic) {
			return airConditionLogic.getCleanSmoke();
		}
		return errorInt;
	}

	/** 背景灯 */
	@Override
	public int getBackgroundLamp() {
		if (null != airConditionLogic) {
			return airConditionLogic.getBackgroundLamp();
		}
		return errorInt;
	}

	/** 显示屏发光 */
	@Override
	public int getScreen() {
		if (null != airConditionLogic) {
			return airConditionLogic.getScreen();
		}
		return errorInt;
	}

	// 盒子用到
	/** LED指示灯 */
	@Override
	public int getLED() {
		if (null != airConditionLogic) {
			return airConditionLogic.getLED();
		}
		return errorInt;
	}

	/** 室内外温度切换显示 */
	@Override
	public int getIndoorOutdoorSwitch() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorOutdoorSwitch();
		}
		return errorInt;
	}

	/** 室内过滤网清洁复位控制 */
	@Override
	public int getIndoorFilterClear() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorFilterClear();
		}
		return errorInt;
	}

	/** 左风摆 */
	@Override
	public int getLeftWind() {
		if (null != airConditionLogic) {
			return airConditionLogic.getLeftWind();
		}
		return errorInt;
	}

	/** 右风摆 */
	@Override
	public int getRightWind() {
		if (null != airConditionLogic) {
			return airConditionLogic.getRightWind();
		}
		return errorInt;
	}

	/** 室内电量板 */
	@Override
	public int getChargeBorad() {
		if (null != airConditionLogic) {
			return airConditionLogic.getChargeBorad();
		}
		return errorInt;
	}

	/** 本次命令之前是否有过红外遥控与按键控制过 */
	@Override
	public int getHaveIRContrl() {
		if (null != airConditionLogic) {
			return airConditionLogic.getHaveIRContrl();
		}
		return errorInt;
	}

	/** 本次命令之前是否有过WIFI控制过 */
	@Override
	public int getHaveWIFIContrl() {
		if (null != airConditionLogic) {
			return airConditionLogic.getHaveWIFIContrl();
		}
		return errorInt;
	}

	/** 室内EEPROM在线升级 */
	@Override
	public int getEEPROMUpdate() {
		if (null != airConditionLogic) {
			return airConditionLogic.getEEPROMUpdate();
		}
		return errorInt;
	}

	/** 室内温度传感器故障 */
	@Override
	public int getIndoorTemperatureSensorTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorTemperatureSensorTrouble();
		}
		return errorInt;
	}

	/** 室内盘管温度传感器故障 */
	@Override
	public int getIndoorPipeTemperatureSensorTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorPipeTemperatureSensorTrouble();
		}
		return errorInt;
	}

	/** 室内湿度传感器故障 */
	@Override
	public int getIndoorHumiditySensorTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorHumiditySensorTrouble();
		}
		return errorInt;
	}

	/** 室内排水泵故障 */
	@Override
	public int getIndoorDrainsWaterPumpTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorDrainsWaterPumpTrouble();
		}
		return errorInt;
	}

	/** 室内风机电机运转异常故障 */
	@Override
	public int getIndoorFanMotorTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorFanMotorTrouble();
		}
		return errorInt;
	}

	/** 柜机格栅保护告警 */
	@Override
	public int getPioneerGrillingProtectTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPioneerGrillingProtectTrouble();
		}
		return errorInt;
	}

	/** 室内电压过零检测故障 */
	@Override
	public int getIndoorVoltageZeroCrossDetectionTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorVoltageZeroCrossDetectionTrouble();
		}
		return errorInt;
	}

	/** 室内外通信故障 */
	@Override
	public int getIndoorOutdoorCommunicationTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorOutdoorCommunicationTrouble();
		}
		return errorInt;
	}

	/** 室内控制板与显示板通信故障 */
	@Override
	public int getIndoorContrlScreenCommunicationTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorContrlScreenCommunicationTrouble();
		}
		return errorInt;
	}

	/** 室内控制板与按键板通信故障 */
	@Override
	public int getIndoorContrlKeypadCommunicationTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorContrlKeypadCommunicationTrouble();
		}
		return errorInt;
	}

	/** WIFI控制板与室内控制板通信故障 */
	@Override
	public int getIndoorContrlWIFICommunicationTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorContrlWIFICommunicationTrouble();
		}
		return errorInt;
	}

	/** 室内控制板与室内电量板通信故障 */
	@Override
	public int getIndoorContrlChargeCommunicationTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorContrlChargeCommunicationTrouble();
		}
		return errorInt;
	}

	/** 室内控制板EEPROM出错 */
	@Override
	public int getIndoorContrlEEPROMTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorContrlEEPROMTrouble();
		}
		return errorInt;
	}

	/** 运行频率 */
	@Override
	public int getRunFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getRunFrequency();
		}
		return errorInt;
	}

	/** 目标频率 */
	@Override
	public int getTargetFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getTargetFrequency();
		}
		return errorInt;
	}

	/** 发给驱动器的频率 */
	@Override
	public int getDriveFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getDriveFrequency();
		}
		return errorInt;
	}

	/** 室外环境温度 */
	@Override
	public int getEnvironmentTemperature() {
		if (null != airConditionLogic) {
			return airConditionLogic.getEnvironmentTemperature();
		}
		return errorInt;
	}

	/** 冷凝器温度 */
	@Override
	public int getCondenserTemperature() {
		if (null != airConditionLogic) {
			return airConditionLogic.getCondenserTemperature();
		}
		return errorInt;
	}

	/** 排气温度 */
	@Override
	public int getExhaustTemperature() {
		if (null != airConditionLogic) {
			return airConditionLogic.getExhaustTemperature();
		}
		return errorInt;
	}

	/** 目标排气温度 */
	@Override
	public int getTargetExhaustTemperature() {
		if (null != airConditionLogic) {
			return airConditionLogic.getTargetExhaustTemperature();
		}
		return errorInt;
	}

	/** 室外电子膨胀阀开度 */
	@Override
	public int getOutdoorElectronicExpansion() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorElectronicExpansion();
		}
		return errorInt;
	}

	/** UABH */
	@Override
	public int getUABH() {
		if (null != airConditionLogic) {
			return airConditionLogic.getUABH();
		}
		return errorInt;
	}

	/** UABL */
	@Override
	public int getUABL() {
		if (null != airConditionLogic) {
			return airConditionLogic.getUABL();
		}
		return errorInt;
	}

	/** UBCH */
	@Override
	public int getUBCH() {
		if (null != airConditionLogic) {
			return airConditionLogic.getUBCH();
		}
		return errorInt;
	}

	/** UBCL */
	@Override
	public int getUBCL() {
		if (null != airConditionLogic) {
			return airConditionLogic.getUBCL();
		}
		return errorInt;
	}

	/** UCAH */
	@Override
	public int getUCAH() {
		if (null != airConditionLogic) {
			return airConditionLogic.getUCAH();
		}
		return errorInt;
	}

	/** UCAL */
	@Override
	public int getUCAL() {
		if (null != airConditionLogic) {
			return airConditionLogic.getUCAL();
		}
		return errorInt;
	}

	/** IAB */
	@Override
	public int getIAB() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIAB();
		}
		return errorInt;
	}

	/** IBC */
	@Override
	public int getIBC() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIBC();
		}
		return errorInt;
	}

	/** ICA */
	@Override
	public int getICA() {
		if (null != airConditionLogic) {
			return airConditionLogic.getICA();
		}
		return errorInt;
	}

	/** IUV */
	@Override
	public int getIUV() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIUV();
		}
		return errorInt;
	}

	/** 直流母线电压H */
	@Override
	public int getCocurrentBusVoltageH() {
		if (null != airConditionLogic) {
			return airConditionLogic.getCocurrentBusVoltageH();
		}
		return errorInt;
	}

	/** 直流母线电压L */
	@Override
	public int getCocurrentBusVoltageL() {
		if (null != airConditionLogic) {
			return airConditionLogic.getCocurrentBusVoltageL();
		}
		return errorInt;
	}

	/** 四通阀状态 */
	@Override
	public int getFourWayLimen() {
		if (null != airConditionLogic) {
			return airConditionLogic.getFourWayLimen();
		}
		return errorInt;
	}

	/** 室外机实际工作状态 */
	@Override
	public int getOutdoorRealityRuning() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorRealityRuning();
		}
		return errorInt;
	}

	/** 风机运行状态 */
	@Override
	public int getFanRuning() {
		if (null != airConditionLogic) {
			return airConditionLogic.getFanRuning();
		}
		return errorInt;
	}

	/** 室外机强制室内机风门位置 */
	@Override
	public int getOutdoorForceIndoorWindPosition() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorForceIndoorWindPosition();
		}
		return errorInt;
	}

	/** 室外机强制室内机风速 */
	@Override
	public int getOutdoorForceIndoorWindSpeed() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorForceIndoorWindSpeed();
		}
		return errorInt;
	}

	/** 室外机强制室内机停 */
	@Override
	public int getOutdoorForceIndoorStop() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorForceIndoorStop();
		}
		return errorInt;
	}

	/** 温控关机 */
	@Override
	public int getShutdownByTemperatureContrl() {
		if (null != airConditionLogic) {
			return airConditionLogic.getShutdownByTemperatureContrl();
		}
		return errorInt;
	}

	/** 一拖多标志 */
	@Override
	public int getOne4All() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOne4All();
		}
		return errorInt;
	}

	/** 除湿阀标志 */
	@Override
	public int getDehumidifierLimen() {
		if (null != airConditionLogic) {
			return airConditionLogic.getDehumidifierLimen();
		}
		return errorInt;
	}

	/** 室外机化霜 */
	@Override
	public int getOutdoorDefrosting() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorDefrosting();
		}
		return errorInt;
	}

	/** 室外旁通化霜 */
	@Override
	public int getOutdoorBypassDefrosting() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorBypassDefrosting();
		}
		return errorInt;
	}

	/** 回油标志 */
	@Override
	public int getOilReturn() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOilReturn();
		}
		return errorInt;
	}

	/** 室外故障显示标志 */
	@Override
	public int getOutdoorTroubleDisplay() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorTroubleDisplay();
		}
		return errorInt;
	}

	/** 室外机EEPROM在线下载标志 */
	@Override
	public int getOutdoorEEPROMDownload() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorEEPROMDownload();
		}
		return errorInt;
	}

	/** 室外机电量板 是否有 */
	@Override
	public int getOutdoorChargeBoard() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorChargeBoard();
		}
		return errorInt;
	}

	/** 压缩机电热带 */
	@Override
	public int getcompressorRibbonHeater() {
		if (null != airConditionLogic) {
			return airConditionLogic.getcompressorRibbonHeater();
		}
		return errorInt;
	}

	/** 压缩机预加热 */
	@Override
	public int getcompressorBeforeHandheat() {
		if (null != airConditionLogic) {
			return airConditionLogic.getcompressorBeforeHandheat();
		}
		return errorInt;
	}

	/*** 补气增晗 */
	@Override
	public int getReinflation() {
		if (null != airConditionLogic) {
			return airConditionLogic.getReinflation();
		}
		return errorInt;
	}

	/** 室内外机模式冲突 */
	@Override
	public int getOutdoorModeClash() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorModeClash();
		}
		return errorInt;
	}

	/** 室外EEPROM出错 */
	@Override
	public int getOutdoorEEPROMTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorEEPROMTrouble();
		}
		return errorInt;
	}

	/** 室外盘管温度传感器故障 */
	@Override
	public int getOutdoorPipeTemperatureSensorTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorPipeTemperatureSensorTrouble();
		}
		return errorInt;
	}

	/** 排气温度传感器故障 */
	@Override
	public int getOutdoorExhausTemperatureSensorTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorExhausTemperatureSensorTrouble();
		}
		return errorInt;
	}

	/** 室外环境温度传感器故障 */
	@Override
	public int getOutdoorEnvironmentTemperatureSensorTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorEnvironmentTemperatureSensorTrouble();
		}
		return errorInt;
	}

	/** 电压变压器故障 */
	@Override
	public int getVoltageTransformerTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getVoltageTransformerTrouble();
		}
		return errorInt;
	}

	/** 电流互感器故障 */
	@Override
	public int getCurrentTransformerTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getCurrentTransformerTrouble();
		}
		return errorInt;
	}

	/** 室外控制与驱动通信故障 */
	@Override
	public int getOutdoorContrlDriveCommunicationTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorContrlDriveCommunicationTrouble();
		}
		return errorInt;
	}

	/** IPM模块过流保护 */
	@Override
	public int getIPMOvercurrentProtect() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIPMOvercurrentProtect();
		}
		return errorInt;
	}

	/** IPM模块过热保护 */
	@Override
	public int getIPMOverheatingProtect() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIPMOverheatingProtect();
		}
		return errorInt;
	}

	/** 交流电过电压保护 */
	@Override
	public int getAlternatingCurrentOvervoltageProtect() {
		if (null != airConditionLogic) {
			return airConditionLogic.getAlternatingCurrentOvervoltageProtect();
		}
		return errorInt;
	}

	/** 交流电欠电压保护 */
	@Override
	public int getAlternatingCurrentUndervoltageProtect() {
		if (null != airConditionLogic) {
			return airConditionLogic.getAlternatingCurrentUndervoltageProtect();
		}
		return errorInt;
	}

	/** 母线电压过电压保护 */
	@Override
	public int getBusbarVoltageOvervoltageProtect() {
		if (null != airConditionLogic) {
			return airConditionLogic.getBusbarVoltageOvervoltageProtect();
		}
		return errorInt;
	}

	/** 母线电压欠电压保护 */
	@Override
	public int getBusbarVoltageUndervoltageProtect() {
		if (null != airConditionLogic) {
			return airConditionLogic.getBusbarVoltageUndervoltageProtect();
		}
		return errorInt;
	}

	/** PFC过电流保护 */
	@Override
	public int getPFCOvercurrentProtect() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPFCOvercurrentProtect();
		}
		return errorInt;
	}

	/** 室外机最大电流保护 */
	@Override
	public int getOutdoorMaximumCurrentProtect() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorMaximumCurrentProtect();
		}
		return errorInt;
	}

	/** 室外环境温度过低保护 */
	@Override
	public int getOutdooEnvironmentOvertemperatureProtect() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdooEnvironmentOvertemperatureProtect();
		}
		return errorInt;
	}

	/** 排气温度过高保护 */
	@Override
	public int getExhaustOvertemperatureProtect() {
		if (null != airConditionLogic) {
			return airConditionLogic.getExhaustOvertemperatureProtect();
		}
		return errorInt;
	}

	/** 压缩机管壳温度保护 */
	@Override
	public int getCompressoPipeShellTemperatureProtect() {
		if (null != airConditionLogic) {
			return airConditionLogic.getCompressoPipeShellTemperatureProtect();
		}
		return errorInt;
	}

	/** 室内防冻结或防过载保护 */
	@Override
	public int getIndoorAntiFreezingProtect() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorAntiFreezingProtect();
		}
		return errorInt;
	}

	/** 室外机PFC保护 */
	@Override
	public int getOutdoorPFCProtect() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorPFCProtect();
		}
		return errorInt;
	}

	/** 压缩机启动失败 */
	@Override
	public int getCompressoBootFail() {
		if (null != airConditionLogic) {
			return airConditionLogic.getCompressoBootFail();
		}
		return errorInt;
	}

	/** 压缩机失步 */
	@Override
	public int getCompressoStepOut() {
		if (null != airConditionLogic) {
			return airConditionLogic.getCompressoStepOut();
		}
		return errorInt;
	}

	/** 室外风机堵转 */
	@Override
	public int getOutdoorFanLockRotor() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorFanLockRotor();
		}
		return errorInt;
	}

	/** 室外盘管防过载保护 */
	@Override
	public int getOutdoorPieOverloadProtect() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorPieOverloadProtect();
		}
		return errorInt;
	}

	/** 冷媒泄漏 */
	@Override
	public int getRefrigerantLeakage() {
		if (null != airConditionLogic) {
			return airConditionLogic.getRefrigerantLeakage();
		}
		return errorInt;
	}

	/** 压缩机型号匹配错误 */
	@Override
	public int getCompressoModelMismatch() {
		if (null != airConditionLogic) {
			return airConditionLogic.getCompressoModelMismatch();
		}
		return errorInt;
	}

	/** 系统低频振动保护 */
	@Override
	public int getSystemLowFrequencyVibrationProtect() {
		if (null != airConditionLogic) {
			return airConditionLogic.getSystemLowFrequencyVibrationProtect();
		}
		return errorInt;
	}

	/** 室外散热器温度过高保护 */
	@Override
	public int getOutdoorRadiatorOvertemperatureProtect() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorRadiatorOvertemperatureProtect();
		}
		return errorInt;
	}

	/** 系统压力过高保护 */
	@Override
	public int getSystemHypertonusProtect() {
		if (null != airConditionLogic) {
			return airConditionLogic.getSystemHypertonusProtect();
		}
		return errorInt;
	}

	/** 逆变器直流过电压故障 */
	@Override
	public int getInverterCocurrentOvervoltageTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getInverterCocurrentOvervoltageTrouble();
		}
		return errorInt;
	}

	/** 逆变器直流低电压故障 */
	@Override
	public int getInverterCocurrentUndervoltageTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getInverterCocurrentUndervoltageTrouble();
		}
		return errorInt;
	}

	/** 逆变器交流过电流故障 */
	@Override
	public int getInverterCocurrentOvercurrentTrouble() {
		if (null != airConditionLogic) {
			return airConditionLogic.getInverterCocurrentOvercurrentTrouble();
		}
		return errorInt;
	}

	/** 失步检出 */
	@Override
	public int getStepOutDetection() {
		if (null != airConditionLogic) {
			return airConditionLogic.getStepOutDetection();
		}
		return errorInt;
	}

	// 暂未找到 键
	// /** 速度推定脉冲检出法检出欠相故障 */@Override
	// public int getSpeedPulseFault() {
	// return getStatusInt("StepOutCheck");
	// }
	//
	// /** 电流推定脉冲检出法检出欠相故障 */@Override
	// public int getCurrentPulseFault() {
	// return ZD[140];
	// }

	/** 逆变器IPM故障-边沿 */
	@Override
	public int getInverterEdgeFault() {
		if (null != airConditionLogic) {
			return airConditionLogic.getInverterEdgeFault();
		}
		return errorInt;
	}

	/** 逆变器IPM故障-电平 */
	@Override
	public int getInverterLevelFault() {
		if (null != airConditionLogic) {
			return airConditionLogic.getInverterLevelFault();
		}
		return errorInt;
	}

	/** PFC_IPM故障-边沿 */
	@Override
	public int getPFC_IPMEdgeFault() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPFC_IPMEdgeFault();
		}
		return errorInt;
	}

	/** PFC_IPM故障-电平 */
	@Override
	public int getPFC_IPMLevelFault() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPFC_IPMLevelFault();
		}
		return errorInt;
	}

	/** PFC停电检出故障 */
	@Override
	public int getPFCPowerCutFault() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPFCPowerCutFault();
		}
		return errorInt;
	}

	/** PFC过电流检出故障 */
	@Override
	public int getPFCOvercurrentFault() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPFCOvercurrentFault();
		}
		return errorInt;
	}

	/** 直流电压检出异常 */
	@Override
	public int getDCVException() {
		if (null != airConditionLogic) {
			return airConditionLogic.getDCVException();
		}
		return errorInt;
	}

	/** PFC低电压（有效值）检出故障 */
	@Override
	public int getPFCLowVoltageFault() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPFCLowVoltageFault();
		}
		return errorInt;
	}

	/** AD偏置异常检出故障 */
	@Override
	public int getADOffsetAnomaliesFault() {
		if (null != airConditionLogic) {
			return airConditionLogic.getADOffsetAnomaliesFault();
		}
		return errorInt;
	}

	/** 逆变器PWM逻辑设置故障 */
	@Override
	public int getInverterPWMLogicFault() {
		if (null != airConditionLogic) {
			return airConditionLogic.getInverterPWMLogicFault();
		}
		return errorInt;
	}

	/** 逆变器PWM初始化故障 */
	@Override
	public int getInverterPWMInitFault() {
		if (null != airConditionLogic) {
			return airConditionLogic.getInverterPWMInitFault();
		}
		return errorInt;
	}

	/** PFC_PWM逻辑设置故障 */
	@Override
	public int getPFCPWMLogicFault() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPFCPWMLogicFault();
		}
		return errorInt;
	}

	/** PFC_PWM初始化故障 */
	@Override
	public int getPFC_PWMInitFault() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPFC_PWMInitFault();
		}
		return errorInt;
	}

	/** 温度异常 */
	@Override
	public int getTemperatureAnomaly() {
		if (null != airConditionLogic) {
			return airConditionLogic.getTemperatureAnomaly();
		}
		return errorInt;
	}

	// 暂未找到键
	// /** 电流采样电阻不平衡调整故障 */@Override
	// public int getCurrentSamplingFault() {
	// return ZD[155];
	// }

	/** 电机参数设置故障 */
	@Override
	public int getMotorDataFault() {
		if (null != airConditionLogic) {
			return airConditionLogic.getMotorDataFault();
		}
		return errorInt;
	}

	/** MCE故障 */
	@Override
	public int getMCEFault() {
		if (null != airConditionLogic) {
			return airConditionLogic.getMCEFault();
		}
		return errorInt;
	}

	/** 驱动EEPROM故障 */
	@Override
	public int getEEPROMFault() {
		if (null != airConditionLogic) {
			return airConditionLogic.getEEPROMFault();
		}
		return errorInt;
	}

	/** 室外盘管过载禁升频 */
	@Override
	public int getOutdoorCoilOverloadUpFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorCoilOverloadUpFrequency();
		}
		return errorInt;
	}

	/** 室外盘管过载降频 */
	@Override
	public int getOutdoorCoilOverloadDownFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOutdoorCoilOverloadDownFrequency();
		}
		return errorInt;
	}

	/** 室内盘管过载禁升频 */
	@Override
	public int getIndoorCoilOverloadUpFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorCoilOverloadUpFrequency();
		}
		return errorInt;
	}

	/** 室内盘管过载降频 */
	@Override
	public int getIndoorCoilOverloadDownFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorCoilOverloadDownFrequency();
		}
		return errorInt;
	}

	/** 压降排气过载禁升频 */
	@Override
	public int getPressureUpFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPressureUpFrequency();
		}
		return errorInt;
	}

	/** 压降排气过载降频 */
	@Override
	public int getPressureDownFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPressureDownFrequency();
		}
		return errorInt;
	}

	/** 室内盘管冻结禁升频 */
	@Override
	public int getIndoorCoilFreezingUpFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorCoilFreezingUpFrequency();
		}
		return errorInt;
	}

	/** 室内盘管冻结降频 */
	@Override
	public int getIndoorCoilFreezingDownFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorCoilFreezingDownFrequency();
		}
		return errorInt;
	}

	/** 室内外通信降频 */
	@Override
	public int getCommunicationDownFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getCommunicationDownFrequency();
		}
		return errorInt;
	}

	/** 模块温度过载限频 */
	@Override
	public int getModuleTemperaturelimitFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getModuleTemperaturelimitFrequency();
		}
		return errorInt;
	}

	/** 变调率限频 */
	@Override
	public int getModulationRatelimitFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getModulationRatelimitFrequency();
		}
		return errorInt;
	}

	/** 相电流限频 */
	@Override
	public int getPhaseCurrentlimitFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPhaseCurrentlimitFrequency();
		}
		return errorInt;
	}

	/** 并用节电保护禁升频 */
	@Override
	public int getPowerSaveUpFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPowerSaveUpFrequency();
		}
		return errorInt;
	}

	/** 并用节电保护降频 */
	@Override
	public int getPowerSaveDownFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPowerSaveDownFrequency();
		}
		return errorInt;
	}

	/** 过电流保护禁升频 */
	@Override
	public int getOvercurrentUpFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOvercurrentUpFrequency();
		}
		return errorInt;
	}

	/** 过电流保护降频 */
	@Override
	public int getOvercurrentDownFrequency() {
		if (null != airConditionLogic) {
			return airConditionLogic.getOvercurrentDownFrequency();
		}
		return errorInt;
	}

	/** 室内风机转速xx */
	@Override
	public int getIndoorFanSpeedH() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorFanSpeedH();
		}
		return errorInt;
	}

	/** 室外风机转速00xx */
	@Override
	public int getIndoorFanSpeed00L() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorFanSpeed00L();
		}
		return errorInt;
	}

	/** 有否PM2.5检测功能 */
	@Override
	public int getPM25() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPM25();
		}
		return errorInt;
	}

	/** PM2.5污染程度 */
	@Override
	public int getPM25Level() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPM25Level();
		}
		return errorInt;
	}

	/** 空气PM2.5质量百分比表示 */
	@Override
	public int getPM25Percent() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPM25Percent();
		}
		return errorInt;
	}

	/** 显示屏亮度值 */
	@Override
	public int getScreenLuminance() {
		if (null != airConditionLogic) {
			return airConditionLogic.getScreenLuminance();
		}
		return errorInt;
	}

	/** 普通定时开关机有效 */
	@Override
	public int getGeneralTimingShutdown() {
		if (null != airConditionLogic) {
			return airConditionLogic.getGeneralTimingShutdown();
		}
		return errorInt;
	}

	/*************************************** 功能使能查询 *************************************************/
	// 功能表
	// getFNEN
	/** 获取 室内风量支持档位数 */
	@Override
	public int getWindSpeedNumFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getWindSpeedNumFN();
		}
		return errorInt;
	}

	/** 设置睡眠模式 */
	@Override
	public int getSleepModeFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getSleepModeFN();
		}
		return errorInt;
	}

	/** 设置模式 */
	/** 单冷/冷暖 机型 */
	@Override
	public int getCoolModeFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getCoolModeFN();
		}
		return errorInt;
	}

	/** 开/关机 */
	@Override
	public int getPowerFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getPowerFN();
		}
		return errorInt;
	}

	/** 室内单个风向控制功能 */
	@Override
	public int getWindDirectionFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getWindDirectionFN();
		}
		return errorInt;
	}

	/** 设置温度 */
	@Override
	public int getTemperatureFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getTemperatureFN();
		}
		return errorInt;
	}

	/** 设置湿度 */
	@Override
	public int getHumidityFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getHumidityFN();
		}
		return errorInt;
	}

	/** 体感控制,体感室内温度,体感室内温度补偿 */
	@Override
	public int getSomatosensoryRealityTemperatureFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getSomatosensoryRealityTemperatureFN();
		}
		return errorInt;
	}

	/** 自动工作模式和除湿模式的温度补偿 */
	@Override
	public int getTemperatureCompensationFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getTemperatureCompensationFN();
		}
		return errorInt;
	}

	/** 华氏/摄氏温度显示设置 */
	@Override
	public int getTemperatureValueSwitchFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getTemperatureValueSwitchFN();
		}
		return errorInt;
	}

	/** 普通定时关机,普通定时关机时间 */
	@Override
	public int getGeneralTimingShutdownFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getGeneralTimingShutdownFN();
		}
		return errorInt;
	}

	/** 实时开机控制,实时时钟的小时值,实时时钟的分钟值,实时开机小时,实时开机分钟 */
	@Override
	public int getRealityTimeFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getRealityTimeFN();
		}
		return errorInt;
	}

	/** 6位置可定室内风门位置控制 */
	@Override
	public int getVerticalWindModeNum() {
		if (null != airConditionLogic) {
			return airConditionLogic.getVerticalWindModeNum();
		}
		return errorInt;
	}

	/** 上下风门模式,上下风开停控制 */
	@Override
	public int getVerticalWindFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getVerticalWindFN();
		}
		return errorInt;
	}

	/** 左右风开停控制,左风摆,右风摆 */
	@Override
	public int getHorizontalWindFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getHorizontalWindFN();
		}
		return errorInt;
	}

	/** 自然风开停 */
	@Override
	public int getNatureWindFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getNatureWindFN();
		}
		return errorInt;
	}

	/** 设置电加热 */
	@Override
	public int getElectricalHeatingFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getElectricalHeatingFN();
		}
		return errorInt;
	}

	/** 除湿模式 */
	@Override
	public int getDehumidificationModeFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getDehumidificationModeFN();
		}
		return errorInt;
	}

	/** 设置节能 */
	@Override
	public int getEnergyConservationFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getEnergyConservationFN();
		}
		return errorInt;
	}

	/** 设置并用节电 */
	@Override
	public int getShareFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getShareFN();
		}
		return errorInt;
	}

	/** 设置高效/强力/快速冷热 */
	@Override
	public int getEfficientFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getEfficientFN();
		}
		return errorInt;
	}

	/** 设置双模 */
	@Override
	public int getDualModeFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getDualModeFN();
		}
		return errorInt;
	}

	/** 设置清新 */
	@Override
	public int getFreshnessFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getFreshnessFN();
		}
		return errorInt;
	}

	/** 设置换风 */
	@Override
	public int getFreshAirFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getFreshAirFN();
		}
		return errorInt;
	}

	/** 设置室内清洁 */
	@Override
	public int getCleanIndoorFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getCleanIndoorFN();
		}
		return errorInt;
	}

	/** 设置室外清洁 */
	@Override
	public int getCleanOutdoorFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getCleanOutdoorFN();
		}
		return errorInt;
	}

	/** 设置室智能眼 */
	@Override
	public int getSmartEyeFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getSmartEyeFN();
		}
		return errorInt;
	}

	/** 设置室静音 功能使能 */
	@Override
	public int getMuteFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getMuteFN();
		}
		return errorInt;
	}

	/** 设置室静音 功能 */
	@Override
	public int getMuteFN(boolean isFunction) {
		if (null != airConditionLogic) {
			return airConditionLogic.getMuteFN(isFunction);
		}
		return errorInt;
	}

	/** 设置语音 */
	@Override
	public int getVoiceFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getVoiceFN();
		}
		return errorInt;
	}

	/** 设置除烟 */
	@Override
	public int getCleanSmokeFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getCleanSmokeFN();
		}
		return errorInt;
	}

	/** 背景灯 */
	@Override
	public int getBackgroundLampFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getBackgroundLampFN();
		}
		return errorInt;
	}

	/** 显示屏发光 */
	@Override
	public int getScreenFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getScreenFN();
		}
		return errorInt;
	}

	/** LED指示灯 */
	@Override
	public int getLEDFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getLEDFN();
		}
		return errorInt;
	}

	/** 室内外温度切换显示 */
	@Override
	public int getIndoorOutdoorSwitchFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorOutdoorSwitchFN();
		}
		return errorInt;
	}

	/** 室内过滤网清洁复位控制 */
	@Override
	public int getIndoorFilterClearFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getIndoorFilterClearFN();
		}
		return errorInt;
	}

	/** 左风摆开停控制 */
	@Override
	public int getLeftFanContrlFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getLeftFanContrlFN();
		}
		return errorInt;
	}

	/** 右风摆开停控制 */
	@Override
	public int getRightFanContrlFN() {
		if (null != airConditionLogic) {
			return airConditionLogic.getRightFanContrlFN();
		}
		return errorInt;
	}

	/** 控制规则 */
	@Override
	public int getContrlRate() {
		if (null != airConditionLogic) {
			return airConditionLogic.getContrlRate();
		}
		return errorInt;
	}

}
