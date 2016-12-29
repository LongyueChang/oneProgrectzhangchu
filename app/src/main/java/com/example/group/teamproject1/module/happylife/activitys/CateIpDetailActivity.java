package com.example.group.teamproject1.module.happylife.activitys;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.VolleyError;
import com.example.group.teamproject1.R;
import com.example.group.teamproject1.api.Apis;
import com.example.group.teamproject1.beans.HappyLifeCateCommentListBean;
import com.example.group.teamproject1.beans.HappyLifeCateCourseRelateBean;
import com.example.group.teamproject1.beans.HappyLifeCateDetailBean;
import com.example.group.teamproject1.beans.HappyLifeCateZanBean;
import com.example.group.teamproject1.common.BaseActivity;
import com.example.group.teamproject1.utils.VolleyUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

public class CateIpDetailActivity extends BaseActivity {

    @BindView(R.id.happylife_cateipdetail_recycleview)
    public RecyclerView mRecyclerView;


    private List<Object> mData;

    private HappyLifeCateDetailBean.DataBean mDetailBean;
    private List<HappyLifeCateZanBean.DataBean.DataBean1> mZanBean;
    private List<HappyLifeCateCourseRelateBean.DataBean.DataBean1> mCourseRelateBean;
    private List<HappyLifeCateCommentListBean.DataBean.DataBean1> mCommentListBean;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_cate_ip_detail;
    }

    @Override
    protected void initView() {
        //初始化美食ip详情recycleview
        initDetialRecycleView();
    }


    @Override
    protected void initEvent() {

    }

    private void initDetialRecycleView() {

        //创建默认的线性LayoutManager
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this.getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);

        mData = new ArrayList<>();
        //创建并设置Adapter
       // mCateDetailAdapter = new CateDetailAdapter(this,mData);
       // mRecyclerView.setAdapter(mCateDetailAdapter);

    }




    @Override
    protected void initData() {

        //加载Detail页面数据
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("methodName", "CourseSeriesView");//methodName=CourseLogo
        map1.put("series_id", "130");//version: 4.4.0
        map1.put("version", "4.40");//version: 4.4.0
        postLoadDetailData(Apis.CATE_IP_API, map1);


        //加载点赞数据
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("post_id", "2101");//methodName=CourseLogo
        map2.put("methodName", "DianzanList");//version: 4.4.0
        map2.put("version", "4.40");//version: 4.4.0
        postLoadZanData(Apis.CATE_IP_API, map2);

        //加载相关课程数据
        Map<String, String> map3 = new HashMap<String, String>();
        map3.put(" size", "10");//methodName=CourseLogo
        map3.put("page", "1");//version: 4.4.0
        map3.put("course_id", "2101");//version: 4.4.0
        map3.put("methodName", "CourseRelate");//version: 4.4.0
        map3.put("version", "4.40");//version: 4.4.0
        postLoadCourseRelateData(Apis.CATE_IP_API, map3);

        //加载评论数据
        Map<String, String> map4 = new HashMap<String, String>();
        map4.put(" size", "10");//methodName=CourseLogo
        map4.put("page", "1");//version: 4.4.0
        map4.put("course_id", "2101");//version: 4.4.0
        map4.put("methodName", "CourseRelate");//version: 4.4.0
        map4.put("version", "4.40");//version: 4.4.0
        postLoadCommentListData(Apis.CATE_IP_API, map4);

    }



    private void postLoadDetailData(String url, final Map<String,String> map){

        VolleyUtils.postRequest(mRequestQueue, url, map, new VolleyUtils.VolleyCallback() {
            @Override
            public void onResponse(String response) {
                Log.d("flag", "onResponse1: " +response);
              //  mDetailBean = JsonUtil
               //         .parseJsonToHappyLifeCateDetailBean(response).getData();

                //refleshCateLogoData(mHappyLifeCateLogoBeans);
            }
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }
    private void postLoadZanData(String url, Map<String, String> map) {

        VolleyUtils.postRequest(mRequestQueue, url, map, new VolleyUtils.VolleyCallback() {
            @Override
            public void onResponse(String response) {
                Log.d("flag", "onResponse2: " +response);
               // mZanBean = JsonUtil
               //         .parseJsonToHappyLifeCateZanBean(response).getData()
                //        .getData();

                //refleshCateLogoData(mHappyLifeCateLogoBeans);
            }
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }

    private void postLoadCourseRelateData(String url, Map<String, String> map) {
        VolleyUtils.postRequest(mRequestQueue, url, map, new VolleyUtils.VolleyCallback() {
            @Override
            public void onResponse(String response) {
                Log.d("flag", "onResponse3: " +response);
               // mCourseRelateBean = JsonUtil
                //        .parseJsonToHappyLifeCateCourseRelateBean(response)
                //        .getData().getData();

                //refleshCateLogoData(mHappyLifeCateLogoBeans);
            }
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }


    private void postLoadCommentListData(String url, Map<String, String> map) {
        VolleyUtils.postRequest(mRequestQueue, url, map, new VolleyUtils.VolleyCallback() {
            @Override
            public void onResponse(String response) {

                Log.d("flag", "onResponse4: " +response);
               // mCommentListBean = JsonUtil
               //         .parseJsonToHappyLifeCateCommentListBean(response)
               //         .getData().getData();

                //refleshCateLogoData(mHappyLifeCateLogoBeans);
            }
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}
