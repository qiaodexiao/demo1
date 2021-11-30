package com.at.ct.web.bean;

import java.util.Date;

public class LabelLogDTO {
    /**
     * 主键
     */
    Integer id;

    /**
     * 标签id
     */
    String labelId;

    /**
     * 登陆id
     */
    String loginId;

    /**
     * 客户群编码
     */
    String modelCode;

    /**
     * 使用时间
     */
    Date useTime;

    /**
     * 省份编码
     */
    String provinceCode;

    public LabelLogDTO(String labelId, String loginId, String modelCode, String provinceCode) {
        this.labelId = labelId;
        this.loginId = loginId;
        this.modelCode = modelCode;
        this.provinceCode = provinceCode;
    }
}
