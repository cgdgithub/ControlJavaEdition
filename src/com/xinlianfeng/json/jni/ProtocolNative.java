package com.xinlianfeng.json.jni;

public class ProtocolNative {

	static {
		try {
			System.loadLibrary("json-jni");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* 查询版本信息 */
	public static native String protocolGetVersion();

	/* 直接将JSON字符串解析成设备的十六进制字符串，传进去的JSON主要是为了库解析成设备协议用 */
	/**
	 * 
	 * @param jsonStr
	 * @param frameSeq
	 *            固定为0
	 * @param device_type
	 * @param deviceSubAddr
	 * @param moblie_type
	 * @param moblie_address
	 * @return
	 */
	public static native String jsonBuildFrame(String jsonStr, int frameSeq, int device_type, int deviceSubAddr,
			int moblie_type, int moblie_address);

	/**
	 * 
	 * @param jsonStr
	 *            jsonCreatePassThrough的返回
	 * @param magic
	 *            0x66bb
	 * @param enctype
	 *            0
	 * @param cmdtype
	 *            0
	 * @return
	 */
	public static native byte[] jsonBuildhead(String jsonStr, int magic, int enctype, int cmdtype);

	/** 设备返回的十六进制字符串解析成JSON字符串，这个JSON为解析返回结果的JSON */
	public static native String jsonParseFrame(String jsonStr, int device_type);

	/** 直接将从网络上接收的数据用来解析生成JSON字符串，这个JSON为解析返回结果的JSON */
	public static native String bytesParseFrame(byte[] recv, int device_type);

	/** 原来库中含有的CRC8算法，返回十六进制字符串 */
	public static native String crc8Data(byte[] in, String strCrc);

	/** 最终生成PassThrough的数据，然后结合 jsonBuildhead 则可以发送WIFI识别的网络包 */
	/**
	 * 
	 * @param pack_seq
	 *            包序号，可以传0
	 * @param ack_flag
	 * @param passData
	 *            jsonBuildFrame的返回
	 * @return
	 */
	public static native String jsonCreatePassThrough(int pack_seq, int ack_flag, String passData);

	/**
	 * 解析接收数据 对应的设备类型
	 * 
	 * @param receiveF4F5String
	 * @return
	 */
	public static native String getSourceDeviceType(String receiveF4F5String);

	/**
	 * 解析发送数据 对应的设备类型
	 * 
	 * @param sendF4F5String
	 * @return
	 */
	public static native String getDestinationDeviceType(String sendF4F5String);
}