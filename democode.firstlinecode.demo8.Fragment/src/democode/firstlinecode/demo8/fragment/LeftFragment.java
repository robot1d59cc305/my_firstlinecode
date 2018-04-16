package democode.firstlinecode.demo8.fragment;

import com.example.democode.firstlinecode.demo8.fragment.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LeftFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.leftfragment, container,false);
		return view;
	}
	
}