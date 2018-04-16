package democode.firstlinecode.demo13.service.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * 这个Service提供(启动和停止,绑定和解绑)服务的功能.
 * @author Administrator
 *
 */
public class AndroidServiceCommunicationService extends Service {

	/**
	 * 下载Binder,AndroidServiceCommunicationService中管理下载功能的部分.
	 * 作为一个引用类型的成员变量放置,让ActivityServiceCommunicationJieMian.java文件可以很好的放置.
	 */
	private DownloadBinder downloadBinder = new DownloadBinder();
	
	/**
	 * 
	 */
	@Override
	public IBinder onBind(Intent intent) {
		return downloadBinder;
	}

	/**
	 * onCreate()方法会在服务创建的时候调用.
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("BasicService", "onCreate execute");
	}
	
	/**
	 * onStartCommand()方法会在每次服务启动的时候调用.
	 * 通常情况下，如果我们希望服务一旦启动就立刻去执行某个动作，就可以将逻辑写在onStartCommand()方法里。 而当服务销毁时，我们又应该在
	 * onDestroy()方法中去回收那些不再使用的资源。
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("BasicService", "onStartCommand");
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

	/**
	 * 在AndroidServiceCommunicationService中提供一个下载功能,然后在活动中可以决定合适开始下载,以及随时查看下载进度.
	 * 模拟的方法.
	 * @author Administrator
	 * 
	 */
	class DownloadBinder extends Binder {

		/**
		 * 开始下载
		 */
		public void startDownload() {
			Log.d("MyService", "startDownload executed");
		}

		/**
		 * 返回进度
		 */
		public int getProgress() {
			Log.d("MyService", "getProgress executed");
			return 0;
		}

	}

}