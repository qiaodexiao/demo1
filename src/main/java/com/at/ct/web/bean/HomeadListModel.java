package com.at.ct.web.bean;

import java.util.List;

public class HomeadListModel {
    /**
     * code : 1
     * data : {"homeadlist":[{"id":1,"imgurl":"/img/homead/a73b3f1d-0f14-429d-9d0f-70643fb0f0eb.jpg","jumpflag":0,"jumpurl":"","posflag":1,"remark":"1111","cityid":1},{"id":12,"imgurl":"/img/homead/eb442fbf-49db-4ba6-a102-d781505f426d.jpg","jumpflag":0,"jumpurl":"","posflag":2,"remark":"","cityid":1},{"id":14,"imgurl":"/img/homead/68109460-635d-4c5c-8be8-64d7c7889d18.jpg","jumpflag":0,"jumpurl":"http://shiranlife.kuaizhan.com/","posflag":4,"remark":"","cityid":1}]}
     */

    public int code;
    public DataBean data;
    public static class DataBean {
        public List<HomeadlistBean> homeadlist;

        public static class HomeadlistBean {
            public int id;
            public String imgurl;
            public int jumpflag;
            public String jumpurl;
            public int posflag;
            public String remark;
            public int cityid;
        }
    }

}
