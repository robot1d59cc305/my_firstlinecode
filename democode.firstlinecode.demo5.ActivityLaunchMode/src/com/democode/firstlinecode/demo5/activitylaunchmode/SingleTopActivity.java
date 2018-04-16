package com.democode.firstlinecode.demo5.activitylaunchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * 最重要的实际上是你要能够自己观察出这些启动模式之间的不同以及生命周期的变化.
 * @author Administrator
 *
 */
public class SingleTopActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.singletop);
		Log.d("onCreate",this.toString()+"\tTaskId:"+getTaskId()+"\tHash:"+hashCode());
	}
	
	/**
	 * 通过点击这个按钮,不断的创建SingleTopActivity这个Activity让用户看到当Activity中的启动模式为singleTopActivity的时候的状态是什么样的.
	 * @param v
	 */
	public void SingleTopActivityButton1(View v) {
		Intent intent = new Intent(SingleTopActivity.this,SingleTopActivity.class);
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