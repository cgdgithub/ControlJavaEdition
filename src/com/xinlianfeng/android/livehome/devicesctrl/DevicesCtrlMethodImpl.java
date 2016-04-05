package com.xinlianfeng.android.livehome.devicesctrl;

import org.json.JSONException;
import org.json.JSONObject;

//import android.os.Build;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Message;
//import android.text.TextUtils;

import com.xinlianfeng.android.livehome.devices.aircleaner.IAirCleanerControl;
import com.xinlianfeng.android.livehome.devices.aircondition.IAirConditionControl;
import com.xinlianfeng.android.livehome.devices.airfan.IAirFanControl;
import com.xinlianfeng.android.livehome.devices.base.IDevicesControl;
import com.xinlianfeng.android.livehome.devices.dehumidifier.IDehumidifierControl;
import com.xinlianfeng.android.livehome.devices.sensorsfourinone.ISensorsFourInOneControl;
import com.xinlianfeng.android.livehome.devices.smartcurtain.ISmartCurtainControl;
import com.xinlianfeng.android.livehome.devices.smartlight.ISmartLightControl;
import com.xinlianfeng.android.livehome.devices.voltameter.IVoltameterControl;
//import com.xinlianfeng.android.livehome.devices.wificontrol.IWifiControl;
import com.xinlianfeng.android.livehome.devicesctrl.DevicesControlManager.DeviceInfo;
//import com.xinlianfeng.android.livehome.net.mqtt.MqttManager;
//import com.xinlianfeng.android.livehome.net.socket.SocketManager;
import com.xinlianfeng.android.livehome.util.Constants;
//import com.xinlianfeng.android.livehome.util.LogUtils;
import com.xinlianfeng.android.livehome.util.Util;

public class DevicesCtrlMethodImpl implements IDevicesCtrlMethod {
	private static final String TAG = "DevicesControlImpl";
	/** 空的byte[] 用于错误情况返回 */
	public byte[] errorByte = null;
	private static DevicesCtrlMethodImpl instance = null;
	
	private DevicesControlManager devicesControlManager = null;
//	private Handler mHandler = null;
	
	private IDevicesControl devicesControl = null;
	private IAirConditionControl airconControl = null;
	private IDehumidifierControl dehumidifierControl = null;
	private IAirCleanerControl aircleanerControl = null;
	private IAirFanControl airfanControl = null;
	private ISensorsFourInOneControl sensorsControl = null;
//	private IWifiControl wifiControl = null;
	private ISmartCurtainControl smartcurtainControl = null;
	private ISmartLightControl smartlightControl = null;
	private IVoltameterControl voltameterControl = null;

	private DevicesCtrlMethodImpl() {
		devicesControlManager = DevicesControlManager.getInstance();
	}

	public static IDevicesCtrlMethod getInstance() {
		if(null == instance) {
			instance = new DevicesCtrlMethodImpl();
		}
		return instance;
	}
	
//	public void setHandler(Handler handler) {
//		mHandler = handler;
//	}

	/**
	* <p>Title: initDevicesControl</p>
	* <p>Description: 初始化设备的控制类 </p>
	* @param deviceId:设备ID(String类型)
	* @param deviceType 设备类型
	*/
	@Override
	public void initDevicesControl(String deviceId, String deviceType) {
		if(null != devicesControlManager) {
			devicesControlManager.initDevicesControl(deviceId, deviceType);
		}
	}

	/**
	* <p>Title: delDevicesControl</p>
	* <p>Description: 删除设备的控制类</p>
	* @param deviceId:设备ID(String类型)
	*/
	@Override
	public void delDevicesControl(String deviceId) {
		if(null != devicesControlManager) {
			devicesControlManager.delDevicesControl(deviceId);
		}
	}

	@Override
	public void cleanAllControl() {
		if(null != devicesControlManager) {
			devicesControlManager.cleanAllControl();
		}
	}
	
	/**
	* <p>Title: initDevicesSocket</p>
	* <p>Description: 初始化设备的socket连接</p>
	* @param deviceId:设备ID(String类型)
	* @param ip:目标IP(String类型)
	* @param port:目标IP的端口(int类型)
	* @param userName:当前用户名(String类型)
	* @return 成功或失败(boolean类型) 成功或失败(boolean类型)
	*/
//	@Override
//	public boolean initDevicesSocket(String deviceId, String ip, int port, boolean ifNeedReconnect, String userName) {
//		boolean isConnectSucceed = false;
//		if(null != devicesControlManager) {
//			DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
//			if(null != deviceInfo) {
//				LogUtils.d(TAG, "Init Socket to " + deviceId + " , " + ip + ":" + port + " ... ");
//				if(!TextUtils.isEmpty(ip) && 0 != port) {
//					if(null != SocketManager.getInstance()) {
//						isConnectSucceed = SocketManager.getInstance().initSocketClientConnect(deviceId, ip, port, deviceInfo.strType, ifNeedReconnect, userName);
//					}
//					if(!isConnectSucceed) {
//						LogUtils.e(TAG, "Init Socket to " + deviceId + " fail !");
//					} else {
//						deviceInfo.ip = ip;
//						deviceInfo.port = port;
//						deviceInfo.isConnect = isConnectSucceed;
//						devicesControlManager.setDeviceInfo(deviceId, deviceInfo);
//						LogUtils.i(TAG, "Init Socket to " + deviceId + " succeed !");
//					}
//				}
//			}
//		}
//		
//		return isConnectSucceed;
//	}

	/**
	* <p>Title: closeDevicesSocket</p>
	* <p>Description: 关闭 设备的socket连接</p>
	* @param deviceId:设备ID(String类型)  
	*/
//	@Override
//	public void closeDevicesSocket(String deviceId) {
//		LogUtils.v(TAG, "close client Socket to " + deviceId);
//		if(null != devicesControlManager) {
//			DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
//			if(null != deviceInfo) {
//				if(null != SocketManager.getInstance()) {
//					if(null != SocketManager.getInstance().getSocketClientChannel(deviceId)) {
//						SocketManager.getInstance().closeSocketChannel(deviceId);
//					} else {
//						SocketManager.getInstance().closeDevicesChannel(deviceId);
//					}
//				}
//				deviceInfo.ip = null;
//				deviceInfo.port = 0;
//				deviceInfo.isConnect = false;
//				devicesControlManager.setDeviceInfo(deviceId, deviceInfo);
//			}
//		}
//	}

	/**
	* <p>Title: startSmartBoxNetConnect</p>
	* <p>Description: 初始化smartbox网络连接服务</p>
	*/
//	@Override
//	public void startSmartBoxNetConnect() {
//		if(null != SocketManager.getInstance()) {
//			SocketManager.getInstance().initDevicesSocketServer();
//			SocketManager.getInstance().initPhoneSocketServer();
//			SocketManager.getInstance().startSocketListenThread();
//		}
//	}

	/**
	* <p>Title: closeSmartBoxNetConnect</p>
	* <p>Description: 关闭smartbox网络连接服务 </p>
	*/
//	@Override
//	public void closeSmartBoxNetConnect() {
//		if(null != SocketManager.getInstance()) {
//			SocketManager.getInstance().stopDevicesSocketServer();
//			SocketManager.getInstance().stopPhoneSocketServer();
//			SocketManager.getInstance().stopSocketListenThread();
//		}
//	}
	
	/**
	 * <p>Title: sendMessageWithSocket</p>
	 * <p>Description: 发送设备控制指令</p> 
	 * @param deviceId:设备ID(String类型)
	 * @param message:指令(byte数组)
	 * @return 成功或失败(boolean类型)
	 */
//	private boolean sendMessageWithSocket(String deviceId, byte[] message) {
//		if(null != deviceId && null != message) {
//			if(null != SocketManager.getInstance()) {
//				if(null != SocketManager.getInstance().getSocketClientChannel(deviceId)) {
//					return SocketManager.getInstance().sendMessage(deviceId, message);
//				} else {
//					return SocketManager.getInstance().sendMessageToDev(deviceId, message);
//				}
//			}
//		}
//		return false;
//	}
	
	/**
	* <p>Title: sendMessageWithMqtt</p>
	* <p>Description: 发送设备控制指令</p> 
	* @param deviceId:设备ID(String类型)
	* @param message:指令(byte数组)
	* @return 成功或失败(boolean类型)
	*/
	private byte[] sendMessageWithMqtt(String deviceId, byte[] message) {
		if(null != deviceId && null != message) {
//			return mqttPulishMessage(Build.SERIAL, "module." + Util.getWifModuleApName(deviceId) + ".S", 0, message);
			return message;
		}
		return null;
	}

	/**
	* <p>Title: setDevicesOnlineStatus</p>
	* <p>Description: 设置设备的在线状态 </p>
	* @param deviceId:设备ID(String类型)
	* @param isOnline:是否在线(boolean类型)
	*/
//	@Override
//	public synchronized void setDevicesOnlineStatus(String deviceId, boolean isOnline) {
//		if(null != devicesControlManager) {
//			DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
//			if(null != deviceInfo) {
//				deviceInfo.isConnect = isOnline;
//				devicesControlManager.setDeviceInfo(deviceId, deviceInfo);
//				
//				/** 设备第一次上线，发送一条66指令到设备 */
//				if(isOnline && null != deviceInfo.devicesControl) {
//					byte[] data = deviceInfo.devicesControl.setQueryDeviceAllStatus(0);
//					int entry = 3;
//					while(!sendMessageWithMqtt(deviceId, data) && entry-- > 0) {
//						;
//					}
//					LogUtils.d(TAG, "frist send 66 comand succeed ! to device " + deviceId);
//				}
//			}
//		}
//	}

//	@Override
//	public boolean initMqttClient(String host, String id, String userName, String password) {
//		if(null != MqttManager.getInstance()) {
//			return MqttManager.getInstance().creatMqttClient(host, id, userName, password);
//		}
//		return false;
//	}

//	@Override
//	public void closeMqttClient(String id) {
//		if(null != MqttManager.getInstance()) {
//			MqttManager.getInstance().delMqttclient(id);
//		}
//	}

//	@Override
//	public boolean mqttClientSubscribeTopic(String id, String topic, int qos) {
//		if(null != MqttManager.getInstance()) {
//			return MqttManager.getInstance().mqttClientSubscribe(id, topic, qos);
//		}
//		return false;
//	}

//	@Override
//	public boolean mqttClientSubscribeAll(String id, int qos) {
//		if(null != MqttManager.getInstance()) {
//			return MqttManager.getInstance().mqttClientSubscribeAll(id, qos);
//		}
//		return false;
//	}
	
//	@Override
//	public boolean mqttClientUnsubscribeTopic(String id, String topic) {
//		if(null != devicesControlManager) {
//			DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(topic);
//			if(null != deviceInfo) {
//				deviceInfo.isConnect = false;
//				devicesControlManager.setDeviceInfo(topic, deviceInfo);
//			}
//		}
//		
//		if(null != MqttManager.getInstance()) {
//			return MqttManager.getInstance().mqttClientUnSubscribe(id, topic);
//		}
//		
//		return false;
//	}

//	@Override
//	public boolean mqttPulishMessage(String id, String topic, int qos, byte[] message) {
//		if(null != MqttManager.getInstance()) {
//			return MqttManager.getInstance().mqttClientPublish(id, topic, qos, message);
//		}
//		return false;
//	}
	
//	@Override
//	public boolean isTopicSubscribed(String id, String topic) {
//		if(null != MqttManager.getInstance()) {
//			return MqttManager.getInstance().isTopicSubscribed(id, topic);
//		}
//		return false;
//	}
	
	/**
	* <p>Title: setDevicesInfo</p>
	* <p>Description: 设置设备的控制类相关信息</p>
	* @param deviceId:设备ID(String类型)
	* @param info:设备信息(DeviceInfo类型)  
	*/
	@Override
	public void setDevicesInfo(String deviceId, DeviceInfo info) {
		if(null != devicesControlManager) {
			devicesControlManager.setDeviceInfo(deviceId, info);
		}
	}

	/**
	* <p>Title: getDevicesInfo</p>
	* <p>Description: 获取设备的控制类相关信息</p>
	* @param deviceId:设备ID(String类型)
	* @return 设备信息(DeviceInfo类型或null)
	*/
	@Override
	public DeviceInfo getDevicesInfo(String deviceId) {
		if(null != devicesControlManager) {
			return devicesControlManager.getDeviceInfo(deviceId);
		}
		return null;
	}

	/**
	* <p>Title: parseSocketData</p>
	* <p>Description: 解析socket收到的数据 </p>
	* @param deviceId:设备ID(String类型)
	* @param result:socket收到的数据(byte数组)
	*/
//	@Override
//	public void parseSocketData(String deviceId, byte[] result) {
//		if(null != devicesControlManager) {
//			DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
//			if(null != deviceInfo && null != deviceInfo.devicesControl) {
//				if(!deviceInfo.isConnect) {
//					deviceInfo.isConnect = true;
//				}
//				/** 调用控制类解析，返回解析结果；通过mHandler发送消息通知ui;如果devices控制类不能解析则调用wifi控制类解析 */
//				String jsonString = deviceInfo.devicesControl.parseByteToJSON(result);
//				if(null == jsonString && null != deviceInfo.wifiControl) {
//					boolean atCmd = deviceInfo.wifiControl.ParseResult(new String(result));
//					if(!atCmd && result.length >= 19) {
//						jsonString = deviceInfo.wifiControl.ParseJsonResult(result);
//					}
//				}
//				
//				if(null != jsonString) {
//					JSONObject tmp = null;
//					String cmd = null;
//					String ret = null;
//					try {
//						tmp = new JSONObject(jsonString);
//						cmd = (null != tmp.get("Cmd") ? tmp.get("Cmd").toString() : "");
//						ret = (null != tmp.get("Result") ? tmp.get("Result").toString() : "");
//					} catch (JSONException e) {
//						e.printStackTrace();
//						LogUtils.e(TAG, "parseSocketData error !");
//						return;
//					}
//					
//					if(null != mHandler) {
//						Message callback = new Message();
//						callback.what = Constants.MSG_GET_APPLIANCE_RESULT;
//						Bundle applianceData = new Bundle();
//						applianceData.putString(Constants.APPLIANCE_APPLIANCE_ID, deviceId);
//						applianceData.putString(Constants.APPLIANCE_APPLIANCE_CMD, cmd);
//						applianceData.putString(Constants.APPLIANCE_APPLIANCE_RESULT, ret);
//						callback.setData(applianceData);
//						
//						mHandler.sendMessage(callback);
//					}
//				}
//			}
//		}
//	}


