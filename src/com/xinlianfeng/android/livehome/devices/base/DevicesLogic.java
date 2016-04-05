package com.xinlianfeng.android.livehome.devices.base;

import org.json.JSONException;
import org.json.JSONObject;

import com.xinlianfeng.json.jni.ProtocolNative;


public class DevicesLogic {
	public static final String TAG_JSON = "TAG_JSON";
	public static final String TAG_STATUS_REFRESH_TIME = "IntervalTime";
	public static final String TAG = "DevicesLogic";
	/** 子设备类型 */
	public int DEVICE_TYPE = 0;
	/** 子设备地址 */
	public int DEVICE_SUB_ADDRESS = 0;
	/** 帧序号 暂时为0 */
	public int frameSequence = 0;
	/** 包序号 用于区分每条指令 */
	public int packetSequence = 0;
	/** 出错判断 */
	public static final String PARSE_ERROR = "";
	/** 命令 键 */
	public static final String CMD_KEY = "Cmd";
	/** 声音控制(设置) */
	public static final String SOUND_KEY = "SoundSet";
	/** 电源开关 */
	public static final String POWER_KEY = "Power";
	/** 通用开机 键 */
	public static final String POWER_ON_COMMON_KEY = "PowerOn";
	/** 通用关机 键 */
	public static final String POWER_OFF_COMMON_KEY = "PowerOff";
	/** 获取地址 键 */
	public static final String GET_DEVICE_ADDRESS_KEY = "GetAddr";
	/** 应答标志 键 */
	public static final String ACK_FLAG_KEY = "AckFlag";
	/** ？ 键 */
	public static final int XLF_HEAD_MAGIC = 0x66bb;
	/** 设置命令key 需要子类覆写 */
	public String CMD_SET_KEY = null;
	/** 查询状态 key 需要子类覆写 */
	public String CMD_QUERY_STATUS_KEY = null;
	/** 查询功能 key 需要子类覆写 */
	public String CMD_QUERY_FUNCTION_KEY = null;
	/** 保存解析出来 状态的JSON 字符串 */
	public String allStatusString = null;
	/** 保存解析出来 功能的JSON 字符串 */
	public String allFunctionString = null;
	/** 设备状态 保存到 JSON对象 */
	public JSONObject deviceAllStatuses = new JSONObject();
	/** 设备功能 保存到 JSON对象 */
	public JSONObject deviceAllFunctions = new JSONObject();
	/** 设备功能使能 保存到JSON对象 */
	public JSONObject deviceFunctionEnable = new JSONObject();
	/** 放json格式字符串 */
	protected StringBuilder jsonBuilder;

	// 查询 key:
	/** 帧内序号 */
	public static final String SEQUENCE_KEY = "Sequence";
	/** 操作结果 */
	public static final String RESULT_KEY = "Result";

	// 错误情况返回
	/** 空的byte[] 用于错误情况返回 */
	public byte[] errorByte = null;
	/** errorInt 用于错误情况返回 */
	public int errorInt = -1;
	/** errorInt 用于错误情况返回 */
	public String errorString = "";

	// Box相关
	/** 设置开机 当前时间 */
	protected long setPowerOnCurrentTime = 0;
	/** 设置关机 当前时间 */
	protected long setPowerOffCurrentTime = 0;
	/** 开机时间更新标志位 */
	protected boolean timePowerOnUpdateFlag = true;
	/** 设置模式 当前时间 */
	protected long setModeCurrentTime = 0;
	/** 模式时间更新标志位 */
	protected boolean timeModeUpdateFlag = true;
	/** 记录上一个模式 */
	protected String lastMode = "auto";
	/** 模式切换标志位 */
	protected boolean modeSwitchUpdateFlag = true;
	/** 设置强力 当前时间 */
	protected long setHighEfficientCurrentTime = 0;
	/** 高效 时间更新标志位 */
	protected boolean timeHighEfficientUpdateFlag = true;
	/** 持续时间 当前时间 */
	protected long durationTime = 0;
	/** 持续时间错误处理 当前时间 */
	protected long durationTimeError = 0;

