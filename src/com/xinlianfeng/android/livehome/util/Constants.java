package com.xinlianfeng.android.livehome.util;

//import android.os.Environment;

public class Constants {
	/** BOX默认ID */
	public static final String DEFAULT_BOXID = "CMD-W01-H-R0020000000";

	/** smartbox 使用的AT指令 */
	public static final String CMD_TO_BOX = "AT+SBOX";
	public static final String CMD_TO_BOX_GETALLSTATUS = "AT+SBOXSQ";
	public static final String CMD_TO_BOX_SETWORKMODE = "AT+SBOXSWM";
	public static final String CMD_TO_BOX_SETEXPERTMODE = "AT+SBOXSEM";
	public static final String CMD_TO_BOX_SETPOWERSTATUS = "AT+SBOXSPM";
	public static final String CMD_TO_BOX_UPDATE_EXPERTINFO = "AT+SBOXUEI";
	public static final String CMD_TO_BOX_UNBINDER = "AT+SBOXUNB";
	public static final String CMD_TO_BOX_DEVICES_UNBINDER = "AT+SBOXDUB";
	public static final String CMD_TO_BOX_TEST_MODE = "AT+SBOXTEST";
	public static final String CMD_TO_BOX_TEST_RET = "AT+SBOXTSRET";
	public static final String CMD_TO_BOX_TEST_SETTIME = "AT+SBOXTST";
	public static final String CMD_TO_BOX_TEST_SETOUTTEM = "AT+SBOXTSOT";
	public static final String CMD_TO_BOX_TEST_SETCO2 = "AT+SBOXSCO2";
	public static final String CMD_TO_BOX_TEST_SETAIRCLEANLINESS = "AT+SBOXSACL";
	public static final String CMD_TO_BOX_TEST_HEARTBEAT = "AT+SBOXHEB";
	public static final String CMD_TO_BOX_TEST_EXECUTE = "AT+SBOXEXE";
	public static final String CMD_TO_BOX_TEST_CONFIG_MODULE = "AT+SBOXTCM";
	public static final String CMD_TO_BOX_TEST_IF_CONFIG = "AT+SBOXTIC";
	public static final String CMD_TO_BOX_TEST_CONFIG_RESULT = "AT+SBOXTCR";

	public static final String BOX_RETURN_GETALLSTATUS = "+SBOXSQ:";
	public static final String BOX_RETURN_SETWORKMODE = "+SBOXSWM:";
	public static final String BOX_RETURN_SETEXPERTMODE = "+SBOXSEM:";
	public static final String BOX_RETURN_SETPOWERSTATUS = "+SBOXSPM:";
	public static final String BOX_RETURN_UPDATE_EXPERTINFO = "+SBOXUEI:";
	public static final String BOX_RETURN_UNBINDER = "+SBOXUNB:";
	public static final String BOX_RETURN_DEVICES_UNBINDER = "+SBOXDUB:";
	public static final String BOX_RETURN_TEST_MODE = "+SBOXTEST:";
	public static final String BOX_RETURN_TEST_RET = "+SBOXTSRET:";
	public static final String BOX_RETURN_TEST_SETTIME = "+SBOXTST:";
	public static final String BOX_RETURN_TEST_SETOUTTEM = "+SBOXTSOT:";
	public static final String BOX_RETURN_TEST_HEARTBEAT = "+SBOXHEB:";
	public static final String BOX_RETURN_TEST_SETCO2 = "+SBOXSCO2:";
	public static final String BOX_RETURN_TEST_SETAIRCLEANLINESS = "+SBOXSACL:";
	public static final String BOX_RETURN_TEST_EXECUTE = "+SBOXEXE:";
	public static final String BOX_RETURN_TEST_CONFIG_MODULE = "+SBOXTCM:";
	public static final String BOX_RETURN_TEST_IF_CONFIG= "+SBOXTIC:";
	public static final String BOX_RETURN_TEST_CONFIG_RESULT = "+SBOXTCR:";
	
	/** 设备地址和类型 */
	public static final int AIRCON_TYPE_ADDR = 0x01;
	public static final int DEHUMIDIFIER_TYPE_ADDR = 0x15;
	public static final int HOTFAN_TYPE_ADDR = 0x19;
	public static final int AIRCLEANER_TYPE_ADDR = 0x18;
	public static final int SENSORS_TYPE_ADDR = 0x53;
	public static final int SMARTBOX_TYPE_ADDR = 0x88;	
	public static final int AIRFAN_TYPE_ADDR = 0x19;
	public static final int SMARTCURTAIN_TYPE_ADDR = 0x55;	
	public static final int SMARTLIGHT_TYPE_ADDR = 0x52;
	public static final int VOLTAMETER_TYPE_ADDR = 0x51;
	
	public static final String AIRCON_TYPE = "aircon";
	public static final String DEHUMIDIFIER_TYPE = "dehumidifier";
	public static final String HOTFAN_TYPE = "hotfan";
	public static final String AIRCLEANER_TYPE = "aircleaner";
	public static final String SENSORS_TYPE = "sensors";
	public static final String AIRFAN_TYPE = "airfan";
	public static final String SMARTCURTAIN_TYPE = "smartcurtain";
	public static final String SMARTLIGHT_TYPE = "smartlight";
	public static final String VOLTAMETER_TYPE = "voltameter";
	
	/** 专家模式、空气品质，设备状态 */
	public static final String errorValueStr = "10000";
	public static final int errorValueInt = 10000;
	public static final float errorValueFloat = 10000;

	public static final String STANDARD_EXPERT_MODE = "Standard";
	public static final String CHILDREN_EXPERT_MODE = "Child";
	public static final String ELDER_EXPERT_MODE = "Old";
	public static final String OFF_EXPERT_MODE = "Off";

	public static final String MUTE_WORK_MODE = "mute";
	public static final String SLEEP_WORK_MODE = "sleep";
	public static final String NORMAL_WORK_MODE = "normal";
	
	public static final String AIR_QUALITY_GOOD = "AIR_QUALITY_GOOD";
	public static final String AIR_QUALITY_GENERAL = "AIR_QUALITY_GENERAL";
	public static final String AIR_QUALITY_BAD = "AIR_QUALITY_BAD";

