package com.example.group.teamproject1;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.group.teamproject1.common.BaseActivity;
import com.example.group.teamproject1.fragments.CommunityFragment;
import com.example.group.teamproject1.fragments.CookbookFragment;
import com.example.group.teamproject1.fragments.HappyLifeFragment;
import com.example.group.teamproject1.fragments.UserFragment;

import butterknife.BindView;
import cn.sharesdk.framework.ShareSDK;

import static com.example.group.teamproject1.common.constant.Constant.REQUEST_CODE;
import static com.example.group.teamproject1.common.constant.Constant.RESULT_CODE;


public class MainActivity extends BaseActivity {

    @BindView(R.id.radioGroup)
    RadioGroup mRadioGroup;

    private Fragment mTempFragment = null;
    private FragmentManager mManager;

    private CookbookFragment mCookbookFragment;
    private CommunityFragment mCommunityFragment;
    private HappyLifeFragment mHappyLifeFragment;
    private UserFragment mUserFragment;



    @Override
    protected int getLayoutId() {
        ShareSDK.initSDK(getBaseContext());

        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        //初始化4个fragment
        initFragments();
    }

    @Override
    protected void initEvent() {

        //初始化radiogroup点击事件
        initRadioGroupListener();

    }

    @Override
    protected void initData() {

    }

    private void initRadioGroupListener() {

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch(checkedId){
                    case R.id.cookbook_radioButton:
                        showFragment(mCookbookFragment);
                        break;
                    case R.id.happylife_radioButton:
                        showFragment(mCommunityFragment);
                        break;
                    case R.id.community_radioButton:
                        showFragment(mHappyLifeFragment);
                        break;
                    case R.id.user_radioButton:
                        showFragment(mUserFragment);
                        break;
                    default:
                        break;
                }
            }
        });

    }


    private void initFragments() {

        //创建四个Fragment对象
        mCookbookFragment = new CookbookFragment();
        mCommunityFragment = new CommunityFragment();
        mHappyLifeFragment = new HappyLifeFragment();
        mUserFragment = new UserFragment();

        mManager = getSupportFragmentManager();
        mManager.beginTransaction()
                .add(R.id.container, mCookbookFragment)
                .commit();

        mTempFragment = mCookbookFragment;

        ((RadioButton)mRadioGroup.getChildAt(0)).setChecked(true);
    }


    public void showFragment(Fragment fragment){

                if(fragment.isAdded()){
                    mManager.beginTransaction()
                            .hide(mTempFragment)
                            .show(fragment)
                            .commit();
                    mTempFragment = fragment;
                }else{
                    mManager.beginTransaction()
                            .hide(mTempFragment)
                            .add(R.id.container,fragment)
                            .commit();
                    mTempFragment = fragment;
                }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE&&resultCode==RESULT_CODE){
           setResult(RESULT_CODE);
            finish();
        }
    }
}
