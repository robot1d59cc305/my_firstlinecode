package com.democode.firstlinecode.demo6.activityjob;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * �����ڹ�������,ÿһ��ͬ�¶���ά�����Լ���һ�ݴ���,��ô���˵����һЩҵ��Խӵ������ô��?ͬ����Ҫʹ����������Կ��ܻ�����鷳����һ����Щ����Ӧ����ô��,��ô�Ϳ���ȥ��дһ�������ķ�������.
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
		
		// �����ζ��һ������������˵��BaseActivity�����ť"����"֮��,�ͻ��˳�����.....
		ActivityCollector.addActivity(this);
		ActivityCollector.finishAll();
	}
	
	/**
	 * ҵ��Խ�,�����е�ʱ��Է�ֻҪ�������API��д�Ϳ���ͨ��Intent�����ӵ�����ߵ�������.
	 */
	public static void actionStart(Context context,String data1,String data2) {
		Intent intent = new Intent(context,WorkConnectActivity.class);
		intent.putExtra("data1",data1);
		intent.putExtra("data2",data2);
		context.startActivity(intent);
	}
	
}