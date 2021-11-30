package com.at.ct.web.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExportUserGroupDTO {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 客户群id
     */
    private String userGroupId;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 开始导出时间
     */
    private Date startTime;
    /**
     * 完成导出时间
     */
    private Date endTime;
    /**
     * 状态码（等待/执行中（根据redis锁）：1,成功：2,异常：3）
     */
    private Integer status;
    /**
     * 省份编码
     */
    private String provinceCode;
    /**
     * 标签信息
     */
    private String labels;
    /**
     * 标签信息list形式
     */
    private List<Map<String,String>> labelList;
    /**
     * 组织机构路径(获取sql用)
     */
    private String orgPath;
    /**
     * oss存放路径
     */
    private String ossPath;
    /**
     * 异常信息
     */
    private String exceptionMsg;

    /**
     * redis锁value值
     */
    private String lockVal;

    /**
     * 标签类型
     * 0：完整标签
     * 1：只有号码、地市、省份
     */
    private Integer labelType;

    public ExportUserGroupDTO(){

    }

    /**
     * 更新库时用
     * @param userGroupId
     * @param creator
     * @param status
     * @param provinceCode
     * @param labels
     */
    public ExportUserGroupDTO(String userGroupId, String creator, Integer status, String provinceCode, String labels, String orgPath) {
        this.userGroupId = userGroupId;
        this.creator = creator;
        this.status = status;
        this.provinceCode = provinceCode;
        this.labels = labels;
        this.orgPath = orgPath;
    }

    /**
     * 执行任务时用
     * @param userGroupId
     * @param creator
     * @param provinceCode
     * @param labelList
     * @param orgPath
     */
    public ExportUserGroupDTO(String userGroupId, String creator, String provinceCode, List<Map<String,String>> labelList, String orgPath, Integer labelType) {
        this.userGroupId = userGroupId;
        this.creator = creator;
        this.provinceCode = provinceCode;
        this.labelList = labelList;
        this.orgPath = orgPath;
        this.labelType = labelType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(String userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public List<Map<String, String>> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<Map<String, String>> labelList) {
        this.labelList = labelList;
    }

    public String getOrgPath() {
        return orgPath;
    }

    public void setOrgPath(String orgPath) {
        this.orgPath = orgPath;
    }

    public String getOssPath() {
        return ossPath;
    }

    public void setOssPath(String ossPath) {
        this.ossPath = ossPath;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public String getLockVal() {
        return lockVal;
    }

    public void setLockVal(String lockVal) {
        this.lockVal = lockVal;
    }

    public Integer getLabelType() {
        return labelType;
    }

    public void setLabelType(Integer labelType) {
        this.labelType = labelType;
    }
}
