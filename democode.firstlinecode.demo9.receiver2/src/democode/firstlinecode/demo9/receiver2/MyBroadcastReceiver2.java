package democode.firstlinecode.demo9.receiver2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 
 * @author Administrator
 *
 */
public class MyBroadcastReceiver2 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context,"MyBroadcastReceiver2自定义广播播放器",Toast.LENGTH_LONG).show();
		
		/*
		 *  如果在 onReceive()方法中调用了 abortBroadcast()方法，就表示将这条广播截断，后面的
			广播接收器将无法再接收到这条广播。现在重新运行程序，并点击一下 Send Broadcast 按钮，
			你会发现，只有 MyBroadcastReceiver 中的 Toast 信息能够弹出，说明这条广播经过
			MyBroadcastReceiver 之后确实是终止传递了。
			
			也就是说如果我们同时在模拟器中开启了democode.firstlinecode.demo9.receiver 以及  democode.firstlinecode.demo9.receiver2
			若我们在运行 democode.firstlinecode.demo9.receiver2这个项目,则后面的democode.firstlinecode.demo9.receiver本来应该也要去发送广播的,
			但是因为调用了这个方法所以就不能够去运行了.
		 * */
		 // abortBroadcast(); 
	}

}