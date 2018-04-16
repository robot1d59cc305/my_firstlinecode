package democode.firstlinecode.demo17.develop.skill.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * 接下来在 FirstActivity 中我们仍然可以使用相同的代码来传递 Person 对象，只不过在
SecondActivity 中获取对象的时候需要稍加改动，如下所示：
 * @author Administrator
 *
 */
public class FirstActivity extends Activity {
	
	protected void onCreate(Bundle bundle) {
		
		super.onCreate(bundle);
		
		/*
		 * 通过Serializable的方式来读取数据.
		 */
		Person person = new Person();
		
		person.setName("Tom");
		
		person.setAge(20);
		
		Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
		
		intent.putExtra("person_data",person);
		
		super.startActivity(intent);
		
		/*
		 * 通过Parcelable的方式来读取数据.
		 * */
		Person2 person2 = (Person2) getIntent().getParcelableExtra("person_data");
		
		/*
		 * 对比一下，Serializable的方式较为简单，但由于会把整个对象进行序列化，因此效率方面会比 Parcelable 方式低一些，所以在通常情况下还是更加推荐使用 Parcelable 的方式来实现 Intent 传递对象的功能。
		 * */
		
	}
	
}
