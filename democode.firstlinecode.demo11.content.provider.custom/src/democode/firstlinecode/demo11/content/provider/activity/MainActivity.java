package democode.firstlinecode.demo11.content.provider.activity;

import com.example.democode.firstlinecode.demo11.content.provider.custom.R;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import democode.firstlinecode.demo11.content.provider.datastorage.MyDatabaseHelper;

/**
 * 
 * MainActivity
 * @author Administrator
 *
 */
public class MainActivity extends Activity implements OnClickListener {

	/**
	 * MyDatabaseHelper数据库类.
	 */
	private MyDatabaseHelper myDatabaseHelper;
	
	/**
	 * 操作数据库中数据的类.
	 */
	private SQLiteDatabase   sqLiteDatabase;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 设置当前Activity的顶级视图.
		setContentView(R.layout.activity_main);
		
		((Button) findViewById(R.id.create_database)).setOnClickListener(this);
		
		((Button) findViewById(R.id.add_data)).setOnClickListener(this);
	}
	
	/**
	 * 为这个Activity设置的顶级视图里面的资源编写具体的响应业务逻辑.
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.add_data:
				
				 // 这个类用于存放一些数据,在待会插入数据的时候将这个对象作为参数传递到insert方法中.
				 ContentValues contentValues = new ContentValues();
				 
				 // 添加数据到contentValues对象.
				 contentValues.put("author","manager");
				 
				 contentValues.put("price",98.9);
				 
				 contentValues.put("pages",15);
				 
				 contentValues.put("name","Tom");
				 
				 // 准备参数执行insert方法,插入数据到数据库中.
				 sqLiteDatabase.insert("Book",null,contentValues);
				 
				 break;
				 
			case R.id.create_database:
				
				 // 创建数据库.
				 myDatabaseHelper = new MyDatabaseHelper(this,"BookStore.db",null,2);
				 
				 // 将数据库文件导出. -- 这个时候才算是真正的将数据库创建成功.否则仅仅只是调用了上面的代码没有任何的作用.
				 sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
				 
				 break;
		}
	}
	
}