	public static final String AIR_COMFORT_GOOD = "AIR_COMFORT_GOOD";
	public static final String AIR_COMFORT_GENERAL = "AIR_COMFORT_GENERAL";
	public static final String AIR_COMFORT_BAD = "AIR_COMFORT_BAD";

	public static final String NOSA_SA_MODE = "nosa";
	public static final String CONTROLLABLE_SA_MODE = "controllable";
	public static final String UNCONTROLLABLE_SA_MODE = "uncontrollable";
	public static final String OFFLINE_SA_MODE = "offline";
	public static final String OTAUPDATE_SA_MODE = "otaupdate";
	
	/** WIFI状态̬ */
	public static final String WIFI_NAME_KEY = "wifiName";
	public static final String WIFI_PASSWORD_KEY = "wifiPassword";
	public static final String WIFI_LOCALIP_KEY = "localIp";
	public static final String WIFI_STATUS_UNKNOWN = "unknown";
	public static final String WIFI_STATUS_CONNECTED = "connected";
	public static final String WIFI_STATUS_CONNECTING = "connecting";
	public static final String WIFI_STATUS_UNCONNECT = "unconnected";
	public static final String WIFI_STATUS_AP = "ap";
	public static final String WIFI_STATUS_UNLOCK = "UNLOCK";
	
	/** AT指令 */
	public static final String AT_COMMAND_RETURN_SUCCESS = "SUCCEED";
	public static final String AT_COMMAND_RETURN_FAIL = "ERROR";
	public static final String CMD_AT_MARK = "AT+";
	public static final String CMD_AT_MARK_ADD = "+";
	public static final String CMD_AT_WRAP = "\r\n";
	public static final String CMD_AT_COLON = ":";
	public static final String CMD_AT_EQUALS_SINGNAL = "=";
	public static final String CMD_AT_GET_STATUS_MARK = "?";
	
	/** 网络连接类型 */
	public static final int STATUS_OFF_LINE = 0;
	public static final int STATUS_ON_LINE = 1;
	public static final int STATUS_ON_LOCAL = 2;
	public static final int MODULE_PORT = 8888;
	public static final int SMARTBOX_PORT = 9999;
	public static final String WIFI_AP_SERVER_IP = "192.168.1.10";
	public static final String BOX_DEFAULT_AP_PASSWORD = "12345678";
	public static final String WIFI_DEFAULT_AP_PASSWORD = "12345678";
	
	/** handler消息处理 */
	public static final int MSG_SMARTBOX_CONNECTED_ROUTER = 201;
	public static final int MSG_SMARTBOX_LOGIN_SUCCEED = 202;
	public static final int MSG_SMARTBOX_LOGIN_FAILED = 207;
	public static final int MSG_SMARTBOX_GETINFO_SUCCEED = 203;
	public static final int MSG_SMARTBOX_UNCONNECTED_ROUTER = 204;
	public static final int MSG_SMARTBOX_SHOW_TIPS = 205;
	public static final int MSG_SMARTBOX_CREATE_MQTT = 206;
	public static final int MSG_GET_APPLIANCE_RESULT = 128;
	public static final String APPLIANCE_APPLIANCE_ID = "appliance_id";
	public static final String APPLIANCE_APPLIANCE_CMD = "appliance_cmd";
	public static final String APPLIANCE_APPLIANCE_RESULT = "appliance_result";
	
	public static final String MQTT_CLIENT = "mqtt_client";
	
	/** restful 常量 */
	public static final String MSG_RESTFUL_FLAG = "flag";
	public static final String MSG_RESTFUL_KEY = "key";
	public static final String MSG_RESTFUL_CODE = "code";
	public static final String MSG_RESTFUL_MESS = "mess";
	public static final String MSG_RESTFUL_JSON = "json";
	public static final int MSG_RESTFUL_ID = 0x8001;
	public static final int MSG_PARAM_ERROR = 0x8002;
	public static final String PARAM_ERROR = "param_error";
	
	public static final String PARAM_CLIENT_ID = "client_id";
	public static final String PARAM_CLIENT_SECRET = "client_secret";
	public static final String PARAM_GRANT_TYPE = "grant_type";
	public static final String PARAM_SCOPE = "scope";
	public static final String APP_CLIENT_ID = "app";
	public static final String APP_CLIENT_SECRET = "android";
	public static final String APP_GRANT_TYPE = "password";
	public static final String APP_SCOPE = "read write";
	public static final String BOX_CLIENT_ID = "box";
	public static final String BOX_CLIENT_SECRET = "boxsecurity";
	public static final String BOX_GRANT_TYPE = "password";
	public static final String BOX_SCOPE = "read write";
	public static final String PARAM_NAME = "username";
	public static final String PARAM_PASSWORD = "password";
	public static final String PARAM_AVATAR = "avatar";
	public static final String PARAM_NICKNAME = "nickname";
	public static final String PARAM_REALNAME = "realname";
	public static final String PARAM_SIGNATURE = "personsignature";
	public static final String PARAM_PERSONDESC = "personDesc";
	public static final String PARAM_GENDER = "gender";
	public static final String PARAM_BIRTHDAY = "birthday";
	public static final String PARAM_MOBLIE_PHONE = "mobliephone";
	public static final String PARAM_TEL_PHONE = "telphone";
	public static final String PARAM_EMAIL = "email";
	public static final String PARAM_SAMPLE_ADDRESS = "sampleaddress";
	public static final String PARAM_DETAIL_ADDRESS = "detailaddress";
	public static final String PARAM_OLD_PASSWD = "oldpasswd";
	public static final String PARAM_NEW_PASSWD = "newpasswd";
	public static final String PARAM_PHONE_NAME = "photoname";
	public static final String PARAM_HOUSE_OWNER = "houseowner";
	public static final String PARAM_HOUSE_OWNER_UP = "houseOwner";
	public static final String PARAM_PHONE_FORMAT = "photoformat";
	public static final String PARAM_ICON = "icon";
	public static final String PARAM_SAMPLE_ADDRESS_UP = "simpleAddress";
	public static final String PARAM_DETAIL_ADDRESS_UP = "detailAddress";
	public static final String PARAM_HOUSE_NAME = "houseName";
	public static final String PARAM_HOUSE_ID = "houseId";
	public static final String PARAM_ROOM_NAME = "roomName";
	public static final String PARAM_ROOM_ID = "roomId";
	public static final String PARAM_PIC_URL = "picUrl";
	public static final String PARAM_MODULE_NO = "moduleNo";
	public static final String PARAM_APPLIANCE_ID = "applianceId";
	public static final String PARAM_MODULENO = "moduleno";
	public static final String PARAM_MODULE_TYPE = "moduletype";
	public static final String PARAM_APPLIANCEVALUE = "applianceValue";
	public static final String PARAM_APPLIANCETYPE = "applianceType";
	public static final String PARAM_GUESTID = "guestId";

