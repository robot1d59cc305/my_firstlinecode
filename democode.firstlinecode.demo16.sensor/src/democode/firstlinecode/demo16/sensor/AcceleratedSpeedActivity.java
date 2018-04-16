package democode.firstlinecode.demo16.sensor;

import com.example.democode.firstlinecode.demo16.sensor.R;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

/**
 * AcceleratedSpeedActivity
 * 加速度传感器,使用加速度传感器制作微信摇一摇功能.
 * @author Administrator
 *
 */
public class AcceleratedSpeedActivity extends Activity {
	
	private SensorManager sensorManager;
	
	private Sensor sensor;
	
	/**
	 *  模仿一下微信的摇一摇功能。其实主体逻辑也非常
		简单，只需要检测手机在 X 轴、Y 轴和 Z 轴上的加速度，当达到了预定值的时候就可以认为
		用户摇动了手机，从而触发摇一摇的逻辑。那么现在问题在于，这个预定值应该设定为多少
		呢？由于重力加速度的存在，即使手机在静止的情况下，某一个轴上的加速度也有可能达到
		9.8m/s2，因此这个预定值必定是要大于 9.8m/s2的，这里我们就设定为 15m/s2吧。
	 */
	private SensorEventListener srnsorEventListener = new SensorEventListener() {

		@Override
		public void onSensorChanged(SensorEvent event) {
			
			/*
			 * 我们在 onSensorChanged()方法中分别获取到了 X轴、Y 轴和 Z 轴方向上的加速度值，并且由于加速度有可能是负值，所以这里又对获取到的数据进行了绝对值处理。
			 * 接下来进行了一个简单的判断，如果手机在 X 轴或 Y 轴或 Z 轴方向上的加速度值大于 15m/s2，就认为用户摇动了手机，从而触发摇一摇的逻辑。
			 * 当然，这里简单起见，我们只是弹出了一个 Toast 而已。
			 * */
			
			// 1.存储event中的values数组前三个值就是 加速度感应器的 x,y,z三个值.
			float xValue = Math.abs(event.values[0]);
			float yValue = Math.abs(event.values[1]);
			float zValue = Math.abs(event.values[2]);
			
			// 2.判断1中只要有任何一个值大于15则表示用户在摇动手机.
			if (xValue > 15 || yValue > 15 || zValue > 15) {
				// 认为用户摇动了手机,触发摇一摇逻辑.
				Toast.makeText(AcceleratedSpeedActivity.this, "摇一摇",Toast.LENGTH_SHORT).show();
			}
			
		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			
		}
		
	};
	
	protected void onCreate(Bundle bundle) {
		
		super.onCreate(bundle);
		
		super.setContentView(R.layout.illuminationsensor);
		
		sensorManager = (SensorManager) super.getSystemService(Context.SENSOR_SERVICE);
		
		sensor = (Sensor) sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		
		sensorManager.registerListener(srnsorEventListener, sensor,SensorManager.SENSOR_DELAY_NORMAL);
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		if (sensorManager != null) {
			sensorManager.unregisterListener(srnsorEventListener);
		}
		
	}
	
}