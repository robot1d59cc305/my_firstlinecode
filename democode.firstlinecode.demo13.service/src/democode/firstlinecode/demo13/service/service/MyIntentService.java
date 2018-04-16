package democode.firstlinecode.demo13.service.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * 
 * @author Administrator
 *
 */
public class MyIntentService extends IntentService {

	/**
	 * 可以定制这个构造器,将有参的改为自己类的名字即可.   
	 */
	public MyIntentService() {
		super("MyIntentService");
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		Log.d("MyIntentService","Thread id is" + Thread.currentThread().getId());
	}
	
	/**
	 * 
	 * 为了避免ANR异常,因此出现了第一种写法.
	 * @author Administrator
	 *
	 */
	class IntentService1 extends Service {
		
		@Override
		public int onStartCommand(Intent intent, int flags, int startId) {
			
			// 服务中的代码都是默认运行在主线程,如果直接在运行服务的时候去运行一些比较耗时的逻辑,则就很容易出现ANR异常.
			new Thread(new Runnable() {

				@Override
				public void run() {
					// 处理具体的逻辑
					
				}
				
			}).start();
			
			return super.onStartCommand(intent, flags, startId);
			
		}

		@Override
		public IBinder onBind(Intent intent) {
			return null;
		}
		
	}
	
	/**
	 * 
	 * 但是，这种服务一旦启动之后，就会一直处于运行状态，必须调用 stopService()或者
stopSelf()方法才能让服务停止下来。所以，如果想要实现让一个服务在执行完毕后自动停止
的功能，因此就出现了第二种写法.
	 * 
	 * @author Administrator
	 *
	 */
	class IntentService2 extends Service {
		
		@Override
		public int onStartCommand(Intent intent, int flags, int startId) {
			
			// 服务中的代码都是默认运行在主线程,如果直接在运行服务的时候去运行一些比较耗时的逻辑,则就很容易出现ANR异常.
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// 处理具体的逻辑
					
				}
				
			}).start();
			
			return super.onStartCommand(intent, flags, startId);
		}
		
		@Override
		public IBinder onBind(Intent intent) {
			return null;
		}
		
	}
	
	/**
	 * 虽说这种写法并不复杂，但是总会有一些程序员忘记开启线程，或者忘记调用 stopSelf()
方法。为了可以简单地创建一个异步的、会自动停止的服务，Android 专门提供了一个
IntentService 类，这个类就很好地解决了前面所提到的两种尴尬，下面我们就来看一下它的
用法。
	 * @author Administrator
	 *
	 */
	class IntentService3 extends IntentService {

		public IntentService3(String name) {
			super(name);
		}

		@Override
		public void onDestroy() {
			super.onDestroy();
			Log.d("MyIntentService","onDestroy executed");
		}
		
		@Override
		protected void onHandleIntent(Intent intent) {
			// 打印这个方法在调用时的线程id,查看id是否和正在运行的主线程的id是一致的,如果是一致的则表示可能并没有专门开辟一个子线程来处理一些比较耗时的逻辑代码.
			Log.d("MyIntentService","Thread id is" + Thread.currentThread().getId());
		}
		
	}
	
}