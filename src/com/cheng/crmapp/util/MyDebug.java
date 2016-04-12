/*AUTO-GENERATED FILE.  DO NOT MODIFY.
 * 项目名称：	JujuApp   
 * @DESCRIPTION: 
 * Copyright 	BF Corporation 2013   
 * 版权所有  
 *    
 */
package com.cheng.crmapp.util;

/*******************************************
 * @COMPANY:	武汉早点科技技术有限责任公司
 * @CLASS:	Debug
 * @DESCRIPTION:	全局调试类
 * @AUTHOR:	CiCi
 * @VERSION:	v1.0.1
 * @DATE:	2013-6-30 下午12:31:08
 *******************************************/

import android.util.Log;

public class MyDebug {

	public static final String TAG = "CRM";
	public static boolean isEnabled = true;

	public static void print(String msg) {
		if (isEnabled) {
			// Log.i(TAG, getTraceInfo() + " " + msg);
			System.out.println(TAG + "======" + getTraceInfo() + "=====" + msg);
		}
	}

	public static void print(int moduleId, Object currentCls, String msg) {
		if (isEnabled) {
			Log.i(TAG, getTraceInfo() + " " + msg);
		}
	}

	public static void error(String msg) {
		if (isEnabled) {
			Log.e(TAG, getTraceInfo() + " " + msg);
		}
	}

	public static void error(int moduleId, Object currentCls, String msg) {
		if (isEnabled) {
			Log.e(TAG, getTraceInfo() + " " + msg);
		}
	}

	/**
	 * @Description:获取日志详细信息--(java文件 方法名 代码行) 方便调试定位问题
	 */
	public static String getTraceInfo() {
		StringBuffer sb = new StringBuffer();
		StackTraceElement[] stacks = new Throwable().getStackTrace();
		String classname = stacks[2].getClassName();
		int lastindex = classname.lastIndexOf(".") + 1;
		if (lastindex >= 0) {
			classname = classname.substring(lastindex);
		}
		sb.append("【" + classname).append(".java->").append(stacks[2].getMethodName()).append("()->").append(stacks[2].getLineNumber() + "】");
		return sb.toString();
	}
}
