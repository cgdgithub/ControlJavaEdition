package com.xinlianfeng.android.livehome.devices.smartlight;

import com.xinlianfeng.android.livehome.devices.base.DevicesControl;

public class SmartLightControl extends DevicesControl implements ISmartLightControl {

	private static final String TAG = "AirCleanerControl";
	/** 逻辑类 */
	private SmartLightLogic smartCurtainLogic = null;

	public SmartLightControl() {
		smartCurtainLogic = new SmartLightLogic();
		super.devicesLogic = smartCurtainLogic;
	}

	/*********************************** 功能设置 *******************************************/
	/** 电源设置 此方法未实现 */
	@Override
	public byte[] setPower(int power) {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.setPower(power);
		}
		return errorByte;
	}

	/** 亮度设置：0~100 */
	@Override
	public byte[] setBrightness(int brightnessValue) {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.setBrightness(brightnessValue);
		}
		return errorByte;
	}

	/** R G B 三元色设置 取值范围均为[0-255] */
	@Override
	public byte[] setRGB(int redValue, int greenValue, int blueValue) {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.setRGB(redValue, greenValue, blueValue);
		}
		return errorByte;
	}

	/** 空气状况 3 优、2 良、1 一般 */
	@Override
	public byte[] setAirQualityLevel(int airQualityLevel) {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.setAirQualityLevel(airQualityLevel);
		}
		return errorByte;
	}

	/** 色温设置(0~65535) 此方法未实现 */
	@Override
	public byte[] setColorTemperature(int colorTemperatureValue) {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.setColorTemperature(colorTemperatureValue);
		}
		return errorByte;
	}

	// 新增 2015.11.12
	/**
	 * 设备状态 0 为正常，1 为掉线
	 * 
	 * @param deviceStatus
	 *            0 为正常，1 为掉线
	 * @return byte[]
	 */
	@Override
	public byte[] setDeviceStatus(int deviceStatus) {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.setDeviceStatus(deviceStatus);
		}
		return errorByte;
	}

	/*********************************** 状态查询 *******************************************/
	/** 开关状态 此方法未实现 */
	@Override
	public int getPower() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getPower();
		}
		return errorInt;
	}

	/** RGB 值是否有效 */
	@Override
	public int getRGBSetValid() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getRGBSetValid();
		}
		return errorInt;
	}

	/** 红色值 */
	@Override
	public int getRedValue() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getRedValue();
		}
		return errorInt;
	}

	/** 绿色值 */
	@Override
	public int getGreenValue() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getGreenValue();
		}
		return errorInt;
	}

	/** 蓝色值 */
	@Override
	public int getBlueValue() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getBlueValue();
		}
		return errorInt;
	}

	/** 色温值是否有效 此方法未实现 */
	@Override
	public int getColorTemperatureValid() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getColorTemperatureValid();
		}
		return errorInt;
	}

	/** 色温值(0~65535) 此方法未实现 */
	@Override
	public int getColorTemperatureValue() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getColorTemperatureValue();
		}
		return errorInt;
	}

	/** 亮度值是否有效 */
	@Override
	public int getBrightnessValid() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getBrightnessValid();
		}
		return errorInt;
	}

	/** 亮度 */
	@Override
	public int getBrightnessValue() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getBrightnessValue();
		}
		return errorInt;
	}

	// 新增状态查询 2015.11.12
	/**
	 * 设备状态 0 为有效，1 为无效
	 * 
	 * @return
	 *         0 为有效，1 为无效
	 */
	@Override
	public int getDeviceStatusValid() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getDeviceStatusValid();
		}
		return errorInt;
	}

	/**
	 * 设备状态 0 为正常，1 为掉线
	 * 
	 * @return
	 *         0 为正常，1 为掉线
	 */
	@Override
	public int getDeviceStatus() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getDeviceStatus();
		}
		return errorInt;
	}

	/**
	 * 空气状况是否有效 0 为有效，1 为无效
	 * 
	 * @return
	 *         0 为有效，1 为无效
	 */
	@Override
	public int getAirStatusValid() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getAirStatusValid();
		}
		return errorInt;
	}

	/**
	 * 空气状况 3 优、2 良、1 一般
	 * 
	 * @return
	 *         3 优、2 良、1 一般
	 */
	@Override
	public int getAirStatus() {
		if (null != smartCurtainLogic) {
			return smartCurtainLogic.getAirStatus();
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
