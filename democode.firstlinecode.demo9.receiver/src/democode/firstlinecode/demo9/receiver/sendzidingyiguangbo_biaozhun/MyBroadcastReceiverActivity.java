package democode.firstlinecode.demo9.receiver.sendzidingyiguangbo_biaozhun;

import com.example.democode.firstlinecode.demo9.receiver.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 这是自定义的广播发送器,由这个类发送,再由MyBroadcastReceiver类进行接受,接受到我们要想发送的广播,然后去操作具体的业务.
 * @author Administrator
 *
 */
public class MyBroadcastReceiverActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.mybroacast);
		
		Button button = (Button) findViewById(R.id.mybroacast_button1);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 这里发送的是自定义广播中的标准广播.
				Intent intent = new Intent("com.example.broadcast.receiver");
				sendBroadcast(intent);
			}
			
		});
		
	}
	
}