	public static final String PARAM_MODULE_HOUR = "modulehour";
	public static final String PARAM_MODULE_KH = "modulekh";
	public static final String PARAM_MODULE_ONLINE = "online";
	public static final String PARAM_MODULE_CONTROL = "control";
	
	public static final String PARAM_SEASON_ID = "seasonid";
	public static final String PARAM_REGION_ID = "regionid";
	public static final String PARAM_EXPERT_ID = "expertid";
	public static final String PARAM_EXPERT_ID1 = "expertId";
	public static final String PARAM_EXPERT_MODEL_ID = "expertModeId";
	public static final String PARAM_EXPERT_MODE_NAME = "expertModeName";
	public static final String PARAM_EXPERT_TEMP = "expertTemp";
	public static final String PARAM_MANUAL_TEMP = "manualTemp";
	public static final String PARAM_MANUAL_HUMI = "manualHumi";
	public static final String PARAM_EXPERT_HUMI = "expertHumi";
	public static final String PARAM_TIME_STAMP = "timestamp";
	
	public static final String PARAM_AIRLIGHT_STATUS = "airLightStatus";
	public static final String PARAM_SMARTCURTAIN_STATUS = "smartcurtainstatus";
	public static final String PARAM_SMARTCURTAIN_POSITION = "smartcurtainposition";
	
	public static final String PARAM_SMARTBOX_LOGIN_ID = "smartboxid";
	public static final String PARAM_SMARTBOX_ID = "smartoxModuleNo";
	public static final String PARAM_TOKEN_ID = "tokenid";
	public static final String PARAM_AIR_QUALITY = "airquality";
	public static final String PARAM_INDOOR_HUMI = "indoorhumi";
	public static final String PARAM_INDOOR_TEMP = "indoortemp";
	public static final String PARAM_INDOOR_HCHO = "indoorhcho";
	public static final String PARAM_INDOOR_PM25 = "indoorpm2dot5";
	public static final String PARAM_INDOOR_CO2 = "indoorco2";
	
	public static final String PARAM_BESPEAK_STOPTTIME = "endtime";
	public static final String PARAM_BESPEAK_STATUS = "bespeakStatus";
	public static final String PARAM_FAMILYID = "familyId";
	public static final String PARAM_BESPEAK_APPLIANCEID = "applianceId";
	public static final String PARAM_BESPEAKTIMESTAMP = "bespeakTimeStamp";
	public static final String PARAM_BESPEAKID = "bespeakid";
	public static final String PARAM_IMAGESTR = "imagestr";
	public static final String PARAM_IMAGENAME = "imagename";
	public static final String PARAM_FILE_TYPE = "fileType";
	public static final String PARAM_FILE_NAME = "fileName";
	public static final String PARAM_FILE_DATA = "fileData";
	public static final String PARAM_IMAGETYPE = "functype";
	public static final String PARAM_QUICKMARKRESULT = "quickmarkresult";
	public static final String PARAM_ROOMOWNERID = "roomownerid";
	public static final String PARAM_SHAREROOMID = "shareroomid";
	public static final String PARAM_SHAREROOMLIMITTIME = "sharelimittime";
	
	public static final String PARAM_SHAREUSERPOSSID = "shareroomuserpossid";
	public static final String PARAM_SHAREREMARKNAME = "remarkname";
	public static final String PARAM_SHAREPOWERDATA = "sharepowerdata";
	public static final String PARAM_SHAREID = "shareid";
	public static final String ACCESS_TOKEN = "access_token";
	public static final String ASYNC_FLAG = "async";
	
	/** box UI*/
	public static int SCREEN_WIDTH = 720;
	public static int SCREEN_HEIGHT = 1280;
	
	/** CDN portel 地址 */
//	//172 portel
//	public static final String URL_PORTAL = "http://portal.topfuturesz.com:6819/PortalServer/Server";
//	public static final String URL_UPDATE = "http://portal.topfuturesz.com:6819";
//
//	//179 cdn
//	public static final String CDN_HOST = "cdn.dns.topfuturesz.com";
//	public static final String CDN_PORT = "5820";

    //110 portel
    public static final String URL_PORTAL = "http://cdn1.topfuturesz.com:6819/PortalServer/Server";
    public static final String URL_UPDATE = "http://cdn1.topfuturesz.com:6819";

    //110 cdn
    public static final String CDN_HOST = "cdn1.topfuturesz.com";
    public static final int CDN_PORT = 5820;

//	//香港portel
//	public static final String URL_PORTAL = "http://119.28.2.248:6819/PortalServer/Server";
//	public static final String URL_UPDATE = "http://119.28.2.248:6819";
//
//	//香港cdn
//	public static final String CDN_HOST = "119.28.2.248";
//	public static final String CDN_PORT = "5820";
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public static final String BOOLEAN_TRUE = "1";
	public static final String BOOLEAN_FALSE = "0";

	public static final String CMD_TYPE = "cmdType";

