package democode.firstlinecode.demo9.receiver.tool;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 
 * 封装Activity,以达到我们需要的需求.
 * @author Administrator
 *
 */
public class BaseActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Log.d("BaseActivity",getClass().getSimpleName());
		
	}
	
}