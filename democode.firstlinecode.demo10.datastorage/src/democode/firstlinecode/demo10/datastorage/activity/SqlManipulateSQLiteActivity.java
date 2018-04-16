package democode.firstlinecode.demo10.datastorage.activity;

import com.example.democode.firstlinecode.demo10.datastorage.R;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import democode.firstlinecode.demo10.datastorage.helper.MyDatabaseHelper;

/**
 * 使用SQL来操作SQLite数据库
 * 将DatabaseHelperActivity这个类实现过一遍的内容使用SQL来实现一遍.
 * @author Administrator
 *
 */
public class SqlManipulateSQLiteActivity extends Activity {
	
	/**
	 * SQLite数据库类
	 */
	private MyDatabaseHelper myDatabaseHelper;
	
	/**
	 * SQLite数据库操作,使用这个实例在进行具体的数据库操作
	 */
	private SQLiteDatabase   sQLiteDatabase;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.database);
		
		myDatabaseHelper = new MyDatabaseHelper(this,"BookStore.db",null,2);
		
		Button button = (Button) findViewById(R.id.carete_database);
		
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// 给sQLiteDatabase创建实例
				sQLiteDatabase = myDatabaseHelper.getWritableDatabase();
				
			}
		});
		
	}
	
	/**
	 * 向数据库中添加数据
	 */
	public void addData(View v) {
		
		sQLiteDatabase = myDatabaseHelper.getWritableDatabase();
		
		sQLiteDatabase.execSQL("insert into Book (name, author, pages, price) values(?, ?, ?, ?)",
				new String[] { "The Da Vinci Code", "Dan Brown", "454", "16.96" });
		
		sQLiteDatabase.execSQL("insert into Book (name, author, pages, price) values(?, ?, ?, ?)",
				new String[] { "The Lost Symbol", "Dan Brown", "510", "19.95" });
		
		Log.v("SqlManipulateSQLiteActivity","addData");
		
	}
	
	/**
	 * 向数据库中更新数据
	 */
	public void updateData(View v) {
		sQLiteDatabase.execSQL("update Book set price = ? where name = ?", new String[] { "10.99",
		"The Da Vinci Code" });
		
		Log.v("SqlManipulateSQLiteActivity","updateData");
	}
	
	/**
	 * 向数据库中删除数据
	 * @param v
	 */
	public void deleteData(View v) {
		sQLiteDatabase.execSQL("delete from Book where pages > ?", new String[] { "500" });
		
		Log.v("SqlManipulateSQLiteActivity","deleteData");
	}
	
	/**
	 * 向数据库中查询数据
	 * @param v
	 */
	public void queryData(View v) {
		sQLiteDatabase.rawQuery("select * from Book", null);
		
		Log.v("SqlManipulateSQLiteActivity","queryData");
	}
	
	/**
	 * 向数据库中查询数据
	 * @param v
	 */
	public void shiwuData(View v) {
		// 如果会使用SQL进行事物操作可以在这里编写代码.
	}
	
}