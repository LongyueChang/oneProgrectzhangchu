package com.example.group.teamproject1.beans;

import java.util.List;

/**
 * Created by kongalong on 2016/12/13.
 */

public class HappyLifeCateCourseRelateBean {

    /**
     * code : 0
     * msg : success
     * version : 4.0
     * timestamp : 1481616654000
     * data : {"page":"1","size":"10","total":"3","count":"3","data":[{"media_id":"1598","media_type":"1","relation":{"dishes_id":"1598","dishes_title":"爱吃煎饺的都别举手","dishes_image":"http://img.szzhangchu.com/1439361259284_4030453636.jpg","material_video":"http://video.szzhangchu.com/zhurouqincaijianjiaoA.mp4","process_video":"http://video.szzhangchu.com/zhurouqincaijianjiaoB.mp4"}},{"media_id":"10196","media_type":"1","relation":{"dishes_id":"10196","dishes_title":"有人说清新，有人说重口","dishes_image":"http://img.szzhangchu.com/dish_20141204171002644.jpg","material_video":"http://video.szzhangchu.com/jiucaijidanjianjiaoA.mp4","process_video":"http://video.szzhangchu.com/jiucaijidanjianjiaoB.mp4"}},{"media_id":"8384","media_type":"1","relation":{"dishes_id":"8384","dishes_title":"外脆里嫩家常饺","dishes_image":"http://img.szzhangchu.com/1439973085563_5928791128.JPG","material_video":"http://video.szzhangchu.com/jiucaizhuroujianjiaoA.mp4","process_video":"http://video.szzhangchu.com/jiucaizhuroujianjiaoB.mp4"}}]}
     */

    private String code;
    private String msg;
    private String version;
    private long timestamp;
    /**
     * page : 1
     * size : 10
     * total : 3
     * count : 3
     * data : [{"media_id":"1598","media_type":"1","relation":{"dishes_id":"1598","dishes_title":"爱吃煎饺的都别举手","dishes_image":"http://img.szzhangchu.com/1439361259284_4030453636.jpg","material_video":"http://video.szzhangchu.com/zhurouqincaijianjiaoA.mp4","process_video":"http://video.szzhangchu.com/zhurouqincaijianjiaoB.mp4"}},{"media_id":"10196","media_type":"1","relation":{"dishes_id":"10196","dishes_title":"有人说清新，有人说重口","dishes_image":"http://img.szzhangchu.com/dish_20141204171002644.jpg","material_video":"http://video.szzhangchu.com/jiucaijidanjianjiaoA.mp4","process_video":"http://video.szzhangchu.com/jiucaijidanjianjiaoB.mp4"}},{"media_id":"8384","media_type":"1","relation":{"dishes_id":"8384","dishes_title":"外脆里嫩家常饺","dishes_image":"http://img.szzhangchu.com/1439973085563_5928791128.JPG","material_video":"http://video.szzhangchu.com/jiucaizhuroujianjiaoA.mp4","process_video":"http://video.szzhangchu.com/jiucaizhuroujianjiaoB.mp4"}}]
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
        private String page;
        private String size;
        private String total;
        private String count;
        /**
         * media_id : 1598
         * media_type : 1
         * relation : {"dishes_id":"1598","dishes_title":"爱吃煎饺的都别举手","dishes_image":"http://img.szzhangchu.com/1439361259284_4030453636.jpg","material_video":"http://video.szzhangchu.com/zhurouqincaijianjiaoA.mp4","process_video":"http://video.szzhangchu.com/zhurouqincaijianjiaoB.mp4"}
         */

        private List<DataBean1> data;

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public List<DataBean1> getData() {
            return data;
        }

        public void setData(List<DataBean1> data) {
            this.data = data;
        }

        public static class DataBean1 {
            private String media_id;
            private String media_type;
            /**
             * dishes_id : 1598
             * dishes_title : 爱吃煎饺的都别举手
             * dishes_image : http://img.szzhangchu.com/1439361259284_4030453636.jpg
             * material_video : http://video.szzhangchu.com/zhurouqincaijianjiaoA.mp4
             * process_video : http://video.szzhangchu.com/zhurouqincaijianjiaoB.mp4
             */

            private RelationBean relation;

            public String getMedia_id() {
                return media_id;
            }

            public void setMedia_id(String media_id) {
                this.media_id = media_id;
            }

            public String getMedia_type() {
                return media_type;
            }

            public void setMedia_type(String media_type) {
                this.media_type = media_type;
            }

            public RelationBean getRelation() {
                return relation;
            }

            public void setRelation(RelationBean relation) {
                this.relation = relation;
            }

            public static class RelationBean {
                private String dishes_id;
                private String dishes_title;
                private String dishes_image;
                private String material_video;
                private String process_video;

                public String getDishes_id() {
                    return dishes_id;
                }

                public void setDishes_id(String dishes_id) {
                    this.dishes_id = dishes_id;
                }

                public String getDishes_title() {
                    return dishes_title;
                }

                public void setDishes_title(String dishes_title) {
                    this.dishes_title = dishes_title;
                }

                public String getDishes_image() {
                    return dishes_image;
                }

                public void setDishes_image(String dishes_image) {
                    this.dishes_image = dishes_image;
                }

                public String getMaterial_video() {
                    return material_video;
                }

                public void setMaterial_video(String material_video) {
                    this.material_video = material_video;
                }

                public String getProcess_video() {
                    return process_video;
                }

                public void setProcess_video(String process_video) {
                    this.process_video = process_video;
                }
            }
        }
    }
}
