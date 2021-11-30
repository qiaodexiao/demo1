package com.at.ct.web.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by zhaoxuan
 * 2018/5/17 14:49
 */
public class DoubleDimeEn {
    @JSONField(name="LOCATION_ID")
    private String LOCATION_ID;
    @JSONField(name="X_INDEX")
    private Integer X_INDEX;
    @JSONField(name="Y_INDEX")
    private Integer Y_INDEX;
    @JSONField(name="X_SQL")
    private String X_SQL;
    @JSONField(name="Y_SQL")
    private String Y_SQL;
    @JSONField(name="SQL")
    private String SQL;
    @JSONField(name="X_NAME")
    private String X_NAME;
    @JSONField(name="Y_NAME")
    private String Y_NAME;
    @JSONField(name="USER_COUNT")
    private Long USER_COUNT;

    public DoubleDimeEn() {
    }

    public DoubleDimeEn(String locationId, Integer xIndex, Integer yIndex, String xSql, String ySql, String sql, String xName, String yName, Long userCount) {
        this.LOCATION_ID = locationId;
        this.X_INDEX = xIndex;
        this.Y_INDEX = yIndex;
        this.X_SQL = xSql;
        this.Y_SQL = ySql;
        this.SQL = sql;
        this.X_NAME = xName;
        this.Y_NAME = yName;
        this.USER_COUNT = userCount;
    }

    public String getLocationId() {
        return LOCATION_ID;
    }

    public void setLocationId(String locationId) {
        this.LOCATION_ID = locationId;
    }

    public Integer getxIndex() {
        return X_INDEX;
    }

    public void setxIndex(Integer xIndex) {
        this.X_INDEX = xIndex;
    }

    public Integer getyIndex() {
        return Y_INDEX;
    }

    public void setyIndex(Integer yIndex) {
        this.Y_INDEX = yIndex;
    }

    public String getxSql() {
        return X_SQL;
    }

    public void setxSql(String xSql) {
        this.X_SQL = xSql;
    }

    public String getySql() {
        return Y_SQL;
    }

    public void setySql(String ySql) {
        this.Y_SQL = ySql;
    }

    public String getSql() {
        return SQL;
    }

    public void setSql(String sql) {
        this.SQL = sql;
    }

    public String getxName() {
        return X_NAME;
    }

    public void setxName(String xName) {
        this.X_NAME = xName;
    }

    public String getyName() {
        return Y_NAME;
    }

    public void setyName(String yName) {
        this.Y_NAME = yName;
    }

    public Long getUserCount() {
        return USER_COUNT;
    }

    public void setUserCount(Long userCount) {
        this.USER_COUNT = userCount;
    }
}
