package com.example.group.teamproject1.fragments;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.group.teamproject1.R;
import com.example.group.teamproject1.common.BaseFragment;
import com.example.group.teamproject1.module.cookbook.CookbookClassifyFragment;
import com.example.group.teamproject1.module.cookbook.CookbookFoodMaterialFragment;
import com.example.group.teamproject1.module.cookbook.CookbookRecommendFragment;
import com.example.group.teamproject1.module.cookbook.adapter.CookbookViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.example.group.teamproject1.common.constant.Constant.REQUEST_CODE;
import static com.example.group.teamproject1.common.constant.Constant.RESULT_CODE;

/**
 * A simple {@link Fragment} subclass.
 */
public class CookbookFragment extends BaseFragment {

    @BindView(R.id.cookbook_tab_layout)
     TabLayout mTabLayout;

    @BindView(R.id.cookbook_view_pager)
     ViewPager mViewPager;

    private List<Fragment> mCookbookDatas;
    private Object mCookRecomeFragment;
    private FragmentManager mManager;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cookbook;
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

        mCookbookDatas = new ArrayList<>();

        mCookbookDatas.add(new CookbookRecommendFragment());
        mCookbookDatas.add(new CookbookFoodMaterialFragment());
        mCookbookDatas.add(new CookbookClassifyFragment());

        String[] tiltes = getActivity().getResources().getStringArray(R.array.cook_book_tab_title);

        mManager = getActivity().
                getSupportFragmentManager();

        FragmentPagerAdapter adapter = new CookbookViewPagerAdapter
                (mManager,mCookbookDatas,tiltes);

        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_CODE) {
            gotCookRecomeFragment();
        }

    }

    private void gotCookRecomeFragment() {
        mManager = getActivity().getSupportFragmentManager();
        CookbookRecommendFragment recommendFragment = new CookbookRecommendFragment();
        mManager.beginTransaction().replace(R.id.cookRecommend_layout,recommendFragment).commit();

    }
}
