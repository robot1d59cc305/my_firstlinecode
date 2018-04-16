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
 * ��ʹ��ListView���չʾÿ��Message��Ϣʱ�Ĺ��˻���.
 * @author Administrator
 */
public class MessageAdapter extends ArrayAdapter<Message> {

	
	private int resourceId;
	
	/**
	 * ͨ���������������һ��Adapter.��ʱ��Ҫ�õ�ʱ��ṹ�������Ķ���ͱ���Ҫ�������ݽ���.
	 * @param context	����������Activity���getContext().
	 * @param resource	��Ҫȥ�������Ǹ�itemѡ���xml�����ļ�����Դid.
	 * @param objects	ÿһ��ListView�µ�itemѡ���List<JavaBean>
	 */
	public MessageAdapter(Context context, int resource, List<Message> objects) {
		super(context, resource, objects);
		resourceId = resource;
	}

	/**
	 * ͨ����������ж�ÿһ��ListView������Ӧ�������ʾ,��Щ�ܹ���ʾ.
	 * ��ʱ����þ����ڵ������������ɸѡ.���Կ�������Ϊ������������е�ʱ���ÿһ��ѭ������,��ListView��.
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