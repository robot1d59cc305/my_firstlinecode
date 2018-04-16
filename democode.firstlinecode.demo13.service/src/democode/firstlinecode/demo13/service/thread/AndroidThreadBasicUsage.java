package democode.firstlinecode.demo13.service.thread;

/**
 * 
 * Android 多线程的基本用法.
 * 1.继承式.
 * 2.匿名内部类.
 * 3.接口式.
 * 
 * @author Administrator
 *
 */
public class AndroidThreadBasicUsage extends Thread { // 继承式用法使用Thread功能.

	public static void main(String[] args) {
		
		// 继承式使用多线程
		new AndroidThreadBasicUsage().start();
		
		// 匿名内部类使用多线程
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
			}
			
		}).start();
		
	}

	@Override
	public void run() {
		super.run();
		// 处理具体的问题
	}

}

/**
 * Android 多线程的接口式用法使用Thread功能.
 * 
 * @author Administrator
 *
 */
class MyThread implements Runnable {

	public static void main(String[] args) {
		// 接口式使用多线程
		MyThread myThread = new MyThread();
		new Thread(myThread).start();
	}

	@Override
	public void run() {

	}

}