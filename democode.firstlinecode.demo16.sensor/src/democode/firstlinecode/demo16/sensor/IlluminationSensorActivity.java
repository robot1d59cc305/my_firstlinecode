package democode.firstlinecode.demo16.sensor;

import com.example.democode.firstlinecode.demo16.sensor.R;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * IlluminationSensorActivity
 * 简易光照探测器,利用Android光照传感器来实现.
 * 运行一下程序，你将会在手机上看到当前环境下的光照强度，根据所处环境的不同，显示的数值有可能是几十到几百勒克斯。而如果你使用强光来照射手机的话，就有可能会达到上千勒克斯的光照强度.
 * 第一行代码书本pp442页中有光照传感器的用法说明. 
 * @author Administrator
 */
public class IlluminationSensorActivity extends BaseActivity {
	
	/*
	 * 
	 */
	private SensorManager sensormManager;
	
	/*
	 * 
	 */
	private Sensor sensor;
	
	/*
	 * 
	 */
	private SensorEventListener sensorEventListener;
	
	/*
	 * 
	 */
	private TextView textView;
	
	@Override
	protected void onCreate(Bundle bundle) {
		
		super.onCreate(bundle);
		
		super.setContentView(R.layout.illuminationsensor);
		
		textView = (TextView) findViewById(R.id.light_level);
		
		/*
		 * 
		 * */
		sensormManager = (SensorManager) super.getSystemService(Context.SENSOR_SERVICE);
		
		/*
		 * 
		 * */
		sensor = sensormManager.getDefaultSensor(Sensor.TYPE_LIGHT);
		
		/*
		 * 下面我们还需要调用 SensorManager 的 registerListener()方法来注册 SensorEventListener
才能使其生效，registerListener()方法接收三个参数，第一个参数就是 SensorEventListener 的
实例，第二个参数是 Sensor的实例，这两个参数我们在前面都已经成功得到了。第三个参数是
用于表示传感器输出信息的更新速率，共有 SENSOR_DELAY_UI、SENSOR_DELAY_NORMAL、
SENSOR_DELAY_GAME 和 SENSOR_DELAY_FASTEST 这四种值可选，它们的更新速率是
依次递增的。
		 * */
		sensormManager.registerListener(listener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
		
	}
	
	/*
	 * 接下来我们需要对传感器输出的信号进行监听，这就要借助 SensorEventListener 来实现了。
	 * SensorEventListener 是一个接口，其中定义了 onSensorChanged()和 onAccuracyChanged()这两个方法，如下所示：
	 * */
	private SensorEventListener listener = new SensorEventListener(){

		/**
		 * 当传感器的精度发生变化时就会调用 onAccuracyChanged()方法
		 * 可以看到 onSensorChanged()方法中传入了一个 SensorEvent 参数，这个参数里又包含了一个 values 数组，所有传感器输出的信息都是存放在这里的。
		 */
		@Override
		public void onSensorChanged(SensorEvent event) {
			// values数组中第一个下标的值就是当前爱你的光照强度.
			float value = event.values[0];
			
			// 将光照强度输出显示到TextView当中.
			textView.setText("Current light level is " + value + " lx");
		}

		/**
		 * ，当传感器监测到的数值发生变化时就会调用 onSensorChanged()方法。
		 */
		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			
		}
		
	};
	
	@Override
	protected void onDestroy() {
		
		super.onDestroy();
		
		// 在销毁Activity的时候也顺便把sensormManager进行注销.
		if (sensormManager != null) {
			sensormManager.unregisterListener(listener);
		}
		
	}
	
}