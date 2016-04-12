/*AUTO-GENERATED FILE.  DO NOT MODIFY.
 * 项目名称：	FamilyFun   
 * @DESCRIPTION: 
 * Copyright 	BF Corporation 2015   
 * 版权所有  
 *    
 */
package com.cheng.crmapp.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;

import java.text.SimpleDateFormat;
import java.util.Date;

/*******************************************
 * @COMPANY: 武汉早点科技技术有限责任公司
 * @CLASS: AppUtil
 * @DESCRIPTION:
 * @AUTHOR: CiCi
 * @VERSION: v1.0.1
 * @DATE: 2015-6-6 下午6:05:31
 *******************************************/
public class AppUtil {

	public static class ViewHolder {
		// I added a generic return type to reduce the casting noise in client
		// code
		@SuppressWarnings("unchecked")
		public static <T extends View> T get(View view, int id) {
			SparseArray<View> viewHolder = (SparseArray<View>) view.getTag();

			if (viewHolder == null) {
                viewHolder = new SparseArray<View>();
                view.setTag(viewHolder);
            }
            View childView = viewHolder.get(id);
			if (childView == null) {
				childView = view.findViewById(id);
				viewHolder.put(id, childView);
			}
			return (T) childView;
		}
	}

	// 获取屏幕高度
	public static int getScreenHight(Activity mActivity) {
		DisplayMetrics metric = new DisplayMetrics();
		mActivity.getWindowManager().getDefaultDisplay().getMetrics(metric);
		return metric.heightPixels;
	}

	// 获取屏幕宽度
	public static int getScreenWidth(Activity mActivity) {
		DisplayMetrics metric = new DisplayMetrics();
		mActivity.getWindowManager().getDefaultDisplay().getMetrics(metric);
		return metric.widthPixels;
	}

	//获取状态栏高度
	public int getStateHeight(Activity activity) {
		Rect rect = new Rect();
		activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
		return rect.top;
	}

	public static String getPhotoFileName() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss");
		return dateFormat.format(date) + ".jpg";
	}

	public static String getVersionName(Context mContext) {
		// 获取packagemanager的实例
		String version = "";
		try {
			PackageManager packageManager = mContext.getPackageManager();
			// getPackageName()是你当前类的包名，0代表是获取版本信息
			PackageInfo packInfo = packageManager.getPackageInfo(mContext.getPackageName(), 0);
			version = packInfo.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return version;
	}

}
