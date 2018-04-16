package democode.firstlinecode.demo15.location;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;
import com.example.democode.firstlinecode.demo15.location.R;

import android.app.Activity;
import android.os.Bundle;

/**
 * 百度地图使用.
 * 第一行代码 书本上p422-p432书籍内容讲的百度地图的版本已经非常的旧,已经跟不上现在的百度地图版本SDK的API. 所以这里是使用的最新的百度地图的
 * http://lbsyun.baidu.com/index.php?title=androidsdk/guide/create-project/hellomap 这篇文章学习百度地图的使用,但是也只是初步的将百度地图的框架搭建好.
 * 不过地图格中的数据并没有显示出来.
 * @author Administrator
 */
public class BaiDuMapActivity extends Activity {
	
	private MapView mMapView = null;  
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//在使用SDK各组件之前初始化context信息，传入ApplicationContext  
        //注意该方法要再setContentView方法之前实现  
        SDKInitializer.initialize(getApplicationContext());  
        setContentView(R.layout.baidu_map);  
        
        //获取地图控件引用  
        mMapView = (MapView) findViewById(R.id.bmapView);  
	}
	
	@Override  
    protected void onDestroy() {  
        super.onDestroy();  
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理  
        mMapView.onDestroy();  
    }
	
    @Override  
    protected void onResume() {  
        super.onResume();  
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理  
        mMapView.onResume();  
    }  
    
    @Override  
    protected void onPause() {  
        super.onPause();  
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理  
        mMapView.onPause();  
    }  
	
}