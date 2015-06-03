package com.example.dialogfactory.dialogs.base;

import android.app.Dialog;

/**
 * Created by Xavier on 2015/6/3.
 */
public interface IDialogActionListener {
	void onPositiveActionClick(Dialog dialog);

	void onNegativeActionClick(Dialog dialog);
}
