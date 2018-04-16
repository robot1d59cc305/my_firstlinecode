package democode.firstlinecode.demo17.develop.skill.context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.widget.Toast;

/**
 * 网络编程,针对服务器发出的一个请求做出的方法封装,以后只需要调用一次就可以获取相应的文件.
 * 并且提供版本超过两个,能够解决当网络编程请求较多,返回的时长较慢的情况.
 * @author Administrator
 */
public class HttpUtil {

	/**
	 * 版本一 1. 这样的方法,以后在调用的时候,每发送一次HTTP请求的时候就可以这样写: String address =
	 * "http://www.baidu.com"; String response = HttpUtil.sendHttpRequest(address);
	 * 
	 * 2. 在获取到服务器响应的数据后我们就可以对它进行解析和处理了。 但是需要注意，网络请求通常都是属于耗时操作， 而
	 * sendHttpRequest()方法的内部并没有开启线程， 这样就有可能导致在调用
	 * sendHttpRequest()方法的时候使得主线程被阻塞住。(因为耗时,又要执行前面和后面的代码)
	 * 
	 * 3. 那么遇到这种情况应该怎么办呢？其实解决方法并不难，只需要使用 Java 的回调机制 就可以了，下面就让我们来学习一下回调机制到底是如何使用的。
	 * 
	 * @param address
	 * @return
	 */
	public static String sendHttpRequest(String address) {
		HttpURLConnection connection = null;

		try {

			URL url = new URL(address);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(8000);
			connection.setReadTimeout(8000);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			StringBuilder response = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null) {
				response.append(line);
			}

			return response.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}

	}

	/**
	 * 版本二 1.首先给 sendHttpRequest()方法添加了一个 HttpCallbackListener 参数.
	 * 另外需要注意的是，onFinish()方法和 onError()方法最终还是在子线程中运行的，因此我们不可以在这里执行任何的 UI 操作，如果需要根据返回的结果来更新 UI，则仍然要使用异步消息处理机制。
	 * @param address
	 * @param listener
	 */
	public static void sendHttpRequest(final Context context,final String address, final HttpCallbackListener listener) {
		
		/*
		 * 1.为了去尝试全局获取Context的用法,拿这里的代码做了一个demo.就是在执行这个方法里面的代码时,判断当前的网络是否是正常的,如果没有网络则使用Toast提示用户没有网络.
		 * */
//		if (!isNetworkAvailable()) {
//			Toast.makeText(context,"当前设备没有连接网络,请先连接网络!",Toast.LENGTH_LONG).show();
//		}
		
		// 使用MyApplication.getContext()的方式来获取Context类的对象.
		if (!isNetworkAvailable()) {
			Toast.makeText(MyApplication.getContext(),"当前设备没有连接网络,请先连接网络!",Toast.LENGTH_LONG).show();
		}
		
		// 2.并在方法的内部开启了一个子线程,然后在子线程里去执行具体的网络操作。
		new Thread(new Runnable() {
			@Override
			public void run() {
				HttpURLConnection connection = null;
				try {
					URL url = new URL(address);
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					connection.setDoInput(true);
					connection.setDoOutput(true);
					InputStream in = connection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));
					StringBuilder response = new StringBuilder();
					String line;
					while ((line = reader.readLine()) != null) {
						response.append(line);
					}

					/*
					 * 3.注意子线程中是无法通过return 语句来返回数据的，因此这里我们将服务器响应的数据传入了 HttpCallbackListener
					 * 的onFinish()方法中，如果出现了异常就将异常原因传入到 onError()方法中。
					 */
						
					
					if (listener != null) {
						// 回调onFinish()方法
						
						/*
						 * 3.1 这样的话，当服务器成功响应的时候我们就可以在 onFinish()方法里对响应数据进行处理了
						 * */
						listener.onFinish(response.toString());
					}
					
				} catch (Exception e) {
					if (listener != null) {
						// 回调onError()方法
						/*
						 *  3.2 类似地，如果出现了异常，就可以在 onError()方法里对异常情况进行处理。如此一来，我们就巧妙地利用回调机制将响应数据成功返回给调用方了
						 * */
						listener.onError(e);
					}
				} finally {
					if (connection != null) {
						connection.disconnect();
					}
				}
			}
		}).start();
	}
	
	/**
	 * 判断网络是否存在.
	 * @return
	 */
	public static boolean isNetworkAvailable() {
		
		return false;
	} 
	
}