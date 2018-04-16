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
 * 在后台代码当中去控制这些常用的UI控件.
 * @author Administrator
 *
 */
public class FrequentlyUIActivity extends Activity implements OnClickListener {
	
	/*
	 * 初始化声明一些变量,用来装载在layout.xml文件中的资源.
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
		   
		    // 点击之后将图片切换.
			case R.id.frequentlyuiButton2:
				 imageView.setImageResource(R.drawable.apple_pic);
				 break;
			
		    // 点击之后将圆形进度条隐藏或者显示.
			case R.id.frequentlyuiButton3:
				 // 如果frequentlyuiProgressBar1可见就把它隐藏起来,如果不可见就把它显示.
				 if (frequentlyuiProgressBar1.getVisibility() == View.GONE) {
					 frequentlyuiProgressBar1.setVisibility(View.VISIBLE);
				 } else { 
					 frequentlyuiProgressBar1.setVisibility(View.GONE);
				 }
				 break;
			
		    // 点击之后每点击一次将一个横线的进度条的进度+10.
			case R.id.frequentlyuiButton4:
				// 通过getProgress()方法获取到值,且每次+10,然后将加完的值赋值到frequentlyuiProgressBar2中.
				int progre = frequentlyuiProgressBar2.getProgress();
				progre = progre + 10;
				frequentlyuiProgressBar2.setProgress(progre);
				 break;
			
		    // 点击之后弹出AlertDialog的对话框.
			case R.id.frequentlyuiButton5:
				AlertDialog.Builder alertDialog = new AlertDialog.Builder(FrequentlyUIActivity.this);
				alertDialog.setTitle("是否要退出这个程序?");
				alertDialog.setMessage("退出这个程序就不能够领取今天的奖励了?");
				alertDialog.setCancelable(false);
				alertDialog.setPositiveButton("确定",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(FrequentlyUIActivity.this,"好吧,再见!",Toast.LENGTH_LONG).show();
						ActivityManager.finishALL();
					}
					
				});
				alertDialog.setNegativeButton("取消",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(FrequentlyUIActivity.this,"谢谢您留下来!",Toast.LENGTH_LONG).show();
					}
					
				});
				alertDialog.show();
				break;
			
			// 点击之后弹出一个ProgressDialog对话框.
			case R.id.frequentlyuiButton6:
				progressDialog = new ProgressDialog(FrequentlyUIActivity.this);
				progressDialog.setTitle("应用程序正在下载安装包....");
				progressDialog.setMessage("Loading...");
				// 如果progressDialog.setCancelable(false),则通过progressDialog.dismiss()方法将这个对话框关闭.
				progressDialog.setCancelable(true);
				progressDialog.show();
				break;
				
			default :
				break;
		}
	}
	
}