	public static final int AT_COMMAND_MIN_LENGTH = 8;
	public static final String INTENT_PARAM_TIMER_TYPE = "timer_type";
	public static final String INTENT_PARAM_TIMER_ON_HOUR = "timer_on_hour";
	public static final String INTENT_PARAM_TIMER_ON_MINUTE = "timer_on_minute";
	public static final String INTENT_PARAM_TIMER_ON_POWER = "timer_on_power";
	public static final String INTENT_PARAM_TIMER_OFF_HOUR = "timer_off_hour";
	public static final String INTENT_PARAM_TIMER_OFF_MINUTE = "timer_off_minute";
	public static final String INTENT_PARAM_TIMER_OFF_POWER = "timer_off_power";
	public static final boolean CMD_MANUAL = true;

	
	public static final String PARAM_VALUE_SPLIT = ",";
	public static final String PARAM_PATH_FILE = "file://";
	public static final String PARAM_PATH_TYPE_FILE = "file";
	public static final String PARAM_PATH_TYPE_CONTENT = "content";

//	public static final String ImageSavePath = Environment
//			.getExternalStorageDirectory().getAbsolutePath() + "/DCIM/Camera";

	public static final String AT_PORTOCOL_SET_BOOLE_TRUE = "1";
	public static final String AT_PORTOCOL_SET_BOOLE_FALSE = "0";
	public static final String INTENT_PARAM_CDN_IP = "cdn_ip";
	public static final String INENT_PARAM_SCAN_CODE_RESULT = "barcode_result";
	public static final String AIRCON_CONTROL_TYPE_LOCAL = "local";
	public static final String AIRCON_CONTROL_TYPE_INTERNET = "cdn";
	public static final String INTENT_PARAM_CONTROL_TYPE = "control_type";
	public static final String INTENT_PARAM_APPLIANCE_ID = "appliance_id";
	public static final String INTENT_PARAM_APPLIANCE_MODEL = "appliance_model";
	public static final String INTENT_PARAM_APPLIANCE_IP = "appliance_ip";
	public static final String INTENT_PARAM_UNIQUE_IDENTIFIER = "user_unique_identifier";
	public static final String INTENT_PARAM_WEB_URL = "web_url";

	public static final String INTENT_PARAM_ROUTER_WIFI_NAME = "router_wifi_name";
	public static final String INTENT_PARAM_ONLINE = "appliance_online";
	public static final String INTENT_APPLIANCES_HOME_LIST = "action.appliance.home.list";
	public static final String INTENT_PARAM_WIND_MAGNITUDE = "wind_magnitude";
	public static final String INTENT_PARAM_SLEEP_MODE_POWER = "sleep_mode_power";
	public static final String INTENT_PARAM_SLEEP_MODE = "sleep_mode";
	public static final String INTENT_PARAM_WIND_DIRECT_UD_MODE = "direct_up_down_mode";
	public static final String INTENT_PARAM_WIND_DIRECT_LR_MODE = "direct_left_right_mode";
	public static final String INTENT_PARAM_MODEL_ID = "model_id";
	public static final String INTENT_PARAM_RUN_MODE = "run_mode";
	public static final String INTENT_PARAM_EXMINE_DATAS = "exmine_datas";
	public static final String INTENT_PARAM_EXMINE_RESULT = "exmine_result";
	public static final String INTENT_PARAM_TEMP_UNIT = "temp_unit";
	public static final String INTENT_PARAM_GROUP_NAME = "GROUP_NAME";
	public static final String INTENT_PARAM_LIVE_HOME = "LIVE_HOME";
	public static final String INTENT_PARAM_SMART_MODE_ID = "SMART_MODE_ID";

	public static final int APPLIANCE_RESULT_EXMINE = 1100;
	public static final String APPLIANCE_RESULT_PARAM = "result";
	public static final String APPLIANCE_POWER_PARAM = "power";
	public static final String APPLIANCE_ONLINE_PARAM = "online";
	public static final String APPLIANCE_MODE_PARAM = "mode";
	public static final String APPLIANCE_LOCALIP_PARAM = "localip";

	public static final int IMAGE_OUTPUT_X = 800;
	public static final int IMAGE_OUTPUT_Y = 800;

	public static final int RESULT_SLEEP_MODE_CODE = 200;
	public static final int RESULT_WIND_MAGNITUDE_CODE = 201;
	public static final int RESULT_POWER_ON_TIMER = 202;
	public static final int RESULT_POWER_OFF_TIMER = 203;
	public static final int RESULT_IMAGE_CAPTURE = 204;
	public static final int RESULT_IMAGE_SELECT = 205;
	public static final int RESULT_WIND_DIRECT_UP_DOWN = 206;
	public static final int RESULT_WIND_DIRECT_LEFT_RIGHT = 207;
	public static final int RESULT_SCAN_MODEL_CODE = 208;
	public static final int RESULT_SCAN_APPLIANCE_ID = 209;

	public static final int RESULT_USERAGREE_CHECKBOX = 210;
	public static final int RESULT_USERAGREE_CHECKBOX_UN = 211;
	public static final int RESULT_TEMP_UNIT_CODE = 212;
	public static final int RESULT_IMAGE_CROP = 213;
	public static final int RESULT_IMAGE_CROP_CONTENT = 214;

	public static final int RESULT_SCAN_WEB_URL = 215;
	/**
	 * 用户唯一标识符
	 */
	public static final int RESULT_SCAN_UNIQUE_IDENTIFIER = 216;

