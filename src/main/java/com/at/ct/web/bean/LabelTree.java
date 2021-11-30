package com.at.ct.web.bean;

/**
 * @author zhaoxuan
 * @date 2019/6/5 14:21
 */
public class LabelTree {

    private String id;

    private String pId;

    private String name;

    private String isLeaf;

    private String type;

    private String iconCls;

    private String state;

    public LabelTree() {
    }

    public LabelTree(String id,String pId,String name,String isLeaf,String type,String iconCls,String state) {
        this.id = id;
        this.pId = pId;
        this.name = name;
        this.isLeaf = isLeaf;
        this.type = type;
        this.iconCls = iconCls;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
