package democode.firstlinecode.demo12.multimedia.sms;

import com.example.democode.firstlinecode.demo12.notifications.R;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 短信Activity. 
 * 1.接受短信 : 通过接受关于短信的广播,然后将接受到的内容显示在我们的View视图中.主要难点在如何解析短信的信息.并能够将解析到的短信数据赋值显示在我们的视图上. 同时接受短信也需要注册相应的权限.
 * 2.拦截短息 : 这里想要的是我们自己的短信程序写好之后,不再让系统的短信程序再次提醒一遍,因此本质上还是利用广播技术里面提供的API工作,先将接受广播信息的时候将我们自身的优先级提高.然后在广播接收器类中做完业务操作之后就截断后面的广播,使其不能够再去接受广播.
 * 3.发送信息 : 动态注册广播SENT_SMS_ACTION ,然后再获取相应的View视图资源将用户输入的短信号码和短信内容数据收集.再通过SmsManager类的sendTextMessage方法将数据发送出去.同时发送短信也需要注册相应的权限.
 * 
 * 这个功能已经很类似于平常应用上看见的"获取验证码"功能.
 * @author Administrator
 *
 */
public class SmSActivity extends Activity {

	/*
	 * 因为接下来很多的事情都要在广播接收器类里面去做,所以说通过onCreate使用findViewById方法将资源获取.
	 * 然后为这些成员属性赋值引用,这样在接下来的广播接收器类里面可以直接调用这些成员属性进行业务操作.
	 */

	/**
	 * 短信号码
	 */
	private TextView sender;

	/**
	 * 短信内容
	 */
	private TextView content;

	/**
	 * 广播接收器类:主要处理接受短信信息功能.
	 */
	private MessageReceiver messageReceiver;

	/**
	 * 广播接收器类:主要处理判断短信是否接受成功功能.
	 */
	private SendStatusReceiver sendStatusReceiver;

	/**
	 * 动态注册广播
	 */
	private IntentFilter intentFilter;

	/**
	 * 短信发送功能
	 */
	private Button send;

	/**
	 * 短信号码
	 */
	private EditText to;

	/**
	 * 短信内容
	 */
	private EditText msgInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms);

		// 接受信息(1,2,3,4,5)

		// 拦截短信(6)

			// 1.获取到相应的View资源.
			sender = (TextView) findViewById(R.id.sms_textview_number);
			content = (TextView) findViewById(R.id.sms_textview_content);
	
			// 2.实例化IntentFilter对象.
			intentFilter = new IntentFilter();
	
			// 3.向IntentFilter中增加一道有关与接受短信广播的Action.
			intentFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
	
			// 6.设置广播的优先级优先于系统自带的短信程序接受到这个广播,比系统短信程序提前能够接收到这个程序.
			intentFilter.setPriority(100);
	
			// 4.实例化广播接收器类.
			messageReceiver = new MessageReceiver();
	
			// 5.通过ContextWrapper类中的registerReceiver方法将3,4作为实参传递,执行注册动态广播方法.
			registerReceiver(messageReceiver, intentFilter);

		// 发送短信

			// 1.动态注册广播.
			intentFilter.addAction("SENT_SMS_ACTION");
	
			// 2.实例化广播接收器类.
			sendStatusReceiver = new SendStatusReceiver();
	
			// 3.注册.
			registerReceiver(sendStatusReceiver, intentFilter);
	
			// 4.将相关资源实例化
			to = (EditText) findViewById(R.id.sms_edittext_number);
	
			msgInput = (EditText) findViewById(R.id.sms_edittext_content);
	
			send = (Button) findViewById(R.id.sms_button_send);
	
			// 5.给发送按钮添加响应事件
			send.setOnClickListener(new OnClickListener() {
	
				@Override
				public void onClick(View v) {
	
					// 4.1 获取SmsManager类
					SmsManager smsManager = SmsManager.getDefault();
	
					// 4.2 编写Intent SEND_SMS_ACTION
					Intent intent = new Intent();
	
					// 4.3 获取PendingIntent类的实例
					PendingIntent pi = PendingIntent.getBroadcast(SmSActivity.this, 0, intent, 0);
	
					// 4.4
					// 通过4.1调用sendTextMessage()方法(如果发送的字符超过160字则需要调用sendMultipart-TextMessage()方法就可以实现).
					smsManager.sendTextMessage(to.getText().toString(), null, msgInput.getText().toString(), pi, null);
	
				}
	
			});

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// 调用ContextWrapper类中的unregisterReceiver方法.卸载广播,当此Activity调用这个onDestory()方法的时候卸载掉当前的广播接收器类.
		unregisterReceiver(messageReceiver);

		// 调用ContextWrapper类中的unregisterReceiver方法.卸载广播,当此Activity调用这个onDestory()方法的时候卸载掉当前的广播接收器类.
		unregisterReceiver(sendStatusReceiver);
	}

	/**
	 * 
	 * 广播接收器类,主要接受系统应用-短信的广播,并对接收到的广播的数据赋值到layout文件夹下sms.xml文件里面的几个TextView节点当中.
	 * 
	 * @author Administrator
	 *
	 */
	public class MessageReceiver extends BroadcastReceiver {

		/**
		 * 广播接收器类的方法
		 */
		@Override
		public void onReceive(Context context, Intent intent) {
			// 1.通过intent获取到Bundle对象的信息
			Bundle bundle = intent.getExtras();
			
			// 2.在步骤1当中获取一个名为pdus的信息,并且转换为Object[]类型进行接受.
			Object[] pdus = (Object[]) bundle.get("pdus");
			
			// 3.使用的时候记得import这个包下的 android.telephony.SmsMessage 将pdus的长度放到这里来.
			SmsMessage[] messages = new SmsMessage[pdus.length];
			
			// 4.循环的将通过SmsMessage中的createFromPdu将2中获取到的数组放入到这里面让3中的SmsMessage类型数组进行接受.
			for (int i = 0;i < messages.length;i++) {
				// 将messages加入到messages数组里面.
				messages[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
			}
			
			// 5.从4中获取到数组开头索引里面的电话号码信息.
			String address = messages[0].getOriginatingAddress();
			
			// 6.准备一个字符串用于接受短信的内容.
			String fullMessage = "";
			
			// 7.从4中调用getMessageBody()方法循环便利数组中每一个元素中的短信内容,将短信内容拼接而成.
			for (SmsMessage message:messages) {
				// 7.1 拼接短信内容信息.
				fullMessage += message.getMessageBody();
			}
			
			// 8.将5中的短信号码放置到sender成员属性当中
			sender.setText(address);
			
			// 9.将7中的短信内容放置到content成员属性当中.
			content.setText(fullMessage);

			// 调用这个方法,截断广播.也就是我们当前的广播接受到完成了业务操作之后就将后面的广播截断.不让后面想要接受
			// android.provider.Telephony.SMS_RECEIVED 这条广播的程序去接受广播. 从而实现拦截短信功能.
			abortBroadcast();
		}

	}

	/**
	 * 广播接收器类,主要处理短信是否发送成功.
	 * 
	 * @author Administrator
	 *
	 */
	public class SendStatusReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {

			// 短信发送成功
			if (getResultCode() == RESULT_OK) {
				Toast.makeText(context, "Send succeeded", Toast.LENGTH_LONG).show();
			} else { // 短信发送失败
				Toast.makeText(context, "Send failed", Toast.LENGTH_LONG).show();
			}

		}

	}

}