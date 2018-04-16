package democode.firstlinecode.demo4.intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * �����Android����ʱ���,app��������.
 * @author Administrator
 *
 */
public class IndexActivity extends Activity {
	
	private static Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intent1layout);
		Log.d("onCreate",this.toString());
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.d("onStart",this.toString());
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.d("onResume",this.toString());
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.d("onResume",this.toString());
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.d("onStop",this.toString());
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("onDestroy",this.toString());
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("onRestart",this.toString());
	}
	
	/**
	 * 1.ͨ����ʽ�ķ�ʽ����һ��Activity����һ��Activity����.
	 * @param v
	 */
	public void showActivityButton(View v) {
		intent = new Intent(IndexActivity.this,ShowActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 2.ͨ��android.intent.action.DEFAULT�����������ƶ�����Ӧ�����activity
	 * @param v
	 */
	public void HideActivityButton(View v) {
		intent = new Intent("android.intent.action.DEFAULT");
		startActivity(intent);
	}
	
	/**
	 * 3.ͨ����action�ڵ��޸�Ϊ�Զ���Ĵ�����������һ��Activity
	 * @param v
	 */
	public void HideCustomizationActivtiycu(View v) {
		intent = new Intent("HideCustomizationActivtiycu");
		startActivity(intent);
	}
	
	/**
	 * 4.ͨ��Intent����һЩϵͳ�Դ��Ĺ���.
	 * �������ܹ���httpЭ���,���������õ�Activity������û��ȥʵ��.
	 * ��ֻ֮Ҫ���ǵ�Activity������httpЭ���������,�Ƕ����Э�������,��ô�Ϳ��Դ����������. 
	 * ����ʹ��һ�������Ĵ���������Intent�Ĺ���������.
	 * @param v
	 */
	public void WebBrowserButton(View v) {
		/* �����action,������ϵͳ���õ������,��ȻҲ���ܻ���ֶ��ѡ������. ��ʹ�����д����ڽ��е��õ�ʱ��,��Anroid4.3���ҵİ汾���ṩ�����������ѡ�� 
		 * ��һ����ActivityTest -->���ActivityTest�����֮����ֵĽ����Ҷ���֪������һ��.��������������������Լ�ʵ�ֵ������.
		 * �ڶ�����ϵͳ���������	 -->�������Androidϵͳ�г��ֵ������.
		 * ������.. ����������ܹ��������ҳ�ķ�ʽ�Ļ�,��Ὣ���ѡ���ṩ����.
		 * ��Щʱ�������Լ�������һ��action�ڵ�����Ϊandroid.intent.action.VIEW��Activity,�������˵���Activity�ڲ��Լ�û��ʵ���ܹ�����ҳ�Ĺ��ܾͲ�Ҫȥ����.
		 * ��Ϊ��������Ϊд�����action�ʹ���һ������ҳ,������ҳ�Ĺ���.
		 * �������Լ�ʵ����һ��activity,���activity��actionд����android.intent.action.VIEW���д���,Ч��Ҳ�Ǻ������һ��ûʲô��.
		 * */
		intent = new Intent("android.intent.action.VIEW");
		intent.setData(Uri.parse("http://www.baidu.com"));
		startActivity(intent);
	}
	
	/**
	 * 5.ͨ��Intent����һЩϵͳ�Դ��Ĺ���.
	 * ֱ��ʹ��Intent�൱�еĳ�����������Intent����������.
	 * @param v
	 */
	public void WebBrowserActivityButton(View v) {
		/*
		 * �������ֻд `intent = new Intent(Intent.ACTION_VIEW);` ���д���,����ܺܶ��Ӧ�ó���ᱻ����ѡ���,��ΪAndroid���кܶ��Ӧ�ó����е�һЩactivity������xx.action_view���������ֵ.
		 * ,�����������`http://www.baidu.com` ȥ��������ַ���,��ϵͳ��֪���û�����Ҫ�������.��ô�ͻ�ȥ����Щ֧�ִ��������activity,����<data>�ı�ǩ�������ñ�������`http`�ĸ�ʽ��ͷ.
		 * ����������Ѿ��ƶ���setData�������,����������һ��http�Ĵ���,���������ActivityҲ�ܹ���Ϊ�б�֮һ,��Ҫ������intent-filter�ڵ�֮�¼���<data>��ǩ.������ָ��Э��Ϊhttp.
		 * */
		intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://www.baidu.com"));
		startActivity(intent);
	}
	
	/**
	 * 6.ͨ��Intent����һЩϵͳ�Դ��Ĺ���.
	 * Intent�е�ACTION_CALL,��Ҫ��ϵͳ����Ȩ��. ʵ�ִ�绰����,���ｫ�绰����̶���д����,д��ͺ�.
	 * @param v
	 */
	public void phone(View v) {
		Intent intent = new Intent(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:10086"));
		startActivity(intent);
	}
	
	/**
	 * 7.��������ť,��Intent���Ѽ�ҳ���е�idΪIntentTransmitLastActivityEditText��Ԫ�ص�����.
	 */
	public void IndexActivityOnClick(View v) {
		
		// 1.��ȡ��EditText�ı��������.
		EditText IndexActivityEditText = (EditText) findViewById(R.id.IndexActivityEditText);
		
		// 2.������Intent�����.
		Intent intent = new Intent(IndexActivity.this,IntentTransmitLastActivity.class);
		
		// 3.ʹ��putExtra����������װ��Intent�൱��.
		intent.putExtra("IndexActivity",IndexActivityEditText.getText().toString());
		
		// 4.����startActivityForResult��Intent�����Լ���������״̬��Ž�ȥ.
		startActivityForResult(intent,1);
		
	}
	
	/**
	 * 8.������һ��Activity�ύ�����ǵ�����.
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		switch(requestCode) {
			case 1 :
				EditText IndexActivityEditTextFanHuiZHi;
				if(resultCode == RESULT_OK) {
					IndexActivityEditTextFanHuiZHi = (EditText) findViewById(R.id.IndexActivityEditText);
					IndexActivityEditTextFanHuiZHi.setText(data.getStringExtra("IntentTransmitLastActivityEditText").toString());
				} 
				
				break;
		}
		
	}
	
	/**
	 * 9.DialogActivity,����һ���Ի���ʽ��Activity,�۲�������������͵�Activityʱ,������Activity���������ڴ���һ��ʲô����״̬.
	 * @param v
	 */
	public void DialogActivity(View v) {
		// 1.������һ��Intent����.
		Intent intent = new Intent(IndexActivity.this,DialogActivity.class);
		// 2.�������Activity
		startActivity(intent);
	}
	
	/**
	 * 10.̽��Android�е�Activity�ڱ����û����ʱ��ϵͳ������ʱ���������������" ������Ҫ�Ǵ������,���һЩ����.
	 * @param v
	 */
	public void DestroyActivity1(View v) {
		Intent intent = new Intent(IndexActivity.this,DestroyActivity1.class);
		startActivity(intent);
	}
	
}