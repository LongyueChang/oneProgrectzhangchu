package com.example.group.teamproject1.module.community.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by kongalong on 2016/12/12.
 */
public class CommunityViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mCommunityDatas;
    private String[] mTitles;

    public CommunityViewPagerAdapter(FragmentManager supportFragmentManager, List<Fragment> communityDatasDatas, String[] tiltes) {
        super(supportFragmentManager);

        this.mCommunityDatas = communityDatasDatas;
        this.mTitles = tiltes;
    }

    @Override
    public Fragment getItem(int position) {
        return mCommunityDatas.get(position);
    }

    @Override
    public int getCount() {
        return mCommunityDatas!=null?mCommunityDatas.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

}
