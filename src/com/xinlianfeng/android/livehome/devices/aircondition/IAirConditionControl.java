package com.xinlianfeng.android.livehome.devices.aircondition;

public interface IAirConditionControl {

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
			int soundSet);

	/*********************************** 功能设置 *******************************************/
	/**
	 * 电源 power : 0关，1开 soundSet : 0无声音，1开声音
	 * 
	 * @param power
	 * @param soundSet
	 * @return int
	 */
	public byte[] setPower(int power, int soundSet);

	/**
	 * 模式 设置功能:模式[heat/auto/cool/dehumidify/blow]
	 * 
	 * @param mode
	 *            [heat/auto/cool/dehumidify/blow]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setMode(String mode, int soundSet);

	/**
	 * 温度 取值：”18”~”32”(内销) 说明：18℃~32℃
	 * 
	 * @param temperature
	 *            [18/32]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setTemperature(int temperature, int soundSet);

	// 此设置温度接口 外销用温度范围更大
	/**
	 * 温度 取值：”16”~”32” 说明：16℃~32℃
	 * 
	 * @param temperature
	 *            [16/32]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setTemperatureExportSales(int temperature, int soundSet);

	/**
	 * 风速 风量[auto/strong/middle/weak/mute]
	 * 
	 * @param windSpeed
	 *            [auto/strong/middle/weak/mute]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setWindSpeed(String windSpeed, int soundSet);

	/**
	 * 水平导风板开停 取值：”0”，”1” 说明： ”0”左右风关，”1”左右风开 设置功能:左右风门控制[0/1],左风摆[0/1],右风摆[0/1],提示声[0/1]
	 * 
	 * @param horizontalWindControl
	 *            [0/1]
	 * @param leftWindSwing
	 *            [0/1]
	 * @param rightWindSwing
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setHorizontalWind(int horizontalWindControl, int leftWindSwing, int rightWindSwing, int soundSet);

	/**
	 * 垂直导风板开停 设置功能:上下风门模式[sweep/auto/#1/#2/#3/#4/#5/#6],上下风门控制[0/1],提示声[0/1]
	 * 
	 * @param airDoorMode
	 *            [sweep/auto/#1/#2/#3/#4/#5/#6]
	 * @param airDoorControl
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setVerticalWind(String airDoorMode, int airDoorControl, int soundSet);

	/**
	 * 定时开、关设定 timingValid : 取值示例： 说明： 1 表示设置有效， 0表示设置无效 timingValue :
	 * Val=0,取消定时,val[1~20],定时val*0.5小时,val=[21~34]定时10+(val-20) 小时
	 * 
	 * @param timingValid
	 *            1 表示设置有效， 0表示设置无效
	 * @param timingValue
	 *            Val=0,取消定时,val[1~20],定时val*0.5小时,val=[21~34]定时10+(val-20) 小时
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setTiming(int timingValid, int timingValue, int soundSet);

	// 暂时没找到对应的at指令
	// /** 设置实时时间 realTimeHour : 说明：设置空调时间为当前时间小时，用来校准 设定范围：0~23 realTimeMinute : 说明：设置空调时间为当前时间分钟，用来校准 设定范围：0~59 */
	// public byte[] setRealTime(int realTimeHour, int realTimeMinute, int soundSet) {
	// if (null != airConditionerLogic) {
	// return airConditionerLogic.setRealTime(realTimeHour, realTimeMinute, soundSet);
	// }
	// return errorByte;
	// }

	/**
	 * 实时开机 power : 说明： 1 表示设置实时开机， 0表示取消实时开机， realTimePowerOnHour : 设定范围：0~23 realTimeMinute :设定范围：0~59,
	 * 实时时钟的小时值[0-24],实时时钟的分钟值[0-60]
	 * 
	 * @param power
	 *            [0/1]
	 * @param minuteValue
	 *            分钟值
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setRealTimePowerOn(int power, int minuteValue, int soundSet);

	/**
	 * 实时关机 power : 说明： 1 表示设置实时开机， 0表示取消实时开机。realTimePowerOnHour : 设定范围：0~23 realTimeMinute : 设定范围：0~59
	 * 
	 * @param power
	 *            [0/1]
	 * @param minuteValue
	 *            分钟值
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setRealTimePowerOff(int power, int minuteValue, int soundSet);

	/**
	 * 睡眠设定 睡眠[off/aged/younger/child/general]
	 * 
	 * @param sleepMode
	 *            [off/aged/younger/child/general]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setSleepMode(String sleepMode, int soundSet);

	/**
	 * 节能 取值：”0”，”1” 说明：”0”节能关，”1”节能开
	 * 
	 * @param energySaving
	 *            ”0”节能关，”1”节能开
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setEnergySaving(int energySaving, int soundSet);

	/**
	 * 背景灯 取值：”0”，”1” 说明：”0”灯光关，”1”灯光开
	 * 
	 * @param light
	 *            ”0”灯光关，”1”灯光开
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setBackgroundLight(int light, int soundSet);

	/**
	 * 显示屏发光 取值：”0”，”1” 说明：”0”灯光关，”1”灯光开
	 * 
	 * @param light
	 *            ”0”灯光关，”1”灯光开
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setScreenLight(int light, int soundSet);

	/**
	 * LED灯 取值：”0”，”1” 说明：”0”灯光关，”1”灯光开
	 * 
	 * @param light
	 *            ”0”灯光关，”1”灯光开
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setLEDLight(int light, int soundSet);

	/**
	 * 电加热 取值：0，1 说明：0电加热关，”1”电加热开
	 * 
	 * @param electricalHeating
	 *            0电加热关，”1”电加热开
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setElectricalHeating(int electricalHeating, int soundSet);

	/**
	 * 强力设定（快速冷热） 取值：”0”，”1” 说明：”0”强力设定关，”1”强力设定开
	 * 
	 * @param fastCooling
	 *            ”0”强力设定关，”1”强力设定开
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setEfficient(int fastCooling, int soundSet);

	// 此设置温度接口 外销用
	/**
	 * 强力设定（快速冷热） 取值：”0”，”1” 说明：”0”强力设定关，”1”强力设定开
	 * 
	 * @param fastCooling
	 *            ”0”强力设定关，”1”强力设定开
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setEfficientExportSales(int fastCooling, int soundSet);

	/**
	 * 静音 取值：”0”，”1” 说明：”0”静音设定关，”1”静音设定开
	 * 
	 * @param isMuteModeOn
	 *            ”0”静音设定关，”1”静音设定开
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setMuteMode(int isMuteModeOn, int soundSet);

	// 此条风向命令livehome代码里没用到
	/**
	 * 风向 取值：”0”，”1” 说明：”0”风向设定关，”1”风向设定开
	 * 
	 * @param isWindDirectionOn
	 *            ”0”风向设定关，”1”风向设定开
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setWindDirection(int isWindDirectionOn, int soundSet);

	// 此条湿度命令livehome代码里没用到
	/**
	 * 湿度 取值：[30-80]
	 * 
	 * @param humidity
	 *            [30-80]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setHumidity(int humidity, int soundSet);

	/**
	 * 华氏 摄氏 温度切换显示 取值：”0”，”1” 说明：”0”切换关，”1”切换开
	 * 
	 * @param isSwitch
	 *            ”0”切换关，”1”切换开
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setFahrenheitOrCelsiusSwitch(int isSwitch, int soundSet);

	/**
	 * 并用节电 设置功能:并用节电[0/1],提示声[0/1]
	 * 
	 * @param isAndPowerSavingMode
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setAndPowerSavingMode(int isAndPowerSavingMode, int soundSet);

	/**
	 * 双模 设置功能:双模[0/1],提示声[0/1]
	 * 
	 * @param isDualMode
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setDualMode(int isDualMode, int soundSet);

	/**
	 * 室内清洁 设置功能:室内清洁[0/1],提示声[0/1]
	 * 
	 * @param isIndoorClean
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setIndoorClean(int isIndoorClean, int soundSet);

	/**
	 * 室外清洁 设置功能:室内清洁[0/1],提示声[0/1]
	 * 
	 * @param isOutdoorClean
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setOutdoorClean(int isOutdoorClean, int soundSet);

	/**
	 * 设置除烟 设置功能:除烟[0/1],提示声[0/1]
	 * 
	 * @param isCleanSmoke
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setCleanSmoke(int isCleanSmoke, int soundSet);

	/**
	 * 显示屏亮度 设置功能:显示屏亮度值[0-255],提示声[0/1]
	 * 
	 * @param brightness
	 *            [0-255]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setBrightness(int brightness, int soundSet);

	// 此条 命令livehome代码里没用到
	/**
	 * 除湿模式 设置功能:除湿模式[auto/1#/2#/3#/4#/5#/6#/7#],提示声[0/1]
	 * 
	 * @param isDehumidifyMode
	 *            [auto/1#/2#/3#/4#/5#/6#/7#]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setDehumidifyMode(String isDehumidifyMode, int soundSet);

	// 此条 命令livehome代码里没用到
	/**
	 * 自然风 设置功能:自然风[0/1],提示声[0/1]
	 * 
	 * @param isNaturalWind
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setNaturalWind(int isNaturalWind, int soundSet);

	// 此条 命令livehome代码里没用到
	/**
	 * 清新 设置功能:清新[0/1],提示声[0/1]
	 * 
	 * @param isFreshAir
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setFreshAir(int isFreshAir, int soundSet);

	// 此条 命令livehome代码里没用到
	/**
	 * 室内外温度切换显示 设置功能:室内外温度切换显示[0/1],提示声[0/1]
	 * 
	 * @param isSwitch
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setIndoorOrOutdoorTemperatureDisplaySwitch(int isSwitch, int soundSet);

	// 此条 命令livehome代码里没用到
	/**
	 * 换风 设置功能:换风[0/1],提示声[0/1]
	 * 
	 * @param isAirExchange
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setAirExchange(int isAirExchange, int soundSet);

	// 此条 命令livehome代码里没用到
	/**
	 * 智慧眼 设置功能:智慧眼[0/1],提示声[0/1]
	 * 
	 * @param isSmartEye
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setSmartEye(int isSmartEye, int soundSet);

	// 此条 命令livehome代码里没用到
	/**
	 * 室内过滤网清洁复位控制(净化) 设置功能:室内过滤网清洁复位控制[0/1],提示声[0/1]
	 * 
	 * @param isReset
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setIndoorFilterCleanReset(int isReset, int soundSet);

	// 此条 命令livehome代码里没用到
	/**
	 * 设置语音 设置功能:语音[0/1],提示声[0/1]
	 * 
	 * @param isVoice
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setVoice(int isVoice, int soundSet);

	// // 此条 命令livehome代码里没用到
	// /**自动工作模式和除湿模式的温度补偿 设置功能:模式[heat/auto/cool/dehumidify/blow],自动工作模式和除湿模式的温度补偿[0-16],提示声[0/1]*/
	// public byte[] setTemperatureCompensation(int compensation, int soundSet) {
	// if (null != airConditionerLogic) {
	// return airConditionerLogic.setTemperatureCompensation(compensation, soundSet);
	// }
	// return errorByte;
	// }

	// 此条先不做，感觉at指令有点乱
	// 此条 命令livehome代码里没用到
	// /**体感控制,体感室内温度,体感室内温度补偿 设置功能:室内过滤网清洁复位控制[0/1],提示声[0/1]*/
	// public byte[] setSomatosensory(int isSomatosensory, int temperature, int compensation, int soundSet) {
	// if (null != airConditionerLogic) {
	// return airConditionerLogic.setSomatosensory(isSomatosensory, temperature, compensation, soundSet);
	// }
	// return errorByte;
	// }

	/*********************************** 状态查询 *******************************************/
	// 盒子用
	/**
	 * 获取 设置开机后，持续时间
	 * 
	 * @return long
	 */
	public long getSetPowerOnDuration();

	// 盒子用
	/**
	 * 获取 设置关机后，持续时间
	 * 
	 * @return long
	 */
	public long getSetPowerOffDuration();

	// 盒子用
	/**
	 * 获取 设置模式后，持续时间
	 * 
	 * @return long
	 */
	public long getSetModeDuration();

	// 盒子用
	/**
	 * 获取 设置强力后，持续时间
	 * 
	 * @return long
	 */
	public long getSetHighEfficientDuration();

	/**
	 * 获取 帧内序号 0~15
	 * 
	 * @return int
	 */
	public int getSequence();

	/**
	 * 获取 操作结果
	 * 
	 * @return String
	 */
	public String getResult();

	// 盒子用到
	/**
	 * 获取 风速 auto/strong/middle/weak/mute
	 * 
	 * @return String
	 */
	public String getWindSpeed();

	/**
	 * 获取 模式 heat/auto/cool/dehumidify/blow
	 * 
	 * @return String
	 */
	public String getMode();

	/**
	 * 获取 睡眠 off/aged/younger/child/general
	 * 
	 * @return String
	 */
	public String getSleepMode();

	// 盒子用到
	/**
	 * 获取电源 0 关，1 开
	 * 
	 * @return int
	 */
	public int getPower();

	/**
	 * 获取 温度值 设置
	 * 
	 * @return int
	 */
	public int getSetTemperature();

	// 盒子用到
	/**
	 * 获取 温度值 室内
	 * 
	 * @return int
	 */
	public int getTemperatureIndoor();

	// 盒子用到
	/**
	 * 获取 温度值 室外
	 * 
	 * @return int
	 */
	public int getTemperatureOutdoor();

	// 盒子用到
	/**
	 * 获取 是否静音
	 * 
	 * @return int
	 */
	public int getMute();

	// 盒子用到
	/**
	 * 获取 强力状态 高效/快速冷热
	 * 
	 * @return int
	 */
	public int getHighEfficient();

	// 盒子用到
	/**
	 * 获取 风门位置[sweep/auto/#1/#2/#3/#4/#5/#6]
	 * 
	 * @return int
	 */
	public String getAirDoorPosition();

	/**
	 * 风向
	 * 
	 * @return int
	 */
	public int getWindDirection();

	/**
	 * 湿度
	 * 
	 * @return int
	 */
	public int getHumidity();

	/**
	 * 体感室内温度
	 * 
	 * @return int
	 */
	public int getSomatosensoryRealityTemperature();

	/**
	 * 室内实际温度
	 * 
	 * @return int
	 */
	public int getIndoorRealityTemperature();

	/**
	 * 室内盘管温度
	 * 
	 * @return int
	 */
	public int getIndoorPipeTemperature();

	/**
	 * 室内实际湿度值
	 * 
	 * @return int
	 */
	public int getIndoorRealityHumidity();

	/**
	 * 体感室内温度补偿
	 * 
	 * @return int
	 */
	public int getSomatosensoryCompensation();

	/**
	 * 体感控制
	 * 
	 * @return int
	 */
	public int getSomatosensoryContrl();

	/**
	 * 自动工作模式和除湿模式的温度补偿
	 * 
	 * @return int
	 */
	public int getTemperatureCompensation();

	/**
	 * 华氏/摄氏温度显示设置
	 * 
	 * @return int
	 */
	public int getTemperatureValueSwitch();

	/**
	 * 普通定时开关机时间
	 * 
	 * @return int
	 */
	public int getGeneralTimingShutdownValue();

	/**
	 * 实时时钟的小时值
	 * 
	 * @return int
	 */
	public int getRealityHour();

	/**
	 * 实时时钟的分钟值
	 * 
	 * @return int
	 */
	public int getRealityMinute();

	/**
	 * 实时开机控制
	 * 
	 * @return int
	 */
	public int getRealityBootContrl();

	/**
	 * 实时开机小时
	 * 
	 * @return int
	 */
	public int getRealityBootHour();

	/**
	 * 实时开机分钟
	 * 
	 * @return int
	 */
	public int getRealityBootMinute();

	/**
	 * 实时关机控制
	 * 
	 * @return int
	 */
	public int getRealityShutdownContrl();

	/**
	 * 实时关机小时
	 * 
	 * @return int
	 */
	public int getRealityShutdownHour();

	/**
	 * 实时关机分钟
	 * 
	 * @return int
	 */
	public int getRealityShutdownMinute();

	/**
	 * 除湿模式
	 * 
	 * @return int
	 */
	public String getDehumidificationMode();

	/**
	 * 上下风门 位置 垂直(上下)导风板位置
	 * 
	 * @return String
	 */
	public String getVerticalWindMode();

	/**
	 * 上下风开停控制
	 * 
	 * @return int
	 */
	public int getVerticalWindContrl();

	/**
	 * 左右风开停控制
	 * 
	 * @return int
	 */
	public int getHorizontalWindContrl();

	/**
	 * 自然风开停控制
	 * 
	 * @return int
	 */
	public int getNatureWindContrl();

	/**
	 * 电加热
	 * 
	 * @return int
	 */
	public int getElectricalHeating();

	/**
	 * 节能
	 * 
	 * @return int
	 */
	public int getEnergyConservation();

	/**
	 * 并用节电
	 * 
	 * @return int
	 */
	public int getShare();

	/**
	 * 双模
	 * 
	 * @return int
	 */
	public int getDualMode();

	/**
	 * 清新
	 * 
	 * @return int
	 */
	public int getFreshness();

	/**
	 * 换风
	 * 
	 * @return int
	 */
	public int getFreshAir();

	/**
	 * 室内清洁
	 * 
	 * @return int
	 */
	public int getCleanIndoor();

	/**
	 * 室外清洁
	 * 
	 * @return int
	 */
	public int getCleanOutdoor();

	/**
	 * 智慧眼
	 * 
	 * @return int
	 */
	public int getSmartEye();

	/**
	 * 语音
	 * 
	 * @return int
	 */
	public int getVoice();

	/**
	 * 除烟
	 * 
	 * @return int
	 */
	public int getCleanSmoke();

	/**
	 * 背景灯
	 * 
	 * @return int
	 */
	public int getBackgroundLamp();

	/**
	 * 显示屏发光
	 * 
	 * @return int
	 */
	public int getScreen();

	// 盒子用到
	/**
	 * LED指示灯
	 * 
	 * @return int
	 */
	public int getLED();

	/**
	 * 室内外温度切换显示
	 * 
	 * @return int
	 */
	public int getIndoorOutdoorSwitch();

	/**
	 * 室内过滤网清洁复位控制
	 * 
	 * @return int
	 */
	public int getIndoorFilterClear();

	/**
	 * 左风摆
	 * 
	 * @return int
	 */
	public int getLeftWind();

	/**
	 * 右风摆
	 * 
	 * @return int
	 */
	public int getRightWind();

	/**
	 * 室内电量板
	 * 
	 * @return int
	 */
	public int getChargeBorad();

	/**
	 * 本次命令之前是否有过红外遥控与按键控制过
	 * 
	 * @return int
	 */
	public int getHaveIRContrl();

	/**
	 * 本次命令之前是否有过WIFI控制过
	 * 
	 * @return int
	 */
	public int getHaveWIFIContrl();

	/**
	 * 室内EEPROM在线升级
	 * 
	 * @return int
	 */
	public int getEEPROMUpdate();

	/**
	 * 室内温度传感器故障
	 * 
	 * @return int
	 */
	public int getIndoorTemperatureSensorTrouble();

	/**
	 * 室内盘管温度传感器故障
	 * 
	 * @return int
	 */
	public int getIndoorPipeTemperatureSensorTrouble();

	/**
	 * 室内湿度传感器故障
	 * 
	 * @return int
	 */
	public int getIndoorHumiditySensorTrouble();

	/**
	 * 室内排水泵故障
	 * 
	 * @return int
	 */
	public int getIndoorDrainsWaterPumpTrouble();

	/**
	 * 室内风机电机运转异常故障
	 * 
	 * @return int
	 */
	public int getIndoorFanMotorTrouble();

	/**
	 * 柜机格栅保护告警
	 * 
	 * @return int
	 */
	public int getPioneerGrillingProtectTrouble();

	/**
	 * 室内电压过零检测故障
	 * 
	 * @return int
	 */
	public int getIndoorVoltageZeroCrossDetectionTrouble();

	/**
	 * 室内外通信故障
	 * 
	 * @return int
	 */
	public int getIndoorOutdoorCommunicationTrouble();

	/**
	 * 室内控制板与显示板通信故障
	 * 
	 * @return int
	 */
	public int getIndoorContrlScreenCommunicationTrouble();

	/**
	 * 室内控制板与按键板通信故障
	 * 
	 * @return int
	 */
	public int getIndoorContrlKeypadCommunicationTrouble();

	/**
	 * WIFI控制板与室内控制板通信故障
	 * 
	 * @return int
	 */
	public int getIndoorContrlWIFICommunicationTrouble();

	/**
	 * 室内控制板与室内电量板通信故障
	 * 
	 * @return int
	 */
	public int getIndoorContrlChargeCommunicationTrouble();

	/**
	 * 室内控制板EEPROM出错
	 * 
	 * @return int
	 */
	public int getIndoorContrlEEPROMTrouble();

	/**
	 * 运行频率
	 * 
	 * @return int
	 */
	public int getRunFrequency();

	/**
	 * 目标频率
	 * 
	 * @return int
	 */
	public int getTargetFrequency();

	/**
	 * 发给驱动器的频率
	 * 
	 * @return int
	 */
	public int getDriveFrequency();

	/**
	 * 室外环境温度
	 * 
	 * @return int
	 */
	public int getEnvironmentTemperature();

	/**
	 * 冷凝器温度
	 * 
	 * @return int
	 */
	public int getCondenserTemperature();

	/**
	 * 排气温度
	 * 
	 * @return int
	 */
	public int getExhaustTemperature();

	/**
	 * 目标排气温度
	 * 
	 * @return int
	 */
	public int getTargetExhaustTemperature();

	/**
	 * 室外电子膨胀阀开度
	 * 
	 * @return int
	 */
	public int getOutdoorElectronicExpansion();

	/**
	 * UABH
	 * 
	 * @return int
	 */
	public int getUABH();

	/**
	 * UABL
	 * 
	 * @return int
	 */
	public int getUABL();

	/**
	 * UBCH
	 * 
	 * @return int
	 */
	public int getUBCH();

	/**
	 * UBCL
	 * 
	 * @return int
	 */
	public int getUBCL();

	/**
	 * UCAH
	 * 
	 * @return int
	 */
	public int getUCAH();

	/**
	 * UCAL
	 * 
	 * @return int
	 */
	public int getUCAL();

	/**
	 * IAB
	 * 
	 * @return int
	 */
	public int getIAB();

	/**
	 * IBC
	 * 
	 * @return int
	 */
	public int getIBC();

	/**
	 * ICA
	 * 
	 * @return int
	 */
	public int getICA();

	/**
	 * IUV
	 * 
	 * @return int
	 */
	public int getIUV();

	/**
	 * 直流母线电压H
	 * 
	 * @return int
	 */
	public int getCocurrentBusVoltageH();

	/**
	 * 直流母线电压L
	 * 
	 * @return int
	 */
	public int getCocurrentBusVoltageL();

	/**
	 * 四通阀状态
	 * 
	 * @return int
	 */
	public int getFourWayLimen();

	/**
	 * 室外机实际工作状态
	 * 
	 * @return int
	 */
	public int getOutdoorRealityRuning();

	/**
	 * 风机运行状态
	 * 
	 * @return int
	 */
	public int getFanRuning();

	/**
	 * 室外机强制室内机风门位置
	 * 
	 * @return int
	 */
	public int getOutdoorForceIndoorWindPosition();

	/**
	 * 室外机强制室内机风速
	 * 
	 * @return int
	 */
	public int getOutdoorForceIndoorWindSpeed();

	/**
	 * 室外机强制室内机停
	 * 
	 * @return int
	 */
	public int getOutdoorForceIndoorStop();

	/**
	 * 温控关机
	 * 
	 * @return int
	 */
	public int getShutdownByTemperatureContrl();

	/**
	 * 一拖多标志
	 * 
	 * @return int
	 */
	public int getOne4All();

	/**
	 * 除湿阀标志
	 * 
	 * @return int
	 */
	public int getDehumidifierLimen();

	/**
	 * 室外机化霜
	 * 
	 * @return int
	 */
	public int getOutdoorDefrosting();

	/**
	 * 室外旁通化霜
	 * 
	 * @return int
	 */
	public int getOutdoorBypassDefrosting();

	/**
	 * 回油标志
	 * 
	 * @return int
	 */
	public int getOilReturn();

	/**
	 * 室外故障显示标志
	 * 
	 * @return int
	 */
	public int getOutdoorTroubleDisplay();

	/**
	 * 室外机EEPROM在线下载标志
	 * 
	 * @return int
	 */
	public int getOutdoorEEPROMDownload();

	/**
	 * 室外机电量板 是否有
	 * 
	 * @return int
	 */
	public int getOutdoorChargeBoard();

	/**
	 * 压缩机电热带
	 * 
	 * @return int
	 */
	public int getcompressorRibbonHeater();

	/**
	 * 压缩机预加热
	 * 
	 * @return int
	 */
	public int getcompressorBeforeHandheat();

	/***
	 * 补气增晗
	 * 
	 * @return int
	 */
	public int getReinflation();

	/**
	 * 室内外机模式冲突
	 * 
	 * @return int
	 */
	public int getOutdoorModeClash();

	/**
	 * 室外EEPROM出错
	 * 
	 * @return int
	 */
	public int getOutdoorEEPROMTrouble();

	/**
	 * 室外盘管温度传感器故障
	 * 
	 * @return int
	 */
	public int getOutdoorPipeTemperatureSensorTrouble();

	/**
	 * 排气温度传感器故障
	 * 
	 * @return int
	 */
	public int getOutdoorExhausTemperatureSensorTrouble();

	/**
	 * 室外环境温度传感器故障
	 * 
	 * @return int
	 */
	public int getOutdoorEnvironmentTemperatureSensorTrouble();

	/**
	 * 电压变压器故障
	 * 
	 * @return int
	 */
	public int getVoltageTransformerTrouble();

	/**
	 * 电流互感器故障
	 * 
	 * @return int
	 */
	public int getCurrentTransformerTrouble();

	/**
	 * 室外控制与驱动通信故障
	 * 
	 * @return int
	 */
	public int getOutdoorContrlDriveCommunicationTrouble();

	/**
	 * IPM模块过流保护
	 * 
	 * @return int
	 */
	public int getIPMOvercurrentProtect();

	/**
	 * IPM模块过热保护
	 * 
	 * @return int
	 */
	public int getIPMOverheatingProtect();

	/**
	 * 交流电过电压保护
	 * 
	 * @return int
	 */
	public int getAlternatingCurrentOvervoltageProtect();

	/**
	 * 交流电欠电压保护
	 * 
	 * @return int
	 */
	public int getAlternatingCurrentUndervoltageProtect();

	/**
	 * 母线电压过电压保护
	 * 
	 * @return int
	 */
	public int getBusbarVoltageOvervoltageProtect();

	/**
	 * 母线电压欠电压保护
	 * 
	 * @return int
	 */
	public int getBusbarVoltageUndervoltageProtect();

	/**
	 * PFC过电流保护
	 * 
	 * @return int
	 */
	public int getPFCOvercurrentProtect();

	/**
	 * 室外机最大电流保护
	 * 
	 * @return int
	 */
	public int getOutdoorMaximumCurrentProtect();

	/**
	 * 室外环境温度过低保护
	 * 
	 * @return int
	 */
	public int getOutdooEnvironmentOvertemperatureProtect();

	/**
	 * 排气温度过高保护
	 * 
	 * @return int
	 */
	public int getExhaustOvertemperatureProtect();

	/**
	 * 压缩机管壳温度保护
	 * 
	 * @return int
	 */
	public int getCompressoPipeShellTemperatureProtect();

	/**
	 * 室内防冻结或防过载保护
	 * 
	 * @return int
	 */
	public int getIndoorAntiFreezingProtect();

	/**
	 * 室外机PFC保护
	 * 
	 * @return int
	 */
	public int getOutdoorPFCProtect();

	/**
	 * 压缩机启动失败
	 * 
	 * @return int
	 */
	public int getCompressoBootFail();

	/**
	 * 压缩机失步
	 * 
	 * @return int
	 */
	public int getCompressoStepOut();

	/**
	 * 室外风机堵转
	 * 
	 * @return int
	 */
	public int getOutdoorFanLockRotor();

	/**
	 * 室外盘管防过载保护
	 * 
	 * @return int
	 */
	public int getOutdoorPieOverloadProtect();

	/**
	 * 冷媒泄漏
	 * 
	 * @return int
	 */
	public int getRefrigerantLeakage();

	/**
	 * 压缩机型号匹配错误
	 * 
	 * @return int
	 */
	public int getCompressoModelMismatch();

	/**
	 * 系统低频振动保护
	 * 
	 * @return int
	 */
	public int getSystemLowFrequencyVibrationProtect();

	/**
	 * 室外散热器温度过高保护
	 * 
	 * @return int
	 */
	public int getOutdoorRadiatorOvertemperatureProtect();

	/**
	 * 系统压力过高保护
	 * 
	 * @return int
	 */
	public int getSystemHypertonusProtect();

	/**
	 * 逆变器直流过电压故障
	 * 
	 * @return int
	 */
	public int getInverterCocurrentOvervoltageTrouble();

	/**
	 * 逆变器直流低电压故障
	 * 
	 * @return int
	 */
	public int getInverterCocurrentUndervoltageTrouble();

	/**
	 * 逆变器交流过电流故障
	 * 
	 * @return int
	 */
	public int getInverterCocurrentOvercurrentTrouble();

	/**
	 * 失步检出
	 * 
	 * @return int
	 */
	public int getStepOutDetection();

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

	/**
	 * 逆变器IPM故障-边沿
	 * 
	 * @return int
	 */
	public int getInverterEdgeFault();

	/**
	 * 逆变器IPM故障-电平
	 * 
	 * @return int
	 */
	public int getInverterLevelFault();

	/**
	 * PFC_IPM故障-边沿
	 * 
	 * @return int
	 */
	public int getPFC_IPMEdgeFault();

	/**
	 * PFC_IPM故障-电平
	 * 
	 * @return int
	 */
	public int getPFC_IPMLevelFault();

	/**
	 * PFC停电检出故障
	 * 
	 * @return int
	 */
	public int getPFCPowerCutFault();

	/**
	 * PFC过电流检出故障
	 * 
	 * @return int
	 */
	public int getPFCOvercurrentFault();

	/**
	 * 直流电压检出异常
	 * 
	 * @return int
	 */
	public int getDCVException();

	/**
	 * PFC低电压（有效值）检出故障
	 * 
	 * @return int
	 */
	public int getPFCLowVoltageFault();

	/**
	 * AD偏置异常检出故障
	 * 
	 * @return int
	 */
	public int getADOffsetAnomaliesFault();

	/**
	 * 逆变器PWM逻辑设置故障
	 * 
	 * @return int
	 */
	public int getInverterPWMLogicFault();

	/**
	 * 逆变器PWM初始化故障
	 * 
	 * @return int
	 */
	public int getInverterPWMInitFault();

	/**
	 * PFC_PWM逻辑设置故障
	 * 
	 * @return int
	 */
	public int getPFCPWMLogicFault();

	/**
	 * PFC_PWM初始化故障
	 * 
	 * @return int
	 */
	public int getPFC_PWMInitFault();

	/** 温度异常 */
	public int getTemperatureAnomaly();

	// 暂未找到键
	// /** 电流采样电阻不平衡调整故障 */
	// public int getCurrentSamplingFault() {
	// return ZD[155];
	// }

	/**
	 * 电机参数设置故障
	 * 
	 * @return int
	 */
	public int getMotorDataFault();

	/**
	 * MCE故障
	 * 
	 * @return int
	 */
	public int getMCEFault();

	/**
	 * 驱动EEPROM故障
	 * 
	 * @return int
	 */
	public int getEEPROMFault();

	/**
	 * 室外盘管过载禁升频
	 * 
	 * @return int
	 */
	public int getOutdoorCoilOverloadUpFrequency();

	/**
	 * 室外盘管过载降频
	 * 
	 * @return int
	 */
	public int getOutdoorCoilOverloadDownFrequency();

	/**
	 * 室内盘管过载禁升频
	 * 
	 * @return int
	 */
	public int getIndoorCoilOverloadUpFrequency();

	/**
	 * 室内盘管过载降频
	 * 
	 * @return int
	 */
	public int getIndoorCoilOverloadDownFrequency();

	/**
	 * 压降排气过载禁升频
	 * 
	 * @return int
	 */
	public int getPressureUpFrequency();

	/**
	 * 压降排气过载降频
	 * 
	 * @return int
	 */
	public int getPressureDownFrequency();

	/**
	 * 室内盘管冻结禁升频
	 * 
	 * @return int
	 */
	public int getIndoorCoilFreezingUpFrequency();

	/**
	 * 室内盘管冻结降频
	 * 
	 * @return int
	 */
	public int getIndoorCoilFreezingDownFrequency();

	/**
	 * 室内外通信降频
	 * 
	 * @return int
	 */
	public int getCommunicationDownFrequency();

	/**
	 * 模块温度过载限频
	 * 
	 * @return int
	 */
	public int getModuleTemperaturelimitFrequency();

	/**
	 * 变调率限频
	 * 
	 * @return int
	 */
	public int getModulationRatelimitFrequency();

	/**
	 * 相电流限频
	 * 
	 * @return int
	 */
	public int getPhaseCurrentlimitFrequency();

	/**
	 * 并用节电保护禁升频
	 * 
	 * @return int
	 */
	public int getPowerSaveUpFrequency();

	/**
	 * 并用节电保护降频
	 * 
	 * @return int
	 */
	public int getPowerSaveDownFrequency();

	/**
	 * 过电流保护禁升频
	 * 
	 * @return int
	 */
	public int getOvercurrentUpFrequency();

	/**
	 * 过电流保护降频
	 * 
	 * @return int
	 */
	public int getOvercurrentDownFrequency();

	/**
	 * 室内风机转速xx
	 * 
	 * @return int
	 */
	public int getIndoorFanSpeedH();

	/**
	 * 室外风机转速00xx
	 * 
	 * @return int
	 */
	public int getIndoorFanSpeed00L();

	/**
	 * 有否PM2.5检测功能
	 * 
	 * @return int
	 */
	public int getPM25();

	/**
	 * PM2.5污染程度
	 * 
	 * @return int
	 */
	public int getPM25Level();

	/**
	 * 空气PM2.5质量百分比表示
	 * 
	 * @return int
	 */
	public int getPM25Percent();

	/**
	 * 显示屏亮度值
	 * 
	 * @return int
	 */
	public int getScreenLuminance();

	/**
	 * 普通定时开关机有效
	 * 
	 * @return int
	 */
	public int getGeneralTimingShutdown();

	/*************************************** 功能使能查询 *************************************************/
	// 功能表
	// getFNEN
	/**
	 * 获取 室内风量支持档位数
	 * 
	 * @return int
	 */
	public int getWindSpeedNumFN();

	/**
	 * 设置睡眠模式
	 * 
	 * @return int
	 */
	public int getSleepModeFN();

	/** 设置模式 */
	/**
	 * 单冷/冷暖 机型
	 * 
	 * @return int
	 */
	public int getCoolModeFN();

	/**
	 * 开/关机
	 * 
	 * @return int
	 */
	public int getPowerFN();

	/**
	 * 室内单个风向控制功能
	 * 
	 * @return int
	 */
	public int getWindDirectionFN();

	/**
	 * 设置温度
	 * 
	 * @return int
	 */
	public int getTemperatureFN();

	/**
	 * 设置湿度
	 * 
	 * @return int
	 */
	public int getHumidityFN();

	/**
	 * 体感控制,体感室内温度,体感室内温度补偿
	 * 
	 * @return int
	 */
	public int getSomatosensoryRealityTemperatureFN();

	/**
	 * 自动工作模式和除湿模式的温度补偿
	 * 
	 * @return int
	 */
	public int getTemperatureCompensationFN();

	/**
	 * 华氏/摄氏温度显示设置
	 * 
	 * @return int
	 */
	public int getTemperatureValueSwitchFN();

	/**
	 * 普通定时关机,普通定时关机时间
	 * 
	 * @return int
	 */
	public int getGeneralTimingShutdownFN();

	/**
	 * 实时开机控制,实时时钟的小时值,实时时钟的分钟值,实时开机小时,实时开机分钟
	 * 
	 * @return int
	 */
	public int getRealityTimeFN();

	/**
	 * 6位置可定室内风门位置控制
	 * 
	 * @return int
	 */
	public int getVerticalWindModeNum();

	/**
	 * 上下风门模式,上下风开停控制
	 * 
	 * @return int
	 */
	public int getVerticalWindFN();

	/**
	 * 左右风开停控制,左风摆,右风摆
	 * 
	 * @return int
	 */
	public int getHorizontalWindFN();

	/**
	 * 自然风开停
	 * 
	 * @return int
	 */
	public int getNatureWindFN();

	/**
	 * 设置电加热
	 * 
	 * @return int
	 */
	public int getElectricalHeatingFN();

	/**
	 * 除湿模式
	 * 
	 * @return int
	 */
	public int getDehumidificationModeFN();

	/**
	 * 设置节能
	 * 
	 * @return int
	 */
	public int getEnergyConservationFN();

	/**
	 * 设置并用节电
	 * 
	 * @return int
	 */
	public int getShareFN();

	/**
	 * 设置高效/强力/快速冷热
	 * 
	 * @return int
	 */
	public int getEfficientFN();

	/**
	 * 设置双模
	 * 
	 * @return int
	 */
	public int getDualModeFN();

	/**
	 * 设置清新
	 * 
	 * @return int
	 */
	public int getFreshnessFN();

	/**
	 * 设置换风
	 * 
	 * @return int
	 */
	public int getFreshAirFN();

	/**
	 * 设置室内清洁
	 * 
	 * @return int
	 */
	public int getCleanIndoorFN();

	/**
	 * 设置室外清洁
	 * 
	 * @return int
	 */
	public int getCleanOutdoorFN();

	/**
	 * 设置智能眼
	 * 
	 * @return int
	 */
	public int getSmartEyeFN();

	/**
	 * 设置室静音 功能使能
	 * 
	 * @return int
	 */
	public int getMuteFN();

	/**
	 * 设置室静音 功能
	 * 
	 * @param isFunction
	 * @return int
	 */
	public int getMuteFN(boolean isFunction);

	/**
	 * 设置语音
	 * 
	 * @return int
	 */
	public int getVoiceFN();

	/**
	 * 设置除烟
	 * 
	 * @return int
	 */
	public int getCleanSmokeFN();

	/**
	 * 背景灯
	 * 
	 * @return int
	 */
	public int getBackgroundLampFN();

	/**
	 * 显示屏发光
	 * 
	 * @return int
	 */
	public int getScreenFN();

	/**
	 * LED指示灯
	 * 
	 * @return int
	 */
	public int getLEDFN();

	/**
	 * 室内外温度切换显示
	 * 
	 * @return int
	 */
	public int getIndoorOutdoorSwitchFN();

	/**
	 * 室内过滤网清洁复位控制
	 * 
	 * @return int
	 */
	public int getIndoorFilterClearFN();

	/**
	 * 左风摆开停控制
	 * 
	 * @return int
	 */
	public int getLeftFanContrlFN();

	/**
	 * 右风摆开停控制
	 * 
	 * @return int
	 */
	public int getRightFanContrlFN();

	/**
	 * 控制规则
	 * 
	 * @return int
	 */
	public int getContrlRate();

}
