package com.democode.firstlinecode.demo7.androidui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * 自定义控件的步骤:
 * 1.类的命名规则:还是跟之前的类名单词字母大写的形式是一样的,只是类名名称末尾单词需要使用Layout来代替之前的Activity.
 * 2.继承 : 需要继承相应的布局框架的类的名称,例如,继承LinearLayout布局,那么就在这里继承相关的LinearLayout类即可.
 *        import android.widget.LinearLayout; 这个包下的文件.
 * 3.实现 : 只需要在当前类内部实现一个参数列表为(Context context, AttributeSet attrs)的构造器即可.
 * @author Administrator
 *
 */
public class CustomControlLayout extends LinearLayout {

	private Button button1;
	
	private Button button2;
	
	/**
	 * 主要来实现这个控件业务逻辑的方法.
	 * @param context
	 * @param attrs
	 */
	public CustomControlLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		LayoutInflater.from(context).inflate(R.layout.title,this);
		button1 = (Button) findViewById(R.id.title_button1);
		button2 = (Button) findViewById(R.id.title_button2);
		
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 这行代码当中的第一个参数在这里不能够直接的调用,因为这里没有间接或直接的继承于Context这个类.但LinearLayout提供了一个方法可以帮助我们搞定.
				Toast.makeText(getContext(),"程序将会退出",Toast.LENGTH_SHORT).show();
			}
			
		});
		
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 这行代码当中的第一个参数在这里不能够直接的调用,因为这里没有间接或直接的继承于Context这个类.但LinearLayout提供了一个方法可以帮助我们搞定.
				Toast.makeText(getContext(),"程序将会启动编辑程序",Toast.LENGTH_SHORT).show();
			}
			
		});
		
	}
	
}