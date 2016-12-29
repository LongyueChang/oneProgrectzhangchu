package com.example.group.teamproject1.module.cookbook.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by kongalong on 2016/12/12.
 */
public class CookbookViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mCookbookDatas;
    private String[] mTitles;

    public CookbookViewPagerAdapter(FragmentManager supportFragmentManager, List<Fragment> cookbookDatas, String[] tiltes) {
        super(supportFragmentManager);

        this.mCookbookDatas = cookbookDatas;
        this.mTitles = tiltes;
    }

    @Override
    public Fragment getItem(int position) {
        return mCookbookDatas.get(position);
    }

    @Override
    public int getCount() {
        return mCookbookDatas!=null?mCookbookDatas.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

}
