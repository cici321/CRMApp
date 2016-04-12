package com.cheng.crmapp.fragment;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.cheng.crmapp.BaseFragment;
import com.cheng.crmapp.R;
import com.cheng.crmapp.activity.CustomerActivity;
import com.cheng.crmapp.model.HomeMonthModel;
import com.cheng.crmapp.model.MenuModel;
import com.cheng.crmapp.util.AppUtil;

/**
 * Created by cici on 16/3/31.
 */
public class HomeFragment extends BaseFragment {

	private TextView mMessageText;
	private LinearLayout mHomeMenuLL;
	private GridView mMonthDataGrid;

	private List<MenuModel> mHomeMenuList = new ArrayList<MenuModel>();

	private List<HomeMonthModel> mMonthDataList = new ArrayList<HomeMonthModel>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View mView = inflater.inflate(R.layout.fragment_home, container, false);
		initView(mView);
		return mView;
	}

	private void initView(View mView) {

		mMessageText = (TextView) mView.findViewById(R.id.home_message);
		mHomeMenuLL = (LinearLayout) mView.findViewById(R.id.home_menu_ll);
		mMonthDataGrid = (GridView) mView.findViewById(R.id.home_month_data);

		Drawable leftDrawable = getResources().getDrawable(R.drawable.ic_launcher);
		leftDrawable.setBounds(0, 0, 30, 30);
		mMessageText.setCompoundDrawables(leftDrawable, null, null, null);

		mHomeMenuList.add(new MenuModel(0, "客户列表"));
		mHomeMenuList.add(new MenuModel(0, "添加客户"));
		mHomeMenuList.add(new MenuModel(0, "拜访记录"));
		mHomeMenuList.add(new MenuModel(0, "联系人"));

		addHomeMenu();

		mMonthDataList.add(new HomeMonthModel(0, 3, "新增客户人数"));
		mMonthDataList.add(new HomeMonthModel(0, 2, "新增联系人"));
		mMonthDataList.add(new HomeMonthModel(0, 5, "新增联系人"));
		mMonthDataList.add(new HomeMonthModel(0, 6, "阶段变化的客户"));
		mMonthDataList.add(new HomeMonthModel(0, 23, "新增销售记录"));
		mMonthDataList.add(new HomeMonthModel(0, 5, "新增客户人数"));

		mMonthDataGrid.setAdapter(new MonthDataAdapter());

	}

	private void addHomeMenu() {
		for (int i = 0; i < mHomeMenuList.size(); i++) {
			View mMenu = LayoutInflater.from(getActivity()).inflate(R.layout.item_menu_home, null);
			LinearLayout.LayoutParams mLayoutParams = new LinearLayout.LayoutParams(0, LayoutParams.MATCH_PARENT);
			mLayoutParams.weight = 1.0f;
			mMenu.setLayoutParams(mLayoutParams);
			ImageView mImage = (ImageView) mMenu.findViewById(R.id.home_menu_image);
			TextView mText = (TextView) mMenu.findViewById(R.id.home_menu_text);

			mText.setText(mHomeMenuList.get(i).getName());
			mHomeMenuLL.addView(mMenu);
			
			final int index=i;
			
			mMenu.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					switch (index) {
					case 0:
						
						break;
						
					case 1:
						break;
						
					case 2:
						break;
					case 3:
						Intent intent=new Intent(getActivity(),CustomerActivity.class);
						startActivity(intent);
						break;

					default:
						break;
					}
				}
			});
			
		}
		
	}

	class MonthDataAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mMonthDataList.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return mMonthDataList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			if (convertView == null) {
				convertView = LayoutInflater.from(getActivity()).inflate(R.layout.item_home_month_data, parent, false);
			}

			ImageView mImage = AppUtil.ViewHolder.get(convertView, R.id.home_month_image);
			TextView mNumerText = AppUtil.ViewHolder.get(convertView, R.id.home_month_data_number);
			TextView mNameText = AppUtil.ViewHolder.get(convertView, R.id.home_month_data_name);
			mNumerText.setText(mMonthDataList.get(position).number + "");
			mNameText.setText(mMonthDataList.get(position).name);
			return convertView;
		}

	}

}
