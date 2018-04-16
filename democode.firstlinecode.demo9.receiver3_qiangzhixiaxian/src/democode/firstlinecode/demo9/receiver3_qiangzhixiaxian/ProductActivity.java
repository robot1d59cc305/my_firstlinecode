package democode.firstlinecode.demo9.receiver3_qiangzhixiaxian;

import com.example.democode.firstlinecode.demo9.receiver3_qiangzhixiaxian.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import my.androiddeveloper.tools.BaseActivity;

/**
 * 产品Activity
 * @author Administrator
 *
 */
public class ProductActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.product);
		
		Button button = (Button)findViewById(R.id.xiaxian);
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("com.example.xiaxian.product");
				sendBroadcast(intent);
			}
			
		});
	}
	
	
	
}