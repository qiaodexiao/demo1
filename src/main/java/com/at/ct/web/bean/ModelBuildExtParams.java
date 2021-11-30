package com.at.ct.web.bean;

/**
 * @author zhaoxuan
 * @date 2019/5/25 14:23
 */
public class ModelBuildExtParams {

    /**
     * 创建类型->0标签提取;1文件上传;2后台表;
     */
    private Integer createType;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 后台表方式,关联字段名
     */
    private String associatedField;

    /**
     * 后台表,账期
     */
    private String modelAcctDate;

    /**
     * 后台表,数据表用户空间
     */
    private String dataUser;

    /**
     * 标签提取的查询条件
     */
    private String sqlStatement;

    /**
     * 关联类型->0设备号;1客户编号;
     */
    private Integer associatedType;

    private String monthId;

    private String dayId;

    private String mapSql;

    public ModelBuildExtParams() {
    }

    public String getMapSql() {
        return mapSql;
    }

    public void setMapSql(String mapSql) {
        this.mapSql = mapSql;
    }

    public Integer getCreateType() {
        return createType;
    }

    public void setCreateType(Integer createType) {
        this.createType = createType;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getAssociatedField() {
        return associatedField;
    }

    public void setAssociatedField(String associatedField) {
        this.associatedField = associatedField;
    }

    public String getModelAcctDate() {
        return modelAcctDate;
    }

    public void setModelAcctDate(String modelAcctDate) {
        this.modelAcctDate = modelAcctDate;
    }

    public String getDataUser() {
        return dataUser;
    }

    public void setDataUser(String dataUser) {
        this.dataUser = dataUser;
    }

    public String getSqlStatement() {
        return sqlStatement;
    }

    public void setSqlStatement(String sqlStatement) {
        this.sqlStatement = sqlStatement;
    }

    public Integer getAssociatedType() {
        return associatedType;
    }

    public void setAssociatedType(Integer associatedType) {
        this.associatedType = associatedType;
    }

    public String getMonthId() {
        return monthId;
    }

    public void setMonthId(String monthId) {
        this.monthId = monthId;
    }

    public String getDayId() {
        return dayId;
    }

    public void setDayId(String dayId) {
        this.dayId = dayId;
    }
}
