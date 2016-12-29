package com.example.group.teamproject1.module.happylife.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.group.teamproject1.R;
import com.example.group.teamproject1.beans.HappyLifeCateBean;
import com.example.group.teamproject1.utils.CircleTransform;

import java.util.List;

/**
 * Created by kongalong on 2016/12/12.
 */
public class CateAdapter extends RecyclerView.Adapter<CateAdapter.ViewHolder>{

    private Context mContext;
    private List<HappyLifeCateBean.DataBean.DataBean1> mCateDataList;

    public CateAdapter(Context context,
                       List<HappyLifeCateBean.DataBean.DataBean1> cateDataList) {

        this.mContext = context;
        this.mCateDataList = cateDataList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.happylife_cate_item, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Glide.with(mContext)
                .load(mCateDataList.get(position).getImage())
                .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .crossFade()
                .into(holder.mMainImage);
        //加载圆形图片
        Glide.with(mContext)
                .load(mCateDataList.get(position).getAlbum_logo())
                .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new CircleTransform(mContext))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .crossFade()
                .into(holder.mLogoImage);

        holder.mTitleText.setText(mCateDataList.get(position).getSeries_name());
        holder.mUpdataText.setText("更新至"+mCateDataList.get(position).getEpisode()+"集");
        holder.mCountText.setText("上课人数"+mCateDataList.get(position).getPlay());
        holder.mLogoText.setText(mCateDataList.get(position).getAlbum());
    }



    @Override
    public int getItemCount() {
        return mCateDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private  ImageView mMainImage;
        private  ImageView mLogoImage;
        private  TextView mTitleText;
        private  TextView mUpdataText;
        private  TextView mCountText;
        private  TextView mLogoText;

        public ViewHolder(View itemView) {
            super(itemView);

            mMainImage =  (ImageView) itemView.findViewById(R.id.happylife_cate_image);
            mLogoImage = (ImageView) itemView.findViewById(R.id.happylife_cate_logo_image);
            mTitleText = (TextView) itemView.findViewById(R.id.happylife_cate_title_text);
            mUpdataText = (TextView) itemView.findViewById(R.id.happylife_cate_updata_text);
            mCountText = (TextView) itemView.findViewById(R.id.happylife_cate_count_text);
            mLogoText = (TextView) itemView.findViewById(R.id.happylife_cate_logo_text);

        }
    }
}
