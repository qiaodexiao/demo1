package com.at.ct.web.bean;

public class DataModel {

    /**
     * subject : "荔枝新闻3.0：不止是阅读"
     * summary : "江苏广电旗下资讯类手机应用“荔枝新闻”于近期推出全新升级换代的3.0版。"
     * cover : "/Attachs/Article/288340/3e8e2c397c70469f8845fad73aa38165_padmini.JPG"
     * pic :
     * format : video
     * changed : 2015-11-07 14:35:22
     */
    private String subject;
    private String summary;
    private String cover;
    private String pic;
    private String format;
    private String changed;


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }
}
