package com.democode.firstlinecode.demo7.androidui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * �Զ���ؼ��Ĳ���:
 * 1.�����������:���Ǹ�֮ǰ������������ĸ��д����ʽ��һ����,ֻ����������ĩβ������Ҫʹ��Layout������֮ǰ��Activity.
 * 2.�̳� : ��Ҫ�̳���Ӧ�Ĳ��ֿ�ܵ��������,����,�̳�LinearLayout����,��ô��������̳���ص�LinearLayout�༴��.
 *        import android.widget.LinearLayout; ������µ��ļ�.
 * 3.ʵ�� : ֻ��Ҫ�ڵ�ǰ���ڲ�ʵ��һ�������б�Ϊ(Context context, AttributeSet attrs)�Ĺ���������.
 * @author Administrator
 *
 */
public class CustomControlLayout extends LinearLayout {

	private Button button1;
	
	private Button button2;
	
	/**
	 * ��Ҫ��ʵ������ؼ�ҵ���߼��ķ���.
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
				// ���д��뵱�еĵ�һ�����������ﲻ�ܹ�ֱ�ӵĵ���,��Ϊ����û�м�ӻ�ֱ�ӵļ̳���Context�����.��LinearLayout�ṩ��һ���������԰������Ǹ㶨.
				Toast.makeText(getContext(),"���򽫻��˳�",Toast.LENGTH_SHORT).show();
			}
			
		});
		
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// ���д��뵱�еĵ�һ�����������ﲻ�ܹ�ֱ�ӵĵ���,��Ϊ����û�м�ӻ�ֱ�ӵļ̳���Context�����.��LinearLayout�ṩ��һ���������԰������Ǹ㶨.
				Toast.makeText(getContext(),"���򽫻������༭����",Toast.LENGTH_SHORT).show();
			}
			
		});
		
	}
	
}