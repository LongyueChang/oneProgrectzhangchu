package com.example.group.teamproject1.module.cookbook.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.group.teamproject1.MainActivity;
import com.example.group.teamproject1.R;
import com.example.group.teamproject1.beans.CookBookBean;
import com.example.group.teamproject1.common.activitys.VideoActivity;
import com.example.group.teamproject1.module.cookbook.FoodFragment;
import com.example.group.teamproject1.module.cookbook.NewsSecondFragment;
import com.example.group.teamproject1.module.cookbook.activitys.CookbookSearch;
import com.example.group.teamproject1.utils.CircleTransform;
import com.example.group.teamproject1.utils.CustomIndicator;

import java.util.ArrayList;
import java.util.List;

import static com.example.group.teamproject1.common.constant.Constant.ALL_SCENE;
import static com.example.group.teamproject1.common.constant.Constant.BOTTOM_COUNT;
import static com.example.group.teamproject1.common.constant.Constant.CHOICE_COUNT;
import static com.example.group.teamproject1.common.constant.Constant.COMMON_COUNT;
import static com.example.group.teamproject1.common.constant.Constant.DIVIDE_COUNT;
import static com.example.group.teamproject1.common.constant.Constant.HEADER_COUNT;
import static com.example.group.teamproject1.common.constant.Constant.INTERACT_COUNT;
import static com.example.group.teamproject1.common.constant.Constant.SCENE_COUNT;
import static com.example.group.teamproject1.common.constant.Constant.SPECIAL_COUNT;
import static com.example.group.teamproject1.common.constant.Constant.TODAY_COUNT;

/**
 * Created by Administrator on 2016/12/12.
 */
public class CookAdapter extends RecyclerView.Adapter{
    private MainActivity mContext;
    private List<CookBookBean> mdata;
    //头布局的个数
    private int headerCount=1;
    //尾布局的个数
    private int bottomCount=1;

    private List<String> str;
    private MyPagerAdapter mPagerAdapter;

    public CookAdapter(MainActivity activity, List<CookBookBean> data) {
        mContext=activity;
        mdata=data;
    }


    public boolean isHeaderView(int position){
        return headerCount!=0&&position<headerCount;
    }

    public boolean isBottomView(int position){
        return bottomCount!=0&&position>(headerCount+getItemCount());
    }

    @Override
    public int getItemCount() {
        List<CookBookBean.DataBean.WidgetListBean> widgetList =
                mdata.get(0).getData().getWidgetList();
        return widgetList!=null?widgetList.size():0;
    }


