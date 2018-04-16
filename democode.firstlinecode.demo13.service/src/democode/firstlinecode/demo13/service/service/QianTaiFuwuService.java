package democode.firstlinecode.demo13.service.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import democode.firstlinecode.demo13.service.main.MainActivity;

/**
 * 前台服务
 * 1.为什么要使用前台服务? 因为有可能在业务上有需要去处理这些前台的业务,以及避免被系统杀掉后台服务的进程.
 * @author Administrator
 *
 */
public class QianTaiFuwuService extends Service {
	
	/**
	 * 
	 */
	@Override
	public IBinder onBind(Intent intent) {
		
		return null;
	}
	
	/**
	 * 创建资源的方法.
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		
		// 1.创建一个Notification对象.
		Notification notification = new Notification();
		
		// 2.准备一个Intent,跳转到MainActivity.class的位置.
		Intent intent = new Intent(this,MainActivity.class);
		
		// 3.通过调用PendingIntent类中的getActivity方法,准备四个参数,第一个参数为当前类的实例,第二个参数为0,第三个参数调用2中的对象,第四个参数为0.
		PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);
		
		/* 4.通过1中的对象调用其中的setLatestEventInfo方法 这个方法是编写用户点击了发出的通知之后需要做出的发应,准备四个参数 
		 * 第一个参数为当前类的实例,第二个参数为标题的字符串,第三个参数为内容的字符串,第四个参数为3中的PendingIntent对象.
		 * */
		notification.setLatestEventInfo(this,"前台服务","这是前台服务的世界",pendingIntent);
		
		// 5.调用Service类当中的startForeground方法.给这个notification传入一个id名称,以及1中的notification对象.
		super.startForeground(1,notification);
		
		// 6.通过Log打印此方法执行成功的信息.
		Log.d("QianTaiFuwuService","onCreate executed");
		
	}

}