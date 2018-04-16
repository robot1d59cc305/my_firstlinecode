package democode.firstlinecode.demo17.develop.skill.intent;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * 
 * @author Administrator
 *
 */
public class SecondActivity extends Activity {
	
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		
		Person person = (Person) super.getIntent().getSerializableExtra("person_data");
		
	}
	
}