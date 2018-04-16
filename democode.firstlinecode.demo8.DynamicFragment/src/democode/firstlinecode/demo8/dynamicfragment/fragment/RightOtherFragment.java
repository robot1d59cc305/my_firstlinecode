package democode.firstlinecode.demo8.dynamicfragment.fragment;

import com.example.democode.firstlinecode.demo8.dynamicfragment.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *这个类用于被ShowActivity进行动态注册.
 * @author Administrator
 *
 */
public class RightOtherFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.rightotherfragment, container, false);
		return view;
	}
	
}
