package democode.firstlinecode.demo8.xinwenyingyong.activity;

import com.example.democode.firstlinecode.demo8.xinwenyingyong.R;

import android.app.Activity;
import android.os.Bundle;

/**
 * 不管是在任何的尺寸设备,第一个运行的Activity都会是这个Activity.
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main_2);
	}
	
}