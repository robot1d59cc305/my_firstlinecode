package democode.firstlinecode.demo11.content.provider.custom;

import com.example.democode.firstlinecode.demo11.content.provider.R;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 使用 democode.firstlinecode.demo11.content.provider.custom 项目的内容提供器. 
 * @author Administrator
 *
 */
public class MyContentProviderActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.content_provider);
		
		Button button = (Button) findViewById(R.id.query_data);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// 1.Uri
				Uri uri = Uri.parse("content://com.example.democode.firstlinecode.demo11.content.provider.custom/book"); 
				
				// 2.解析URi获取Cursor对象
				Cursor cursor = getContentResolver().query(uri,null,null,null,null);
				
				// 3.遍历Cusror对象,将获得的数据循环打印
				if (cursor != null) {
					
					// 遍历cursor中的内容
					while (cursor.moveToNext()) {
						
						String author = cursor.getString(cursor.getColumnIndex("author"));
						
						Double price  = cursor.getDouble(cursor.getColumnIndex("price"));
						
						int    pages  = cursor.getInt(cursor.getColumnIndex("pages"));
						
						String name   = cursor.getString(cursor.getColumnIndex("name"));
						
						Log.d("MyContentProviderActivity","author:" + author);
						Log.d("MyContentProviderActivity","price:"  + price);
						Log.d("MyContentProviderActivity","pages:"  + pages);
						Log.d("MyContentProviderActivity","name:"   + name);
					}
					
				   // 关闭cursor
				   cursor.close();
				   
				}
				
			}
			
		});
		
	}
	
}