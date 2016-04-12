/*AUTO-GENERATED FILE.  DO NOT MODIFY.
 * 项目名称：	FamilyFun   
 * @DESCRIPTION: 
 * Copyright 	BF Corporation 2015   
 * 版权所有  
 *    
 */
package com.cheng.crmapp.adapter;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheng.crmapp.R;
import com.cheng.crmapp.model.MenuModel;
import com.cheng.crmapp.util.AppUtil;


/*******************************************
 * @COMPANY: 武汉早点科技技术有限责任公司
 * @CLASS: ActionAdapter
 * @DESCRIPTION:
 * @AUTHOR: CiCi
 * @VERSION: v1.0.1
 * @DATE: 2015-6-8 下午6:24:15
 *******************************************/
public class MainMenuAdapter extends BaseAdapter {
	private List<MenuModel> mActionList;
	private Activity mContext;
	private int selectItem = 0;

	public MainMenuAdapter(List<MenuModel> mActionList, Activity mContext) {
		super();
		this.mActionList = mActionList;
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mActionList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mActionList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public int getSelectItem() {
		return selectItem;
	}

	public void setSelectItem(int selectItem) {
		this.selectItem = selectItem;
		notifyDataSetChanged();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_menu_grid, parent, false);
		}

		final ImageView goodsImage = AppUtil.ViewHolder.get(convertView, R.id.main_menu_image);
		TextView titleText = AppUtil.ViewHolder.get(convertView, R.id.main_menu_text);

		MenuModel mMenu = mActionList.get(position);

		titleText.setText(mMenu.getName());

		if (selectItem == position) {
			goodsImage.setImageResource(mMenu.getSelectImage());

//			convertView.setBackgroundResource(R.drawable.footer_bg);
		} else {
			goodsImage.setImageResource(mMenu.getImage());
	
		}

		return convertView;
	}

}
