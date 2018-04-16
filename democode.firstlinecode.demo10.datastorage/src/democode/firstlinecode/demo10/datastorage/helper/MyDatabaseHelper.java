package democode.firstlinecode.demo10.datastorage.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.widget.Toast;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 继承SQLiteOpenHelper类来使用Android的SQLite数据库.
 * @author Administrator
 *
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

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
	
	Context mContext;
		
	public MyDatabaseHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_BOOK);
		db.execSQL(CREATE_CATEGORY);
		Toast.makeText(mContext,"CREATE DATABASE",Toast.LENGTH_LONG).show();
	}

	/**
	 * 如果想让这个方法能够成功的执行成功的跑起来,则还需要在获取这个类的实例的时候将数据库的版本号指定成比之前指定的版本号高一个版本.
	 * 但是这种方法只适合用在开发阶段.因为在开发阶段可以不涉及到用户的数据.
	 * 产品上线阶段这种方法不适合使用.但是在上线阶段已经涉及到用户的数据,很多数据保存在本地的数据库,贸然删除会会让以前存储在本地的数据丢失....
	 * 当然存储在服务端的数据可以有办法下载,不过没有存储在服务器端的数据就很尴尬了,这里只是删除了表之后重建一张具体之前数据结构但并没有数据的新表.
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists Book");
		db.execSQL("drop table if exists Category");
		onCreate(db);
	}

}