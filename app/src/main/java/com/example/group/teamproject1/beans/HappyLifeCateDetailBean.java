package com.example.group.teamproject1.beans;

import java.util.List;

/**
 * Created by kongalong on 2016/12/13.
 */

public class HappyLifeCateDetailBean {

    /**
     * code : 0
     * msg : success
     * version : 4.4
     * timestamp : 1481615645000
     * data : {"series_id":"130","series_name":"#可可私厨#山药玫瑰饼CP","series_title":"药玫瑰饼CP,沉下心来做一道精致的下午茶甜点,约上三两好友下午茶,或者给TA一份爱意满满的惊喜。","create_time":"2016-11-29 14:19:34","last_update":"2016-12-06 15:37:22","order_no":"1","tag":"","episode":2,"series_image":"http://img.szzhangchu.com/1481009842372_7463683948.jpg","share_title":null,"share_description":null,"share_image":null,"album":"","album_logo":"1481009842643_9770458379.jpg","relate_activity":"159","data":[{"course_id":2033,"course_video":"http://video.szzhangchu.com/1480383111134_1890686890.mp4","episode":1,"course_name":"玫瑰煎饺","course_subject":"颜值妥妥的煎饺来啦！","course_image":"http://img.szzhangchu.com/1480400438757_3603961709.jpg","ischarge":"0","price":"0","video_watchcount":5122,"course_introduce":"","is_collect":0,"is_like":0},{"course_id":2101,"course_video":"http://video.szzhangchu.com/1481008508809_7266325767.mp4","episode":2,"course_name":"山药玫瑰饼CP","course_subject":"药玫瑰饼CP,沉下心来做一道精致的下午茶甜点,约上三两好友下午茶,或者给TA一份爱意满满的惊喜。","course_image":"http://img.szzhangchu.com/1481010384747_4849128295.jpg","ischarge":"0","price":"0","video_watchcount":11,"course_introduce":"","is_collect":0,"is_like":0}],"play":5133,"share_url":"http://m.izhangchu.com/micro/shike.php?&amp;material_id=130"}
     */

    private String code;
    private String msg;
    private String version;
    private long timestamp;
    /**
     * series_id : 130
     * series_name : #可可私厨#山药玫瑰饼CP
     * series_title : 药玫瑰饼CP,沉下心来做一道精致的下午茶甜点,约上三两好友下午茶,或者给TA一份爱意满满的惊喜。
     * create_time : 2016-11-29 14:19:34
     * last_update : 2016-12-06 15:37:22
     * order_no : 1
     * tag :
     * episode : 2
     * series_image : http://img.szzhangchu.com/1481009842372_7463683948.jpg
     * share_title : null
     * share_description : null
     * share_image : null
     * album :
     * album_logo : 1481009842643_9770458379.jpg
     * relate_activity : 159
     * data : [{"course_id":2033,"course_video":"http://video.szzhangchu.com/1480383111134_1890686890.mp4","episode":1,"course_name":"玫瑰煎饺","course_subject":"颜值妥妥的煎饺来啦！","course_image":"http://img.szzhangchu.com/1480400438757_3603961709.jpg","ischarge":"0","price":"0","video_watchcount":5122,"course_introduce":"","is_collect":0,"is_like":0},{"course_id":2101,"course_video":"http://video.szzhangchu.com/1481008508809_7266325767.mp4","episode":2,"course_name":"山药玫瑰饼CP","course_subject":"药玫瑰饼CP,沉下心来做一道精致的下午茶甜点,约上三两好友下午茶,或者给TA一份爱意满满的惊喜。","course_image":"http://img.szzhangchu.com/1481010384747_4849128295.jpg","ischarge":"0","price":"0","video_watchcount":11,"course_introduce":"","is_collect":0,"is_like":0}]
     * play : 5133
     * share_url : http://m.izhangchu.com/micro/shike.php?&amp;material_id=130
     */

    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String series_id;
        private String series_name;
        private String series_title;
        private String create_time;
        private String last_update;
        private String order_no;
        private String tag;
        private int episode;
        private String series_image;
        private Object share_title;
        private Object share_description;
        private Object share_image;
        private String album;
        private String album_logo;
        private String relate_activity;
        private int play;
        private String share_url;
        /**
         * course_id : 2033
         * course_video : http://video.szzhangchu.com/1480383111134_1890686890.mp4
         * episode : 1
         * course_name : 玫瑰煎饺
         * course_subject : 颜值妥妥的煎饺来啦！
         * course_image : http://img.szzhangchu.com/1480400438757_3603961709.jpg
         * ischarge : 0
         * price : 0
         * video_watchcount : 5122
         * course_introduce :
         * is_collect : 0
         * is_like : 0
         */

