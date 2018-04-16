package democode.firstlinecode.demo11.content.provider.custom;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/**
 * 创建一个内容提供器.
 * @author Administrator
 *
 */
public class MyContentProvider extends ContentProvider {

	/*
	 *  回顾一下，一个标准的内容 URI 写法是这样的：
	 *  content://com.example.app.provider/table1
	 * */
	
	/*
	 *  如何匹配:
	 *  内容 URI 的格式主要就只有以上两种，以路径结尾据。我们可以使用通配符的方式来分别匹
		配这两种格式的内容 URI，规则如下。
			1. *：表示匹配任意长度的任意字符就表示期望访问该表中所有的数据，
		以 id 结尾就表示期望访问该表中拥有相应 id 的数
			2. #：表示匹配任意长度的数字
		所以，一个能够匹配任意表的内容 URI 格式就可以写成：
			content://com.example.app.provider/*
		而一个能够匹配 table1 表中任意一行数据的内容 URI 格式就可以写成：
			content://com.example.app.provider/table1/#
	 * */
	
	/**
	 *  初始化内容提供器的时候调用。通常会在这里完成对数据库的创建和升级等操作，
		返回 true 表示内容提供器初始化成功，返回 false 则表示失败。注意，只有当存在
		ContentResolver 尝试访问我们程序中的数据时，内容提供器才会被初始化。
	 */
	@Override
	public boolean onCreate() {
		return false;
	}

	/**
	 *  从内容提供器中查询数据。使用 uri 参数来确定查询哪张表，projection 参数用于确
		定查询哪些列，selection 和 selectionArgs 参数用于约束查询哪些行，sortOrder 参数用于
		对结果进行排序，查询的结果存放在 Cursor 对象中返回。
	 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		return null;
	}

	/**
	 *  根据传入的内容 URI 来返回相应的 MIME 类型。
		可以看到，几乎每一个方法都会带有 Uri 这个参数，这个参数也正是调用 ContentResolver
		的增删改查方法时传递过来的。而现在，我们需要对传入的 Uri 参数进行解析，从中分析出
		调用方期望访问的表和数据。
		
		一个内容 URI 所对应的 MIME字符串主要由三部分组分，Android 对这三个部分做了如下格式规定。
		1. 必须以 vnd 开头。
		2. 如果内容 URI 以路径结尾，则后接 android.cursor.dir/，如果内容 URI 以 id 结尾，
		则后接 android.cursor.item/。
		3. 最后接上 vnd.<authority>.<path>。
		
		所以，对于 content://com.example.app.provider/table1 这个内容 URI，它所对应的 MIME
		类型就可以写成：
			vnd.android.cursor.dir/vnd.com.example.app.provider.table1
		对于 content://com.example.app.provider/table1/1 这个内容 URI，它所对应的 MIME 类型
		就可以写成：
			vnd.android.cursor.item/vnd. com.example.app.provider.table1
	 */
	@Override
	public String getType(Uri uri) {
		return null;
	}

	/**
	 *  向内容提供器中添加一条数据。使用 uri 参数来确定要添加到的表，待添加的数据
		保存在 values 参数中。添加完成后，返回一个用于表示这条新记录的 URI。
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		return null;
	}

	/**
	 *  从内容提供器中删除数据。使用 uri 参数来确定删除哪一张表中的数据，selection
		和 selectionArgs 参数用于约束删除哪些行，被删除的行数将作为返回值返回。
	 */
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return 0;
	}

	/**
	 *  更新内容提供器中已有的数据。使用 uri 参数来确定更新哪一张表中的数据，新数
		据保存在 values 参数中，selection 和 selectionArgs 参数用于约束更新哪些行，受影响的
		行数将作为返回值返回。
	 */
	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		return 0;
	}

}