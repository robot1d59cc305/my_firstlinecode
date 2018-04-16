package democode.firstlinecode.demo10.datastorage.activity;

import com.example.democode.firstlinecode.demo10.datastorage.R;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import democode.firstlinecode.demo10.datastorage.helper.MyDatabaseHelper2;

/**
 * 
 * @author Administrator
 *
 */
public class DatabaseUpdateActivity extends Activity {
	
	/**
	 * 数据库产品类
	 */
	private MyDatabaseHelper2 myDatabaseHelper2;
	
	/**
	 * SQLiteDatabase操作数据库的类
	 */
	private SQLiteDatabase    sqLiteDatabase;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.database2);
		
		myDatabaseHelper2 = new MyDatabaseHelper2(this,"BookStore2.db",null,2);
		
		sqLiteDatabase = myDatabaseHelper2.getWritableDatabase();
	}
	
}