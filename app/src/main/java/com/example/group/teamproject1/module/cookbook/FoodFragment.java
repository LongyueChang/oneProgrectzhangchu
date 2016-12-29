package com.example.group.teamproject1.module.cookbook;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.group.teamproject1.R;
import com.example.group.teamproject1.beans.FoodBean;
import com.example.group.teamproject1.utils.VolleyUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.group.teamproject1.api.Apis.COOKBOOK_PATH;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {
    private GridView mGridView;
    private Button btStatic,btSelect,btAdd,bottomBt1,bottomBt2,bottomBt3;
    private ListView foodListView;
    private TextView btText1,btText2,textNum;
    private Map<String, String> map;
    private List<FoodBean> mData=new ArrayList<>();

    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 17:
                    String res= (String) msg.obj;
                    FoodBean foodBean = new Gson().fromJson(res, FoodBean.class);
                    mData.add(foodBean);
                    break;


            }
        }
    };


    public FoodFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_food, container, false);
        initView(ret);

        initData();
        return ret;
    }

    private void initData() {
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        map=new HashMap<>();
        map.put("material","");
        map.put("methodName","SearchMix");
        map.put("size","15");
        map.put("page","1");
        map.put("token","9BCA7B5084FBD32BDE1ACD58880B9F30");
        map.put("user_id","1795237");
        map.put("version","4.4.0");

        VolleyUtils.postRequest(requestQueue, COOKBOOK_PATH,
                map, new VolleyUtils.VolleyCallback() {
                    @Override
                    public void onResponse(String response) {
                        if (response != null) {
                            Message msg=Message.obtain();
                            msg.what=17;
                            msg.obj=response;
                            mHandler.sendMessage(msg);
                        }

                    }

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
    }

    private void initView(View ret) {
        mGridView= (GridView) ret.findViewById(R.id.food_gridView);
        btStatic= (Button) ret.findViewById(R.id.food_cook_static);
        btSelect= (Button) ret.findViewById(R.id.food_select_static);
        btAdd= (Button) ret.findViewById(R.id.food_bottom_add);
        bottomBt1= (Button) ret.findViewById(R.id.food_bottom_bt1);
        bottomBt2= (Button) ret.findViewById(R.id.food_bottom_bt2);
        bottomBt3= (Button) ret.findViewById(R.id.food_bottom_bt3);
        foodListView= (ListView) ret.findViewById(R.id.food_draw_listView);
        btText1= (TextView) ret.findViewById(R.id.food_bottom_text1);
        btText2= (TextView) ret.findViewById(R.id.food_bottom_text2);
        textNum= (TextView) ret.findViewById(R.id.food_text_num);
    }
}
