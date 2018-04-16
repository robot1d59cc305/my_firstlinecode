package democode.firstlinecode.demo14.webview_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.example.democode.firstlinecode.demo14.webview.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import democode.firstlinecode.demo14.webview_network.other.App;
import democode.firstlinecode.demo14.webview_network.other.ContentHandler;

/**
 * 
 * HttpUrlConnectionActivityx
 * 1.Web展示Activity,在应用程序当中调用网页.
 * @author Administrator
 */
public class HttpUrlConnectionActivity extends Activity implements OnClickListener {

	/*
	 * 
	 */
	public static final int SHOW_RESPONSE = 0;

	/*
	 * 发送请求
	 */
	private Button sendRequest;

	/*
	 * 响应文本
	 */
	private TextView responseText;

	/*
	 * 1.在MainActivity进行点击的时候会将所点击的id值一并传递到这个属性当中,然后在根据这个id值来判断需要使用哪一种请求方法来获取数据.
	 * 2.这样做可以直接在MainActivity类中去点击相应的按钮,然后就可以去调用HttpUrlConnectionActivity中的功能.
	 * 3.当然是在MainActivity类中点击相应的按钮就去将对应的id值赋值到这个属性上,
	 * 然后进入到HttpUrlConnectionActivity当中这里加载的视图里面默认带了一个按钮.
	 * 4.通过点击这个按钮,为这个按钮设置相应onClickListener监听事件,然后在onClick方法当中编写相应的业务代码.
	 * 5.这个业务代码是使用switch分支流程语句来case id
	 * 的值,case的值是加载了activity_main.xml文件中id为activity_main_button2以后的id类型的名称,
	 * 这个id的类型的名称除整个名称字符串最后一个变外其它不变,最后一个变的规律按照自然数的增长进行增加.
	 */
	public static int id;

	/*
	 * 1.url地址,是用来在sendRequestWithHttpClient2()方法中因为需要获取服务器上的文件地址,所以说将地址存储在这个变量当中,
	 * 然后在获取服务器文件地址的时候将这个变量放入进去,使用这个变量里面的值作为服务器文件的路径.
	 */
	private String url;

	/*
	 * 2.method选项,是用来在去sendRequestWithHttpClient2()获取到服务器的地址之后,需要判断要调用哪些方法进行文件的解析.
	 * 这里面的值是根据我在每个方法上面写的注释都会有一个关于方法的标号,我将需要调用的那个文件的标号放在这个变量里面进行了选择.
	 */
	private int method;

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
				responseText.setText(resource);
			}
		}

	};

	/**
	 * 创建资源.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// 1.调用父类onCreate方法.
		super.onCreate(savedInstanceState);

		// 2.设置内容视图.
		super.setContentView(R.layout.httpurlconnection);

		// 3.获取2中内容视图资源并且赋值给sendRequest.
		sendRequest = (Button) findViewById(R.id.httpurlconnection_button1);

		// 4.获取2中内容视图资源并且赋值给responseText;
		responseText = (TextView) findViewById(R.id.httpurlconnection_textview1);

		// 5.给3加上点击事件
		sendRequest.setOnClickListener(this);

	}

	/**
	 * 为按钮添加业务逻辑.
	 * 
	 * @param view
	 */
	public void onClick(View view) {
		// 加载MainActivity.java文件中的视图文件,因为需要与这个视图文件中的资源去进行比较.
		super.getLayoutInflater().inflate(R.layout.activity_main, null);

		switch (id) {
			case R.id.activity_main_button_2:
				Log.d("HttpUrlConnectionActivity", "正在使用HttpURLConnection访问网络");
				sendRequestWithHttpURLConnection();
				break;
			case R.id.activity_main_button_3:
				Log.d("HttpUrlConnectionActivity", "正在使用HttpGet访问网络");
				sendRequestWithHttpClient();
				break;
			case R.id.activity_main_button_4:
				Log.d("HttpUrlConnectionActivity", "正在使用HttpGet访问XML文件--使用PULL方式解析XML");
				sendRequestWithHttpClient2();
				url = "http://192.168.1.101/get_data.xml";
				method = 3;
				break;
			case R.id.activity_main_button_5:
				Log.d("HttpUrlConnectionActivity", "正在使用HttpGet访问XML文件--使用SAX方式解析XML");
				sendRequestWithHttpClient2();
				url = "http://192.168.1.101/get_data.xml";
				method = 4;
				break;
			case R.id.activity_main_button_6:
				Log.d("HttpUrlConnectionActivity", "正在使用HttpGet访问JSON文件--使用JSONObject方式解析JSON");
				sendRequestWithHttpClient2();
				url = "http://192.168.1.101/get_data.json";
				method=5;
			case R.id.activity_main_button_7:
				Log.d("HttpUrlConnectionActivity", "正在使用HttpGet访问JSON文件--使用GSON方式解析JSON");
				sendRequestWithHttpClient2();
				url = "http://192.168.1.101/get_data.json";
				method=6;
			default:
				break;
		}

	}

	/**
	 * 1.发送HttpURLConnection请求,来获取服务器返回的内容.
	 */
	private void sendRequestWithHttpURLConnection() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				HttpURLConnection connection = null;

				try {

					// 1.对HttpURLConnection对象进行设置.
					URL url = new URL("http://www.baidu.com");
//					URL url = new URL("http://www.weather.com.cn/data/list3/city19.xml");
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					connection.setDoInput(true);
					connection.setDoOutput(true);

					// 2.通过1获取输入流.
					InputStream in = connection.getInputStream();

					// 3.读取2中的输入流.
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					StringBuilder response = new StringBuilder();
					String line;

					while ((line = reader.readLine()) != null) {
						response.append(line);
					}

					// 4.准备Message对象
					Message message = new Message();
					message.what = SHOW_RESPONSE;

					// 5.将4中的message对象返回给服务器端.
					message.obj = response.toString();
					handler.sendMessage(message);

				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {

					if (connection != null) {
						connection.disconnect();
					}

				}
			}
			
		}).start();
	}

	/**
	 * 2.发送HttpClient请求.
	 */
	private void sendRequestWithHttpClient() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// 1.通过new DefaultHttpClient()来获取HttpClient的实例.
					HttpClient httpClient = new DefaultHttpClient();

					// 2.实例化一个HttpGet的对象.
