package democode.firstlinecode.demo14.webview_network;

import com.example.democode.firstlinecode.demo14.webview.R;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * WebViewActivity
 * 1.Web展示Activity,在应用程序当中调用网页.
 * @author Administrator
 *
 */
public class WebViewActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle bundle) {
		// 0.调用父类的onCreate方法
		super.onCreate(bundle);
		
		// 1.设置内容视图.
		setContentView(R.layout.webviewactivity);
		
		// 2.获取activity_main.xml文件中webview控件资源.
		WebView webView = (WebView) super.findViewById(R.id.webviewactivity_webview_1);
		
		// 3.设置网页中的js效果开启.
		webView.getSettings().setJavaScriptEnabled(true);
		
		// 4.设置网页中的内容视图 这里的代码和方法必须要在libs目录下导入android-support-v4.jar这个工具包才能够进行导入.
		webView.setWebViewClient(new WebViewClient(){
			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// 根据传入的参数再去加载新的网页
				view.loadUrl(url);
				// 表示当前WebView可以处理打开新网页的请求，不用借助系统浏览器
				return true;
			}
			
		});
		
		// 5.设置网页的url,打开应用程序便开始加载这个uri地址的WebAPP.
		webView.loadUrl("https://www.baidu.com");
		
	}
	
}