        private List<DataBean1> data;

        public String getSeries_id() {
            return series_id;
        }

        public void setSeries_id(String series_id) {
            this.series_id = series_id;
        }

        public String getSeries_name() {
            return series_name;
        }

        public void setSeries_name(String series_name) {
            this.series_name = series_name;
        }

        public String getSeries_title() {
            return series_title;
        }

        public void setSeries_title(String series_title) {
            this.series_title = series_title;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getLast_update() {
            return last_update;
        }

        public void setLast_update(String last_update) {
            this.last_update = last_update;
        }

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public int getEpisode() {
            return episode;
        }

        public void setEpisode(int episode) {
            this.episode = episode;
        }

        public String getSeries_image() {
            return series_image;
        }

        public void setSeries_image(String series_image) {
            this.series_image = series_image;
        }

        public Object getShare_title() {
            return share_title;
        }

        public void setShare_title(Object share_title) {
            this.share_title = share_title;
        }

        public Object getShare_description() {
            return share_description;
        }

        public void setShare_description(Object share_description) {
            this.share_description = share_description;
        }

        public Object getShare_image() {
            return share_image;
        }

        public void setShare_image(Object share_image) {
            this.share_image = share_image;
        }

        public String getAlbum() {
            return album;
        }

        public void setAlbum(String album) {
            this.album = album;
        }

        public String getAlbum_logo() {
            return album_logo;
        }

        public void setAlbum_logo(String album_logo) {
            this.album_logo = album_logo;
        }

        public String getRelate_activity() {
            return relate_activity;
        }

        public void setRelate_activity(String relate_activity) {
            this.relate_activity = relate_activity;
        }

        public int getPlay() {
            return play;
        }

        public void setPlay(int play) {
            this.play = play;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public List<DataBean1> getData() {
            return data;
        }

        public void setData(List<DataBean1> data) {
            this.data = data;
        }

        public static class DataBean1 {
            private int course_id;
            private String course_video;
            private int episode;
            private String course_name;
            private String course_subject;
            private String course_image;
            private String ischarge;
            private String price;
            private int video_watchcount;
            private String course_introduce;
            private int is_collect;
            private int is_like;

            public int getCourse_id() {
                return course_id;
            }

            public void setCourse_id(int course_id) {
                this.course_id = course_id;
            }

            public String getCourse_video() {
                return course_video;
            }

            public void setCourse_video(String course_video) {
                this.course_video = course_video;
            }

            public int getEpisode() {
                return episode;
            }

            public void setEpisode(int episode) {
                this.episode = episode;
            }

            public String getCourse_name() {
                return course_name;
            }

            public void setCourse_name(String course_name) {
                this.course_name = course_name;
            }

            public String getCourse_subject() {
                return course_subject;
            }

            public void setCourse_subject(String course_subject) {
                this.course_subject = course_subject;
            }

            public String getCourse_image() {
                return course_image;
            }

            public void setCourse_image(String course_image) {
                this.course_image = course_image;
            }

            public String getIscharge() {
                return ischarge;
            }

            public void setIscharge(String ischarge) {
                this.ischarge = ischarge;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public int getVideo_watchcount() {
                return video_watchcount;
            }

            public void setVideo_watchcount(int video_watchcount) {
                this.video_watchcount = video_watchcount;
            }

            public String getCourse_introduce() {
                return course_introduce;
            }

            public void setCourse_introduce(String course_introduce) {
                this.course_introduce = course_introduce;
            }

            public int getIs_collect() {
                return is_collect;
            }

            public void setIs_collect(int is_collect) {
                this.is_collect = is_collect;
            }

            public int getIs_like() {
                return is_like;
            }

            public void setIs_like(int is_like) {
                this.is_like = is_like;
            }
        }
    }
}
