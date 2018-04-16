package democode.firstlinecode.demo14.webview_network;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.example.democode.firstlinecode.demo14.webview.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import democode.firstlinecode.demo14.webview_network.other.HttpUtil;

/**
 * XmlServerLocationFileContentParseActivity
 * XML服务器地址文件内容解析Activity
 * @author Administrator
 *
 */
public class XmlServerLocationFileContentParseActivity extends Activity {
	
	private EditText testserver_edittext1;
	
	private Button   testserver_button1;
	
	private TextView testserver_textview1;
	
	private HttpUtil httpUtil = new HttpUtil();
	
	public static final int SHOW_RESPONSE = 0;
	
	/*
	 * Handler类处理message的消息.
	 */
	private Handler handler = new Handler() {

		public void handleMessage(Message msg) {
			// 分支流程判断msg的what属性是否和SHOW_RESPONSE的值是相等的.
			if (msg.what == SHOW_RESPONSE) {
				// 获取message对象中的obj属性并将其强转为String类型.
				String resource = (String) msg.obj;

				// 将这个结果赋值到文本框当中.
				testserver_textview1.setText(resource);
			}
		}

	};
	
	/**
	 * 1.创建资源
	 */
	protected void onCreate(Bundle bundle) {
		
		// 1
		super.onCreate(bundle);
		
		// 2 此方法需要在3之前进行调用
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		// 3
		super.setContentView(R.layout.testserver);
		
		// 4 
		testserver_edittext1 = (EditText) super.findViewById(R.id.testserver_edittext1);
		
		testserver_button1   = (Button)   super.findViewById(R.id.testserver_button1);
		
		testserver_textview1 = (TextView) super.findViewById(R.id.testserver_textview1); 
		
		// 5
		testserver_button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				sendRequestWithHttpClient(testserver_edittext1.getText().toString());
				
			}
			
		});
		
	}
	
	/**
	 * 2.发送HttpClient请求.
	 */
	private void sendRequestWithHttpClient(final String address) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				
				final StringBuilder stringBuilder = new StringBuilder(address);
				
				try {
					// 1.通过new DefaultHttpClient()来获取HttpClient的实例.
					HttpClient httpClient = new DefaultHttpClient();

					/*
					 * 为了保证用户在文本框中输入的地址是正确的,因此这里需要提前做判断.
					 * */
					if (address.contains("http://")) {
						
						runOnUiThread(new Runnable() {
							
							@Override
							public void run() {
								Toast.makeText(XmlServerLocationFileContentParseActivity.this,"网站地址正确,正在解析网站文件",Toast.LENGTH_SHORT).show();
							}
							
						});
						
					} else {
						
						/*
						 * 因为如果输入的不是一个完整的网址则这个程序就会报错.所以如果当前不包括www字符串则直接退出方法不执行这个方法
						 * */
						if (!address.contains("www")) {
							
							testserver_edittext1.setText("http://www.weather.com.cn/data/list3/city.xml");
							
							Toast.makeText(XmlServerLocationFileContentParseActivity.this,"网站地址无效或缺少关键字符,请按照文本展示框中的地址输入",Toast.LENGTH_SHORT).show();
							
							System.exit(0);
							
							return;
						}
						
						// 如果说用户已经在开头的位置输入了http://中的一些字符,但是还不是很完整,则先将www前面的字符串到索引位置0的这中间的位置清除掉.这只会删除0位置和www字符之前位置的字符.
						stringBuilder.delete(0,stringBuilder.indexOf("www"));
						
						// 将开头的位置加入http://
						stringBuilder.insert(0,"http://");	
						
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								
								testserver_edittext1.setText(stringBuilder.toString());
								
								Toast.makeText(XmlServerLocationFileContentParseActivity.this,"网站地址错误,必须要在开头加入http://,程序自动修复成功",Toast.LENGTH_SHORT).show();
							}
						});
						
					}
					
					// 2.实例化一个HttpGet的对象.
//					HttpGet httpGet = new HttpGet("http://www.baidu.com");
					HttpGet httpGet = new HttpGet(stringBuilder.toString());

					// 3.通过1中的execute方法将2中的对象进行组装来获取到HttpResponse的对象引用地址.
					HttpResponse httpResponse = httpClient.execute(httpGet);

					// 4.通过3中的HttpResponse对象来判断当前的HTTP请求状态码是否为200.
					if (httpResponse.getStatusLine().getStatusCode() == 200) {

						// 5.请求和响应都成功了!通过4中的getEntity()方法获取实例
						HttpEntity entity = httpResponse.getEntity();

						// 6.通过5将结果保存为UTF-8的编码文件并且以String类型数据进行保存.
						String response = EntityUtils.toString(entity, "UTF-8");

						// 7.获取Message对象
						Message message = new Message();

						// 8.设置Message对象中的what属性
						message.what = SHOW_RESPONSE;

						// 9.将服务器返回的结果保存到Message中.
						message.obj = response.toString();

						// 10.发送信息
						handler.sendMessage(message);
						
					} else {
					
						Toast.makeText(XmlServerLocationFileContentParseActivity.this,"解析失败,请检查服务器xml文件地址或程序代码,本程序采用EclipseIDE开发",Toast.LENGTH_LONG).show();
						
					}

				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					Toast.makeText(XmlServerLocationFileContentParseActivity.this,"网站地址无效,程序崩溃",Toast.LENGTH_SHORT).show();
					e.printStackTrace();
				}
			}
		}).start();
	}
	
}