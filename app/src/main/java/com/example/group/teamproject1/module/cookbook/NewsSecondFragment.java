package com.example.group.teamproject1.module.cookbook;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.group.teamproject1.R;
import com.example.group.teamproject1.beans.NewsBeans;
import com.example.group.teamproject1.beans.NewsMessageBeans;
import com.example.group.teamproject1.module.cookbook.adapter.NewsAdapter;
import com.example.group.teamproject1.utils.CircleTransform;
import com.example.group.teamproject1.utils.VolleyUtils;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

import static com.example.group.teamproject1.api.Apis.COOKBOOK_PATH;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsSecondFragment extends Fragment {
    private TextView title;
    private Button stat, share;
    private HorizontalScrollView mScrollView;
    private ListView mRecyclerView;
    private Map<String, String> map;
    private ImageView newsTitleImg;
    private TextView newsTitletext;
    private String page;
    private List<NewsBeans> mData = new ArrayList<>();
    private List<NewsMessageBeans> messageData = new ArrayList<>();


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 10:
                    String response = (String) msg.obj;
                    NewsBeans newsBeans = new Gson().fromJson(response, NewsBeans.class);
                    mData.add(newsBeans);

                    for (int i = 0; i < mData.get(0).getData().getLogos().size(); i++) {
                        View ret = LayoutInflater.from(getActivity()).inflate(R.layout.newstitle_item, null);
                        newsTitleImg = (ImageView) ret.findViewById(R.id.news_title_img);
                        newsTitletext = (TextView) ret.findViewById(R.id.news_title_name);
                        String logoPath = mData.get(0).getData().getLogos().get(i).getLogo();

                        newsTitletext.setText(mData.get(0).getData().getLogos().get(i).getName());
                        Picasso.with(getActivity())
                                .load(logoPath)
                                .resize(200, 200)
                                .noFade()
                                .placeholder(R.mipmap.placeholder)
                                .error(android.R.drawable.stat_notify_error)
                                .transform((Transformation) new CircleTransform(getActivity()))
                                .into(newsTitleImg);

                        mScrollView.addView(ret);
                    }
                    break;

                case 11:
                    String data = (String) msg.obj;
                    NewsMessageBeans messageBeans = new Gson().fromJson(data, NewsMessageBeans.class);
                    messageData.add(messageBeans);
                    mAdapter.notifyDataSetChanged();

                    break;
            }
        }
    };
    private NewsAdapter mAdapter;

    public NewsSecondFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View ret = inflater.inflate(R.layout.fragment_news_second, container, false);
        initView(ret);

        initData();

        initAdapter();

        return ret;
    }

    private void initAdapter() {
        mAdapter = new NewsAdapter(NewsSecondFragment.this, messageData);
        mRecyclerView.setAdapter(mAdapter);
    }


    private void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        map = new HashMap<>();
        map.put("methodName", "TourLogo");
        map.put("version", "4.4");
        map.put("user_id", "1795237");
        map.put("_time", "1481511774");
        map.put("_signature", "636f35d2a157132653d4d9edbd869562");

        VolleyUtils.postRequest(requestQueue, COOKBOOK_PATH, map, new VolleyUtils.VolleyCallback() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    Message msg = Message.obtain();
                    msg.what = 10;
                    msg.obj = response;
                    mHandler.sendMessage(msg);
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        mAdapter.setCallBack(new NewsAdapter.PageCallBack() {
            @Override
            public void getCount(int pa) {
                page=pa+"";
            }
        });
        map = new HashMap<>();
        map.put("methodName", "TourIndex");
        map.put("version", "4.4");
        map.put("page", page);
        map.put("size", "10");
        map.put("type", "2");
        map.put("catid", "7");
        map.put("user_id", "1795237");
        map.put("_time", "1481511774");
        map.put("_signature", "636f35d2a157132653d4d9edbd869562");

        VolleyUtils.postRequest(requestQueue, COOKBOOK_PATH, map, new VolleyUtils.VolleyCallback() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    Message msg = Message.obtain();
                    msg.what = 11;
                    msg.obj = response;
                    mHandler.sendMessage(msg);
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("TAG", "----------->newsSecond数据加载失败:");
            }
        });
    }

    private void initView(View ret) {
        mRecyclerView = (ListView) ret.findViewById(R.id.news_second_listView);
        mScrollView = (HorizontalScrollView) ret.findViewById(R.id.news_second_scrollView);
        title = (TextView) ret.findViewById(R.id.news_title);
        stat = (Button) ret.findViewById(R.id.news_static);
        share = (Button) ret.findViewById(R.id.news_share);

        stat.setOnClickListener(new View.OnClickListener() {//后退的监听
            @Override
            public void onClick(View v) {
            }
        });

        share.setOnClickListener(new View.OnClickListener() {//分享的监听
            @Override
            public void onClick(View v) {
                showShare();

            }
        });
    }

    private void showShare() {
        ShareSDK.initSDK(getActivity());
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("标题");
        // titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(getActivity());
    }


}


