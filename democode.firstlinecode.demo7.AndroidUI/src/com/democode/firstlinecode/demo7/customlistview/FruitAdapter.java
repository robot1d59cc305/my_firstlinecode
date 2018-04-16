package com.democode.firstlinecode.demo7.customlistview;

import java.util.List;

import com.democode.firstlinecode.demo7.androidui.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * �Զ���һ��������,��ô��������,�������ݵ������������Լ�������.
 * @author Administrator
 *
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {

	/**
	 * ��������ǳ���Ҫ,�ܶ�ķ�������Ҫʹ�õ���,��Ϊ���Ƕ���Ҫ���һ����Դid,ͨ�������Դid��������ͼ�е���ͼ��Դ.
	 */
	private int resourceId;

	/**
	 * �������������������ƽ����ʹ�õ�һ��Ĭ�ϵ�ArrayAdapter<String []>���͵Ĺ���������Ҫ�������������һЩ����.
	 * @param context	
	 * @param resource	������Դid,���Ŀ���ͼ�Զ�����һ��ListView,��������չʾ.
	 * @param textViewResourceId 
	 * @param objects 	һ��List<Fruit>���͵�����.
	 */
	public FruitAdapter(Context context,int textViewResourceId, List<Fruit> objects) {
		super(context,textViewResourceId, objects);
		resourceId=textViewResourceId;
	}
	
	/**
	 * ����ÿһ����Ļ��������ÿһ������γ��ֵķ���.
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		// 1.��ȡ����ǰ���Fruit,����ж��ǵ�ǰ��,����position���ֵ�������ж�.
		Fruit fruit = getItem(position);
		
		// 2.��ȡ����Ҫ����չ�ֵ���ͼ����.
		View view = LayoutInflater.from(getContext()).inflate(R.layout.fruit_item,null);
		
		// 3.ͨ��findViewById���API,��ȡ����Ӧid����Դ,����,��Ҫ��view�Ļ����Ͻ��е���.
		ImageView imageView = (ImageView) view.findViewById(R.id.fruit_Image);
		TextView  textView  = (TextView)view.findViewById(R.id.fruit_Text);
		
		// 4.��1�е����ݷ��뵽3�е���ͼ��������,һһ��Ӧ.
		imageView.setImageResource(fruit.getResourceId());
		textView.setText(fruit.getName());
		
		// 5.��4�е�view���󷵻�.��Ϊ������2-4�����ж��������View�����ڲ�������,����,����ÿ������һ�����ݾ���Ҫ�����ݷ���,��view���󷵻�.
		return view;
	}

}