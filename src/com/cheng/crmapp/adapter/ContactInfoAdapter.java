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
import android.widget.TextView;

import com.cheng.crmapp.R;
import com.cheng.crmapp.model.Model;
import com.cheng.crmapp.util.AppUtil;

/*******************************************
 * @COMPANY: 武汉早点科技技术有限责任公司
 * @CLASS: ActionAdapter
 * @DESCRIPTION:
 * @AUTHOR: CiCi
 * @VERSION: v1.0.1
 * @DATE: 2015-6-8 下午6:24:15
 *******************************************/
public class ContactInfoAdapter extends BaseAdapter {
	private List<Model> mActionList;
	private Activity mContext;
	private int selectItem = 0;

	public ContactInfoAdapter(List<Model> mActionList, Activity mContext) {
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
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_contact_info_list, parent, false);
		}

		TextView keyText = AppUtil.ViewHolder.get(convertView, R.id.item_info_key);
		TextView valueText = AppUtil.ViewHolder.get(convertView, R.id.item_info_value);

		Model mMenu = mActionList.get(position);

		keyText.setText(mMenu.key);
		valueText.setText(mMenu.value);

		return convertView;
	}

}
