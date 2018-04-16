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
 * ʵ�ֹ�������:
 * I.����ActivityĬ���Դ��ı�����.
 * II.��ʾToast�ַ�չʾ���û�.
 * III.��ʾMenuչʾ���û�.
 * @author Administrator
 *
 */
public class HideTitleToastMenuFinishActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 1.���ر�����. �����������Ҫ��setContentView����֮ǰ����.����ᱨ��.
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		// 2.ʹ��Toast������ʾ�û�
		Toast.makeText(HideTitleToastMenuFinishActivity.this,"ʹ��Toastչʾ��Ϣ���û�",Toast.LENGTH_SHORT).show();
		
		// 3.����layout��Դ
		setContentView(R.layout.linearlayout);
		
		// 4.Ϊlinearlayout.xml�ļ��е�bu_1��ť��ӵ���¼��ļ���
		Button button = (Button) findViewById(R.id.bu_1);
		button.setOnClickListener(new MyClickListener());
	}
	
	class MyClickListener implements OnClickListener {
		
		@Override
		public void onClick(View arg0) {
			// �ڽ������������֮ǰ�����û���ʾ.
			Toast.makeText(HideTitleToastMenuFinishActivity.this,"����ʾ����֮������˳�......",Toast.LENGTH_SHORT).show();
			// �����������Activity������.
			finish();
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// ����menu�ļ����¹���main.xml�ļ�����Դ
		getMenuInflater().inflate(R.menu.main,menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()) {
			case R.id.menu_1:
				Toast.makeText(HideTitleToastMenuFinishActivity.this, "лл����ע���ǵ�'�ļ�'����!", Toast.LENGTH_SHORT);
				Log.i("info","�û�������ļ�,˵���û���ʼ�����ǵĲ�Ʒ����һЩ��Ȥ");
				break;
			case R.id.menu_2:
				Toast.makeText(HideTitleToastMenuFinishActivity.this,"лл����ע���ǵ�'����'����!", Toast.LENGTH_SHORT);
				Log.i("info", "�û�����˹���,˵���û���ʼ�����ǵ��Ŷ�����һЩ��Ȥ");
				break;
		}
		
		return true;
	}
	
}