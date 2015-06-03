package com.example.dialogfactory.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.dialogfactory.R;
import com.example.dialogfactory.dialogs.base.AbsDialogFactory;
import com.example.dialogfactory.dialogs.base.CommonDoubleButtonFactory;
import com.example.dialogfactory.dialogs.base.CommonSingleButtonFactory;
import com.example.dialogfactory.dialogs.base.CommonSingleButtonProgressFactory;
import com.example.dialogfactory.dialogs.base.IDialogActionListener;

/**
 * Created by Xavier on 2015/6/4.
 */
public class MainFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);

		Button singleButton = (Button) rootView.findViewById(R.id.btn_main_show_double_btn_dialog);
		singleButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AbsDialogFactory factory = new CommonSingleButtonFactory(
						getActivity(),
						getString(R.string.custom_dialog_text_login_title),
						getString(R.string.custom_dialog_text_login_message),
						getString(R.string.action_ok),
						"");

				factory.demonstrateCommonDialog(new IDialogActionListener() {
					@Override
					public void onPositiveActionClick(Dialog dialog) {
						Toast.makeText(getActivity(), getString(R.string.action_ok), Toast.LENGTH_LONG).show();
					}

					@Override
					public void onNegativeActionClick(Dialog dialog) {
					}
				});
			}
		});

		Button doubleButton = (Button) rootView.findViewById(R.id.btn_main_show_single_btn_dialog);
		doubleButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AbsDialogFactory factory = new CommonDoubleButtonFactory(
						getActivity(),
						getString(R.string.custom_dialog_text_login_title),
						getString(R.string.custom_dialog_text_login_message),
						getString(R.string.action_ok),
						getString(R.string.action_cancel));

				factory.demonstrateCommonDialog(new IDialogActionListener() {
					@Override
					public void onPositiveActionClick(Dialog dialog) {
						Toast.makeText(getActivity(), getString(R.string.action_ok), Toast.LENGTH_LONG).show();
					}

					@Override
					public void onNegativeActionClick(Dialog dialog) {
						Toast.makeText(getActivity(), getString(R.string.action_cancel), Toast.LENGTH_LONG).show();
					}
				});
			}
		});

		Button singleProgressButton = (Button) rootView.findViewById(R.id.btn_main_show_single_btn_progress_dialog);
		singleProgressButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				AbsDialogFactory factory = new CommonSingleButtonProgressFactory(
						getActivity(),
						getString(R.string.custom_dialog_text_login_title),
						getString(R.string.custom_dialog_text_login_message),
						getString(R.string.action_ok),
						"");

				factory.demonstrateCommonDialog(new IDialogActionListener() {
					@Override
					public void onPositiveActionClick(Dialog dialog) {
						Toast.makeText(getActivity(), getString(R.string.action_ok), Toast.LENGTH_LONG).show();
					}

					@Override
					public void onNegativeActionClick(Dialog dialog) {
					}
				});
			}
		});

		return rootView;
	}
}