	public static final int MSG_DELETE_APPLIANCE_FAIL = 101;
	public static final int MSG_DELETE_APPLIANCE_SUCCESS = 102;
	public static final int MSG_PROCESS_UNBIND_APPLIANCE = 103;
	public static final int MSG_SET_AIRCON_POWER_RESULT = 104;
	public static final int MSG_SET_AIRCON_RUNMODE_RESULT = 105;
	public static final int MSG_GET_AIRCON_STATUS_FAIL = 106;
	public static final int MSG_GET_AIRCON_ONLINE_RESULT = 107;
	public static final int MSG_AIRCON_INIT_ERROR = 108;
	public static final int MSG_GET_WEATHER_FAIL = 109;
	public static final int MSG_GET_WEATHER_SUCCESS = 110;
	public static final int MSG_REFRESH_LIST_DATA = 111;
	public static final int MSG_GET_AIRCON_INDOOR_TEMPRATURE_RESULT = 112;
	public static final int MSG_GET_ALL_STATUS_ERROR = 113;
	public static final int MSG_INIT_APK_UPDATE = 114;
	public static final int MSG_INIT_APK_UPDATE_COMPLETED = 115;
	public static final int MSG_GET_APPLIANCE_IP_RESULT = 116;
	public static final int MSG_SWITCH_APPLIANCE_TO_SERVER = 117;
	public static final int MSG_SEND_UDP_CMD = 118;
	public static final int MSG_RECEIVE_UDP_CMD = 119;
	public static final int MSG_CLEAR_WIFI_CONFIG_PARS = 120;
	public static final int MSG_USER_OPEN_WIFI = 121;
	public static final int MSG_SWITCH_AIRCON = 122;
	public static final int MSG_SWITCH_AIRCON_FAIL = 123;
	public static final int MSG_LISTVIEW_SET_TURE = 124;
	public static final int MSG_LISTVIEW_SET_FALSE = 125;
	public static final int MSG_GET_APPLIANCE_STATUS = 126;
	public static final int MSG_GET_APPLIANCE_STAT = 127;
	

	public static final int MSG_UDP_BINDER_SMARTBOX = 130;
	public static final int MSG_UDP_BINDER_SA_TO_SMARTBOX = 131;

	public static final int MSG_MODULE_UPGRADE_NORMAL = 132;
	public static final int MSG_MODULE_UPGRADE_FORCE = 133;

	public static final int MSG_PUSH_APPLIANCE_WARNING = 134;

	public static final int MSG_START_EXPERTMODE = 10;
	public static final int MSG_STOP_EXPERTMODE = 11;

	public static final String CHECKBOX_MSG = "CheckBox_msg";
	public static final String APPLIANCE_OFF_LINE_ERROR = "NOSA";
	public static final String APPLIANCE_UPGRADE_ERROR = "UPGRADE";
	public static final String UNKNOW_PHOTOS_URL = "UNKNOW_PHOTOS";
	public static final int SWITCH_TO_ONLINE_STATUS_TYPE_LAN = 0;
	public static final int SWITCH_TO_ONLINE_STATUS_TYPE_DOMAIN = 1;
	public static final int Disable_local = 1;

	public static final String SA_SOCKET_SERVER_PORT = "8899";
	public static final String PHONE_SOCKET_SERVER_PORT = "9988";

	public static final int SENT_TO_CND = 0;
	public static final int SENT_TO_SA = 1;
	public static final int SENT_TO_PHONE = 2;

	public static final int CONNECT_TO_CND = 0;
	public static final int CONNECT_TO_SMARTBOX = 1;
	public static final int CONNECT_TO_SA = 2;

	public static final int SA_SOCKET_CONNECT_ERROR = 0;
	public static final int SA_SOCKET_READ_TIMEOUT = 1;
	public static final int PHONE_SOCKET_CONNECT_ERROR = 2;
	public static final int PHONE_SOCKET_READ_TIMEOUT = 3;
	public static final int CDN_SOCKET_CONNECT_ERROR = 4;
	public static final int CDN_SOCKET_READ_TIMEOUT = 5;






	/**
	 * 消息处理
	 */

	public static final String APPLIANCE_APPLIANCE_ERRORNO = "appliance_errorno";
	public static final int MSG_CLEAR_SMARTBOX_CONFIG_PARS = 120;

	/**
	 * 广播处理
	 */
	public static final String BRODCAST_REFRESH_UI = "com.smartbox.livehome.REFRESH_UI_BROADCAST";
	public static final String BRODCAST_CHANGE_SMARTMODE = "com.smartbox.livehome.CHANGE_SMARTMODE_BROADCAST";
	public static final String BRODCAST_CHANGE_WIFI_STATUS = "com.smartbox.livehome.CHANGE_WIFI_STATUS";
	public static final String BRODCAST_REFRESH_SMARTMODE = "com.smartbox.livehome.REFRESH_SMARTMODE_BROADCAST";
	public static final String BRODCAST_SMARTBOX_UPDATE_DIYCURVE = "com.smartbox.livehome.UPDATE_DIYCURVE_BROADCAST";
	public static final String BRODCAST_SMARTBOX_RUN_EXPERT = "com.smartbox.livehome.RUN_EXPERT_BROADCAST";
	public static final String BRODCAST_SMARTBOX_MUTE_STOP = "com.smartbox.livehome.MUTE_STOP_BROADCAST";
	public static final String BRODCAST_SMARTBOX_MUTE_START = "com.smartbox.livehome.MUTE_START_BROADCAST";
	public static final String BRODCAST_SMARTBOX_POWER_STOP = "com.smartbox.livehome.POWER_STOP_BROADCAST";
	public static final String BRODCAST_SMARTBOX_POWER_START = "com.smartbox.livehome.POWER_START_BROADCAST";
	public static final String BRODCAST_SMARTBOX_POWER_MUTE_STOP = "com.smartbox.livehome.POWER_MUTE_STOP_BROADCAST";

	/**
	 * 设备控制类
	 */





	/**
	 * 空调状态、故障码
	 */
	public static final String AIRCONDITION_MODE_HEAT = "heat";
	public static final String AIRCONDITION_MODE_COOL = "cool";
	public static final String AIRCONDITION_MODE_DEHUMIDIFY = "dehumidify";
	public static final String AIRCONDITION_MODE_BLOW = "blow";
	public static final String AIRCONDITION_MODE_AUTO = "auto";
	public static final String AIRCONDITION_WIND_STRONG = "strong";
	public static final String AIRCONDITION_WIND_MIDDLE = "middle";
	public static final String AIRCONDITION_WIND_WEAK = "weak";
	public static final String AIRCONDITION_WIND_AUTO = "auto";
	public static final String AIRCONDITION_WIND_MUTE = "mute";

