package democode.firstlinecode.demo8.xinwenyingyong.fragment;

import com.example.democode.firstlinecode.demo8.xinwenyingyong.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 新闻内容碎片
 * @author Administrator
 *
 */
public class NewsContentFragment extends Fragment {
	
	private View view;
	
	/**
	 * 
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		// 获取资源文件   
		view = inflater.from(getActivity()).inflate(R.layout.news_content, container);
		
		// 返回资源文件
		return view;
	}
	
	/**
	 * 不管是NewsContentActivity方法也好还是NewsTitleFragment,最终都是通过调用这个方法.
	 */
	public void refresh(String title,String content) {
		
		LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.news_content_linearlayout);
		linearLayout.setVisibility(LinearLayout.VISIBLE);
		
		TextView newsTitle   = (TextView) view.findViewById(R.id.news_content_title);
		TextView newsContent = (TextView) view.findViewById(R.id.news_content_content);
		
		newsTitle.setText(title);
		newsContent.setText(content);
	}
	
}