package democode.firstlinecode.demo9.receiver.dynamic_registration_to_monitor_network_changes;

import com.example.democode.firstlinecode.demo9.receiver.R;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;
import democode.firstlinecode.demo9.receiver.tool.BaseActivity;

/**
 * 动态注册接受系统广播用于监听网络变化
 * @author Administrator
 *
 */
public class DynamicActivity extends BaseActivity {
	
	/**
	 * 	通过这个类来接受系统发出的广播.
	 */
	private IntentFilter intentFilter;
	
	/**
	 * 接受广播信息后处理业务
	 */
	private NetworkChangeReceiver networkChangeReceiver;
	
	/**
	 * 创建视图
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 设置布局文件
		setContentView(R.layout.activity_main);
		
		// 1.使用这个类来接受广播
		intentFilter = new IntentFilter();
		
		// 2.动态注册,写入值来接受系统的广播
		intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
		
		// 3.实例化广播接收器类
		networkChangeReceiver = new NetworkChangeReceiver();
		
		// 4.注册服务
		registerReceiver(networkChangeReceiver, intentFilter);
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		// 卸载广播
		unregisterReceiver(networkChangeReceiver);
	}
	
	/**
	 * 
	 * @author Administrator
	 *
	 */
	class NetworkChangeReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			
			// 通过Activity类中的getSystemService方法获得ConnectivityManager类的实例,使用这个类的实例可以获得网络有关的信息
			ConnectivityManager connectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
			
			// 通过connectionManager类中的getActiveNetworkInfo方法2获取到NetworkInfo类的实例.
			NetworkInfo networkInfo = connectionManager.getActiveNetworkInfo();
			
			// 判断networkInfo以及networkInfo的isAvailable()方法得到的boolean结果是否为true如果为true则说明当前的网络是开启的状态.
			if (networkInfo != null && networkInfo.isAvailable()) {
				Toast.makeText(context,"network is available",Toast.LENGTH_LONG).show();
			} else { // 否则则说明网络并没有开启已经关闭
				Toast.makeText(context,"network is unavailable",Toast.LENGTH_LONG).show();
			}
			
		}
		
	} 
	
}