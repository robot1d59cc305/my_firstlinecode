package democode.firstlinecode.demo9.receiver.index;
import com.example.democode.firstlinecode.demo9.receiver.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import democode.firstlinecode.demo9.receiver.bendiguangbo.BenDiGuangBoActivity;
import democode.firstlinecode.demo9.receiver.dynamic_registration_to_monitor_network_changes.DynamicActivity;
import democode.firstlinecode.demo9.receiver.sendzidingyiguangbo_biaozhun.MyBroadcastReceiverActivity;
import democode.firstlinecode.demo9.receiver.tool.BaseActivity;

/**
 * 
 * @author Administrator
 *
 */
public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	/**
	 * 动态注册监听网络
	 * @param v
	 */
	public void dynamicActivity(View v) {
		Intent intent = new Intent(MainActivity.this,DynamicActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 实现发送自定义广播,并且进行接受.
	 * @param v
	 */
	public void broadcastreceiver(View v) {
		Intent intent = new Intent(MainActivity.this,MyBroadcastReceiverActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 发送本地广播
	 */
	public void bendiguangbo(View v) {
		Intent intent = new Intent(MainActivity.this,BenDiGuangBoActivity.class);
		startActivity(intent);
	}
	
}	