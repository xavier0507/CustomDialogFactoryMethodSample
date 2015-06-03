package com.example.dialogfactory.dialogs.base;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.Window;

/**
 * Created by Xavier on 2015/6/3.
 */
public abstract class BaseDialogFragment extends DialogFragment {
	public final static String DIALOG_TITLE = "DIALOG_TITLE";
	public final static String DIALOG_MESSAGE = "DIALOG_MESSAGE";
	public final static String DIALOG_POSITIVE_ACTION = "DIALOG_POSITIVE_ACTION";
	public final static String DIALOG_NEGATIVE_ACTION = "DIALOG_NEGATIVE_ACTION";

	protected String title;
	protected String message;
	protected String positiveAction;
	protected String negativeAction;
	protected IDialogActionListener commonDialogActionListener;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (this.getArguments() != null) {
			this.title = this.getArguments().getString(DIALOG_TITLE);
			this.message = this.getArguments().getString(DIALOG_MESSAGE);
			this.positiveAction = this.getArguments().getString(DIALOG_POSITIVE_ACTION);
			this.negativeAction = this.getArguments().getString(DIALOG_NEGATIVE_ACTION);
		}
	}

	public void setCommonDialogActionListener(IDialogActionListener commonDialogActionListener) {
		this.commonDialogActionListener = commonDialogActionListener;
	}

	protected void adjustDialogBackground() {
		Window window = getDialog().getWindow();
		window.requestFeature(Window.FEATURE_NO_TITLE);
		window.setBackgroundDrawableResource(android.R.color.transparent);
		window.setGravity(Gravity.CENTER);
	}
}
