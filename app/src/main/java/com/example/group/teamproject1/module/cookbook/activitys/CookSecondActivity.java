package com.example.group.teamproject1.module.cookbook.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.group.teamproject1.R;
import com.example.group.teamproject1.beans.CookTitleFishBeen;
import com.example.group.teamproject1.beans.CookTitleNoheatBeen;
import com.example.group.teamproject1.beans.CookTitlePancakeBeen;
import com.example.group.teamproject1.beans.CookTitleThreeBeen;
import com.example.group.teamproject1.beans.CookTitleWishBeen;
import com.example.group.teamproject1.module.cookbook.adapter.MyCookSecondAdapter;
import com.example.group.teamproject1.utils.SDCardHelper;
import com.example.group.teamproject1.utils.VolleyUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.group.teamproject1.api.Apis.COOKBOOK_PATH;

public class CookSecondActivity extends AppCompatActivity {
    private TextView showTitle;
    private RecyclerView mRecyclerView;
    private RequestQueue request;
    private List<Object> mData=new ArrayList<>();
    private List<Object> mHeaderData=new ArrayList<>();


    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 123:
                    Bundle bundle= (Bundle) msg.obj;
                    String id = bundle.getString("ids");
                    Log.i("TAG", "----------->cooksecond中的id:" +id);
                    String response = bundle.getString("response");
                    Gson gson=new Gson();
                    if(id.equals("100")){
                        CookTitleFishBeen fishBeen = gson.fromJson(response, CookTitleFishBeen.class);
                        mHeaderData.add(fishBeen);
                    }else if(id.equals("76")){
                        CookTitleWishBeen wishBeen = gson.fromJson(response, CookTitleWishBeen.class);
                        mHeaderData.add(wishBeen);
                    }else if(id.equals("23")){
                        CookTitleThreeBeen threeBeen = gson.fromJson(response, CookTitleThreeBeen.class);
                        mHeaderData.add(threeBeen);
                    }else if(id.equals("112")){
                        CookTitleNoheatBeen noheatBeen = gson.fromJson(response, CookTitleNoheatBeen.class);
                        mHeaderData.add(noheatBeen);

                    }else if(id.equals("109")){
                        CookTitlePancakeBeen pancakeBeen = gson.fromJson(response, CookTitlePancakeBeen.class);
                        mHeaderData.add(pancakeBeen);
                    }

                    initAdapter(id);
                    break;
            }
        }
    };
    private MyCookSecondAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_second);

        initView();//初始化控件

        initData();//获取数据源

    }

    private void initAdapter(String id) {

        //添加头布局
        mAdapter.addHeadView(id,mHeaderData);

        mAdapter = new MyCookSecondAdapter(this, mData);
    }


    private void initData() {
        Intent intent = getIntent();
        final String id = intent.getStringExtra("id");

        Log.i("TAG", "----------->second从外面传进来的id:" +id);

        request= Volley.newRequestQueue(this);
        Map<String,String> map=new HashMap<>();
        map.put("methodName","CourseSeriesView");
        map.put("series_id",id);
        map.put("token","9BCA7B5084FBD32BDE1ACD58880B9F30");
        map.put("user_id","1795237");
        map.put("version","4.4.0");


        VolleyUtils.postRequest(request, COOKBOOK_PATH, map
                , new VolleyUtils.VolleyCallback() {
                    @Override
                    public void onResponse(String response) {
                        if (response != null) {
                            SDCardHelper.saveFileToSDCardCustomDir(response.getBytes()
                            ,"cookSecond","response");
                            Bundle bundle=new Bundle();
                            bundle.putString("ids",id);
                            bundle.putString("response",response);
                            Message msg=Message.obtain();
                            msg.what=123;
                            msg.obj=bundle;
                            mHandler.sendMessage(msg);
                        }
                    }
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("TAG", "----------->cookSecondActivity获取数据失败:");
                    }
                });
    }

    private void initView() {
        showTitle= (TextView) findViewById(R.id.cook_showTitle);
        mRecyclerView= (RecyclerView) findViewById(R.id.cook_recycleView);
    }

    public void retreat(View view) {
        switch (view.getId()){
            case R.id.cook_static:
                finish();
                break;
        }
    }
}
