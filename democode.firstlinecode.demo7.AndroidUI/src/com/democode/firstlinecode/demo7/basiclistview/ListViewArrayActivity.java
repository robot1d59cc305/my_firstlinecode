package com.democode.firstlinecode.demo7.basiclistview;

import com.democode.firstlinecode.demo7.androidui.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 使用ListView控件(以数组为数据源).
 * 使用方法:
 * 	1.准备一个字符串类型的数组,在数组当中填充一些对应这个数组类型的数组元素.
 *  2.加载顶级视图.
 *  3.通过ArrayAdapter类编写一个适配器,但需要选择与一个构造器参数类型为(Context context,int resourceid,String[] objects)的构造器.
 *  4.通过setAdapter方法将3中的适配器加入进去.
 * @author Administrator
 *
 */
public class ListViewArrayActivity extends Activity {
	
	/**
	 * 这个数组是ListView控件的数据源.
	 */
	private String[] data = {
			 "Ature","Bture","Cture","Dture","Eture"
			,"Fture","Gture","Hture","ITure","JTure"
			,"Kture","Uture","Mture","Nture","Oture"
			,"Pture","Qture","Rture","Sture","Tture"
			,"Uture","Vture","Wture","Xture","Yture"
			,"Zture"};
	
	/**
	 * 一个简单的ListView控件的数据源.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 1.加载顶级视图资源.
		setContentView(R.layout.listviewarraylayout);
		
		// 2.编写一个适配器.
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ListViewArrayActivity.this,android.R.layout.simple_list_item_1,data);
		
		// 3.获取ListView控件资源.
		ListView listView = (ListView) findViewById(R.id.listviewarraylayout_listView1);
		
		// 4.为控件添加适配器.
		listView.setAdapter(arrayAdapter);
		
	}
	
}