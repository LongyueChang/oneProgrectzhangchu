package com.example.group.teamproject1.module.happylife.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by kongalong on 2016/12/12.
 */
public class HappyLifeViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mHappyLifeDatas;
    private String[] mTitles;

    public HappyLifeViewPagerAdapter(FragmentManager supportFragmentManager, List<Fragment> happyLifeDatas, String[] tiltes) {
        super(supportFragmentManager);

        this.mHappyLifeDatas = happyLifeDatas;
        this.mTitles = tiltes;
    }

    @Override
    public Fragment getItem(int position) {
        return mHappyLifeDatas.get(position);
    }

    @Override
    public int getCount() {
        return mHappyLifeDatas!=null?mHappyLifeDatas.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
