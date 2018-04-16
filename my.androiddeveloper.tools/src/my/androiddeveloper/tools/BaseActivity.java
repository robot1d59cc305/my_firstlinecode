package my.androiddeveloper.tools;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 
 * @author Administrator
 *
 */
public class BaseActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Log.d("BaseActivity",getClass().getSimpleName());
		
		ActivityCollector.addActivity(this);
	}
	
}