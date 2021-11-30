package com.at.ct.web.bean;

/**
 * @author zhaoxuan
 * @descriptioon 模型构建参数
 * @date 2019/5/25 10:09
 */
public class ModelBuildBaseParams {

    /**
     * 网别->0本网;1异网
     */
    private Integer netType;

    /**
     * 业务类型->0移网;1固网;
     */
    private Integer mobileBroadband;

    /**
     * 组织机构路径
     */
    private String orgPath;

    /**
     * 最新账期
     */
    private String acctDate;

    /**
     * 创建类型
     */
    private Integer createType;

    /**
     * 管理字段->0电话号码;1用户编码;2非本网在网用户
     */
    private Integer associatedType;

    public String getBelongedModelCode() {
        return belongedModelCode;
    }

    public void setBelongedModelCode(String belongedModelCode) {
        this.belongedModelCode = belongedModelCode;
    }

    /**
     * 所属后台表编码
     */
    private String belongedModelCode;

    /**
     * 行云表名
     */
    private String tableName;


    public ModelBuildBaseParams() {
    }

    public Integer getCreateType() {
        return createType;
    }

    public void setCreateType(Integer createType) {
        this.createType = createType;
    }

    public Integer getNetType() {
        return netType;
    }

    public void setNetType(Integer netType) {
        this.netType = netType;
    }

    public Integer getMobileBroadband() {
        return mobileBroadband;
    }

    public void setMobileBroadband(Integer mobileBroadband) {
        this.mobileBroadband = mobileBroadband;
    }

    public String getOrgPath() {
        return orgPath;
    }

    public void setOrgPath(String orgPath) {
        this.orgPath = orgPath;
    }

    public String getAcctDate() {
        return acctDate;
    }

    public void setAcctDate(String acctDate) {
        this.acctDate = acctDate;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getAssociatedType() {
        return associatedType;
    }

    public void setAssociatedType(Integer associatedType) {
        this.associatedType = associatedType;
    }
}
