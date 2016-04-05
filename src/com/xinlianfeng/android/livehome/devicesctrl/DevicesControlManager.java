package com.xinlianfeng.android.livehome.devicesctrl;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

//import android.text.TextUtils;

import com.xinlianfeng.android.livehome.devices.aircleaner.AirCleanerControl;
import com.xinlianfeng.android.livehome.devices.aircondition.AirConditionControl;
import com.xinlianfeng.android.livehome.devices.airfan.AirFanControl;
import com.xinlianfeng.android.livehome.devices.base.IDevicesControl;
import com.xinlianfeng.android.livehome.devices.dehumidifier.DehumidifierControl;
import com.xinlianfeng.android.livehome.devices.sensorsfourinone.SensorsFourInOneControl;
import com.xinlianfeng.android.livehome.devices.smartcurtain.SmartCurtainControl;
import com.xinlianfeng.android.livehome.devices.smartlight.SmartLightControl;
import com.xinlianfeng.android.livehome.devices.voltameter.VoltameterControl;
//import com.xinlianfeng.android.livehome.devices.wificontrol.WifiControl;
import com.xinlianfeng.android.livehome.util.Constants;
//import com.xinlianfeng.android.livehome.util.LogUtils;

public class DevicesControlManager {
	private static final String TAG = "DevicesControlManager";

	private static DevicesControlManager instance = null;
	private ConcurrentHashMap<String, DeviceInfo> deviceInfoMap = null;

	public class DeviceInfo {
		public IDevicesControl devicesControl = null;
//		public WifiControl wifiControl = null;
		public int onlineStat = Constants.STATUS_OFF_LINE;
		public int strType = 0;
		public int networkType = -1;
		public int reconnectCount = 3;
		public volatile long lastTime = System.currentTimeMillis();
		public ArrayList<String> addressList = null;
		public boolean isNeedConnect = false;
		public volatile boolean isConnect = false;
		public boolean isNeedUpgrade = false;
		public String wifiName = null;
		public String localIp = null;
		public String ip = null;
		public int port = Constants.MODULE_PORT;
		public String version = null;
		public String lastCmd = null;
		public Thread updateT = null;
		public Thread devDiscoveryThread = null;
		public Thread updateWANThread = null;
		public Thread upgradeCheckThread = null;
	}

	/** 单例 */
	private DevicesControlManager() {
		if(null == deviceInfoMap) {
			deviceInfoMap = new ConcurrentHashMap<String, DeviceInfo>();
		}
	}

	public static DevicesControlManager getInstance() {
		if(null == instance) {
			instance = new DevicesControlManager();
		}
		return instance;
	}

	public ConcurrentHashMap<String, DeviceInfo> getDeviceInfoMap() {
		return deviceInfoMap;
	}
	
	/************************************************************************************/

	/**
	* <p>Title: setDeviceInfo</p>
	* <p>Description: 设置设备控制类相关信息</p>
	* @param deviceId:设备ID(String类型)
	* @param deviceInfo:控制类信息(DeviceInfo类型)
	*/
	public void setDeviceInfo(String deviceId, DeviceInfo deviceInfo) {
		if(null != deviceId && null != deviceInfoMap) {
			if(deviceInfoMap.containsKey(deviceId)) {
				deviceInfoMap.put(deviceId, deviceInfo);
			}
		}
	}

	/**
	* <p>Title: getDeviceInfo</p>
	* <p>Description: 获取设备控制类相关信息</p>
	* @param deviceId: 设备ID(String类型)
	* @return 控制类信息
	*/
	public DeviceInfo getDeviceInfo(String deviceId) {
		if(null != deviceInfoMap && null != deviceId) {
			if(deviceInfoMap.containsKey(deviceId)) {
				return deviceInfoMap.get(deviceId);
			}
		}
		return null;
	}

	/**
	* <p>Title: delDevicesControl</p>
	* <p>Description: 删除设备控制类信息</p>
	* @param deviceId:设备ID(String类型)
	*/
	public void delDevicesControl(String deviceId) {
		DeviceInfo deviceInfo = getDeviceInfo(deviceId);
		if(null != deviceInfo) {
			System.out.println(TAG + ", " + "device " + "del devices control " + deviceId + " ... ");
			deviceInfo.devicesControl = null;
//			deviceInfo.wifiControl = null;
			deviceInfoMap.remove(deviceId);
		}
	}

	/**
	* <p>Title: initDevicesControl</p>
	* <p>Description: 创建设备控制类信息</p>
	* @param deviceId:设备ID(String类型)
	* @param deviceType:设备类型(String类型)
	*/
	public void initDevicesControl(String deviceId, String deviceType) {
		if((deviceId != null && deviceId != "") || (deviceType != null && deviceType != "")) {
			return;
		}
		DeviceInfo deviceInfo = getDeviceInfo(deviceId);
		if(null == deviceInfo) {
			deviceInfo = new DeviceInfo();

			if(deviceType.equals(Constants.AIRCON_TYPE)) {
				deviceInfo.devicesControl = new AirConditionControl();// 空调
				deviceInfo.strType = Constants.AIRCON_TYPE_ADDR;
			} else if(deviceType.equals(Constants.DEHUMIDIFIER_TYPE)) {
				deviceInfo.devicesControl = new DehumidifierControl();// 除湿机
				deviceInfo.strType = Constants.DEHUMIDIFIER_TYPE_ADDR;
			} else if(deviceType.equals(Constants.AIRCLEANER_TYPE)) {
				deviceInfo.devicesControl = new AirCleanerControl();// 空气净化器
				deviceInfo.strType = Constants.AIRCLEANER_TYPE_ADDR;
			} else if(deviceType.equals(Constants.AIRFAN_TYPE)) {
				deviceInfo.devicesControl = new AirFanControl();// 新风机
				deviceInfo.strType = Constants.AIRFAN_TYPE_ADDR;
			} else if(deviceType.equals(Constants.SENSORS_TYPE)) {
				deviceInfo.devicesControl = new SensorsFourInOneControl();// 四合一传感器
				deviceInfo.strType = Constants.SENSORS_TYPE_ADDR;
			} else if(deviceType.equals(Constants.SMARTLIGHT_TYPE)) {
				deviceInfo.devicesControl = new SmartLightControl();// 呼吸灯
				deviceInfo.strType = Constants.SMARTLIGHT_TYPE_ADDR;
			} else if(deviceType.equals(Constants.SMARTCURTAIN_TYPE)) {
				deviceInfo.devicesControl = new SmartCurtainControl();// 窗帘
				deviceInfo.strType = Constants.SMARTCURTAIN_TYPE_ADDR;
			} else if(deviceType.equals(Constants.VOLTAMETER_TYPE)) {
				deviceInfo.devicesControl = new VoltameterControl();// 电量计
				deviceInfo.strType = Constants.VOLTAMETER_TYPE_ADDR;				
			} else {
				return;
			}

//			deviceInfo.wifiControl = new WifiControl();
			deviceInfo.isConnect = false;
			deviceInfoMap.put(deviceId, deviceInfo);
		}
	}

	/**
	* <p>Title: cleanAllControl</p>
	* <p>Description: 删除所有的设备控制类</p>
	*/
	public void cleanAllControl() {
		if(null != deviceInfoMap && deviceInfoMap.size() > 0) {
			for (String id : deviceInfoMap.keySet()) {
				DeviceInfo deviceInfo = deviceInfoMap.get(id);
				if(null != deviceInfo) {
					deviceInfo.devicesControl = null;
//					deviceInfo.wifiControl = null;
					deviceInfoMap.remove(id);
				}
			}
		}
	}

}