	/*********************************** 设备公共函数 *******************************************/
	/**
	* <p>Title: isAirconditionExist</p>
	* <p>Description: 此空调是否可用 </p>
	* @param deviceId:设备ID(String类型)
	* @return 成功或失败(boolean类型)  
	*/
	@Override
	public boolean isDevicesExist(String deviceId) {
		if(null != devicesControlManager) {
			DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
			if(null != deviceInfo) {
				if(deviceInfo.isConnect) {
					if(null != deviceInfo.devicesControl) {
						devicesControl = deviceInfo.devicesControl;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	* <p>Title: isAirconditionExist</p>
	* <p>Description: 此空调是否可用 </p>
	* @param deviceId:设备ID(String类型)
	* @return 成功或失败(boolean类型)  
	*/
	@Override
	public boolean isAirconditionExist(String deviceId) {
		if(null != devicesControlManager) {
			DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
			if(null != deviceInfo) {
				if(deviceInfo.isConnect && Constants.AIRCON_TYPE_ADDR == deviceInfo.strType) {
					if(null != deviceInfo.devicesControl) {
						airconControl = (IAirConditionControl)deviceInfo.devicesControl;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	* <p>Title: isDehumidifierExist</p>
	* <p>Description: 此除湿机是否可用</p>
	* @param deviceId:设备ID(String类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public boolean isDehumidifierExist(String deviceId) {
		if(null != devicesControlManager) {
			DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
			if(null != deviceInfo) {
				if(deviceInfo.isConnect && Constants.DEHUMIDIFIER_TYPE_ADDR == deviceInfo.strType) {
					if(null != deviceInfo.devicesControl) {
						dehumidifierControl = (IDehumidifierControl)deviceInfo.devicesControl;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	* <p>Title: isAircleanerExist</p>
	* <p>Description: 此空气净化器是否可用</p>
	* @param deviceId:设备ID(String类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public boolean isAircleanerExist(String deviceId) {
		if(null != devicesControlManager) {
			DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
			if(null != deviceInfo) {
				if(deviceInfo.isConnect && Constants.AIRCLEANER_TYPE_ADDR == deviceInfo.strType) {
					if(null != deviceInfo.devicesControl) {
						aircleanerControl = (IAirCleanerControl)deviceInfo.devicesControl;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	* <p>Title: isAirfanExist</p>
	* <p>Description: 此新风机是否可用</p>
	* @param deviceId:设备ID(String类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public boolean isAirfanExist(String deviceId) {
		if(null != devicesControlManager) {
			DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
			if(null != deviceInfo) {
				if(deviceInfo.isConnect && Constants.AIRFAN_TYPE_ADDR == deviceInfo.strType) {
					if(null != deviceInfo.devicesControl) {
						airfanControl = (IAirFanControl)deviceInfo.devicesControl;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	* <p>Title: isSensorsExist</p>
	* <p>Description: 此传感器是否可用</p>
	* @param deviceId:设备ID(String类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public boolean isSensorsExist(String deviceId) {
		if(null != devicesControlManager) {
			DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
			if(null != deviceInfo) {
				if(deviceInfo.isConnect && Constants.SENSORS_TYPE_ADDR == deviceInfo.strType) {
					if(null != deviceInfo.devicesControl) {
						sensorsControl = (ISensorsFourInOneControl)deviceInfo.devicesControl;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	* <p>Title: isSmartcurtainExist</p>
	* <p>Description: 此窗帘是否可用</p>
	* @param deviceId:设备ID(String类型)
	* @return 成功或失败(boolean类型)
	*/
	public boolean isSmartcurtainExist(String deviceId) {
		if(null != devicesControlManager) {
			DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
			if(null != deviceInfo) {
				if(deviceInfo.isConnect && Constants.SMARTCURTAIN_TYPE_ADDR == deviceInfo.strType) {
					if(null != deviceInfo.devicesControl) {
						smartcurtainControl = (ISmartCurtainControl)deviceInfo.devicesControl;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	* <p>Title: isSmartlightExist</p>
	* <p>Description: 此氛围灯是否可用</p>
	* @param deviceId:设备ID(String类型)
	* @return 成功或失败(boolean类型)
	*/
	public boolean isSmartlightExist(String deviceId) {
		if(null != devicesControlManager) {
			DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
			if(null != deviceInfo) {
				if(deviceInfo.isConnect && Constants.SMARTLIGHT_TYPE_ADDR == deviceInfo.strType) {
					if(null != deviceInfo.devicesControl) {
						smartlightControl = (ISmartLightControl)deviceInfo.devicesControl;
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	* <p>Title: isVoltameterExist</p>
	* <p>Description: 此电量计是否可用</p>
	* @param deviceId:设备ID(String类型)
	* @return 成功或失败(boolean类型)
	*/
	public boolean isVoltameterExist(String deviceId) {
		if(null != devicesControlManager) {
			DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
			if(null != deviceInfo) {
				if(deviceInfo.isConnect && Constants.VOLTAMETER_TYPE_ADDR == deviceInfo.strType) {
					if(null != deviceInfo.devicesControl) {
						voltameterControl = (IVoltameterControl)deviceInfo.devicesControl;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	* <p>Title: isWifiModuleExist</p>
	* <p>Description: 此wifi模组是否可用</p>
	* @param deviceId:设备ID(String类型)
	* @return 成功或失败(boolean类型)
	*/
//	@Override
//	public boolean isWifiModuleExist(String deviceId) {
//		if(null != devicesControlManager) {
//			DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
//			if(null != deviceInfo) {
//				if(deviceInfo.isConnect) {
//					if(null != deviceInfo.wifiControl) {
//						wifiControl = deviceInfo.wifiControl;
//						return true;
//					}
//				}
//			}
//		}
//		return false;
//	}
	
	private IDevicesControl getDeviceControl(String deviceId) {
		if(null != devicesControlManager) {
			DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
			if(null != deviceInfo) {
				if(deviceInfo.isConnect) {
					if(null != deviceInfo.devicesControl) {
						return deviceInfo.devicesControl;
					}
				}
			}
		}
		return null;
	}
	
//	private IWifiControl getWifiControl(String deviceId) {
//		if(null != devicesControlManager) {
//			DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
//			if(null != deviceInfo) {
//				if(deviceInfo.isConnect) {
//					if(null != deviceInfo.wifiControl) {
//						return deviceInfo.wifiControl;
//					}
//				}
//			}
//		}
//		return null;
//	}
	
	
	/**
	 * 通用开、关机
	 * @param power [0/1]
	 * @param soundSet [0/1]
	 * @return 成功或失败
	 */
	@Override
	public byte[] setDevicePowerCommon(String deviceId, int power, int soundSet) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			byte[] message = devicesControl.setPowerCommon(power, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}
	
	/**
	 * 查询设备所有状态
	 * @param soundSet [0/1]
	 * @return
	 */
	@Override
	public byte[] setQueryDeviceAllStatus(String deviceId, int soundSet) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			byte[] message = devicesControl.setQueryDeviceAllStatus(soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}
	
	/**
	 * 获取所有状态的json字符串
	 * @return String
	 */
	@Override
	public String getDeviceAllStatusString(String deviceId) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			return devicesControl.getDeviceAllStatusString();
		}
		return "";
	}
	
	/**
	 * 获取所有状态的json对象
	 * @return JSONObject
	 */
	@Override
	public JSONObject getDeviceAllStatusJSONObject(String deviceId) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			return devicesControl.getDeviceAllStatusJSONObject();
		}
		return null;
	}

	/**
	 * 设置 状态刷新 间隔时间 单位 秒
	 * @param seconds 时间间隔秒数
	 * @return 设置成功与否
	 */
	@Override
	public boolean setIntervalTimeOfStatusRefresh(String deviceId, long seconds) {
		DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
		if(null != deviceInfo) {
			if(null != deviceInfo.devicesControl) {
				return deviceInfo.devicesControl.setIntervalTimeOfStatusRefresh(seconds);
			}
		}
		return false;
	}
	 
	/**
	 * 查询 状态刷新 是否超时
	 * 
	 * @return true 超时，false不超时
	 */
	@Override
	public boolean getIntervalTimeOfStatusRefreshIsOverTime(String deviceId) {
		DeviceInfo deviceInfo = devicesControlManager.getDeviceInfo(deviceId);
		if(null != deviceInfo) {
			if(null != deviceInfo.devicesControl) {
				return deviceInfo.devicesControl.getIntervalTimeOfStatusRefreshIsOverTime();
			}
		}
		return false;
	}
	
	/**
	 * 查询设备所有状态
	 * @param soundSet [0/1]
	 * @return byte[]
	 */
	@Override
	public byte[] setQueryDeviceAllFunctions(String deviceId, int soundSet) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			byte[] message = devicesControl.setQueryDeviceAllFunctions(soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}
	
	/**
	 * 保存设备所有功能
	 * @param deviceFunctions 设备功能
	 * @return boolean
	 */
	@Override
	public boolean setSaveDeviceAllFunctions(String deviceId, JSONObject deviceFunctions) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			return devicesControl.setSaveDeviceAllFunctions(deviceFunctions);
		}
		return false;
	}
	
	/**
	 * 获取 设备所有功能 String
	 * @return String
	 */
	@Override
	public String getDeviceAllFunctionsString(String deviceId) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			return devicesControl.getDeviceAllFunctionsString();
		}
		return "";
	}
	
	/**
	 * 获取 设备所有功能 JSONObject
	 * @return JSONObject
	 */
	@Override
	public JSONObject getDeviceAllFunctionsJSONObject(String deviceId) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			return devicesControl.getDeviceAllFunctionsJSONObject();
		}
		return null;
	}
	
	/**
	 * 设备状态 保存
	 * @param key 键
	 * @param value 值
	 * @return boolean
	 */
	@Override
	public boolean setDeviceStatusSave(String deviceId, String key, Object value) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			return devicesControl.setStatusSave(key, value);
		}
		return false;
	}
	
	/**
	 * 获取状态 String类型
	 * @param key 键
	 * @return String
	 */
	@Override
	public String getDeviceStatusString(String deviceId, String key) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			return devicesControl.getStatusString(key);
		}
		return "";
	}
	
	/**
	 * 获取状态 Int类型
	 * @param key 键
	 * @return int
	 */
	@Override
	public int getDeviceStatusInt(String deviceId, String key) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			return devicesControl.getStatusInt(key);
		}
		return -1;
	}
	
	/**
	 * 设备功能 保存
	 * @param key 键
	 * @param value 值
	 * @return boolean
	 */
	@Override
	public boolean setDeviceFunction(String deviceId, String key, Object value) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			return devicesControl.setDeviceFunction(key, value);
		}
		return false;
	}

	/**
	 * 获取功能 Int类型
	 * @param key 键
	 * @return int
	 */
	@Override
	public int getDeviceFunction(String deviceId, String key) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			return devicesControl.getDeviceFunction(key);
		}
		return -1;
	}
	
	/**
	 * 设备功能使能 保存
	 * @param key 键
	 * @param value 值
	 * @return
	 */
	@Override
	public boolean setDeviceFunctionEnable(String deviceId, String key, Object value) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			return devicesControl.setFunctionEnable(key, value);
		}
		return false;
	}
	
	/**
	 * 获取功能 Int类型
	 * @param key 键
	 * @return int
	 */
	@Override
	public int getDeviceFunctionEnable(String deviceId, String key) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			return devicesControl.getFunctionEnable(key);
		}
		return -1;
	}
	
	/**
	 * 获取控制类版本号
	 * @return String
	 */
	@Override
	public String getVersionNumberOfDevicesControl(String deviceId) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			return devicesControl.getVersionNumberOfDevicesControl();
		}
		return "";
	}
	
	/**
	 * 获取so库版本号
	 * @return String
	 */
	@Override
	public String getVersionNumberOfSoLibrary(String deviceId) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			return devicesControl.getVersionNumberOfSoLibrary();
		}
		return "";
	}
	
	/**
	 * 获取4004版本号
	 * @return String
	 */
	@Override
	public String getVersionNumberOf4004(String deviceId) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			return devicesControl.getVersionNumberOf4004();
		}
		return "";
	}
	
	/**
	* <p>Title: setInitDeviceFunctions</p>
	* <p>Description: 设置家电功能表</p>
	* @param deviceId:设备ID
	* @param functionsValueString: 功能值字符串
	*/
	@Override
	public void setInitDeviceFunctions(String deviceId, String functionsValueString) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			devicesControl.setInitDeviceFunctions(functionsValueString);
		}
	}
	
	/**
	 * 解析方法 收到的byte[] 转化成字符串
	 * @param recv 返回的byte[]
	 * @return String
	 */
	@Override
	public String parseByteToJSON(String deviceId, byte[] recv) {
		IDevicesControl devicesControl = getDeviceControl(deviceId);
		if(null != devicesControl) {
			return devicesControl.parseByteToJSON(recv);
		}
		return "";
	}


	/*********************************** 空调 *******************************************/
	/**
	* <p>Title: setAircondition</p>
	* <p>Description: smartbox设置空调的接口</p>
	* @param deviceId:设备ID(String类型)
	* @param power:开关机状态(int类型)
	* @param mode:运行模式(String类型)
	* @param windSpeed:风速(String类型)
	* @param temperature:温度(int类型)
	* @param upDownAirDoorControl:风门控制位(int类型)
	* @param airDoorPosition:风向(String类型)
	* @param isMute:静音开关(int类型)
	* @param isHighEfficient:快速冷热(int类型)
	* @param isBackgroundLight:LED显示(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAircondition(String deviceId, int power, String mode, String windSpeed, int temperature, int upDownAirDoorControl, String airDoorPosition, int isMute, int isHighEfficient, int isBackgroundLight, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setBoxAirConditioner(power, mode, windSpeed, temperature,upDownAirDoorControl, airDoorPosition, isMute, isHighEfficient, isBackgroundLight, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionSmartStatus</p>
	* <p>Description: 获取空调的受控状态</p>
	* @param deviceId:设备ID(String类型)
	* @param smartStatus:受控状态(String类型)	
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionSmartStatus(String deviceId, String smartStatus) {
		// TODO Auto-generated method stub
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionPower</p>
	* <p>Description: 设置空调开关机</p>
	* @param deviceId:设备ID(String类型)
	* @param power:开关机(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionPower(String deviceId, int power, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setPower(power, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionMode</p>
	* <p>Description: 设置空调模式 </p>
	* @param deviceId:设备ID(String类型)
	* @param mode:模式(String类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionMode(String deviceId, String mode, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setMode(mode, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionTemperature</p>
	* <p>Description: 设置空调温度</p>
	* @param deviceId:设备ID(String类型)
	* @param temperature:温度(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionTemperature(String deviceId, int temperature, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setTemperature(temperature, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionWindSpeed</p>
	* <p>Description: 设置空调风速</p>
	* @param deviceId:设备ID(String类型)
	* @param windSpeed:风速(String类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionWindSpeed(String deviceId, String windSpeed, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setWindSpeed(windSpeed, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionHorizontalWind</p>
	* <p>Description: 设置空调左右风门</p>
	* @param deviceId:设备ID(String类型)
	* @param horizontalWindControl:使能(int类型)
	* @param leftWindSwing:左风门(int类型)
	* @param rightWindSwing:右风门(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionHorizontalWind(String deviceId, int horizontalWindControl, int leftWindSwing, int rightWindSwing, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setHorizontalWind(horizontalWindControl, leftWindSwing, rightWindSwing, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionVerticalWind</p>
	* <p>Description: 设置空调上下风门</p>
	* @param deviceId:设备ID(String类型)
	* @param airDoorPosition:风门方向(String类型)
	* @param airDoorControl:风门控制(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionVerticalWind(String deviceId, String airDoorPosition, int airDoorControl, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setVerticalWind(airDoorPosition, airDoorControl, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionTiming</p>
	* <p>Description: 设置空调定时</p>
	* @param deviceId:设备ID(String类型)
	* @param timingValid:时间实际值(int类型)
	* @param timingValue:时间设置值(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionTiming(String deviceId, int timingValid, int timingValue, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setTiming(timingValid, timingValue, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionSleepMode</p>
	* <p>Description: 设置空调睡眠模式</p>
	* @param deviceId:设备ID(String类型)
	* @param sleepMode:睡眠模式(String类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionSleepMode(String deviceId, String sleepMode, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setSleepMode(sleepMode, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionEnergySaving</p>
	* <p>Description: 设置空调节能</p>
	* @param deviceId:设备ID(String类型)
	* @param energySaving:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionEnergySaving(String deviceId, int energySaving, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setEnergySaving(energySaving, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionBackgroundLight</p>
	* <p>Description: 设置空调背光灯</p>
	* @param deviceId:设备ID(String类型)
	* @param light:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionBackgroundLight(String deviceId, int light, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setBackgroundLight(light, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionScreenLight</p>
	* <p>Description: 设置空调显示屏</p>
	* @param deviceId:设备ID(String类型)
	* @param light:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionScreenLight(String deviceId, int light, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setScreenLight(light, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionLEDLight</p>
	* <p>Description: 设置空调LED显示</p>
	* @param deviceId:设备ID(String类型)
	* @param light:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionLEDLight(String deviceId, int light, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setLEDLight(light, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionElectricalHeating</p>
	* <p>Description: 设置空调电热</p>
	* @param deviceId:设备ID(String类型)
	* @param electricalHeating:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionElectricalHeating(String deviceId, int electricalHeating, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setElectricalHeating(electricalHeating, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionEfficient</p>
	* <p>Description: 设置空调快速冷热 </p>
	* @param deviceId:设备ID(String类型)
	* @param fastCooling:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionEfficient(String deviceId, int fastCooling, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setEfficient(fastCooling, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionTemperatureExportSales</p>
	* <p>Description: 设置空调温度(外销机专用，华氏度)</p>
	* @param deviceId:设备ID(String类型)
	* @param temperature:温度(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionTemperatureExportSales(String deviceId, int temperature, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setTemperatureExportSales(temperature, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionRealTimePowerOn</p>
	* <p>Description: 设置空调定时开机时间(实时)</p>
	* @param deviceId:设备ID(String类型)
	* @param power:开关机(int类型)
	* @param minuteValue:分钟值(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionRealTimePowerOn(String deviceId, int power, int minuteValue, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setRealTimePowerOn(power, minuteValue, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionRealTimePowerOff</p>
	* <p>Description: 设置空调定关开机时间(实时)</p>
	* @param deviceId:设备ID(String类型)
	* @param power:开关机(int类型)
	* @param minuteValue:分钟值(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionRealTimePowerOff(String deviceId, int power, int minuteValue, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setRealTimePowerOff(power, minuteValue, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionEfficientExportSales</p>
	* <p>Description: 设置空调快速冷热(外销机专用)</p>
	* @param deviceId:设备ID(String类型)
	* @param fastCooling:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionEfficientExportSales(String deviceId, int fastCooling, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setEfficientExportSales(fastCooling, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionMuteMode</p>
	* <p>Description: 设置空调静音模式</p>
	* @param deviceId:设备ID(String类型)
	* @param isMuteModeOn:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionMuteMode(String deviceId, int isMuteModeOn, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setMuteMode(isMuteModeOn, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionWindDirection</p>
	* <p>Description: 设置空调风向开关</p>
	* @param deviceId:设备ID(String类型)
	* @param isWindDirectionOn:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionWindDirection(String deviceId, int isWindDirectionOn, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setWindDirection(isWindDirectionOn, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionHumidity</p>
	* <p>Description: 设置空调湿度</p>
	* @param deviceId:设备ID(String类型)
	* @param humidity:湿度值(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionHumidity(String deviceId, int humidity, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setHumidity(humidity, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionFahrenheitOrCelsiusSwitch</p>
	* <p>Description: 设置空调华氏/摄氏显示取值</p>
	* @param deviceId:设备ID(String类型)
	* @param isSwitch:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionFahrenheitOrCelsiusSwitch(String deviceId, int isSwitch, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setFahrenheitOrCelsiusSwitch(isSwitch, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionAndPowerSavingMode</p>
	* <p>Description: 设置空调节能模式</p>
	* @param deviceId:设备ID(String类型)
	* @param isAndPowerSavingMode:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionAndPowerSavingMode(String deviceId, int isAndPowerSavingMode, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setAndPowerSavingMode(isAndPowerSavingMode, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionDualMode</p>
	* <p>Description: 设置空调双模</p>
	* @param deviceId:设备ID(String类型)
	* @param isDualMode:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionDualMode(String deviceId, int isDualMode, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setDualMode(isDualMode, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionIndoorClean</p>
	* <p>Description: 设置空调室内清洁</p>
	* @param deviceId:设备ID(String类型)
	* @param isIndoorClean:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionIndoorClean(String deviceId, int isIndoorClean, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setIndoorClean(isIndoorClean, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionOutdoorClean</p>
	* <p>Description: 设置空调室外清洁</p>
	* @param deviceId:设备ID(String类型)
	* @param isOutdoorClean:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionOutdoorClean(String deviceId, int isOutdoorClean, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setOutdoorClean(isOutdoorClean, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionCleanSmoke</p>
	* <p>Description: 设置空调除烟</p>
	* @param deviceId:设备ID(String类型)
	* @param isCleanSmoke:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionCleanSmoke(String deviceId, int isCleanSmoke, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setCleanSmoke(isCleanSmoke, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionBrightness</p>
	* <p>Description: 设置空调显示屏亮度</p>
	* @param deviceId:设备ID(String类型)
	* @param brightness:亮度值(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionBrightness(String deviceId, int brightness, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setBrightness(brightness, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionDehumidifyMode</p>
	* <p>Description: 设置空调除湿模式</p>
	* @param deviceId:设备ID(String类型)
	* @param isDehumidifyMode:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionDehumidifyMode(String deviceId, String isDehumidifyMode, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setDehumidifyMode(isDehumidifyMode, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionNaturalWind</p>
	* <p>Description: 设置空调自然风</p>
	* @param deviceId:设备ID(String类型)
	* @param isNaturalWind:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionNaturalWind(String deviceId, int isNaturalWind, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setNaturalWind(isNaturalWind, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionFreshAir</p>
	* <p>Description: 设置空调换风</p>
	* @param deviceId:设备ID(String类型)
	* @param isFreshAir:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionFreshAir(String deviceId, int isFreshAir, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setFreshAir(isFreshAir, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionIndoorOrOutdoorTemperatureDisplaySwitch</p>
	* <p>Description: 设置空调室内外温度显示切换</p>
	* @param deviceId:设备ID(String类型)
	* @param isSwitch:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionIndoorOrOutdoorTemperatureDisplaySwitch(String deviceId, int isSwitch, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setIndoorOrOutdoorTemperatureDisplaySwitch(isSwitch, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionAirExchange</p>
	* <p>Description: 设置空调空气交换 </p>
	* @param deviceId:设备ID(String类型)
	* @param isAirExchange:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionAirExchange(String deviceId, int isAirExchange, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setAirExchange(isAirExchange, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionSmartEye</p>
	* <p>Description: 设置空调智慧眼</p>
	* @param deviceId:设备ID(String类型)
	* @param isSmartEye:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionSmartEye(String deviceId, int isSmartEye, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setSmartEye(isSmartEye, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionIndoorFilterCleanReset</p>
	* <p>Description: 设置空调室内机滤网清洁复位</p>
	* @param deviceId:设备ID(String类型)
	* @param isReset:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionIndoorFilterCleanReset(String deviceId, int isReset, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setIndoorFilterCleanReset(isReset, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirconditionVoice</p>
	* <p>Description: 设置空调声音</p>
	* @param deviceId:设备ID(String类型)
	* @param isVoice:使能(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirconditionVoice(String deviceId, int isVoice, int soundSet) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			byte[] message = airconControl.setVoice(isVoice, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: getAirconditionOnlineStatus</p>
	* <p>Description: 获取空调在线状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public boolean getAirconditionOnlineStatus(String deviceId) {
		return isAirconditionExist(deviceId);
	}

	/**
	* <p>Title: getAirconditionSmartStatus</p>
	* <p>Description: 获取空调的受控状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 设备的可控状态(String类型)
	*/
	@Override
	public String getAirconditionSmartStatus(String deviceId) {
		return "controllable";
	}

	/**
	* <p>Title: getAirconditionSequence</p>
	* <p>Description: 获取空调帧内序号</p>
	* @param deviceId:设备ID(String类型)
	* @return 数值(int类型)
	*/
	@Override
	public int getAirconditionSequence(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getSequence();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionResult</p>
	* <p>Description: 获取空调操作结果</p>
	* @param deviceId:设备ID(String类型)
	* @return 结果(String类型)
	*/
	@Override
	public String getAirconditionResult(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getResult();
		}
		return "";
	}

	/**
	* <p>Title: getAirconditionWindSpeed</p>
	* <p>Description: 设置空调风速</p>
	* @param deviceId:设备ID(String类型)
	* @return 风速(String类型)
	*/
	@Override
	public String getAirconditionWindSpeed(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getWindSpeed();
		}
		return "";
	}

	/**
	* <p>Title: getAirconditionMode</p>
	* <p>Description: 设置空调模式</p>
	* @param deviceId:设备ID(String类型)
	* @return 模式(String类型)
	*/
	@Override
	public String getAirconditionMode(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getMode();
		}
		return "";
	}

	/**
	* <p>Title: getAirconditionSleepMode</p>
	* <p>Description: 设置空调睡眠模式</p>
	* @param deviceId:设备ID(String类型)
	* @return 睡眠模式(String类型)
	*/
	@Override
	public String getAirconditionSleepMode(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getSleepMode();
		}
		return "";
	}

	/**
	* <p>Title: getAirconditionPower</p>
	* <p>Description: 设置空调开关机</p>
	* @param deviceId:设备ID(String类型)
	* @return 开关机状态(int类型)
	*/
	@Override
	public int getAirconditionPower(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPower();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionSetPowerOnDuration</p>
	* <p>Description: 获取空调设置开机后的持续时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 时间(int类型)
	*/
	@Override
	public long getAirconditionSetPowerOnDuration(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getSetPowerOnDuration();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionSetPowerOffDuration</p>
	* <p>Description: 获取空调设置关机后的持续时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 时间(int类型)
	*/
	@Override
	public long getAirconditionSetPowerOffDuration(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getSetPowerOffDuration();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionSetModeDuration</p>
	* <p>Description: 获取空调设置模式后的持续时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 时间(int类型)
	*/
	@Override
	public long getAirconditionSetModeDuration(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getSetModeDuration();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionSetHighEfficientDuration</p>
	* <p>Description: 获取空调设置快速冷热后的持续时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 时间(int类型)
	*/
	@Override
	public long getAirconditionSetHighEfficientDuration(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getSetHighEfficientDuration();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionSetTemperature</p>
	* <p>Description: 获取空调设置的温度</p>
	* @param deviceId:设备ID(String类型)
	* @return 温度(int类型)
	*/
	@Override
	public int getAirconditionSetTemperature(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getSetTemperature();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionTemperatureIndoor</p>
	* <p>Description: 获取空调室内温度</p>
	* @param deviceId:设备ID(String类型)
	* @return 温度(int类型)
	*/
	@Override
	public int getAirconditionTemperatureIndoor(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getTemperatureIndoor();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionTemperatureOutdoor</p>
	* <p>Description: 获取空调室外温度</p>
	* @param deviceId:设备ID(String类型)
	* @return 温度(int类型)
	*/
	@Override
	public int getAirconditionTemperatureOutdoor(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getTemperatureOutdoor();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionMute</p>
	* <p>Description: 获取空调静音</p>
	* @param deviceId:设备ID(String类型)
	* @return 静音状态(int类型)
	*/
	@Override
	public int getAirconditionMute(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getMute();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionHighEfficient</p>
	* <p>Description: 获取空调快速冷热</p>
	* @param deviceId:设备ID(String类型)
	* @return 快速冷热状态(int类型)
	*/
	@Override
	public int getAirconditionHighEfficient(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getHighEfficient();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionAirDoorPosition</p>
	* <p>Description: 获取空调风门位置</p>
	* @param deviceId:设备ID(String类型)
	* @return 风门位置(String类型)
	*/
	@Override
	public String getAirconditionAirDoorPosition(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getAirDoorPosition();
		}
		return "";
	}

	/**
	* <p>Title: getAirconditionWindDirection</p>
	* <p>Description: 获取空调风向</p>
	* @param deviceId:设备ID(String类型)
	* @return 风向(int类型)
	*/
	@Override
	public int getAirconditionWindDirection(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getWindDirection();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionHumidity</p>
	* <p>Description: 获取空调湿度</p>
	* @param deviceId:设备ID(String类型)
	* @return 湿度(int类型)
	*/
	@Override
	public int getAirconditionHumidity(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getHumidity();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionSomatosensoryRealityTemperature</p>
	* <p>Description: 获取空调体感室内温度</p>
	* @param deviceId:设备ID(String类型)
	* @return 温度(int类型)
	*/
	@Override
	public int getAirconditionSomatosensoryRealityTemperature(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getSomatosensoryRealityTemperature();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorRealityTemperature</p>
	* <p>Description: 获取空调室内实际温度</p>
	* @param deviceId:设备ID(String类型)
	* @return 温度(int类型)
	*/
	@Override
	public int getAirconditionIndoorRealityTemperature(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorRealityTemperature();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorPipeTemperature</p>
	* <p>Description: 获取空调室内管温</p>
	* @param deviceId:设备ID(String类型)
	* @return 温度(int类型)
	*/
	@Override
	public int getAirconditionIndoorPipeTemperature(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorPipeTemperature();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorRealityHumidity</p>
	* <p>Description: 获取空调实际湿度</p>
	* @param deviceId:设备ID(String类型)
	* @return 湿度(int类型)
	*/
	@Override
	public int getAirconditionIndoorRealityHumidity(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorRealityHumidity();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionSomatosensoryCompensation</p>
	* <p>Description: 获取空调体感室内温度补偿</p>
	* @param deviceId:设备ID(String类型)
	* @return 温度补偿(int类型)
	*/
	@Override
	public int getAirconditionSomatosensoryCompensation(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getSomatosensoryCompensation();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionSomatosensoryContrl</p>
	* <p>Description: 获取空调体感控制状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 控制状态(int类型)
	*/
	@Override
	public int getAirconditionSomatosensoryContrl(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getSomatosensoryContrl();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionTemperatureCompensation</p>
	* <p>Description: 获取空调温度补偿</p>
	* @param deviceId:设备ID(String类型)
	* @return 温度补偿(int类型)
	*/
	@Override
	public int getAirconditionTemperatureCompensation(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getTemperatureCompensation();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionTemperatureValueSwitch</p>
	* <p>Description: 获取空调温度值切换</p>
	* @param deviceId:设备ID(String类型)
	* @return 温度值切换(int类型)
	*/
	@Override
	public int getAirconditionTemperatureValueSwitch(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getTemperatureValueSwitch();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionGeneralTimingShutdownValue</p>
	* <p>Description: 获取空调普通定时关机时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 时间(int类型)
	*/
	@Override
	public int getAirconditionGeneralTimingShutdownValue(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getGeneralTimingShutdownValue();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionRealityHour</p>
	* <p>Description: 获取空调实际时间小时数</p>
	* @param deviceId:设备ID(String类型)
	* @return 小时数(int类型)
	*/
	@Override
	public int getAirconditionRealityHour(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getRealityHour();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionRealityMinute</p>
	* <p>Description: 获取空调实际时间分钟数</p>
	* @param deviceId:设备ID(String类型)
	* @return 分钟数(int类型)
	*/
	@Override
	public int getAirconditionRealityMinute(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getRealityBootMinute();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionRealityBootContrl</p>
	* <p>Description: 获取空调实时开机状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 开机状态(int类型)
	*/
	@Override
	public int getAirconditionRealityBootContrl(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getRealityBootContrl();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionRealityBootHour</p>
	* <p>Description: 获取空调实时开机小时数</p>
	* @param deviceId:设备ID(String类型)
	* @return 小时数(int类型)
	*/
	@Override
	public int getAirconditionRealityBootHour(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getRealityBootHour();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionRealityBootMinute</p>
	* <p>Description: 获取空调实时开机分钟数</p>
	* @param deviceId:设备ID(String类型)
	* @return 分钟数(int类型)
	*/
	@Override
	public int getAirconditionRealityBootMinute(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getRealityBootMinute();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionRealityShutdownContrl</p>
	* <p>Description: 获取空调实时关机状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 关机状态(int类型)
	*/
	@Override
	public int getAirconditionRealityShutdownContrl(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getRealityShutdownContrl();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionRealityShutdownHour</p>
	* <p>Description: 获取空调实时关机小时数</p>
	* @param deviceId:设备ID(String类型)
	* @return 小时数(int类型)
	*/
	@Override
	public int getAirconditionRealityShutdownHour(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getRealityShutdownHour();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionRealityShutdownMinute</p>
	* <p>Description: 获取空调实时关机分钟数</p>
	* @param deviceId:设备ID(String类型)
	* @return 分钟数(int类型)
	*/
	@Override
	public int getAirconditionRealityShutdownMinute(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getRealityShutdownMinute();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionDehumidificationMode</p>
	* <p>Description: 获取空调除湿模式</p>
	* @param deviceId:设备ID(String类型)
	* @return 模式(String类型)
	*/
	@Override
	public String getAirconditionDehumidificationMode(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getDehumidificationMode();
		}
		return "";
	}

	/**
	* <p>Title: getAirconditionVerticalWindMode</p>
	* <p>Description: 获取空调上下风模式</p>
	* @param deviceId:设备ID(String类型)
	* @return 模式(String类型)
	*/
	@Override
	public String getAirconditionVerticalWindMode(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getVerticalWindMode();
		}
		return "";
	}

	/**
	* <p>Title: getAirconditionVerticalWindContrl</p>
	* <p>Description: 获取空调上下风状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionVerticalWindContrl(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getVerticalWindContrl();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionHorizontalWindContrl</p>
	* <p>Description: 获取空调左右风状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionHorizontalWindContrl(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getHorizontalWindContrl();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionNatureWindContrl</p>
	* <p>Description: 获取空调自然风状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionNatureWindContrl(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getNatureWindContrl();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionElectricalHeating</p>
	* <p>Description: 获取空调电热状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionElectricalHeating(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getElectricalHeating();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionEnergyConservation</p>
	* <p>Description: 获取空调节能状态 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionEnergyConservation(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getEnergyConservation();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionShare</p>
	* <p>Description: 获取空调并用节电状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionShare(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getShare();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionDualMode</p>
	* <p>Description: 获取空调双模状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionDualMode(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getDualMode();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionFreshness</p>
	* <p>Description: 获取空调清新状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionFreshness(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getFreshness();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionFreshAir</p>
	* <p>Description: 获取空调换风状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionFreshAir(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getFreshAir();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCleanIndoor</p>
	* <p>Description: 获取空调室内清洁状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionCleanIndoor(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getCleanIndoor();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCleanOutdoor</p>
	* <p>Description: 获取空调室外清洁状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionCleanOutdoor(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getCleanOutdoor();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionSmartEye</p>
	* <p>Description: 获取空调智慧眼状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionSmartEye(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getSmartEye();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionVoice</p>
	* <p>Description: 获取空调声音状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionVoice(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getVoice();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCleanSmoke</p>
	* <p>Description: 获取空调除烟状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionCleanSmoke(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getCleanSmoke();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionBackgroundLamp</p>
	* <p>Description: 获取空调背光灯状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionBackgroundLamp(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getBackgroundLamp();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionScreen</p>
	* <p>Description: 获取空调显示屏状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionScreen(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getScreen();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionLED</p>
	* <p>Description: 获取空调LED灯状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionLED(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getLED();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorOutdoorSwitch</p>
	* <p>Description: 获取空调室内外温度显示切换状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionIndoorOutdoorSwitch(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorOutdoorSwitch();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorFilterClear</p>
	* <p>Description: 获取空调室内机滤网清洁状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionIndoorFilterClear(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorFilterClear();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionLeftWind</p>
	* <p>Description: 获取空调左风门状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getAirconditionLeftWind(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getLeftWind();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionRightWind</p>
	* <p>Description: 获取空调右风门状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionRightWind(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getRightWind();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionChargeBorad</p>
	* <p>Description: 获取空调室内电量板状态 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionChargeBorad(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getChargeBorad();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionHaveIRContrl</p>
	* <p>Description: 获取空调本次命令之前是否有过红外遥控与按键控制过</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionHaveIRContrl(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getHaveIRContrl();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionHaveWIFIContrl</p>
	* <p>Description: 获取空调本次命令之前是否有过WIFI控制过</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionHaveWIFIContrl(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getHaveWIFIContrl();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionEEPROMUpdate</p>
	* <p>Description: 获取空调室内EEPROM在线升级状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionEEPROMUpdate(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getEEPROMUpdate();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorTemperatureSensorTrouble</p>
	* <p>Description: 获取空调室内温度传感器故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorTemperatureSensorTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorTemperatureSensorTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorPipeTemperatureSensorTrouble</p>
	* <p>Description: 获取空调室内盘管温度传感器故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorPipeTemperatureSensorTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorPipeTemperatureSensorTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorHumiditySensorTrouble</p>
	* <p>Description: 获取空调室内湿度传感器故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorHumiditySensorTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorHumiditySensorTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorDrainsWaterPumpTrouble</p>
	* <p>Description: 获取空调室内排水泵故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorDrainsWaterPumpTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorDrainsWaterPumpTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorFanMotorTrouble</p>
	* <p>Description: 获取空调室内风机电机运转异常故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorFanMotorTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorFanMotorTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPioneerGrillingProtectTrouble</p>
	* <p>Description: 获取空调柜机格栅保护告警</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPioneerGrillingProtectTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPioneerGrillingProtectTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorVoltageZeroCrossDetectionTrouble</p>
	* <p>Description: 获取空调室内电压过零检测故障 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorVoltageZeroCrossDetectionTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorVoltageZeroCrossDetectionTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorOutdoorCommunicationTrouble</p>
	* <p>Description: 获取空调室内外通信故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorOutdoorCommunicationTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorOutdoorCommunicationTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorContrlScreenCommunicationTrouble</p>
	* <p>Description: 获取空调室内控制板与显示板通信故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorContrlScreenCommunicationTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorContrlScreenCommunicationTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorContrlKeypadCommunicationTrouble</p>
	* <p>Description: 获取空调室内控制板与按键板通信故障 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorContrlKeypadCommunicationTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorContrlKeypadCommunicationTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorContrlWIFICommunicationTrouble</p>
	* <p>Description: 获取空调WIFI控制板与室内控制板通信故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorContrlWIFICommunicationTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorContrlWIFICommunicationTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorContrlChargeCommunicationTrouble</p>
	* <p>Description: 获取空调室内控制板与室内电量板通信故障 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorContrlChargeCommunicationTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorContrlChargeCommunicationTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorContrlEEPROMTrouble</p>
	* <p>Description: 获取空调室内控制板EEPROM故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorContrlEEPROMTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorContrlEEPROMTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionRunFrequency</p>
	* <p>Description: 获取空调当前运行频率</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionRunFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getRunFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionTargetFrequency</p>
	* <p>Description: 获取空调目标频率</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionTargetFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getTargetFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionDriveFrequency</p>
	* <p>Description: 获取空调发给驱动器的频率</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionDriveFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getDriveFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionEnvironmentTemperature</p>
	* <p>Description: 获取空调室外环境温度</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionEnvironmentTemperature(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getEnvironmentTemperature();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCondenserTemperature</p>
	* <p>Description: 获取空调冷凝器温度 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionCondenserTemperature(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getCondenserTemperature();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionExhaustTemperature</p>
	* <p>Description: 获取空调排气温度 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionExhaustTemperature(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getExhaustTemperature();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionTargetExhaustTemperature</p>
	* <p>Description: 获取空调目标排气温度</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionTargetExhaustTemperature(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getTargetExhaustTemperature();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorElectronicExpansion</p>
	* <p>Description: 获取空调室外电子膨胀阀开度</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorElectronicExpansion(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorElectronicExpansion();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionUABH</p>
	* <p>Description: 获取空调UABH</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionUABH(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getUABH();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionUABL</p>
	* <p>Description: 获取空调UABL</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionUABL(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getUABL();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionUBCH</p>
	* <p>Description: 获取空调UBCH</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionUBCH(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getUBCH();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionUBCL</p>
	* <p>Description: 获取空调UBCL</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionUBCL(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getUBCL();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionUCAH</p>
	* <p>Description: 获取空调UCAH</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionUCAH(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getUCAH();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionUCAL</p>
	* <p>Description: 获取空调UCAL</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionUCAL(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getUCAL();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIAB</p>
	* <p>Description: 获取空调IAB</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIAB(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIAB();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIBC</p>
	* <p>Description: 获取空调IBC</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIBC(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIBC();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionICA</p>
	* <p>Description: 获取空调ICA</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionICA(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getICA();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIUV</p>
	* <p>Description: 获取空调IUV</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIUV(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIUV();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCocurrentBusVoltageH</p>
	* <p>Description: 获取空调直流母线电压H</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionCocurrentBusVoltageH(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getCocurrentBusVoltageH();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCocurrentBusVoltageL</p>
	* <p>Description: 获取空调直流母线电压L</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionCocurrentBusVoltageL(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getCocurrentBusVoltageL();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionFourWayLimen</p>
	* <p>Description: 获取空调四通阀状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionFourWayLimen(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getFourWayLimen();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorRealityRuning</p>
	* <p>Description: 获取空调室外机实际工作状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorRealityRuning(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorRealityRuning();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionFanRuning</p>
	* <p>Description: 获取空调风机运行状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionFanRuning(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getFanRuning();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorForceIndoorWindPosition</p>
	* <p>Description: 获取空调室外机强制室内机风门位置</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorForceIndoorWindPosition(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorForceIndoorWindPosition();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorForceIndoorWindSpeed</p>
	* <p>Description: 获取空调室外机强制室内机风速</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorForceIndoorWindSpeed(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorForceIndoorWindSpeed();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorForceIndoorStop</p>
	* <p>Description: 获取空调室外机强制室内机停</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorForceIndoorStop(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorForceIndoorStop();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionShutdownByTemperatureContrl</p>
	* <p>Description: 获取空调温控关机状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionShutdownByTemperatureContrl(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getShutdownByTemperatureContrl();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOne4All</p>
	* <p>Description: 获取空调一拖多标志</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOne4All(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOne4All();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionDehumidifierLimen</p>
	* <p>Description: 获取空调除湿阀标志</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionDehumidifierLimen(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getDehumidifierLimen();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorDefrosting</p>
	* <p>Description: 获取空调室外机化霜</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorDefrosting(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorDefrosting();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorBypassDefrosting</p>
	* <p>Description: 获取空调室外旁通化霜</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorBypassDefrosting(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorBypassDefrosting();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOilReturn</p>
	* <p>Description: 获取空调回油标志</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOilReturn(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOilReturn();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorTroubleDisplay</p>
	* <p>Description: 获取空调室外故障显示标志</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorTroubleDisplay(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorTroubleDisplay();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorEEPROMDownload</p>
	* <p>Description: 获取空调室外机EEPROM在线下载标志</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorEEPROMDownload(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorEEPROMDownload();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorChargeBoard</p>
	* <p>Description: 获取空调室外机电量板是否有</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorChargeBoard(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorChargeBoard();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCompressorRibbonHeater</p>
	* <p>Description: 获取空调压缩机电热带</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionCompressorRibbonHeater(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getcompressorRibbonHeater();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCompressorBeforeHandheat</p>
	* <p>Description: 获取空调压缩机预加热</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionCompressorBeforeHandheat(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getcompressorBeforeHandheat();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionReinflation</p>
	* <p>Description: 获取空调补气增晗</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionReinflation(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getReinflation();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorModeClash</p>
	* <p>Description: 获取空调室内外机模式冲突</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorModeClash(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorModeClash();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorEEPROMTrouble</p>
	* <p>Description: 获取空调室外EEPROM故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorEEPROMTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorEEPROMTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorPipeTemperatureSensorTrouble</p>
	* <p>Description: 获取空调室外盘管温度传感器故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorPipeTemperatureSensorTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorPipeTemperatureSensorTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorExhausTemperatureSensorTrouble</p>
	* <p>Description: 获取空调排气温度传感器故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorExhausTemperatureSensorTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorExhausTemperatureSensorTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorEnvironmentTemperatureSensorTrouble</p>
	* <p>Description: 获取空调室外环境温度传感器故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorEnvironmentTemperatureSensorTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorEnvironmentTemperatureSensorTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionVoltageTransformerTrouble</p>
	* <p>Description: 获取空调电压变压器故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionVoltageTransformerTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getVoltageTransformerTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCurrentTransformerTrouble</p>
	* <p>Description: 获取空调电流互感器故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionCurrentTransformerTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getCurrentTransformerTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorContrlDriveCommunicationTrouble</p>
	* <p>Description: 获取空调室外控制与驱动通信故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorContrlDriveCommunicationTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorContrlDriveCommunicationTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIPMOvercurrentProtect</p>
	* <p>Description: 获取空调IPM模块过流保护故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIPMOvercurrentProtect(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIPMOvercurrentProtect();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIPMOverheatingProtect</p>
	* <p>Description: 获取空调IPM模块过热保护故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIPMOverheatingProtect(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIPMOverheatingProtect();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionAlternatingCurrentOvervoltageProtect</p>
	* <p>Description: 获取空调交流电过电压保护故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionAlternatingCurrentOvervoltageProtect(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getAlternatingCurrentOvervoltageProtect();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionAlternatingCurrentUndervoltageProtect</p>
	* <p>Description: 获取空调交流电欠电压保护故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionAlternatingCurrentUndervoltageProtect(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getAlternatingCurrentUndervoltageProtect();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionBusbarVoltageOvervoltageProtect</p>
	* <p>Description: 获取空调母线电压过电压保护故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionBusbarVoltageOvervoltageProtect(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getBusbarVoltageOvervoltageProtect();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionBusbarVoltageUndervoltageProtect</p>
	* <p>Description: 获取空调母线电压欠电压保护故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionBusbarVoltageUndervoltageProtect(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getBusbarVoltageUndervoltageProtect();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPFCOvercurrentProtect</p>
	* <p>Description: 获取空调PFC过电流保护故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPFCOvercurrentProtect(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPFCOvercurrentProtect();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorMaximumCurrentProtect</p>
	* <p>Description: 获取空调室外机最大电流保护故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorMaximumCurrentProtect(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorMaximumCurrentProtect();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorEnvironmentOvertemperatureProtect</p>
	* <p>Description: 获取空调室外环境温度过低保护故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorEnvironmentOvertemperatureProtect(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdooEnvironmentOvertemperatureProtect();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionExhaustOvertemperatureProtect</p>
	* <p>Description: 获取空调排气温度过高保护故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionExhaustOvertemperatureProtect(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getExhaustOvertemperatureProtect();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCompressoPipeShellTemperatureProtect</p>
	* <p>Description: 获取空调压缩机管壳温度保护故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionCompressoPipeShellTemperatureProtect(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getCompressoPipeShellTemperatureProtect();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorAntiFreezingProtect</p>
	* <p>Description: 获取空调室内防冻结或防过载保护故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorAntiFreezingProtect(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorAntiFreezingProtect();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorPFCProtect</p>
	* <p>Description: 获取空调室外机PFC保护故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorPFCProtect(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorPFCProtect();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCompressoBootFail</p>
	* <p>Description: 获取空调压缩机启动失败故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionCompressoBootFail(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getCompressoBootFail();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCompressoStepOut</p>
	* <p>Description: 获取空调压缩机失步故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionCompressoStepOut(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getCompressoStepOut();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorFanLockRotor</p>
	* <p>Description: 获取空调室外风机堵转故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorFanLockRotor(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorFanLockRotor();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorPieOverloadProtect</p>
	* <p>Description: 获取空调室外盘管防过载保护故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorPieOverloadProtect(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorPieOverloadProtect();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionRefrigerantLeakage</p>
	* <p>Description: 获取空调冷媒泄漏故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionRefrigerantLeakage(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getRefrigerantLeakage();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCompressoModelMismatch</p>
	* <p>Description: 获取空调压缩机型号匹配错误故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionCompressoModelMismatch(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getCompressoModelMismatch();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionSystemLowFrequencyVibrationProtect</p>
	* <p>Description: 获取空调系统低频振动保护故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionSystemLowFrequencyVibrationProtect(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getSystemLowFrequencyVibrationProtect();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorRadiatorOvertemperatureProtect</p>
	* <p>Description: 获取空调室外散热器温度过高保护故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorRadiatorOvertemperatureProtect(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorRadiatorOvertemperatureProtect();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionSystemHypertonusProtect</p>
	* <p>Description: 获取空调系统压力过高保护故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionSystemHypertonusProtect(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getSystemHypertonusProtect();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionInverterCocurrentOvervoltageTrouble</p>
	* <p>Description: 获取空调逆变器直流过电压故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionInverterCocurrentOvervoltageTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getInverterCocurrentOvervoltageTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionInverterCocurrentUndervoltageTrouble</p>
	* <p>Description: 获取空调逆变器直流低电压故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionInverterCocurrentUndervoltageTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getInverterCocurrentUndervoltageTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionInverterCocurrentOvercurrentTrouble</p>
	* <p>Description: 获取空调逆变器交流过电流故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionInverterCocurrentOvercurrentTrouble(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getInverterCocurrentOvercurrentTrouble();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionStepOutDetection</p>
	* <p>Description: 获取空调失步检出故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionStepOutDetection(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getStepOutDetection();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionInverterEdgeFault</p>
	* <p>Description: 获取空调逆变器IPM故障-边沿</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionInverterEdgeFault(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getInverterEdgeFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionInverterLevelFault</p>
	* <p>Description: 获取空调逆变器IPM故障-电平</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionInverterLevelFault(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getInverterLevelFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPFC_IPMEdgeFault</p>
	* <p>Description: 获取空调PFC_IPM故障-边沿</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPFC_IPMEdgeFault(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPFC_IPMEdgeFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPFC_IPMLevelFault</p>
	* <p>Description: 获取空调PFC_IPM故障-电平</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPFC_IPMLevelFault(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPFC_IPMLevelFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPFCPowerCutFault</p>
	* <p>Description: 获取空调PFC停电检出故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPFCPowerCutFault(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPFCPowerCutFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPFCOvercurrentFault</p>
	* <p>Description: 获取空调PFC过电流检出故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPFCOvercurrentFault(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPFCOvercurrentFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionDCVException</p>
	* <p>Description: 获取空调直流电压检出异常</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionDCVException(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getDCVException();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPFCLowVoltageFault</p>
	* <p>Description: 获取空调PFC低电压(有效值)检出故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPFCLowVoltageFault(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPFCLowVoltageFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionADOffsetAnomaliesFault</p>
	* <p>Description: 获取空调AD偏置异常检出故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionADOffsetAnomaliesFault(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getADOffsetAnomaliesFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionInverterPWMLogicFault</p>
	* <p>Description: 获取空调逆变器PWM逻辑设置故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionInverterPWMLogicFault(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getInverterPWMLogicFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionInverterPWMInitFault</p>
	* <p>Description: 获取空调逆变器PWM初始化故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionInverterPWMInitFault(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getInverterPWMInitFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPFCPWMLogicFault</p>
	* <p>Description: 获取空调PFC_PWM逻辑设置故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPFCPWMLogicFault(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPFCPWMLogicFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPFC_PWMInitFault</p>
	* <p>Description: 获取空调PFC_PWM初始化故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPFC_PWMInitFault(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPFC_PWMInitFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionTemperatureAnomaly</p>
	* <p>Description: 获取空调温度异常</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionTemperatureAnomaly(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getTemperatureAnomaly();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionMotorDataFault</p>
	* <p>Description: 获取空调电机参数设置故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionMotorDataFault(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getMotorDataFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionMCEFault</p>
	* <p>Description: 获取空调MCE故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionMCEFault(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getMCEFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionEEPROMFault</p>
	* <p>Description: 获取空调驱动EEPROM故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionEEPROMFault(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getEEPROMFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorCoilOverloadUpFrequency</p>
	* <p>Description:	获取空调室外盘管过载禁升频</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorCoilOverloadUpFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorCoilOverloadUpFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOutdoorCoilOverloadDownFrequency</p>
	* <p>Description: 获取空调室外盘管过载降频</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOutdoorCoilOverloadDownFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOutdoorCoilOverloadDownFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorCoilOverloadUpFrequency</p>
	* <p>Description: 获取空调室内盘管过载禁升频 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorCoilOverloadUpFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorCoilOverloadUpFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorCoilOverloadDownFrequency</p>
	* <p>Description: 获取空调室内盘管过载降频 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorCoilOverloadDownFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorCoilOverloadDownFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPressureUpFrequency</p>
	* <p>Description: 获取空调压降排气过载禁升频</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPressureUpFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPressureUpFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPressureDownFrequency</p>
	* <p>Description: 获取空调压降排气过载降频</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPressureDownFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPressureDownFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorCoilFreezingUpFrequency</p>
	* <p>Description: 获取空调室内盘管冻结禁升频</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorCoilFreezingUpFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorCoilFreezingUpFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorCoilFreezingDownFrequency</p>
	* <p>Description: 获取空调室内盘管冻结降频</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorCoilFreezingDownFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorCoilFreezingDownFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCommunicationDownFrequency</p>
	* <p>Description: 获取空调室内外通信降频</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionCommunicationDownFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getCommunicationDownFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionModuleTemperaturelimitFrequency</p>
	* <p>Description: 获取空调模块温度过载限频</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionModuleTemperaturelimitFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getModuleTemperaturelimitFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionModulationRatelimitFrequency</p>
	* <p>Description: 获取空调变调率限频</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionModulationRatelimitFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getModulationRatelimitFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPhaseCurrentlimitFrequency</p>
	* <p>Description: 获取空调相电流限频</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPhaseCurrentlimitFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPhaseCurrentlimitFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPowerSaveUpFrequency</p>
	* <p>Description: 获取空调并用节电保护禁升频</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPowerSaveUpFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPowerSaveUpFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPowerSaveDownFrequency</p>
	* <p>Description: 获取空调并用节电保护降频</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPowerSaveDownFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPowerSaveDownFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOvercurrentUpFrequency</p>
	* <p>Description: 获取空调过电流保护禁升频</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOvercurrentUpFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOvercurrentUpFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionOvercurrentDownFrequency</p>
	* <p>Description: 获取空调过电流保护降频</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionOvercurrentDownFrequency(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getOvercurrentDownFrequency();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorFanSpeedH</p>
	* <p>Description: 获取空调室内风机转速H</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorFanSpeedH(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorFanSpeedH();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorFanSpeed00L</p>
	* <p>Description: 获取空调室外风机转速L</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorFanSpeed00L(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorFanSpeed00L();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPM25</p>
	* <p>Description: 获取空调有否PM2.5检测功能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPM25(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPM25();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPM25Level</p>
	* <p>Description: 获取空调PM2.5污染程度</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPM25Level(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPM25Level();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPM25Percent</p>
	* <p>Description: 获取空调空气PM2.5质量百分比表示</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPM25Percent(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPM25Percent();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionScreenLuminance</p>
	* <p>Description: 获取空调显示屏亮度值</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionScreenLuminance(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getScreenLuminance();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionGeneralTimingShutdown</p>
	* <p>Description: 获取空调普通定时开关机有效</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionGeneralTimingShutdown(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getGeneralTimingShutdown();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionWindSpeedNumFN</p>
	* <p>Description: 获取空调室内风量支持档位数</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionWindSpeedNumFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getWindSpeedNumFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionSleepModeFN</p>
	* <p>Description: 获取空调设置睡眠模式使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionSleepModeFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getSleepModeFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCoolModeFN</p>
	* <p>Description: 获取空调单冷/冷暖 机型</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionCoolModeFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getCoolModeFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionPowerFN</p>
	* <p>Description: 获取空调开关机使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionPowerFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getPowerFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionWindDirectionFN</p>
	* <p>Description: 获取空调室内单个风向控制功能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionWindDirectionFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getWindDirectionFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionTemperatureFN</p>
	* <p>Description: 获取空调设置温度使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionTemperatureFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getTemperatureFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionHumidityFN</p>
	* <p>Description: 获取空调设置湿度使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionHumidityFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getHumidityFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionSomatosensoryRealityTemperatureFN</p>
	* <p>Description: 获取空调体感控制,体感室内温度,体感室内温度补偿使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionSomatosensoryRealityTemperatureFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getSomatosensoryRealityTemperatureFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionTemperatureCompensationFN</p>
	* <p>Description: 获取空调自动工作模式和除湿模式的温度补偿使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionTemperatureCompensationFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getTemperatureCompensationFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionTemperatureValueSwitchFN</p>
	* <p>Description: 获取空调华氏/摄氏温度显示设置使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionTemperatureValueSwitchFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getTemperatureValueSwitchFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionGeneralTimingShutdownFN</p>
	* <p>Description: 获取空调普通定时关机,普通定时关机时间使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionGeneralTimingShutdownFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getGeneralTimingShutdownFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionRealityTimeFN</p>
	* <p>Description: 获取空调实时开机控制使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionRealityTimeFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getRealityTimeFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionVerticalWindModeNum</p>
	* <p>Description: 获取空调6位置可定室内风门位置控制使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionVerticalWindModeNum(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getVerticalWindModeNum();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionVerticalWindFN</p>
	* <p>Description: 获取空调上下风门模式,上下风开停控制使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionVerticalWindFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getVerticalWindFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionHorizontalWindFN</p>
	* <p>Description: 获取空调左右风开停控制使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionHorizontalWindFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getHorizontalWindFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionNatureWindFN</p>
	* <p>Description: 获取空调自然风开停使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionNatureWindFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getNatureWindFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionElectricalHeatingFN</p>
	* <p>Description: 获取空调设置电加热使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionElectricalHeatingFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getElectricalHeatingFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionDehumidificationModeFN</p>
	* <p>Description: 获取空调除湿模式使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionDehumidificationModeFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getDehumidificationModeFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionEnergyConservationFN</p>
	* <p>Description: 获取空调设置节能使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionEnergyConservationFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getEnergyConservationFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionShareFN</p>
	* <p>Description: 获取空调设置并用节电使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionShareFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getShareFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionEfficientFN</p>
	* <p>Description: 获取空调快速冷热使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionEfficientFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getEfficientFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionDualModeFN</p>
	* <p>Description: 获取空调设置双模使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionDualModeFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getDualModeFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionFreshnessFN</p>
	* <p>Description: 获取空调设置清新使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionFreshnessFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getFreshnessFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionFreshAirFN</p>
	* <p>Description: 获取空调设置换风使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionFreshAirFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getFreshAirFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCleanIndoorFN</p>
	* <p>Description:	获取空调设置室内清洁使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionCleanIndoorFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getCleanIndoorFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCleanOutdoorFN</p>
	* <p>Description: 获取空调设置室外清洁使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionCleanOutdoorFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getCleanOutdoorFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionSmartEyeFN</p>
	* <p>Description: 获取空调设置室智能眼使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionSmartEyeFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getSmartEyeFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionMuteFN</p>
	* <p>Description: 获取空调设置室静音功能使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionMuteFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getMuteFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionMuteFN</p>
	* <p>Description: 获取空调设置室静音功能使能</p>
	* @param deviceId:设备ID(String类型)
	* @param isFunction:使能(boolean类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionMuteFN(String deviceId, boolean isFunction) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getMuteFN(isFunction);
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionVoiceFN</p>
	* <p>Description: 获取空调设置语音使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionVoiceFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getVoiceFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionCleanSmokeFN</p>
	* <p>Description:	获取空调设置除烟使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionCleanSmokeFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getCleanSmokeFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionBackgroundLampFN</p>
	* <p>Description: 获取空调背景灯使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionBackgroundLampFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getBackgroundLampFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionScreenFN</p>
	* <p>Description: 获取空调显示屏发光使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionScreenFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getScreenFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionLEDFN</p>
	* <p>Description: 获取空调LED指示灯使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionLEDFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getLEDFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorOutdoorSwitchFN</p>
	* <p>Description: 获取空调室内外温度切换显示使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorOutdoorSwitchFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorOutdoorSwitchFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionIndoorFilterClearFN</p>
	* <p>Description: 获取空调室内过滤网清洁复位控制使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionIndoorFilterClearFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getIndoorFilterClearFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionLeftFanContrlFN</p>
	* <p>Description: 获取空调左风摆开停控制使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionLeftFanContrlFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getLeftFanContrlFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionRightFanContrlFN</p>
	* <p>Description: 获取空调右风摆开停控制使能 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionRightFanContrlFN(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getRightFanContrlFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirconditionContrlRate</p>
	* <p>Description: 获取空调控制规则</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirconditionContrlRate(String deviceId) {
		if(isAirconditionExist(deviceId) && null != airconControl) {
			return airconControl.getContrlRate();
		}
		return -1;
	}

	
	/*********************************** 除湿机 *******************************************/
	/**
	* <p>Title: setDehumidifier</p>
	* <p>Description: smartbox设置除湿机</p>
	* @param deviceId:设备ID(String类型)
	* @param power:开关机(String类型)
	* @param mode:模式(String类型)
	* @param windSpeed:风速(String类型)
	* @param humidity:湿度(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setDehumidifier(String deviceId, int power, String mode, String windSpeed, int humidity, int soundSet) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			byte[] message = dehumidifierControl.setBoxAirDehumidifier(power, mode, windSpeed, humidity, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	@Override
	public byte[] setDehumidifierPower(String deviceId, int power, int soundSet) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			byte[] message = dehumidifierControl.setPower(power, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}
	
	/**
	* <p>Title: setDehumidifierSmartStatus</p>
	* <p>Description: 设置除湿机受控状态</p>
	* @param deviceId:设备ID(String类型)
	* @param smartStatus:受控状态(String类型)	
	* @return 成功或失败(boolean类型)
	*/	
	@Override
	public byte[] setDehumidifierSmartStatus(String deviceId, String smartStatus) {
		// TODO Auto-generated method stub
		return errorByte;
	}

	/**
	* <p>Title: setDehumidifierWindSpeed</p>
	* <p>Description: 设置除湿机风速</p>
	* @param deviceId:设备ID(String类型)
	* @param windSpeed:风速(String类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setDehumidifierWindSpeed(String deviceId, String windSpeed, int soundSet) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			byte[] message = dehumidifierControl.setWindSpeed(windSpeed, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setDehumidifierMode</p>
	* <p>Description: 设置除湿机模式</p>
	* @param deviceId:设备ID(String类型)
	* @param mode:模式(String类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setDehumidifierMode(String deviceId, String mode, int soundSet) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			byte[] message = dehumidifierControl.setMode(mode, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setDehumidifierTimingSwitchMachine</p>
	* <p>Description: 设置除湿机普通定时开关机</p>
	* @param deviceId:设备ID(String类型)
	* @param timingEnable:定时使能(int类型)
	* @param timingValue:时间值(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setDehumidifierTimingSwitchMachine(String deviceId, int timingEnable, int timingValue, int soundSet) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			byte[] message = dehumidifierControl.setTimingSwitchMachine(timingEnable, timingValue, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setDehumidifierHumidityValue</p>
	* <p>Description: 设置除湿机湿度</p>
	* @param deviceId:设备ID(String类型)
	* @param humidityValue:湿度值(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setDehumidifierHumidityValue(String deviceId, int humidityValue, int soundSet) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			byte[] message = dehumidifierControl.setHumidityValue(humidityValue, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setDehumidifierTemperature</p>
	* <p>Description: 设置除湿机温度</p>
	* @param deviceId:设备ID(String类型)
	* @param temperature:温度值(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setDehumidifierTemperature(String deviceId, int temperature, int soundSet) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			byte[] message = dehumidifierControl.setTemperature(temperature, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setDehumidifierElectricalHeating</p>
	* <p>Description: 设置除湿机电热</p>
	* @param deviceId:设备ID(String类型)
	* @param electricalHeating:电热开关(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setDehumidifierElectricalHeating(String deviceId, int electricalHeating, int soundSet) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			byte[] message = dehumidifierControl.setElectricalHeating(electricalHeating, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setDehumidifierWaterPumpPower</p>
	* <p>Description: 设置除湿机水离子开关</p>
	* @param deviceId:设备ID(String类型)
	* @param waterPump:水离子开关(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setDehumidifierWaterPumpPower(String deviceId, int waterPump, int soundSet) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			byte[] message = dehumidifierControl.setWaterPumpPower(waterPump, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setDehumidifierAnionPower</p>
	* <p>Description: 设置除湿机负离子开关</p>
	* @param deviceId:设备ID(String类型)
	* @param anionPower:负离子开关(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setDehumidifierAnionPower(String deviceId, int anionPower, int soundSet) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			byte[] message = dehumidifierControl.setAnionPower(anionPower, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: getDehumidifierOnlineStatus</p>
	* <p>Description: 获取除湿机在线状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 是否在线(boolean类型)
	*/
	@Override
	public boolean getDehumidifierOnlineStatus(String deviceId) {
		return isDehumidifierExist(deviceId);
	}

	/**
	* <p>Title: getDehumidifierSmartStatus</p>
	* <p>Description: 获取除湿机受控状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 是否受控(String类型)
	*/
	@Override
	public String getDehumidifierSmartStatus(String deviceId) {
		return "controllable";
	}

	/**
	* <p>Title: getDehumidifierSetPowerOnDuration</p>
	* <p>Description: 获取除湿机设置开机后的持续时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public long getDehumidifierSetPowerOnDuration(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getSetPowerOnDuration();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierSetPowerOffDuration</p>
	* <p>Description: 获取除湿机设置关机后的持续时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public long getDehumidifierSetPowerOffDuration(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getSetPowerOffDuration();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierSetModeDuration</p>
	* <p>Description: 获取除湿机设置模式后的持续时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public long getDehumidifierSetModeDuration(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getSetModeDuration();
		}
		return -1;
	}
	
	/**
	* <p>Title: getDehumidifierSequence</p>
	* <p>Description: 获取除湿机的帧内序号</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)
	*/
	@Override
	public int getDehumidifierSequence(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getSequence();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierResult</p>
	* <p>Description: 获取除湿机的操作结果</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(String类型)  
	*/
	@Override
	public String getDehumidifierResult(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getResult();
		}
		return "";
	}

	/**
	* <p>Title: getDehumidifierWindSpeed</p>
	* <p>Description: 获取除湿机风速</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(String类型)  
	*/
	@Override
	public String getDehumidifierWindSpeed(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getWindSpeed();
		}
		return "";
	}

	/**
	* <p>Title: getDehumidifierMode</p>
	* <p>Description: 获取除湿机模式</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(String类型)  
	*/
	@Override
	public String getDehumidifierMode(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getMode();
		}
		return "";
	}

	/**
	* <p>Title: getDehumidifierPower</p>
	* <p>Description: 获取除湿机开关机状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierPower(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getPower();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierHumidityValueSet</p>
	* <p>Description: 获取除湿机设定湿度</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型) 状态(int类型)  
	*/
	@Override
	public int getDehumidifierHumidityValueSet(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getHumidityValueSet();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierHumidityValueIndoor</p>
	* <p>Description: 获取除湿机当前室内湿度</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierHumidityValueIndoor(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getHumidityValueIndoor();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierTimeValid</p>
	* <p>Description: 获取除湿机定时开关机是否有效</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierTimeValid(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getTimeValid();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierTimerValue</p>
	* <p>Description: 获取除湿机定时开关机时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(String类型)  
	*/
	@Override
	public String getDehumidifierTimerValue(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getTimerValue();
		}
		return "";
	}

	/**
	* <p>Title: getDehumidifierEletricalHeating</p>
	* <p>Description: 获取除湿机电热状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierEletricalHeating(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getEletricalHeating();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierIndoorTempStatus</p>
	* <p>Description: 获取除湿机室内实际温度</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierIndoorTempStatus(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getIndoorTempStatus();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierWaterPumpStatus</p>
	* <p>Description: 获取除湿机水泵开关状态 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierWaterPumpStatus(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getWaterPumpStatus();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierAnionStatus</p>
	* <p>Description: 获取除湿机负离子状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierAnionStatus(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getAnionStatus();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierFilterNetCleanWarning</p>
	* <p>Description: 获取除湿机滤网清洁报警</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierFilterNetCleanWarning(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getFilterNetCleanWarning();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierHumidSensorError</p>
	* <p>Description: 获取除湿机湿度传感器故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierHumidSensorError(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getHumidSensorError();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierPumpTempratureError</p>
	* <p>Description: 获取除湿机管温故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierPumpTempratureError(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getPumpTempratureError();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierIndoorTempratureError</p>
	* <p>Description: 获取除湿机室内温度故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierIndoorTempratureError(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getIndoorTempratureError();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierWaterFullWarning</p>
	* <p>Description: 获取除湿机水满报警</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierWaterFullWarning(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getWaterFullWarning();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierWaterPumpWarning</p>
	* <p>Description: 获取除湿机水泵故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierWaterPumpWarning(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getWaterPumpWarning();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierSmartWindFN</p>
	* <p>Description: 获取除湿机智慧风使能 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierSmartWindFN(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getSmartWindFN();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierHighWindFN</p>
	* <p>Description: 获取除湿机高风使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierHighWindFN(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getHighWindFN();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierMediumWindFN</p>
	* <p>Description: 获取除湿机中风使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierMediumWindFN(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getMediumWindFN();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierLowWindFN</p>
	* <p>Description: 获取除湿机低风使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierLowWindFN(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getLowWindFN();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierContinueModeFN</p>
	* <p>Description: 获取除湿机持续模式使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierContinueModeFN(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getContinueModeFN();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierNormalModeFN</p>
	* <p>Description: 获取除湿机正常模式使能 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierNormalModeFN(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getNormalModeFN();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierAutoModeFN</p>
	* <p>Description: 获取除湿机智能模式使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierAutoModeFN(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getAutoModeFN();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierTimerControlFN</p>
	* <p>Description: 获取除湿机定时使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierTimerControlFN(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getTimerControlFN();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierElectricHeatFN</p>
	* <p>Description: 获取除湿机电热使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierElectricHeatFN(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getElectricHeatFN();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierElectricHeatSetTemperatureFN</p>
	* <p>Description: 获取除湿机电热设置温度使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierElectricHeatSetTemperatureFN(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getElectricHeatSetTemperatureFN();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierIndoorHumidityFN</p>
	* <p>Description: 获取除湿机室内湿度使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierIndoorHumidityFN(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getIndoorHumidityFN();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierWaterPumpFN</p>
	* <p>Description: 获取除湿机水泵使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierWaterPumpFN(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getWaterPumpFN();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierAnionFN</p>
	* <p>Description: 获取除湿机负离子使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierAnionFN(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getAnionFN();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierElectronicDetectFN</p>
	* <p>Description: 获取除湿机电量检测使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierElectronicDetectFN(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getElectronicDetectFN();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierPowerFN</p>
	* <p>Description: 获取除湿机开关机使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierPowerFN(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getPowerFN();
		}
		return -1;
	}

	/**
	* <p>Title: getDehumidifierEEPROMWriteFN</p>
	* <p>Description: 获取除湿机EEPROM可写使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getDehumidifierEEPROMWriteFN(String deviceId) {
		if(isDehumidifierExist(deviceId) && null != dehumidifierControl) {
			return dehumidifierControl.getEEPROMWriteFN();
		}
		return -1;
	}
	
	
	/*********************************** 空气净化器 *******************************************/
	
	/**
	* <p>Title: setAircleaner</p>
	* <p>Description: smartbox设置空气净化器</p>
	* @param deviceId:设备ID(String类型)
	* @param power:开关机(int类型)
	* @param mode:模式(String类型)
	* @param windSpeed:风速(String类型)
	* @param anionPower:负离子开关(int类型)
	* @param humidifierPower:除湿开关(int类型)
	* @param humidity:设置湿度(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAircleaner(String deviceId, int power, String mode, String windSpeed, int anionPower, int humidifierPower, int humidity, int soundSet) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			byte[] message = aircleanerControl.setBoxAirPurifier(power, mode, windSpeed, anionPower, humidifierPower, humidity, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAircleanerSmartStatus</p>
	* <p>Description: 设置空气净化器受控状态 </p>
	* @param deviceId:设备ID(String类型)
	* @param smartStatus:受控状态(String类型)	
	* @return 成功或失败(boolean类型)
	*/	
	@Override
	public byte[] setAircleanerSmartStatus(String deviceId, String smartStatus) {
		// TODO Auto-generated method stub
		return errorByte;
	}

	/**
	* <p>Title: setAircleanerPower</p>
	* <p>Description: 设置空气净化器开关机 </p>
	* @param deviceId:设备ID(String类型)
	* @param power:开关机(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAircleanerPower(String deviceId, int power, int soundSet) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			byte[] message = aircleanerControl.setPower(power, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAircleanerWindSpeed</p>
	* <p>Description: 设置空气净化器风速</p>
	* @param deviceId:设备ID(String类型)
	* @param windSpeed:风速(String类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAircleanerWindSpeed(String deviceId, String windSpeed, int soundSet) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			byte[] message = aircleanerControl.setWindSpeed(windSpeed, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAircleanerMode</p>
	* <p>Description: 设置空气净化器模式</p>
	* @param deviceId:设备ID(String类型)
	* @param mode:模式(String类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAircleanerMode(String deviceId, String mode, int soundSet) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			byte[] message = aircleanerControl.setMode(mode, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAircleanerTimingSwitchMachine</p>
	* <p>Description: 设置空气净化器普通定时开关机</p>
	* @param deviceId:设备ID(String类型)
	* @param timingEnable:定时使能(int类型)
	* @param timingValue:定时时间(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAircleanerTimingSwitchMachine(String deviceId, int timingEnable, int timingValue, int soundSet) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			byte[] message = aircleanerControl.setTimingSwitchMachine(timingEnable, timingValue, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAircleanerChildClockPower</p>
	* <p>Description: 设置空气净化器童锁开关</p>
	* @param deviceId:设备ID(String类型)
	* @param childClockPower:童锁开关(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAircleanerChildClockPower(String deviceId, int childClockPower, int soundSet) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			byte[] message = aircleanerControl.setChildClockPower(childClockPower, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAircleanerWaterIonPower</p>
	* <p>Description: 设置空气净化器水离子开关</p>
	* @param deviceId:设备ID(String类型)
	* @param waterIonPower:水离子开关(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAircleanerWaterIonPower(String deviceId, int waterIonPower, int soundSet) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			byte[] message = aircleanerControl.setWaterIonPower(waterIonPower, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAircleanerHumidifierPower</p>
	* <p>Description: 设置空气净化器加湿开关</p>
	* @param deviceId:设备ID(String类型)
	* @param humidifierPower:加湿开关(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAircleanerHumidifierPower(String deviceId, int humidifierPower, int soundSet) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			byte[] message = aircleanerControl.setHumidifierPower(humidifierPower, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAircleanerHumidityValue</p>
	* <p>Description: 设置空气净化器加湿湿度值</p>
	* @param deviceId:设备ID(String类型)
	* @param humidityValue:湿度值(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAircleanerHumidityValue(String deviceId, int humidityValue, int soundSet) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			byte[] message = aircleanerControl.setHumidityValue(humidityValue, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: getAircleanerOnlineStatus</p>
	* <p>Description: 获取空气净化器在线状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 是否在线(boolean类型) 
	*/
	@Override
	public boolean getAircleanerOnlineStatus(String deviceId) {
		return isAircleanerExist(deviceId);
	}

	/**
	* <p>Title: getAircleanerSmartStatus</p>
	* <p>Description: 获取空气净化器受控状态 </p>
	* @param deviceId:设备ID(String类型)
	* @return 受控状态(String类型)
	*/
	@Override
	public String getAircleanerSmartStatus(String deviceId) {
		return "controllable";
	}

	/**
	* <p>Title: getAircleanerSetPowerOnDuration</p>
	* <p>Description: 获取空气净化器设置开机后的持续时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public long getAircleanerSetPowerOnDuration(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getSetPowerOnDuration();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerSetPowerOffDuration</p>
	* <p>Description: 获取空气净化器设置关机后的持续时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public long getAircleanerSetPowerOffDuration(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getSetPowerOffDuration();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerSetModeDuration</p>
	* <p>Description: 获取空气净化器设置模式后的持续时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public long getAircleanerSetModeDuration(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getSetModeDuration();
		}
		return -1;
	}
	
	/**
	* <p>Title: getAircleanerHumidifyDuration</p>
	* <p>Description: 获取空气净化器加湿持续时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public long getAircleanerHumidifyDuration(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getHumidifyDuration();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerAnionDuration</p>
	* <p>Description: 获取空气净化器打开负离子开关后的持续时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public long getAircleanerAnionDuration(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getAnionDuration();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerSequence</p>
	* <p>Description: 获取空气净化器帧内序号</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerSequence(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getSequence();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerResult</p>
	* <p>Description: 获取空气净化器操作结果</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(String类型)  
	*/
	@Override
	public String getAircleanerResult(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getResult();
		}
		return "";
	}

	/**
	* <p>Title: getAircleanerWindSpeed</p>
	* <p>Description: 获取空气净化器风速</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(String类型)  
	*/
	@Override
	public String getAircleanerWindSpeed(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getWindSpeed();
		}
		return "";
	}

	/**
	* <p>Title: getAircleanerMode</p>
	* <p>Description: 获取空气净化器模式</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(String类型) 
	*/
	@Override
	public String getAircleanerMode(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getMode();
		}
		return "";
	}

	/**
	* <p>Title: getAircleanerPower</p>
	* <p>Description: 获取空气净化器开关机状态 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerPower(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getPower();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerHumidityValueSet</p>
	* <p>Description: 获取空气净化器设置的湿度值</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerHumidityValueSet(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getHumidityValueSet();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerHumidityPower</p>
	* <p>Description: 获取空气净化器加湿开关</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerHumidityPower(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getHumidityPower();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerAnionPower</p>
	* <p>Description: 获取空气净化器负离子开关</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerAnionPower(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getAnionPower();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerHumidifyIndoor</p>
	* <p>Description: 获取空气净化器室内湿度</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerHumidifyIndoor(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getHumidifyIndoor();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerTimeStatus</p>
	* <p>Description: 获取空气净化器定时状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerTimeStatus(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getTimeStatus();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerTimerValue</p>
	* <p>Description: 获取空气净化器定时时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(String类型)  
	*/
	@Override
	public String getAircleanerTimerValue(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getTimerValue();
		}
		return "";
	}

	/**
	* <p>Title: getAircleanerMotorSpeed</p>
	* <p>Description: 获取空气净化器风机转速</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerMotorSpeed(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getMotorSpeed();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerAirQuality</p>
	* <p>Description: 获取空气净化器空气质量</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerAirQuality(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getAirQuality();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerAirQualityPercent</p>
	* <p>Description: 获取空气净化器空气质量百分比 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerAirQualityPercent(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getAirQualityPercent();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerRelativeHumidityValue</p>
	* <p>Description: 获取空气净化器实际湿度值</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerRelativeHumidityValue(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getRelativeHumidityValue();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerChildLockStatus</p>
	* <p>Description: 获取空气净化器童锁开关状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerChildLockStatus(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getChildLockStatus();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerWaterionStatus</p>
	* <p>Description: 获取空气净化器水离子开关状态 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerWaterionStatus(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getWaterionStatus();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerHumidityStatus</p>
	* <p>Description: 获取空气净化器加湿状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerHumidityStatus(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getHumidityStatus();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerChangeFilterError</p>
	* <p>Description: 获取空气净化器滤网更换警告</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerChangeFilterError(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getChangeFilterError();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerHumidityWheelError</p>
	* <p>Description: 获取空气净化器加湿转轮故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerHumidityWheelError(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getHumidityWheelError();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerWaterSinkEmptyError</p>
	* <p>Description: 获取空气净化器水箱空警告</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerWaterSinkEmptyError(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getWaterSinkEmptyError();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerWaterSinkNotSetup</p>
	* <p>Description: 获取空气净化器水箱未安装警告</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerWaterSinkNotSetup(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getWaterSinkNotSetup();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerHumiditySensorError</p>
	* <p>Description: 获取空气净化器湿度传感器故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerHumiditySensorError(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getHumiditySensorError();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerMotorError</p>
	* <p>Description: 获取空气净化器电机故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerMotorError(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getMotorError();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerDustSensorError</p>
	* <p>Description: 获取空气净化器粉尘传感器故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerDustSensorError(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getDustSensorError();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerSmellSensorError</p>
	* <p>Description: 获取空气净化器异味传感器故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerSmellSensorError(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getSmellSensorError();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerLeanError</p>
	* <p>Description: 获取空气净化器放置倾斜警告</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerLeanError(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getLeanError();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerSettingHumid</p>
	* <p>Description: 获取空气净化器设置的湿度值</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerSettingHumid(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getSettingHumid();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerCleanSpeedAutoFN</p>
	* <p>Description: 获取空气净化器自动风使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerCleanSpeedAutoFN(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getCleanSpeedAutoFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerCleanSpeedDelSmokeFN</p>
	* <p>Description: 获取空气净化器除烟风使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerCleanSpeedDelSmokeFN(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getCleanSpeedDelSmokeFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerCleanSpeedHighFN</p>
	* <p>Description: 获取空气净化器高速风使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerCleanSpeedHighFN(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getCleanSpeedHighFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerCleanSpeedMiddleFN</p>
	* <p>Description: 获取空气净化器中速风使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerCleanSpeedMiddleFN(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getCleanSpeedMiddleFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerCleanSpeedLowFN</p>
	* <p>Description: 获取空气净化器低速风使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerCleanSpeedLowFN(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getCleanSpeedLowFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerCleanModeSleepFN</p>
	* <p>Description: 获取空气净化器睡眠模式使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerCleanModeSleepFN(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getCleanModeSleepFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerCleanModeMuteFN</p>
	* <p>Description: 获取空气净化器静音模式使能 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerCleanModeMuteFN(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getCleanModeMuteFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerCleanModeSmartFN</p>
	* <p>Description: 获取空气净化器智能模式使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerCleanModeSmartFN(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getCleanModeSmartFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerCleanModeDelTasteFN</p>
	* <p>Description: 获取空气净化器除味模式使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerCleanModeDelTasteFN(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getCleanModeDelTasteFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerCleanModeDelSmokeFN</p>
	* <p>Description: 获取空气净化器除烟模式使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerCleanModeDelSmokeFN(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getCleanModeDelSmokeFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerGeneralTimingFN</p>
	* <p>Description: 获取空气净化器普通定时使能 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerGeneralTimingFN(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getGeneralTimingFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerChildLockFN</p>
	* <p>Description: 获取空气净化器童锁开关使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerChildLockFN(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getChildLockFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerWaterIonFN</p>
	* <p>Description: 获取空气净化器水离子开关使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerWaterIonFN(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getWaterIonFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerDehumidifierFN</p>
	* <p>Description: 获取空气净化器加湿开关使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerDehumidifierFN(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getDehumidifierFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerCleanMachineFN</p>
	* <p>Description: 获取空气净化器净化机开停功能使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerCleanMachineFN(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getCleanMachineFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerEEpromReadWriteFN</p>
	* <p>Description: 获取空气净化器EEPROM可读写使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerEEpromReadWriteFN(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getEEpromReadWriteFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAircleanerPowerDetectFN</p>
	* <p>Description: 获取空气净化器电量检测功能使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAircleanerPowerDetectFN(String deviceId) {
		if(isAircleanerExist(deviceId) && null != aircleanerControl) {
			return aircleanerControl.getPowerDetectFN();
		}
		return -1;
	}

	
	/*********************************** 新风机 *******************************************/
	
	/**
	* <p>Title: setAirfan</p>
	* <p>Description: smartbox设置新风机</p>
	* @param deviceId:设备ID(String类型)
	* @param power:开关机(int类型)
	* @param mode:模式(String类型)
	* @param windSpeed:风速(String类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirfan(String deviceId, int power, String mode, String windSpeed, int soundSet) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			byte[] message = airfanControl.setBoxAirFan(power, mode, windSpeed, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirfanSmartStatus</p>
	* <p>Description: 设置新风机受控状态</p>
	* @param deviceId:设备ID(String类型)
	* @param smartStatus:受控状态(String类型)	
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirfanSmartStatus(String deviceId, String smartStatus) {
		// TODO Auto-generated method stub
		return errorByte;
	}

	/**
	* <p>Title: setAirfanPower</p>
	* <p>Description: 设置新风机开关机状态 </p>
	* @param deviceId:设备ID(String类型)
	* @param power:开关机(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirfanPower(String deviceId, int power, int soundSet) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			byte[] message = airfanControl.setPower(power, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirfanWindSpeed</p>
	* <p>Description: 设置新风机风速</p>
	* @param deviceId:设备ID(String类型)
	* @param windSpeed:风速(String类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirfanWindSpeed(String deviceId, String windSpeed, int soundSet) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			byte[] message = airfanControl.setWindSpeed(windSpeed, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirfanMode</p>
	* <p>Description: 设置新风机模式</p>
	* @param deviceId:设备ID(String类型)
	* @param mode:模式(String类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirfanMode(String deviceId, String mode, int soundSet) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			byte[] message = airfanControl.setMode(mode, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setAirfanTimingSwitchMachine</p>
	* <p>Description: 设置新风机普通定时</p>
	* @param deviceId:设备ID(String类型)
	* @param timingEnable:定时使能(int类型)
	* @param timingValue:定时时间(int类型)
	* @param soundSet:操作提示音(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setAirfanTimingSwitchMachine(String deviceId, int timingEnable, int timingValue, int soundSet) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			byte[] message = airfanControl.setTimingSwitchMachine(timingEnable, timingValue, soundSet);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: getAirfanOnlineStatus</p>
	* <p>Description: 获取新风机在线状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 是否在线(boolean类型)
	*/
	@Override
	public boolean getAirfanOnlineStatus(String deviceId) {
		return isAirfanExist(deviceId);
	}

	/**
	* <p>Title: getAirfanSmartStatus</p>
	* <p>Description: 获取新风机受控状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 受控状态(String类型)
	*/
	@Override
	public String getAirfanSmartStatus(String deviceId) {
		return "controllable";
	}

	/**
	* <p>Title: getAirfanSetPowerOnDuration</p>
	* <p>Description: 获取新风机设置开机后的持续时间 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public long getAirfanSetPowerOnDuration(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getSetPowerOnDuration();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanSetPowerOffDuration</p>
	* <p>Description: 获取新风机设置关机后的持续时间 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public long getAirfanSetPowerOffDuration(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getSetPowerOffDuration();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanSetModeDuration</p>
	* <p>Description: 获取新风机设置模式后的持续时间 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型) 
	*/
	@Override
	public long getAirfanSetModeDuration(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getSetModeDuration();
		}
		return -1;
	}
	
	/**
	* <p>Title: getAirfanSequence</p>
	* <p>Description: 获取新风机帧内序号</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanSequence(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getSequence();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanResult</p>
	* <p>Description: 获取新风机操作结果</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(String类型)  
	*/
	@Override
	public String getAirfanResult(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getResult();
		}
		return "";
	}

	/**
	* <p>Title: getAirfanWindSpeed</p>
	* <p>Description: 获取新风机风速</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(String类型) 
	*/
	@Override
	public String getAirfanWindSpeed(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getWindSpeed();
		}
		return "";
	}

	/**
	* <p>Title: getAirfanMode</p>
	* <p>Description: 获取新风机模式</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(String类型) 
	*/
	@Override
	public String getAirfanMode(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getMode();
		}
		return "";
	}

	/**
	* <p>Title: getAirfanPower</p>
	* <p>Description: 获取新风机开关机状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanPower(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getPower();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanHumidityIndoor</p>
	* <p>Description: 获取新风机室内湿度</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanHumidityIndoor(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getHumidityIndoor();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanHumidityOutdoor</p>
	* <p>Description: 获取新风机室外湿度</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanHumidityOutdoor(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getHumidityOutdoor();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanTemperatureIndoor</p>
	* <p>Description: 获取新风机室内温度 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanTemperatureIndoor(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getTemperatureIndoor();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanTemperatureOutdoor</p>
	* <p>Description: 获取新风机室外温度</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanTemperatureOutdoor(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getTemperatureOutdoor();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanCO2Indoor</p>
	* <p>Description: 获取新风机室内二氧化碳浓度 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanCO2Indoor(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getCO2Indoor();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanSuspendMode</p>
	* <p>Description: 获取新风机待机状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanSuspendMode(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getSuspendMode();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanIsTiming</p>
	* <p>Description: 获取新风机定时状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanIsTiming(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getIsTiming();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanTimingTime</p>
	* <p>Description: 获取新风机定时时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanTimingTime(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getTimingTime();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanOuterFanSpeed</p>
	* <p>Description: 获取新风机外部风扇转速</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanOuterFanSpeed(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getOuterFanSpeed();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanInnerFanSpeed</p>
	* <p>Description: 获取新风机内部风扇转速</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanInnerFanSpeed(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getInnerFanSpeed();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanInnerTempratureValid</p>
	* <p>Description: 获取新风机内部有效温度</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanInnerTempratureValid(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getInnerTempratureValid();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanInnerHumidityValid</p>
	* <p>Description: 获取新风机内部有效湿度</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanInnerHumidityValid(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getInnerHumidityValid();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanInnerco2DensityValid</p>
	* <p>Description: 获取室内二氧化碳有效值</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanInnerco2DensityValid(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getInnerco2DensityValid();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanOuterTempratureValid</p>
	* <p>Description: 获取新风机外部有效温度</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanOuterTempratureValid(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getOuterTempratureValid();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanOuterHumidityValid</p>
	* <p>Description: 获取新风机外部有效湿度</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanOuterHumidityValid(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getOuterHumidityValid();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanFilterIfReplace</p>
	* <p>Description: 获取新风机滤网复位状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanFilterIfReplace(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getFilterIfReplace();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanOuterFanIfFault</p>
	* <p>Description: 获取新风机室外风扇故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanOuterFanIfFault(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getOuterFanIfFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanInnerFanIfFault</p>
	* <p>Description: 获取新风机室内风扇故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanInnerFanIfFault(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getInnerFanIfFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanOuterTemperatureSensorIfFault</p>
	* <p>Description: 获取新风机室外温度传感器故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanOuterTemperatureSensorIfFault(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getOuterTemperatureSensorIfFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanOuterHumiditySensorIfFault</p>
	* <p>Description: 获取新风机室外湿度传感器故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanOuterHumiditySensorIfFault(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getOuterHumiditySensorIfFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanCo2SensorIfFault</p>
	* <p>Description: 获取新风机二氧化碳传感器故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanCo2SensorIfFault(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getCo2SensorIfFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanInnerTemperatureSensorFault</p>
	* <p>Description: 获取新风机室内温度传感器故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanInnerTemperatureSensorFault(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getInnerTemperatureSensorFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanInnerHumiditySensorFault</p>
	* <p>Description: 获取新风机室内湿度传感器故障</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanInnerHumiditySensorFault(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getInnerHumiditySensorFault();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanSpeedSupportNumberFN</p>
	* <p>Description: 获取新风机风量支持档位数使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanSpeedSupportNumberFN(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getSpeedSupportNumberFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanfullheatModeFN</p>
	* <p>Description: 获取新风机全热换气模式使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanfullheatModeFN(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getfullheatModeFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanDirectModeFN</p>
	* <p>Description: 获取新风机直通换气模式使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanDirectModeFN(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getDirectModeFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanIndoorModeFN</p>
	* <p>Description: 获取新风机室内回旋模式使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanIndoorModeFN(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getIndoorModeFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanTiming</p>
	* <p>Description: 获取新风机普通定时模式使能 </p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanTiming(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getTiming();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanPowerFN</p>
	* <p>Description: 获取新风机开关机控制位使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanPowerFN(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getPowerFN();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanIfUpdateEEPROM</p>
	* <p>Description: 获取新风机是否升级EEPROM</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanIfUpdateEEPROM(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getIfUpdateEEPROM();
		}
		return -1;
	}

	/**
	* <p>Title: getAirfanBatteryIFdetection</p>
	* <p>Description: 获取新风机电量检测使能</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getAirfanBatteryIFdetection(String deviceId) {
		if(isAirfanExist(deviceId) && null != airfanControl) {
			return airfanControl.getbatteryIFdetection();
		}
		return -1;
	}
	
	
	/*********************************** 四合一传感器 *******************************************/
	/**
	* <p>Title: setSensorsSmartStatus</p>
	* <p>Description: 设置传感器受控状态</p>
	* @param deviceId:设备ID(String类型)
	* @param smartStatus:受控状态(String类型)	
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setSensorsSmartStatus(String deviceId, String smartStatus) {
		// TODO Auto-generated method stub
		return errorByte;
	}

	/**
	* <p>Title: setSensorsPM25Power</p>
	* <p>Description: smartbox设置传感器</p>
	* @param deviceId:设备ID(String类型)
	* @param power:开关机(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setSensorsPM25Power(String deviceId, int power) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			byte[] message = sensorsControl.setPM2_5Power(power);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setSensorsPower</p>
	* <p>Description: 设置传感器开关机</p>
	* @param deviceId:设备ID(String类型)
	* @param power:开关机(int类型)
	* @param sensorID:传感器ID(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setSensorsPower(String deviceId, int power, int sensorID) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			byte[] message = sensorsControl.setSensorsPower(power, sensorID);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setResponseFrequency</p>
	* <p>Description: 设置传感器主动上报频率</p>
	* @param deviceId:设备ID(String类型)
	* @param responseFrequencyValid:频率实际值(int类型)
	* @param responseID:ID(int类型)
	* @param responseFrequency:频率(int类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setResponseFrequency(String deviceId, int responseFrequencyValid, int responseID, int responseFrequency) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			byte[] message = sensorsControl.setResponseFrequency(responseFrequencyValid, responseID, responseFrequency);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: getSensorsOnlineStatus</p>
	* <p>Description: 设置传感器在线状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 是否在线(boolean类型)  
	*/
	@Override
	public boolean getSensorsOnlineStatus(String deviceId) {
		return isSensorsExist(deviceId);
	}

	/**
	* <p>Title: getSensorsSmartStatus</p>
	* <p>Description: 获取传感器受控状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 受控状态(String类型)
	*/
	@Override
	public String getSensorsSmartStatus(String deviceId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	* <p>Title: getSensorsTemperatureSensorID</p>
	* <p>Description: 获取传感器温度sensor的ID</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsTemperatureSensorID(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getTemperatureSensorID();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsTemperatureValueValid</p>
	* <p>Description: 获取传感器有效温度值</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsTemperatureValueValid(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getTemperatureValueValid();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsTemperatureSensorPowerStatus</p>
	* <p>Description: 获取传感器温度sensor的开关状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsTemperatureSensorPowerStatus(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getTemperatureSensorPowerStatus();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsTemperatureInterval</p>
	* <p>Description: 获取传感器上次读温度值时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsTemperatureInterval(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getTemperatureInterval();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsTemperatureValue</p>
	* <p>Description: 获取传感器温度值</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(float类型)  
	*/
	@Override
	public float getSensorsTemperatureValue(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getTemperatureValue();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsHumiditySensorID</p>
	* <p>Description: 获取传感器湿度sensor的ID</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsHumiditySensorID(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getHumiditySensorID();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsHumidityValueValid</p>
	* <p>Description: 获取传感器实际湿度值</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsHumidityValueValid(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getHumidityValueValid();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsHumiditySensorPowerStatus</p>
	* <p>Description: 获取传感器湿度sensor的开关状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsHumiditySensorPowerStatus(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getHumiditySensorPowerStatus();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsHumidityInterval</p>
	* <p>Description: 获取传感器上次读湿度值时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsHumidityInterval(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getHumidityInterval();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsHumidityValue</p>
	* <p>Description: 获取传感器湿度值</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsHumidityValue(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getHumidityValue();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsH2COSensorID</p>
	* <p>Description: 获取传感器甲醛sensor的ID</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsH2COSensorID(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getH2COSensorID();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsH2COValueValid</p>
	* <p>Description: 获取传感器实际甲醛含量</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsH2COValueValid(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getH2COValueValid();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsH2COSensorPowerStatus</p>
	* <p>Description: 获取传感器甲醛sensor的开关状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsH2COSensorPowerStatus(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getH2COSensorPowerStatus();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsH2COInterval</p>
	* <p>Description: 获取传感器上次读甲醛值时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsH2COInterval(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getH2COInterval();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsH2COValue</p>
	* <p>Description: 获取传感器甲醛值</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(float类型)  
	*/
	@Override
	public float getSensorsH2COValue(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getH2COValue();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsPM25SensorID</p>
	* <p>Description: 获取传感器pm2.5sensor的ID</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsPM25SensorID(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getPM2_5SensorID();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsPM25ValueValid</p>
	* <p>Description: 获取传感器 的pm2.5的值</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsPM25ValueValid(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getPM2_5ValueValid();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsPM25SensorPowerStatus</p>
	* <p>Description: 获取传感器pm2.5sensor的开关状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsPM25SensorPowerStatus(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getPM2_5SensorPowerStatus();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsPM25Interval</p>
	* <p>Description: 获取传感器上次读PM2.5值时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsPM25Interval(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getPM2_5Interval();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsPM25Value</p>
	* <p>Description: 获取传感器pm2.5的值</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(float类型)  
	*/
	@Override
	public float getSensorsPM25Value(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getPM2_5Value();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsCO2SensorID</p>
	* <p>Description: 获取传感器二氧化碳sensor的ID</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsCO2SensorID(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getCO2SensorID();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsCO2ValueValid</p>
	* <p>Description: 获取传感器二氧化碳的实际值</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsCO2ValueValid(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getCO2ValueValid();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsCO2SensorPowerStatus</p>
	* <p>Description: 获取传感器二氧化碳sensor的开关状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsCO2SensorPowerStatus(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getCO2SensorPowerStatus();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsCO2Interval</p>
	* <p>Description: 获取传感器上次读CO2值时间</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsCO2Interval(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getCO2Interval();
		}
		return -1;
	}

	/**
	* <p>Title: getSensorsCO2Value</p>
	* <p>Description: 获取传感器二氧化碳值</p>
	* @param deviceId:设备ID(String类型)
	* @return 状态(int类型)  
	*/
	@Override
	public int getSensorsCO2Value(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getCO2Value();
		}
		return -1;
	}
	
	/**
	* <p>Title: getSensorsIsPeripheralsCommunicationError</p>
	* <p>Description: 获取传感器转换板通信错误</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型:0为正常，1为通信错误
	*/
	@Override
	public int getSensorsIsPeripheralsCommunicationError(String deviceId) {
		if(isSensorsExist(deviceId) && null != sensorsControl) {
			return sensorsControl.getIsPeripheralsCommunicationError();
		}
		return -1;
	}


//	/*********************************** 4004模组 *******************************************/
//	/**
//	* <p>Title: getSmartSwitchPowerStatus</p>
//	* <p>Description: TODO(这里用一句话描述这个方法的作用)</p>
//	* @param deviceId:设备ID(String类型)
//	* @return int类型
//	*/
//	@Override
//	public int getSmartSwitchPowerStatus(String deviceId) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			return wifiControl.getSmartSwitchPowerStatus();
//		}
//		return -1;
//	}
//
//	/**
//	* <p>Title: getSmartSwitchCurrent</p>
//	* <p>Description: TODO(这里用一句话描述这个方法的作用)</p>
//	* @param deviceId:设备ID(String类型)
//	* @return int类型
//	*/
//	@Override
//	public int getSmartSwitchCurrent(String deviceId) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			return wifiControl.getSmartSwitchCurrent();
//		}
//		return -1;
//	}
//
//	/**
//	* <p>Title: getSmartSwitchVoltage</p>
//	* <p>Description: TODO(这里用一句话描述这个方法的作用)</p>
//	* @param deviceId:设备ID(String类型)
//	* @return int类型
//	*/
//	@Override
//	public int getSmartSwitchVoltage(String deviceId) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			return wifiControl.getSmartSwitchVoltage();
//		}
//		return -1;
//	}
//
//	/**
//	* <p>Title: getSmartSwitchPowerConsum</p>
//	* <p>Description: TODO(这里用一句话描述这个方法的作用)</p>
//	* @param deviceId:设备ID(String类型)
//	* @return int类型
//	*/
//	@Override
//	public long getSmartSwitchPowerConsum(String deviceId) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			return wifiControl.getSmartSwitchPowerConsum();
//		}
//		return -1;
//	}
//	
//	@Override
//	public int getWifiModuleSmartControlStatus(String deviceId) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			return wifiControl.getWifiModuleSmartControlStatus();
//		}
//		return -1;
//	}
//	
//	@Override
//	public boolean setDeviceAutoReportFlag(String deviceId, String autoReport) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			byte[] message = wifiControl.jStrSetDevReportFlag(autoReport);
//			if(null != message) {
//				return sendMessageWithMqtt(deviceId, message);
//			}
//		}
//		return false;
//	}
//	
//	@Override
//	public boolean setDeviceControllable(String deviceId, String cmd) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			byte[] message = wifiControl.jStrConfigDevSmartCtrl(cmd);
//			if(null != message) {
//				return sendMessageWithMqtt(deviceId, message);
//			}
//		}
//		return false;
//	}
//	
//	/**
//	* <p>Title: queryWifiModuleModuleID</p>
//	* <p>Description: 查询wifi模组的ID</p>
//	* @param deviceId:设备ID(String类型)
//	* @return 成功或失败(boolean类型) 
//	*/
//	@Override
//	public boolean queryWifiModuleModuleID(String deviceId) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			byte[] message = wifiControl.jStrQueryModule();
//			if(null != message) {
//				return sendMessageWithMqtt(deviceId, message);
//			}
//		}
//		return false;
//	}
//	/**
//	* <p>Title: queryWifiModuleVersion</p>
//	* <p>Description: 获取wifi模组的版本</p>
//	* @param deviceId:设备ID(String类型)
//	* @return 成功或失败(boolean类型)  
//	*/
//	@Override
//	public boolean queryWifiModuleVersion(String deviceId) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			byte[] message = wifiControl.jStrQueryModuleVersion();
//			if(null != message) {
//				return sendMessageWithMqtt(deviceId, message);
//			}
//		}
//		return false;
//	}
//
//	/**
//	* <p>Title: queryWifiModuleStatus</p>
//	* <p>Description: 获取wifi模组的状态</p>
//	* @param deviceId:设备ID(String类型)
//	* @return 成功或失败(boolean类型)  
//	*/
//	@Override
//	public boolean queryWifiModuleStatus(String deviceId) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			byte[] message = wifiControl.jStrQueryWifiStatus();
//			if(null != message) {
//				return sendMessageWithMqtt(deviceId, message);
//			}
//		}
//		return false;
//	}
//
//	/**
//	* <p>Title: clearWifiConfigPars</p>
//	* <p>Description: 清除wifi模组的配置信息</p>
//	* @param deviceId:设备ID(String类型)
//	* @return 成功或失败(boolean类型)  
//	*/
//	@Override
//	public boolean clearWifiConfigPars(String deviceId) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			byte[] message = wifiControl.jStrClearConfigPars();
//			if(null != message) {
//				return sendMessageWithMqtt(deviceId, message);
//			}
//		}
//		return false;
//	}
//
//	/**
//	* <p>Title: queryWifiModuleMac</p>
//	* <p>Description: 获取wifi模组的Mac地址</p>
//	* @param deviceId:设备ID(String类型)
//	* @return 成功或失败(boolean类型)  
//	*/
//	@Override
//	public boolean queryWifiModuleMac(String deviceId) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			byte[] message = wifiControl.jStrGetModuleMac();
//			if(null != message) {
//				return sendMessageWithMqtt(deviceId, message);
//			}
//		}
//		return false;
//	}
//
//	/**
//	* <p>Title: queryWifiModuleRSInfo</p>
//	* <p>Description: 获取wifi模组的cdn信息</p>
//	* @param deviceId:设备ID(String类型)
//	* @return 成功或失败(boolean类型)  
//	*/
//	@Override
//	public boolean queryWifiModuleRSInfo(String deviceId) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			byte[] message = wifiControl.jStrQueryRSInfo();
//			if(null != message) {
//				return sendMessageWithMqtt(deviceId, message);
//			}
//		}
//		return false;
//	}
//
//	/**
//	* <p>Title: setWifiModuleRSInfo</p>
//	* <p>Description: 设置wifi模组的cdn信息</p>
//	* @param deviceId:设备ID(String类型)
//	* @param domainname:域名(String类型)
//	* @param port:端口(String类型)
//	* @return 成功或失败(boolean类型)  
//	*/
//	@Override
//	public boolean setWifiModuleRSInfo(String deviceId, String domainname, String port) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			byte[] message = wifiControl.jStrConfigRSInfo(domainname, port);
//			if(null != message) {
//				return sendMessageWithSocket(deviceId, message);
//			}
//		}
//		return false;
//	}
//
//	/**
//	* <p>Title: queryWifiRouterInfo</p>
//	* <p>Description: 获取wifi模组的路由器信息</p>
//	* @param deviceId:设备ID(String类型)
//	* @return 成功或失败(boolean类型)  
//	*/
//	@Override
//	public boolean queryWifiRouterInfo(String deviceId) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			byte[] message = wifiControl.jStrQueryRouterInfo();
//			if(null != message) {
//				return sendMessageWithMqtt(deviceId, message);
//			}
//		}
//		return false;
//	}
//
//	/**
//	* <p>Title: setWifiRouterInfo</p>
//	* <p>Description: 设置wifi模组的路由器信息</p>
//	* @param deviceId:设备ID(String类型)
//	* @param ssid:路由器SSID(String类型)
//	* @param password:路由器密码(String类型)
//	* @return 成功或失败(boolean类型)  
//	*/
//	@Override
//	public boolean setWifiRouterInfo(String deviceId, String ssid, String password) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			byte[] message = wifiControl.jStrConfigRouterInfo(ssid, password);
//			if(null != message) {
//				return sendMessageWithSocket(deviceId, message);
//			}
//		}
//		return false;
//	}
//
//	/**
//	* <p>Title: setWifiToStationMode</p>
//	* <p>Description: 设置wifif模组到station模式</p>
//	* @param deviceId:设备ID(String类型)
//	* @return 成功或失败(boolean类型)  
//	*/
//	@Override
//	public boolean setWifiToStationMode(String deviceId) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			byte[] message = wifiControl.jStrRequestConnectRemote();
//			if(null != message) {
//				return sendMessageWithSocket(deviceId, message);
//			}
//		}
//		return false;
//	}
//
//	/**
//	* <p>Title: queryWifiModuleServerIp</p>
//	* <p>Description: 获取wifi模组连接cdn的IP</p>
//	* @param deviceId:设备ID(String类型)
//	* @return 成功或失败(boolean类型)  
//	*/
//	@Override
//	public boolean queryWifiModuleServerIp(String deviceId) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			byte[] message = wifiControl.jStrQueryModuleServerIp();
//			if(null != message) {
//				return sendMessageWithMqtt(deviceId, message);
//			}
//		}
//		return false;
//	}
//
//	/**
//	* <p>Title: setWifiToApMode</p>
//	* <p>Description: 设置wifi模组到AP模式</p>
//	* @param deviceId:设备ID(String类型)
//	* @return 成功或失败(boolean类型)  
//	*/
//	@Override
//	public boolean setWifiToApMode(String deviceId) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			byte[] message = wifiControl.jStrSwitchApMode();
//			if(null != message) {
//				return sendMessageWithMqtt(deviceId, message);
//			}
//		}
//		return false;
//	}
//
//	/**
//	* <p>Title: setWifiModuleLocalFlag</p>
//	* <p>Description: 设置wifi模组是否为本地连接模式，不用去连cdn</p>
//	* @param deviceId:设备ID(String类型)
//	* @param flag:是否只连接本地(String类型)
//	* @return 成功或失败(boolean类型)  
//	*/
//	@Override
//	public boolean setWifiModuleLocalFlag(String deviceId, String flag) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			byte[] message = wifiControl.jStrSetLocalFlag(flag);
//			if(null != message) {
//				return sendMessageWithMqtt(deviceId, message);
//			}
//		}
//		return false;
//	}
//
//	/**
//	* <p>Title: setWifiProtocolVersion</p>
//	* <p>Description: 设置wifi模组的协议版本</p>
//	* @param deviceId:设备ID(String类型)
//	* @param version:版本号(String类型)
//	* @return 成功或失败(boolean类型)  
//	*/
//	@Override
//	public boolean setWifiProtocolVersion(String deviceId, String version) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			byte[] message = wifiControl.jStrSetProtocolVersion(version);
//			if(null != message) {
//				return sendMessageWithMqtt(deviceId, message);
//			}
//		}
//		return false;
//	}
//
//	/**
//	* <p>Title: setHttpUpdateWifiModule</p>
//	* <p>Description: 远程升级wifi模组</p>
//	* @param deviceId:设备ID(String类型)
//	* @param url:资源位置(String类型)
//	* @return 成功或失败(boolean类型)
//	*/
//	@Override
//	public boolean setHttpUpdateWifiModule(String deviceId, String url) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			byte[] message = wifiControl.jStrHttpUpdateModule(url);
//			if(null != message) {
//				return sendMessageWithMqtt(deviceId, message);
//			}
//		}
//		return false;
//	}
//
//	/**
//	* <p>Title: querySmartSwitchValue</p>
//	* <p>Description:查询电量计的值   开关状态、当前电压、当前电流、累积电量</p>
//	* @param deviceId:设备ID(String类型)
//	* @return 成功或失败(boolean类型)
//	*/
//	@Override
//	public boolean querySmartSwitchValue(String deviceId) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			String message = wifiControl.querySmartSwitchValue();
//			if(null != message) {
//				return sendMessageWithMqtt(deviceId, message.getBytes());
//			}
//		}
//		return false;
//	}
//
//	/**
//	* <p>Title: clearSmartSwitchValue</p>
//	* <p>Description:累积电量清零</p>
//	* @param deviceId:设备ID(String类型)
//	* @return 成功或失败(boolean类型)
//	*/
//	@Override
//	public boolean clearSmartSwitchValue(String deviceId) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			String message = wifiControl.clearSmartSwitchValue();
//			if(null != message) {
//				return sendMessageWithMqtt(deviceId, message.getBytes());
//			}
//		}
//		return false;
//	}
//
//	/**
//	* <p>Title: setSmartSwitchPower</p>
//	* <p>Description:设置计电器开关</p>
//	* @param deviceId:设备ID(String类型)
//	* @param enflag:开关量,1开0关
//	* @return 成功或失败(boolean类型)
//	*/
//	@Override
//	public boolean setSmartSwitchPower(String deviceId, String enflag) {
//		IWifiControl wifiControl = getWifiControl(deviceId);
//		if(null != wifiControl) {
//			String message = wifiControl.setSmartSwitchPower(enflag);
//			if(null != message) {
//				return sendMessageWithMqtt(deviceId, message.getBytes());
//			}
//		}
//		return false;
//	}


	/*********************************** 窗帘 *******************************************/
	/**
	* <p>Title: setSmartcurtainMode</p>
	* <p>Description: 设置窗帘的模式</p>
	* @param deviceId:设备ID(String类型)
	* @param mode:模式(int类型) 0打开、1 关闭、2、重启、3 定点控制
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setSmartcurtainMode(String deviceId, int mode) {
		if(isSmartcurtainExist(deviceId) && null != smartcurtainControl) {
			byte[] message = smartcurtainControl.setMode(mode);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setSmartcurtainPosition</p>
	* <p>Description: 设置窗帘的定点位置</p>
	* @param deviceId:设备ID(String类型)
	* @param position:定点位置(int类型) [0-16]
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setSmartcurtainPosition(String deviceId, int position) {
		if(isSmartcurtainExist(deviceId) && null != smartcurtainControl) {
			byte[] message = smartcurtainControl.setPosition(position);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: getSmartcurtainOnlineStatus</p>
	* <p>Description: 设置窗帘在线状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 是否在线(boolean类型)  
	*/
	@Override
	public boolean getSmartcurtainOnlineStatus(String deviceId) {
		return isSmartcurtainExist(deviceId);
	}
	
	/**
	* <p>Title: getSmartcurtainPowerStatusParameterIsValid</p>
	* <p>Description: 获取窗帘开关状态是否有效</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型
	*/
	@Override
	public int getSmartcurtainPowerStatusParameterIsValid(String deviceId) {
		if(isSmartcurtainExist(deviceId) && null != smartcurtainControl) {
			return smartcurtainControl.getPowerStatusParameterIsValid();
		}
		return -1;
	}

	/**
	* <p>Title: getSmartcurtainPowerStatus</p>
	* <p>Description: 获取窗帘开关状态</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型 [0/1]
	*/
	@Override
	public int getSmartcurtainPowerStatus(String deviceId) {
		if(isSmartcurtainExist(deviceId) && null != smartcurtainControl) {
			return smartcurtainControl.getPowerStatus();
		}
		return -1;
	}

	/**
	* <p>Title: getSmartcurtainPositionParameterIsValid</p>
	* <p>Description: 获取窗帘的定点位置参数是否有效</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型
	*/
	@Override
	public int getSmartcurtainPositionParameterIsValid(String deviceId) {
		if(isSmartcurtainExist(deviceId) && null != smartcurtainControl) {
			return smartcurtainControl.getPositionParameterIsValid();
		}
		return -1;
	}

	/**
	* <p>Title: getSmartcurtainPositionStatus</p>
	* <p>Description: 获取窗帘当前的定点位置</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型 [0-16]
	*/
	@Override
	public int getSmartcurtainPositionStatus(String deviceId) {
		if(isSmartcurtainExist(deviceId) && null != smartcurtainControl) {
			return smartcurtainControl.getPositionStatus();
		}
		return -1;
	}

	/**
	* <p>Title: getSmartcurtainIsPeripheralsCommunicationError</p>
	* <p>Description: 获取窗帘转换板通信错误</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型:0为正常，1为通信错误
	*/
	@Override
	public int getSmartcurtainIsPeripheralsCommunicationError(String deviceId) {
		if(isSmartcurtainExist(deviceId) && null != smartcurtainControl) {
			return smartcurtainControl.getIsPeripheralsCommunicationError();
		}
		return -1;
	}


	/*********************************** 氛围灯 *******************************************/	
	/**
	* <p>Title: setSmartlightPower</p>
	* <p>Description: 设置氛围灯电源(此方法未实现)</p>
	* @param deviceId:设备ID(String类型)
	* @param power:开关(int类型) [0/1]
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public byte[] setSmartlightPower(String deviceId, int power) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			byte[] message = smartlightControl.setPower(power);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setSmartlightBrightness</p>
	* <p>Description: 设置氛围灯的亮度</p>
	* @param deviceId:设备ID(String类型)
	* @param brightnessValue:亮度值(int类型) [0-100]
	* @return 成功或失败(byte[]类型)
	*/
	@Override
	public byte[] setSmartlightBrightness(String deviceId, int brightnessValue) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			byte[] message = smartlightControl.setBrightness(brightnessValue);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setSmartlightRGB</p>
	* <p>Description: 设置氛围灯的三原色</p>
	* @param deviceId:设备ID(String类型)
	* @param redValue:红色(int类型) [0-255]
	* @param greenValue:绿色(int类型) [0-255]
	* @param blueValue:蓝色(int类型) [0-255]
	* @return 成功或失败(byte[]类型)
	*/
	@Override
	public byte[] setSmartlightRGB(String deviceId, int redValue, int greenValue, int blueValue) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			byte[] message = smartlightControl.setRGB(redValue, greenValue, blueValue);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setSmartlightAirQualityLevel</p>
	* <p>Description: 设置氛围灯的空气状况</p>
	* @param deviceId:设备ID(String类型)
	* @param airQualityLevel:控制质量等级(int类型) 3 优、2 良、1 一般
	* @return 成功或失败(byte[]类型)
	*/
	@Override
	public byte[] setSmartlightAirQualityLevel(String deviceId, int airQualityLevel) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			byte[] message = smartlightControl.setAirQualityLevel(airQualityLevel);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setSmartlightColorTemperature</p>
	* <p>Description: 设置氛围灯色温(此方法未实现)</p>
	* @param deviceId:设备ID(String类型)
	* @param colorTemperatureValue:色温(int类型) [0-65535]
	* @return 成功或失败(byte[]类型)
	*/
	@Override
	public byte[] setSmartlightColorTemperature(String deviceId, int colorTemperatureValue) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			byte[] message = smartlightControl.setColorTemperature(colorTemperatureValue);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setSmartlightDeviceStatus</p>
	* <p>Description: 设置氛围灯的状态</p>
	* @param deviceId:设备ID(String类型)
	* @param deviceStatus:设备状态(int类型)
	* @return 成功或失败(byte[]类型)
	*/
	@Override
	public byte[] setSmartlightDeviceStatus(String deviceId, int deviceStatus) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			byte[] message = smartlightControl.setDeviceStatus(deviceStatus);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: getSmartlightOnlineStatus</p>
	* <p>Description: 获取氛围灯的在线状态</p>
	* @param deviceId:设备ID(String类型)
	* @return 成功或失败(boolean类型)
	*/
	@Override
	public boolean getSmartlightOnlineStatus(String deviceId) {
		return isSmartlightExist(deviceId);
	}
	
	/**
	* <p>Title: getSmartlightPower</p>
	* <p>Description: 获取氛围灯的开关状态(此方法未实现)</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型 [0/1]
	*/
	@Override
	public int getSmartlightPower(String deviceId) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			return smartlightControl.getPower();
		}
		return -1;
	}

	/**
	* <p>Title: getSmartlightRGBSetValid</p>
	* <p>Description: 获取氛围灯的RGB值是否有效</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型
	*/
	@Override
	public int getSmartlightRGBSetValid(String deviceId) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			return smartlightControl.getRGBSetValid();
		}
		return -1;
	}

	/**
	* <p>Title: getSmartlightRedValue</p>
	* <p>Description: 获取氛围灯的红色值</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型 [0-255]
	*/
	@Override
	public int getSmartlightRedValue(String deviceId) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			return smartlightControl.getRedValue();
		}
		return -1;
	}

	/**
	* <p>Title: getSmartlightGreenValue</p>
	* <p>Description: 获取氛围灯的绿色值</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型 [0-255]
	*/
	@Override
	public int getSmartlightGreenValue(String deviceId) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			return smartlightControl.getGreenValue();
		}
		return -1;
	}

	/**
	* <p>Title: getSmartlightBlueValue</p>
	* <p>Description: 获取氛围灯的蓝色值</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型 [0-255]
	*/
	@Override
	public int getSmartlightBlueValue(String deviceId) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			return smartlightControl.getBlueValue();
		}
		return -1;
	}

	/**
	* <p>Title: getSmartlightColorTemperatureValid</p>
	* <p>Description: 获取氛围灯的色温值是否有效(此方法未实现)</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型
	*/
	@Override
	public int getSmartlightColorTemperatureValid(String deviceId) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			return smartlightControl.getColorTemperatureValid();
		}
		return -1;
	}

	/**
	* <p>Title: getSmartlightColorTemperatureValue</p>
	* <p>Description: 获取氛围灯的色温值(此方法未实现)</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型[0-65535]
	*/
	@Override
	public int getSmartlightColorTemperatureValue(String deviceId) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			return smartlightControl.getColorTemperatureValue();
		}
		return -1;
	}

	/**
	* <p>Title: getSmartlightBrightnessValid</p>
	* <p>Description: 获取氛围灯的亮度值是否有效</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型
	*/
	@Override
	public int getSmartlightBrightnessValid(String deviceId) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			return smartlightControl.getBrightnessValid();
		}
		return -1;
	}

	/**
	* <p>Title: getSmartlightBrightnessValue</p>
	* <p>Description: 获取氛围灯的亮度值</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型 [0-100]
	*/
	@Override
	public int getSmartlightBrightnessValue(String deviceId) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			return smartlightControl.getBrightnessValue();
		}
		return -1;
	}

	/**
	* <p>Title: getSmartlightDeviceStatusValid</p>
	* <p>Description: 获取氛围灯的状态是否有效</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型
	*/
	@Override
	public int getSmartlightDeviceStatusValid(String deviceId) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			return smartlightControl.getDeviceStatusValid();
		}
		return -1;
	}

	/**
	* <p>Title: getSmartlightDeviceStatus</p>
	* <p>Description: 获取氛围灯的状态</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型 (0 为正常，1 为掉线)
	*/
	@Override
	public int getSmartlightDeviceStatus(String deviceId) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			return smartlightControl.getDeviceStatus();
		}
		return -1;
	}

	/**
	* <p>Title: getSmartlightAirStatusValid</p>
	* <p>Description: 获取氛围灯的空气状况是否有效</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型 (0 为有效，1 为无效)
	*/
	@Override
	public int getSmartlightAirStatusValid(String deviceId) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			return smartlightControl.getAirStatusValid();
		}
		return -1;
	}

	/**
	* <p>Title: getSmartlightAirStatus</p>
	* <p>Description: 获取氛围灯的空气状况</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型 (3 优、2 良、1 一般)
	*/
	@Override
	public int getSmartlightAirStatus(String deviceId) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			return smartlightControl.getAirStatus();
		}
		return -1;
	}
	
	/**
	* <p>Title: getSmartlightIsPeripheralsCommunicationError</p>
	* <p>Description: 获取氛围灯转换板通信错误</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型:0为正常，1为通信错误
	*/
	@Override
	public int getSmartlightIsPeripheralsCommunicationError(String deviceId) {
		if(isSmartlightExist(deviceId) && null != smartlightControl) {
			return smartlightControl.getIsPeripheralsCommunicationError();
		}
		return -1;
	}


	/*********************************** 电量计 *******************************************/
	/**
	* <p>Title: setVoltameterPower</p>
	* <p>Description: 设置电量计开关</p>
	* @param deviceId:设备ID(String类型)
	* @param power:开关(int类型)
	* @return 成功或失败
	*/
	@Override
	public byte[] setVoltameterPower(String deviceId, int power) {
		if(isVoltameterExist(deviceId) && null != voltameterControl) {
			byte[] message = voltameterControl.setPower(power);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: setVoltameterResetCount</p>
	* <p>Description: 设置电量统计清零</p>
	* @param deviceId:设备ID(String类型)
	* @param isResetCount:是否清零(int类型)
	* @return 成功或失败
	*/
	@Override
	public byte[] setVoltameterResetCount(String deviceId, int isResetCount) {
		if(isVoltameterExist(deviceId) && null != voltameterControl) {
			byte[] message = voltameterControl.setResetCount(isResetCount);
			if(null != message) {
				return sendMessageWithMqtt(deviceId, message);
			}
		}
		return errorByte;
	}

	/**
	* <p>Title: getVoltameterPower</p>
	* <p>Description: 获取电量计总电源开关状态</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型
	*/
	@Override
	public int getVoltameterPower(String deviceId) {
		if(isVoltameterExist(deviceId) && null != voltameterControl) {
			return voltameterControl.getPower();
		}
		return -1;
	}

	/**
	* <p>Title: getVoltameterCurrentValue</p>
	* <p>Description: 获取电量计电流值uA</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型
	*/
	@Override
	public int getVoltameterCurrentValue(String deviceId) {
		if(isVoltameterExist(deviceId) && null != voltameterControl) {
			return voltameterControl.getCurrentValue();
		}
		return -1;
	}

	/**
	* <p>Title: getVoltameterVoltageValue</p>
	* <p>Description: 获取电量计电压值mV</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型
	*/
	@Override
	public int getVoltameterVoltageValue(String deviceId) {
		if(isVoltameterExist(deviceId) && null != voltameterControl) {
			return voltameterControl.getVoltageValue();
		}
		return -1;
	}

	/**
	* <p>Title: getVoltameterQuantityValue</p>
	* <p>Description: 获取电量计电量值的统计</p>
	* @param deviceId:设备ID(String类型)
	* @return long类型
	*/
	@Override
	public long getVoltameterQuantityValue(String deviceId) {
		if(isVoltameterExist(deviceId) && null != voltameterControl) {
			return voltameterControl.getVoltameterValue();
		}
		return -1;
	}

	/**
	* <p>Title: getVoltameterIsPeripheralsCommunicationError</p>
	* <p>Description: 获取电量计转换板通信错误</p>
	* @param deviceId:设备ID(String类型)
	* @return int类型:0为正常，1为通信错误
	*/
	@Override
	public int getVoltameterIsPeripheralsCommunicationError(String deviceId) {
		if(isVoltameterExist(deviceId) && null != voltameterControl) {
			return voltameterControl.getIsPeripheralsCommunicationError();
		}
		return -1;
	}


	/***********************************设备控制接口 end****************************************/


}
