package com.at.ct.web.query;

import java.util.List;

/**
 * Created by thinkpad on 2019/9/11.
 */

public class PageResult {


    //来源于前台
    private Integer currentPage;//当前页
    private Integer pageSize;  //显示几条数据


    //从数据库查询出
    private Integer totalCount; //总个数
    private List list;

    //计算得到
    private Integer totalPages;  //总页数
    private Integer prevPage;   //上一页
    private Integer nextPage;  //下一页


    public PageResult(Integer currentPage, Integer pageSize, List list, Integer totalCount){
        this.currentPage = currentPage;
        this.pageSize = pageSize;

        this.list = list;
        this.totalCount = totalCount;

        this.totalPages = Double.valueOf(Math.ceil(totalCount*1.0/pageSize)).intValue();
        this.prevPage = currentPage - 1> 1 ? currentPage - 1: 1 ;
        this.nextPage = currentPage + 1<totalPages ? currentPage + 1:totalPages;

    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public List getList() {
        return list;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getPrevPage() {
        return prevPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public void setList(List list) {
        this.list = list;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public void setPrevPage(Integer prevPage) {
        this.prevPage = prevPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", list=" + list +
                ", totalPages=" + totalPages +
                ", prevPage=" + prevPage +
                ", nextPage=" + nextPage +
                '}';
    }
}