	// 距离上次状态刷新 时间间隔
	protected long timeCurrentOfStatusRefresh = 0;
	protected long defaultTimeIntervalOfLastTimeStatusRefresh = 2 * 60;
	protected long getTimeIntervalOfLastTimeStatusRefresh = 0;
	protected long setTimeIntervalOfLastTimeStatusRefresh = 0;
	protected boolean isFirstTimeStatusRefresh = true;
	// 状态查询返回是否超时标记
	protected boolean isStatusQueryReturnOverTime = true;

	// 功能设置相关 初始化设备功能
	/** 功能 键 数组 */
	public static String[] functionsKeyArray = null;
	/** 功能 值 int数组 */
	public static int[] functionsValueIntArray = null;
	/** 功能 值 String数组 */
	public static String[] functionsValueStringArray = null;
	/** 功能 键 数组 长度 */
	public static int functionsKeyLength = -1;
	/** 功能 值 数组 长度 */
	public static int functionsValueLength = -1;

	/** 版本号 */
	public static final String VERSION_NUMBER = "VersionNumber:1.0.3_2015.10.20"; // 控制类版本号
	public static final String VERSION_NUMBER_MODIFY = "Modify : Add Set Functions Methods\r\n"; // Modify

	/** 获取控制类版本号 */
	public String getVersionNumberOfDevicesControl() {
		return VERSION_NUMBER; // 控制类版本号
		// return VERSION_NUMBER + VERSION_NUMBER_MODIFY;
	}

	/** 获取so库版本号 */
	public String getVersionNumberOfSoLibrary() {
		return ProtocolNative.protocolGetVersion(); // so库的版本号
	}

	/** 获取4004固件版本号 */
	public String getVersionNumberOf4004() {
		return ""; // 4004的版本号
	}

	/** 通用 字符串格式化成JSON格式 */
	protected String formatStringToJSON(Object... objects) {
		jsonBuilder = new StringBuilder();
		jsonBuilder.append("{");
		for (int i = 0; i < objects.length - 1; i += 2) {
			if (objects[i + 1] instanceof String) {
				objects[i + 1] = "\"" + objects[i + 1] + "\"";
			}
			jsonBuilder.append("\"" + objects[i] + "\"" + ":" + objects[i + 1]);
			jsonBuilder.append(",");
		}
		jsonBuilder = jsonBuilder.delete(jsonBuilder.length() - 1, jsonBuilder.length());
		jsonBuilder.append("}");
		return jsonBuilder.toString();
	}

	/** 将功能设置字符串格式化成JSON格式 */
	protected String formatStringToJSONSetCmd(Object... objects) {
		jsonBuilder = new StringBuilder();
		jsonBuilder.append("{");
		jsonBuilder.append("\"" + CMD_KEY + "\"" + ":" + "\"" + CMD_SET_KEY + "\"");
		jsonBuilder.append(",");
		for (int i = 0; i < objects.length - 1; i += 2) {
			if (objects[i + 1] instanceof String) {
				objects[i + 1] = "\"" + objects[i + 1] + "\"";
			}
			jsonBuilder.append("\"" + objects[i] + "\"" + ":" + objects[i + 1]);
			jsonBuilder.append(",");
		}
		jsonBuilder = jsonBuilder.delete(jsonBuilder.length() - 1, jsonBuilder.length());
		jsonBuilder.append("}");
		return jsonBuilder.toString();
	}

	/** 将查询字符串格式化成JSON格式 */
	protected String formatStringToJSONQueryStatusCmd(Object... objects) {
		jsonBuilder = new StringBuilder();
		jsonBuilder.append("{");
		jsonBuilder.append("\"" + CMD_KEY + "\"" + ":" + "\"" + CMD_QUERY_STATUS_KEY + "\"");
		jsonBuilder.append(",");
		for (int i = 0; i < objects.length - 1; i += 2) {
			if (objects[i + 1] instanceof String) {
				objects[i + 1] = "\"" + objects[i + 1] + "\"";
			}
			jsonBuilder.append("\"" + objects[i] + "\"" + ":" + objects[i + 1]);
			jsonBuilder.append(",");
		}
		jsonBuilder = jsonBuilder.delete(jsonBuilder.length() - 1, jsonBuilder.length());
		jsonBuilder.append("}");
		return jsonBuilder.toString();
	}

	/** 保存设备功能 */
	public boolean setSaveDeviceAllFunctions(JSONObject deviceFunctions) {
		if (deviceFunctions == null) { // 判断语句 做一些出错判断
		}
		if (deviceAllFunctions != deviceFunctions) {
			deviceAllFunctions = deviceFunctions;
			return true;
		}
		return false;
	}

