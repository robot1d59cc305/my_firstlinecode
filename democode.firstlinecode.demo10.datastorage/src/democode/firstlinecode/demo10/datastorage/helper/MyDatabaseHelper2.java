package democode.firstlinecode.demo10.datastorage.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 
 * Android使用数据库2,这个是产品上线阶段使用的类.
 * @author Administrator
 *
 */
public class MyDatabaseHelper2 extends SQLiteOpenHelper {

	public static final String CREATE_BOOK = "create table Book ("
			+ "id integer primary key autoincrement, " 
			+ "author text, "
			+ "price real, " 
			+ "pages integer, " 
			+ "name text)";
	
	public static final String CREATE_CATEGORY = "create table Category ("
			+ "id integer primary key autoincrement, "
			+ "category_name text, "
			+ "category_code integer)";
	
	public MyDatabaseHelper2(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_BOOK);
		db.execSQL(CREATE_CATEGORY);
	}

	/**
	 * 升级时调用的方法
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		Log.d("oldVersion",String.valueOf(oldVersion));
		
		switch (oldVersion) {
			case 1:
//				db.execSQL(CREATE_CATEGORY);  这里的代码为什么执行不了?因为这里执行的代码最终得到的结果是创建一个表叫做CATEGORY但是我们已经在前面的onCreate方法里面创建出来因此不能执行这行会报表已经重复这种异常.
			case 2:
				db.execSQL("alter table Book add column category_id integer");
			default:
		}
		
	}

}