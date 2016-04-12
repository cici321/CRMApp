/*AUTO-GENERATED FILE.  DO NOT MODIFY.
 * 项目名称：	PltsForPad   
 * @DESCRIPTION: 
 * Copyright 	BF Corporation 2015   
 * 版权所有  
 *    
 */
package com.cheng.crmapp.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import com.cheng.crmapp.R;
import com.cheng.crmapp.util.AppUtil;

/*******************************************
 * 
 * @AUTHOR: CiCi
 * @VERSION: v1.0.1
 * @DATE: 2015-3-17 下午4:08:40
 *******************************************/
public class ChangeTypeFragmentDialog extends DialogFragment {

	private TextView mMySelfBut;
	private TextView mMySubordinateBut;
	private TextView mCancelBut;
	private int typeId;

	public static ChangeTypeFragmentDialog newInstance(int typeId) {
		ChangeTypeFragmentDialog newFragment = new ChangeTypeFragmentDialog();
		Bundle bundle = new Bundle();
		bundle.putInt("typeId", typeId);
		newFragment.setArguments(bundle);
		return newFragment;

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle args = getArguments();
		if (args != null) {
			typeId = args.getInt("typeId");
		}
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		Window mWindow = getDialog().getWindow();
		mWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		// mWindow.setBackgroundDrawable( new ColorDrawable( 0xff000000 ) );
		mWindow.setGravity(Gravity.BOTTOM);
		mWindow.setWindowAnimations(R.style.myDialog);
		mWindow.setLayout(AppUtil.getScreenWidth(getActivity()), mWindow.getAttributes().height);
		this.setCancelable(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

		View mView = inflater.inflate(R.layout.view_dialog_list, container, false);
		initView(mView);

		return mView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		setListen();

	}

	public void initView(View mView) {
		// TODO Auto-generated method stub
		
		mMySelfBut=(TextView) mView.findViewById(R.id.crm_dialog_myself);
		mMySubordinateBut=(TextView) mView.findViewById(R.id.crm_dialog_subordinate);
		mCancelBut=(TextView) mView.findViewById(R.id.crm_dialog_cancel);

	}

	public void setListen() {
		// TODO Auto-generated method stub
		mMySelfBut.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dismiss();
			}
		});
		mMySubordinateBut.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dismiss();
			}
		});
		mCancelBut.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dismiss();
			}
		});

	}

}
