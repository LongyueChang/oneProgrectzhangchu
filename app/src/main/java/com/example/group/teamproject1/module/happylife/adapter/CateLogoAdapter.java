package com.example.group.teamproject1.module.happylife.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.group.teamproject1.R;
import com.example.group.teamproject1.beans.HappLifeCateLogoBean;
import com.example.group.teamproject1.utils.CircleTransform;

import java.util.List;

/**
 * Created by kongalong on 2016/12/12.
 */
public class CateLogoAdapter extends RecyclerView.Adapter<CateLogoAdapter.ViewHolder> implements View.OnClickListener{

    Context mContext;
    List<HappLifeCateLogoBean.DataBean.AlbumsBean> mAlbumList;

    public CateLogoAdapter(Context context ,List<HappLifeCateLogoBean.DataBean.AlbumsBean>
                                   albumList) {
        this.mContext = context;
        this.mAlbumList = albumList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.happylife_cate_logo_item, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        //加载圆形图片
        Glide.with(mContext)
                .load(mAlbumList.get(position).getAlbum_logo())
                .centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new CircleTransform(mContext))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .crossFade()
                .into(holder.mImageView);

        //为view设置监听
        holder.mImageView.setOnClickListener(this);
        //为view设置tag，在点击事件获取data
        holder.mImageView.setTag(holder.mImageView.getId(),mAlbumList.get(position));
    }

    @Override
    public int getItemCount() {

        return mAlbumList.size();
    }

    private OnRecycleViewItemOnClickListener mOnRecycleViewItemOnClickListener;

    @Override
    public void onClick(View v) {
        mOnRecycleViewItemOnClickListener.onItemClick(v,(HappLifeCateLogoBean.DataBean.AlbumsBean)v.getTag(v.getId()));
    }

    //为view设置监听事件
    public void setOnRecycleItemOnClickListener
    (OnRecycleViewItemOnClickListener onRecycleItemOnClickListener){
        this.mOnRecycleViewItemOnClickListener = onRecycleItemOnClickListener;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {


        private ImageView mImageView;

        public ViewHolder(View itemView) {

            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.happylife_cate_logo_image);
        }

    }

    //自定义监听接口
    public interface OnRecycleViewItemOnClickListener{

        void onItemClick(View view, HappLifeCateLogoBean.DataBean.AlbumsBean data);

    }



}
