package com.example.dialogfactory.utils;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Xavier on 2015/6/4.
 */
public class FragmentUtil {
	public static boolean containFragment(FragmentActivity fragmentActivity, int viewId) {
		FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();

		return fragmentManager.findFragmentById(viewId) != null;
	}

	public static void addFragment(FragmentActivity fragmentActivity, int viewId, Fragment fragment, Intent intent) {
		FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

		if (intent != null) {
			fragment.setArguments(intent.getExtras());
		}

		fragmentTransaction.add(viewId, fragment);
		fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		fragmentTransaction.commit();
	}
}
