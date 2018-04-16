package democode.firstlinecode.demo11.content.provider.basic;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;

/**
 * 
 * 简单的使用Android内容提供器
 * @author Administrator
 *
 */
public class BasicContentProviderActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 1.获取ContentResolver对象 ContentResolver中提供类似于SQLiteDatabase类的insert,query,update方法,但是这些方法放入的参数不是像SQLiteDatabase类方法中的表名,而是URI链接名称.
		ContentResolver contentResolver = getContentResolver();
		
		/* 2.准备URI链接对象.
		 * URL链接名称由以下部分组成:
		 * 权限(authority),路径(path)
		 * 
		 * 权限 是用于对不同的应用程序做区分的，一般为了避免冲突，都会采用程序包名的方式来进行命名。比如某个
		       程序的包名是 com.example.app，那么该程序对应的权限就可以命名为 com.example.app.provider。 
		
		       路径 则是用于对同一应用程序中不同的表做区分的，通常都会添加到权限的后面。
		       比如某个程序的数据库里存在两张表，table1 和 table2，这时就可以将路径分别命名为/table1
		       和/table2，然后把权限和路径进行组合，
		       
		       因此内容URI最标准的写法如下:
		   content://com.example.app.provider/table1
		   content://com.example.app.provider/table2
		*/
		Uri uri = Uri.parse("content://com.example.app.provider/table1");
		
		// 3.调用1中相应的方法
//		Cursor cursor = contentResolver.query(uri, projection, selection, selectionArgs, sortOrder); 只不过这里并没有相应的参数可以传递进去.
		
		
		// 4.遍历3中的cursor
		/*if (cursor != null) {
			
			while (cursor.moveToNext()) {
				String column1 = cursor.getString(cursor.getColumnIndex("column1"));
				int column2 = cursor.getInt(cursor.getColumnIndex("column2"));
			}
			
			cursor.close();
		}*/
		
		// 5.调用insert方法插入数据
		ContentValues contentValues = new ContentValues();
		contentValues.put("column","text");
		contentValues.put("column2",2);
		contentResolver.insert(uri,contentValues);
		
		// 6.调用update方法更新数据
		ContentValues contentValues2 = new ContentValues();
		contentValues2.put("column1","");
		getContentResolver().update(uri,contentValues2,"column1 = ? and column2 = ?", new
				String[] {"text", "1"});
		
		// 7.调用delete方法删除数据
		getContentResolver().delete(uri, "column2 = ?", new String[] { "1" });
	}
	
}