	// aircon body check
	// OutDoor
	public static final String AIRCONDITION_BODY_CHECK_OutdoorEEPROMTrouble = "1";
	public static final String AIRCONDITION_BODY_CHECK_OutdoorPipeTemperatureSensorTrouble = "2";
	public static final String AIRCONDITION_BODY_CHECK_OutdoorExhausTemperatureSensorTrouble = "3";
	public static final String AIRCONDITION_BODY_CHECK_OutdoorEnvironmentTemperatureSensorTrouble = "4";
	public static final String AIRCONDITION_BODY_CHECK_OutdoorControlBoardTrouble = "5";
	public static final String AIRCONDITION_BODY_CHECK_AlternatingCurrentOvervoltageProtect = "6";
	public static final String AIRCONDITION_BODY_CHECK_AlternatingCurrentUndervoltageProtect = "7";
	public static final String AIRCONDITION_BODY_CHECK_OutdooEnvironmentOvertemperatureProtect = "8";
	public static final String AIRCONDITION_BODY_CHECK_OutdoorMachineTrouble = "9";
	public static final String AIRCONDITION_BODY_CHECK_OutdoorBoardOrCompressorTrouble = "10";
	// InDoor
	public static final String AIRCONDITION_BODY_CHECK_IndoorTemperatureSensorTrouble = "11";
	public static final String AIRCONDITION_BODY_CHECK_IndoorPipeTemperatureSensorTrouble = "12";
	public static final String AIRCONDITION_BODY_CHECK_IndoorHumiditySensorTrouble = "13";
	public static final String AIRCONDITION_BODY_CHECK_IndoorFanMotorTrouble = "14";
	public static final String AIRCONDITION_BODY_CHECK_PioneerGrillingProtectTrouble = "15";
	public static final String AIRCONDITION_BODY_CHECK_IndoorVoltageZeroCrossDetectionTrouble = "16";
	public static final String AIRCONDITION_BODY_CHECK_IndoorOutdoorCommunicationTrouble = "17";
	public static final String AIRCONDITION_BODY_CHECK_IndoorContrlScreenCommunicationTrouble = "18";
	public static final String AIRCONDITION_BODY_CHECK_IndoorContrlKeypadCommunicationTrouble = "19";
	public static final String AIRCONDITION_BODY_CHECK_IndoorContrlWIFICommunicationTrouble = "20";
	public static final String AIRCONDITION_BODY_CHECK_IndoorContrlChargeCommunicationTrouble = "21";
	public static final String AIRCONDITION_BODY_CHECK_IndoorContrlEEPROMTrouble = "22";
	// Not Show
	public static final String AIRCONDITION_BODY_CHECK_OutdoorCoilOverloadUpFrequency = "23";
	public static final String AIRCONDITION_BODY_CHECK_OutdoorCoilOverloadDownFrequency = "24";
	public static final String AIRCONDITION_BODY_CHECK_IndoorCoilOverloadUpFrequency = "25";
	public static final String AIRCONDITION_BODY_CHECK_IndoorCoilOverloadDownFrequency = "26";
	public static final String AIRCONDITION_BODY_CHECK_PressureUpFrequency = "27";
	public static final String AIRCONDITION_BODY_CHECK_PressureDownFrequency = "28";
	public static final String AIRCONDITION_BODY_CHECK_IndoorCoilFreezingUpFrequency = "29";
	public static final String AIRCONDITION_BODY_CHECK_IndoorCoilFreezingDownFrequency = "30";
	public static final String AIRCONDITION_BODY_CHECK_CommunicationDownFrequency = "31";
	public static final String AIRCONDITION_BODY_CHECK_ModuleTemperaturelimitFrequency = "32";
	public static final String AIRCONDITION_BODY_CHECK_ModulationRatelimitFrequency = "33";
	public static final String AIRCONDITION_BODY_CHECK_PhaseCurrentlimitFrequency = "34";
	public static final String AIRCONDITION_BODY_CHECK_PowerSaveUpFrequency = "35";
	public static final String AIRCONDITION_BODY_CHECK_PowerSaveDownFrequency = "36";
	public static final String AIRCONDITION_BODY_CHECK_OvercurrentUpFrequency = "37";
	public static final String AIRCONDITION_BODY_CHECK_OvercurrentDownFrequency = "38";
	// 故障5细化为故障39～47
	public static final String AIRCONDITION_BODY_CHECK_VoltageTransformerTrouble = "39";
	public static final String AIRCONDITION_BODY_CHECK_CurrentTransformerTrouble = "40";
	public static final String AIRCONDITION_BODY_CHECK_OutdoorContrlDriveCommunicationTrouble = "41";
	public static final String AIRCONDITION_BODY_CHECK_IPMOvercurrentProtect = "42";
	public static final String AIRCONDITION_BODY_CHECK_IPMOverheatingProtect = "43";
	public static final String AIRCONDITION_BODY_CHECK_BusbarVoltageOvervoltageProtect = "44";
	public static final String AIRCONDITION_BODY_CHECK_BusbarVoltageUndervoltageProtect = "45";
	public static final String AIRCONDITION_BODY_CHECK_PFCOvercurrentProtect = "46";
	public static final String AIRCONDITION_BODY_CHECK_OutdoorMaximumCurrentProtect = "47";
	// 故障9细化为故障48～60
	public static final String AIRCONDITION_BODY_CHECK_ExhaustOvertemperatureProtect = "48";
	public static final String AIRCONDITION_BODY_CHECK_CompressoPipeShellTemperatureProtect = "49";
	public static final String AIRCONDITION_BODY_CHECK_IndoorAntiFreezingProtect = "50";
	public static final String AIRCONDITION_BODY_CHECK_OutdoorPFCProtect = "51";
	public static final String AIRCONDITION_BODY_CHECK_CompressoBootFail = "52";
	public static final String AIRCONDITION_BODY_CHECK_CompressoStepOut = "53";
	public static final String AIRCONDITION_BODY_CHECK_OutdoorFanLockRotor = "54";
	public static final String AIRCONDITION_BODY_CHECK_OutdoorPieOverloadProtect = "55";
	public static final String AIRCONDITION_BODY_CHECK_RefrigerantLeakage = "56";
	public static final String AIRCONDITION_BODY_CHECK_CompressoModelMismatch = "57";
	public static final String AIRCONDITION_BODY_CHECK_SystemLowFrequencyVibrationProtect = "58";
	public static final String AIRCONDITION_BODY_CHECK_OutdoorRadiatorOvertemperatureProtect = "59";
	public static final String AIRCONDITION_BODY_CHECK_SystemHypertonusProtect = "60";

