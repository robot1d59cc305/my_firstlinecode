package com.democode.firstlinecode.demo7.basiclistview;

import com.democode.firstlinecode.demo7.androidui.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * ʹ��ListView�ؼ�(������Ϊ����Դ).
 * ʹ�÷���:
 * 	1.׼��һ���ַ������͵�����,�����鵱�����һЩ��Ӧ����������͵�����Ԫ��.
 *  2.���ض�����ͼ.
 *  3.ͨ��ArrayAdapter���дһ��������,����Ҫѡ����һ����������������Ϊ(Context context,int resourceid,String[] objects)�Ĺ�����.
 *  4.ͨ��setAdapter������3�е������������ȥ.
 * @author Administrator
 *
 */
public class ListViewArrayActivity extends Activity {
	
	/**
	 * ���������ListView�ؼ�������Դ.
	 */
	private String[] data = {
			 "Ature","Bture","Cture","Dture","Eture"
			,"Fture","Gture","Hture","ITure","JTure"
			,"Kture","Uture","Mture","Nture","Oture"
			,"Pture","Qture","Rture","Sture","Tture"
			,"Uture","Vture","Wture","Xture","Yture"
			,"Zture"};
	
	/**
	 * һ���򵥵�ListView�ؼ�������Դ.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// 1.���ض�����ͼ��Դ.
		setContentView(R.layout.listviewarraylayout);
		
		// 2.��дһ��������.
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ListViewArrayActivity.this,android.R.layout.simple_list_item_1,data);
		
		// 3.��ȡListView�ؼ���Դ.
		ListView listView = (ListView) findViewById(R.id.listviewarraylayout_listView1);
		
		// 4.Ϊ�ؼ����������.
		listView.setAdapter(arrayAdapter);
		
	}
	
}