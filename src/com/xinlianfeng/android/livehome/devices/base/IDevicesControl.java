package com.xinlianfeng.android.livehome.devices.base;

import org.json.JSONObject;

public interface IDevicesControl {

	/**
	 * 通用开、关机
	 * 
	 * @param power
	 *            [0/1]
	 * @param soundSet
	 *            [0/1]
	 * @return
	 */
	public byte[] setPowerCommon(int power, int soundSet);

	/*********************************** 所有 状态设置及查询 **************************************/
	/**
	 * 查询设备所有状态
	 * 
	 * @param soundSet
	 *            [0/1]
	 * @return
	 */
	public byte[] setQueryDeviceAllStatus(int soundSet);

	/**
	 * 获取所有状态的json字符串
	 * 
	 * @return String
	 */
	public String getDeviceAllStatusString();

	/**
	 * 获取所有状态的json对象
	 * 
	 * @return JSONObject
	 */
	public JSONObject getDeviceAllStatusJSONObject();

	/**
	 * 设置 状态刷新 间隔时间 单位 秒
	 * 
	 * @param seconds
	 *            时间间隔秒数
	 * @return
	 *         设置成功与否
	 */

	public boolean setIntervalTimeOfStatusRefresh(long seconds);

	/**
	 * 查询 状态刷新 是否超时
	 * 
	 * @return
	 *         true 超时，false不超时
	 */
	public boolean getIntervalTimeOfStatusRefreshIsOverTime();

	/*********************************** 所有 功能设置及查询 **************************************/
	/**
	 * 查询设备所有状态
	 * 
	 * @param soundSet
	 *            [0/1]
	 * @return byte[]
	 */
	public byte[] setQueryDeviceAllFunctions(int soundSet);

	/**
	 * 保存设备所有功能
	 * 
	 * @param deviceFunctions
	 *            设备功能
	 * @return boolean
	 */
	public boolean setSaveDeviceAllFunctions(JSONObject deviceFunctions);

	/**
	 * 获取 设备所有功能 String
	 * 
	 * @return String
	 */
	public String getDeviceAllFunctionsString();

	/**
	 * 获取 设备所有功能 JSONObject
	 * 
	 * @return JSONObject
	 */
	public JSONObject getDeviceAllFunctionsJSONObject();

	/*********************************** 单个 状态设置及查询 **************************************/
	/**
	 * 设备状态 保存
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * @return boolean
	 */
	public boolean setStatusSave(String key, Object value);

	/**
	 * 获取状态 String类型
	 * 
	 * @param key
	 *            键
	 * @return String
	 */
	public String getStatusString(String key);

	/**
	 * 获取状态 Int类型
	 * 
	 * @param key
	 *            键
	 * @return int
	 */
	public int getStatusInt(String key);

	/*********************************** 功能及功能使能相关设置 查询 **************************************/
	/**
	 * 设备功能 保存
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * @return boolean
	 */
	public boolean setDeviceFunction(String key, Object value);

	/**
	 * 获取功能 Int类型
	 * 
	 * @param key
	 *            键
	 * @return int
	 */
	public int getDeviceFunction(String key);

	/**
	 * 设备功能使能 保存
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 * @return
	 */
	public boolean setFunctionEnable(String key, Object value);

	/**
	 * 获取功能 Int类型
	 * 
	 * @param key
	 *            键
	 * @return int
	 */
	public int getFunctionEnable(String key);

	/*********************************** 获取版本号 **************************************/
	/**
	 * 获取控制类版本号
	 * 
	 * @return String
	 */
	public String getVersionNumberOfDevicesControl();
	
	/**
	 * 获取so库版本号
	 * 
	 * @return String
	 */
	public String getVersionNumberOfSoLibrary();
	
	/**
	 * 获取4004版本号
	 * 
	 * @return String
	 */
	public String getVersionNumberOf4004();

	/***************************************** 初始化设备功能 相关 ******************************************/
	/**
	 * 设置家电功能表
	 * 
	 * @param functionsValueString
	 *            功能值字符串
	 */
	public void setInitDeviceFunctions(String functionsValueString);

	/*********************************** 解析方法 **************************************/
	/**
	 * 解析方法 收到的byte[] 转化成字符串
	 * 
	 * @param recv
	 *            返回的byte[]
	 * @return String
	 */
	public String parseByteToJSON(byte[] recv);
	
	/*********************************** 获取设备类型 *************************************/
	/**
	 * 解析接收数据 对应的设备类型
	 * 
	 * @param receiveF4F5String
	 * @return
	 */
	public String getSourceDeviceType(String receiveF4F5String);
}
