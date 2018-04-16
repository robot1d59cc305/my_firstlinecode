package democode.firstlinecode.demo13.service.dingshirenwu;

import com.example.democode.firstlinecode.demo13.service.dingshirenwu.R;
import android.app.Activity;
import android.os.Bundle;

/**
 * 
 * 程序启动界面,无操作.
 * 实际上真正在调用程序的是AlarmReceiver这个广播类,每次自动调用这个广播跳转到LongRunningService服务,根据设定的时间又切回来AlarmReceiver里面,这样就可以形成一个永久的循环.
 * @author Administrator
 *
 */
public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
	}
	
}