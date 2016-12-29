package com.example.group.teamproject1.common;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {

    private Unbinder mUnbinder;


    protected RequestQueue mRequestQueue;



    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View ret = inflater.inflate( getLayoutId(), container, false);

        //初始化ButterKnife
        mUnbinder = ButterKnife.bind(this,ret);

        //初始化RequestQueue
        mRequestQueue =  Volley
                .newRequestQueue(getContext());

        //初始化View
        initView(ret);

        //初始化事件
        initEvent();

        //初始化数据
        initData();


        return ret;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mUnbinder.unbind();
    }

    //返回layoutId
    protected abstract  int getLayoutId();

    protected  abstract  void initView(View ret);

    protected abstract void initEvent();


    protected  abstract  void initData();






}
