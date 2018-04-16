package democode.firstlinecode.demo8.dynamicfragment.fragment;

import com.example.democode.firstlinecode.demo8.dynamicfragment.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import democode.firstlinecode.demo8.dynamicfragment.activity.ShowActivity;

public class LeftFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.leftfragment, container,false);
		
		ShowActivity showActivity = (ShowActivity) getActivity();
		
		return view;
	}
	
}