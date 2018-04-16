package com.democode.firstlinecode.demo7.tool;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;

/**
 * 
 * 对于Activity的管理类.
 * @author Administrator
 *
 */
public class ActivityManager  {
	
	public static List<Activity> activitys = new ArrayList<Activity>();
	
	/**
	 * 将一个Activity的类放入到这个方法当中,被这个容器管理.
	 * @param activity
	 */
	public static void addActivity(Activity activity) {
		activitys.add(activity);
	}
	
	/**
	 * 从容器中删除对应的activity参数的Activity类型的元素.
	 * @param activity
	 */
	public static void removeActivity(Activity activity) {
		activitys.remove(activity);
	}
	
	/**
	 * 清楚掉容器当中的所有的元素
	 */
	public static void finishALL() {
		for (Activity activity:activitys) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}
	
}