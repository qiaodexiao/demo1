package com.at.ct.web.query;

import com.mysql.jdbc.StringUtils;


/**
 * Created by thinkpad on 2019/9/11.
 */

public class QueryObject {


    private Integer currentPage = 1;

    private Integer pageSize = 2;



    private String userName;

    private String userTel;


    public String getUserName() {
        return StringUtils.isNullOrEmpty(this.userName)?null:this.userName;
    }

    public String getUserTel() {
        return StringUtils.isNullOrEmpty(this.userTel)?null:this.userTel;
    }


    public Integer getStart(){
        return (this.currentPage-1)*this.pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }


    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    @Override
    public String toString() {
        return "QueryObject{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                '}';
    }
}
