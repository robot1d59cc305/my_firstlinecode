package com.democode.firstlinecode.demo6.activityjob;

import java.util.ArrayList;
import android.app.Activity;

/**
 * �������Թ������е���.finish��ȫ����Activity
 * @author Administrator
 *
 */
public class ActivityCollector extends BaseActivity {
	
	/**
	 * �������е�Activity������.
	 */
	public static ArrayList<Activity> activitys = new ArrayList<Activity>();
	
	/**
	 * ����һ��Activity��Activitys����.
	 * @param activity
	 */
	public static void addActivity(Activity activity) {
		activitys.add(activity);
	}
	
	/**
	 * ɾ��һ��Activity
	 * @param activity
	 */
	public static void removeActivity(Activity activity) {
		activitys.remove(activity);
	}
	
	/**
	 * ɾ����ȫ����Activity
	 */
	public static void finishAll() {
		for (Activity activity : activitys) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}
	
}