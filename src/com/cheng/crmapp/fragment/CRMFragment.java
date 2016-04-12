package com.cheng.crmapp.fragment;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.cheng.crmapp.BaseFragment;
import com.cheng.crmapp.R;
import com.cheng.crmapp.adapter.CrmListAdapter;
import com.cheng.crmapp.model.CrmModel;
import com.cheng.pull.lib.PullToRefreshListView;

/**
 * Created by cici on 16/3/31.
 */
public class CRMFragment extends BaseFragment {
	private TextView changetypeBut;
	private TextView mtitleName;
	private PullToRefreshListView mPullToRefreshListView;
	private ListView mListView;
	private CrmListAdapter mCrmListAdapter;
	private List<CrmModel> mCrmList = new ArrayList<CrmModel>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View mView = inflater.inflate(R.layout.fragment_crm, container, false);
		init(mView);
		return mView;
	}

	private void init(View mView) {
		mtitleName=(TextView) mView.findViewById(R.id.title_text);
		mtitleName.setText("客户列表");
		
		changetypeBut=(TextView) mView.findViewById(R.id.crm_change_but);
		mPullToRefreshListView = (PullToRefreshListView) mView.findViewById(R.id.crm_listview);
		mListView = mPullToRefreshListView.getRefreshableView();
		mListView.setDivider(new ColorDrawable(0xf3f3f3));
		mListView.setDividerHeight(1);
		
		
		
		for (int i = 0; i < 10; i++) {
			mCrmList.add(new CrmModel());
		}
		mCrmListAdapter = new CrmListAdapter(mCrmList, getActivity());
		mListView.setAdapter(mCrmListAdapter);
		
		changetypeBut.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ChangeTypeFragmentDialog mDialog=ChangeTypeFragmentDialog.newInstance(1);
				mDialog.show(getFragmentManager(), "dialog");
			}
		});
	}
	
	

}
