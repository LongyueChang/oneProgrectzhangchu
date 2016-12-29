package com.example.group.teamproject1.beans;

import java.util.List;

/**
 * Created by Administrator on 2016/12/26.
 */

public class NewsMessageBeans {

    /**
     * code : 0
     * msg : success
     * version : 4.0
     * timestamp : 1482742007000
     * data : {"type":2,"type_name":"kitchenskill","page":"1","size":"10","total":"37","count":"10","data":[{"id":"37","title":"怎样选择酸奶，酸奶哪种比较好？","image":"http://img.szzhangchu.com/1465005924234_5282707690.jpg","video":"","views":"42355"},{"id":"36","title":"怎样挑选新鲜好羊肉","image":"http://img.szzhangchu.com/1465005509513_4444360370.jpg","video":"","views":"44129"},{"id":"35","title":"怎样让苹果保持新鲜好吃？","image":"http://img.szzhangchu.com/1465005158254_8072024300.jpg","video":"","views":"33115"},{"id":"34","title":"怎样巧妙判断冬笋的老嫩","image":"http://img.szzhangchu.com/1465004779191_9929774526.jpg","video":"","views":"27427"},{"id":"33","title":"怎样防止面食品变硬","image":"http://img.szzhangchu.com/1464947547158_8432305556.jpg","video":"","views":"41046"},{"id":"32","title":"怎样的当归才是好当归","image":"http://img.szzhangchu.com/1464946938121_9618615210.jpg","video":"","views":"33371"},{"id":"31","title":"怎么挑选新鲜牛肉？","image":"http://img.szzhangchu.com/1464946503087_5827121785.jpg","video":"","views":"35712"},{"id":"30","title":"怎么挑选购买菜花？","image":"http://img.szzhangchu.com/1464945480787_4604557060.jpg","video":"","views":"40096"},{"id":"29","title":"该怎么辨别土鸡蛋？","image":"http://img.szzhangchu.com/1464944729970_4784417359.jpg","video":"","views":"28356"},{"id":"28","title":"土豆储存方法有哪些？","image":"http://img.szzhangchu.com/1464943647206_7084128597.jpg","video":"","views":"32417"}]}
     */

    private String code;
    private String msg;
    private String version;
    private long timestamp;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * type : 2
         * type_name : kitchenskill
         * page : 1
         * size : 10
         * total : 37
         * count : 10
         * data : [{"id":"37","title":"怎样选择酸奶，酸奶哪种比较好？","image":"http://img.szzhangchu.com/1465005924234_5282707690.jpg","video":"","views":"42355"},{"id":"36","title":"怎样挑选新鲜好羊肉","image":"http://img.szzhangchu.com/1465005509513_4444360370.jpg","video":"","views":"44129"},{"id":"35","title":"怎样让苹果保持新鲜好吃？","image":"http://img.szzhangchu.com/1465005158254_8072024300.jpg","video":"","views":"33115"},{"id":"34","title":"怎样巧妙判断冬笋的老嫩","image":"http://img.szzhangchu.com/1465004779191_9929774526.jpg","video":"","views":"27427"},{"id":"33","title":"怎样防止面食品变硬","image":"http://img.szzhangchu.com/1464947547158_8432305556.jpg","video":"","views":"41046"},{"id":"32","title":"怎样的当归才是好当归","image":"http://img.szzhangchu.com/1464946938121_9618615210.jpg","video":"","views":"33371"},{"id":"31","title":"怎么挑选新鲜牛肉？","image":"http://img.szzhangchu.com/1464946503087_5827121785.jpg","video":"","views":"35712"},{"id":"30","title":"怎么挑选购买菜花？","image":"http://img.szzhangchu.com/1464945480787_4604557060.jpg","video":"","views":"40096"},{"id":"29","title":"该怎么辨别土鸡蛋？","image":"http://img.szzhangchu.com/1464944729970_4784417359.jpg","video":"","views":"28356"},{"id":"28","title":"土豆储存方法有哪些？","image":"http://img.szzhangchu.com/1464943647206_7084128597.jpg","video":"","views":"32417"}]
         */

        private int type;
        private String type_name;
        private String page;
        private String size;
        private String total;
        private String count;
        private List<DataBean> data;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }

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

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 37
             * title : 怎样选择酸奶，酸奶哪种比较好？
             * image : http://img.szzhangchu.com/1465005924234_5282707690.jpg
             * video :
             * views : 42355
             */

            private String id;
            private String title;
            private String image;
            private String video;
            private String views;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getVideo() {
                return video;
            }

            public void setVideo(String video) {
                this.video = video;
            }

            public String getViews() {
                return views;
            }

            public void setViews(String views) {
                this.views = views;
            }
        }
    }
}