//					HttpGet httpGet = new HttpGet("http://www.baidu.com");
					HttpGet httpGet = new HttpGet("http://www.weather.com.cn/data/list3/city19.xml");

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
						
					}

				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	/**
	 * 访问电脑中使用Apache服务器上的一个文件.
	 */
	private void sendRequestWithHttpClient2() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// 1.通过new DefaultHttpClient()来获取HttpClient的实例.
					HttpClient httpClient = new DefaultHttpClient();

					/*
					 * 2.实例化一个HttpGet的对象.从电脑的Apache服务器上获取即可. 这里的地址需要使用在电脑客户端上的Start Apache in
					 * Console 上给出的地址,因为这个地址是能够直接在浏览器当中访问到的. 另外我们这里又因为是一个并没有部署运行在服务器上的WEB应用程序.
					 * 所以,实际上也只能够在电脑上进行访问操作,不能够拿到其它的地方,因为如果拿到其它的地方数据就会获取不到.
					 * 所以要想使这个应用程序能够真正的运行起来需要符合三个条件: I.可以使用 http://192.168.1.101/get_data.xml
					 * 这个地址访问到xml文件,且里面的xml文件的数据结构可以与parseXMLWithPull()方法获取遍历的节点是一样的,
					 * 这个需要提前在模拟器里面运行安卓应用程序的时候就必须要做好准备.当然这个 http://192.168.1.101的地址到底是哪个这里不限定根据情况而定.
					 * II.sendRequestWithHttpClient2,parseXMLWithPull方法内部整个的程序运行逻辑结构没有错误,
					 * 符合I中的xml文件结构,业务,且能够顺利通过编译运行.
					 * III.在Logcat插件上添加HttpUrlConnectionActivity,因为最终结果是输出到HttpUrlConnectionActivity
					 * 键的.
					 */

					// HttpGet httpGet = new HttpGet("http://192.168.1.101//get_data.xml");
					// 这里因为后来有很多的方法需要去调用这里的代码,但是重复写又会导致代码量的臃肿因此改变为了使用url参数作为地址,然后在onClick方法中会将url传递进去.
					HttpGet httpGet = new HttpGet(url);

					// 3.通过1中的execute方法将2中的对象进行组装来获取到HttpResponse的对象引用地址.
					HttpResponse httpResponse = httpClient.execute(httpGet);

					// 4.通过3中的HttpResponse对象来判断当前的HTTP请求状态码是否为200.
					if (httpResponse.getStatusLine().getStatusCode() == 200) {

						// 5.请求和响应都成功了!通过4中的getEntity()方法获取实例
						HttpEntity entity = httpResponse.getEntity();

						// 6.通过5将结果保存为UTF-8的编码文件并且以String类型数据进行保存.
						String response = EntityUtils.toString(entity, "UTF-8");

						// 7.调用parseXMLWithPull,使用PULL的方式去解析XML文件,并且将获得的结果输出到Log窗口控制台上.
						switch (method) {
							case 3:
								parseXMLWithPull(response);
								break;
							case 4:
								parseXMLWithSAX(response);
								break;
							case 5:
								parseJSONWithJSONObject(response);
								break;
							case 6:
								parseJSONWithGSON(response);
								break;
						default:
							break;
						}
					}

				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	/**
	 * 3.解析XML PULL方式.
	 */
	private void parseXMLWithPull(String xmlData) {

		try {
			// 1.通过XmlPullParserFactory类中的newInstance()方法获取到实例.
			XmlPullParserFactory xmlPullParseFactory = XmlPullParserFactory.newInstance();

			// 2.通过1调用newPullParser方法获取到XmlPullParser对象实例.
			XmlPullParser xmlPullParser = xmlPullParseFactory.newPullParser();

			// 3.通过2中的setInput给一个StringReader类型的参数,将xmlData做为其构造器参数.
			xmlPullParser.setInput(new StringReader(xmlData));

			/*
			 * 4.通过2中的getEventType()方法获取到一个解析事件.这个解释事件表示了当前解析的进度是解析完了一行xml数据还是没有解析完一行xml数据.
			 * 用户通过是否正在解析数据根据当前的事件状态来做相应的代码,比如说当事件状态为 START_TAG 则表示正在解析,则可以将解析到的节点数据进行保存.
			 * END_TAG 则表示解析完某各节点,则可以将解析到的节点数据通过Log打印输出到控制台.
			 * 当然最后将这个方法获取到的数据使用一个int类型的变量进行保存.
			 */
			int eventType = xmlPullParser.getEventType();

			// 5.准备字符串id,version,name 用来存储等一会会得到的数据.
			String id = "", version = "", name = "";

			// 6.循环语句,当eventType不等于XmlPullParser.END_DOCUMENT时进行循环遍历.
			while (eventType != XmlPullParser.END_DOCUMENT) {

				// 6.1 通过2中的getName()方法获取到当前正在便利的节点名称.
				String nodeName = xmlPullParser.getName();

				// 6.2 switch分支语句判断4中保存的事件状态.
				switch (eventType) {

					// 6.3 case XmlPullParser.START_TAG
					case XmlPullParser.START_TAG: {
	
						// 6.3.1 使用if,else if语句判断6.1中保存的节点名称是否为5中准备的字符串.如果是则调用nextText()方法返回数据到5中的每一个属性.
						if (nodeName.equals("id")) {
							id = xmlPullParser.nextText();
						} else if (nodeName.equals("version")) {
							version = xmlPullParser.nextText();
						} else if (nodeName.equals("name")) {
							name = xmlPullParser.nextText();
						}
	
						break;
					}
	
					// 6.4 case XmlPullParser.END_TAG
					case XmlPullParser.END_TAG: {
	
						// 6.3.2 使用if判断6.1中的节点名称是否为app,因为app就是每一个app节点开头的结尾app节点.
						if (nodeName.equals("app")) {
	
							// 6.3.3使用Log输出5中的字符串,因为这个时候5中已经有了数据.
							Log.d("HttpUrlConnectionActivity",
									"id:" + id + " " + "name:" + name + " " + "version:" + version);
						}
	
						break;
					}

				}

				// 6.5 循环语句结尾使用2中的next()方法并将其数据保存到4中.
				eventType = xmlPullParser.next();
				
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 4.xml解析 SAX方式. 在得到了服务器返回的数据后，我们这次去调用 parseXMLWithSAX()方法来解析 XML数据。
	 * 
	 */
	private void parseXMLWithSAX(String xmlData) {
		try {
			// parseXMLWithSAX()方法中先是创建了一个 SAXParserFactory 的对象，然后再获取到XMLReader 对象.
			SAXParserFactory factory = SAXParserFactory.newInstance();
			XMLReader xmlReader = factory.newSAXParser().getXMLReader();

			// 接着将我们编写的 ContentHandler 的实例设置到 XMLReader 中，最后调用 parse()方法开始执行解析就好了。
			ContentHandler handler = new ContentHandler();
			xmlReader.setContentHandler(handler);
			xmlReader.parse(new InputSource(new StringReader(xmlData)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 5.解析JSON--使用JSONObject的方式.
	 * 
	 * @param jsonData
	 */
	private void parseJSONWithJSONObject(String jsonData) {
		try {
			
			// 1.实例化JSONArray对象,并且将jsonData数据包裹进来.
			JSONArray jsonArray = new JSONArray(jsonData);

			// 2.循环遍历jsonArray中的数据.
			for (int i = 0; i < jsonArray.length(); i++) {

				// 2.1 实例化JSONObject对象,从1中通过getJSONObject方法.
				JSONObject jsonObject = jsonArray.getJSONObject(i);

				// 2.2 从2.1中获取到每一个json项的具体属性数据.
				String id = jsonObject.getString("id");
				String version = jsonObject.getString("version");
				String name = jsonObject.getString("name");

				// 2.3 将2.2中的数据输出到Log控制台中.
				Log.d("HttpUrlConnectionActivity", "id:" + id + " " + "name:" + name + " " + "version:" + version);
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 6.解析JSON--使用GSON的方式.
	 * @param jsonData
	 */
	private void parseJSONWithGSON(String jsonData) {
		Gson gson = new Gson();
		List<App> appList = gson.fromJson(jsonData, new TypeToken<List<App>>() {
		}.getType());
		for (App app : appList) {
			Log.d("HttpUrlConnectionActivity", "id:" + app.getId() + " " + " name:" + app.getName() + " " + " version:" + app.getVersion());
		}
	}

}