package democode.firstlinecode.demo9.receiver3_qiangzhixiaxian.receiver;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;
import democode.firstlinecode.demo9.receiver3_qiangzhixiaxian.MainActivity;
import my.androiddeveloper.tools.ActivityCollector;

/**
 * 如果说将BroadcastReceiver类写在了ProductAcitvity里面,则发出的广播只能够使用动态注册.
 * @author Administrator
 *
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, Intent intent) {

		// 这里在填入应该要放在哪个Activity上去显示这个对话框时可以选择onReceive方法中的使用context参数即可.
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
		
		alertDialog.setTitle("退出");
		
		alertDialog.setMessage("确认是否强制退出所有程序?");
		
		alertDialog.setCancelable(false);
		
		alertDialog.setPositiveButton("确定",new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				ActivityCollector.finishAll();
				// 这里进行跳转的时候原本应该要去写一个Activit的this,但是因为这里是在Receiver当中因此使用的是context,但是在使用context的时候要注意给context加上一个final.
				Intent intent = new Intent(context,MainActivity.class);
				
				/* 给这个intent跳转跳转到的intent加上一个类型,是建立在一个新的任务栈当中.
				 * 这里为什么要加上这个?是因为在上一行代码当中实际上是将所有的原来的任务栈中的Activity清除了,
				 * 那么现在为了不受原本的影响,所以每次跳过去的时候都是建立一个新的任务栈让这个Activity生存于这个新的任务栈当中.
				 * 避免,用户因为关不掉这个对话框,采取一些特殊措施,比如在应用管理界面将应用程序清除这样的方式,但实际上由于申明了这个权限之后基本上是清除不掉的.
				 * 但是可能也有一些用户会在点击了对话框当中的"确定"按钮之前,就已经按下home键,那么此时这个对话框还是会在整个手机屏幕视图的最顶端.只不过应用程序并没有出现在整个任务栈的最顶端.
				 * 因此重新创建一个,将这个Activity的声明周期单独放到一个任务栈当中.不管怎么样都能够在用户按下确认按钮之后将整个视图显示出来.
				 * */
				
				intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);
				
				// 然后使用context中的startActivity将这个intent执行.
				context.startActivity(intent);
			}
			
		});
		
		AlertDialog alertDialog2 = alertDialog.create();
		alertDialog2.getWindow().setType(
				WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		alertDialog2.show();
	}

}