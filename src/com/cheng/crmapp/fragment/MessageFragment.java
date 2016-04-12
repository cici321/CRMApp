package com.cheng.crmapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cheng.crmapp.BaseFragment;
import com.cheng.crmapp.R;

/**
 * Created by cici on 16/3/31.
 */
public class MessageFragment extends BaseFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView=inflater.inflate(R.layout.fragment_message,container,false);
        return mView;
    }

}
