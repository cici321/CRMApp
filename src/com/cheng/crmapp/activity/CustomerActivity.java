package com.cheng.crmapp.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.TextView;

import com.cheng.crmapp.BaseActivity;
import com.cheng.crmapp.R;
import com.cheng.crmapp.adapter.UserListAdapter;
import com.cheng.crmapp.model.UserModel;
import com.cheng.crmapp.util.UserComparator;
import com.cheng.crmapp.widget.IndexedSideBar;

public class CustomerActivity extends BaseActivity implements UserListAdapter.OnItemClickEventListener {
	
	private TextView mTitleText;

	private List<UserModel> data = new ArrayList<UserModel>();

	private RecyclerView recyclerView = null;
	private UserListAdapter adapter = null;

	private IndexedSideBar sideBar = null;
	private TextView sideDialog = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contacts);
		initView();
	}

	private void initView() {
		
		mTitleText=(TextView) findViewById(R.id.title_text);
		mTitleText.setText("联系人");


		data.add(new UserModel("阿牛", "aniu"));
		data.add(new UserModel("阿苍", "acang"));
		data.add(new UserModel("阿杜", "adu"));
		data.add(new UserModel("百度", "baidu"));
		data.add(new UserModel("阿里", "ali"));
		data.add(new UserModel("胡喝", "huhe"));
		data.add(new UserModel("刀乐", "daole"));
		data.add(new UserModel("阿牛", "aniu"));
		data.add(new UserModel("阿苍", "acang"));
		data.add(new UserModel("阿杜", "adu"));
		data.add(new UserModel("百度", "baidu"));
		data.add(new UserModel("阿里", "ali"));
		data.add(new UserModel("胡喝", "huhe"));
		data.add(new UserModel("刀乐", "daole"));
		data.add(new UserModel("阿牛", "aniu"));
		data.add(new UserModel("阿苍", "acang"));
		data.add(new UserModel("阿杜", "adu"));
		data.add(new UserModel("百度", "baidu"));
		data.add(new UserModel("阿里", "ali"));
		data.add(new UserModel("胡喝", "huhe"));
		data.add(new UserModel("刀乐", "daole"));
		data.add(new UserModel("阿牛", "aniu"));
		data.add(new UserModel("阿苍", "acang"));
		data.add(new UserModel("阿杜", "adu"));
		data.add(new UserModel("百度", "baidu"));
		data.add(new UserModel("阿里", "ali"));
		data.add(new UserModel("胡喝", "huhe"));
		data.add(new UserModel("刀乐", "daole"));

		recyclerView = (RecyclerView) findViewById(R.id.contacts);
		LinearLayoutManager mLLM = new LinearLayoutManager(CustomerActivity.this);
		mLLM.setOrientation(LinearLayoutManager.VERTICAL);
		recyclerView.setLayoutManager(mLLM);

		filterEmptyStr();
		Collections.sort(data, new UserComparator());
		adapter = new UserListAdapter(CustomerActivity.this, true);
		adapter.setAdapterData(data);
		recyclerView.setAdapter(adapter);
		adapter.notifyDataSetChanged();
		adapter.setOnItemClickEventListener(this);

		// recyclerView.addItemDecoration(new
		// HorizontalDividerItemDecoration.Builder(getActivity()).margin((int)
		// ScreenUtils.dpToPx(getActivity(), 10), (int)
		// ScreenUtils.dpToPx(getActivity(), 25)).build());

		// 初始化边栏
		sideBar = (IndexedSideBar) findViewById(R.id.sidebar);
		sideDialog = (TextView) findViewById(R.id.dialog);
		sideBar.setTextView(sideDialog);

		sideBar.setOnTouchingLetterChangedListener(new IndexedSideBar.OnTouchingLetterChangedListener() {

			@Override
			public void onTouchingLetterChanged(String s) {

				int position = adapter.getPositionForSection(s.charAt(0));
				if (position != -1) {
					recyclerView.scrollToPosition(position);
				}

			}
		});

	}

	public void filterEmptyStr() {

		if (null == data || data.size() == 0)
			return;
		for (int i = 0; i < data.size(); i++) {
			if (TextUtils.isEmpty(data.get(i).nickname_py)) {
				UserModel user = data.get(i);
				user.nickname_py = "#";
				data.set(i, user);
			}
		}

	}

	@Override
	public void onItemClick(int position) {

		if (null != data) {
			Intent intent = new Intent(getApplicationContext(), ContactInfoActivity.class);
			startActivity(intent);

		}

	}

	@Override
	public void onItemLongClick(int position) {

	}

}
