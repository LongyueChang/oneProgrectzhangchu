package com.example.group.teamproject1.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * Created by Administrator on 2016/12/12.
 */

public class VolleyUtils {

    public interface VolleyCallback{
        void onResponse(String response);
        void onErrorResponse(VolleyError error);
    }


    /**
     * volley get 的封装
     * @param mRequestQueue
     * @param url
     * @param callback
     */
    public static void getRequest(RequestQueue mRequestQueue, String url, final VolleyCallback callback){

        StringRequest request=new StringRequest(Request.Method.GET
                , url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response != null) {
                    callback.onResponse(response);                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onErrorResponse(error);
            }
        })
        {
            @Override
            public Priority getPriority() {//提高请求优先级
                return Priority.HIGH;
            }
        };

        mRequestQueue.add(request);
    }


    /**
     * volley post 的封装
     * @param mRequestQueue
     * @param url
     * @param map
     * @param callback
     */
    public static void postRequest(RequestQueue mRequestQueue, String url
            , final Map<String,String> map, final VolleyCallback callback){

        StringRequest request=new StringRequest(Request.Method.POST
                , url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response != null) {
                    callback.onResponse(response);                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onErrorResponse(error);
            }
        })
        {
            @Override
            protected Map<String, String> getParams()
                    throws AuthFailureError {

                return map;
            }

            @Override
            public Priority getPriority() {//提高请求优先级
                return Priority.HIGH;
            }
        };

        mRequestQueue.add(request);
    }




    public static byte[] getCatch(RequestQueue mRequestQueue,String path) {
        Cache cache = mRequestQueue.getCache();
        byte[] data=null;
        if (cache != null) {
            Cache.Entry entry = cache.get(path);
            if (entry != null) {
               data = entry.data;
                return data;
            }
        }
        return null;
    }
}
