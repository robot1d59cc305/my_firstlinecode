package com.democode.firstlinecode.demo7.liaotian;

import java.util.ArrayList;
import java.util.List;

import com.democode.firstlinecode.demo7.androidui.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class LiaoTianActivity extends Activity {

	/**
	 * ListView
	 */
	private ListView messageListView;
	
	/**
	 * List<Message>
	 */
	private List<Message> messageList = messageList = new ArrayList<Message>();
	
	/**
	 * adapter
	 */
	private MessageAdapter messageadapter;
	
	/**
	 * ���Ͱ�ť
	 */
	private Button button;
	
	/**
	 * ��Ϣ�༭��
	 */
	private EditText editText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.liaotian_jiemian);
		
		initMsgList();
		
		messageadapter = new MessageAdapter(LiaoTianActivity.this,R.layout.liaotian_jiemian_listview_item, messageList);
		
		messageListView = (ListView) findViewById(R.id.liaotian_jiemian_listview1);
		
		messageListView.setAdapter(messageadapter);
		
		button = (Button) findViewById(R.id.liaotian_jiemian_button1);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				editText = (EditText) findViewById(R.id.liaotian_jiemian_edittext1);
				
				if (!"".equals(editText.getText().toString())) {
					
					Message message = new Message(0,editText.getText().toString());
					messageList.add(message);
					messageadapter.notifyDataSetChanged();
					messageListView.setSelection(messageList.size());
					editText.setText("");
					
				}
				
			}
		});
		
	}
	
	private void initMsgList() {
		
		Message message = new Message(1, "���,����С��ʹ!");
		messageList.add(message);
		
		Message message2 = new Message(0, "���,�����й���������ʦ�ȹ�!");
		messageList.add(message2);
		
		Message message3 = new Message(1, "���,�����й���������ʦfreestyle���ෲ!");
		messageList.add(message3);
		
		Message message4 = new Message(0, "���,�����й���������ʦfreestyle������!");
		messageList.add(message4);
		
		Message message5 = new Message(1, "���,�����й�������PGOne�����!");
		messageList.add(message5);
		
	}
	
}