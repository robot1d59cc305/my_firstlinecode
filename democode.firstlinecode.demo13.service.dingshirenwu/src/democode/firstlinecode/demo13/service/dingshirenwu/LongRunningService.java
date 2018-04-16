package democode.firstlinecode.demo13.service.dingshirenwu;

import java.util.Date;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

/**
 * 长时间运行服务.
 * Android 中的定时任务一般有两种实现方式，一种是使用 Java API 里提供的 Timer 类，
一种是使用 Android 的 Alarm 机制。这两种方式在多数情况下都能实现类似的效果，但 Timer
有一个明显的短板，它并不太适用于那些需要长期在后台运行的定时任务。我们都知道，为
了能让电池更加耐用，每种手机都会有自己的休眠策略，Android 手机就会在长时间不操作
的情况下自动让 CPU 进入到睡眠状态，这就有可能导致 Timer 中的定时任务无法正常运行。
而 Alarm 机制则不存在这种情况，它具有唤醒 CPU 的功能，即可以保证每次需要执行定时
任务的时候 CPU 都能正常工作。需要注意，这里唤醒 CPU 和唤醒屏幕完全不是同一个概念，
千万不要产生混淆。

另外需要注意的是，从 Android 4.4 版本开始，Alarm 任务的触发时间将会变得不准确，
有可能会延迟一段时间后任务才能得到执行。这并不是个 bug，而是系统在耗电性方面进行
的优化。系统会自动检测目前有多少 Alarm 任务存在，然后将触发时间将近的几个任务放在
一起执行，这就可以大幅度地减少 CPU 被唤醒的次数，从而有效延长电池的使用时间。
当然，如果你要求 Alarm 任务的执行时间必须准备无误，Android 仍然提供了解决方案。
使用 AlarmManager 的 setExact()方法来替代 set()方法，就可以保证任务准时执行了。
 * @author Administrator
 *
 */
public class LongRunningService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		
		return null;
	}

	public int onStartCommand(Intent intent, int flags, int startId) {
		
		new Thread(new Runnable(){
			
			@Override
			public void run() {
				Log.d("LongRunningService","executed at" + new Date().toString());
			}
			
		}).start();
		
		// 1.AlarmManager类
		AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
		
		// 2.隔多少秒的时间? 需要乘以1000才会是30秒.
		int anHour = 30 * 1000;
		
		long triggerAtTime = SystemClock.elapsedRealtime() + anHour;
		
		Intent i = new Intent(this,AlarmReceiver.class);
		
		PendingIntent pi = PendingIntent.getBroadcast(this,0,i,0);
		
		/**
		 * 
		 * 第一个参数是一个整型参数，用于指定 AlarmManager 的
		 * 工作类型，有四种值可选，分别是 ELAPSED_REALTIME、ELAPSED_REALTIME_WAKEUP、
		   RTC 和 RTC_WAKEUP。其中 ELAPSED_REALTIME 表示让定时任务的触发时间从系统开
		       机开始算起，但不会唤醒 CPU。ELAPSED_REALTIME_WAKEUP 同样表示让定时任务的触
		       发时间从系统开机开始算起，但会唤醒 CPU。RTC 表示让定时任务的触发时间从 1970 年 1
		       月 1 日 0 点开始算起，但不会唤醒 CPU。RTC_WAKEUP 同样表示让定时任务的触发时间从
		   1970 年 1 月 1 日 0 点开始算起，但会唤醒 CPU。使用 SystemClock.elapsedRealtime()方法可
		       以获取到系统开机至今所经历时间的毫秒数，使用 System.currentTimeMillis()方法可以获取
		       到 1970 年 1 月 1 日 0 点至今所经历时间的毫秒数。
		       
		       第二个参数，这个参数就好理解多了，就是定时任务触发的时间，以毫秒为
		       单位。如果第一个参数使用的是 ELAPSED_REALTIME 或 ELAPSED_REALTIME_WAKEUP，
		        则这里传入开机至今的时间再加上延迟执行的时间。如果第一个参数使用的是 RTC 或
		   RTC_WAKEUP，则这里传入 1970 年 1 月 1 日 0 点至今的时间再加上延迟执行的时间。
		   
		       第三个参数是一个 PendingIntent，对于它你应该已经不会陌生了吧。这里我们一般会调
		       用 getBroadcast()方法来获取一个能够执行广播的 PendingIntent。这样当定时任务被触发的时
		       候，广播接收器的 onReceive()方法就可以得到执行。    
		 */
		manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pi);
		
		return super.onStartCommand(intent, flags, startId);
	};
	
}