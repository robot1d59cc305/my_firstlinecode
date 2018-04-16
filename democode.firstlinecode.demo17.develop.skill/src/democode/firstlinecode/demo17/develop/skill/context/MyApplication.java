package democode.firstlinecode.demo17.develop.skill.context;

import android.app.Application;
import android.content.Context;

/**
 * MyApplication
 * Android 提供了一个 Application 类，每当应用程序启动的时候，系统就会自动将这个类进行初始化。
       而我们可以定制一个自己的 Application 类，以便于管理程序内一些全局的状态信息，比如说全局 Context。
 * @author Administrator
 *
 */
public class MyApplication extends Application {

	private static Context context;
	
	@Override
	public void onCreate() {
		super.onCreate();
		context = super.getApplicationContext();
	}
	
	public static Context getContext() {
		return context;
	}
	
}