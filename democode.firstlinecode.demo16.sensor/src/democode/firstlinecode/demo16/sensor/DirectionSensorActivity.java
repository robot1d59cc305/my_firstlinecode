package democode.firstlinecode.demo16.sensor;

import com.example.democode.firstlinecode.demo16.sensor.R;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/**
 * DirectionSensor
 * 使用方向传感器,制作简易指南针.
 * @author Administrator
 *
 */
public class DirectionSensorActivity extends Activity {
	
	/*
	 * 传感器管理类.
	 */
	private SensorManager sensorManager;

	/*
	 * 图片展示.
	 */
	private ImageView compassImg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// 1.加载父类onCreate方法.
		super.onCreate(savedInstanceState);
		
		// 2.设置视图View.
		setContentView(R.layout.directionsensor);
		
		// 3.寻找视图ID资源获取到ImageView类的实例.
		compassImg = (ImageView) findViewById(R.id.compass_img);
		
		// 4.通过父类的getSystemService方法,给入Context.SENSOR_SERVICE参数来获取到SensorManager类的实例.
		sensorManager = (SensorManager) super.getSystemService(Context.SENSOR_SERVICE);
		
		// 5.通过4中的SensorManager里的getDefaultSensor方法,传递需要获取的传感器的参数,来获取到对应的传感器的实例.这里获取的是加速传感器.
		Sensor magneticSensor = sensorManager
				.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
		
		// 6.通过4中的SensorManager里的getDefaultSensor方法,传递需要获取的传感器的参数,来获取到对应的传感器的实例.这里获取的是地磁传感器.
		Sensor accelerometerSensor = sensorManager
				.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
		
		// 7.通过4中的SensorManager里的registerListener方法,对5传感器进行注册.
		sensorManager.registerListener(listener, magneticSensor,
				SensorManager.SENSOR_DELAY_GAME);
		
		// 8.通过4中的SensorManager里的registerListener方法,对6传感器进行注册.
		sensorManager.registerListener(listener, accelerometerSensor,
				SensorManager.SENSOR_DELAY_GAME);
		
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		// 判断sensorManager是否不为空
		if (sensorManager != null) {
			// 如果不为空则调用unregisterListener方法来卸载listener对象.
			sensorManager.unregisterListener(listener);
		}
	}

	/*
	 * 传感器事件监听,通过这个监听接口来对传感器进行编程.
	 */
	private SensorEventListener listener = new SensorEventListener() {

		/*
		 * 
		 */
		float[] accelerometerValues = new float[3];

		/*
		 * 
		 */
		float[] magneticValues = new float[3];

		/*
		 * 
		 */
		private float lastRotateDegree;

		@Override
		public void onSensorChanged(SensorEvent event) {
			
			// 判断当前是加速度传感器还是地磁传感器
			if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
				// 注意赋值时要调用clone()方法
				accelerometerValues = event.values.clone();
			} else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
				// 注意赋值时要调用clone()方法
				magneticValues = event.values.clone();
			}
			
			// 建立一个长度为3的数组.
			float[] values = new float[3];
			
			// 建立一个长度为9的数组.
			float[] R = new float[9];
			
			// 
			SensorManager.getRotationMatrix(R, null, accelerometerValues,
					magneticValues);
			
			// 
			SensorManager.getOrientation(R, values);
			
			// 将计算出来的旋转角度取反,用于旋转指南针背景图.
			float rotateDegree = -(float) Math.toDegrees(values[0]);
			
			if (Math.abs(rotateDegree - lastRotateDegree) > 1) {
				
				// 使用这个类来对图片需要转的角度进行特定的设置. 第一个参数表示旋转的角度,第二个参数表示旋转的终止角度,后面四个参数用于指定旋转的中心点.
				RotateAnimation animation = new RotateAnimation(
						lastRotateDegree, rotateDegree,
						Animation.RELATIVE_TO_SELF, 0.5f,
						Animation.RELATIVE_TO_SELF, 0.5f);
				
				// 指定旋转的中心点为指南针背景图的中心.
				animation.setFillAfter(true);
				
				// 调用ImageView的startAnimation方法来执行旋转动画.
				compassImg.startAnimation(animation);
				
				// 
				lastRotateDegree = rotateDegree;
				
			}
			
		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			
		}

	};
	
}