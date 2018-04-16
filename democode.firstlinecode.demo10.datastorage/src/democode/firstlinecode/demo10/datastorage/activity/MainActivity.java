package democode.firstlinecode.demo10.datastorage.activity;

import com.example.democode.firstlinecode.demo10.datastorage.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import democode.firstlinecode.demo10.datastorage.helper.MyDatabaseHelper;

/**
 * 
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	/**
	 * 进入SaveFileActivity.java
	 * @param v
	 */
	public void savefile(View v) {
		Intent intent = new Intent(MainActivity.this,SaveFileActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 使用SharedPreferences写出数据
	 */
	public void writeSharedPreferences(View v) {
		Intent intent = new Intent(MainActivity.this,SharedPreferencesActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 使用SQlLite数据库
	 */
	public void createDatabase(View v) {
		Intent intent = new Intent(MainActivity.this,DatabaseHelperActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 使用SQl操作SQLite数据库
	 * @param v
	 */
	public void sqlManipulateSQlite(View v) {
		Intent intent = new Intent(MainActivity.this,SqlManipulateSQLiteActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 数据库产品上线阶段如何进行升级的解决方法
	 * @param v
	 */
	public void shujukuUpdate(View v) {
		Intent intent = new Intent(MainActivity.this,DatabaseUpdateActivity.class);
		startActivity(intent);
	}
	
}