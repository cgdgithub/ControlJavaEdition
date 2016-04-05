package com.xinlianfeng.android.livehome.devices.voltameter;

import com.xinlianfeng.android.livehome.devices.base.DevicesControl;

public class VoltameterControl extends DevicesControl implements IVoltameterControl {

	private static final String TAG = "VoltameterControl";
	/** 逻辑类 */
	private VoltameterLogic voltameterLogic = null;

	public VoltameterControl() {
		voltameterLogic = new VoltameterLogic();
		super.devicesLogic = voltameterLogic;
	}

	/*********************************** 功能设置 *******************************************/
	/** 总的电源开关 */
	@Override
	public byte[] setPower(int power) {
		if (null != voltameterLogic) {
			return voltameterLogic.setPower(power);
		}
		return errorByte;
	}

	/** 电量统计清0 1清零，0不清零 */
	@Override
	public byte[] setResetCount(int isResetCount) {
		if (null != voltameterLogic) {
			return voltameterLogic.setResetCount(isResetCount);
		}
		return errorByte;
	}

	/*********************************** 状态查询 *******************************************/
	/** 总电源开关状态 */
	@Override
	public int getPower() {
		if (null != voltameterLogic) {
			return voltameterLogic.getPower();
		}
		return errorInt;
	}

	/** 电流值uA */
	@Override
	public int getCurrentValue() {
		if (null != voltameterLogic) {
			return voltameterLogic.getCurrentValue();
		}
		return errorInt;
	}

	/** 电压值mV */
	@Override
	public int getVoltageValue() {
		if (null != voltameterLogic) {
			return voltameterLogic.getCurrentValue();
		}
		return errorInt;
	}

	/**
	 * 整个电量值的统计用64位数据表示，以大端字节序存储
	 * 统计时使用 (PCountH * 0xffffffff)+PCountL得到最终结果，单位焦尔
	 */
	/** 电量值的统计 */
	@Override
	public long getVoltameterValue() {
		if (null != voltameterLogic) {
			return voltameterLogic.getVoltameterValue();
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
		if (null != voltameterLogic) {
			return voltameterLogic.getIsPeripheralsCommunicationError();
		}
		return errorInt;
	}

}
