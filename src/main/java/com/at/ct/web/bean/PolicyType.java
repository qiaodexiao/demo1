package com.at.ct.web.bean;

public class PolicyType {

    /**
     * 政策分类ID
     */
    private String POLICY_TYPE_ID;
    /**
     * 政策分类名称
     */
    private String POLICY_TYPE_NAME;
    /**
     * 父政策分类ID
     */
    private String PARENT_POLICY_TYPE_ID;

    public String getPOLICY_TYPE_ID() {
        return POLICY_TYPE_ID;
    }

    public void setPOLICY_TYPE_ID(String POLICY_TYPE_ID) {
        this.POLICY_TYPE_ID = POLICY_TYPE_ID;
    }

    public String getPOLICY_TYPE_NAME() {
        return POLICY_TYPE_NAME;
    }

    public void setPOLICY_TYPE_NAME(String POLICY_TYPE_NAME) {
        this.POLICY_TYPE_NAME = POLICY_TYPE_NAME;
    }

    public String getPARENT_POLICY_TYPE_ID() {
        return PARENT_POLICY_TYPE_ID;
    }

    public void setPARENT_POLICY_TYPE_ID(String PARENT_POLICY_TYPE_ID) {
        this.PARENT_POLICY_TYPE_ID = PARENT_POLICY_TYPE_ID;
    }
}