    @Override
    public int getItemViewType(int position) {
        if(isHeaderView(position)){
            return HEADER_COUNT;
        }else if(isBottomView(position)) {
            return BOTTOM_COUNT;
        }else if(position==0){
            return DIVIDE_COUNT;
        }else if(position==1){
            return INTERACT_COUNT;
        }else if(position==2){
            return TODAY_COUNT;
        }else if(position==3&&position==4) {
            return COMMON_COUNT;
        }else if(position==5){
            return ALL_SCENE;
        }else if(position==6){
            return SCENE_COUNT;
        }else if(position==7){
            return CHOICE_COUNT;
        }else if(position==8){
            return SPECIAL_COUNT;
        }else {
            return COMMON_COUNT;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View ret=null;
        switch (viewType){
            case HEADER_COUNT://头布局
               ret=LayoutInflater.from(mContext)
                       .inflate(R.layout.header_item,parent,false);

                return new HeaderHolder(ret);

            case DIVIDE_COUNT://第一个条目
                ret= LayoutInflater.from(mContext)
                        .inflate(R.layout.divide_item,parent,false);

                return new DivideHolder(ret);

            case INTERACT_COUNT://橙宝互动
               ret=LayoutInflater.from(mContext)
                       .inflate(R.layout.interact_item,parent,false);
                return new InteractHolder(ret);


            case TODAY_COUNT:
                ret=LayoutInflater.from(mContext)
                        .inflate(R.layout.today_item,parent,false);
                return new TodayHolder(ret);

            case COMMON_COUNT:
                ret=LayoutInflater.from(mContext)
                        .inflate(R.layout.common_item,parent,false);

                return new CommonHolder(ret);

            case ALL_SCENE:
                ret=LayoutInflater.from(mContext)
                        .inflate(R.layout.allscene_item,parent,false);

                return new AllScreenHolder(ret);
            case SCENE_COUNT:
                ret=LayoutInflater.from(mContext)
                        .inflate(R.layout.scene_item,parent,false);
                return new SceneHolder(ret);

            case CHOICE_COUNT:
                ret=LayoutInflater.from(mContext)
                        .inflate(R.layout.choice_item,parent,false);
                return new ChoiceHolder(ret);

            case SPECIAL_COUNT:
                ret=LayoutInflater.from(mContext)
                        .inflate(R.layout.special_item,parent,false);
                return new SpecialHolder(ret);
            default:
                return null;
        }

    }


    /**
     * 头布局的相关属性
     */
    private  View[] icons=null;
    private int lastIndex=0;
    private int imgPosition=1;
    private int currentPosition=1;
    private List<ImageView> mHeadView=new ArrayList<>();


    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        List<CookBookBean.DataBean.WidgetListBean> widgetData
                = mdata.get(0).getData().getWidgetList();


        if (holder instanceof HeaderHolder) {//头布局
//            ((HeaderHolder) holder).mViewPager.setPageTransformer(false, new FilmPagerTransformer());
            ((HeaderHolder) holder).mViewPager.setPageMargin(30);

            mPagerAdapter = new MyPagerAdapter(mContext, mHeadView);

            ((HeaderHolder) holder).mViewPager.setAdapter(mPagerAdapter);

            ((HeaderHolder) holder).mViewPager.setCurrentItem(1);

            ((HeaderHolder) holder).mCustom.setCount(mHeadView.size());

            ((HeaderHolder) holder).mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    ((HeaderHolder) holder).mCustom.setMoveX(position - 1, positionOffset);
                }

                @Override
                public void onPageSelected(int position) {
                    if (position == 0) {
                        imgPosition = mHeadView.size();
                    } else if (position == (mHeadView.size() + 1)) {
                        imgPosition = 1;
                    } else {
                        imgPosition = position;
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                    if (state == ViewPager.SCROLL_STATE_IDLE) {
                        ((HeaderHolder) holder).mViewPager.setCurrentItem(imgPosition, false);
                    }
                }
            });


