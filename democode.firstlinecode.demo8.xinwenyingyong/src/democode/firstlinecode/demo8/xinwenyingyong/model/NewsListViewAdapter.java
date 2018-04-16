package democode.firstlinecode.demo8.xinwenyingyong.model;

import java.util.List;

import com.example.democode.firstlinecode.demo8.xinwenyingyong.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * ListView控件的item选项视图数据
 * @author Administrator
 *
 */
public class NewsListViewAdapter extends ArrayAdapter<News>  {

	/**
	 * 资源id
	 */
	private int resourceId;	
	
	/**
	 * 
	 * @param context
	 * @param resource
	 * @param objects
	 */
	public NewsListViewAdapter(Context context, int resource, List<News> objects) {
		super(context, resource, objects);
		resourceId = resource;
	}
	
	/**
	 * 处理每一个ListView选项如何展现数据的业务
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		// 获取到每一个News新闻类的实体对象.
		News news = getItem(position);
		
		// 定义一个View,用于从其它的xml文件资源当中获取到数据.
		View view = null;
		
		// 如果是第一次在获取res下的layout资源文件,使用代码为后面获取资源提高性能.
		if (convertView == null) {
			
			// 设置布局文件
			view = LayoutInflater.from(getContext()).inflate(resourceId,null);
			
		// 如果已经不是第一次在获取res下的layout资源文件	
		} else if (convertView != null) {
			
			// 设置convertView并且赋值到view
			view = convertView;
			
		}
		
		// 将需要被填写的资源获取到.
		TextView textView = (TextView) view.findViewById(R.id.list_view_item);
		
		// 将数据填充到资源中.
		textView.setText(news.getTitle());
		
		// 将view返回出去让下一次的资源获取更加的方便
		return view;
	}
	
}