package democode.firstlinecode.demo4.intent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * 这个在Android当中通过隐式Intent当中的来启动.但是intent-filter节点中的数据都是默认的.
 * @author Administrator
 *
 */
public class HideActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intent3layout);
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