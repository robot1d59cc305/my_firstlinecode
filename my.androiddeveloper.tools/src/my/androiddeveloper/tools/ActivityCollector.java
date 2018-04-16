package my.androiddeveloper.tools;

import java.util.ArrayList;
import android.app.Activity;

/**
 * @author Administrator
 *
 */
public class ActivityCollector extends BaseActivity {
	
	/**
	 */
	public static ArrayList<Activity> activitys = new ArrayList<Activity>();
	
	/**
	 * @param activity
	 */
	public static void addActivity(Activity activity) {
		activitys.add(activity);
	}
	
	/**
	 * @param activity
	 */
	public static void removeActivity(Activity activity) {
		activitys.remove(activity);
	}
	
	/**
	 */
	public static void finishAll() {
		for (Activity activity : activitys) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}
	
}