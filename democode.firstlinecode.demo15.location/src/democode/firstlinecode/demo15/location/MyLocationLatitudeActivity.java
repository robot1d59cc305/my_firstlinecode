package democode.firstlinecode.demo15.location;

import java.util.List;

import com.example.democode.firstlinecode.demo15.location.R;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * MyLocationLatitude
 * 确定用户当前位置,并将当前位置的经纬度显示在视图中的TextView控件中.
 * @author Administrator
 *
 */
public class MyLocationLatitudeActivity extends BaseActivity {
	
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
	private void showLocation(Location location) {
		// 1.准备输出的位置信息字符串.
		String currentPosition = "latitude is" + location.getLatitude()  + "\n" + "longitude is" + location.getLongitude();
		
		// 2.将位置信息写到TextView控件当中.
		positionTextView.setText(currentPosition);
	}
	
}