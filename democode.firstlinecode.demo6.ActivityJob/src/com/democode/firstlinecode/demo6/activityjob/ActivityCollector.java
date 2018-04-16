package com.democode.firstlinecode.demo6.activityjob;

import java.util.ArrayList;
import android.app.Activity;

/**
 * 这个类可以管理所有的类.finish掉全部的Activity
 * @author Administrator
 *
 */
public class ActivityCollector extends BaseActivity {
	
	/**
	 * 这是所有的Activity的容器.
	 */
	public static ArrayList<Activity> activitys = new ArrayList<Activity>();
	
	/**
	 * 增加一个Activity到Activitys当中.
	 * @param activity
	 */
	public static void addActivity(Activity activity) {
		activitys.add(activity);
	}
	
	/**
	 * 删除一个Activity
	 * @param activity
	 */
	public static void removeActivity(Activity activity) {
		activitys.remove(activity);
	}
	
	/**
	 * 删除掉全部的Activity
	 */
	public static void finishAll() {
		for (Activity activity : activitys) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}
	
}