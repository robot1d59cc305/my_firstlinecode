package democode.firstlinecode.demo4.intent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * �����Android����ͨ����ʾIntent��ʵ�� 
 * @author Administrator
 *
 */
public class ShowActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intent2layout);
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
	
}