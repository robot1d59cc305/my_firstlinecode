package democode.firstlinecode.demo10.datastorage.activity;

import com.example.democode.firstlinecode.demo10.datastorage.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;

/**
 * 使用SharedPreferences的方式来存储数据
 * @author Administrator
 *
 */
public class SharedPreferencesActivity extends Activity {
	
	/**
	 * 
	 */
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences);
	};
	
	/**
	 * 使用SharedPreferences的方式写出数据
	 */
	public void writeData(View v) {
		// 这里获取ContextWrapper提供的getSharedPrefernces方法获取到SharedPreferences的实例,然后再通过这个实例中的edit方法获取到其内部类Editor.
		// 通过ContextWrapper提供的getSharedPreference方法,会将数据保存到/data/data/<package-name>/shared_prefs/目录下,文件名会以给入的第一个参数值为文件名称.
		SharedPreferences.Editor sharedPreferencesEditor = getSharedPreferences("data",MODE_PRIVATE).edit();
		
		// 存储字符串类型数据.
		sharedPreferencesEditor.putString("Username",((EditText)findViewById(R.id.sharedpreferences_username)).getText().toString());
		
		// 存储数值类型数据.
		sharedPreferencesEditor.putInt("Monery",Integer.parseInt(((EditText)findViewById(R.id.sharedpreferences_monery)).getText().toString()));
		
		// 存储浮点类型数据.
		sharedPreferencesEditor.putFloat("Screen",Float.parseFloat(((EditText)findViewById(R.id.sharedpreferences_screen)).getText().toString()));
		
		// 存储id long类型数据.
		sharedPreferencesEditor.putLong("id",Long.parseLong(((EditText)findViewById(R.id.sharedpreferences_id)).getText().toString()));
		
		// 将数据提交.
		sharedPreferencesEditor.commit();
	}
	
	/**
	 * 读取数据
	 */
	public void readData(View v) {
		
		SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
		
		// 注意大小写不能够改变
		String username = sharedPreferences.getString("Username", null);
		
		int    monery   = sharedPreferences.getInt("Monery",0);
		
		float  screen   = sharedPreferences.getFloat("Screen",0.0f);
		
		long   id       = sharedPreferences.getLong("id",0L);
		
		
		((EditText)findViewById(R.id.sharedpreferences_username)).setText("" + username);
		
		((EditText)findViewById(R.id.sharedpreferences_monery)).setText("" + monery);
		
		((EditText)findViewById(R.id.sharedpreferences_screen)).setText("" + screen);
		
		((EditText)findViewById(R.id.sharedpreferences_id)).setText("" + id);
		
	}
	
}