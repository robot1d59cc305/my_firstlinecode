package democode.firstlinecode.demo11.content.provider.main;

import com.example.democode.firstlinecode.demo11.content.provider.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import democode.firstlinecode.demo11.content.provider.contacts.ReadSystemContactsActivity;
import democode.firstlinecode.demo11.content.provider.custom.MyContentProviderActivity;

/**
 * 主界面,为所有的按钮去添加响应事件.
 * @author Administrator
 *
 */
public class MainActivity extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    Button activity_main_go_ReadSystemContactsActivity = (Button) findViewById(R.id.activity_main_go_ReadSystemContactsActivity);
	    activity_main_go_ReadSystemContactsActivity.setOnClickListener(this);
	    
	    Button activity_main_go_MyContentProviderActivity  = (Button) findViewById(R.id.activity_main_go_MyContentProviderActivity);
	    activity_main_go_MyContentProviderActivity.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
			case R.id.activity_main_go_ReadSystemContactsActivity:
				 intent = new Intent(MainActivity.this,ReadSystemContactsActivity.class);
				 startActivity(intent);
				 break;
			case R.id.activity_main_go_MyContentProviderActivity:
				 intent = new Intent(MainActivity.this,MyContentProviderActivity.class);
				 startActivity(intent);
			default:
				 break;
		}
	}
	
}