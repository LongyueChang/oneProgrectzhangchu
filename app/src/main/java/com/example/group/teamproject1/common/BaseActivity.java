package com.example.group.teamproject1.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder mUnbinder;

    protected RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //隐藏actionbar
        getSupportActionBar().hide();



        setContentView(getLayoutId());

        //初始化ButterKnife
        mUnbinder = ButterKnife.bind(this);

        //初始化RequestQueue
        mRequestQueue =  Volley
                .newRequestQueue(this);

        //初始化View
        initView();

        //初始化事件
        initEvent();

        //初始化数据
        initData();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mUnbinder.unbind();

    }

    //返回layoutId
    protected abstract  int getLayoutId();


    protected  abstract void initView();


    protected abstract void initEvent();


    protected  abstract void initData();


}
