package democode.firstlinecode.demo9.receiver2;

import com.example.democode.firstlinecode.demo9.receiver2.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * 
 * @author Administrator
 *
 */
public class MyBroadcastReceiverActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	/**
	 * 
	 */
	public void broadcast(View v) {
		
		Intent intent = new Intent("com.example.broadcast.receiver");
//		sendBroadcast(intent); 无序广播
		sendOrderedBroadcast(intent, null); // 有序广播,在AndroidManifest.xml文件当中去编写广播发送的顺序.另外一个参数代表着这个广播的权限
	}
	
}