package com.at.ct.web.bean;

import java.util.Date;

public class DynamicUserGroupDO {
    /**
     * 客户群编码
     */
    private String userGroupId;

    /**
     * sftp路径
     */
    private String sftpPath;

    /**
     * 客户群来源
     */
    private String userGroupSource;

    /**
     * 更新周期（分钟）
     */
    private String updateCycle;

    /**
     * 数据有效期(天)
     */
    private Integer validTime;

    /**
     * 客户群有效期
     */
    private Date validDate;

    /**
     * 最后一次加入任务时间
     */
    private Date lastTaskTime;

    /**
     * 省份编码
     */
    private String provinceCode;

    /**
     * 行云表名
     */
    private String tableName;

    /**
     * 数据失效时间类型
     * 0: NOW() + VALID_TIME(天)
     * 1: END_TIME
     * 2: START_TIME——END_TIME
     */
    private Integer timeType;

    /**
     * 数据失效日期
     */
    private Date endTime;

    /**
     * 是否资采
     * 0: 否
     * 1: 是
     */
    private Integer isCollect;

    /**
     * 是否自定义字段
     * 0: 否
     * 1: 是
     */
    private String isCustom;

    /**
     * 系统标识
     */
    private String signId;

    /**
     * 自定义字段
     */
    private String customField;

    public String getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getSftpPath() {
        return sftpPath;
    }

    public void setSftpPath(String sftpPath) {
        this.sftpPath = sftpPath;
    }

    public String getUserGroupSource() {
        return userGroupSource;
    }

    public void setUserGroupSource(String userGroupSource) {
        this.userGroupSource = userGroupSource;
    }

    public String getUpdateCycle() {
        return updateCycle;
    }

    public void setUpdateCycle(String updateCycle) {
        this.updateCycle = updateCycle;
    }

    public Integer getValidTime() {
        return validTime;
    }

    public void setValidTime(Integer validTime) {
        this.validTime = validTime;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Date getLastTaskTime() {
        return lastTaskTime;
    }

    public void setLastTaskTime(Date lastTaskTime) {
        this.lastTaskTime = lastTaskTime;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(Integer isCollect) {
        this.isCollect = isCollect;
    }

    public String getIsCustom() {
        return isCustom;
    }

    public void setIsCustom(String isCustom) {
        this.isCustom = isCustom;
    }

    public String getCustomField() {
        return customField;
    }

    public void setCustomField(String customField) {
        this.customField = customField;
    }

    public String getSignId() {
        return signId;
    }

    public void setSignId(String signId) {
        this.signId = signId;
    }
}
