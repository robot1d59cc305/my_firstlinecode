package democode.firstlinecode.demo13.service.service;

import com.example.democode.firstlinecode.demo12.service.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Activity与服务进行通信
 * 1.这里提供一个界面,让用户使用Activity与服务进行通信的功能,基于BasicService进行修改,主要实现绑定服务和解绑服务.
 * 2.同时也提供启动服务和停止服务,当然是在BasicService上进行定制的.
 * @author Administrator
 *
 */
public class ActivityServiceCommunicationJieMian extends Activity implements OnClickListener{
	
	/**
	 * 
	 */
	private Intent service;
	
	/**
	 * 1.准备Binder部分的引用类型属性作为成员变量  AndroidServiceCommunicationService服务当中用于管理下载功能部分的Binder. 这个属性的实例由serviceConnection属性当中获取即可.
	 */
	private AndroidServiceCommunicationService.DownloadBinder downloadBinder;
	
	/**
	 * 2.通过ServiceConnection类进行解绑和绑定业务的实现.以及对1中业务的调用.
	 * 当活动与服务进行通信的时候会调用的类.
	 * 一般进行绑定和解绑的时候都会在这个匿名内部类当中对绑定和解绑的方法进行调用,我们就把绑定时需要实现的业务和解绑时需要实现的业务的代码写在这个匿名内部类对应的方法里面即可.
	 */
	private ServiceConnection serviceConnection = new ServiceConnection(){

		/**
		 * 当活动与服务进行绑定的时候会进行调用的方法.
		 */
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			/* 1.
			 * 在这个方法当中要获取Service中的Binder部分,可以通过这个方法中的service参数获,然后再通过强转的方式转换为AndroidServiceCommunicationService.
			 * DownloadBinder类型的数据并且赋值给downloadBinder就完成了Service的获取. 
			 * */
			downloadBinder = (AndroidServiceCommunicationService.DownloadBinder)service;
			
			// 2.调用开始下载的功能.
			downloadBinder.startDownload();
			
			// 3.调用返回数据的功能.
			downloadBinder.getProgress();
		}

		/**
		 * 当活动与服务解绑的时候会进行调用的方法.
		 */
		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.d("ServiceConnection","服务与活动之间解除绑定");
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 3.做好视图资源的加载工作.
		setContentView(R.layout.androidservicejiemian2);
		
		((Button) findViewById(R.id.androidservicejiemian2_button1)).setOnClickListener(this);
		((Button) findViewById(R.id.androidservicejiemian2_button2)).setOnClickListener(this);
		((Button) findViewById(R.id.androidservicejiemian2_button3)).setOnClickListener(this);
		((Button) findViewById(R.id.androidservicejiemian2_button4)).setOnClickListener(this);
		
		// 4.指定Activity到Service.
		service = new Intent(ActivityServiceCommunicationJieMian.this,AndroidServiceCommunicationService.class);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		
			// 启动服务
			case R.id.androidservicejiemian2_button1:
				 startService(service);
				 break;
				 
			// 停止服务
			case R.id.androidservicejiemian2_button2:
				 stopService(service);
				 break;
				 
			// 绑定服务
			case R.id.androidservicejiemian2_button3:
				 /*
				  * 5.通过调用ContextWrapper类中的bindService方法,将2,4中的资源传递进去,并且指定一个参数.来实现活动与服务绑定的目的.
				  * 这里传入 BIND_AUTO_CREATE 表示在活动和服务进行绑定后自动创建服务。这会使得 MyService 中的 onCreate()方法得到执行，但 onStartCommand()方法不会执行。
				  * */
				 super.bindService(service,serviceConnection,BIND_AUTO_CREATE);
				 break;
				 
			// 解绑服务
			case R.id.androidservicejiemian2_button4:
				 /* 6.通过调用ContextWrapper类中的unbindService方法,将2中的资源传递进去,来实现活动与服务解除绑定的目的. 
				  * 但是这里有一个公有的bug,不管是在我的程序还是在郭淼给我的程序当中如果反复的点击这个按钮那么就会开始报错. 
				  * 我本来想通过限制调用这个方法从而只让这个方法调用一次来达到避免多次调用报错的目的.
				  * 但很显然这个问题不是这么简单就能够解决.服务的声明周期有些复杂,有些方法会在一定的情况下调用,比如在xx和xx方法调用的时候它才可以调用,不然不行.
				  * */
					 unbindService(serviceConnection);
				 break;
				 
			default:
				 break;
				 
		}
		
	}
	
}