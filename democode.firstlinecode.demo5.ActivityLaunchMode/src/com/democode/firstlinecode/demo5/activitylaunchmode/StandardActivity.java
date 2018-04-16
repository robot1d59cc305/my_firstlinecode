package com.democode.firstlinecode.demo5.activitylaunchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * 使用StandardActivity类,来测试,当Activity的启动模式为standard时的状态.
 * 最重要的实际上是你要能够自己观察出这些启动模式之间的不同以及生命周期的变化.
 * @author Administrator
 *
 */
public class StandardActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.standardlayout);
		Log.d("onCreate",this.toString()+"\tTaskId:"+getTaskId()+"\tHash:"+hashCode());
	}
	
	/**
	 * 用于对StandardActivityButton1按钮的业务编写.通过点击这个按钮,看出当Activity的启动模式为Standard的时候是一个什么样子的.
	 * @param v
	 */
	public void StandardActivityButton1(View v) {
		Intent intent = new Intent(StandardActivity.this,StandardActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 跳转到SingleTopActivity界面.用来展示当Activity的启动模式为SingTop的时候是一个什么样的状态.
	 * @param v
	 */
	public void StandardActivityButton2(View v) {
		Intent intent = new Intent(StandardActivity.this,SingleTopActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 跳转到SingleTaskActivity界面,用来展示当Activity的启动模式为singletask的时候是一个什么样的状态.
	 * @param v
	 */
	public void SingleTaskActivityButton3(View v) {
		Intent intent= new Intent(StandardActivity.this,SingleTaskActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 
	 * @param v
	 */
	public void SingleInstanceButton4(View v) {
		Intent intent = new Intent(StandardActivity.this,SingleInstance.class);
	    startActivity(intent);
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