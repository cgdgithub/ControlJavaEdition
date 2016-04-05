package com.xinlianfeng.android.livehome.devices.sensorsfourinone;

import com.xinlianfeng.android.livehome.devices.base.DevicesControl;

public class SensorsFourInOneControl extends DevicesControl implements ISensorsFourInOneControl {

	private static final String TAG = "SensorsFourInOneControl";
	/** 逻辑类 */
	private SensorsFourInOneLogic sensorsFourInOneLogic = null;

	public SensorsFourInOneControl() {
		sensorsFourInOneLogic = new SensorsFourInOneLogic();
		super.devicesLogic = sensorsFourInOneLogic;
	}

	/** PM2.5开关设置 设置功能：power[1] */
	@Override
	public byte[] setPM2_5Power(int power) {
		if (null != sensorsFourInOneLogic) {
			byte[] command = sensorsFourInOneLogic.setPM2_5Power(power);
			return command;
		}
		return errorByte;
	}

	/** 传感器电源控制 切断 上电 电源控制：power[0/1] 传感器ID: [1 温度, 2湿度, 3 甲醛, 4 PM2.5, 5 CO2] */
	@Override
	public byte[] setSensorsPower(int power, int sensorID) {
		if (null != sensorsFourInOneLogic) {
			byte[] command = sensorsFourInOneLogic.setSensorsPower(power, sensorID);
			return command;
		}
		return errorByte;
	}

	/**
	 * 主动上报频率设置 是否设置上报频率：responseFrequencyValid[0/1] 传感器ID responseID : [1 温度、2湿度、3 甲醛、4 PM2.5] 上报频率(单位
	 * 秒)：responseFrequency
	 */
	@Override
	public byte[] setResponseFrequency(int responseFrequencyValid, int responseID, int responseFrequency) {
		if (null != sensorsFourInOneLogic) {
			byte[] command = sensorsFourInOneLogic.setResponseFrequency(responseFrequencyValid, responseID,
					responseFrequency);
			return command;
		}
		return errorByte;
	}

	/*************************************** 状态查询 *************************************************/
	/** 获取 温度传感器ID */
	@Override
	public int getTemperatureSensorID() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getTemperatureSensorID();
		}
		return errorInt;
	}

	/** 获取 温度值是否有效 */
	@Override
	public int getTemperatureValueValid() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getTemperatureValueValid();
		}
		return errorInt;
	}

	/** 获取 温度传感器电源状态 */
	@Override
	public int getTemperatureSensorPowerStatus() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getTemperatureSensorPowerStatus();
		}
		return errorInt;
	}

	/** 获取 上次读温度值时间 */
	@Override
	public int getTemperatureInterval() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getTemperatureInterval();
		}
		return errorInt;
	}

	/** 获取 温度值 */
	@Override
	public float getTemperatureValue() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getTemperatureValue();
		}
		return errorInt;
	}

	/** 获取 湿度传感器ID */
	@Override
	public int getHumiditySensorID() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getHumiditySensorID();
		}
		return errorInt;
	}

	/** 获取 湿度值是否有效 */
	@Override
	public int getHumidityValueValid() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getHumidityValueValid();
		}
		return errorInt;
	}

	/** 获取 湿度传感器电源状态 */
	@Override
	public int getHumiditySensorPowerStatus() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getHumiditySensorPowerStatus();
		}
		return errorInt;
	}

	/** 获取 上次读湿度值时间 */
	@Override
	public int getHumidityInterval() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getHumidityInterval();
		}
		return errorInt;
	}

	/** 获取 湿度值 */
	@Override
	public int getHumidityValue() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getHumidityValue();
		}
		return errorInt;
	}

	/** 获取 甲醛传感器ID */
	@Override
	public int getH2COSensorID() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getH2COSensorID();
		}
		return errorInt;
	}

	/** 获取 甲醛值是否有效 */
	@Override
	public int getH2COValueValid() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getH2COValueValid();
		}
		return errorInt;
	}

	/** 获取 甲醛传感器电源状态 */
	@Override
	public int getH2COSensorPowerStatus() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getH2COSensorPowerStatus();
		}
		return errorInt;
	}

	/** 获取 上次读甲醛值时间 */
	@Override
	public int getH2COInterval() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getH2COInterval();
		}
		return errorInt;
	}

	/** 获取 甲醛值 */
	@Override
	public float getH2COValue() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getH2COValue();
		}
		return errorInt;
	}

	/** 获取 PM2.5传感器ID */
	@Override
	public int getPM2_5SensorID() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getPM2_5SensorID();
		}
		return errorInt;
	}

	/** 获取 PM2.5值是否有效 */
	@Override
	public int getPM2_5ValueValid() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getPM2_5ValueValid();
		}
		return errorInt;
	}

	/** 获取 PM2.5传感器电源状态 */
	@Override
	public int getPM2_5SensorPowerStatus() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getPM2_5SensorPowerStatus();
		}
		return errorInt;
	}

	/** 获取 上次读PM2.5值时间 */
	@Override
	public int getPM2_5Interval() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getPM2_5Interval();
		}
		return errorInt;
	}

	/** 获取 PM2.5值 */
	@Override
	public float getPM2_5Value() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getPM2_5Value();
		}
		return errorInt;
	}

	/** 获取 CO2传感器ID */
	@Override
	public int getCO2SensorID() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getCO2SensorID();
		}
		return errorInt;
	}

	/** 获取 CO2值是否有效 */
	@Override
	public int getCO2ValueValid() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getCO2ValueValid();
		}
		return errorInt;
	}

	/** 获取 CO2传感器电源状态 */
	@Override
	public int getCO2SensorPowerStatus() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getCO2SensorPowerStatus();
		}
		return errorInt;
	}

	/** 获取 上次读CO2值时间 */
	@Override
	public int getCO2Interval() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getCO2Interval();
		}
		return errorInt;
	}

	/** 获取 CO2值 */
	@Override
	public int getCO2Value() {
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getCO2Value();
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
		if (null != sensorsFourInOneLogic) {
			return sensorsFourInOneLogic.getIsPeripheralsCommunicationError();
		}
		return errorInt;
	}

}
