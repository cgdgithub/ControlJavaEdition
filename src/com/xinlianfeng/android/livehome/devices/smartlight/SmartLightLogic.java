package com.xinlianfeng.android.livehome.devices.smartlight;

import com.xinlianfeng.android.livehome.devices.base.DevicesLogic;

public class SmartLightLogic extends DevicesLogic {
	/** 氛围灯设备类型 */
	private static final int SMARTLIGHT_TYPE = 0x52;
	/** 氛围灯设备地址 */
	private static final int SMARTLIGHT_ADDRESS = 0x01;

	// 氛围灯Set命 令 key:
	/** 电源 */
	private static final String POWER_KEY = "Power";
	/** 色温值 (0~65535) */
	private static final String COLOER_TEMPERATURE_KEY = "ColorTemp";
	/** 设备状态 0 为正常，1 为掉线 */
	private static final String DEVICE_STATUS = "DevStat";
	/** 亮度设置 */
	private static final String BRIGHTNESS_KEY = "Bright";
	/** RGB设置 下面的 R G B 要和RGB一起设置 */
	private static final String RGB_SET_KEY = "RGBSet";
	/** RGB-R设置 红色值 */
	private static final String RGB_R_SET_KEY = "RGB_R";
	/** RGB-G设置 绿色值 */
	private static final String RGB_G_SET_KEY = "RGB_G";
	/** RGB-B设置 蓝色值 */
	private static final String RGB_B_SET_KEY = "RGB_B";
	/** 空气质量等级指示 */
	private static final String AIR_QUALITY_LEVEL_KEY = "AirStat";
	// 新增 2015.11.20
	/** 转换板通信错误 */
	private static final String COMMUNICATION_ERROR_KEY = "PeriComErr";

	public SmartLightLogic() {
		CMD_SET_KEY = "LightSet";
		CMD_QUERY_STATUS_KEY = "LightQuery";
		DEVICE_TYPE = SMARTLIGHT_TYPE;
		DEVICE_SUB_ADDRESS = SMARTLIGHT_ADDRESS;
	}

	/******************************** 功能设置 ********************************************/
	/** 电源设置 此方法未实现 */
	public byte[] setPower(int power) {
		String command = formatStringToJSONSetCmd(POWER_KEY, power);
		setStatusSave(POWER_KEY, power);
		return createNetBytes(command);
	}

	/** 亮度设置：0~100 */
	public byte[] setBrightness(int brightnessValue) {
		String command = formatStringToJSONSetCmd(BRIGHTNESS_KEY, brightnessValue);
		setStatusSave(BRIGHTNESS_KEY, brightnessValue); // 设置亮度
		return createNetBytes(command);
	}

	/** R G B 三元色设置 取值范围均为[0-255] */
	public byte[] setRGB(int redValue, int greenValue, int blueValue) {
		String command = formatStringToJSONSetCmd(RGB_SET_KEY, 1, RGB_R_SET_KEY, redValue, RGB_G_SET_KEY, greenValue,
				RGB_B_SET_KEY, blueValue);
		setStatusSave(RGB_SET_KEY, 1); // 设置 R G B
		setStatusSave(RGB_R_SET_KEY, redValue); // 设置红色
		setStatusSave(RGB_G_SET_KEY, greenValue); // 设置绿色
		setStatusSave(RGB_B_SET_KEY, blueValue); // 设置蓝色
		return createNetBytes(command);
	}

	/** 空气状况 3 优、2 良、1 一般 */
	public byte[] setAirQualityLevel(int airQualityLevel) {
		String command = formatStringToJSONSetCmd(AIR_QUALITY_LEVEL_KEY, airQualityLevel);
		setStatusSave(AIR_QUALITY_LEVEL_KEY, airQualityLevel);
		return createNetBytes(command);
	}

	/** 色温设置(0~65535) 此方法未实现 */
	public byte[] setColorTemperature(int colorTemperatureValue) {
		String command = formatStringToJSONSetCmd(COLOER_TEMPERATURE_KEY, colorTemperatureValue);
		setStatusSave(COLOER_TEMPERATURE_KEY, colorTemperatureValue);
		return createNetBytes(command);
	}

	// 新增 2015.11.12
	/**
	 * 设备状态 0 为正常，1 为掉线
	 * 
	 * @param deviceStatus
	 *            0 为正常，1 为掉线
	 * @return byte[]
	 */
	public byte[] setDeviceStatus(int deviceStatus) {
		String command = formatStringToJSONSetCmd(DEVICE_STATUS, deviceStatus);
		setStatusSave(DEVICE_STATUS, deviceStatus);
		return createNetBytes(command);
	}

	/***************************************** 解析方法 ******************************************/
	/** 解析查询的状态/功能 */
	public String parseByteToJSON(byte[] recv) {
		String parseResult = super.parseByteToJSON(recv);
		return parseResult;
	}

	/******************************** 状态查询 ********************************************/
	/** 开关状态 此方法未实现 */
	public int getPower() {
		return getStatusInt("Power");
	}

	/** RGB 值是否有效 */
	public int getRGBSetValid() {
		return getStatusInt(RGB_SET_KEY);
	}

	/** 红色值 */
	public int getRedValue() {
		return getStatusInt(RGB_R_SET_KEY);
	}

	/** 绿色值 */
	public int getGreenValue() {
		return getStatusInt(RGB_G_SET_KEY);
	}

	/** 蓝色值 */
	public int getBlueValue() {
		return getStatusInt(RGB_B_SET_KEY);
	}

	/** 色温值是否有效 此方法未实现 */
	public int getColorTemperatureValid() {
		return getStatusInt("CTempValid");
	}

	/** 色温值(0~65535) 此方法未实现 */
	public int getColorTemperatureValue() {
		return getStatusInt("ColorTemp");
	}

	/** 亮度值是否有效 */
	public int getBrightnessValid() {
		return getStatusInt("BrightValid");
	}

	/** 亮度 */
	public int getBrightnessValue() {
		return getStatusInt("Bright");
	}

	// 新增状态查询 2015.11.12
	/**
	 * 设备状态 0 为有效，1 为无效
	 * 
	 * @return
	 *         0 为有效，1 为无效
	 */
	public int getDeviceStatusValid() {
		return getStatusInt("DevStatValid");
	}

	/**
	 * 设备状态 0 为正常，1 为掉线
	 * 
	 * @return
	 *         0 为正常，1 为掉线
	 */
	public int getDeviceStatus() {
		return getStatusInt(DEVICE_STATUS);
	}

	/**
	 * 空气状况是否有效 0 为有效，1 为无效
	 * 
	 * @return
	 *         0 为有效，1 为无效
	 */
	public int getAirStatusValid() {
		return getStatusInt("AirStatValid");
	}

	/**
	 * 空气状况 3 优、2 良、1 一般
	 * 
	 * @return
	 *         3 优、2 良、1 一般
	 */
	public int getAirStatus() {
		return getStatusInt("AirStat");
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
