package com.xinlianfeng.android.livehome.devices.smartcurtain;

import com.xinlianfeng.android.livehome.devices.base.DevicesLogic;

public class SmartCurtainLogic extends DevicesLogic {
	/** 窗帘设备类型 */
	private static final int SMARTCURTAIN_TYPE = 0x55;
	/** 窗帘设备地址 */
	private static final int SMARTCURTAIN_ADDRESS = 0x01;

	// 窗帘Set命 令 key:
	/** 模式 */
	private static final String MODE_KEY = "Mode";
	/** 定点控制 */
	private static final String POSITION_KEY = "Pos";
	// 新增 2015.11.20
	/** 转换板通信错误 */
	private static final String COMMUNICATION_ERROR_KEY = "PeriComErr";

	public SmartCurtainLogic() {
		CMD_SET_KEY = "CurtainSet";
		CMD_QUERY_STATUS_KEY = "CurtainQuery";
		DEVICE_TYPE = SMARTCURTAIN_TYPE;
		DEVICE_SUB_ADDRESS = SMARTCURTAIN_ADDRESS;
	}

	/******************************** 功能设置 ********************************************/
	/** 控制类型：Mode : 设置功能:0打开、1 关闭 */
	public byte[] setMode(int mode) {
		String command = formatStringToJSONSetCmd(MODE_KEY, mode);
		setStatusSave(MODE_KEY, mode); // 设置模式
		return createNetBytes(command);
	}

	/** 定点控制：Pos : 设置功能:设置的定点位置(0~16)，全开位置是0，中间闭合位置是16，每次设置位置间隔距离应大于等于4个单位 */
	// 需要同时设置"Mode":3
	public byte[] setPosition(int position) {
		String command = formatStringToJSONSetCmd(MODE_KEY, 4, POSITION_KEY, position);
		setStatusSave(MODE_KEY, 3); // 设置模式
		setStatusSave(POSITION_KEY, position); // 设置定点控制位置
		return createNetBytes(command);
	}

	/***************************************** 解析方法 ******************************************/
	/** 解析查询的状态/功能 */
	public String parseByteToJSON(byte[] recv) {
		String parseResult = super.parseByteToJSON(recv);
		return parseResult;
	}

	/******************************** 状态查询 ********************************************/
	/** 全开全闭 参数是否有效 */
	public int getPowerStatusParameterIsValid() {
		return getStatusInt("OCValid");
	}

	/** 全开全闭 开关状态 查一下，有异常 */
	public int getPowerStatus() {
		return getStatusInt("OCstat");
	}

	/** 定点位置 参数是否有效 */
	public int getPositionParameterIsValid() {
		return getStatusInt("PosValid");
	}

	/** 当前的定点位置 */
	public int getPositionStatus() {
		return getStatusInt("Pos");
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
