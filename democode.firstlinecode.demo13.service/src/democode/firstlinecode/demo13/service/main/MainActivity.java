package democode.firstlinecode.demo13.service.main;

import com.example.democode.firstlinecode.demo12.service.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import democode.firstlinecode.demo13.service.service.ActivityServiceCommunicationJieMian;
import democode.firstlinecode.demo13.service.service.AndroidServiceJieMianActivity;
import democode.firstlinecode.demo13.service.service.MyIntentService;
import democode.firstlinecode.demo13.service.service.QianTaiFuwuService;
import democode.firstlinecode.demo13.service.thread.AndroidThreadActivity;

/**
 * 主界面
 * 1.Android多线程编程.
 * 2.Android服务的基本用法.
 * 3.Android服务的实践--后台执行定时任务.
 * @author Administrator
 *
 */
public class MainActivity extends Activity implements OnClickListener {

	/**
	 * Intent
	 */
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 设置内容视图.
		setContentView(R.layout.activity_main);
		
		// 查找获取资源ID并填对应的响应事件.
		((Button) findViewById(R.id.activity_main_button1)).setOnClickListener(this);
		((Button) findViewById(R.id.activity_main_button2)).setOnClickListener(this);
		((Button) findViewById(R.id.activity_main_button3)).setOnClickListener(this);
		((Button) findViewById(R.id.activity_main_button4)).setOnClickListener(this);
		((Button) findViewById(R.id.activity_main_button5)).setOnClickListener(this);
		((Button) findViewById(R.id.activity_main_button6)).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
			//  跳转到 Android多线程界面.
			case R.id.activity_main_button1:
				intent = new Intent(this, AndroidThreadActivity.class);
				startActivity(intent);
				break;
			// 跳转到Android服务的基本用法界面.
			case R.id.activity_main_button2:
				intent = new Intent(this, AndroidServiceJieMianActivity.class);
				startActivity(intent);
				break;
			// 跳转到Android服务与活动通信的界面.
			case R.id.activity_main_button4:
				intent = new Intent(this,ActivityServiceCommunicationJieMian.class);
				startActivity(intent);
				break;
			// 跳转到Android服务的实践--后台执行定时任务的界面.
			case R.id.activity_main_button3:
				intent = new Intent(this, AndroidThreadActivity.class);
				startActivity(intent);
				break;
			case R.id.activity_main_button5:
				intent = new Intent(this,QianTaiFuwuService.class);
			    startService(intent);
				break;
			case R.id.activity_main_button6:
				intent = new Intent(this,MyIntentService.class);
				startService(intent);
				Log.d("MyIntentService","Main Thread id is" + Thread.currentThread().getId());
			default:
				break;
		}

	}

}