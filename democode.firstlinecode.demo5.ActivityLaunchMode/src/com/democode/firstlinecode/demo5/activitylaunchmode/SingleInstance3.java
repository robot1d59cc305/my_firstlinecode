package com.democode.firstlinecode.demo5.activitylaunchmode;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Activity 的SingleInstance启动模式之SingleInstance3类.
 * SingleInstance3窗口会直接退出到SingleInstance窗口.
 * @author Administrator
 *
 */
public class SingleInstance3 extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.singleinstance3);
		Log.d("onCreate",this.toString()+"-->TaskId:"+getTaskId()+"-->Hash:"+hashCode());
	}
	
	/**
	 * 
	 * @param v
	 */
	public void SingleInstance3Button1(View v) {
		
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.d("onStart",this.toString()+"-->TaskId:"+getTaskId()+"-->Hash:"+hashCode());
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.d("onResume",this.toString()+"-->TaskId:"+getTaskId()+"-->Hash:"+hashCode());
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.d("onPause",this.toString()+"-->TaskId:"+getTaskId()+"-->Hash:"+hashCode());
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.d("onStop",this.toString()+"-->TaskId:"+getTaskId()+"-->Hash:"+hashCode());
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("onDestroy",this.toString()+"-->TaskId:"+getTaskId()+"-->Hash:"+hashCode());
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("onRestart",this.toString()+"-->TaskId:"+getTaskId()+"-->Hash:"+hashCode());
	}
	
}