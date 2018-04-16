package com.democode.firstlinecode.demo6.activityjob;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 
 * 这个类可以让每一个类输出自己的名字.让在项目开发的时候,每一个活动对应的Activity类到底是哪一个.
 * @author Administrator
 *
 */
public class BaseActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("BaseActivity",getClass().getSimpleName());
		
		setContentView(R.layout.baseactivity);
		
		Button button = (Button) findViewById(R.id.BaseActivityButton1);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				WorkConnectActivity.actionStart(BaseActivity.this, "100", "86");
			}
			
		});
		
		ActivityCollector.addActivity(this);
	}
	
}