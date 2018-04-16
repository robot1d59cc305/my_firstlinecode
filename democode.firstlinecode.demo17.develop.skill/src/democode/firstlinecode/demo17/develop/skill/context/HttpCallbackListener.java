package democode.firstlinecode.demo17.develop.skill.context;

/**
 * HttpCallbackListener
 * 为了解决在调用HttpUtil中的sendHttpRequest方法因为这个方法是属于网络请求,没有开启线程进行执行,所以如果说网路请求的速度比较慢,则可能会影响主线程,从而导致主线程柱塞.
 * 在HttpUtil中的sendHttpRequest方法中调用过.
 * @author Administrator
 *
 */
public interface HttpCallbackListener {
	
	/**
	 * 当服务器成功响应我们请求的时候调用,这两个方法都带有参数,onFinish()方法中的参数代表着服务器返回的数据.
	 * @param response
	 */
	void onFinish(String response);
	
	/**
	 * onError()表示当进行网络操作出现错误的时候调用,而 onError()方法中的参数记录着错误的详细信息.
	 * @param e
	 */
	void onError(Exception e);
	
}
