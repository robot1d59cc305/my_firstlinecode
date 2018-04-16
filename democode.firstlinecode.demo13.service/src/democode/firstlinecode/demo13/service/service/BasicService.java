package democode.firstlinecode.demo13.service.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * 基本的Android服务的形式,实现的方法,当用户点击启动服务或停止服务时都会在Logcat插件当中进行输出.
 * @author Administrator
 *
 */
public class BasicService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		
		return null;
	}

	/**
	 * onCreate()方法会在服务创建的时候调用.
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("BasicService","onCreate execute");
	}
	
	/**
	 * onStartCommand()方法会在每次服务启动的时候调用.
	 * 通常情况下，如果我们希望服务一旦启动就立刻去执行某个动作，就可以将逻辑写在onStartCommand()方法里。
	 * 而当服务销毁时，我们又应该在 onDestroy()方法中去回收那些不再使用的资源。
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("BasicService","onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}
	
	/**
	 * onDestroy()方法会在服务销毁的时候调用.
	 */
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("BasicService", "onDestroy executed");
	}
	
}