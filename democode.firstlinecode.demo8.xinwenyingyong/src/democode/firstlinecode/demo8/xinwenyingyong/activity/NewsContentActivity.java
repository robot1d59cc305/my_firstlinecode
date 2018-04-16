package democode.firstlinecode.demo8.xinwenyingyong.activity;

import com.example.democode.firstlinecode.demo8.xinwenyingyong.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import democode.firstlinecode.demo8.xinwenyingyong.fragment.NewsContentFragment;
import democode.firstlinecode.demo8.xinwenyingyong.fragment.NewsTitleFragment;

/**
 * 
 * 新闻内容的Activity,只在手机设备(小于600dpi)上运行.
 * @author Administrator
 *
 */
public class NewsContentActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 通过将R.layout.news_content_frag视图文件设置为当前的顶级视图,也算是将Fragment的内容加载了xml节点树里面,那么接下来就可以直接去获取id即可.
		setContentView(R.layout.news_content_frag);
		
		// 获取Intent对象数据 
		Intent intent = getIntent();
		
		// 获取用户点击的选项对应的新闻标题
		String title = intent.getStringExtra("title");
		
		// 获取用户点击的选线对应的新闻内容
		String content = intent.getStringExtra("content");
		
		// 因为之前加载过这个R.id.news_content_frag的文件R.layout.news_content_frag,所以这里直接获取它的Fragment的实例.
		NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_frag);
		
		// 通过NewsContentFragment将数据传入刷新页面!
		newsContentFragment.refresh(title, content);
	}
	
	/**
	 * 通过这个方法,从其它的Activity调用到这个Activity里面来.
	 * 只需要给如一个Intent和其它与业务相关的参数就可以.
	 */
	public static void statusAction(Context context,String title,String content) {
		// 构建好一个Intent对象 
		Intent intentActivity = new Intent(context,NewsContentActivity.class);
		intentActivity.putExtra("title",title);
		intentActivity.putExtra("content", content);
		context.startActivity(intentActivity);
	}
	
}