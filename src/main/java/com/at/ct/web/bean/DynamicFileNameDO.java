package com.at.ct.web.bean;

public class DynamicFileNameDO {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 客户群编码
     */
    private String userGroupId;

    /**
     * sftp文件名
     */
    private String sftpFileName;

    /**
     * 同步时间
     */
    private String syncTime;

    /**
     * 省份编码
     */
    private String provinceCode;

    public DynamicFileNameDO(String userGroupId, String sftpFileName, String provinceCode) {
        this.userGroupId = userGroupId;
        this.sftpFileName = sftpFileName;
        this.provinceCode = provinceCode;
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

    public String getSftpFileName() {
        return sftpFileName;
    }

    public void setSftpFileName(String sftpFileName) {
        this.sftpFileName = sftpFileName;
    }

    public String getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(String syncTime) {
        this.syncTime = syncTime;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}
