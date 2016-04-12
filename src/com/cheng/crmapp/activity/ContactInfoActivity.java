package com.cheng.crmapp.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.cheng.crmapp.BaseActivity;
import com.cheng.crmapp.R;
import com.cheng.crmapp.adapter.ContactInfoAdapter;
import com.cheng.crmapp.model.Model;

/**
 * Created by cici on 16/3/31.
 */
public class ContactInfoActivity extends BaseActivity {

	private TextView mTitleText;
	private ListView mContentListView;
	private ContactInfoAdapter mContactInfoAdapter;
	private List<Model> mModelList = new ArrayList<Model>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_info);
		initView();
	}

	private void initView() {
		mTitleText = (TextView) findViewById(R.id.title_text);
		mTitleText.setText("联系人详情");
		mContentListView = (ListView) findViewById(R.id.contact_info_list);

		mModelList.add(new Model("性别", "男"));
		mModelList.add(new Model("年龄", "23"));
		mModelList.add(new Model("身份证号", "352664547747"));
		mModelList.add(new Model("联系电话", "027-35363636"));
		mModelList.add(new Model("职务", "销售总经理"));
		mModelList.add(new Model("邮箱", "42423323@qq.com"));
		mModelList.add(new Model("QQ", "3534535353"));
		mModelList.add(new Model("备注", "我们为客户提供专业的界面方案，网站视觉设计，视觉包装，服务项目涵盖了桌面平台、互联网服务以及电子消费产品等"));

		mContactInfoAdapter = new ContactInfoAdapter(mModelList, ContactInfoActivity.this);
		mContentListView.setAdapter(mContactInfoAdapter);

	}

}
