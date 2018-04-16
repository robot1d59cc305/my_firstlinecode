package com.democode.firstlinecode.demo7.androidui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * 
 * 展示"引入布局"案例的Activity.
 * @author Administrator
 *
 */
public class IncludeActivity extends Activity {

	private static int res_layout_id;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 这个方法必须要在setContentView方法之前调用.
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(res_layout_id);
	}

	public static int getRes_layout_id() {
		return res_layout_id;
	}

	public static void setRes_layout_id(int res_layout_id) {
		IncludeActivity.res_layout_id = res_layout_id;
	}
	
}