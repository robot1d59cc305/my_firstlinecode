package democode.firstlinecode.demo4.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * ������չʾ����һ��Activity�������ݸ���һ��Activity����.
 * ͨ��back���Լ���ť�ķ�ʽ��д.
 * @author Administrator
 *
 */
public class IntentTransmitLastActivity extends Activity {
	
	/**
	 * ͨ�������������������,�ͽ�����һ��Activity���ݵĲ���.����ֵ�ŵ������������.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 1.���ز�����Դ
		setContentView(R.layout.intent6layout);
		
		// 2.��ȡ��һ��Activity���ݵ�����,�Լ���ǰ�����е�Activity�е�EditText����ʵ��.
		Intent intent = getIntent();
		EditText IntentTransmitLastActivityEditText = (EditText) findViewById(R.id.IntentTransmitLastActivityEditText);
		
		// 3.����һ��Activity���ݵ����ݷ��뵽2�л�ȡ��EditText����ʵ������.  
		IntentTransmitLastActivityEditText.setText(intent.getStringExtra("IndexActivity"));
		
	}
	
	/**
	 * 1.ͨ����������ť,����ǰ��Activity�е�EditText����ʵ���е����ݴ��ݸ���һ��Activity����,�������ٵ���ǰ��Activity.
	 * @param v
	 */
	public void IntentTransmitLastActivityButton(View v) {
		
		// 1.��ȡ����ǰ�����е�EditText�ı���Ķ���.
		EditText IntentTransmitLastActivityEditText = (EditText) findViewById(R.id.IntentTransmitLastActivityEditText);
		
		// 2.������һ��Intent����.����1�е�������ӵ�������.
		Intent intent = new Intent();
		intent.putExtra("IntentTransmitLastActivityEditText",IntentTransmitLastActivityEditText.getText().toString());
		
		// 3.��1�е�EditText�ı����еĶ�������ݷŵ�setResult��������.
		setResult(RESULT_OK, intent);
		
		// 4.�رյ�ǰ��Activity����.
		finish();
		
	}
	
	/**
	 * 2.ͨ���û�ȥ���Back�˳�����,���˳����Ӧ�ó����ʱ����������.
	 *   �����������,�����ﲢû�дﵽ��Ӧ��Ч��,�����Һ�ʧ��.
	 */
	@Override
	public void onBackPressed() {
		
		// 1.��ȡ����ǰ�����е�EditText�ı���Ķ���.
		EditText IntentTransmitLastActivityEditText = (EditText) findViewById(R.id.IntentTransmitLastActivityEditText);
		
		// 2.������һ��Intent����.����1�е�������ӵ�������.
		Intent intent = new Intent();
		intent.putExtra("IntentTransmitLastActivityEditText",IntentTransmitLastActivityEditText.getText().toString());
		
		// 3.��1�е�EditText�ı����еĶ�������ݷŵ�setResult��������.
		setResult(RESULT_OK, intent);
		
		// 4.�رյ�ǰ��Activity����.
		finish();
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
	
}