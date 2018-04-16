package democode.firstlinecode.demo9.receiver.sendzidingyiguangbo_biaozhun;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 发送自定义广播,这个类是用来接受自定义广播的.
 * @author Administrator
 *
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context,"我们收到了自定义发送的广播",Toast.LENGTH_LONG).show();
	}

}