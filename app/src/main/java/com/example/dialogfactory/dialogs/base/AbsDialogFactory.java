package com.example.dialogfactory.dialogs.base;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Xavier on 2015/6/3.
 */
public abstract class AbsDialogFactory {
	protected final static String DIALOG_TAG = "DIALOG";

	protected FragmentActivity fragmentActivity;
	protected String title;
	protected String message;
	protected String actionPositiveText;
	protected String actionNegativeText;

	AbsDialogFactory(FragmentActivity fragmentActivity, String title, String message, String actionPositiveText, String actionNegativeText) {
		this.fragmentActivity = fragmentActivity;
		this.title = title;
		this.message = message;
		this.actionPositiveText = actionPositiveText;
		this.actionNegativeText = actionNegativeText;
	}

	protected void showDialog(FragmentActivity fragmentActivity, DialogFragment dialog, Intent intent) {
		FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		Fragment prev = fragmentManager.findFragmentByTag(DIALOG_TAG);

		if (intent != null) {
			dialog.setArguments(intent.getExtras());
		}

		if (prev != null) {
			fragmentTransaction.remove(prev);
		}

		dialog.show(fragmentTransaction, DIALOG_TAG);
	}

	protected abstract DialogFragment createDialog(IDialogActionListener actionPositiveEventListener);

	public void demonstrateCommonDialog(IDialogActionListener actionPositiveEventListener) {
		DialogFragment dialogFragment = this.createDialog(actionPositiveEventListener);
		this.showDialog(fragmentActivity, dialogFragment, null);
	}
}
