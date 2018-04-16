package com.democode.firstlinecode.demo5.activitylaunchmode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * ʹ��StandardActivity��,������,��Activity������ģʽΪstandardʱ��״̬.
 * ����Ҫ��ʵ��������Ҫ�ܹ��Լ��۲����Щ����ģʽ֮��Ĳ�ͬ�Լ��������ڵı仯.
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
	 * ���ڶ�StandardActivityButton1��ť��ҵ���д.ͨ����������ť,������Activity������ģʽΪStandard��ʱ����һ��ʲô���ӵ�.
	 * @param v
	 */
	public void StandardActivityButton1(View v) {
		Intent intent = new Intent(StandardActivity.this,StandardActivity.class);
		startActivity(intent);
	}
	
	/**
	 * ��ת��SingleTopActivity����.����չʾ��Activity������ģʽΪSingTop��ʱ����һ��ʲô����״̬.
	 * @param v
	 */
	public void StandardActivityButton2(View v) {
		Intent intent = new Intent(StandardActivity.this,SingleTopActivity.class);
		startActivity(intent);
	}
	
	/**
	 * ��ת��SingleTaskActivity����,����չʾ��Activity������ģʽΪsingletask��ʱ����һ��ʲô����״̬.
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