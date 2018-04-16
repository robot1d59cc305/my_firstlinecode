package democode.firstlinecode.demo12.multimedia.play_audio;

import java.io.File;

import com.example.democode.firstlinecode.demo12.notifications.R;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * PlayAudioActivity:
 * 1.播放音频.
 * 2.暂停音频.
 * 3.停止音频.
 * 4.运行的时候因为一些条件没有办法在sd卡放置相应需要读取的文件,所以说整体应用是没有成功的.
 * @author Administrator
 *
 */
public class PlayAudioActivity extends Activity implements OnClickListener {

	/**
	 * 播放音频按钮
	 */
	private Button play;

	/**
	 * 暂停音频按钮
	 */
	private Button pause;

	/**
	 * 停止音频按钮
	 */
	private Button stop;

	/**
	 * 音频功能操作类
	 */
	private MediaPlayer mediaPlayer = new MediaPlayer();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 1.设置内容视图.
		super.setContentView(R.layout.playaudio);

		// 2.查找获取视图ID.
		play = (Button) findViewById(R.id.playaudio_play);
		pause = (Button) findViewById(R.id.playaudio_pause);
		stop = (Button) findViewById(R.id.playaudio_stop);

		// 3.设置按钮响应函数
		play.setOnClickListener(this);
		pause.setOnClickListener(this);
		stop.setOnClickListener(this);

		// 4.初始化MediaPlayer(指定需要播放的音频文件,以及让MediaPlayer进入到准备状态)
		initMediaPlayer();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		// 在Activity销毁的时候若mediaPlayer已经存在则停止则释放.
		if (mediaPlayer != null) {
			mediaPlayer.stop();
			mediaPlayer.release();
		}
	}
	
	/**
	 * 初始化MediaPlayer.
	 */
	public void initMediaPlayer() {

		// 1.指定文件的路径,并且以File类进行包装,存放路径在SD卡中.
		File file = new File(Environment.getExternalStorageDirectory(), "music.mp3");

		try {
			// 2.设置音频文件的路径,通过1中的getPath()返回的数据做为实参.
			mediaPlayer.setDataSource(file.getPath());

			// 3.让mediaPlayer类就绪.
			mediaPlayer.prepare();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 为按钮添加响应事件
	 */
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.playaudio_play:
				
				 /* 1.如果当前的状态是没有播放,则用户点击播放音乐按钮可以成功. 
				  * 2.用户需要按按钮的场景有:第一次打开APP应用程序,用户需要通过这个按钮来播放音乐.
				  * 3.用户第一次通过play按钮播放音乐,然后点击了pause按钮,或stop按钮.再次的想点击play按钮播放音乐.
				  * 4.如果此时用户已经在播放音乐,然后又点击了一次play按钮,就会导致听音频听到一半又开始从头开始进行播放.
				  * 5.于是在这里就添加一个限制,只有在音乐没有播放的时候才会播放音乐.
				  * */
				 if (!mediaPlayer.isPlaying()) {
					 mediaPlayer.start();
				 }
				 
				 break;
				 
			case R.id.playaudio_pause:
				 
				 // 如果当前的状态是在播放音乐,则才可以暂停播放. 
				 if (mediaPlayer.isPlaying()) {
					 mediaPlayer.pause();
				 }
				 
				 break;
				 
			case R.id.playaudio_stop:
				 
				 // 如果当前的状态是在播放音乐,则才可以停止.
				 if (mediaPlayer.isPlaying()) {
					 // 首先进行暂停
					 mediaPlayer.reset();
					 
					 // 为了未来的应用场景能够扩展,因为很有可能用户之所以停止是因为,将音乐的路径改变了,那么现在就需要停止播放,然后重新将配置加载一遍变成下一首歌.
					 // 或者说通过这种方式,也可以将当前播放的位置改变,重置为0.就变成了再听一遍.
					 initMediaPlayer();
				 }
				
				 break;
				 
			default :
				 break;
		}
	}

}