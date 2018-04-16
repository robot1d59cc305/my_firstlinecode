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
 * 自定义一个适配器,怎么处理数据,处理数据的流程由我们自己来定制.
 * @author Administrator
 *
 */
public class FruitAdapter extends ArrayAdapter<Fruit> {

	/**
	 * 这个变量非常重要,很多的方法都需要使用到它,因为我们都需要获得一个资源id,通过这个资源id来查找视图中的视图资源.
	 */
	private int resourceId;

	/**
	 * 这个构造器就像是我们平常在使用的一个默认的ArrayAdapter<String []>类型的构造器中需要给适配器适配的一些参数.
	 * @param context	
	 * @param resource	传入资源id,是哪块视图自定义了一个ListView,让我们来展示.
	 * @param textViewResourceId 
	 * @param objects 	一个List<Fruit>类型的数据.
	 */
	public FruitAdapter(Context context,int textViewResourceId, List<Fruit> objects) {
		super(context,textViewResourceId, objects);
		resourceId=textViewResourceId;
	}
	
	/**
	 * 返回每一次屏幕滑动到的每一项是如何出现的方法.
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		// 1.获取到当前项的Fruit,如何判断是当前项,根据position这个值来进行判断.
		Fruit fruit = getItem(position);
		
		// 2.获取到需要数据展现的视图对象.
		View view = LayoutInflater.from(getContext()).inflate(R.layout.fruit_item,null);
		
		// 3.通过findViewById这个API,获取到对应id的资源,但是,是要在view的基础上进行调用.
		ImageView imageView = (ImageView) view.findViewById(R.id.fruit_Image);
		TextView  textView  = (TextView)view.findViewById(R.id.fruit_Text);
		
		// 4.将1中的数据放入到3中的视图对象里面,一一对应.
		imageView.setImageResource(fruit.getResourceId());
		textView.setText(fruit.getName());
		
		// 5.将4中的view对象返回.因为我们在2-4步骤中都是在针对View对象在操作数据,所以,这里每操作完一次数据就需要将数据返回,将view对象返回.
		return view;
	}

}