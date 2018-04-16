package com.democode.firstlinecode.demo7.androidui;

import com.democode.firstlinecode.demo7.basiclistview.ListViewArrayActivity;
import com.democode.firstlinecode.demo7.customlistview.FruitActivity;
import com.democode.firstlinecode.demo7.liaotian.LiaoTianActivity;
import com.democode.firstlinecode.demo7.tool.ActivityManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 这个app的主活动程序,为其它的活动提供了入口.
 * @author Administrator
 */
public class IndexActivity extends Activity {
	
	/*
	 * 这下面的属性实际上都是indexlayout.xml文件里面的一些按钮.
	 * 先定义一些属性,当做成员变量放在这个类里面.
	 * */
	
	private Button IndexActivityButton1_Go_FrequentlyUIActivity;
	
	private Button IndexActivityButton2_Go_FrequentlyUIActivity;
	
	private Button IndexActivityButton3_Go_RelativeLayoutActivity;
	
	private Button IndexActivityButton4_Go_RelativeLayoutActivity;
	
	private Button IndexActivityButton5_Go_FrameLayoutActivity;
	
	private Button IndexActivityButton6_Go_TableLayoutActivity;
	
	private Button IndexActivityButton7_Go_IncludeActivity;
	
	private Button IndexActivityButton8_Go_CustomControlActivity;
	
	private Button IndexActivityButton9_Go_ListViewArrayActivity;
	
	private Button IndexActivityButton10_Go_FruitActivity;
	
	private Button NinePatchActivity;
	
	private Button IndexActivityButton12_Go_LiaoTianActivity;
	
	private Intent intent;
	
	/**
	 * 使用这个方法去加载,初始化属性,和为上面的属性添加响应事件.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.indexlayout);
		
		IndexActivityButton1_Go_FrequentlyUIActivity = (Button) findViewById(R.id.IndexActivityButton1_Go_FrequentlyUIActivity);
		IndexActivityButton2_Go_FrequentlyUIActivity = (Button) findViewById(R.id.IndexActivityButton2_Go_LinearLayoutActivity);
		IndexActivityButton3_Go_RelativeLayoutActivity = (Button) findViewById(R.id.IndexActivityButton3_Go_RelativeLayoutActivity);
		IndexActivityButton4_Go_RelativeLayoutActivity = (Button) findViewById(R.id.IndexActivityButton4_Go_RelativeLayoutActivity);
		IndexActivityButton5_Go_FrameLayoutActivity    = (Button) findViewById(R.id.IndexActivityButton5_Go_FrameLayoutActivity);
		IndexActivityButton6_Go_TableLayoutActivity    = (Button) findViewById(R.id.IndexActivityButton6_Go_TableLayoutActivity);
		IndexActivityButton7_Go_IncludeActivity        = (Button) findViewById(R.id.IndexActivityButton7_Go_IncludeActivity);
		IndexActivityButton8_Go_CustomControlActivity  = (Button) findViewById(R.id.IndexActivityButton8_Go_CustomControlActivity);
		IndexActivityButton9_Go_ListViewArrayActivity  = (Button) findViewById(R.id.IndexActivityButton9_Go_ListViewArrayActivity);
		IndexActivityButton10_Go_FruitActivity         = (Button) findViewById(R.id.IndexActivityButton10_Go_FruitActivity);
		NinePatchActivity = (Button) findViewById(R.id.NinepatchActivityButton11_Go_nine_patch);
		IndexActivityButton12_Go_LiaoTianActivity      = (Button) findViewById(R.id.IndexActivityButton12_Go_LiaoTianActivity);
		
		IndexActivityButton1_Go_FrequentlyUIActivity.setOnClickListener(new MyOnClickListener());
		IndexActivityButton2_Go_FrequentlyUIActivity.setOnClickListener(new MyOnClickListener());
		IndexActivityButton3_Go_RelativeLayoutActivity.setOnClickListener(new MyOnClickListener());
		IndexActivityButton4_Go_RelativeLayoutActivity.setOnClickListener(new MyOnClickListener());
		IndexActivityButton5_Go_FrameLayoutActivity.setOnClickListener(new MyOnClickListener());
		IndexActivityButton6_Go_TableLayoutActivity.setOnClickListener(new MyOnClickListener());
		IndexActivityButton7_Go_IncludeActivity.setOnClickListener(new MyOnClickListener());
		IndexActivityButton8_Go_CustomControlActivity.setOnClickListener(new MyOnClickListener());
		IndexActivityButton9_Go_ListViewArrayActivity.setOnClickListener(new MyOnClickListener());
		IndexActivityButton10_Go_FruitActivity.setOnClickListener(new MyOnClickListener());
		NinePatchActivity.setOnClickListener(new MyOnClickListener());
		IndexActivityButton12_Go_LiaoTianActivity.setOnClickListener(new MyOnClickListener());
		
		ActivityManager.addActivity(this);
	}
	
	/**
	 * 通过在类中自定义一个类,并且实现OnClickListener接口中的方法来达到为这些按钮添加响应事件的效果.
	 * @author Administrator
	 *
	 */
	public class MyOnClickListener implements OnClickListener {
		
