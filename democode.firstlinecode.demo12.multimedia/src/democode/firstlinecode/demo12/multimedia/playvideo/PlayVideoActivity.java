package democode.firstlinecode.demo12.multimedia.playvideo;

import java.io.File;

import com.example.democode.firstlinecode.demo12.notifications.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.VideoView;

/**
 * 播放视屏Activity
 * 1.播放视屏.
 * 2.暂停视屏.
 * 3.停止视屏.
 * 4.运行的时候因为一些条件没有办法在sd卡放置相应需要读取的文件,所以说整体应用是没有成功的.
 * @author Administrator
 *
 */
public class PlayVideoActivity extends Activity implements OnClickListener {
	
	/**
	 * 播放视屏按钮
	 */
	private Button play;

	/**
	 * 暂停视屏按钮
	 */
	private Button pause;

	/**
	 * 停止视屏按钮
	 */
	private Button stop;
	
	/**
	 * 操作视屏类
	 */
	private VideoView videoView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 1.设置内容视图.
		super.setContentView(R.layout.playvideo);

		// 2.查找获取视图ID.
		play =      (Button) findViewById(R.id.playvideo_play);
		pause =     (Button) findViewById(R.id.playvideo_pause);
		stop =      (Button) findViewById(R.id.playvideo_replay);
		videoView = (VideoView) findViewById(R.id.playvideo_video_view);

		// 3.设置按钮响应函数
		play.setOnClickListener(this);
		pause.setOnClickListener(this);
		stop.setOnClickListener(this);

		// 4.初始化MediaPlayer(指定需要播放的视屏文件,以及让VideoView进入到准备状态)
		initVideoView();
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		// 如果videoView已经被实例化,则关闭.
		if (videoView != null) {
			videoView.suspend();
		}
		
	}
	
	/**
	 * 初始化VideoView类的一些设置
	 */
	public void initVideoView() {
		File file = new File(Environment.getExternalStorageDirectory(),"movie.mp4");
		videoView.setVideoPath(file.getPath());
	}

	/**
	 * 为按钮添加业务
	 */
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.playvideo_play:
				 if (!videoView.isPlaying()) {
					 videoView.start();
				 }
				 break;
				 
			case R.id.playvideo_pause:
				 if (videoView.isPlaying()) {
					 videoView.pause();
				 }
				 break;
				 
			case R.id.playvideo_replay:
				 if (videoView.isPlaying()) {
					 videoView.resume();
				 }
				 break;
		}
	}
	
}