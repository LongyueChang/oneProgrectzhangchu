package com.example.group.teamproject1.api;

/**
 * Created by kongalong on 2016/12/12.
 */


/**
 *
 * 各种Api接口
 *
 */

public class Apis {



    /**
     * 美食IP
     *
     *page=1			methodName=CourseIndex
     *size=20  		version=4.40
     *
     *
     *悬浮logo信息
     * methodName=CourseLogo		version: 4.4.0
     *
     */

    /**
     * 美食ip 详情页面
     *
     * 详情界面:Series_id不一样，Series_id从happyLife_cate_id中获取
     methodName  :CourseSeriesView
     series_id 130		version 4.40
     (  video_watchcount观看人数   is_collect 是否收藏  course_video 视频
     详情中有不同的视频集数，对该视频的点赞和课程相关都不一样)

     *
     *点赞：post_id不一样，post_id从详情中获取
     post_id : 2101		methodName  :DianzanList  mediaType  :3	 version  :4.40

     *
     *
     *课程相关：course_id与post_id一样
     size=10&version=4.40&page=1&course_id=2101&methodName=CourseRelate

     *
     *评论：Relate_id与详情id一样
     relate_id  :130		type  :2 		page  :1		methodName  :CommentList
     size 20 		version 4.40
     (parent属性与回复有关)
     *
     */

    public static final String CATE_IP_API = "http://api.izhangchu.com/";

    /**
     *食谱：
     * 推荐界面:L
     * COOKBOOK_PATH(post请求的键值对)
     *methodName			SceneHome
     * version				4.4.0
     *
     *
     * 头布局图片跳转对应的键值对:
     * 第一个:
     * methodName           MaterialView
     * version              1.0
     * series_id            148
     * user_id              1795237
     * _time                1482065503
     * token                7ed755201febca616dc6a86c66519b66
     *
     *
     *  methodName			CourseSeriesView
     *  series_id		    100,76,23,112,
     *  token				9BCA7B5084FBD32BDE1ACD58880B9F30
     *  user_id				1795237
     *  version				4.4.0
     *
     * 新手入门头部局中滑动条目
     *  methodName			TourLogo
     *  version				4.4
     *  user_id				1795237
     *   _time				1481511774
     *   _signature			636f35d2a157132653d4d9edbd869562
     *
     *   新手入门内容对应的数据信息
     *   methodName			TourIndex
     *   version			4.4
     *   page				1
     *   size				10
     *   type				2
     *   catid				7
     *   user_id			1795237
     *   _time				1481511774
     *   _signature			636f35d2a157132653d4d9edbd869562
     *
     */

    public static final String COOKBOOK_PATH="http://api.izhangchu.com/";








}
