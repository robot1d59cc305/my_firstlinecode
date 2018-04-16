package democode.firstlinecode.demo16.sensor;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * BaseActivity
 * Activity包装类,将需要对所有的Activity做出的操作都封装到这个类里面,然后其余的类继承此类即可.
 * @author Administrator
 *
 */
public class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// 1.加载父类的onCreate方法.(注意并不是这里写了这行代码,就代表其它的Activity可以去不写这行代码.)
		super.onCreate(savedInstanceState);

		// 2.输出继承此类的类名称.
		Log.i("BaseActivity", getClass().getSimpleName());

	}

}