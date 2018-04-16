package democode.firstlinecode.demo14.webview_network;

import com.example.democode.firstlinecode.demo14.webview.R;
import democode.firstlinecode.demo14.webview_network.HttpUrlConnectionActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;

/**
 * MainActivity: 1.这是应用程序的主界面,同时主界面中提供其它7个功能的入口按钮. 2.提供
 * 在应用程序中打开一个Activity打开指定的网页. 3.提供 使用httpurlconnection的方式来访问网络,获取服务器上的文件. 4.提供
 * 使用httpclient的方式来访问网络,获取服务器上的文件. 5.提供 使用PULL的方式解析Apache服务器上的XML文件. 6.提供
 * 使用SAX的方式解析Apache服务器上的XML文件. 7.提供 解析JSON格式数据. 8.提供 解析JSON格式数据--使用GSON.
 * 
 * @author Administrator
 */
public class MainActivity extends Activity implements OnClickListener {

	private Button button1;

	private Button button2;

	private Button button3;

	private Button button4;

	private Button button5;

	private Button button6;

	private Button button7;

	private Button button8;

	@Override
	protected void onCreate(Bundle bundle) {
		// 1.调用父类的onCreate方法.
		super.onCreate(bundle);

		// 2.调用setContentView方法,加载内容视图.
		super.setContentView(R.layout.activity_main);

		// 3.获取2中视图按钮资源,并且为这些视图按钮资源添加响应事件.
		button1 = (Button) super.findViewById(R.id.activity_main_button_1);
		button2 = (Button) super.findViewById(R.id.activity_main_button_2);
		button3 = (Button) super.findViewById(R.id.activity_main_button_3);
		button4 = (Button) super.findViewById(R.id.activity_main_button_4);
		button5 = (Button) super.findViewById(R.id.activity_main_button_5);
		button6 = (Button) super.findViewById(R.id.activity_main_button_6);
		button7 = (Button) super.findViewById(R.id.activity_main_button_7);
		button8 = (Button) super.findViewById(R.id.activity_main_button_8);

		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
		button5.setOnClickListener(this);
		button6.setOnClickListener(this);
		button7.setOnClickListener(this);
		button8.setOnClickListener(this);
	}

	/**
	 * 4.为视图资源按钮添加业务逻辑.
	 */
	@Override
	public void onClick(View v) {

		/*
		 * 为不同业务在进行实例化时在类构造器给入不同的实参.
		 */
		Intent intent;

		/**
		 * 分支语句为用户不同的业务进行不同的实现.
		 */
		switch (v.getId()) {
			/*
			 * 为什么要将按钮的资源id赋值给HttpUrlConnectionActivity.id?
			 * 1.在MainActivity进行点击的时候会将所点击的id值一并传递到这个属性当中,然后在根据这个id值来判断需要使用哪一种请求方法来获取数据.
			 * 2.这样做可以直接在MainActivity类中去点击相应的按钮,然后就可以去调用HttpUrlConnectionActivity中的功能.
			 * 3.当然是在MainActivity类中点击相应的按钮就去将对应的id值赋值到这个属性上,
			 * 然后进入到HttpUrlConnectionActivity当中这里加载的视图里面默认带了一个按钮.
			 * 4.通过点击这个按钮,为这个按钮设置相应onClickListener监听事件,然后在onClick方法当中编写相应的业务代码.
			 * 5.这个业务代码是使用switch分支流程语句来case id
			 * 的值,case的值是加载了activity_main.xml文件中id为activity_main_button2以后的id类型的名称,
			 * 这个id的类型的名称除整个名称字符串最后一个变外其它不变,最后一个变的规律按照自然数的增长进行增加.
			 */
			case R.id.activity_main_button_1:
				intent = new Intent(MainActivity.this, WebViewActivity.class);
				super.startActivity(intent);
				break;
	
			case R.id.activity_main_button_2:
				intent = new Intent(MainActivity.this, HttpUrlConnectionActivity.class);
				HttpUrlConnectionActivity.id = button2.getId();
				super.startActivity(intent);
				break;
	
			case R.id.activity_main_button_3:
				intent = new Intent(MainActivity.this, HttpUrlConnectionActivity.class);
				HttpUrlConnectionActivity.id = button3.getId();
				super.startActivity(intent);
				break;
	
			case R.id.activity_main_button_4:
				intent = new Intent(MainActivity.this, HttpUrlConnectionActivity.class);
				HttpUrlConnectionActivity.id = button4.getId();
				super.startActivity(intent);
				break;
	
			case R.id.activity_main_button_5:
				intent = new Intent(MainActivity.this, HttpUrlConnectionActivity.class);
				HttpUrlConnectionActivity.id = button5.getId();
				super.startActivity(intent);
				break;
	
			case R.id.activity_main_button_6:
				intent = new Intent(MainActivity.this, HttpUrlConnectionActivity.class);
				HttpUrlConnectionActivity.id = button6.getId();
				super.startActivity(intent);
				break;
	
			case R.id.activity_main_button_7:
				intent = new Intent(MainActivity.this, HttpUrlConnectionActivity.class);
				HttpUrlConnectionActivity.id = button7.getId();
				super.startActivity(intent);
				break;
	
			case R.id.activity_main_button_8:
				intent = new Intent(MainActivity.this, XmlServerLocationFileContentParseActivity.class);
				super.startActivity(intent);
				break;
	
			default:
				break;
		}

	}

}