            ((HeaderHolder) holder).mButton.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(mContext, CookbookSearch.class);
                            mContext.startActivity(intent);
                        }
                    });


        } else if (holder instanceof DivideHolder) {
            ((DivideHolder) holder).divide_bt1.setText("新手入门");
            ((DivideHolder) holder).divide_bt2.setText("食材搭配");
            ((DivideHolder) holder).divide_bt3.setText("场景菜谱");
            ((DivideHolder) holder).divide_bt4.setText("美食直播");

            //这里的几个都是跳转界面，暂时保留
            ((DivideHolder) holder).divide_bt1
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent =new Intent(mContext, NewsSecondFragment.class);
                            mContext.startActivity(intent);


                        }
                    });

            ((DivideHolder) holder).divide_bt2
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent=new Intent(mContext,FoodFragment.class);
                            mContext.startActivity(intent);

                        }
                    });

            ((DivideHolder) holder).divide_bt3
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });

            ((DivideHolder) holder).divide_bt4
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });
        } else if (holder instanceof InteractHolder) {
            List<ImageView> list = new ArrayList<>();
            list.add(((InteractHolder) holder).interact_img1);
            list.add(((InteractHolder) holder).interact_img2);
            list.add(((InteractHolder) holder).interact_img3);
            list.add(((InteractHolder) holder).interact_img4);

            String contentPath = null;
            for (int i = 0; i < 4; i++) {
                contentPath = widgetData.get(position).getWidget_data().get(i).getContent();
                Glide.with(mContext).load(contentPath)
                        .placeholder(R.mipmap.placeholder)
                        .error(android.R.drawable.stat_notify_error)
                        .into(list.get(i));
            }


        } else if (holder instanceof TodayHolder) {

            //今日新品条目点击
            ((TodayHolder) holder).mLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "今日新品点击了", Toast.LENGTH_SHORT).show();
                }
            });

            TodayView today = new TodayView();
            today.initChoiceView();

            ((TodayHolder) holder).today_subtitle.setText(widgetData.get(position).getTitle());

            for (int i = 0; i < 12; i++) {
                String type = widgetData.get(position).getWidget_data().get(i).getType();
                List<String> str = null;
                if (type.equals("image")) {
                    str = new ArrayList<>();
                    for (int j = 0; j < 3; j++) {
                        String imgPath = widgetData.get(position).getWidget_data().get(j * 4).getContent();
                        str.add(imgPath);
                    }

                    Glide.with(mContext).load(str.get(0))
                            .placeholder(R.mipmap.placeholder)
                            .error(android.R.drawable.stat_notify_error)
                            .override(400, 400)
                            .centerCrop()
                            .into(today.today_img1);

                    Glide.with(mContext).load(str.get(1))
                            .placeholder(R.mipmap.placeholder)
                            .error(android.R.drawable.stat_notify_error)
                            .override(400, 400)
                            .centerCrop()
                            .into(today.today_img2);

                    Glide.with(mContext).load(str.get(2))
                            .placeholder(R.mipmap.placeholder)
                            .error(android.R.drawable.stat_notify_error)
                            .override(400, 400)
                            .centerCrop()
                            .into(today.today_img3);

                } else if (type.equals("video")) {
                    /////////////////////////////////////////////////
                    //视频播放
                    str = new ArrayList<>();
                    for (int j = 0; j < 3; j++) {
                        String videoPath = widgetData.get(position).getWidget_data().get(j * 4 + 1).getContent();
                        str.add(videoPath);
                    }

                    final String imgPath1 = widgetData.get(position).getWidget_data().get(0).getContent();
                    final String imgPath2 = widgetData.get(position).getWidget_data().get(1).getContent();
                    final String imgPath3 = widgetData.get(position).getWidget_data().get(2).getContent();

                    final Intent intent = new Intent(mContext, VideoActivity.class);
                    final List<String> finalStr = str;
                    today.today_play1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Bundle bundle = new Bundle();
                            bundle.putString("video", finalStr.get(0));
                            bundle.putString("image", imgPath1);
                            intent.putExtras(bundle);
                            mContext.startActivity(intent);
                        }
                    });

                    today.today_play2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Bundle bundle = new Bundle();
                            bundle.putString("video", finalStr.get(1));
                            bundle.putString("image", imgPath2);
                            intent.putExtras(bundle);
                            mContext.startActivity(intent);
                        }
                    });

                    today.today_play3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Bundle bundle = new Bundle();
                            bundle.putString("video", finalStr.get(2));
                            bundle.putString("image", imgPath3);
                            intent.putExtras(bundle);
                            mContext.startActivity(intent);
                        }
                    });

                } else if (type.equals("text")) {
                    str = new ArrayList<>();
                    for (int j = 0; j < 3; j++) {
                        String titlePath = widgetData.get(position).getWidget_data().get(j * 4 + 2).getContent();
                        String message = widgetData.get(position).getWidget_data().get(j * 4 + 3).getContent();
                        str.add(titlePath);
                        str.add(message);
                    }
                    today.today_title1.setText(str.get(0));
                    today.today_title2.setText(str.get(2));
                    today.today_title3.setText(str.get(4));

                    today.today_message1.setText(str.get(1));
                    today.today_message2.setText(str.get(3));
                    today.today_message3.setText(str.get(5));

                }
            }
            today.initAdapter(((TodayHolder) holder).gridView);

        } else if (holder instanceof CommonHolder) {

            ((CommonHolder) holder).common_subtitle
                    .setText(widgetData.get(position).getTitle());

            CommonView common = new CommonView();
            common.initChoiceView();
            List<String> str = null;
            List<String> imgStr = null;
            for (int i = 0; i < 13; i++) {
                String type = widgetData.get(position).getWidget_data().get(i).getType();
                List<CookBookBean.DataBean.WidgetListBean.WidgetDataBean> wData
                        = widgetData.get(position).getWidget_data();

                if (type.equals("image")) {
                    imgStr = new ArrayList<>();
                    for (int j = 1; j < 6; j++) {
                        String imgPath = wData.get(j * 2 + 1).getContent();
                        imgStr.add(imgPath);
                    }

                } else if (type.equals("text")) {
                    ((CommonHolder) holder).common_title.setText(wData.get(1).getContent());
                    ((CommonHolder) holder).common_title2.setText(wData.get(2).getContent());
                } else if (type.equals("video")) {
                    str = new ArrayList<>();

                    for (int j = 1; j < 5; j++) {
                        String videoPath = wData.get(j * 2 + 2).getContent();
                        str.add(videoPath);
                    }

                    final Intent intent = new Intent(mContext, VideoActivity.class);
                    final String img1 = wData.get(3).getContent();
                    final String img2 = wData.get(5).getContent();
                    final String img3 = wData.get(7).getContent();
                    final String img4 = wData.get(9).getContent();

                    final List<String> finalStr = str;
                    common.common_play1
                            .setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("video", finalStr.get(0));
                                    bundle.putString("image", img1);
                                    intent.putExtras(bundle);
                                    mContext.startActivity(intent);
                                }
                            });

                    common.common_play2
                            .setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("video", finalStr.get(1));
                                    bundle.putString("image", img2);
                                    intent.putExtras(bundle);
                                    mContext.startActivity(intent);
                                }
                            });

                    common.common_play3
                            .setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("video", finalStr.get(2));
                                    bundle.putString("image", img3);
                                    intent.putExtras(bundle);
                                    mContext.startActivity(intent);
                                }
                            });

                    common.common_play4
                            .setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("video", finalStr.get(3));
                                    bundle.putString("image", img4);
                                    intent.putExtras(bundle);
                                    mContext.startActivity(intent);
                                }
                            });
                }
            }

            Glide.with(mContext).load(imgStr.get(0))
                    .placeholder(R.mipmap.placeholder)
                    .error(android.R.drawable.stat_notify_error)
                    .override(300, 300)
                    .centerCrop()
                    .into(((CommonHolder) holder).common_img1);

            Glide.with(mContext).load(imgStr.get(1))
                    .placeholder(R.mipmap.placeholder)
                    .error(android.R.drawable.stat_notify_error)
                    .override(300, 210)
                    .centerCrop()
                    .into(common.img1);


            Glide.with(mContext).load(imgStr.get(2))
                    .placeholder(R.mipmap.placeholder)
                    .error(android.R.drawable.stat_notify_error)
                    .override(300, 210)
                    .centerCrop()
                    .into(common.img2);

            Glide.with(mContext).load(imgStr.get(3))
                    .placeholder(R.mipmap.placeholder)
                    .error(android.R.drawable.stat_notify_error)
                    .override(300, 210)
                    .centerCrop()
                    .into(common.img3);

            Glide.with(mContext).load(imgStr.get(4))
                    .placeholder(R.mipmap.placeholder)
                    .error(android.R.drawable.stat_notify_error)
                    .override(300, 210)
                    .centerCrop()
                    .into(common.img4);


            common.initAdapter(((CommonHolder) holder).gridView);

        } else if (holder instanceof AllScreenHolder) {//推荐全部场景

            ((AllScreenHolder) holder).subText.setText(widgetData.get(position).getTitle());
            ((AllScreenHolder) holder).layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "allScreenHolder被点击了", Toast.LENGTH_SHORT).show();
                }
            });


        } else if (holder instanceof SceneHolder) {//推荐达人

            ((SceneHolder) holder).scene_subTitle.setText(widgetData.get(position).getTitle());

            List<CookBookBean.DataBean.WidgetListBean.WidgetDataBean> wData
                    = widgetData.get(position).getWidget_data();
            for (int i = 0; i < wData.size(); i++) {
                String type = widgetData.get(position).getWidget_data().get(i).getType();
                if (type.equals("image")) {
                    str = new ArrayList<>();
                    for (int j = 0; j < 3; j++) {
                        String imgPath = wData.get(j * 4).getContent();
                        str.add(imgPath);
                    }

                    Glide.with(mContext).load(str.get(0))
                            .placeholder(R.mipmap.placeholder)
                            .transform(new CircleTransform(mContext))
                            .error(android.R.drawable.stat_notify_error)
                            .override(155, 155)
                            .into(((SceneHolder) holder).scene_img1);

                    Glide.with(mContext).load(str.get(1))
                            .placeholder(R.mipmap.placeholder)
                            .transform(new CircleTransform(mContext))
                            .error(android.R.drawable.stat_notify_error)
                            .override(155, 155)
                            .into(((SceneHolder) holder).scene_img2);

                    Glide.with(mContext).load(str.get(2))
                            .placeholder(R.mipmap.placeholder)
                            .transform(new CircleTransform(mContext))
                            .error(android.R.drawable.stat_notify_error)
                            .override(140, 140)
                            .into(((SceneHolder) holder).scene_img3);

                } else if (type.equals("text")) {
                    str = new ArrayList<>();
                    for (int j = 0; j < 3; j++) {
                        String name = wData.get(j * 4 + 1).getContent();
                        str.add(name);
                        String message = wData.get(j * 4 + 2).getContent();
                        str.add(message);
                        String fans = wData.get(j * 4 + 3).getContent();
                        str.add(fans);
                    }

                    ((SceneHolder) holder).scene_title1.setText(str.get(0));
                    ((SceneHolder) holder).scene_message1.setText(str.get(1));
                    ((SceneHolder) holder).scene_fans1.setText(str.get(2));

                    ((SceneHolder) holder).scene_title2.setText(str.get(3));
                    ((SceneHolder) holder).scene_message2.setText(str.get(4));
                    ((SceneHolder) holder).scene_fans2.setText(str.get(5));

                    ((SceneHolder) holder).scene_title3.setText(str.get(6));
                    ((SceneHolder) holder).scene_message3.setText(str.get(7));
                    ((SceneHolder) holder).scene_fans3.setText(str.get(8));
                }
            }
        } else if (holder instanceof ChoiceHolder) {
            //初始化
            ChoiceView choiceView = new ChoiceView();
            choiceView.initChoiceView();

            ((ChoiceHolder) holder).choice_subtitle.setText(widgetData.get(position).getTitle());
            ((ChoiceHolder) holder).choice_message.setText((String) widgetData.get(position).getDesc());

            List<CookBookBean.DataBean.WidgetListBean.WidgetDataBean> wData
                    = widgetData.get(position).getWidget_data();
            List<String> imgStr = null;
            for (int i = 0; i < wData.size(); i++) {
                String type = wData.get(i).getType();

                if (type.equals("image")) {
                    imgStr = new ArrayList<>();
                    for (int j = 0; j < 3; j++) {
                        String imgPath = wData.get(j * 3).getContent();
                        imgStr.add(imgPath);
                        String personPath = wData.get(j * 3 + 1).getContent();
                        imgStr.add(personPath);
                    }

                } else if (type.equals("text")) {
                    str = new ArrayList<>();
                    for (int j = 0; j < 3; j++) {
                        String name = wData.get(j * 3 + 2).getContent();
                        str.add(name);
                    }

                    choiceView.showInfo.setText(str.get(0));
                    choiceView.showInfo2.setText(str.get(1));
                    choiceView.showInfo3.setText(str.get(2));
                }
            }

            Glide.with(mContext).load(imgStr.get(0))
                    .placeholder(R.mipmap.placeholder)
                    .error(android.R.drawable.stat_notify_error)
                    .centerCrop()
                    .fitCenter()
                    .override(200, 200)
                    .into(choiceView.img1);

            Glide.with(mContext).load(imgStr.get(1))
                    .placeholder(R.mipmap.placeholder)
                    .transform(new CircleTransform(mContext))
                    .error(android.R.drawable.stat_notify_error)
                    .override(100, 100)
                    .into(choiceView.personImg1);

            Glide.with(mContext).load(imgStr.get(2))
                    .placeholder(R.mipmap.placeholder)
                    .error(android.R.drawable.stat_notify_error)
                    .override(200, 200)
                    .centerCrop()
                    .fitCenter()
                    .into(choiceView.img2);

            Glide.with(mContext).load(imgStr.get(3))
                    .placeholder(R.mipmap.placeholder)
                    .transform(new CircleTransform(mContext))
                    .error(android.R.drawable.stat_notify_error)
                    .override(100, 100)
                    .into(choiceView.personImg2);

            Glide.with(mContext).load(imgStr.get(4))
                    .placeholder(R.mipmap.placeholder)
                    .error(android.R.drawable.stat_notify_error)
                    .override(200, 200)
                    .centerCrop()
                    .fitCenter()
                    .into(choiceView.img3);

            Glide.with(mContext).load(imgStr.get(5))
                    .placeholder(R.mipmap.placeholder)
                    .transform(new CircleTransform(mContext))
                    .error(android.R.drawable.stat_notify_error)
                    .override(100, 100)
                    .into(choiceView.personImg3);

            //设置适配器
            choiceView.initAdapter(((ChoiceHolder) holder).mGridView);


        } else if (holder instanceof SpecialHolder) {
            ((SpecialHolder) holder).special_subtitle.setText(widgetData.get(position).getTitle());
            List<CookBookBean.DataBean.WidgetListBean.WidgetDataBean> wData
                    = widgetData.get(position).getWidget_data();

            Log.i("TAG", "----------->cookAdapter中specialHolder中的wdata:" + wData.size());
            for (int i = 0; i < 6; i++) {
                String type = wData.get(i).getType();
                if (type.equals("image")) {
                    String imgPath1 = wData.get(0).getContent();
                    String imgPath2 = wData.get(3).getContent();

                    Glide.with(mContext).load(imgPath1)
                            .placeholder(R.mipmap.placeholder)
                            .error(android.R.drawable.stat_notify_error)
                            .into(((SpecialHolder) holder).special_img1);

                    Glide.with(mContext).load(imgPath2)
                            .placeholder(R.mipmap.placeholder)
                            .error(android.R.drawable.stat_notify_error)
                            .into(((SpecialHolder) holder).special_img2);

                } else if (type.equals("text")) {

                    ((SpecialHolder) holder).special_title1.setText(wData.get(1).getContent());
                    ((SpecialHolder) holder).special_title2.setText(wData.get(4).getContent());

                    ((SpecialHolder) holder).special_mesage1.setText(wData.get(2).getContent());
                    ((SpecialHolder) holder).special_mesage2.setText(wData.get(5).getContent());
                }
            }
        }
    }


    //chice的glidView封装的类
    public class ChoiceView{
        public ImageView img1,img2,img3;
        private ImageView personImg1,personImg2,personImg3;
        private TextView showInfo,showInfo2,showInfo3;
        private BaseAdapter adapter;
        private List<View> list=new ArrayList<>();

        //初始化属性值
        private void initChoiceView() {
            View ret=LayoutInflater.from(mContext).inflate(R.layout.choice_choide_item,null);
            img1= (ImageView) ret.findViewById(R.id.choice_img1);
            img1.setScaleType(ImageView.ScaleType.FIT_XY);
            personImg1= (ImageView) ret.findViewById(R.id.choice_person1);
            showInfo= (TextView) ret.findViewById(R.id.choice_info);


            View ret2=LayoutInflater.from(mContext).inflate(R.layout.choice_choide_item,null);
            img2= (ImageView) ret2.findViewById(R.id.choice_img1);
            img2.setScaleType(ImageView.ScaleType.FIT_XY);
            personImg2= (ImageView) ret2.findViewById(R.id.choice_person1);
            showInfo2= (TextView) ret2.findViewById(R.id.choice_info);

            View ret3=LayoutInflater.from(mContext).inflate(R.layout.choice_choide_item,null);
            img3= (ImageView) ret3.findViewById(R.id.choice_img1);
            img3.setScaleType(ImageView.ScaleType.FIT_XY);
            personImg3= (ImageView) ret3.findViewById(R.id.choice_person1);
            showInfo3= (TextView) ret3.findViewById(R.id.choice_info);

            list.add(ret);
            list.add(ret2);
            list.add(ret3);


        }

        //设置适配器
        public void initAdapter(GridView gridView) {
            adapter=new BaseAdapter() {
                @Override
                public int getCount() {
                    return list!=null?list.size():0;
                }

                @Override
                public Object getItem(int position) {
                    return list.get(position);
                }

                @Override
                public long getItemId(int position) {
                    return position;
                }

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    return list.get(position);
                }
            };

            gridView.setAdapter(adapter);
        }
    }

    //Common的gridView封装的类
    public class CommonView{
        private ImageView common_play1,common_play2,common_play3,common_play4;
        public ImageView img1,img2,img3,img4;

        private BaseAdapter adapter;
        private List<View> list=new ArrayList<>();

        //初始化属性值
        private void initChoiceView() {
            View ret=LayoutInflater.from(mContext).inflate(R.layout.common_choide_item,null);
            img1= (ImageView) ret.findViewById(R.id.common_child_img);
            common_play1= (ImageView) ret.findViewById(R.id.common_child_play);

            View ret2=LayoutInflater.from(mContext).inflate(R.layout.common_choide_item,null);
            img2= (ImageView) ret2.findViewById(R.id.common_child_img);
            common_play2= (ImageView) ret2.findViewById(R.id.common_child_play);

            View ret3=LayoutInflater.from(mContext).inflate(R.layout.common_choide_item,null);
            img3= (ImageView) ret3.findViewById(R.id.common_child_img);
            common_play3= (ImageView) ret3.findViewById(R.id.common_child_play);

            View ret4=LayoutInflater.from(mContext).inflate(R.layout.common_choide_item,null);
            img4= (ImageView) ret4.findViewById(R.id.common_child_img);
            common_play4= (ImageView) ret4.findViewById(R.id.common_child_play);

            list.add(ret);
            list.add(ret2);
            list.add(ret3);
            list.add(ret4);

        }

        //设置适配器
        public void initAdapter(GridView gridView) {
            adapter=new BaseAdapter() {
                @Override
                public int getCount() {
                    return list!=null?list.size():0;
                }

                @Override
                public Object getItem(int position) {
                    return list.get(position);
                }

                @Override
                public long getItemId(int position) {
                    return position;
                }

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    return list.get(position);
                }
            };

            gridView.setAdapter(adapter);
        }
    }

    //Today的gridView封装的类
    public class TodayView{
        private ImageView today_img1,today_img2,today_img3;
        private TextView today_title1,today_title2,today_title3;
        private TextView today_message1,today_message2,today_message3;
        private ImageView today_play1,today_play2,today_play3;
        private BaseAdapter adapter;
        private List<View> list=new ArrayList<>();

        //初始化属性值
        private void initChoiceView() {

            View ret=LayoutInflater.from(mContext).inflate(R.layout.today_grid_item,null);
            today_img1= (ImageView) ret.findViewById(R.id.today_grid_img);
            today_title1= (TextView) ret.findViewById(R.id.today_grid_title);
            today_message1= (TextView) ret.findViewById(R.id.today_grid_message);
            today_play1= (ImageView) ret.findViewById(R.id.today_grid_play);

            View ret2=LayoutInflater.from(mContext).inflate(R.layout.today_grid_item,null);
            today_img2= (ImageView) ret2.findViewById(R.id.today_grid_img);
            today_title2= (TextView) ret2.findViewById(R.id.today_grid_title);
            today_message2= (TextView) ret2.findViewById(R.id.today_grid_message);
            today_play2= (ImageView) ret2.findViewById(R.id.today_grid_play);

            View ret3=LayoutInflater.from(mContext).inflate(R.layout.today_grid_item,null);
            today_img3= (ImageView) ret3.findViewById(R.id.today_grid_img);
            today_title3= (TextView) ret3.findViewById(R.id.today_grid_title);
            today_message3= (TextView) ret3.findViewById(R.id.today_grid_message);
            today_play3= (ImageView) ret3.findViewById(R.id.today_grid_play);

            list.add(ret);
            list.add(ret2);
            list.add(ret3);

        }

        //设置适配器
        public void initAdapter(GridView gridView) {
            adapter=new BaseAdapter() {
                @Override
                public int getCount() {
                    return list!=null?list.size():0;
                }

                @Override
                public Object getItem(int position) {
                    return list.get(position);
                }

                @Override
                public long getItemId(int position) {
                    return position;
                }

                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    return list.get(position);
                }
            };

            gridView.setAdapter(adapter);
        }
    }


    public void addHeaderView(List<ImageView> imageViews) {
       mHeadView.addAll(imageViews);
    }

    public class HeaderHolder extends RecyclerView.ViewHolder{
        private ViewPager mViewPager;
        private Button mButton;
        private CustomIndicator mCustom;

        public HeaderHolder(View itemView) {
            super(itemView);
            mViewPager= (ViewPager) itemView.findViewById(R.id.header_viewPager);
            mButton= (Button) itemView.findViewById(R.id.header_bt);
            mCustom= (CustomIndicator) itemView.findViewById(R.id.custom_icon);
        }
    }

    //第二个条目按钮
    public class DivideHolder extends RecyclerView.ViewHolder{
        private Button divide_bt1,divide_bt2,divide_bt3,divide_bt4;

        public DivideHolder(View itemView) {
            super(itemView);
            divide_bt1= (Button) itemView.findViewById(R.id.divide_xs);
            divide_bt2= (Button) itemView.findViewById(R.id.divide_sc);
            divide_bt3= (Button) itemView.findViewById(R.id.divide_cj);
            divide_bt4= (Button) itemView.findViewById(R.id.divide_ms);
        }
    }

    //橙宝互动条目
    public class InteractHolder extends RecyclerView.ViewHolder{
        private ImageView interact_img1,interact_img2,interact_img3,interact_img4;

        public InteractHolder(View itemView) {
            super(itemView);
            interact_img1= (ImageView) itemView.findViewById(R.id.interact_img1);
            interact_img2= (ImageView) itemView.findViewById(R.id.interact_img2);
            interact_img3= (ImageView) itemView.findViewById(R.id.interact_img3);
            interact_img4= (ImageView) itemView.findViewById(R.id.interact_img4);
        }
    }


    public class TodayHolder extends RecyclerView.ViewHolder{
        private LinearLayout mLayout;
        private GridView gridView;
        private TextView today_subtitle;

        public TodayHolder(View itemView) {
            super(itemView);
            mLayout= (LinearLayout) itemView.findViewById(R.id.today_layout);
            gridView= (GridView) itemView.findViewById(R.id.today_gridview);
            today_subtitle= (TextView) itemView.findViewById(R.id.today_subtitle);
        }
    }

    public class CommonHolder extends RecyclerView.ViewHolder{
        private LinearLayout mLayout;
        private ImageView common_img1;
        private TextView common_subtitle;
        private TextView common_title,common_title2;
        private TextView common_message;
        private GridView gridView;

        public CommonHolder(View itemView) {
            super(itemView);
            mLayout= (LinearLayout) itemView.findViewById(R.id.common_layout);
            common_img1= (ImageView) itemView.findViewById(R.id.common_img1);

            common_subtitle= (TextView) itemView.findViewById(R.id.common_subtitle);
            common_title= (TextView) itemView.findViewById(R.id.common_title);
            common_title2= (TextView) itemView.findViewById(R.id.common_title2);
            common_message= (TextView) itemView.findViewById(R.id.common_message);
            gridView= (GridView) itemView.findViewById(R.id.common_gridview);
        }
    }


    public class SceneHolder extends RecyclerView.ViewHolder{
        private ImageView scene_img1,scene_img2,scene_img3;
        private TextView scene_subTitle;
        private TextView scene_title1,scene_title2,scene_title3;
        private TextView scene_message1,scene_message2,scene_message3;
        private TextView scene_fans1,scene_fans2,scene_fans3;


        public SceneHolder(View itemView) {
            super(itemView);

            scene_img1= (ImageView) itemView.findViewById(R.id.scene_img1);
            scene_img2= (ImageView) itemView.findViewById(R.id.scene_img2);
            scene_img3= (ImageView) itemView.findViewById(R.id.scene_img3);

            scene_subTitle= (TextView) itemView.findViewById(R.id.scene_subtitle2);

            scene_title1= (TextView) itemView.findViewById(R.id.scene_title1);
            scene_title2= (TextView) itemView.findViewById(R.id.scene_title2);
            scene_title3= (TextView) itemView.findViewById(R.id.scene_title3);

            scene_message1= (TextView) itemView.findViewById(R.id.scene_message1);
            scene_message2= (TextView) itemView.findViewById(R.id.scene_message2);
            scene_message3= (TextView) itemView.findViewById(R.id.scene_message3);

            scene_fans1= (TextView) itemView.findViewById(R.id.scene_fans1);
            scene_fans2= (TextView) itemView.findViewById(R.id.scene_fans2);
            scene_fans3= (TextView) itemView.findViewById(R.id.scene_fans3);
        }
    }

    public class AllScreenHolder extends RecyclerView.ViewHolder{
        private TextView subText;
        private LinearLayout layout;

        public AllScreenHolder(View itemView) {
            super(itemView);
            subText= (TextView) itemView.findViewById(R.id.allScene_subtitle);
            layout= (LinearLayout) itemView.findViewById(R.id.allScene_subLayout1);
        }
    }

    public class ChoiceHolder extends RecyclerView.ViewHolder{
        private TextView choice_subtitle,choice_message;
        private GridView mGridView;

        public ChoiceHolder(View itemView) {
            super(itemView);
            choice_subtitle= (TextView) itemView.findViewById(R.id.choice_subtitle);
            choice_message= (TextView) itemView.findViewById(R.id.choice_message);
            mGridView= (GridView) itemView.findViewById(R.id.choice_gridView);
        }
    }

    public class SpecialHolder extends RecyclerView.ViewHolder{
        private ImageView special_img1,special_img2;
        private TextView special_subtitle;
        private TextView special_title1,special_title2;
        private TextView special_mesage1,special_mesage2;

        public SpecialHolder(View itemView) {
            super(itemView);
            special_img1= (ImageView) itemView.findViewById(R.id.special_img1);
            special_img2= (ImageView) itemView.findViewById(R.id.special_img2);
            special_subtitle= (TextView) itemView.findViewById(R.id.special_subtitle);
            special_title1= (TextView) itemView.findViewById(R.id.special_title1);
            special_title2= (TextView) itemView.findViewById(R.id.special_title2);
            special_mesage1= (TextView) itemView.findViewById(R.id.special_message1);
            special_mesage2= (TextView) itemView.findViewById(R.id.special_message2);
        }
    }
}
