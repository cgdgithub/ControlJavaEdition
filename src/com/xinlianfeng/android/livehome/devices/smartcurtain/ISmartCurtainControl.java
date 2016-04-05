package com.xinlianfeng.android.livehome.devices.smartcurtain;

public interface ISmartCurtainControl {

	/*********************************** 功能设置 *******************************************/
	/**
	 * 控制类型：Mode : 设置功能:0打开、1 关闭
	 * 
	 * @param mode
	 *            0打开、1 关闭、2停止、3 重启
	 * @return byte[]
	 */
	public byte[] setMode(int mode);

	/**
	 * 定点控制：Pos : 设置功能:定点控制：Pos : 设置功能:设置的定点位置(0~16)，全开位置是0，中间闭合位置是16，每次设置位置间隔距离应大于等于4个单位
	 * 
	 * @param position
	 *            [0~16]
	 * @return byte[]
	 */
	public byte[] setPosition(int position);

	/*********************************** 状态查询 *******************************************/
	/**
	 * Open or Close state 参数是否有效
	 * 
	 * @return int
	 */
	public int getPowerStatusParameterIsValid();

	/**
	 * Open or Close state 开关状态
	 * 
	 * @return int
	 *         0 打开 1关闭
	 */
	public int getPowerStatus();

	/**
	 * 定点位置 参数是否有效
	 * 
	 * @return int
	 */
	public int getPositionParameterIsValid();

	/**
	 * 当前的定点位置
	 * 
	 * @return int
	 */
	public int getPositionStatus();

	/**
	 * 转换板通信错误
	 * 
	 * @return
	 *         0为正常，1为通信错误
	 */
	public int getIsPeripheralsCommunicationError();

}
