package com.example.dialogfactory.dialogs;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dialogfactory.R;
import com.example.dialogfactory.dialogs.base.BaseDialogFragment;

/**
 * Created by Xavier on 2015/6/3.
 */
public class CommonDoubleButtonDialog extends BaseDialogFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.dialog_common_double_button, null);

		this.adjustDialogBackground();

		TextView commonDoubleTitleText = (TextView) view.findViewById(R.id.text_common_double_title);
		TextView commonDoubleLessMessageText = (TextView) view.findViewById(R.id.text_common_double_less_message);
		TextView commonDoubleMoreMessageText = (TextView) view.findViewById(R.id.text_common_double_more_message);
		TextView commonDoublePositiveActionBtn = (TextView) view.findViewById(R.id.text_common_double_positive_action);
		TextView commonDoubleNegativeActionBtn = (TextView) view.findViewById(R.id.text_common_double_negative_action);

		if (!TextUtils.isEmpty(this.title)) {
			commonDoubleTitleText.setVisibility(View.VISIBLE);
			commonDoubleTitleText.setText(this.title);
		}

		if (!TextUtils.isEmpty(this.message)) {
			if (this.message.length() < 10) {
				commonDoubleLessMessageText.setVisibility(View.VISIBLE);
				commonDoubleLessMessageText.setText(this.message);
				commonDoubleMoreMessageText.setVisibility(View.GONE);
			} else {
				commonDoubleMoreMessageText.setVisibility(View.VISIBLE);
				commonDoubleMoreMessageText.setText(this.message);
				commonDoubleLessMessageText.setVisibility(View.GONE);
			}
		}

		if (!TextUtils.isEmpty(this.positiveAction)) {
			commonDoublePositiveActionBtn.setVisibility(View.VISIBLE);
			commonDoublePositiveActionBtn.setText(this.positiveAction);

			commonDoublePositiveActionBtn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					commonDialogActionListener.onPositiveActionClick(getDialog());
				}
			});
		}

		if (!TextUtils.isEmpty(this.negativeAction)) {
			commonDoubleNegativeActionBtn.setVisibility(View.VISIBLE);
			commonDoubleNegativeActionBtn.setText(this.negativeAction);

			commonDoubleNegativeActionBtn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					commonDialogActionListener.onNegativeActionClick(getDialog());
				}
			});
		}

		return view;
	}
}