	/** 获取 设备功能 String */
	public String getDeviceAllFunctionsString() {
		if (allFunctionString != null) {
			return allFunctionString;
		}
		return "";
	}

	/** 获取 设备功能 JSONObject */
	public JSONObject getDeviceAllFunctionsJSONObject() {
		if (deviceAllFunctions != null) {
			return deviceAllFunctions;
		}
		return null;
	}

	/** 通用开关机命令 */
	public byte[] setPowerCommon(int power, int soundSet) {
		String command = "";
		if (1 == power) {
			command = formatStringToJSON(CMD_KEY, POWER_ON_COMMON_KEY, SOUND_KEY, soundSet);
		} else if (0 == power) {
			command = formatStringToJSON(CMD_KEY, POWER_OFF_COMMON_KEY, SOUND_KEY, soundSet);
		}
		setStatusSave(POWER_KEY, power);
		return createNetBytesNoPassThrough(command);
	}

	/** 查询设备所有状态 */
	public byte[] setQueryDeviceAllStatus(int soundSet) {
		if (null != CMD_QUERY_STATUS_KEY) {
			String command = formatStringToJSONQueryStatusCmd(SOUND_KEY, soundSet);
			return createNetBytes(command);
		}
		return null;
	}

	/** 查询设备所有功能 */
	public byte[] setQueryDeviceAllFunctions(int soundSet) {
		if (null != CMD_QUERY_FUNCTION_KEY) {
			String command = formatStringToJSON(CMD_KEY, CMD_QUERY_FUNCTION_KEY, SOUND_KEY, soundSet);
			return createNetBytes(command);
		}
		return null;
	}

	/** 获取所有状态的json格式字符串 */
	public String getDeviceAllStatusString() {
		if (null != allStatusString) {
			return allStatusString;
		}
		return "";
	}

	/** 获取所有状态的json对象 */
	public JSONObject getDeviceAllStatusJSONObject() {
		if (null != deviceAllStatuses) {
			return deviceAllStatuses;
		}
		return null;
	}

