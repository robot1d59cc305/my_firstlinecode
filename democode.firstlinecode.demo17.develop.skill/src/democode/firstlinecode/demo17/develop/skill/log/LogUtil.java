package democode.firstlinecode.demo17.develop.skill.log;

import android.util.Log;

public class LogUtil {

	/*
	 * 可以看到，我们在 LogUtil 中先是定义了 VERBOSE、DEBUG、INFO、WARN、ERROR、NOTHING
	 * 这六个整型常量，并且它们对应的值都是递增的。然后又定义了一个 LEVEL 常量，可以将它的值指定为上面六个常量中的任意一个。
	 */
	public static final int VERBOSE = 1;
	public static final int DEBUG = 2;
	public static final int INFO = 3;
	public static final int WARN = 4;
	public static final int ERROR = 5;
	public static final int NOTHING = 6; // 这个级别是其它的日志警告级别所打印不出来的.
	public static final int LEVEL = VERBOSE; // 这个级别是用来进行比较的,以这个级别为准.默认是所有的日志都可以打印,如果说到了上线的时候不需要某些级别的日志,则可以单独的对这个属性进行设置.如果全部迪欧不需要显示则将这个设置为NOTHING即可.

	/**
	 * 
	 * @param tag
	 * @param msg
	 */
	public static void v(String tag, String msg) {
		if (LEVEL <= VERBOSE) {
			Log.v(tag, msg);
		}
	}

	public static void d(String tag, String msg) {
		if (LEVEL <= DEBUG) {
			Log.d(tag, msg);
		}
	}

	public static void i(String tag, String msg) {
		if (LEVEL <= INFO) {
			Log.i(tag, msg);
		}
	}

	public static void w(String tag, String msg) {
		if (LEVEL <= WARN) {
			Log.w(tag, msg);
		}
	}

	public static void e(String tag, String msg) {
		if (LEVEL <= ERROR) {
			Log.e(tag, msg);
		}
	}
	
}