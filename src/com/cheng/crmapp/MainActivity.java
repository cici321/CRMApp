package com.cheng.crmapp;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.cheng.crmapp.adapter.MainMenuAdapter;
import com.cheng.crmapp.fragment.CRMFragment;
import com.cheng.crmapp.fragment.HomeFragment;
import com.cheng.crmapp.fragment.MessageFragment;
import com.cheng.crmapp.fragment.MineFragment;
import com.cheng.crmapp.model.MenuModel;

public class MainActivity extends BaseActivity {

	private GridView mMenuGrid;
	private MainMenuAdapter mMainMenuAdapter;

	private List<MenuModel> mMenuList = new ArrayList<MenuModel>();

	// private FrameLayout mFrameLayout;

	private HomeFragment mHomeFragment;
	private CRMFragment mCRMFragment;
	private MessageFragment mMessageFragment;
	private MineFragment mMineFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		initView();
	}

	private void initView() {
		mMenuGrid = (GridView) findViewById(R.id.content_frame_grid);
		mMenuList.add(new MenuModel(R.drawable.tab_home, R.drawable.tab_home_select, "首页"));
		mMenuList.add(new MenuModel(R.drawable.tab_work_tools, R.drawable.tab_work_tools_select, "客户"));
		mMenuList.add(new MenuModel(R.drawable.tab_work_tools, R.drawable.tab_work_tools_select, "消息"));
		mMenuList.add(new MenuModel(R.drawable.tab_mine, R.drawable.tab_mine_select, "我"));

		mMainMenuAdapter = new MainMenuAdapter(mMenuList, MainActivity.this);
		mMenuGrid.setAdapter(mMainMenuAdapter);

		showView(0);

		mMenuGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				mMainMenuAdapter.setSelectItem(position);
				showView(position);
			}
		});
	}

	private void hideFragments(FragmentTransaction transaction) {
		if (null != mHomeFragment) {
			transaction.hide(mHomeFragment);
		}
		if (null != mCRMFragment) {
			transaction.hide(mCRMFragment);
		}
		if (null != mMessageFragment) {
			transaction.hide(mMessageFragment);
		}
		if (null != mMineFragment) {
			transaction.hide(mMineFragment);
		}

	}

	public void switchContent(FragmentTransaction transaction, int index) {
		switch (index) {

		case 0:
			if (null != mHomeFragment) {
				transaction.show(mHomeFragment);
			} else {
				mHomeFragment = new HomeFragment();

				transaction.add(R.id.content_frame, mHomeFragment);

			}

			break;
		case 1:

			if (null != mCRMFragment) {
				transaction.show(mCRMFragment);
			} else {
				mCRMFragment = new CRMFragment();// new MessageFragment();
				transaction.add(R.id.content_frame, mCRMFragment);

			}

			break;
		case 2:

			if (null != mMessageFragment) {
				transaction.show(mMessageFragment);
			} else {
				mMessageFragment = new MessageFragment();// new
															// MessageFragment();
				transaction.add(R.id.content_frame, mMessageFragment);

			}

			break;

		case 3:
			if (null != mMineFragment) {
				transaction.show(mMineFragment);
			} else {
				mMineFragment = new MineFragment();
				transaction.add(R.id.content_frame, mMineFragment);
			}
			break;

		}

		transaction.commitAllowingStateLoss();

	}

	private void showView(int index) {
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		hideFragments(fragmentTransaction);
		switchContent(fragmentTransaction, index);
	}

}
