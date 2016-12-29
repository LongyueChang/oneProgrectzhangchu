package com.example.group.teamproject1.fragments;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.group.teamproject1.R;
import com.example.group.teamproject1.common.BaseFragment;
import com.example.group.teamproject1.module.happylife.adapter.HappyLifeViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HappyLifeFragment extends BaseFragment {

    @BindView(R.id.happylife_tab_layout)
     TabLayout mTabLayout;

    @BindView(R.id.happylife_view_pager)
     ViewPager mViewPager;

    private List<Fragment> mHappyLifeDatas;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_happy_life;
    }



    //在这初始化view
    @Override
    protected void initView(View ret) {



    }
    //在这初始化事件
    @Override
    protected void initEvent() {

    }

    //在这初始化数据
    @Override
    protected void initData() {

        mHappyLifeDatas = new ArrayList<>();

//        mHappyLifeDatas.add(new HappyLifeCateFragment());
//        mHappyLifeDatas.add(new HappyLifeHealthFragment());


        String[] tiltes = getActivity().getResources().getStringArray(R.array.happy_life_tab_title);

        FragmentManager supportFragmentManager = getActivity().
                getSupportFragmentManager();

        FragmentPagerAdapter adapter = new HappyLifeViewPagerAdapter
                (supportFragmentManager,mHappyLifeDatas,tiltes);

        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);
    }




}
