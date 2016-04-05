package com.xinlianfeng.android.livehome.devices.smartlight;

public interface ISmartLightControl {

	/*********************************** 功能设置 *******************************************/
	/**
	 * 电源设置 此方法未实现
	 * 
	 * @param power
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setPower(int power);

	/**
	 * 亮度设置：0~100
	 * 
	 * @param brightnessValue
	 *            0~100
	 * @return byte[]
	 */
	public byte[] setBrightness(int brightnessValue);

	/**
	 * R G B 三元色设置 取值范围均为[0-255]
	 * 
	 * @param redValue
	 *            [0-255]
	 * @param greenValue
	 *            [0-255]
	 * @param blueValue
	 *            [0-255]
	 * @return byte[]
	 */
	public byte[] setRGB(int redValue, int greenValue, int blueValue);

	/**
	 * 空气状况 3 优、2 良、1 一般
	 * 
	 * @param airQualityLevel
	 *            3 优、2 良、1 一般
	 * @return
	 */
	public byte[] setAirQualityLevel(int airQualityLevel);

	/**
	 * 色温设置(0~65535) 此方法未实现
	 * 
	 * @param colorTemperatureValue
	 *            (0~65535)
	 * @return byte[]
	 */
	public byte[] setColorTemperature(int colorTemperatureValue);

	// 新增 2015.11.12
	/**
	 * 设备状态 0 为正常，1 为掉线
	 * 
	 * @param deviceStatus
	 *            0 为正常，1 为掉线
	 * @return byte[]
	 */
	public byte[] setDeviceStatus(int deviceStatus);

	/*********************************** 状态查询 *******************************************/
	/**
	 * 开关状态 此方法未实现
	 * 
	 * @return int
	 */
	public int getPower();

	/**
	 * RGB 值是否有效
	 * 
	 * @return int
	 */
	public int getRGBSetValid();

	/**
	 * 红色值
	 * 
	 * @return int
	 */
	public int getRedValue();

	/**
	 * 绿色值
	 * 
	 * @return int
	 */
	public int getGreenValue();

	/**
	 * 蓝色值
	 * 
	 * @return int
	 */
	public int getBlueValue();

	/**
	 * 色温值是否有效 此方法未实现
	 * 
	 * @return int
	 */
	public int getColorTemperatureValid();

	/**
	 * 色温值(0~65535) 此方法未实现
	 * 
	 * @return int
	 */
	public int getColorTemperatureValue();

	/**
	 * 亮度值是否有效
	 * 
	 * @return int
	 */
	public int getBrightnessValid();

	/**
	 * 亮度
	 * 
	 * @return int
	 */
	public int getBrightnessValue();

	// 新增状态查询 2015.11.12
	/**
	 * 设备状态 0 为有效，1 为无效
	 * 
	 * @return
	 *         0 为有效，1 为无效
	 */
	public int getDeviceStatusValid();

	/**
	 * 设备状态 0 为正常，1 为掉线
	 * 
	 * @return
	 *         0 为正常，1 为掉线
	 */
	public int getDeviceStatus();

	/**
	 * 空气状况是否有效 0 为有效，1 为无效
	 * 
	 * @return
	 *         0 为有效，1 为无效
	 */
	public int getAirStatusValid();

	/**
	 * 空气状况 3 优、2 良、1 一般
	 * 
	 * @return
	 *         3 优、2 良、1 一般
	 */
	public int getAirStatus();

	/**
	 * 转换板通信错误
	 * 
	 * @return
	 *         0为正常，1为通信错误
	 */
	public int getIsPeripheralsCommunicationError();

}
