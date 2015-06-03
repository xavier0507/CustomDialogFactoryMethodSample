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
 * Created by Xavier on 2015/6/2.
 */
public class CommonSingleButtonProgressDialog extends BaseDialogFragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.dialog_common_single_button_progress, null);

		this.adjustDialogBackground();

		TextView commonSingleTitleText = (TextView) view.findViewById(R.id.text_common_single_title);
		TextView commonSingleActionBtn = (TextView) view.findViewById(R.id.text_common_single_action);

		if (!TextUtils.isEmpty(this.title)) {
			commonSingleTitleText.setVisibility(View.VISIBLE);
			commonSingleTitleText.setText(this.title);
		}

		if (!TextUtils.isEmpty(this.positiveAction)) {
			commonSingleActionBtn.setVisibility(View.VISIBLE);
			commonSingleActionBtn.setText(this.positiveAction);

			commonSingleActionBtn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					commonDialogActionListener.onPositiveActionClick(getDialog());
				}
			});
		}

		return view;
	}
}
