package com.democode.firstlinecode.demo6.activityjob;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * 这是在工作当中,每一个同事都是维护着自己的一份代码,那么如果说遇到一些业务对接的情况怎么办?同事需要使用你的类所以可能会过来麻烦你问一下这些数据应该怎么传,那么就可以去编写一个这样的方法来做.
 * @author Administrator
 */
public class WorkConnectActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.baseactivity);

		Intent intent = getIntent();
		Log.d("data1", intent.getStringExtra("data1"));
		Log.d("data2", intent.getStringExtra("data2"));
		
		// 这就意味着一到这个界面或者说在BaseActivity点击按钮"发送"之后,就会退出程序.....
		ActivityCollector.addActivity(this);
		ActivityCollector.finishAll();
	}
	
	/**
	 * 业务对接,工作中的时候对方只要按照你的API来写就可以通过Intent来连接到你这边的数据了.
	 */
	public static void actionStart(Context context,String data1,String data2) {
		Intent intent = new Intent(context,WorkConnectActivity.class);
		intent.putExtra("data1",data1);
		intent.putExtra("data2",data2);
		context.startActivity(intent);
	}
	
}