package democode.firstlinecode.demo4.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * "̽��Android�е�Activity�ڱ����û����ʱ��ϵͳ������ʱ���������������" ������Ҫ�Ǵ������,���һЩ����.
 * @author Administrator
 *
 */
public class DestroyActivity1 extends Activity {
	
	private EditText destroyActivity1EditText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intent7layout);
		Log.d("onCreate",this.toString());
		
		destroyActivity1EditText = (EditText) findViewById(R.id.DestroyActivity1EditText);
		
		// ��ʱ���ݻָ�����,�����ǰ��Activity���ݱ�����,�����������������ݱ�������.
		if (savedInstanceState != null) {
			destroyActivity1EditText.setText(savedInstanceState.getString("destroyActivity1EditText"));
		}
	}
			
	/**
	 * ��������ǵ���ǰ��Activity������ɵ���,����˵��ϵͳ�ɵ��˵�ʱ��,�������������������,Ȼ��ϵͳ��֪���ո�����Ϊ�Լ���ԭ�����ɵ���,��������Ҫ�ɵ����ҳ��.
	 * ����ϵͳ�ͻ�ȥ�����������,��Ȼ����������ڼ���ִ��OnDestroy()����֮ǰ���õ�,�ָ�֮��ϵͳ�����onCreate����,��ֻҪ��onCreate����ִ����Ӧ��ҵ���߼��Ϳ�����.
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putString("destroyActivity1EditText", destroyActivity1EditText.getText().toString());
		Toast.makeText(DestroyActivity1.this, "onSaveInstanceState������", Toast.LENGTH_LONG).show();
	}
	
	/**
	 * 1.��������ť,�����ť�ͻ���ת����һ��ActivityҲ����DestroyActivity2��������.
	 */
	public void DestroyActivity1(View v) {
		Intent intent = new Intent(DestroyActivity1.this,DestroyActivity2.class);
		startActivity(intent);
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