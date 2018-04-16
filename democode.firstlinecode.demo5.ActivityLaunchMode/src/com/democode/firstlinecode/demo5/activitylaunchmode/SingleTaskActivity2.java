package com.democode.firstlinecode.demo5.activitylaunchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * SingleTaskActivity2的启动模式为默认的Standard
 * @author Administrator
 *
 */
public class SingleTaskActivity2 extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("onCreate",this.toString()+"\tTaskId:"+getTaskId()+"\tHash:"+hashCode());
		
		setContentView(R.layout.singletask2);
		
		Button button = (Button) findViewById(R.id.SingleTaskActivity2Button1);				
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SingleTaskActivity2.this,SingleTaskActivity3.class);
				startActivity(intent);
			}
			
		});
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.d("onStart",this.toString()+"\tTaskId:"+getTaskId()+"\tHash:"+hashCode());
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.d("onResume",this.toString()+"\tTaskId:"+getTaskId()+"\tHash:"+hashCode());
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.d("onPause",this.toString()+"\tTaskId:"+getTaskId()+"\tHash:"+hashCode());
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.d("onStop",this.toString()+"\tTaskId:"+getTaskId()+"\tHash:"+hashCode());
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("onDestroy",this.toString()+"\tTaskId:"+getTaskId()+"\tHash:"+hashCode());
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("onRestart",this.toString()+"\tTaskId:"+getTaskId()+"\tHash:"+hashCode());
	}
	
}