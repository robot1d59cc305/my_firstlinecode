package democode.firstlinecode.demo9.receiver3_qiangzhixiaxian;

import com.example.democode.firstlinecode.demo9.receiver3_qiangzhixiaxian.R;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import my.androiddeveloper.tools.BaseActivity;

/**
 *
 * @author Administrator
 *
 */
public class MainActivity2 extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
	}
	
	public void xiaxian(View v) {
		
		// 1.获取两个资源文件的资源
		EditText accountEditText = (EditText) findViewById(R.id.login_account);
		EditText passwordEditText = (EditText) findViewById(R.id.login_Password);
		
		String account  = accountEditText.getText().toString();	
		String password = passwordEditText.getText().toString();

		
		// 2.判断账户和密码是否一致?
		if (account.equals("admin") && password.equals("123456") ) {
			Intent intent = new Intent(MainActivity2.this,ProductActivity.class);
			startActivity(intent);
		} else {
			// 注意如果在外部类里面调用Toast则必须要在第一个参数里面使用v.getContext(),而不能够去写this或直接写一个类的引用
			Toast.makeText(v.getContext(), "账户或密码错误",Toast.LENGTH_LONG).show();
		}
		
		
		
		/* 建议不要这么写代码,为什么?因为我们在login.xml文件中给某个控件加上了android:onClick标签,然后将这个onClick标签中的值在我们的这个类中去写成一个方法
		 * 实际上就已经将这个控件的id资源加上了点击事件,所以如果还在这里面去写一个点击事件则表示点击之后还需要再次点击才会执行这个代码.
		 * 这样的变态效果显示是不能够适用于我们现在的场景的.
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 1.获取两个资源文件的资源
				EditText accountEditText = (EditText) findViewById(R.id.login_account);
				EditText passwordEditText = (EditText) findViewById(R.id.login_Password);
				
				String account  = accountEditText.getText().toString();	
				String password = passwordEditText.getText().toString();

				
				// 2.判断账户和密码是否一致?
				if (account.equals("admin") && password.equals("123456") ) {
					Intent intent = new Intent(MainActivity.this,ProductActivity.class);
					startActivity(intent);
				} else {
					// 注意如果在外部类里面调用Toast则必须要在第一个参数里面使用v.getContext(),而不能够去写this或直接写一个类的引用
					Toast.makeText(v.getContext(), "账户或密码错误",Toast.LENGTH_LONG).show();
				}
			}
		});
		*/
			
	}
	
}