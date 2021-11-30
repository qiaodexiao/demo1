package com.at.ct.web.bean;


import java.util.Date;

public class DynamicUserGroupDTO {
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
    private String createUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 开始同步时间
     */
    private Date startTime;
    /**
     * 完成同步时间
     */
    private Date endTime;
    /**
     * 状态码（等待：1,成功：2,异常：3）
     */
    private Integer status;
    /**
     * 批次
     */
    private Integer batch;
    /**
     * 省份编码
     */
    private String provinceCode;
    /**
     * 异常信息
     */
    private String exceptionMsg;

    /**
     * redis锁value值
     */
    private String lockVal;

    public DynamicUserGroupDTO() {
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
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
}

