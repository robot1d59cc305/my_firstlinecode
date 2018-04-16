package democode.firstlinecode.demo9.receiver3_qiangzhixiaxian;

import com.example.democode.firstlinecode.demo9.receiver3_qiangzhixiaxian.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import my.androiddeveloper.tools.BaseActivity;

/**
 * 这是一个实现了记住密码功能的强制下线功能,如果不需要可以将当前的文件名与此包存在的MainActivity2.java文件名进行替换,.
 * @author Administrator
 *
 */
public class MainActivity extends BaseActivity {
	
	/*
	 * 为什么有写资源要放在这里做一个全局的?因为button.setOnClickListener(new OnClickListener() {是一个内部类
	 * 一个内部类如果说想要去使用内部类外的资源则需要给那些资源加上final,那么这样一来我们的程序就不能够动态的接受用户输入的值了,一旦加上final,那么这个属性的值就不能够被改变.\
	 * 这6个属性都是setOnClickListener函数里面需要使用到的.为了保证能够动态的接受到视图里面的值,因此将这6个属性做为类的成员而存在.
	 * */
	SharedPreferences.Editor shEditor;
	
	SharedPreferences sharedPreferences;
	
	CheckBox rememberPassword;
	
	String account;
	
	String password;
	
	EditText accountEditText;
	
	EditText passwordEditText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		/*
		 * 说明:这个文件的版本要比上一个版本的文件增加了一个用户登录成功之后记住账户和密码功能.
		 *      如果说不需要这个功能只需要实现上一个版本的功能那么就把这个文件的名称改为MainActivity.java文件即可.
		 *      然后将这个包下原本的MainActivity2.java文件名改为MainActivity.java文件名即可.
		 * */
		
		// 1.获取SharedPreferences存读资源的相关对象.
		sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
		shEditor   = getSharedPreferences("data", MODE_PRIVATE).edit();

		// 2.获取账户和密码资源,为什么需要放在这里获取资源?如果上将findViewById()放在onCreate方法之前进行资源获取,那么这个时候很可能我们的类并没有开始加载,这个时候视图资源也没有出现,那么资源是获取不到的,到最后是会得一个空指针的异常. 
		accountEditText  = (EditText) findViewById(R.id.login_account);
		passwordEditText = (EditText) findViewById(R.id.login_Password);
		
		// 3.获取登录按钮,复选框资源.
		Button button = (Button) findViewById(R.id.login_button);
		rememberPassword  = (CheckBox) findViewById(R.id.rememberPassword);
		
		// 4.假定用户上一次登录过,则从sharedPreferences中获取用户的复选框勾选信息.
		boolean checking = sharedPreferences.getBoolean("rememberPassword",false); 
		
		// 4.若用户上一次点击了复选框,则实现记住密码功能  从SharedPreferences中读取用户账户,用户密码,并且将复选框中的对勾手动打上. 
		if (checking) {
			
			accountEditText.setText(sharedPreferences.getString("account",""));
			
			passwordEditText.setText(sharedPreferences.getString("password",""));
			
			rememberPassword.setChecked(true);
			
		}
		
		/* 5.若经过步骤3的判断,用户并没有在之前的时候使用过记住密码的功能,或者这是用户第一次使用这个应用程序,则用户在视图中输入完账户和密码之后点击了login登录,这里需要为用户的单击事件加上setOnClickListener函数. 
		 * 为什么要在这里实现这个
		 * */
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 为什么这些资源需要放在这里获取?因为如果在前面就获取的话,很可能最后获取到的资源是一个空值,或者是用户输入一次之后就改变了.我需要获取的是用户做好所有的选择之后最后按下按钮再来统计所有的资源情况.
				account   = accountEditText.getText().toString();	
				password  = passwordEditText.getText().toString();
				rememberPassword  = (CheckBox) findViewById(R.id.rememberPassword);
				
				// 判断账户和密码是否正确
				 if (account.equals("admin") && password.equals("123456") ) {
					
					 // 判断用户是否需要记住密码
					 if (rememberPassword.isChecked()) {
						
					 	 shEditor.putString("account",account);
						
						 shEditor.putString("password",password);
						
						 shEditor.putBoolean("rememberPassword",true);
						
					 } else{
						 // 否则如果用户没有点击复选框,那么就说明,用户不需要记住密码功能,就需要将之前保存的数据删除.
						 shEditor.clear();
					 }
					 
					 // SharedPreferences做的所有操作每次都必须要commit,包括clear()操作.否则不会被记录.
					 shEditor.commit();
					 Intent intent = new Intent(MainActivity.this,ProductActivity.class);
					 startActivity(intent);
				 } else {
					 // 注意如果在外部类里面调用Toast则必须要在第一个参数里面使用v.getContext(),而不能够去写this或直接写一个类的引用
					 Toast.makeText(v.getContext(), "账户或密码错误",Toast.LENGTH_LONG).show();
				 }
			}
			
		});

	}
	
}