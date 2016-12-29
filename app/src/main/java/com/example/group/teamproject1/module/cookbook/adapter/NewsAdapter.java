package com.example.group.teamproject1.module.cookbook.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.group.teamproject1.R;
import com.example.group.teamproject1.beans.NewsMessageBeans;
import com.example.group.teamproject1.module.cookbook.NewsSecondFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/12/26.
 */
public class NewsAdapter extends BaseAdapter{
    private NewsSecondFragment mActivity;
    private List<NewsMessageBeans> mData;
    private int page=1;

    public NewsAdapter(NewsSecondFragment activity, List<NewsMessageBeans> messageData) {
        mActivity=activity;
        mData=messageData;
    }

    @Override
    public int getCount() {
        List<NewsMessageBeans.DataBeanX.DataBean> data = mData.get(0).getData().getData();
        return data!=null?data.size():0;
    }

    @Override
    public Object getItem(int position) {
        return mData.get(0).getData().getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View ret=null;
        MyHolder holder=null;
        if (convertView != null) {
            ret=convertView;
            holder= (MyHolder) convertView.getTag();
        }else {
            ret= LayoutInflater.from(mActivity.getContext()).inflate(R.layout.news_show_item,parent,false);
            holder=new MyHolder();
            holder.newsImg= (ImageView) ret.findViewById(R.id.news_show_img);
            holder.title= (TextView) ret.findViewById(R.id.news_show_title);
            holder.watch_number= (TextView) ret.findViewById(R.id.news_show_watches);
            holder.bt_more= (Button) ret.findViewById(R.id.bt_more);
            convertView.setTag(holder);
        }

        holder.title.setText(mData.get(0).getData().getData().get(position).getTitle());
        holder.watch_number.setText("浏览量:"+mData.get(0).getData().getData().get(position).getViews());

        String imagePath = mData.get(0).getData().getData().get(position).getImage();
        Picasso.with(mActivity.getContext())
                .load(imagePath)
                .placeholder(R.mipmap.placeholder)
                .error(android.R.drawable.stat_notify_error)
                .noFade()
                .into(holder.newsImg);

        if(position==mData.get(0).getData().getData().size()-1){
            holder.bt_more.setVisibility(View.VISIBLE);
        }

        String total = mData.get(0).getData().getTotal();
        String count = mData.get(0).getData().getCount();
        int number = Integer.parseInt(total) - Integer.parseInt(count);
        holder.bt_more.setText("还剩下"+number+"篇");

        holder.bt_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page++;
             pageCallBack.getCount(page);
            }
        });
        return ret;
    }


    public class MyHolder{
        private ImageView newsImg;
        private TextView title,watch_number;
        private Button bt_more;
    }

    private PageCallBack pageCallBack;

    public void setCallBack(PageCallBack callBack){
        this.pageCallBack=callBack;
    }

    public interface PageCallBack {
        void getCount(int page);
    }

}
