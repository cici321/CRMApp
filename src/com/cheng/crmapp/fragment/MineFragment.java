package com.cheng.crmapp.fragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.cheng.crmapp.BaseFragment;
import com.cheng.crmapp.R;
import com.cheng.crmapp.adapter.UserInfoAdapter;
import com.cheng.crmapp.model.MineContentModel;

/**
 * Created by cici on 16/3/31.
 */
public class MineFragment extends BaseFragment{
	
	private TextView mTitleText;
	private ListView mContentListView;
	private UserInfoAdapter mUserInfoAdapter;
	private List<MineContentModel> mMineList=new ArrayList<MineContentModel>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView=inflater.inflate(R.layout.fragment_mine,container,false);
        initView(mView);
        return mView;
        
        
    }
    
    private void initView(View mView){
    	mTitleText=(TextView) mView.findViewById(R.id.title_text);
    	mTitleText.setText("我的");
    	mContentListView=(ListView) mView.findViewById(R.id.mine_listview);
    	
    	
    	mMineList.add(new MineContentModel(0, "", "头像", "", 1, true));
    	mMineList.add(new MineContentModel(0, "", "姓名", "cici酱", 2, true));
    	mMineList.add(new MineContentModel(0, "", "性别", "男", 2, true));
    	
    	mMineList.add(new MineContentModel(0, "", "", "", 3, true));
    	
    	mMineList.add(new MineContentModel(0, "", "职务", "程序员", 2, true));
    	mMineList.add(new MineContentModel(0, "", "所属部门", "移动开发", 2, true));
    	
    	mMineList.add(new MineContentModel(0, "", "", "", 3, true));
    	
    	mMineList.add(new MineContentModel(0, "", "身份证号", "535336363636363", 2, true));
    	mMineList.add(new MineContentModel(0, "", "手机号", "35352434242", 2, true));
    	mMineList.add(new MineContentModel(0, "", "手机IMEI", "35352434242", 2, false));
    	mMineList.add(new MineContentModel(0, "", "备注", "分身乏术", 2, true));
    	
    	
    	mUserInfoAdapter=new UserInfoAdapter(mMineList, getActivity());
    	mContentListView.setAdapter(mUserInfoAdapter);
    }

}
