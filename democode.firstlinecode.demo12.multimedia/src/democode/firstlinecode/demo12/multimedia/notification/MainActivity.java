package democode.firstlinecode.demo12.multimedia.notification;

import java.io.File;

import com.example.democode.firstlinecode.demo12.notifications.R;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import democode.firstlinecode.demo12.multimedia.notification.NotificationActivity;

/**
 * 
 * MainActivity:
 * 1.向应用程序推送一条通知.
 * 2.手机程序发出振动来通知用户.
 * 3.这里面LED没有如愿显示出来效果(失败).
 * @author Administrator
 *
 */
public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		((Button) findViewById(R.id.activity_main_button1)).setOnClickListener(this);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.activity_main_button1:
			
			// 1,2,3,4是最基本的一个通知的使用步骤.
			
			// 1.获取NotificationManager类的实例.
			NotificationManager manager = (NotificationManager)
			getSystemService(NOTIFICATION_SERVICE);
			
			// 2.获取Notification类的实例.
			Notification notification = new Notification(R.drawable.
			ic_launcher, "This is ticker text", System.currentTimeMillis());
			
				// 这个PendingIntent是在某个合适的时机才会得到触发,而不是向Intent一样,写了相关的代码就立即触发.加入了这两行代码之后点击通知才会有反应.
				Intent intent = new Intent(MainActivity.this,NotificationActivity.class);
				PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
				
				// 通知的高级技巧,通过手机的铃声来通知用户.
				Uri uri = Uri.fromFile(new File("/system/media/audio/ringtones/Basic_tone.ogg"));
				notification.sound = uri;
				
				// 通知的高级技巧,通过手机的振动来通知用户.
				long[] vibrates = {0,1000,1000,1000};
				notification.vibrate = vibrates;
				
				// 通知的高级技巧,通过手机的LED灯来通知用户.
//				notification.ledARGB = Color.GREEN;
//				notification.ledOnMS = 1000;
//				notification.ledOffMS = 1000;
//				notification.flags = Notification.FLAG_SHOW_LIGHTS;
				notification.defaults = Notification.DEFAULT_ALL; //通过这条设置可以不用进行上面这么繁多的设置,它会根据手机的环境来决定播放什么铃声.
			
			// 3.通过setLatestEventInfo方法设置通知的内容 如果不需要给通知加上一个点击事件,则第四个参数写null就可以,如果说需要给通知加上一个点击事件则将PendingIntent对象相关的属性放入这里.
			notification.setLatestEventInfo(this, "This is content title","This is content text",pendingIntent);
			
			// 4.通过NotificationManager类的  notify方法设置执行这条notification.
			manager.notify(1,notification);
			
			break;

		default:
			break;
		}
	}
	
}