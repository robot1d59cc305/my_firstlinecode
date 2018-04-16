package democode.firstlinecode.demo4.intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * 这个在Android当中时主活动,app的主窗口.
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
	 * 1.通过显式的方式从上一个Activity到下一个Activity里面.
	 * @param v
	 */
	public void showActivityButton(View v) {
		intent = new Intent(IndexActivity.this,ShowActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 2.通过android.intent.action.DEFAULT这条代码来移动到对应代码的activity
	 * @param v
	 */
	public void HideActivityButton(View v) {
		intent = new Intent("android.intent.action.DEFAULT");
		startActivity(intent);
	}
	
	/**
	 * 3.通过将action节点修改为自定义的代码来启动下一个Activity
	 * @param v
	 */
	public void HideCustomizationActivtiycu(View v) {
		intent = new Intent("HideCustomizationActivtiycu");
		startActivity(intent);
	}
	
	/**
	 * 4.通过Intent来打开一些系统自带的功能.
	 * 这两个能够打开http协议的,不管是内置的Activity当中有没有去实现.
	 * 总之只要我们的Activity加上了http协议这个东西,是对这个协议的限制,那么就可以打开这个超链接. 
	 * 这里使用一串这样的代码来放在Intent的构造器当中.
	 * @param v
	 */
	public void WebBrowserButton(View v) {
		/* 打开这个action,则会调用系统内置的浏览器,当然也可能会出现多个选项的情况. 当使用这行代码在进行调用的时候,在Anroid4.3左右的版本会提供最基本的两个选项 
		 * 第一个是ActivityTest -->这个ActivityTest点击打开之后出现的界面我都不知道是哪一个.所以这个东西就是我们自己实现的浏览器.
		 * 第二个是系统内置浏览器	 -->这个就是Android系统中出现的浏览器.
		 * 第三个.. 如果有其它能够打开这个网页的方式的话,则会将这个选项提供给你.
		 * 有些时候我们自己会声明一个action节点配置为android.intent.action.VIEW的Activity,但是如果说这个Activity内部自己没有实现能够打开网页的功能就不要去尝试.
		 * 因为本身不会因为写了这个action就带有一个打开网页,加载网页的功能.
		 * 就算你自己实现了一个activity,这个activity的action写的是android.intent.action.VIEW这行代码,效果也是和上面的一样没什么用.
		 * */
		intent = new Intent("android.intent.action.VIEW");
		intent.setData(Uri.parse("http://www.baidu.com"));
		startActivity(intent);
	}
	
	/**
	 * 5.通过Intent来打开一些系统自带的功能.
	 * 直接使用Intent类当中的常量来放置在Intent构造器当中.
	 * @param v
	 */
	public void WebBrowserActivityButton(View v) {
		/*
		 * 如果这里只写 `intent = new Intent(Intent.ACTION_VIEW);` 这行代码,则可能很多的应用程序会被放在选项当中,因为Android当中很多的应用程序中的一些activity都带有xx.action_view这个常量的值.
		 * ,但如果加上了`http://www.baidu.com` 去解析这个字符串,则系统就知道用户是想要打开浏览器.那么就会去将那些支持打开浏览器的activity,并且<data>的标签里面设置必须是以`http`的格式开头.
		 * 如果你想在已经制定了setData的情况下,并且内容是一串http的代码,让你的内置Activity也能够成为列表之一,则要在它的intent-filter节点之下加入<data>标签.并且是指定协议为http.
		 * */
		intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://www.baidu.com"));
		startActivity(intent);
	}
	
	/**
	 * 6.通过Intent来打开一些系统自带的功能.
	 * Intent中的ACTION_CALL,需要向系统申明权限. 实现打电话功能,这里将电话号码固定的写死了,写活就好.
	 * @param v
	 */
	public void phone(View v) {
		Intent intent = new Intent(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:10086"));
		startActivity(intent);
	}
	
	/**
	 * 7.点击这个按钮,则Intent将搜集页面中的id为IntentTransmitLastActivityEditText的元素的数据.
	 */
	public void IndexActivityOnClick(View v) {
		
		// 1.获取到EditText文本框的数据.
		EditText IndexActivityEditText = (EditText) findViewById(R.id.IndexActivityEditText);
		
		// 2.构建好Intent类对象.
		Intent intent = new Intent(IndexActivity.this,IntentTransmitLastActivity.class);
		
		// 3.使用putExtra方法将数据装到Intent类当中.
		intent.putExtra("IndexActivity",IndexActivityEditText.getText().toString());
		
		// 4.调用startActivityForResult将Intent对象以及这个对象的状态码放进去.
		startActivityForResult(intent,1);
		
	}
	
	/**
	 * 8.接受下一个Activity提交给我们的数据.
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
	 * 9.DialogActivity,启动一个对话框式的Activity,观察在启动这个类型的Activity时,其它的Activity的生命周期处于一个什么样的状态.
	 * @param v
	 */
	public void DialogActivity(View v) {
		// 1.构建好一个Intent对象.
		Intent intent = new Intent(IndexActivity.this,DialogActivity.class);
		// 2.启动这个Activity
		startActivity(intent);
	}
	
	/**
	 * 10.探索Android中的Activity在被非用户许可时被系统销毁了时保存非永久性数据" 这里主要是存放数据,存放一些数据.
	 * @param v
	 */
	public void DestroyActivity1(View v) {
		Intent intent = new Intent(IndexActivity.this,DestroyActivity1.class);
		startActivity(intent);
	}
	
}