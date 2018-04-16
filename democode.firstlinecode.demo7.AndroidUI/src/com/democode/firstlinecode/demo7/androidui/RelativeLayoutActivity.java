package com.democode.firstlinecode.demo7.androidui;

import android.app.Activity;
import android.os.Bundle;

/**
 * 
 * 针对相对布局的一些案例.
 * @author Administrator
 *
 */
public class RelativeLayoutActivity extends Activity {
	
	public static int resLayoutId;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(resLayoutId);
	}

	public static int getResLayoutId() {
		return resLayoutId;
	}

	public static void setResLayoutId(int resLayoutId) {
		RelativeLayoutActivity.resLayoutId = resLayoutId;
	}
	
}