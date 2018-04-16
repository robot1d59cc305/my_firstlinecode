package democode.firstlinecode.demo10.datastorage.activity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.example.democode.firstlinecode.demo10.datastorage.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 
 * @author Administrator
 *
 */
public class SaveFileActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.save_file);
		
		/*Intent intent = new Intent("com.example.broadcast.receiver");
		
		sendBroadcast(intent);*/
		
		// 3.从文件中读取数据给str.
		StringBuilder str = load();
		
		/* 4.判断步骤3中str执行过load()方法后是否存在数据 
		 *   这里首先通过TextUtils.isEmpty(str)判断字符串是否为空,若为空则返回true.
		 *   但是这里取反,将true的结果变成false,也就是说,在这种情况下是不能够执行这个if分支流程语句里面的代码.
		 *   只有在str里面有内容的情况下才可以去执行,那么当str里面有内容时说明这不是用户第一次或者说用户没有写东西,说明我们的load方法
		 *   在读取数据.于是这里我们就可以将读取到的数据放入到save_file.xml里面的id等于save_file_edit1d的控件当中.
		 * */
		if (!TextUtils.isEmpty(str)) {
			
			EditText editText = (EditText) findViewById(R.id.save_file_edit1);
			
			// 将内容放到视图中的文本框当中.
			editText.setText(str.toString());
			
			editText.setSelection(str.length());
			
			Toast.makeText(this,"Reader Resource",Toast.LENGTH_LONG).show();
			
		}
		
	}
	
	/**
	 * 保存一段文字到文本.
	 * @param inputText
	 */
	public void save(String inputText) {
		
		// 
		FileOutputStream fileOutputStream = null;
		
		BufferedWriter   bufferedWriter   = null;
		
		try {
			
			fileOutputStream = openFileOutput("save",Context.MODE_PRIVATE);
			
			bufferedWriter   = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
			
			bufferedWriter.write(inputText);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	/**
	 * 加载文本中的文字到程序当中.
	 * @return
	 */
	public StringBuilder load() {
		
		FileInputStream fileInputStream = null;
		
		BufferedReader  bufferedReader  = null;
		
		StringBuilder   strb            = new StringBuilder();
		
		try {
			
			fileInputStream = openFileInput("save");
			
			bufferedReader  = new BufferedReader(new InputStreamReader(fileInputStream));
			
			String line = "";
			
			while ((line = bufferedReader.readLine()) != null) {
				strb.append(line);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		return strb;
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		// 在关闭销毁这个Activity的时候将已经输入到文本框的内容进行保存.
		save(((EditText) findViewById(R.id.save_file_edit1)).getText().toString());
		
		// 卸载广播接收器类
//		unregisterReceiver(myBroadcastReceiver);
		
	}
	
}