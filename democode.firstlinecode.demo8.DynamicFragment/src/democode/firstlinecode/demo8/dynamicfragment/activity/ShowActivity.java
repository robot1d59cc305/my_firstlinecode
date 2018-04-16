package democode.firstlinecode.demo8.dynamicfragment.activity;

import com.example.democode.firstlinecode.demo8.dynamicfragment.R;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import democode.firstlinecode.demo8.dynamicfragment.fragment.LeftFragment;
import democode.firstlinecode.demo8.dynamicfragment.fragment.RightOtherFragment;

/**
 * 
 * @author Administrator
 *
 */
public class ShowActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button = (Button) findViewById(R.id.leftfragment_bu1);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 动态注册 这个Fragment并没有出现在activity_main.xml文件的fragment标签当中,纯粹的动态注册!
				RightOtherFragment  rightOtherFragment  = new RightOtherFragment();
				FragmentManager     fragmentManager     = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				fragmentTransaction.replace(R.id.activity_main_rightfragment, rightOtherFragment);
				
				/*
				 * 这个方法可以让Fragment模拟返回栈的效果,就是如果你在程序里面打开了多个Fragment,
				 * 则退出的时候是会一个一个的进行退出,而不是会一次性全部清空完毕退出完成.
				 * 这种情况一般来说是你使用了这种方法之后会产生的效果,一般的静态引入不会产生一步步退出来的效果.
				 * */
				fragmentTransaction.addToBackStack(null);
				
				fragmentTransaction.commit();
			}
			
		});
	}
	
	/**
	 * 在Activity中与Fragment进行通信
	 */
	public void tongxin() {
  		 // 放入相关的fragment的layout布局文件,然后强制转换为所需要的类的文件.实际上这里能够完成引用还是因为在之前的时候setContentView方法引用了fragment标签所在的布局文件.
		 LeftFragment leftfragment = (LeftFragment) getFragmentManager().findFragmentById(R.layout.leftfragment);
	}
	
}