package democode.firstlinecode.demo13.service.thread;

import com.example.democode.firstlinecode.demo12.service.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Android多线程编程
 * 1.在子线程中更新UI.
 * 2.解析异步消息处理机制.
 * 3.使用AsyncTask.
 * @author Administrator
 */
public class AndroidThreadActivity extends Activity implements OnClickListener{
	
	/**
	 * Intent
	 */
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 设置内容视图.
		setContentView(R.layout.androidthread);
		
		// 查找获取资源ID并填对应的响应事件.
		Button button = (Button) findViewById(R.id.androidthread_button1);
		
		// 为按钮添加响应事件.
		button.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.androidthread_button1:
			 intent = new Intent(AndroidThreadActivity.this,AndroidThreadAsynchronous.class);
			 startActivity(intent);
			break;

		default:
			break;
		}
		
	}
	
}