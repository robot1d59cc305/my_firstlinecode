package democode.firstlinecode.demo11.content.provider.custom;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import democode.firstlinecode.demo11.content.provider.datastorage.MyDatabaseHelper;

/**
 * 内容提供器.
 * @author Administrator
 *
 */
public class MyContentProvider extends ContentProvider {
	
	/**
	 * Book表所有.
	 */
	private static final int BOOK_DIR = 0;
	
	/**
	 * Book表的某个id列.
	 */
	private static final int BOOK_ITEM = 1;
	
	/**
	 * 权限
	 */
	private static final String AUTHOR = "com.example.democode.firstlinecode.demo11.content.provider.custom";
	
	/**
	 *  管理所有的URL,匹配的时候会去匹配这里面的URL.
	 */
	private static UriMatcher uriMatcher;
	
	/**
	 * 数据库创建帮助类,在后期获取信息的时候还需要从数据库中去获取,所以需要这个类的帮助.
	 */
	private MyDatabaseHelper myDatabaseHelper;
	
	/**
	 * 通过这个类对数据库进行数据操作.
	 */
	private SQLiteDatabase   sqLiteDatabase;
	
	/**
	 * 静态,在类一开始进行加载的时候就把所有需要匹配的URI地址加入进去.
	 */
	static {
		// 获取UriMatcher的实例
	    uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(AUTHOR,"book", BOOK_DIR);
		uriMatcher.addURI(AUTHOR,"book/#",BOOK_ITEM);
	}
	
	@Override
	public boolean onCreate() {
		// 将数据库实例化
		myDatabaseHelper = new MyDatabaseHelper(getContext(),"BookStore",null,2);
		
		// 将数据库文件写出,并获取到SQLiteDatabase的实例. 不要在这里写这个,因为这个方法会被自动的记性调用.就是在安装程序之后自动的进行调用,如果说自动的进行调用那么可能有些时候会多此一举达不到原本要达到的效果.
//		sqLiteDatabase = myDatabaseHelper.getWritableDatabase(); 
		
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		
		sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
		Cursor cursor  = null;
		
		switch (uriMatcher.match(uri)) {
		
			case BOOK_DIR:
				
				 // 获取表数据
				 cursor = sqLiteDatabase.query("Book",projection,selection,selectionArgs,null,null,sortOrder);
				 
				 break;
				 
			case BOOK_ITEM:
				
				 // 获取到具体指定的id 
				 String book_id = uri.getPathSegments().get(1);
				
				 // 获取表数据 
				 cursor = sqLiteDatabase.query("Book",projection,"id = ?",new String[]{book_id},null,null,sortOrder);
				 
				 break;
				 
			default:
				 break;
		}
		
		return cursor;
	}

	/**
	 * 返回用户输入的每一个的值的对应的值
	 */
	@Override
	public String getType(Uri uri) {
		switch (uriMatcher.match(uri)) {
			case BOOK_DIR:
				 return "vnd.android.cursor.dir/vnd.com.example.democode.firstlinecode.demo11.content.provider.custom.book";
			case BOOK_ITEM:
				 return "vnd.android.cursor.item/vnd.com.example.democode.firstlinecode.demo11.content.provider.custom.book";
		}
		
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		
		sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
		
		Uri uriReturn = null;
		
		switch (uriMatcher.match(uri)) {
			case BOOK_DIR:
			case BOOK_ITEM:
				 long newBookId = sqLiteDatabase.insert("Book",null,values);
				 uriReturn = Uri.parse("content://" + AUTHOR + "/book" + newBookId);
				 break;
		}
		
		return uriReturn;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		
		sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
		
		int deleteRow = 0;
		
		// 匹配uri字符串.
		switch (uriMatcher.match(uri)) {
			case BOOK_DIR:
				deleteRow = sqLiteDatabase.delete("Book",selection,selectionArgs);
				break;
			case BOOK_ITEM:
				String bookId = uri.getPathSegments().get(1);
				deleteRow  = sqLiteDatabase.delete("Book","id = ?",new String[]{bookId});
				break;
			default:
				break;
		}
		
		return deleteRow;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		
		sqLiteDatabase = myDatabaseHelper.getWritableDatabase();
		
		int updateRows = 0;
		
		switch (uriMatcher.match(uri)) {
			case BOOK_DIR:
				 updateRows = sqLiteDatabase.update("Book",values,selection,selectionArgs);
				 break;
			case BOOK_ITEM:
				 String bookId = uri.getPathSegments().get(1);
				 updateRows = sqLiteDatabase.update("Book",values,"id = ?",new String[]{bookId});
				 break;
		}
		
		return 0;
	}

}