package democode.firstlinecode.demo12.multimedia.notification;

import com.example.democode.firstlinecode.demo12.notifications.R;

import android.app.Activity;
import android.app.NotificationManager;

/**
 * 
 * NotificationActivity:
 * 1.当用户点击推送的通知则跳转到这个页面.
 * 2.并且取消通知栏上的通知.
 * @author Administrator
 *
 */
public class NotificationActivity extends Activity {
	
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.notification_layout);
		NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		
		// 当用户点击通知已经跳转到另外的一个页面时如果想取消先前已经有的通知则可以在这里调用cancel()方法.里面填入的参数是之前在MainActivty.java调用notify方法的第一个参数.
		notificationManager.cancel(1);
	};
	
}