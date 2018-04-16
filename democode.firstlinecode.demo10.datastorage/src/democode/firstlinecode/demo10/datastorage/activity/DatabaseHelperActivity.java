package democode.firstlinecode.demo10.datastorage.activity;

import com.example.democode.firstlinecode.demo10.datastorage.R;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import democode.firstlinecode.demo10.datastorage.helper.MyDatabaseHelper;

/**
 * 使用Android自带数据库SQLite
 * @author Administrator
 *
 */
public class DatabaseHelperActivity extends Activity {
	
	private MyDatabaseHelper myDatabaseHelper;
	
	private SQLiteDatabase   sqliteDatabase;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.database);
		
		// 获取数据库的实例. 升级数据库要将第四个参数说明好.
		myDatabaseHelper = new MyDatabaseHelper(this,"BookStore.db",null,2);
		
		Button button = (Button) findViewById(R.id.carete_database);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// 写出数据库.myDatabaseHelper.getWritableDatabase()语句会返回一个sqliteDatabase对象.
				myDatabaseHelper.getWritableDatabase();
				
			}
			
		});
		
	}
	
	/**
	 * 向数据库中添加数据
	 */
	public void addData(View v) {
		
		sqliteDatabase = myDatabaseHelper.getWritableDatabase();
		
		// 插入第一条数据
		ContentValues  contentValues  = new ContentValues();
		contentValues.put("id", 505);
		contentValues.put("author","manager");
		contentValues.put("price",8.9);
		contentValues.put("pages",23);
		sqliteDatabase.insert("Book",null,contentValues);
		
		// 将之前插入的数据清除
		contentValues.clear();
		
		// 插入第二条数据
		contentValues.put("id", 154);
		contentValues.put("author","manager");
		contentValues.put("price",88.8);
		contentValues.put("pages",7);
		sqliteDatabase.insert("Book",null,contentValues);
		
		// 将之前插入的数据清除
		contentValues.clear();
		
		// 插入第三条数据
		contentValues.put("id", 12);
		contentValues.put("author","employee");
		contentValues.put("price",99.9);
		contentValues.put("pages",5);
		sqliteDatabase.insert("Book",null,contentValues);
		
		// 将之前插入的数据清除
		contentValues.clear();
		
		// 插入第四条数据
		contentValues.put("id", 58);
		contentValues.put("author","employee");
		contentValues.put("price",60);
		contentValues.put("pages",1);
		sqliteDatabase.insert("Book",null,contentValues);
		
		// 将之前插入的数据清除
		contentValues.clear();
		
		// 插入第五条数据
		contentValues.put("id", 305);
		contentValues.put("author","manager");
		contentValues.put("price",75.9);
		contentValues.put("pages",3);
		sqliteDatabase.insert("Book",null,contentValues);
	}
	
	/**
	 * 向数据库中更新数据
	 */
	public void updateData(View v) {
		sqliteDatabase = myDatabaseHelper.getWritableDatabase();
		
		// 准备要修改的数据
		ContentValues contentValues = new ContentValues();
		contentValues.put("pages",2689);
		
		// 这个方法的意思是将Book表中的id=888的字段的pages字段数据改为2689.
		sqliteDatabase.update("Book", contentValues,"id=?",new String[]{"888"});
	}
	
	/**
	 * 向数据库中删除数据
	 * @param v
	 */
	public void deleteData(View v) {
		sqliteDatabase = myDatabaseHelper.getWritableDatabase();
		
		// 删除数据 在Book表中,将id大于887的数据删除.如果不指定第二,第三个参数,则默认是删除所有的数据.
		sqliteDatabase.delete("Book","id > ?",new String[]{"100"});
	}
	
	/**
	 * 想数据库中查询数据并将查询得到的数据展示在ListView控件当中.
	 * @param v
	 */
	public void queryData(View v) {
		sqliteDatabase = myDatabaseHelper.getWritableDatabase();
		
		// 获取查询到的结果数据.
		Cursor cursor =  sqliteDatabase.query("Book",null,null,null,null,null,null);
		
		// 将数据整理好之后放在这里,这里的数组的元素数量必须要比cursor里面的多一个.为什么?因为从一个实验中使用query()方法到数据库中获取数据一共拿了5条,将数据存放在cursor里面的元素的索引是从0-4,实际数量是5个.这没错.
		// 但是使用getColumnCount()方法获取到的数量是4也就是说只能够获取到下标最大值.
		// 如果说将下标的数量做为str数组的元素下标最大值,那么结果肯定会报错ArrayIndexOutOfException. 
		// 索引只是我们在调用的时候会去使用的一个数据,而我们在设定元素的存储大小的时候还是要以实际为准,因此要在索引的基础上+1,数组的实际能够存放元素的数量是与cursor里面的实际存放元素的数量是对等的.
		// 这样才不会在后面的使用中报出数组下表越界这样的错误.
		
		String[] str = new String[cursor.getColumnCount()+1];
			
		while(cursor.moveToNext()) {
			
			int id = cursor.getInt(cursor.getColumnIndex("id"));
			
			String author = cursor.getString(cursor.getColumnIndex("author"));
			
			float  price  = cursor.getFloat(cursor.getColumnIndex("price"));
			
			int    pages   = cursor.getInt(cursor.getColumnIndex("pages"));
			
			str[cursor.getPosition()] = "员工id:" + id + " 员工权限:" + author + " 员工工资:" + price + " 员工页数:" + pages;
			
		} 
		
		// 释放资源.
		cursor.close();
		
		Log.d("DatabaseHelperActivity",String.valueOf(cursor.getColumnCount() + 1));
		
		// 将以下四行代码注释掉即可解决数据库没有数据点击查询数据就报错的情况,实际上是ArrayAdapter再报错,前面的代码没有错误. -- 2018/3/16
		// 可惜没有作用了,现在不管怎么样都会进行报错,所以只能将这四行代码进行屏蔽. -- 2018/3/19
		
		/*// 将获取到的数据放入ListView中.
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,str);
		
		// 3.获取ListView控件资源.
		ListView listView = (ListView) findViewById(R.id.database_listview);
		
		// 4.为控件添加适配器.
		listView.setAdapter(arrayAdapter);
		
		// 将ListView显示.
		listView.setVisibility(View.VISIBLE);*/
		
	}
	
	/**
	 * 使用事务操作数据库
	 * 这里将旧数据库删除,新数据插入数据库中.
	 * @param view
	 */
	public void shiwuData(View view) {
		// 获取SQLiteDatabase对象的实例.
		sqliteDatabase = myDatabaseHelper.getWritableDatabase();
		
		// 开启事物
		sqliteDatabase.beginTransaction();
		
		try {
			
			// 删除数据
			sqliteDatabase.delete("Book",null,null);
			
			// 异常处理,判断事物是否有效 判断当在数据的传输当中出现了错误,事物是否能够有效的将数据撤回,将数据恢复到原先的状态.
			/*if (true) {
				throw new NullPointerException(); 
			}*/
			
			// ContentValues对象
			ContentValues contentValues = new ContentValues();
			
			contentValues.put("name", "linlin");
			contentValues.put("author","manager");
			contentValues.put("price",98.8);
			contentValues.put("pages",89);
			
			// 插入数据
			sqliteDatabase.insert("Book",null,contentValues);
			
			// 结束事物
			sqliteDatabase.setTransactionSuccessful();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqliteDatabase.endTransaction();
		}
		
	}
	
}