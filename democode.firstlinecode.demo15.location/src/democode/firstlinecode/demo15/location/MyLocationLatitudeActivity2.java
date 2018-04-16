package democode.firstlinecode.demo15.location;

import java.io.IOException;
import java.util.List;

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

import com.example.democode.firstlinecode.demo15.location.R;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

/**
 * MyLocationLatitudeActivity2
 * 确定用户当前位置,并将当前位置的经纬度通过访问 Geocoding API来获取到这个经纬度说表示的信息然后将信息显示在TextView控件当中.
 * @author Administrator
 *
 */
public class MyLocationLatitudeActivity2 extends BaseActivity {
	
	// 
	private static final int SHOW_LOCATION =0;
	
	// 文本显示控件.
	private TextView positionTextView;
	
	// 位置信息管理器.
	private LocationManager locationManager;
	
	// 供应者.
	private String provider;
	
	// 位置监听器.
	LocationListener locationListener = new LocationListener() {

		@Override
		public void onLocationChanged(Location location) {
			// 更新当前设备的位置信息.
			showLocation(location);	
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			
		}

		@Override
		public void onProviderDisabled(String provider) {
			
		}
		
	};
	
	/**
	 * 创建资源
	 */
	protected void onCreate(Bundle bundle) {
		
		// 1.调用父类的onCreate方法.
		super.onCreate(bundle);
		
		// 2.设置内容视图.
		super.setContentView(R.layout.my_location_latitude);
		
		// 3.获取视图资源.
		positionTextView = (TextView) findViewById(R.id.my_location_latitude_textview1);
		locationManager  = (LocationManager) super.getSystemService(Context.LOCATION_SERVICE);
		
		// 4.获取所有的位置提供器.
		List<String> providerList = locationManager.getProviders(true);
		
		// 5.使用分支语句判断4中是否包含LocationManager.GPS_PROVIDER 或 NETWORK_PROVIDER , 当没有任何的位置提供器时如何处理.
		if (providerList.contains(LocationManager.GPS_PROVIDER)) {
			provider = LocationManager.GPS_PROVIDER;
		} else if (providerList.contains(LocationManager.NETWORK_PROVIDER)) {
			provider = LocationManager.NETWORK_PROVIDER;
		} else {
			
			// 当没有可用的位置提供器时,弹出Toast提示用户.
			Toast.makeText(this,"No Location provider to use",Toast.LENGTH_SHORT).show();
			
			// 结束方法运行.
			return;
			
		}
		
		Location location = locationManager.getLastKnownLocation(provider);
		
		if (location != null) {
			// 显示当前设备的位置信息
			showLocation(location);
		}
		
		// 通过这个代码添加了一个位置监听器. 设置时间间隔是5秒,距离间隔是1米,并在locationListener中的onLocationChanged()方法中实时更新TextView上显示的经纬度信息.
		locationManager.requestLocationUpdates(provider,5000,1,locationListener);
	}
	
	/**
	 * 销毁资源
	 */
	protected void onDestroy() {
		// 1.调用父类的onDestroy()销毁这个Activity.
		super.onDestroy();
		
		// 2.判断当locationManager不为空的情况. 当程序关闭时,还需要调用removeUpdates方法来将位置监听器移除,以保证不会继续耗费手机中的电量.
		if (locationManager != null) {
			// 2.1 删除更新locationListener.
			locationManager.removeUpdates(locationListener);
		}
		
	}
	
	/**
	 * 显示位置信息 
	 * @param location
	 */
	private void showLocation(final Location location) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				
				// 1.组装反向地理编码的接口地址.
				StringBuilder url = new StringBuilder();
				
				// 2.append目标地址.
				url.append("http://maps.googleapis.com/maps/api/geocode/json?latlng=");
				
				// 3.append目标地址所需要的参数.
				url.append(location.getLatitude()).append(",").append(location.getLongitude());
				
				// 4.追加一个参数sensor
				url.append("&sensor=false");
				
				// 5.准备发出1-4准备的HTTP地址. 准备HttpClient,以及HttpGet.两个对象.
				HttpClient httpClient = new DefaultHttpClient();
				HttpGet    httpGet    = new HttpGet(url.toString());
				
				// 6.在请求消息头中指定语言,保证服务器会返回中文数据.
				httpGet.addHeader("Accept-language","zh-CN");
				
				try {
					// 7.准备接受服务器返回的数据,准备HttpResponse对象.
					HttpResponse httpResponse = httpClient.execute(httpGet);
					
					// 8.判断HTTP服务器返回的状态码,若状态码为200则表示成功,可以进行下一步的数据解析操作.
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						
						// 9.获取数据
						HttpEntity entity = httpResponse.getEntity();
						
						// 10.将数据使用UTF-8编码保存到response中.
						String reponse = EntityUtils.toString(entity,"UTF-8");
						
						// 11.将10中获取到的数据使用JSONObject进行解析.这里面得到的数据是一个JSON数组.
						JSONObject jsonObject = new JSONObject(reponse);
						
						// 12.获取11中的位置信息.将数组信息保存
						JSONArray jsonArray = jsonObject.getJSONArray("results");
						
						// 13.判断12中长度大于0
						if (jsonArray.length() > 0) {
							
							// 14.取出数组中第0个数据,保存.
							JSONObject subObject = jsonArray.getJSONObject(0);
							
							// 15.将14中数据取出.
							String locationStr = subObject.getString("formatted_address");
							
							// 16.准备Message开始异步处理更新UI.
							Message message = new Message();
							
							// 17.设置message的属性.
							message.what=SHOW_LOCATION;
							message.obj = locationStr;
							
							// 18.发送16message数据.
							handler.sendMessage(message);
						}
						
						
					} else { // 8.若状态码不为200则表示不成功,则提示用户开启VPN或者在一个宽阔的地方四处走走.
						
						String str = "请开启VPN程序,或者在一个宽阔的地方四处走走";
						
						Message message = new Message();
						
						message.what=SHOW_LOCATION;
						message.obj = str;
						
						handler.sendMessage(message);
					}
					
					
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
			}
			
		}).start();
		
	}
	
	private Handler handler = new Handler(){
		
		public void handleMessage(Message msg) {
			
			switch (msg.what) {
				case SHOW_LOCATION:
					 positionTextView.setText((String)msg.obj);
 					 break;
			}
			
		};
		
	};
	
}