	/** 设备状态 保存 */
	public boolean setStatusSave(String key, Object value) {
		try {
			if (deviceAllStatuses != null) {
				deviceAllStatuses.put(key, value);
			}
			return true;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return false;
	}

	/** 获取状态 String类型 */
	public String getStatusString(String key) {
		String stateStringValue = "";
		try {
			if (deviceAllStatuses != null) {
				stateStringValue = deviceAllStatuses.getString(key);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return stateStringValue;
	}

	/** 获取状态 Int类型 */
	public int getStatusInt(String key) {
		int stateIntValue = -1;
		try {
			if (deviceAllStatuses != null) {
				stateIntValue = deviceAllStatuses.getInt(key);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return stateIntValue;
	}

	/** 设备功能 保存 */
	public boolean setDeviceFunction(String key, Object value) {
		try {
			if (deviceAllFunctions != null) {
				deviceAllFunctions.put(key, value);
			}
			return true;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return false;
	}

	/** 获取功能 Int类型 */
	public int getDeviceFunction(String key) {
		int stateIntValue = -1;
		try {
			if (deviceAllFunctions != null) {
				stateIntValue = deviceAllFunctions.getInt(key);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return stateIntValue;
	}

	/** 设备功能使能 保存 */
	public boolean setDeviceFunctionEnable(String key, Object value) {
		try {
			if (deviceFunctionEnable != null) {
				deviceFunctionEnable.put(key, value);
			}
			return true;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return false;
	}

	/** 获取功能 Int类型 */
	public int getDeviceFunctionEnable(String key) {
		int stateIntValue = -1;
		try {
			if (deviceFunctionEnable != null) {
				stateIntValue = deviceFunctionEnable.getInt(key);
			}
			// stateIntValue = deviceAllFunctions.optInt(key);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return stateIntValue;
	}

	/** 生成"F4F5... 暂时 frameSeq ： 0， DEVICE_SUB_ADDRESS 从子设备取 */
	public byte[] createNetBytes(String jsonFormatedString) {
		return createNetBytes(jsonFormatedString, frameSequence, DEVICE_SUB_ADDRESS);
	}

	/** 生成"F4F5... 暂时 frameSeq ： 0， DEVICE_SUB_ADDRESS 从子设备取 */
	public byte[] createNetBytesNoPassThrough(String jsonFormatedString) {
		return createNetBytesNoPassThrough(jsonFormatedString, frameSequence, DEVICE_SUB_ADDRESS);
	}

	/**
	 * 生成"F4F5...
	 * 
	 * @param root
	 *            json格式的字符串
	 * @param farmeSeq
	 *            帧序号
	 * @param deviceSubAddr
	 *            设备子地址
	 * @return
	 */
	private byte[] createNetBytes(String root, int farmeSeq, int deviceSubAddr) {
		String tmpBuf = null;
		String strBuf = jsonBuildFrame(root, farmeSeq, deviceSubAddr); // 返回的f4f5和老的at的库返回一样
		if (strBuf != null)
			// 最终生成PassThrough的数据，然后结合 jsonBuildhead则可以发送WIFI识别的网络包
			if (packetSequence < 0) {
				packetSequence = 0;
			}
		tmpBuf = ProtocolNative.jsonCreatePassThrough(packetSequence++, 1, strBuf);
		if (tmpBuf != null)
			return jsonBuildhead(tmpBuf, 0, 0); // 最终生成WIFI识别的网络包
		return null;
	}

	/**
	 * 生成"F4F5... 通用指令透传
	 * 
	 * @param root
	 *            json格式的字符串
	 * @param farmeSeq
	 *            帧序号
	 * @param deviceSubAddr
	 *            设备子地址
	 * @return
	 */
	private byte[] createNetBytesNoPassThrough(String root, int farmeSeq, int deviceSubAddr) {
		String strBuf = jsonBuildFrame(root, farmeSeq, deviceSubAddr); // 返回的f4f5和老的at的库返回一样
		if (strBuf != null)
			return jsonBuildhead(strBuf, 0, 0); // 最终生成WIFI识别的网络包
		return null;
	}

	/**
	 * 将JSON 数据转成F4F5的调用接口
	 * 
	 * @param jsonStr
	 *            JSON格式的协议
	 * @param seq
	 *            帧内部序列号
	 * @param device_address
	 *            设备子地址
	 * @return "F4F5..."
	 */
	public String jsonBuildFrame(String jsonStr, int frameSeq, int deviceSubAddr) {
		String frame = ProtocolNative.jsonBuildFrame(jsonStr, frameSeq, DEVICE_TYPE, deviceSubAddr, 0xfe, 1);
		return frame;
	}

	/**
	 * @param jsonStr
	 *            将要发送出去的JSON数据
	 * @param enctype
	 *            是否加密
	 * @param cmdtype
	 *            发送类型
	 * @return 返回加了19字节头的全部数据流
	 */
	public byte[] jsonBuildhead(String jsonStr, int enctype, int cmdtype) {
		return ProtocolNative.jsonBuildhead(jsonStr, XLF_HEAD_MAGIC, enctype, cmdtype);
	}

	/***************************************** 初始化设备功能 相关 ******************************************/
	/**
	 * 拆分 功能 值 并保存到
	 * 
	 * subClass override
	 */
	public void setInitDeviceFunctions(String functionsValueString) {

	}

	/**
	 * subClass invoke
	 */
	public void setInitFunctions() {
		deviceAllFunctions = deviceFunctionEnable;
	}

	/***************************************** 解析方法 ******************************************/
	/**
	 * 服务收到byte[]数据后调用，以更新保存设备状态的JSON对象
	 * 
	 * @param recv
	 * @return
	 * @throws JSONException
	 */
	public String parseByteToJSON(byte[] recv) {
		JSONObject tmp = null;
		String parseString = "";
		String Cmd = "";
		String Result = "";
		parseString = ProtocolNative.bytesParseFrame(recv, DEVICE_TYPE);
		System.out.println("parse result : " + ((parseString == null) ? "" : parseString));
		if (parseString != null) {
			try {
				tmp = new JSONObject(parseString); // 暂时先这样，以后再查找效率更高的阿里的方法 ? JSONObject.fromObject(retJson);
				// Cmd = tmp.get(CMD_KEY).toString();
				// Result = tmp.get(RESULT_KEY).toString();
				Cmd = tmp.optString(CMD_KEY);
				Result = tmp.optString(RESULT_KEY);
			} catch (JSONException e) {
				e.printStackTrace();
				// json对象的状态 功能 置空 以便解析出错时方便判断
				deviceAllStatuses = null;
				deviceAllFunctions = null;
				return PARSE_ERROR;
			}
			// 查询状态
			if (Cmd.equals(CMD_QUERY_STATUS_KEY) && Result.equals("SUCCEED")) {
				if (deviceAllStatuses == null) {
					deviceAllStatuses = new JSONObject();
				}
				deviceAllStatuses = tmp;
				allStatusString = parseString;
				// 状态刷新时间间隔处理部分
				if (isFirstTimeStatusRefresh) {
					// 本次状态刷新当前时间
					timeCurrentOfStatusRefresh = System.currentTimeMillis();
					isFirstTimeStatusRefresh = false;
				}
				// 本次状态刷新当前时间
				timeCurrentOfStatusRefresh = System.currentTimeMillis();
			} else if (Cmd.equals(CMD_QUERY_FUNCTION_KEY) && Result.equals("SUCCEED")) { // 查询功能
				if (deviceAllFunctions == null) { // 保存功能的json对象
					deviceAllFunctions = new JSONObject();
				}
				if (deviceFunctionEnable == null) { // 保存功能使能的json对象
					deviceFunctionEnable = new JSONObject();
				}
				deviceAllFunctions = tmp;
				deviceFunctionEnable = deviceAllFunctions; // 将功能赋值给功能使能
				allFunctionString = parseString;
			} else {
				return null;
			}
		}
		// 调用回调
		return allStatusString;
	}

	/**
	 * 距离上次状态刷新 间隔时间 单位 秒
	 * 
	 * @return
	 *         距离上次状态刷新 间隔时间 单位 秒
	 */
	public long getIntervalTimeOfStatusRefresh() {
		if (timeCurrentOfStatusRefresh != 0) {
			return (System.currentTimeMillis() - timeCurrentOfStatusRefresh) / 1000;
		}
		return errorInt;
	}

	/**
	 * 设置 状态刷新 间隔时间 单位 秒
	 * 
	 * @return
	 */
	public boolean setIntervalTimeOfStatusRefresh(long seconds) {
		if (seconds != 0) {
			defaultTimeIntervalOfLastTimeStatusRefresh = seconds;
			return true;
		}
		return false;
	}

	/**
	 * 查询 状态刷新 是否超时
	 * 
	 * @return
	 *         true 超时，false不超时
	 */
	public boolean getIntervalTimeOfStatusRefreshIsOverTime() {
		// 状态刷新时间间隔处理部分
		long intervalTimeOfStatusRefresh = getIntervalTimeOfStatusRefresh();
		if (intervalTimeOfStatusRefresh == errorInt
				|| intervalTimeOfStatusRefresh > defaultTimeIntervalOfLastTimeStatusRefresh) {
			// 超出默认或设置的状态刷新时间间隔，置null处理
			deviceAllStatuses = null;
			allStatusString = null;
			return true;
		}
		return false;
	}

	/**
	 * 解析接收数据 对应的设备类型
	 * 
	 * @param receiveF4F5String
	 * @return
	 */
	public String getSourceDeviceType(String receiveF4F5String) {
		String parseF4F5Result = ProtocolNative.getSourceDeviceType(receiveF4F5String);
		System.out.println("parseF4F5Result : " + ((parseF4F5Result == null) ? "" : parseF4F5Result));
		if (parseF4F5Result != null && parseF4F5Result != "") {
			return parseF4F5Result;
		}
		return "";
	}

	/***************************************** 以下方法暂时不用 ******************************************/
	/**
	 * 这个是用来从网络收到的或build出来的byte[]中找出json字符串的方法，可以用来debug
	 * 
	 * @param in
	 * @return
	 */
	public String getJsonFromBytes(byte[] in) {
		String jsonStr = null;
		if (in.length > 19) {
			/*
			 * for(int i=0;i<19;i++){ Log.d(TAG,in[i]+" "); }
			 */
			byte[] out = new byte[in.length - 19];
			System.arraycopy(in, 19, out, 0, out.length);
			jsonStr = new String(out);
			System.out.println(jsonStr);
		} else {
			System.out.println("byte[] is null");
		}

		return jsonStr;
	}
}
