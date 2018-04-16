package democode.firstlinecode.demo13.service.service;

import com.example.democode.firstlinecode.demo12.service.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Android服务界面
 * 1.启动停止BasicService
 * @author Administrator
 */
public class AndroidServiceJieMianActivity extends Activity implements OnClickListener{
	
	/**
	 * Intent
	 */
	private Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.androidservicejiemian);
		
		// 查找获取资源ID并填对应的响应事件.
		Button button = (Button) findViewById(R.id.androidservicejiemian_button1);
		Button button2 = (Button) findViewById(R.id.androidservicejiemian_button2);
		button.setOnClickListener(this);
		button2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
			case R.id.androidservicejiemian_button1:
				 intent = new Intent(AndroidServiceJieMianActivity.this,BasicService.class);
				 startService(intent);
				break;
			
			case R.id.androidservicejiemian_button2:
				 intent = new Intent(AndroidServiceJieMianActivity.this,BasicService.class);
				 stopService(intent);
				break;
				
			default:
				break;
		}
		
	}
	
}