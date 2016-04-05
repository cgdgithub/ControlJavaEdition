package com.xinlianfeng.android.livehome.devices.voltameter;

import com.xinlianfeng.android.livehome.devices.base.DevicesLogic;

public class VoltameterLogic extends DevicesLogic {
	/** 电量计设备类型 */
	private static final int VOLTAMETER_TYPE = 0x11;
	/** 电量计设备地址 */
	private static final int VOLTAMETER_ADDRESS = 0x01;

	// 电量计Set命 令 key:
	/** 总电源开关状态 */
	private static final String POWER_KEY = "Power";
	/** 电量统计清0 */
	private static final String RESET_COUNT_KEY = "RstCount";
	// 电量计Get命 令 key:
	/** 电源值uA */
	private static final String CURRENT_KEY = "Current";
	/** 电压值mV */
	private static final String VOLTAGE_KEY = "Voltage";
	// 新增 2015.11.20
	/** 转换板通信错误 */
	private static final String COMMUNICATION_ERROR_KEY = "PeriComErr";

	/**
	 * 整个电量值的统计用64位数据表示，以大端字节序存储
	 * 统计时使用 (PCountH * 0xffffffff)+PCountL得到最终结果，单位焦尔
	 */
	/** 当前电量累计的高32bit值焦尔 */
	private static final String COUNT_H_KEY = "PCountH";
	/** 当前电量累计的低32bit值焦尔 */
	private static final String COUNT_L_KEY = "PCountL";

	public VoltameterLogic() {
		CMD_SET_KEY = "VoltaSet";
		CMD_QUERY_STATUS_KEY = "VoltaQuery";
		DEVICE_TYPE = VOLTAMETER_TYPE;
		DEVICE_SUB_ADDRESS = VOLTAMETER_ADDRESS;
	}

	/******************************** 功能设置 ********************************************/
	/** 总的电源开关 */
	public byte[] setPower(int power) {
		String command = formatStringToJSONSetCmd(POWER_KEY, power);
		setStatusSave(POWER_KEY, power);
		return createNetBytes(command);
	}

	/** 电量统计清0 1清零，0不清零 */
	public byte[] setResetCount(int isResetCount) {
		String command = formatStringToJSONSetCmd(RESET_COUNT_KEY, isResetCount);
		setStatusSave(RESET_COUNT_KEY, isResetCount); // 设置亮度
		return createNetBytes(command);
	}

	/***************************************** 解析方法 ******************************************/
	/** 解析查询的状态/功能 */
	public String parseByteToJSON(byte[] recv) {
		String parseResult = super.parseByteToJSON(recv);
		return parseResult;
	}

	/******************************** 状态查询 ********************************************/
	/** 总电源开关状态 */
	public int getPower() {
		return getStatusInt(POWER_KEY);
	}

	/** 电流值uA */
	public int getCurrentValue() {
		return getStatusInt(CURRENT_KEY);
	}

	/** 电压值mV */
	public int getVoltageValue() {
		return getStatusInt(VOLTAGE_KEY);
	}

	/**
	 * 整个电量值的统计用64位数据表示，以大端字节序存储
	 * 统计时使用 (PCountH * 0xffffffff)+PCountL得到最终结果，单位焦尔
	 */
	/** 电量值的统计 */
	public long getVoltameterValue() {
		return (getCountHValue() * 0xffffffff) + getCountLValue();
	}

	/** 当前电量累计的高32bit值焦尔 */
	public int getCountHValue() {
		return getStatusInt(COUNT_H_KEY);
	}

	/** 当前电量累计的低32bit值焦尔 */
	public int getCountLValue() {
		return getStatusInt(COUNT_L_KEY);
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