		@Override 
		public void onClick(View v) {
			
			switch (v.getId()) {
				case R.id.IndexActivityButton1_Go_FrequentlyUIActivity:
					 intent = new Intent(IndexActivity.this,FrequentlyUIActivity.class);
					 startActivity(intent);
					break;
				case R.id.IndexActivityButton2_Go_LinearLayoutActivity:
					 intent = new Intent(IndexActivity.this,LinearLayoutActivity.class);
					 startActivity(intent);
					 break;
				case R.id.IndexActivityButton3_Go_RelativeLayoutActivity:
					 RelativeLayoutActivity.setResLayoutId(R.layout.relativelayout);
					 intent = new Intent(IndexActivity.this,RelativeLayoutActivity.class);
					 startActivity(intent);
					 break;
				case R.id.IndexActivityButton4_Go_RelativeLayoutActivity:
					 RelativeLayoutActivity.setResLayoutId(R.layout.relativelayout2);
					 intent = new Intent(IndexActivity.this,RelativeLayoutActivity.class);
					 startActivity(intent);
					 break;
				case R.id.IndexActivityButton5_Go_FrameLayoutActivity:
					 intent = new Intent(IndexActivity.this,FrameLayoutActivity.class);
					 startActivity(intent);
					 break;
				case R.id.IndexActivityButton6_Go_TableLayoutActivity:
					intent = new Intent(IndexActivity.this,TableLayoutActivity.class);
					startActivity(intent);
					break;
				case R.id.IndexActivityButton7_Go_IncludeActivity:
					IncludeActivity.setRes_layout_id(R.layout.title);
					intent = new Intent(IndexActivity.this,IncludeActivity.class);
					startActivity(intent);
					break;
				case R.id.IndexActivityButton8_Go_CustomControlActivity:
					IncludeActivity.setRes_layout_id(R.layout.customcontrollayout);
					intent = new Intent(IndexActivity.this,IncludeActivity.class);
					startActivity(intent);
					break;
				case R.id.IndexActivityButton9_Go_ListViewArrayActivity:
					intent = new Intent(IndexActivity.this,ListViewArrayActivity.class);
					startActivity(intent);
					break;
				case R.id.IndexActivityButton10_Go_FruitActivity:
					intent = new Intent(IndexActivity.this,FruitActivity.class);
					startActivity(intent);
					break;
				case R.id.NinepatchActivityButton11_Go_nine_patch:
					intent = new Intent(IndexActivity.this,NinePatchActivity.class);
					startActivity(intent);
					break;
				case R.id.IndexActivityButton12_Go_LiaoTianActivity:
					intent = new Intent(IndexActivity.this,LiaoTianActivity.class);
					startActivity(intent);
					break;
			}
		}
		
	}
	
}