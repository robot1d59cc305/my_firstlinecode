package democode.firstlinecode.demo9.receiver.boot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/*
 * 静态注册接受系统广播,实现开机自启.
 */
public class BootReceive extends BroadcastReceiver {
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context,"开机自启",Toast.LENGTH_LONG).show();
	}
	
}	