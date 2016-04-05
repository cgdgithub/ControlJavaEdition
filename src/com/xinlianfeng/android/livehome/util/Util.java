package com.xinlianfeng.android.livehome.util;

//import android.app.Activity;
//import android.app.ActivityManager;
//import android.app.ActivityManager.RunningTaskInfo;
//import android.content.ComponentName;
//import android.content.Context;
//import android.content.Intent;
//import android.content.pm.PackageInfo;
//import android.content.pm.PackageManager;
//import android.content.pm.PackageManager.NameNotFoundException;
//import android.database.Cursor;
//import android.graphics.Bitmap;
//import android.graphics.Matrix;
//import android.media.ExifInterface;
//import android.net.Uri;
//import android.provider.MediaStore;
//import android.util.Log;
//import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Util {
    private static final String TAG = "Util";
    private static final boolean DEBUG = false;
    /**
     * 把十六进制字符串转换成byte数组
     *
     * @return
     */
    private final static byte[] hex = "0123456789ABCDEF".getBytes();
//    private static Toast mToast;

    /**
     * 专家系统数据是否无效，无效则返回true，否则则返回false
     */
    public static boolean isDataInvalid(int value) {
        if (value == Constants.errorValueInt) {
            return true;
        }

        return false;
    }

    public static void printLog(String tag, String log) {
        if (DEBUG) {
//            Log.d(tag, "==================" + log + "=================");
        }

    }

    public static String getCurrentTime() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sDateFormat.format(new java.util.Date());
    }

