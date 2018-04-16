package com.democode.firstlinecode.demo5.activitylaunchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Activity 的SingleInstance启动模式之SingleInstance2类.
 * 这个Activity单独存在于一个窗口当中.
 * @author Administrator
 *
 */
public class SingleInstance2 extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.singleinstance2);
		Log.d("onCreate",this.toString()+"-->TaskId:"+getTaskId()+"-->Hash:"+hashCode());
	}
	
	/**
	 * 
	 * @param v
	 */
	public void SingleInstance2Button1(View v) {
		Intent intent = new Intent(SingleInstance2.this,SingleInstance3.class);
		startActivity(intent);
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
