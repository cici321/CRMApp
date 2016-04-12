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
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cheng.crmapp.R;
import com.cheng.crmapp.model.CrmModel;
import com.cheng.crmapp.util.AppUtil;

/*******************************************
 * @COMPANY: 武汉早点科技技术有限责任公司
 * @CLASS: ActionAdapter
 * @DESCRIPTION:
 * @AUTHOR: CiCi
 * @VERSION: v1.0.1
 * @DATE: 2015-6-8 下午6:24:15
 *******************************************/
public class CrmListAdapter extends BaseAdapter {
	private List<CrmModel> mActionList;
	private Activity mContext;
	private int selectItem = 0;

	public CrmListAdapter(List<CrmModel> mActionList, Activity mContext) {
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
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_crm_list, parent, false);
		}

		TextView companyText = AppUtil.ViewHolder.get(convertView, R.id.crm_company_name);
		TextView relationText = AppUtil.ViewHolder.get(convertView, R.id.crm_relation_name);
		TextView addressText = AppUtil.ViewHolder.get(convertView, R.id.crm_user_address);
		TextView typeText = AppUtil.ViewHolder.get(convertView, R.id.crm_user_type);
		TextView rankText = AppUtil.ViewHolder.get(convertView, R.id.crm_user_rank);
		TextView telephoneText = AppUtil.ViewHolder.get(convertView, R.id.crm_user_telephone);
		
		addressText.setText(Html.fromHtml("<font color=\"#cdcdd4\">地址：</font><font color=\"#696a6b\">"+"武汉市东湖高新技术开发区武大科技园"+"</font>"));
		typeText.setText(Html.fromHtml("<font color=\"#cdcdd4\">类型：</font><font color=\"#696a6b\">"+"工厂"+"</font>"));
		rankText.setText(Html.fromHtml("<font color=\"#cdcdd4\">客户级别：</font><font color=\"#696a6b\">"+"大客户"+"</font>"));
		telephoneText.setText(Html.fromHtml("<font color=\"#cdcdd4\">单位电话：</font><font color=\"#696a6b\">"+"027-3464366"+"</font>"));

//		CrmModel mCrmModel = mActionList.get(position);
//		companyText.setText(mCrmModel.company);
//		relationText.setText(mCrmModel.relationName);
//		addressText.setText(mCrmModel.address);
//		typeText.setText(mCrmModel.type);
//		rankText.setText(mCrmModel.rank);
//		telephoneText.setText(mCrmModel.telephone);

		return convertView;
	}
}