	// 故障10细化为故障61～84
	public static final String AIRCONDITION_BODY_CHECK_InverterCocurrentOvervoltageTrouble = "61";
	public static final String AIRCONDITION_BODY_CHECK_InverterCocurrentUndervoltageTrouble = "62";
	public static final String AIRCONDITION_BODY_CHECK_InverterCocurrentOvercurrentTrouble = "63";
	public static final String AIRCONDITION_BODY_CHECK_StepOutDetection = "64";
	public static final String AIRCONDITION_BODY_CHECK_SpeedPulseFault = "65";
	public static final String AIRCONDITION_BODY_CHECK_CurrentPulseFault = "66";
	public static final String AIRCONDITION_BODY_CHECK_InverterEdgeFault = "67";
	public static final String AIRCONDITION_BODY_CHECK_InverterLevelFault = "68";
	public static final String AIRCONDITION_BODY_CHECK_PFC_IPMEdgeFault = "69";
	public static final String AIRCONDITION_BODY_CHECK_PFC_IPMLevelFault = "70";
	public static final String AIRCONDITION_BODY_CHECK_PFCPowerCutFault = "71";
	public static final String AIRCONDITION_BODY_CHECK_PFCOvercurrentFault = "72";
	public static final String AIRCONDITION_BODY_CHECK_DCVException = "73";
	public static final String AIRCONDITION_BODY_CHECK_PFCLowVoltageFault = "74";
	public static final String AIRCONDITION_BODY_CHECK_ADOffsetAnomaliesFault = "75";
	public static final String AIRCONDITION_BODY_CHECK_InverterPWMLogicFault = "76";
	public static final String AIRCONDITION_BODY_CHECK_InverterPWMInitFault = "77";
	public static final String AIRCONDITION_BODY_CHECK_PFCPWMLogicFault = "78";
	public static final String AIRCONDITION_BODY_CHECK_PFC_PWMInitFault = "79";
	public static final String AIRCONDITION_BODY_CHECK_TemperatureAnomaly = "80";
	public static final String AIRCONDITION_BODY_CHECK_CurrentSamplingFault = "81";
	public static final String AIRCONDITION_BODY_CHECK_MotorDataFault = "82";
	public static final String AIRCONDITION_BODY_CHECK_MCEFault = "83";
	public static final String AIRCONDITION_BODY_CHECK_EEPROMFault = "84";

	/* airconmobile */
	public static final String AIRCONMOBILE_BODY_CHECK_IndoorFilterClear = "1";
	public static final String AIRCONMOBILE_BODY_CHECK_IndoorTemperatureSensorTrouble = "2";
	public static final String AIRCONMOBILE_BODY_CHECK_IndoorPipeTemperatureSensorTrouble = "3";
	public static final String AIRCONMOBILE_BODY_CHECK_OutdoorPipeTemperatureSensorTrouble = "4";
	public static final String AIRCONMOBILE_BODY_CHECK_IndoorDrainsWaterPumpTrouble = "5";

	/**
	 * 空气净化器状态、故障码
	 */
	public static final String AIRCLEANER_MODE_CLEARDUST = "cleardust";
	public static final String AIRCLEANER_MODE_CLEARSMELL = "clearsmell";
	public static final String AIRCLEANER_MODE_SMART = "smart";
	public static final String AIRCLEANER_MODE_MUTE = "mute";
	public static final String AIRCLEANER_MODE_SLEEP = "sleep";
	public static final String AIRCLEANER_WIND_STRONG = "strong";
	public static final String AIRCLEANER_WIND_MIDDLE = "middle";
	public static final String AIRCLEANER_WIND_WEAK = "weak";
	public static final String AIRCLEANER_WIND_AUTO = "auto";
	public static final String AIRCLEANER_WIND_CLEAR = "clear";

	// aircleaner body check
	public static final String AIRCLEANER_BODY_CHECK_MotorError = "1";
	public static final String AIRCLEANER_BODY_CHECK_LeanError = "2";
	public static final String AIRCLEANER_BODY_CHECK_ChangeFilter = "3";
	public static final String AIRCLEANER_BODY_CHECK_HumidityWheelError = "4";
	public static final String AIRCLEANER_BODY_CHECK_WaterSinkEmptyError = "5";
	public static final String AIRCLEANER_BODY_CHECK_WaterSinkNotSetup = "6";
	public static final String AIRCLEANER_BODY_CHECK_HumiditySensorError = "7";
	public static final String AIRCLEANER_BODY_CHECK_DustSensor = "8";
	public static final String AIRCLEANER_BODY_CHECK_SmellSensor = "9";

	/**
	 * 除湿机状态、故障码
	 */
	public static final String DEHUMIDIFIER_MODE_CONTINUE = "continue";
	public static final String DEHUMIDIFIER_MODE_NORMAL = "normal";
	public static final String DEHUMIDIFIER_MODE_AUTO = "auto";
	public static final String DEHUMIDIFIER_MODE_HEAT = "heat";
	public static final String DEHUMIDIFIER_WIND_STRONG = "strong";
	public static final String DEHUMIDIFIER_WIND_WEAK = "weak";
	public static final String DEHUMIDIFIER_WIND_AUTO = "auto";

	// dehumidifier body check
	public static final String DEHUMIDIFIER_BODY_CHECK_FilterNetCleanWarning = "1";
	public static final String DEHUMIDIFIER_BODY_CHECK_HumidSensorError = "2";
	public static final String DEHUMIDIFIER_BODY_CHECK_PumpTempratureError = "3";
	public static final String DEHUMIDIFIER_BODY_CHECK_IndoorTempratureError = "4";
	public static final String DEHUMIDIFIER_BODY_CHECK_WaterPumpWarning = "5";
	public static final String DEHUMIDIFIER_BODY_CHECK_WaterFullWarning = "6";

