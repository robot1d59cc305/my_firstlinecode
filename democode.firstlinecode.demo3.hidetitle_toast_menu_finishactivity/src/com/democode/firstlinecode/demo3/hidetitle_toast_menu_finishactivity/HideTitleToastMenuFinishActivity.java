package com.democode.firstlinecode.demo3.hidetitle_toast_menu_finishactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

/**
 * 实现功能如下:
 * I.隐藏Activity默认自带的标题栏.
 * II.显示Toast字符展示给用户.
 * III.显示Menu展示给用户.
 * @author Administrator
 *
 */
public class HideTitleToastMenuFinishActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 1.隐藏标题栏. 这个方法必须要在setContentView方法之前调用.否则会报错.
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		// 2.使用Toast功能提示用户
		Toast.makeText(HideTitleToastMenuFinishActivity.this,"使用Toast展示信息给用户",Toast.LENGTH_SHORT).show();
		
		// 3.引入layout资源
		setContentView(R.layout.linearlayout);
		
		// 4.为linearlayout.xml文件中的bu_1按钮添加点击事件的监听
		Button button = (Button) findViewById(R.id.bu_1);
		button.setOnClickListener(new MyClickListener());
	}
	
	class MyClickListener implements OnClickListener {
		
		@Override
		public void onClick(View arg0) {
			// 在结束程序的运行之前给与用户提示.
			Toast.makeText(HideTitleToastMenuFinishActivity.this,"本提示结束之后程序将退出......",Toast.LENGTH_SHORT).show();
			// 结束关于这个Activity的运行.
			finish();
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// 调用menu文件夹下关于main.xml文件的资源
		getMenuInflater().inflate(R.menu.main,menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()) {
			case R.id.menu_1:
				Toast.makeText(HideTitleToastMenuFinishActivity.this, "谢谢您关注我们的'文件'功能!", Toast.LENGTH_SHORT);
				Log.i("info","用户点击了文件,说明用户开始对我们的产品有了一些兴趣");
				break;
			case R.id.menu_2:
				Toast.makeText(HideTitleToastMenuFinishActivity.this,"谢谢您关注我们的'关于'功能!", Toast.LENGTH_SHORT);
				Log.i("info", "用户点击了关于,说明用户开始对我们的团队有了一些兴趣");
				break;
		}
		
		return true;
	}
	
}