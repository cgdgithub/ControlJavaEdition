package com.xinlianfeng.android.livehome.devices.base;

import org.json.JSONObject;

public class DevicesControl implements IDevicesControl {
	public static final String TAG_JSON = "TAG_JSON";

	public static final String TAG = "DevicesControl";

	/** 空的byte[] 用于错误情况返回 */
	public byte[] errorByte = null;
	/** errorInt 用于错误情况返回 */
	public int errorInt = -1;
	/** errorInt 用于错误情况返回 */
	public String errorString = "";

	public DevicesLogic devicesLogic = null;

	public DevicesControl() {
		devicesLogic = new DevicesLogic();
	}

	/** 通用开、关机 */
	@Override
	public byte[] setPowerCommon(int power, int soundSet) {
		if (null != devicesLogic) {
			return devicesLogic.setPowerCommon(power, soundSet);
		}
		return errorByte;
	}

	/*********************************** 所有 状态设置及查询 **************************************/
	/** 查询设备所有状态 */
	@Override
	public byte[] setQueryDeviceAllStatus(int soundSet) {
		if (null != devicesLogic) {
			return devicesLogic.setQueryDeviceAllStatus(soundSet);
		}
		return errorByte;
	}

	/** 获取所有状态的json字符串 */
	@Override
	public String getDeviceAllStatusString() {
		if (null != devicesLogic) {
			return devicesLogic.getDeviceAllStatusString();
		}
		return errorString;
	}

	/** 获取所有状态的json对象 */
	@Override
	public JSONObject getDeviceAllStatusJSONObject() {
		if (null != devicesLogic) {
			return devicesLogic.getDeviceAllStatusJSONObject();
		}
		return null;
	}

	/**
	 * 设置 状态刷新 间隔时间 单位 秒
	 * 
	 * @return
	 */
	@Override
	public boolean setIntervalTimeOfStatusRefresh(long seconds) {
		if (null != devicesLogic) {
			return devicesLogic.setIntervalTimeOfStatusRefresh(seconds);
		}
		return false;
	}

	/**
	 * 查询 状态刷新 是否超时
	 * 
	 * @return
	 *         true 超时，false不超时
	 */
	@Override
	public boolean getIntervalTimeOfStatusRefreshIsOverTime() {
		if (null != devicesLogic) {
			return devicesLogic.getIntervalTimeOfStatusRefreshIsOverTime();
		}
		return false;
	}

	/*********************************** 所有 功能设置及查询 *************************************/
	/** 查询设备所有状态 */
	@Override
	public byte[] setQueryDeviceAllFunctions(int soundSet) {
		if (null != devicesLogic) {
			return devicesLogic.setQueryDeviceAllFunctions(soundSet);
		}
		return errorByte;
	}

	/** 保存设备所有功能 */
	@Override
	public boolean setSaveDeviceAllFunctions(JSONObject deviceFunctions) {
		if (null != devicesLogic) {
			return devicesLogic.setSaveDeviceAllFunctions(deviceFunctions);
		}
		return false;
	}

	/** 获取 设备所有功能 String */
	@Override
	public String getDeviceAllFunctionsString() {
		if (null != devicesLogic) {
			return devicesLogic.getDeviceAllFunctionsString();
		}
		return "";
	}

	/** 获取 设备所有功能 JSONObject */
	@Override
	public JSONObject getDeviceAllFunctionsJSONObject() {
		if (null != devicesLogic) {
			return devicesLogic.getDeviceAllFunctionsJSONObject();
		}
		return null;
	}

	/*********************************** 单个 状态设置及查询 *************************************/
	/** 设备状态 保存 */
	@Override
	public boolean setStatusSave(String key, Object value) {
		if (null != devicesLogic) {
			return devicesLogic.setStatusSave(key, value);
		}
		return false;
	}

	/** 获取状态 String类型 */
	@Override
	public String getStatusString(String key) {
		String stateStringValue = "";
		if (null != devicesLogic) {
			stateStringValue = devicesLogic.getStatusString(key);
		}
		return stateStringValue;
	}

	/** 获取状态 Int类型 */
	@Override
	public int getStatusInt(String key) {
		int stateIntValue = -1;
		if (null != devicesLogic) {
			stateIntValue = devicesLogic.getStatusInt(key);
		}
		return stateIntValue;
	}

	/*********************************** 功能及功能使能相关设置 查询 *************************************/
	/** 设备功能 保存 */
	@Override
	public boolean setDeviceFunction(String key, Object value) {
		if (null != devicesLogic) {
			return devicesLogic.setDeviceFunction(key, value);
		}
		return false;
	}

	/** 获取功能 Int类型 */
	@Override
	public int getDeviceFunction(String key) {
		if (null != devicesLogic) {
			return devicesLogic.getDeviceFunction(key);
		}
		return errorInt;
	}

	/** 设备功能使能 保存 */
	@Override
	public boolean setFunctionEnable(String key, Object value) {
		if (null != devicesLogic) {
			return devicesLogic.setDeviceFunctionEnable(key, value);
		}
		return false;
	}

	/** 获取功能 Int类型 */
	@Override
	public int getFunctionEnable(String key) {
		if (null != devicesLogic) {
			return devicesLogic.getDeviceFunctionEnable(key);
		}
		return errorInt;
	}

	/*********************************** 获取版本号 *************************************/
	/** 获取控制类版本号 */
	@Override
	public String getVersionNumberOfDevicesControl() {
		if (null != devicesLogic) {
			return devicesLogic.getVersionNumberOfDevicesControl();
		}
		return errorString;
	}

	/** 获取so库版本号 */
	@Override
	public String getVersionNumberOfSoLibrary() {
		if (null != devicesLogic) {
			return devicesLogic.getVersionNumberOfSoLibrary();
		}
		return errorString;
	}

	/** 获取4004版本号 */
	@Override
	public String getVersionNumberOf4004() {
		if (null != devicesLogic) {
			return devicesLogic.getVersionNumberOf4004();
		}
		return errorString;
	}

	/***************************************** 初始化设备功能 相关 ******************************************/
	/**
	 * 拆分 功能 值 并保存到
	 */
	@Override
	public void setInitDeviceFunctions(String functionsValueString) {
		if (null != devicesLogic) {
			devicesLogic.setInitDeviceFunctions(functionsValueString);
		}
	}

	/*********************************** 解析方法 *************************************/
	/** 解析方法 收到的byte[] 转化成字符串 */
	@Override
	public String parseByteToJSON(byte[] recv) {
		if (null != devicesLogic) {
			return devicesLogic.parseByteToJSON(recv);
		}
		return null;
	}
	
	/*********************************** 获取设备类型 *************************************/
	/**
	 * 解析接收数据 对应的设备类型
	 * 
	 * @param receiveF4F5String
	 * @return
	 */
	@Override
	public String getSourceDeviceType(String receiveF4F5String) {
		if (null != devicesLogic) {
			return devicesLogic.getSourceDeviceType(receiveF4F5String);
		}
		return null;
	}

}
