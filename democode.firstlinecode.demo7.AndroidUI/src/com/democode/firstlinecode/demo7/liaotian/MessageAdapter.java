package com.democode.firstlinecode.demo7.liaotian;

import java.util.List;

import com.democode.firstlinecode.demo7.androidui.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 在使用ListView组件展示每条Message消息时的过滤机制.
 * @author Administrator
 */
public class MessageAdapter extends ArrayAdapter<Message> {

	
	private int resourceId;
	
	/**
	 * 通过这个构造器构建一个Adapter.到时候要用的时候会构造这个类的对象就必须要传递数据进来.
	 * @param context	构造这个类的Activity类的getContext().
	 * @param resource	需要去遍历的那个item选项的xml布局文件的资源id.
	 * @param objects	每一个ListView下的item选项的List<JavaBean>
	 */
	public MessageAdapter(Context context, int resource, List<Message> objects) {
		super(context, resource, objects);
		resourceId = resource;
	}

	/**
	 * 通过这个方法判断每一个ListView的子项应该如何显示,哪些能够显示.
	 * 到时候调用就是在调用这个方法做筛选.所以可以想象为这个方法是运行的时候的每一次循环迭代,对ListView的.
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		Message message = getItem(position);
		
		View view;
		
		ViewHandler viewHandler;
		
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId,null);
			viewHandler = new ViewHandler();
			viewHandler.liaotian_jiemian_listview_item_left_linearlayout  = (LinearLayout) view.findViewById(R.id.liaotian_jiemian_listview_item_left_linearlayout);
			viewHandler.liaotian_jiemian_listview_item_right_linearlayout = (LinearLayout) view.findViewById(R.id.liaotian_jiemian_listview_item_right_linearlayout);
			viewHandler.liaotian_jiemian_listview_item_left_linearlayout_textview  = (TextView) view.findViewById(R.id.liaotian_jiemian_listview_item_left_linearlayout_textview);
			viewHandler.liaotian_jiemian_listview_item_right_linearlayout_textview = (TextView) view.findViewById(R.id.liaotian_jiemian_listview_item_right_linearlayout_textview);
			view.setTag(viewHandler);
		} else {
			view = convertView;
			viewHandler = (ViewHandler) convertView.getTag();
		}
		
		if (message.getZhaungtaima() == message.fachu) {
			viewHandler.liaotian_jiemian_listview_item_right_linearlayout.setVisibility(View.VISIBLE);
			viewHandler.liaotian_jiemian_listview_item_left_linearlayout.setVisibility(View.GONE);
			viewHandler.liaotian_jiemian_listview_item_right_linearlayout_textview.setText(message.getContent());
		} else if (message.getZhaungtaima() == message.shou) {
			viewHandler.liaotian_jiemian_listview_item_left_linearlayout.setVisibility(View.VISIBLE);
			viewHandler.liaotian_jiemian_listview_item_right_linearlayout.setVisibility(View.GONE);
			viewHandler.liaotian_jiemian_listview_item_left_linearlayout_textview.setText(message.getContent());
		}
		
		return view;
	}
	
	/**
	 * 
	 * @author Administrator
	 *
	 */
	class ViewHandler {
		
		private LinearLayout liaotian_jiemian_listview_item_left_linearlayout;
		
		private LinearLayout liaotian_jiemian_listview_item_right_linearlayout;
		
		private TextView liaotian_jiemian_listview_item_left_linearlayout_textview;
		
		private TextView liaotian_jiemian_listview_item_right_linearlayout_textview;
		
	}
	
}