	/**
	 * 换风机状态、故障码
	 */
	public static final String HOTFAN_MODE_FULLHEAT = "fullheat";
	public static final String HOTFAN_MODE_DIRECT = "direct";
	public static final String HOTFAN_MODE_INDOOR = "indoor";
	public static final String HOTFAN_MODE_AUTO = "auto";
	public static final String HOTFAN_WIND_STRONG = "strong";
	public static final String HOTFAN_WIND_MIDDLE = "middle";
	public static final String HOTFAN_WIND_WEAK = "weak";
	public static final String HOTFAN_WIND_AUTO = "auto";

	// hotfan body check
	public static final String HOTFAN_BODY_CHECK_InnerTemperatureSensorFault = "1";
	public static final String HOTFAN_BODY_CHECK_InnerHumiditySensorFault = "2";
	public static final String HOTFAN_BODY_CHECK_Co2SensorIfFault = "3";
	public static final String HOTFAN_BODY_CHECK_OuterTemperatureSensorIfFault = "4";
	public static final String HOTFAN_BODY_CHECK_OuterHumiditySensorIfFault = "5";

	public static final String BATTERY_STATUS_UNKNOWN = "unknown";
	public static final String BATTERY_STATUS_CHARGING = "charging";
	public static final String BATTERY_STATUS_DISCHARGING = "discharg";
	public static final String BATTERY_STATUS_FULL = "full";
	public static final String URL_IMAGE = "http://oven.topfuturesz.com:6819/Config/ImageServer";
	public static final String RETURN_RESULT = "result";
	public static final String RETURN_SUCCESS = "success";
	public static final String RETURN_FAILURE = "failure";
	public static final String USER_HEAD_IMAGE_PATH = "USER_HEAD_IMAGE_PATH";
	public static final int ACTIVITY_REQUEST_CODE = 0x100;
	public static final String REFRESH_FLAG = "IS_REFRESH";
	
	/**
	 * Fragment常量标记
	 */
	public static final String UserFragment = "UserFragment";
	public static final String LoginMenuFragment = "LoginMenuFragment";
	public static final String MainFragment = "MainFragment";
	public static final String DeviceListFragment = "DeviceListFragment";
	public static final String ReleaseMenuFragment = "ReleaseMenuFragment"; // 发布菜谱
	public static final String FindFriendFragment = "FindFriendFragment";
	public static final String SettingFragment = "SettingFragment";
	public static final String ExperienceFragment = "ExperienceFragment";
	public static final String CurveListFragment = "CurveListFragment";
	public static final String DishListFragment = "DishListFragment";
	public static final String RecipesListFragment = "RecipesListFragment";
	public static final String CurveAddFragment = "CurveAddFragment";
	/**
	 * 用户常量标记
	 */
	public static final String UserName = "username";
	public static final String PassWord = "password";
	public static final String IsRemember = "isremember";
	public static final String UseOven = "useoven"; // 当前标记的烤箱
	public static final String Success = "success";
	public static final String SetCookie = "Set-Cookie";
	public static final String Cookie = "Cookie";
	public static final String Tooken = "Tooken";
	/**
	 * 用与activity fragment 等传递数据 通常为序列化过的对象
	 */
	public static final String ObjectData = "ObjectData";
	public static final String DraftboxDish = "DraftboxDish";
	public static final String DiyCreateDish = "DiycreateDish";
	public static final String ProductionDish = "ProductionDish";
	public static final String PreViewDish = "PreViewDish";
	public static final String StepToCreate = "StepToCreate";
	public static final String BroadcastReceiver = "BroadcastReceiver";
	/**
	 * 用与记录位置
	 */
	public static final String Position = "Position";
	/**
	 * html正式地址
	 */
	public static final String IndexUrl = "http://oven.topfuturesz.com:6819/OVEN_WEB/mobile/jsp/oven.jsp";
	public static final String CollectUrl = "http://oven.topfuturesz.com:6819/OVEN_WEB/mobile/jsp/MyCollect.jsp";

	/**
	 * html测试地址
	 */
	// public static final String IndexUrl =
	// "http://192.168.0.161:6819/OVEN_WEB/index.jsp";
	// public static final String CollectUrl =
	// "http://192.168.0.161:6819/OVEN_WEB/mobile/jsp/MyCollect.jsp";
	// public static final String
	// DIYUrl="http://192.168.0.161:6819:6819/OVEN_WEB/mobile/jsp/DIYDishes.jsp";
	// public static final String
	// PraiseUrl="http://192.168.0.161:6819:6819/OVEN_WEB/mobile/jsp/praiseFrom.jsp";
	// public static final String
	// UserCenterUrl="http://192.168.0.161:6819:6819/OVEN_WEB/mobile/jsp/userInfo.jsp";
	public static final String DIYUrl = "http://oven.topfuturesz.com:6819/OVEN_WEB/mobile/jsp/curve.jsp?diy=1#pageCurveList";
	public static final String PraiseUrl = "http://oven.topfuturesz.com:6819/OVEN_WEB/mobile/jsp/praiseFrom.jsp";
	public static final String ExperienceUrl = "http://oven.topfuturesz.com:6819/OVEN_WEB/mobile/jsp/experience.jsp";
	public static final String DownLoadDishes = "http://oven.topfuturesz.com:6819/OVEN_WEB/mobile/jsp/downLoadDishes.jsp";
	public static final String UserCenterUrl = "http://oven.topfuturesz.com:6819/OVEN_WEB/mobile/jsp/userInfo.jsp";
	/**
	 * 错误页面
	 */
	public static final String errorURL = "file:///android_asset/404.html";
	public static final String Upload_Image_URL = "http://cdn1.topfuturesz.com/ImageServer/UploadServlet"; // 图片上传地址
	/**
	 * html跳转参数
	 */
	public static final String JumpAddress = "jumpaddress";
	public static final String Image_Unspecified = "image/*";
	/**
	 * 节点服务器
	 */
	public static final String CDN = "CDN_MAIN";
	/**
	 * 百度云推送apikey
	 */
	public static final String Baidu_Api_Key = "ZQSuwVp0UGIoItBG5GnYuxGA";
	public static final String Baidu_Secret_Key = "XiOo1BGye6KyAa2voT7kZGId8ymemneB";

}
