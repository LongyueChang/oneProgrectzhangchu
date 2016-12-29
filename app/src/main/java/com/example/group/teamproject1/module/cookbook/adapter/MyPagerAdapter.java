package com.example.group.teamproject1.module.cookbook.adapter;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.group.teamproject1.MainActivity;
import com.example.group.teamproject1.module.cookbook.activitys.CookSecondActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/13.
 */
public class MyPagerAdapter extends PagerAdapter{
    private MainActivity mContext;
    private List<ImageView> mHeadView;
    private LayoutInflater inflater;
    private List<ImageView> images=new ArrayList<>();
    private String[] ids={"100","76","23","112","109"};

    public MyPagerAdapter(MainActivity context, List<ImageView> headView) {
        mContext=context;
        mHeadView=headView;
        inflater=LayoutInflater.from(mContext);
        for (int i = 0; i < mHeadView.size()+2; i++) {
            ImageView img=new ImageView(mContext);
            images.add(img);
        }
    }


    @Override
    public int getCount() {
        return mHeadView.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        ImageView img;
        //根据位置进行条件判断
        if(position==0){
            //0当位置是第一个时,设置最后一张图片
            img=mHeadView.get(mHeadView.size()-1);
        }else if (position==images.size()-1){
            //4
            img=mHeadView.get(0);
        }else{
            //1-3
            img=mHeadView.get(position-1);

        }

        container.removeView(img);
        container.addView(img);
        //创建ViewPager的点击事件
        img.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, CookSecondActivity.class);
                intent.putExtra("id",ids[position]);
                mContext.startActivity(intent);
            }
        });
        return img;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(images.get(position));
    }
}
