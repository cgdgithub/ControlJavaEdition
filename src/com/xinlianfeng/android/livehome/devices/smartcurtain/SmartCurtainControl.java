package com.xinlianfeng.android.livehome.devices.smartcurtain;

import com.xinlianfeng.android.livehome.devices.base.DevicesControl;

public class SmartCurtainControl extends DevicesControl implements ISmartCurtainControl {

	private static final String TAG = "AirCleanerControl";
	/** 逻辑类 */
	private SmartCurtainLogic smartCurtainLogic = null;

	public SmartCurtainControl() {
		smartCurtainLogic = new SmartCurtainLogic();
		super.devicesLogic = smartCurtainLogic;
	}

	/*********************************** 功能设置 *******************************************/
	/** 控制类型：Mode : 设置功能:0打开、1 关闭*/
	@Override
	public byte[] setMode(int mode) {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.setMode(mode);
		}
		return errorByte;
	}

	/** 定点控制：Pos : 设置功能:设置的定点位置(0~16)，全开位置是0，中间闭合位置是16，每次设置位置间隔距离应大于等于4个单位 */
	@Override
	public byte[] setPosition(int position) {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.setPosition(position);
		}
		return errorByte;
	}

	/*********************************** 状态查询 *******************************************/
	/** Open or Close state 参数是否有效 */
	@Override
	public int getPowerStatusParameterIsValid() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getPowerStatusParameterIsValid();
		}
		return errorInt;
	}

	/** Open or Close state 开关状态 */
	@Override
	public int getPowerStatus() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getPowerStatus();
		}
		return errorInt;
	}

	/** 定点位置 参数是否有效 */
	@Override
	public int getPositionParameterIsValid() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getPositionParameterIsValid();
		}
		return errorInt;
	}

	/** 当前的定点位置 */
	@Override
	public int getPositionStatus() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getPositionStatus();
		}
		return errorInt;
	}

	/**
	 * 转换板通信错误
	 * 
	 * @return
	 *         0为正常，1为通信错误
	 */
	@Override
	public int getIsPeripheralsCommunicationError() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getIsPeripheralsCommunicationError();
		}
		return errorInt;
	}

}
