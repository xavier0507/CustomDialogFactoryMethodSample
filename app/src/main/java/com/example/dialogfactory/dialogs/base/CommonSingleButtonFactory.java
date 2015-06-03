package com.example.dialogfactory.dialogs.base;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

import com.example.dialogfactory.dialogs.CommonSingleButtonDialog;

/**
 * Created by Xavier on 2015/6/3.
 */
public class CommonSingleButtonFactory extends AbsDialogFactory {
	public CommonSingleButtonFactory(FragmentActivity fragmentActivity, String title, String message, String actionPositiveText, String actionNegativeText) {
		super(fragmentActivity, title, message, actionPositiveText, actionNegativeText);
	}

	@Override
	protected DialogFragment createDialog(IDialogActionListener actionPositiveEventListener) {
		CommonSingleButtonDialog commonSingleButtonDialog = new CommonSingleButtonDialog();

		Bundle bundle = new Bundle();
		bundle.putString(BaseDialogFragment.DIALOG_TITLE, this.title);
		bundle.putString(BaseDialogFragment.DIALOG_MESSAGE, this.message);
		bundle.putString(BaseDialogFragment.DIALOG_POSITIVE_ACTION, this.actionPositiveText);
		bundle.putString(BaseDialogFragment.DIALOG_NEGATIVE_ACTION, this.actionNegativeText);

		commonSingleButtonDialog.setCancelable(true);
		commonSingleButtonDialog.setArguments(bundle);
		commonSingleButtonDialog.setCommonDialogActionListener(actionPositiveEventListener);

		return commonSingleButtonDialog;
	}
}
