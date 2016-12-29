package com.example.group.teamproject1.utils;

import com.example.group.teamproject1.beans.CookBookBean;
import com.example.group.teamproject1.beans.HappLifeCateLogoBean;
import com.example.group.teamproject1.beans.HappyLifeCateBean;
import com.google.gson.Gson;

/**
 * Created by kongalong on 2016/12/12.
 */

public class JsonUtil {



    /**
     * 美食IP  数据解析
     */
    public static HappyLifeCateBean parseJsonToHappyLifeCateIPBeans(String json){

        Gson gson = new Gson();
        return gson.fromJson(json, HappyLifeCateBean.class);

    }

    /**
     * 美食IP logo  数据解析
     */
    public static HappLifeCateLogoBean parseJsonToHappLifeCateIPLogoBeans(String json){

        Gson gson = new Gson();
        return gson.fromJson(json, HappLifeCateLogoBean.class);

    }


    /**
     * 美食IP logo  数据解析
     */
    public static CookBookBean parseJsonToCookBookBean(String json){

        Gson gson = new Gson();
        return gson.fromJson(json, CookBookBean.class);

    }








}
