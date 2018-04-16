package democode.firstlinecode.demo4.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * "探索Android中的Activity在被非用户许可时被系统销毁了时保存非永久性数据" 这里主要是存放数据,存放一些数据.
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
		
		// 临时数据恢复机制,如果当前的Activity数据被销毁,则调用这个方法将数据保存起来.
		if (savedInstanceState != null) {
			destroyActivity1EditText.setText(savedInstanceState.getString("destroyActivity1EditText"));
		}
	}
			
	/**
	 * 这个方法是当当前的Activity被意外干掉了,就是说被系统干掉了的时候,调用这个方法保存数据,然后系统会知道刚刚是因为自己的原因把你干掉了,而不是你要干掉这个页面.
	 * 于是系统就会去调用这个方法,当然这个方法是在即将执行OnDestroy()方法之前调用的,恢复之后系统会调用onCreate方法,你只要在onCreate方法执行相应的业务逻辑就可以了.
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putString("destroyActivity1EditText", destroyActivity1EditText.getText().toString());
		Toast.makeText(DestroyActivity1.this, "onSaveInstanceState被调用", Toast.LENGTH_LONG).show();
	}
	
	/**
	 * 1.点击这个按钮,点击按钮就会跳转到下一个Activity也就是DestroyActivity2界面里面.
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