package democode.firstlinecode.demo8.xinwenyingyong.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.democode.firstlinecode.demo8.xinwenyingyong.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import democode.firstlinecode.demo8.xinwenyingyong.activity.NewsContentActivity;
import democode.firstlinecode.demo8.xinwenyingyong.model.News;
import democode.firstlinecode.demo8.xinwenyingyong.model.NewsListViewAdapter;

/**
 * 
 * 新闻标题碎片
 * @author Administrator
 *
 */
public class NewsTitleFragment extends Fragment implements OnItemClickListener {
	
	/**
	 * 存放所有新闻内容的容器.
	 */
	private List<News> newsList;
	
	/**
	 * ListView控件.
	 */
	private ListView listView;
	
	/**
	 * 这是是一个什么类型的设备如果应用运行在平板上则为true.
	 * 如果应用运行在手机上则为false;
	 */
	private boolean  isPad;
	
	/**
	 * ListView控件的业务逻辑方法.
	 */
	private NewsListViewAdapter newsListViewAdapter;
	
	/**
	 * 组装资源
	 */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		// 获取新闻类数据
		newsList = getList();
		
		// 组装资源构建ListView的适配器
		newsListViewAdapter = new NewsListViewAdapter(getActivity(), R.layout.list_view_item,newsList);
		
	}
	
	/**
	 * 创建视图页面
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		// 加载资源文件
		View view = inflater.inflate(R.layout.list_view,container);
		
		// 通过id获取资源文件中的ListView控件
		listView = (ListView) view.findViewById(R.id.list_view);
		
		// 为ListView控件放置适配器
		listView.setAdapter(newsListViewAdapter);
		
		// 为ListView控件的每一个item选项都设置一个点击事件
		listView.setOnItemClickListener(this);
		
		// 返回view为下一次加载做铺垫
		return view;
	}

	/**
	 * 当Activity所有的活动都加载完成的时候调用此方法,可能万一是运行在600dp以下设备.
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// 如果说当前的xml资源布局文件R.id.news_content_fragment元素节点存在则说明当前应用程序运行在尺寸大于600dp的设备
		if (getActivity().findViewById(R.id.news_content_fragment) != null) {
			
			isPad = true;
			
		// 如果说当前的xml资源布局文件R.id.news_content_fragment元素节点存在则说明当前应用程序运行在尺寸小于600dp的设备
		} else { 
			
			isPad = false;
			
		}
		
	}
	
	/**
	 * 为每一个item选项实现点击业务的方法
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		
		// 通过当前用户点击的item选项获取在newsList中对应的元素.
		News news = newsList.get(position);
		
		// 判断当前应用运行在哪个设备当中,根据设备的不同情况来使用不同的数据展现方案来展示数据.
		// 如果当前应用运行在尺寸大于600dp的设备上 
		if (isPad) {
			
			// 获取到对应的NewsContentFragment
			NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment); 
			
			// 调用相关的业务方法进行数据上的刷新
			newsContentFragment.refresh(news.getTitle(), news.getContent());
			
		} else { // 如果当前应用运行在尺寸小于600dp的设备上.
			
			NewsContentActivity.statusAction(getActivity(),news.getTitle(),news.getContent());
			
		}
		
	}
	
	/**
	 * 返回一个装满着所有的List<News>数据的方法
	 * @return
	 */
	public List<News> getList() {
		
		// 封装好数据即可.
		List<News> newsList = new ArrayList<News>();
		News news1 = new News("Succeed in College as a Learning Disabled Student","College freshmen will soon learn to live with a roommate, adjust to a new social scene and survive less-than-stellar dining hall food. Students with learning disabilities will face these transitions while also grappling with a few more hurdles.");
		newsList.add(news1);
		
		News news2 = new News("Google Android exec poached by China's Xiaomi","China's Xiaomi has poached a key Google executive involved in the tech giant's Android phones, in a move seen as a coup for the rapidly growing Chinese smartphone maker.");
		newsList.add(news2);
		
		return newsList; 
	}
	
}