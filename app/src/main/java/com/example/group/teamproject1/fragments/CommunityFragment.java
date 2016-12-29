package com.example.group.teamproject1.fragments;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.group.teamproject1.R;
import com.example.group.teamproject1.common.BaseFragment;
import com.example.group.teamproject1.module.community.CommunityFocusFragment;
import com.example.group.teamproject1.module.community.CommunityNewestFragment;
import com.example.group.teamproject1.module.community.CommunityRecommendFragment;
import com.example.group.teamproject1.module.community.adapter.CommunityViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CommunityFragment extends BaseFragment {


    @BindView(R.id.community_tab_layout)
    TabLayout mTabLayout;

    @BindView(R.id.community_view_pager)
    ViewPager mViewPager;


    private List<Fragment> mCommunityDatas;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_community;
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

        mCommunityDatas = new ArrayList<>();

        mCommunityDatas.add(new CommunityFocusFragment());
        mCommunityDatas.add(new CommunityRecommendFragment());
        mCommunityDatas.add(new CommunityNewestFragment());

        String[] tiltes = getActivity().getResources().getStringArray(R.array.community_tab_title);

        FragmentManager supportFragmentManager = getActivity().
                getSupportFragmentManager();

        FragmentPagerAdapter adapter = new CommunityViewPagerAdapter
                (supportFragmentManager,mCommunityDatas,tiltes);

        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);

    }


}