//    public static void showToast(Context mContext, int toast) {
//        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
//    }
//
//    public static void showToast(Context mContext, String toast) {
//        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
//    }
//
//    public static void showToast(Context mContext, int msg, int duration) {
//        // if (mToast != null) {
//        // mToast.cancel();
//        // }
//        // mToast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
//        if (mToast == null) {
//            mToast = Toast.makeText(mContext, msg, duration);
//        } else {
//            mToast.setText(msg);
//        }
//        mToast.show();
//    }
	public static String encodeUrl(String url) {
		try {
			return URLEncoder.encode(url, "UTF-8");
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return url;
	}
    /**
     * 把boolean true 转换成String 1，false 转换成 String 0
     */
    public static String changeBooleanToString(boolean value) {
        if (value) {
            return Constants.AT_PORTOCOL_SET_BOOLE_TRUE;
        } else {
            return Constants.AT_PORTOCOL_SET_BOOLE_FALSE;
        }
    }

    /**
     * 把String 1  转换成boolean true， String 0 转换成 false，其他字符为 false
     */
    public static boolean changeStringToBoolean(String value) {
        if (Constants.AT_PORTOCOL_SET_BOOLE_TRUE.equals(value)) {
            return true;
        } else if (Constants.AT_PORTOCOL_SET_BOOLE_FALSE.equals(value)) {
            return false;
        } else {
            return false;
        }
    }

    /**
     * 把字符串转成 整形
     */
    public static int changeStringToInterger(String value) {
        if (null != value) {
            return Integer.valueOf(value).intValue();
        }
        return 0;
    }

    /**
     * 把模块ID后12位改成小写，用作wifi模块AP模式时的ssid；
     */
	public synchronized static String getWifModuleApName(String ssid) {
		String temp = ssid.trim();
		if(temp.length() > 12) {
			String head = temp.substring(0, 9);
			return head + (temp.substring(9, temp.length())).toLowerCase(Locale.ENGLISH);
		}
		
		return null;
	}
	
	/**
	 * 把模块ID后12位改成大写；
	 */
	public static String getWifModuleUppercaseName(String ssid) {
		String temp = ssid.trim();
		if(temp.length() > 12) {
			String head = temp.substring(0, 9);
			return head + (temp.substring(9, temp.length())).toUpperCase(Locale.ENGLISH);
		}
		
		return null;
	}
    /**
     * 把整形转换成字符串型
     */
    public static String changeIntergerToString(int value) {
        return String.valueOf(value);
    }

    public static String intToIp(int i) {
        return (i & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + ((i >> 16) & 0xFF) + "." + ((i >> 24) & 0xFF);
    }

    public static boolean parseGetToggleValue(String result, boolean defaultValue) {
        if (Constants.AT_PORTOCOL_SET_BOOLE_FALSE.equalsIgnoreCase(result)) {
            return false;
        } else if (Constants.AT_PORTOCOL_SET_BOOLE_TRUE.equals(result)) {
            return true;
        } else {
            return defaultValue;
        }
    }

//    public static boolean isActivityRunningBackground(Context mContext) {
//        /*需要增加权限 android.permission.GET_TASKS"*/
//        ActivityManager am = (ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE);
//        List<RunningTaskInfo> tasks = am.getRunningTasks(1);
//        if (!tasks.isEmpty()) {
//            ComponentName topActivity = tasks.get(0).topActivity;
//            if (!topActivity.getClassName().equals(mContext.getClass().getName())) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static String formatIntValueToTime(int hour, int minute) {
        DecimalFormat decimalFormatHour = new DecimalFormat("00");
        DecimalFormat decimalFormatMin = new DecimalFormat("00");
        return decimalFormatHour.format(hour) + ":" + decimalFormatMin.format(minute);
    }

    //得到当前版本信息
//    public static String getVersionName(Context context) throws NameNotFoundException {
//        //获取PackageManager 实例
//        PackageManager packageManager = context.getPackageManager();
//        //获得context所属类的包名，0表示获取版本信息
//        PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
//        Log.d("", "getVersionName: = " + packageInfo.versionName);
//        return packageInfo.versionName;
//    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    public static byte[] hexStringToBinary(String hexstr) {
        byte[] b = new byte[hexstr.length() / 2];
        int j = 0;
        for (int i = 0; i < b.length; i++) {
            char c0 = hexstr.charAt(j++);
            char c1 = hexstr.charAt(j++);
            b[i] = (byte) ((parse(c0) << 4) | parse(c1));
        }
        return b;
    }

    /**
     * 把byte数组转换成十六进制字符串
     *
     * @return
     */
    public static String Bytes2HexString(byte[] b) {
        byte[] buff = new byte[2 * b.length];
        for (int i = 0; i < b.length; i++) {
            buff[2 * i] = hex[(b[i] >> 4) & 0x0f];
            buff[2 * i + 1] = hex[b[i] & 0x0f];
        }
        return new String(buff);
    }

    private static int parse(char c) {
        if (c >= 'a')
            return (c - 'a' + 10) & 0x0f;
        if (c >= 'A')
            return (c - 'A' + 10) & 0x0f;
        return (c - '0') & 0x0f;
    }

    public static String formatStirng(String strs, String letter) {
        String formatString = null;
        formatString = letter + strs.substring(letter.length()).toLowerCase();
        return formatString;
    }

    public static boolean isReachable(String host, int port, int timeout) {
        boolean isReachable = false;
        Socket socket = null;
        try {
            socket = new Socket();
            // 端口号设置为 0 表示在本地挑选一个可用端口进行连接
            InetSocketAddress endpointSocketAddr = new InetSocketAddress(host, port);//Integer.valueOf(port).intValue()
            socket.connect(endpointSocketAddr, timeout);
            isReachable = true;
        } catch (IOException e) {
            System.out.println("host " + host + " port" + port + "not connect!");
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println("Error occurred while closing socket..");
                }
            }
        }
        return isReachable;
    }

    public static boolean isReachable(String host, int timeout) {
        boolean isReachable = false;
        InetAddress address;
        try {
            address = InetAddress.getByName(host);
            isReachable = address.isReachable(3000);
            if (!isReachable) {
                isReachable = address.isReachable(timeout);
            }
        } catch (IOException e) {
            System.out.println("host " + host + "not connect!");
        }
        return isReachable;
    }

    /**
     * 根据4004，或者box的id的后8位生产一个8位的密码；用作AP模式时的密码
     */
    public static String getPassWord(String ssid) {
        String password = null;
        password = ssid.substring(ssid.length() - 8);

        if (null != password) {
            password = password.toUpperCase(Locale.ENGLISH);
        }

        char[] temp = password.toCharArray();

        for (int i = 0; i < 8; i++) {
            if (temp[i] >= 'A' && temp[i] <= 'F') {
                temp[i] = (char) (((~temp[i]) << 1) & 0xbf);
                if (temp[i] == '<') {
                    temp[i] = '1';
                } else if (temp[i] == ':') {
                    temp[i] = '0';
                }
            } else {
                temp[i] = (char) (~((~temp[i]) << 1));
            }
        }
        password = new String(temp);
        return password;
    }

    public static int[] hexStringToint(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }

        int StrLength = hexString.length();
        if (StrLength < 4) {
            for (int i = 0; i < 4 - StrLength; i++)
                hexString = "0" + hexString;
        }

        hexString = hexString.toUpperCase(Locale.ENGLISH);
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        int[] d = new int[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }


    /**
     * Convert char to byte
     *
     * @param c char
     * @return byte
     */
    public static String stringToAscii(String value) {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sbu.append(Integer.toHexString((int) chars[i]));
        }

        return sbu.toString();
    }

    public static String asciiToString(String value) {
        return new String(hexStringToBinary2(value));
    }

    public static byte[] hexStringToBinary2(String hexString) {
        // hexString的长度对2取整，作为bytes的长度
        int len = hexString.length() / 2;
        byte[] bytes = new byte[len];
        byte high = 0;// 字节高四位
        byte low = 0;// 字节低四位
        ArrayList List = new ArrayList();

        for (int i = 0; i < len; i++) {
            // 右移四位得到高位
            high = (byte) (("0123456789ABCDEF".indexOf(hexString.charAt(2 * i))) << 4);
            low = (byte) "0123456789ABCDEF".indexOf(hexString.charAt(2 * i + 1));
            bytes[i] = (byte) (high | low);// 高地位做或运算
            if (bytes[i] > 0x20 && bytes[i] < 0x7e) {
                List.add(bytes[i]);
            }
        }

        Object[] b = (Object[]) List.toArray();
        byte[] bb = new byte[b.length];
        for (int i = 0; i < b.length; ++i) {
            bb[i] = ((Byte) b[i]).byteValue();
        }

        return bb;
    }


    /**
     * 读取图片属性：旋转的角度
     *
     * @param path 图片绝对路径
     * @return degree旋转的角度
     */
