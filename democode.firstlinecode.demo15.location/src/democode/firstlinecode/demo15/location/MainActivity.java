package democode.firstlinecode.demo15.location;

import com.example.democode.firstlinecode.demo15.location.R;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;

/**
 * MainActivity 这个类是这个Android应用程序端的入口,主要的Activity.
 * 
 * @author Administrator
 *
 */
public class MainActivity extends BaseActivity implements OnClickListener {

	/*
	 * activity_main.xml视图中所有的按钮资源
	 */
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	private Button button10;
	
	/*
	 * Intent
	 */
	private Intent intent;
	
	protected void onCreate(Bundle savedInstanceState) {

		// 1.加载父类的onCreate方法.
		super.onCreate(savedInstanceState);

		// 2.设置内容视图.
		super.setContentView(R.layout.activity_main);

		// 3.获取视图资源.
		button1 = (Button) super.findViewById(R.id.activity_main_button1);
		button2 = (Button) super.findViewById(R.id.activity_main_button2);
		button3 = (Button) super.findViewById(R.id.activity_main_button3);
		button4 = (Button) super.findViewById(R.id.activity_main_button4);
		button5 = (Button) super.findViewById(R.id.activity_main_button5);
		button6 = (Button) super.findViewById(R.id.activity_main_button6);
		button7 = (Button) super.findViewById(R.id.activity_main_button7);
		button8 = (Button) super.findViewById(R.id.activity_main_button8);
		button9 = (Button) super.findViewById(R.id.activity_main_button9);
		button10 = (Button) super.findViewById(R.id.activity_main_button10);

		// 4.给视图资源添加监听事件.
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
		button5.setOnClickListener(this);
		button6.setOnClickListener(this);
		button7.setOnClickListener(this);
		button8.setOnClickListener(this);
		button9.setOnClickListener(this);
		button10.setOnClickListener(this);

	}

	/**
	 * 为所有在activity_main.xml视图上的按钮资源添加监听事件.
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.activity_main_button1:
				 intent = new Intent(MainActivity.this,MyLocationLatitudeActivity.class);
				 startActivity(intent);
				 break;
			case R.id.activity_main_button2:
				 intent = new Intent(MainActivity.this,MyLocationLatitudeActivity2.class);
				 startActivity(intent);
				break;
			case R.id.activity_main_button3:
				 intent = new Intent(MainActivity.this,BaiDuMapActivity.class);
				 startActivity(intent);
				break;
			case R.id.activity_main_button4:
				
				break;
			case R.id.activity_main_button5:
				
				break;
			case R.id.activity_main_button6:
				
				break;
			case R.id.activity_main_button7:
				
				break;
			case R.id.activity_main_button8:
				
				break;
			case R.id.activity_main_button9:
				
				break;
			case R.id.activity_main_button10:
				
				break;
			default:
				break;
		}
	}

}