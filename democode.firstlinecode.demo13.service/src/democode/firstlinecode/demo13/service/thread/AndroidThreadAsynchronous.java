package democode.firstlinecode.demo13.service.thread;

import com.example.democode.firstlinecode.demo12.service.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * 用于在子线程当中更新Android UI部分,使用Android异步处理技术来解决这个技术难点.
 * @author Administrator
 *
 */
public class AndroidThreadAsynchronous extends Activity implements OnClickListener {
	
	/**
	 * 更新文本字段,通过这个字段来进行匹配操作.
	 */
	public static final int UPDATE_TEXT = 1;
	
	/**
	 * 点击按钮
	 */
	private Button androidthread_asynchronous_button;
	
	/**
	 * 文本展示
	 */
	private TextView androidthread_asynchronous_textview;
	
	/**
	 * Handler
	 */
	private Handler handler = new Handler(){
		
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
				case UPDATE_TEXT:
					 androidthread_asynchronous_textview.setText("Hello Last To Me You");
					 break;
				default:
					 break;
			}
		};
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.androidthread_asynchronous);
		
		androidthread_asynchronous_button = (Button) findViewById(R.id.androidthread_asynchronous_button);
		
		androidthread_asynchronous_button.setOnClickListener(this);
		
		androidthread_asynchronous_textview = (TextView) findViewById(R.id.androidthread_asynchronous_textview);
		
	}
	
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
			case R.id.androidthread_asynchronous_button:
				
				 // 在创建完成这个Thread对象的时候记住需要调用start()方法才能够执行这个线程.
				 new Thread(new Runnable() {
					
					@Override
					public void run() {
						// Message 是在线程之间传递的消息，它可以在内部携带少量的信息，用于在不同线程之间交换数据。
						Message message = new Message();
						
						// 
						message.what=UPDATE_TEXT;
						
						// Handler 顾名思义也就是处理者的意思，它主要是用于发送和处理消息的。发送消息一般是使用 Handler 的 sendMessage()方法，而发出的消息经过一系列地辗转处理后，最终会传递到 Handler 的 handleMessage()方法中。
						handler.sendMessage(message);
					}
					
				 }).start();
				 
				 /* 
					 new Thread(new Runnable() {
						 
						 @Override
						 public void run() {
							 androidthread_asynchronous_textview.setText("Nice to meet you");
						 }
						 
					 }).start();
					 
				       如果是调用了上面这些代码则会报下面这行错误. 
				   android.view.ViewRootImpl$CalledFromWrongThreadException: Only the original thread that created a view hierarchy can touch its views.
				 */
				
				 break;
			default :
				 break;
		}
		
	}
	
	
}