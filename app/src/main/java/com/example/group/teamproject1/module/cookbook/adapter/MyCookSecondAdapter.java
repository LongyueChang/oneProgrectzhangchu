package com.example.group.teamproject1.module.cookbook.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.group.teamproject1.R;
import com.example.group.teamproject1.beans.CookTitleFishBeen;
import com.example.group.teamproject1.beans.CookTitleNoheatBeen;
import com.example.group.teamproject1.beans.CookTitlePancakeBeen;
import com.example.group.teamproject1.beans.CookTitleThreeBeen;
import com.example.group.teamproject1.beans.CookTitleWishBeen;
import com.example.group.teamproject1.module.cookbook.activitys.CookSecondActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.group.teamproject1.common.constant.Constant.DIVIDE_COUNT;
import static com.example.group.teamproject1.common.constant.Constant.HEADER_COUNT;
import static com.example.group.teamproject1.common.constant.Constant.INTERACT_COUNT;
import static com.example.group.teamproject1.common.constant.Constant.TODAY_COUNT;

/**
 * Created by Administrator on 2016/12/19.
 */
public class MyCookSecondAdapter extends RecyclerView.Adapter{
    private CookSecondActivity mContext;
    private List<Object> mData;
    private List<Object> mTitleData;
    private List<CookTitleFishBeen> fishData;
    private List<CookTitleWishBeen> wishData;
    private List<CookTitleThreeBeen> threeData;
    private List<CookTitleNoheatBeen> noheaData;
    private List<CookTitlePancakeBeen> panckeData;
    private String mId;

    public MyCookSecondAdapter(CookSecondActivity cookSecondActivity, List<Object> data) {
        mContext=cookSecondActivity;
        mData=data;
    }

    @Override
    public int getItemCount() {

        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return HEADER_COUNT;
        }else if(position==1){
            return DIVIDE_COUNT;
        }else if(position==2){
            return INTERACT_COUNT;
        }else {
            return TODAY_COUNT;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View ret=null;
        switch (viewType){
            case HEADER_COUNT:
                ret = LayoutInflater.from(mContext).inflate(R.layout.cookbook_title, null);

                break;

        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HeadViewHolder){
            if(mId.equals("100")){
                CookTitleFishBeen fishBeen= (CookTitleFishBeen) mTitleData.get(0);

                    ((HeadViewHolder) holder).personInfo.setText(fishBeen.getData()
                            .getData().get(0).getVideo_watchcount());

                if(fishBeen.getData().getData().size()>20){


                }else {
                    List<Button> buttons=new ArrayList<>();
                    for (int i = 0; i < fishBeen.getData().getData().size(); i++) {
                        Button button=new Button(mContext);
                        button.setText(i);
                        buttons.add(button);
                    }

                    new MyGridViewAdapter(mContext,buttons);
                }



                Glide.with(mContext)
                        .load(fishBeen.getData().getSeries_image())
                        .placeholder(R.mipmap.placeholder)
                        .centerCrop()
                        .override(100,100)
                        .error(android.R.drawable.stat_notify_error)
                        .into(((HeadViewHolder) holder).video);





            }else if(mId.equals("76")){
                CookTitleWishBeen wishBeen= (CookTitleWishBeen) mTitleData.get(1);
                wishData = new ArrayList<>();
                wishData.add(wishBeen);

            }else if(mId.equals("23")){
                CookTitleThreeBeen threeBeen= (CookTitleThreeBeen) mTitleData.get(2);
                threeData = new ArrayList<>();
                threeData.add(threeBeen);

            }else if(mId.equals("112")){
                CookTitleNoheatBeen noheatBeen = (CookTitleNoheatBeen) mTitleData.get(3);
                noheaData = new ArrayList<>();
                noheaData.add(noheatBeen);

            }else if(mId.equals("109")){
                CookTitlePancakeBeen pancakeBeen= (CookTitlePancakeBeen) mTitleData.get(4);
                panckeData = new ArrayList<>();
                panckeData.add(pancakeBeen);
            }
        }
    }

    public void addHeadView(String id, List<Object> headerData) {
        mTitleData.addAll(headerData);
        mId=id;
    }

    public class HeadViewHolder extends RecyclerView.ViewHolder {
        private ImageView video,collect,rinaMore,share,setsMore,praiseThumb;
        private TextView personInfo,rina,rinaShowInfo,setNews,praise;
        private GridView gridView1,gridView2,gridViewPerson;
        private Button play;

        public HeadViewHolder(View itemView) {
            super(itemView);
            video= (ImageView) itemView.findViewById(R.id.cookbook_video);
            collect= (ImageView) itemView.findViewById(R.id.cookbook_collect);
            rinaMore= (ImageView) itemView.findViewById(R.id.cookbook_rina_more);
            share= (ImageView) itemView.findViewById(R.id.cookbook_share);
            setsMore= (ImageView) itemView.findViewById(R.id.cookbook_sets_more);
            praiseThumb= (ImageView) itemView.findViewById(R.id.praise_thumb);
            personInfo= (TextView) itemView.findViewById(R.id.cookbook_person_info);
            rina= (TextView) itemView.findViewById(R.id.rina);
            rinaShowInfo= (TextView) itemView.findViewById(R.id.cookbook_rina_showInfo);
            setNews= (TextView) itemView.findViewById(R.id.cookbook_set_news);
            praise= (TextView) itemView.findViewById(R.id.cookbook_praise);
            gridView1= (GridView) itemView.findViewById(R.id.cookbook_gridView1);
            gridView2= (GridView) itemView.findViewById(R.id.cookbook_gridView2);
            gridViewPerson= (GridView) itemView.findViewById(R.id.cookbook_gridView_person);
            play= (Button) itemView.findViewById(R.id.cookbook_paly);
        }
    }
}
