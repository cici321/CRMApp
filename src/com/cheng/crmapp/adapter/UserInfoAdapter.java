/*AUTO-GENERATED FILE.  DO NOT MODIFY.
 * 项目名称：	FamilyFun   
 * @DESCRIPTION: 
 * Copyright 	BF Corporation 2015   
 * 版权所有  
 *    
 */
package com.cheng.crmapp.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cheng.crmapp.R;
import com.cheng.crmapp.model.MineContentModel;
import com.cheng.crmapp.widget.RoundImageView;

/*******************************************
 * @COMPANY: 武汉早点科技技术有限责任公司
 * @CLASS: MineContentAdapter
 * @DESCRIPTION:
 * @AUTHOR: CiCi
 * @VERSION: v1.0.1
 * @DATE: 2015-6-9 下午4:16:06
 *******************************************/
public class UserInfoAdapter extends BaseAdapter {
	private List<MineContentModel> mContentList;
	private Context mContext;

	public UserInfoAdapter(List<MineContentModel> mContentList, Context mContext) {
		super();
		this.mContentList = mContentList;
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mContentList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mContentList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		MineContentModel mModel = mContentList.get(position);
		if (mModel.type == 1) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.view_user_info1, null);

			RoundImageView mHeardImage = (RoundImageView) convertView.findViewById(R.id.user_info_image);

		} else if (mModel.type == 3) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.view_user_info3, null);
		} else {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.view_user_info2, null);
			TextView mKey = (TextView) convertView.findViewById(R.id.user_info_key);
			ImageView mForward = (ImageView) convertView.findViewById(R.id.user_info_forward);
			TextView mName = (TextView) convertView.findViewById(R.id.user_info_value);
			mKey.setText(mModel.key);
			mName.setText(mModel.name);
			if (mModel.isShow) {
				mForward.setVisibility(View.VISIBLE);
			} else {
				mForward.setVisibility(View.GONE);
			}
		}
		return convertView;
	}

}
