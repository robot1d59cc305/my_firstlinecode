package democode.firstlinecode.demo11.content.provider.contacts;

import java.util.ArrayList;
import java.util.List;
import com.example.democode.firstlinecode.demo11.content.provider.R;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 
 * 读取系统联系人活动
 * 
 * @author Administrator
 *
 */
public class ReadSystemContactsActivity extends Activity {

	private ListView listView;

	private ArrayAdapter<String> arrayAdapter;

	private List<String> list = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contacts_list_view);

		listView = (ListView) findViewById(R.id.contacts_list_view);

		arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

		listView.setAdapter(arrayAdapter);

		readContacts();
	}

	/**
	 * 读取系统联系人
	 */
	public void readContacts() {

		// 获取系统手机中的联系人,以一个Cursor对象的结果返回.
		Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null,
				null);

		// 遍历Cursor对象中的结果.
		while (cursor.moveToNext()) {

			String display_name = cursor
					.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

			String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

			list.add(display_name + "\n" + number);

		}

	}

}