//    public static int readPictureDegree(String path) {
//        int degree = 0;
//        try {
//            ExifInterface exifInterface = new ExifInterface(path);
//            int orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION,
//                    ExifInterface.ORIENTATION_NORMAL);
//            switch (orientation) {
//                case ExifInterface.ORIENTATION_ROTATE_90:
//                    degree = 90;
//                    break;
//                case ExifInterface.ORIENTATION_ROTATE_180:
//                    degree = 180;
//                    break;
//                case ExifInterface.ORIENTATION_ROTATE_270:
//                    degree = 270;
//                    break;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return degree;
//    }

    /*
     * 旋转图片
     *
     * @param angle
     *
     * @param bitmap
     *
     * @return Bitmap
     */
//    public static Bitmap rotaingImageView(int angle, Bitmap bitmap) {
//        if (bitmap == null) {
//            return null;
//        }
//        // 旋转图片 动作
//        Matrix matrix = new Matrix();
//        matrix.postRotate(angle);
//        // 创建新的图片
//        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
//        return resizedBitmap;
//    }

    /**
     * 调用系统应用裁剪照片
     * <p/>
     * requestCode: Constants.RESULT_IMAGE_CROP:拍照完并裁剪
     * Constants.RESULT_IMAGE_CROP_CONTENT:  调用系统相册选取照片并裁剪
     * *
     */
