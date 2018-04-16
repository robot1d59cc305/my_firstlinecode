package democode.firstlinecode.demo9.receiver.bendiguangbo;

import com.example.democode.firstlinecode.demo9.receiver.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Toast;

/**
 * 发送本地广播
 * @author Administrator
 *
 */
public class BenDiGuangBoActivity extends Activity {
	
	private IntentFilter intentFilter;
	
	// 这个类使用来管理所有的本地广播.
	private LocalBroadcastManager localBroadManager;
	
	// 自定义的本地广播
	private LocalReceiver localReceiver;
	
	/**
	 * 
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 设置顶级视图
		setContentView(R.layout.bendiguangbo);
	}
	
	/**
	 * 发送本地广播,处理用户
	 */
	public void bendiguangbo(View v) {
		// 获得LocalBroadcastManager类的实例 
		localBroadManager = LocalBroadcastManager.getInstance(this);
		
			// 这两行要在按钮被点击的时候写到一块.
			Intent intent = new Intent("com.example.broadcast.receiver");
			localBroadManager.sendBroadcast(intent);
		
		// 获取intentFilter实例
		intentFilter = new IntentFilter();
		
		// 在intentFilter中添加我们要发送的广播的地址
		intentFilter.addAction("com.example.broadcast.receiver");
		
		// 获取LocalReceiver类的实例,处理我们自身的业务逻辑.
		localReceiver = new LocalReceiver();
		
		// 调用localBroadManager来注册,发送广播.
		localBroadManager.registerReceiver(localReceiver, intentFilter);
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		// 卸载广播.
		localBroadManager.unregisterReceiver(localReceiver);
	}
	
	/**
	 * 本地广播
	 * @author Administrator
	 *
	 */
	class LocalReceiver extends BroadcastReceiver {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			Toast.makeText(context,"这是我们自己编写的本地广播",Toast.LENGTH_LONG).show();
		}
		
	}
	
}