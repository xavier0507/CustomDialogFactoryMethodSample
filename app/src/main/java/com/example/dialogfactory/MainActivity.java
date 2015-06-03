package com.example.dialogfactory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.example.dialogfactory.fragments.MainFragment;
import com.example.dialogfactory.utils.FragmentUtil;

/**
 * Created by Xavier on 2015/6/4.
 */
public class MainActivity extends FragmentActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity_main);

		if (FragmentUtil.containFragment(this, R.id.container) == false) {
			Fragment fragment = new MainFragment();
			FragmentUtil.addFragment(this, R.id.container, fragment, null);
		}
	}
}