//    public static void cropImageUri(Activity activity, Uri uri, Uri olduri, int requestCode) {
//        if (Constants.RESULT_IMAGE_CROP_CONTENT == requestCode) {
//            int indexColon = olduri.toString().indexOf(Constants.CMD_AT_COLON);
//            if (-1 == indexColon) {
//                return;
//            }
//            String pathType = olduri.toString().substring(0, indexColon);
//            if (Constants.PARAM_PATH_TYPE_CONTENT.equals(pathType)) {
//                Log.d(TAG, "RESULT_IMAGE_SELECT Content: " + olduri.toString());
//                String[] proj = {MediaStore.Images.Media.DATA};
//                Cursor actualimagecursor = activity.managedQuery(olduri, proj, null, null, null);
//                int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//                actualimagecursor.moveToFirst();
//                String img_path = GalleryFunction.getPath(activity, olduri);// actualimagecursor.getString(actual_image_column_index);
//                File file = new File(img_path);
//                olduri = Uri.fromFile(file);
//                if (null == olduri) {
//                    return;
//                }
//            } else if (Constants.PARAM_PATH_TYPE_FILE.equals(pathType)) {
//                Boolean isValidatePicturePath = ValidateCharset
//                        .isValidatePicturePath(olduri.toString());
//                if (!isValidatePicturePath) {
//                    return;
//                }
//            } else {
//                return;
//            }
//        }
//        Intent intent = new Intent("com.android.camera.action.CROP");
//        intent.setDataAndType(olduri, "image/*");
//
//        //裁剪框的比例，1：1
//        intent.putExtra("aspectX", 1);
//        intent.putExtra("aspectY", 1);
//        //intent.putExtra("circleCrop", true);
//
//        //裁剪后输出图片的尺寸大小
//        intent.putExtra("crop", "true");
//        intent.putExtra("outputX", Constants.IMAGE_OUTPUT_X);
//        intent.putExtra("outputY", Constants.IMAGE_OUTPUT_Y);
//        intent.putExtra("scale", true);
//
//
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
//
//        //图片格式
//        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
//        intent.putExtra("return-data", false);
//        intent.putExtra("noFaceDetection", true); // no face detection
//        activity.startActivityForResult(intent, requestCode);
//
//    }
    /************************************************/

    /**
     * 将时间转成 yyyyMMdd_hhmmss 格式
     */
    public static String formatData(Date date) {
        return new SimpleDateFormat("yyyyMMdd_hhmmss").format(date);
    }

    /**
     * 将时间转成对应的style格式
     *
     * @param style yyyy-MM-dd|yyyyMMdd_hhmmss|yyyy-MM-dd hh:mm:ss|yyyy年MM月dd日 等
     */
    public static String formatDataDIY(Date date, String style) {
        return new SimpleDateFormat(style).format(date);
    }

    /**
     * 将传入的时间转化为距离现在多少分，时
     *
     * @param time 多少ms
     * @return
     */
    public static String formatDataByNow(Long time) {
        if (time == null) return "";
        long now = System.currentTimeMillis() - time;
        now = now / 1000; //秒
        if (now < 60) {
            return now + "秒前";
        }
        now /= 60;  //分钟
        if (now < 60) {
            return now + "分钟前";
        }
        now /= 60;  //小时
        if (now < 24) {
            return now + "小时前";
        }
        now /= 24;  //天
        if (now < 31) {
            return now + "天前";
        }
        now /= 31; //月
        if (now < 12) {
            return now + "月前";
        }
        now /= 12;
        return now + "年前";
    }

    /**
     * 格式化文件大小，不保留末尾的0
     */
    public static String formatFileSize(long len) {
        return formatFileSize(len, false);
    }

    /**
     * 将以逗号分隔的字符串转换成 List对象
     *
     * @param originalText
     * @return
     */
    public static List<String> getTagsList(String originalText) {
        if (originalText == null || originalText.equals("")) {
            return null;
        }
        List<String> tags = new ArrayList<String>();
        int indexOfComma = originalText.indexOf(',');
        String tag;
        while (indexOfComma != -1) {
            tag = originalText.substring(0, indexOfComma);
            tags.add(tag);

            originalText = originalText.substring(indexOfComma + 1);
            indexOfComma = originalText.indexOf(',');
        }

        tags.add(originalText);
        return tags;
    }

    /**
     * 格式化文件大小，保留末尾的0，达到长度一致
     */
    public static String formatFileSize(long len, boolean keepZero) {
        String size;
        DecimalFormat formatKeepTwoZero = new DecimalFormat("#.00");
        DecimalFormat formatKeepOneZero = new DecimalFormat("#.0");
        if (len < 1024) {
            size = String.valueOf(len + "B");
        } else if (len < 10 * 1024) {
            // [0, 10KB)，保留两位小数
            size = String.valueOf(len * 100 / 1024 / (float) 100) + "KB";
        } else if (len < 100 * 1024) {
            // [10KB, 100KB)，保留一位小数
            size = String.valueOf(len * 10 / 1024 / (float) 10) + "KB";
        } else if (len < 1024 * 1024) {
            // [100KB, 1MB)，个位四舍五入
            size = String.valueOf(len / 1024) + "KB";
        } else if (len < 10 * 1024 * 1024) {
            // [1MB, 10MB)，保留两位小数
            if (keepZero) {
                size = String.valueOf(formatKeepTwoZero.format(len * 100 / 1024 / 1024 / (float) 100)) + "MB";
            } else {
                size = String.valueOf(len * 100 / 1024 / 1024 / (float) 100) + "MB";
            }
        } else if (len < 100 * 1024 * 1024) {
            // [10MB, 100MB)，保留一位小数
            if (keepZero) {
                size = String.valueOf(formatKeepOneZero.format(len * 10 / 1024 / 1024 / (float) 10)) + "MB";
            } else {
                size = String.valueOf(len * 10 / 1024 / 1024 / (float) 10) + "MB";
            }
        } else if (len < 1024 * 1024 * 1024) {
            // [100MB, 1GB)，个位四舍五入
            size = String.valueOf(len / 1024 / 1024) + "MB";
        } else {
            // [1GB, ...)，保留两位小数
            size = String.valueOf(len * 100 / 1024 / 1024 / 1024 / (float) 100) + "GB";
        }
        return size;
    }

    /**
     * ************************************************************
     */


    public static String calcMD5FromString(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }
        try {
            MessageDigest hashEngine = MessageDigest.getInstance("MD5");
            hashEngine.update(input.getBytes("iso-8859-1"), 0, input.length());
            return Bytes2HexString(hashEngine.digest());
        } catch (Exception e) {
            return null;
        }
    }

    
    public static final String APPLIANCE_WIFI_FIRST_MARK = "TE-M001-";
	public static final String APPLIANCE_WIFI_HTTP_FIRST_MARK = "te-id=";
	public static final String APPLIANCE_WIFI_FIRST_MARK_HISENSE = "AIH-W401-";
	public static final String APPLIANCE_WIFI_FIRST_MARK_SMARTBOX = "CMD-W01-";
	public static final String APPLIANCE_WIFI_FIRST_MARK_FT = "FT-JACGD-";
	public static final String APPLIANCE_WIFI_FIRST_MARK_XLF = "XLF-D401-";
	/**
	 * 判断指定SSID是否属于家电类型
	 * 
	 * @param SSID
	 * @return 是家电类型返回true，否则返回false
	 */
	public static boolean isApplianceWifi(String SSID) {

		if(null == SSID) {
			return false;
		}
		if(SSID.contains(APPLIANCE_WIFI_FIRST_MARK)
				|| SSID.contains(APPLIANCE_WIFI_FIRST_MARK_HISENSE)
				|| SSID.contains(APPLIANCE_WIFI_HTTP_FIRST_MARK)
				|| SSID.contains(APPLIANCE_WIFI_FIRST_MARK_SMARTBOX)
				|| SSID.contains(APPLIANCE_WIFI_FIRST_MARK_FT)
				|| SSID.contains(APPLIANCE_WIFI_FIRST_MARK_XLF)) {
			return true;
		} else {
			return false;
		}
	}
}
