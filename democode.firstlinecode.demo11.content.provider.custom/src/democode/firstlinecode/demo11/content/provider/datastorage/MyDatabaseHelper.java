package democode.firstlinecode.demo11.content.provider.datastorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * 通过这个类去实现创建数据库
 * @author Administrator
 *
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {
	
	/**
	 * Book表SQL语句
	 */
	private static final String CREATE_TABLE = "CREATE TABLE Book("
											+  "id integer primary key autoincrement,"
											+  "author text,"
											+  "price  real,"
											+  "pages  integer,"
											+  "name   text);"
											;
	
	/**
	 * 全局管理者
	 */
	private Context mContext;
	
	/**
	 * 数据库构造器
	 * @param context
	 * @param name
	 * @param factory
	 * @param version
	 */
	public MyDatabaseHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		mContext = context;
	}

	/**
	 * 创建数据库
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// 执行 CREATE_TABLE 语句
		db.execSQL(CREATE_TABLE);
		
		// 执行以上SQL语句成功进行提示.
		Toast.makeText(mContext,"CREATE TABLE",Toast.LENGTH_LONG).show();
	}

	/**
	 * 升级数据库
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// 如果这个表已经存在,则删除这张表.
		db.execSQL("drop table if exists Book");
		
		// 重新执行onCreate方法,去执行一遍初始状态会去执行的方法.
		onCreate(db);
	}

}