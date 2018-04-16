package democode.firstlinecode.demo12.notifications.main;

import com.example.democode.firstlinecode.demo12.notifications.R;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import democode.firstlinecode.demo12.multimedia.choosepic.ChoosePicActivity;
import democode.firstlinecode.demo12.multimedia.notification.MainActivity;
import democode.firstlinecode.demo12.multimedia.play_audio.PlayAudioActivity;
import democode.firstlinecode.demo12.multimedia.playvideo.PlayVideoActivity;
import democode.firstlinecode.demo12.multimedia.sms.SmSActivity;

/**
 * 主界面Activity
 * 1.界面中的"通知"按钮.
 * 2.界面中的"短信"按钮.
 * 3.界面中的"调用摄像头和相册"按钮.
 * 4.界面中的"音频播放器"按钮.
 * 5.界面中的"视频播放器"按钮.
 * @author Administrator
 *
 */
public class JieMianActivity extends Activity {
	
	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jiemian);
	};
	
	/**
	 * 1.界面中的"通知"按钮.
	 * @param view
	 */
	public void jiemian_button1(View view) {
		Intent intent = new Intent(this,MainActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 2.界面中的"短信"按钮.
	 * @param view
	 */
	public void jiemian_button2(View view) {
		Intent intent = new Intent(this,SmSActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 3.界面中的"调用摄像头和相册"按钮.
	 * @param view
	 */
	public void jiemian_button3(View view) {
		Intent intent = new Intent(this,ChoosePicActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 4.界面中的"音频播放器"按钮.
	 * @param view
	 */
	public void jiemian_button4(View view) {
		Intent intent = new Intent(this,PlayAudioActivity.class);
		startActivity(intent);
	}
	
	/**
	 * 5.界面中的"视频播放器"按钮.
	 * @param view
	 */
	public void jiemian_button5(View view) {
		Intent intent = new Intent(this,PlayVideoActivity.class);
		startActivity(intent);
	}
	
}