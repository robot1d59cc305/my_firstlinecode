package democode.firstlinecode.demo4.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * 这里是展示从下一个Activity传递数据给上一个Activity的类.
 * 通过back键以及按钮的方式来写.
 * @author Administrator
 *
 */
public class IntentTransmitLastActivity extends Activity {
	
	/**
	 * 通过这个方法来创建布局,和接受上一个Activity传递的参数.来将值放到这个界面上来.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 1.加载布局资源
		setContentView(R.layout.intent6layout);
		
		// 2.获取上一个Activity传递的数据,以及当前布局中的Activity中的EditText对象实例.
		Intent intent = getIntent();
		EditText IntentTransmitLastActivityEditText = (EditText) findViewById(R.id.IntentTransmitLastActivityEditText);
		
		// 3.将上一个Activity传递的数据放入到2中获取的EditText对象实例中来.  
		IntentTransmitLastActivityEditText.setText(intent.getStringExtra("IndexActivity"));
		
	}
	
	/**
	 * 1.通过点击这个按钮,将当前的Activity中的EditText对象实例中的数据传递给上一个Activity当中,并且销毁掉当前的Activity.
	 * @param v
	 */
	public void IntentTransmitLastActivityButton(View v) {
		
		// 1.获取到当前界面中的EditText文本框的对象.
		EditText IntentTransmitLastActivityEditText = (EditText) findViewById(R.id.IntentTransmitLastActivityEditText);
		
		// 2.构建好一个Intent对象.并将1中的数据添加到这里来.
		Intent intent = new Intent();
		intent.putExtra("IntentTransmitLastActivityEditText",IntentTransmitLastActivityEditText.getText().toString());
		
		// 3.将1中的EditText文本框中的对象的数据放到setResult方法里面.
		setResult(RESULT_OK, intent);
		
		// 4.关闭当前的Activity界面.
		finish();
		
	}
	
	/**
	 * 2.通过用户去点击Back退出按键,来退出这个应用程序的时候做出操作.
	 *   不过这个方法,在这里并没有达到相应的效果,这令我很失望.
	 */
	@Override
	public void onBackPressed() {
		
		// 1.获取到当前界面中的EditText文本框的对象.
		EditText IntentTransmitLastActivityEditText = (EditText) findViewById(R.id.IntentTransmitLastActivityEditText);
		
		// 2.构建好一个Intent对象.并将1中的数据添加到这里来.
		Intent intent = new Intent();
		intent.putExtra("IntentTransmitLastActivityEditText",IntentTransmitLastActivityEditText.getText().toString());
		
		// 3.将1中的EditText文本框中的对象的数据放到setResult方法里面.
		setResult(RESULT_OK, intent);
		
		// 4.关闭当前的Activity界面.
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