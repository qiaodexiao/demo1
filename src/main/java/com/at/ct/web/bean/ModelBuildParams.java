package com.at.ct.web.bean;

import java.util.List;

/**
 * @author zhaoxuan
 * @date 2019/5/25 14:24
 */
public class ModelBuildParams {

    private ModelBuildBaseParams baseParams;

    private List<ModelBuildExtParams> extParamsList;

    public ModelBuildParams() {
    }

    public ModelBuildBaseParams getBaseParams() {
        return baseParams;
    }

    public void setBaseParams(ModelBuildBaseParams baseParams) {
        this.baseParams = baseParams;
    }

    public List<ModelBuildExtParams> getExtParamsList() {
        return extParamsList;
    }

    public void setExtParamsList(List<ModelBuildExtParams> extParamsList) {
        this.extParamsList = extParamsList;
    }
}
