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
	 * 发送按钮
	 */
	private Button button;
	
	/**
	 * 消息编辑框
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
		
		Message message = new Message(1, "你好,我是小天使!");
		messageList.add(message);
		
		Message message2 = new Message(0, "你好,我是中国有嘻哈导师热狗!");
		messageList.add(message2);
		
		Message message3 = new Message(1, "你好,我是中国有嘻哈导师freestyle吴亦凡!");
		messageList.add(message3);
		
		Message message4 = new Message(0, "你好,我是中国有嘻哈导师freestyle张震岳!");
		messageList.add(message4);
		
		Message message5 = new Message(1, "你好,我是中国有嘻哈PGOne万磁王!");
		messageList.add(message5);
		
	}
	
}