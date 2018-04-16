package democode.firstlinecode.demo16.sensor;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;

/**
 * 
 * ����Activity�Ĺ�����.
 * @author Administrator
 *
 */
public class ActivityManager  {
	
	public static List<Activity> activitys = new ArrayList<Activity>();
	
	/**
	 * ��һ��Activity������뵽�����������,�������������.
	 * @param activity
	 */
	public static void addActivity(Activity activity) {
		activitys.add(activity);
	}
	
	/**
	 * ��������ɾ����Ӧ��activity������Activity���͵�Ԫ��.
	 * @param activity
	 */
	public static void removeActivity(Activity activity) {
		activitys.remove(activity);
	}
	
	/**
	 * ������������е����е�Ԫ��
	 */
	public static void finishALL() {
		for (Activity activity:activitys) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}
	
}