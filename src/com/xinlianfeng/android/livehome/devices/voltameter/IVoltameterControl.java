package com.xinlianfeng.android.livehome.devices.voltameter;

public interface IVoltameterControl {

	/*********************************** 功能设置 *******************************************/
	/**
	 * 总的电源开关
	 * 
	 * @param power
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setPower(int power);

	/**
	 * 电量统计清0
	 * 
	 * @param isResetCount
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setResetCount(int isResetCount);

	/*********************************** 状态查询 *******************************************/
	/**
	 * 总电源开关状态
	 * 
	 * @return int
	 */
	public int getPower();

	/**
	 * 电流值uA
	 * 
	 * @return int
	 */
	public int getCurrentValue();

	/**
	 * 电压值mV
	 * 
	 * @return int
	 */
	public int getVoltageValue();

	/**
	 * 电量值的统计
	 * 
	 * @return long
	 */
	public long getVoltameterValue();

	/**
	 * 转换板通信错误
	 * 
	 * @return
	 *         0为正常，1为通信错误
	 */
	public int getIsPeripheralsCommunicationError();

}
