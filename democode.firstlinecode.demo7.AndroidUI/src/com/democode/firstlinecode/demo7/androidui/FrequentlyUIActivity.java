package com.democode.firstlinecode.demo7.androidui;

import com.democode.firstlinecode.demo7.tool.ActivityManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * �ں�̨���뵱��ȥ������Щ���õ�UI�ؼ�.
 * @author Administrator
 *
 */
public class FrequentlyUIActivity extends Activity implements OnClickListener {
	
	/*
	 * ��ʼ������һЩ����,����װ����layout.xml�ļ��е���Դ.
	 * */
	
	private Button    buttonImage;
	
	private ImageView imageView;
	
	private Button frequentlyuiButton3;
	
	private ProgressBar frequentlyuiProgressBar1;
	
	private Button frequentlyuiButton4;
	
	private Button frequentlyuiButton5;
	
	private ProgressBar frequentlyuiProgressBar2;
	
	private ProgressBar frequentlyuiProgressBar3;
	
	private Button frequentlyuiButton6;
	
	private ProgressDialog progressDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.frequentlyui);
		
		Button button = (Button) findViewById(R.id.frequentlyuiButton1);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText editText = (EditText) findViewById(R.id.frequentlyuiEditText1);
				Toast.makeText(FrequentlyUIActivity.this,editText.getText().toString(),Toast.LENGTH_LONG).show();
			}
			
		});
		
		buttonImage = (Button) findViewById(R.id.frequentlyuiButton2);
		
		imageView = (ImageView) findViewById(R.id.frequentlyuiImage1);
		
		frequentlyuiButton3 = (Button) findViewById(R.id.frequentlyuiButton3);
		
		frequentlyuiProgressBar1 = (ProgressBar) findViewById(R.id.frequentlyuiProgressBar1);
		
		frequentlyuiButton4 = (Button) findViewById(R.id.frequentlyuiButton4); 
		
		frequentlyuiProgressBar2 = (ProgressBar) findViewById(R.id.frequentlyuiProgressBar2);
		
		frequentlyuiButton5 = (Button) findViewById(R.id.frequentlyuiButton5);
		
		frequentlyuiButton6 = (Button) findViewById(R.id.frequentlyuiButton6);
		
		buttonImage.setOnClickListener(FrequentlyUIActivity.this);
		
		frequentlyuiButton3.setOnClickListener(FrequentlyUIActivity.this);
		
		frequentlyuiButton4.setOnClickListener(FrequentlyUIActivity.this);
		
		frequentlyuiButton5.setOnClickListener(FrequentlyUIActivity.this);
		
		frequentlyuiButton6.setOnClickListener(FrequentlyUIActivity.this);
		
		ActivityManager.addActivity(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		   
		    // ���֮��ͼƬ�л�.
			case R.id.frequentlyuiButton2:
				 imageView.setImageResource(R.drawable.apple_pic);
				 break;
			
		    // ���֮��Բ�ν��������ػ�����ʾ.
			case R.id.frequentlyuiButton3:
				 // ���frequentlyuiProgressBar1�ɼ��Ͱ�����������,������ɼ��Ͱ�����ʾ.
				 if (frequentlyuiProgressBar1.getVisibility() == View.GONE) {
					 frequentlyuiProgressBar1.setVisibility(View.VISIBLE);
				 } else { 
					 frequentlyuiProgressBar1.setVisibility(View.GONE);
				 }
				 break;
			
		    // ���֮��ÿ���һ�ν�һ�����ߵĽ������Ľ���+10.
			case R.id.frequentlyuiButton4:
				// ͨ��getProgress()������ȡ��ֵ,��ÿ��+10,Ȼ�󽫼����ֵ��ֵ��frequentlyuiProgressBar2��.
				int progre = frequentlyuiProgressBar2.getProgress();
				progre = progre + 10;
				frequentlyuiProgressBar2.setProgress(progre);
				 break;
			
		    // ���֮�󵯳�AlertDialog�ĶԻ���.
			case R.id.frequentlyuiButton5:
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(FrequentlyUIActivity.this);
				alertDialog.setTitle("�Ƿ�Ҫ�˳��������?");
				alertDialog.setMessage("�˳��������Ͳ��ܹ���ȡ����Ľ�����?");
				alertDialog.setCancelable(false);
				alertDialog.setPositiveButton("ȷ��",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(FrequentlyUIActivity.this,"�ð�,�ټ�!",Toast.LENGTH_LONG).show();
						ActivityManager.finishALL();
					}
					
				});
				alertDialog.setNegativeButton("ȡ��",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(FrequentlyUIActivity.this,"лл��������!",Toast.LENGTH_LONG).show();
					}
					
				});
				alertDialog.show();
				break;
			
			// ���֮�󵯳�һ��ProgressDialog�Ի���.
			case R.id.frequentlyuiButton6:
				progressDialog = new ProgressDialog(FrequentlyUIActivity.this);
				progressDialog.setTitle("Ӧ�ó����������ذ�װ��....");
				progressDialog.setMessage("Loading...");
				// ���progressDialog.setCancelable(false),��ͨ��progressDialog.dismiss()����������Ի���ر�.
				progressDialog.setCancelable(true);
				progressDialog.show();
				break;
				
			default :
				break;
		}
	}
	
}