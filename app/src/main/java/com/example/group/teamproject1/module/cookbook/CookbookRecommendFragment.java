package com.example.group.teamproject1.module.cookbook;


import android.graphics.Rect;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.group.teamproject1.MainActivity;
import com.example.group.teamproject1.R;
import com.example.group.teamproject1.beans.CookBookBean;
import com.example.group.teamproject1.common.BaseFragment;
import com.example.group.teamproject1.module.cookbook.adapter.CookAdapter;
import com.example.group.teamproject1.utils.JsonUtil;
import com.example.group.teamproject1.utils.SDCardHelper;
import com.example.group.teamproject1.utils.VolleyUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.group.teamproject1.api.Apis.COOKBOOK_PATH;

/**
 * A simple {@link Fragment} subclass.
 */
public class CookbookRecommendFragment extends BaseFragment {
    private RecyclerView mRecyclerView;
    private RequestQueue mRequestQueue;
    private final int CookBook_Code=1;
    private List<CookBookBean> mData=new ArrayList<>();
    private List<ImageView> imageDagta=new ArrayList<>();
    private CookAdapter mAdapter;

    private Handler mHandler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case CookBook_Code:
                    String response = (String) msg.obj;
                    CookBookBean cook = JsonUtil.parseJsonToCookBookBean(response);

                    mData.add(cook);
                    Log.i("TAG", "----------->cookbook获取的mData:" +mData);

                    for (int i = 0; i < cook.getData().getBanner().size(); i++) {
                        String imagePath = cook.getData().getBanner().get(i).getBanner_picture();
                        ImageView imageView=new ImageView(getContext());
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        Glide.with(getContext()).load(imagePath)
                                .placeholder(R.mipmap.placeholder)
                                .fitCenter()
                                .into(imageView);
                        imageDagta.add(imageView);
                        Log.i("TAG", "----------->cookbook获取的imageData:" +imageDagta);
                    }

                    initAdapter();

                    break;

            }
        }

        private void initAdapter() {
            LinearLayoutManager manager=new LinearLayoutManager(getContext());
            manager.setOrientation(LinearLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(manager);

            int size = getResources().getDimensionPixelSize(R.dimen.space);
            mAdapter = new CookAdapter((MainActivity) getActivity(), mData);
            mAdapter.addHeaderView(imageDagta);
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.addItemDecoration(new SpaceDuration(size));


        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_cookbook_recommend;
    }

    @Override
    protected void initView(View ret) {
        mRecyclerView= (RecyclerView) ret.findViewById(R.id.cookRecomebook_recycleView);


    }

    @Override
    protected void initEvent() {
    }

    @Override
    protected void initData() {

        String filePath=
                Environment.getExternalStorageDirectory().getAbsolutePath()
                        +File.separator+"aa"+File.separator+"cookBook";
        Log.i("TAG", "----------->filePath:" +filePath);
        File file=new File(filePath);
        if(file.exists()){
            byte[] bytes = SDCardHelper.loadFileFromSDCard(filePath);
            if (bytes != null) {
                Message msg = Message.obtain();
                Log.i("TAG", "----------->内存中的response:" +new String(bytes));
                msg.what = CookBook_Code;
                msg.obj = new String(bytes);
                mHandler.sendMessage(msg);
            }

        }else {
            mRequestQueue = Volley.newRequestQueue(getContext());
            Map<String, String> map = new HashMap<>();
            map.put("token", "9BCA7B5084FBD32BDE1ACD58880B9F30");
            map.put("user_id", "1795237");
            map.put("methodName", "SceneHome");
            map.put("version", "4.40");

            VolleyUtils.postRequest(mRequestQueue, COOKBOOK_PATH, map, new VolleyUtils.VolleyCallback() {
                @Override
                public void onResponse(String response) {
                    if (response != null) {
                        boolean isSave =
                                SDCardHelper.saveFileToSDCardCustomDir
                                        (response.getBytes(),
                                "aa", "cookBook");
                        Log.i("TAG", "----------->文件已经保存路径:"+isSave);
                        Message msg = Message.obtain();
                        msg.what = CookBook_Code;
                        msg.obj = response;
                        mHandler.sendMessage(msg);
                    }
                }

                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });
        }
    }

    public class SpaceDuration extends RecyclerView.ItemDecoration{
        private int space;

        public SpaceDuration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

            if(parent.getChildAdapterPosition(view)!=0){
                outRect.top=space;
            }
        }
    }
}
