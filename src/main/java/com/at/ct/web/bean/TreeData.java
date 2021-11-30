package com.at.ct.web.bean;

/**
 * @author zhaoxuan
 * @date 2019/6/3 16:49
 */
public class TreeData {

    private String nodeCode;

    private String nodeName;

    private String parentNodeCode;

    private String sqlConditions;

    private String resume;

    private String conditions;

    public TreeData() {
    }

    public TreeData(String nodeCode, String nodeName, String parentNodeCode, String sqlConditions, String resume, String conditions) {
        this.nodeCode = nodeCode;
        this.nodeName = nodeName;
        this.parentNodeCode = parentNodeCode;
        this.sqlConditions = sqlConditions;
        this.resume = resume;
        this.conditions = conditions;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getParentNodeCode() {
        return parentNodeCode;
    }

    public void setParentNodeCode(String parentNodeCode) {
        this.parentNodeCode = parentNodeCode;
    }

    public String getSqlConditions() {
        return sqlConditions;
    }

    public void setSqlConditions(String sqlConditions) {
        this.sqlConditions = sqlConditions;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
}
