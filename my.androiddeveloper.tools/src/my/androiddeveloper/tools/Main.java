package my.androiddeveloper.tools;

import android.text.TextUtils;
import android.util.Log;

public class Main {
	
	public static void main(String[] args) {
		String str = "...";
		Log.d("Empty",TextUtils.isEmpty(str) == true ? "true" : "false");
	}
	
}