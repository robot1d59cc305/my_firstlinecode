package democode.firstlinecode.demo13.service.dingshirenwu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 通过广播调用定时任务服务处理.
 * @author Administrator
 *
 */
public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		/*
		 * 每隔三十秒启动服务之后就会重新调用这里面的代码,然后通过这里的代码再次启动再次设置而不是启动了一次就不启动了.
		 * */
		Intent i = new Intent(context, LongRunningService.class);
		context.startService(i);
	}

}