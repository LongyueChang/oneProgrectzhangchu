package com.example.group.teamproject1.fragments;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;

import com.example.group.teamproject1.R;
import com.example.group.teamproject1.common.BaseFragment;
import com.example.group.teamproject1.module.user.activitys.MenuActivity;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends BaseFragment {

    @BindView(R.id.setting)
    ImageView settingMenu;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user;
    }

    @Override
    protected void initView(View ret) {

    }

    @Override
    protected void initEvent() {
        settingMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MenuActivity.class);
                getContext().startActivity(intent);

            }
        });
    }

    @Override
    protected void initData() {

    }


}
