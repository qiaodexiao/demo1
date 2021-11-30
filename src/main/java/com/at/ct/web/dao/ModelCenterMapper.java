package com.at.ct.web.dao;

import com.at.ct.web.bean.*;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ModelCenterMapper {
    /**
     * 根据当前账期获取数据库连接
     *
     * @param provinceCode
     * @return
     */
    ClyxMppResourceDO queryDBConnParams(@Param("provinceCode") String provinceCode);

    List<ClyxMppResourceDO> queryAllDBConnParams();

    List<Map<String, Object>> getSystemParams(Map<String, Object> map);

    List<Map<String, Object>> getSystemCode(Map<String, Object> map);

    List<PolicyType> getPolicyList(Map<String, Object> map);

    Integer queryModelCount(Map<String, Object> map);

    Integer queryModelCount2(Map<String, Object> map);

    List<Map<String, Object>> queryModelList(Map<String, Object> map);

    Map<String,Object> queryModelStatisticData(@Param("modelCode") String modelCode);

    Integer checkModelName(Map<String, Object> map);

    String queryBussinessType(@Param("belong_model_code") String belong_model_code, @Param("province_code") String province_code);

    void insertModel(Map<String, Object> map);

    Integer queryThirdModelCount(Map<String, Object> map);

    List<Map<String, Object>> queryThirdModelList(Map<String, Object> map);

    List<Map<String, Object>> getSubdivisionParams(Map<String, Object> map);

    List<Map<String, Object>> delSubdivisionParams(Map<String, Object> map);

    int getSubSum(Map<String, Object> map);

    void deleteModel(@Param("modelCode") String modelCode);

    void shareModel(@Param("modelCode") String modelCode);

    void shareOtherModel(@Param("modelCode") String modelCode);

    List<String> queryShareOtherModelProvinceCode(@Param("modelCode") String modelCode);

    void copyModel(Map<String, Object> map);

    void copyDynamicInfo(Map<String, Object> map);

    /**
     * 查询基础参数
     *
     * @param modelCode
     * @param orgPath
     * @param provinceCode
     * @param homeTable
     * @param diffTable
     * @return
     */
    ModelBuildBaseParams queryBaseParams(@Param("modelCode") String modelCode, @Param("orgPath") String orgPath, @Param("provinceCode") String provinceCode, @Param("homeTable") String homeTable, @Param("diffTable") String diffTable);

    String selectMaxDate(@Param("provinceCode") String provinceCode);

    /**
     * 查询创建类型
     *
     * @param modelCode
     * @param provinceCode
     * @return
     */
    Integer queryCreateType(@Param("modelCode") String modelCode, @Param("provinceCode") String provinceCode);

    /**
     * 查询"文件上传"类型扩展参数
     *
     * @param modelCode
     * @param provinceCode
     * @return
     */
    List<ModelBuildExtParams> queryExtParamsForTyep1(@Param("modelCode") String modelCode, @Param("provinceCode") String provinceCode);

    /**
     * 查询"后台表导入"类型扩展参数
     *
     * @param modelCode
     * @param provinceCode
     * @return
     */
    List<ModelBuildExtParams> queryExtParamsForTyep2(@Param("modelCode") String modelCode, @Param("provinceCode") String provinceCode);

    List<ModelBuildExtParams> queryExtParamsForTyep2B(@Param("modelCode") String modelCode, @Param("provinceCode") String provinceCode);

    Integer getThirdModelNetType(@Param("modelCode") String modelCode);

    /**
     * 查询"标签提取类"类型扩展参数
     *
     * @param modelCode
     * @param provinceCode
     * @return
     */
    List<ModelBuildExtParams> queryExtParamsForTyep0(@Param("modelCode") String modelCode, @Param("provinceCode") String provinceCode);



    void updateModelState(Map<String, Object> map);

    void updateModelStateActive(Map<String, Object> map);

    List<Map<String, Object>> getMergeModelList(Map<String, Object> map);
    int getMergeModelListCount(Map<String, Object> map);
    void acquireModel(Map<String, Object> map);
    void editModel(Map<String, Object> map);
    String getPolicyType(@Param("modelCode") String modelCode);

    List<Map> queryActivityInfo(Map param);

    Map getStrategyInfo(String strategyId);

    Integer queryModelExamineCount(Map<String, Object> map);

    List<Map<String, Object>> queryModelExamineList(Map<String, Object> map);

    void changeExamineStatus(@Param("status") String status, @Param("modelCode") String modelCode);

    Map getModelInfoForExamine(@Param("MODEL_CODE") String MODEL_CODE);

    List<Map<String, Object>> queryModelList1(Map<String, Object> map);

    Map<String, String> queryDateForThirdModelTable(@Param("modelCode") String modelCode, @Param("provinceCode") String provinceCode);

    void modelComplement(Map<String, Object> map);

    void saveLog(Map<String, Object> map);

    void validCheck();

    void setExamineProcessId(@Param("modelCode") String modelCode, @Param("examineProcessId") String examineProcessId);

    String getExamineProcessId(@Param("modelCode") String modelCode);

    Map<String,Object> getThirdModelInfo(@Param("modelCode") String modelCode);

    void saveTapModel(Map<String, Object> map);

    String getSuccessFilePath(@Param("modelCode") String modelCode);

    void userGroupToModel(Map<String, Object> map);

    List<Map<String, Object>> queryModelDetail(@Param("sql") String sql);

    List<Map<String, Object>> syncMppInfo(@Param("lastHourTime") String lastHourTime);

    List<Map<String, Object>> syncMppInfo2(@Param("start") String start, @Param("end") String end);

    List<Map<String, Object>> syncRedisInfo(@Param("lastHourTime") String lastHourTime, @Param("flag") String flag);

    List<Map<String, Object>> syncRedisInfo2(@Param("start") String start, @Param("end") String end, @Param("flag") String flag);

    List<Map<String, Object>> syncRedisInfo1(@Param("lastHourTime") String lastHourTime);

    List<Map<String, Object>> syncMppInfoInit();

    List<Map<String, Object>> syncRedisInfoInit();

    Map<String,Object> getSFTPInfo(@Param("PROVINCE_CODE") String PROVINCE_CODE);

    String getSFTPPath(@Param("MODEL_CODE") String MODEL_CODE);

    void saveSFTPPath(@Param("MODEL_CODE") String MODEL_CODE, @Param("SFTP_PATH") String SFTP_PATH);

    List<Map<String, Object>> getUserGroupSource(String provinceCode);

    void saveDynamicInfo(Map<String, Object> map);

    void deleteDynamicInfo(@Param("MODEL_CODE") String MODEL_CODE);


    List<DynamicUserGroupDTO> findDynamicUserGroupTask(@Param("status") int status);

    void updateDynamicUserGroupTask(DynamicUserGroupDTO dto);

    List<DynamicUserGroupDTO> findDynamicUserGroupTaskBySync();

    void addDynamicUserGroupTask(@Param("dtos") List<DynamicUserGroupDTO> dtos);

    void addDynamicUserGroupTask1(@Param("USERGROUP_ID") String USERGROUP_ID, @Param("PROVINCE_CODE") String PROVINCE_CODE);

    DynamicUserGroupDO findDynamicUserGroupInfo(@Param("userGroupId") String userGroupId);

    List<DynamicFileNameDO> findDynamicFileName(@Param("userGroupId") String userGroupId);

    void addDynamicFileName(DynamicFileNameDO dynamicFileNameDO);

    void updateDynamicUserGroupTaskTime(@Param("userGroupIds") List<String> userGroupIds);

    void updateDynamicUserGroupTaskTimeOne(@Param("modelCode") String modelCode);

    List<DynamicUserGroupDO> findValidDynamicUserGroup();

    List<Map<String, Object>> getFieldConfigParam(@Param("provinceCode") String provinceCode);

    void editField(Map<String, Object> map);

    List<Map<String, Object>> getOptionalFieldList(Map<String, Object> map);

    Integer getOptionalFieldListCount(Map<String, Object> map);

    List<Map<String, Object>> getChosenFieldList(Map<String, Object> map);

    Integer getChosenFieldListCount(Map<String, Object> map);

    void saveFieldChosen(@Param("FIELD_ID") int FIELD_ID, @Param("provinceCode") String provinceCode);

    void saveFieldCancel(@Param("FIELD_ID") int FIELD_ID, @Param("provinceCode") String provinceCode);

    void updateSelectBy(@Param("FIELD_ID") int FIELD_ID, @Param("SELECT_BY") String SELECT_BY, @Param("provinceCode") String provinceCode);

    String getBpmFlowCode(@Param("provinceCode") String provinceCode, @Param("serviceType") String serviceType);

    void saveLabelLog(@Param("labels") List<LabelLogDTO> labels);

    Integer checkFieldName(Map<String, Object> map);

    List<Map<String, Object>> getTemplateParam(Map<String, Object> map);

    void saveTemplate(Map<String, Object> map);

    void saveTemplateField(Map<String, Object> map);

    Integer getFieldId();

    void updateFieldId(@Param("FIELD_ID") int FIELD_ID);

    String getCustomFieldFromTemplate(@Param("TEMPLATE_ID") String TEMPLATE_ID);

    String getCustomFieldFromModel(@Param("MODEL_CODE") String MODEL_CODE);

    String getCustomFieldDescFromModel(@Param("MODEL_CODE") String MODEL_CODE);

    List<Map<String, Object>> getFieldByTemplate(@Param("customField") String customField);

    Integer checkTemplateName(Map<String, Object> map);

    void clearDynamicTask();

    Integer getExamineProcessStatus(@Param("PROVINCE_CODE") String PROVINCE_CODE);

    Integer getThirdModelOrigin(@Param("MODEL_CODE") String MODEL_CODE);

    Integer getMetadataClassId(@Param("CLASS_ID") String metadataClassId);

    void insertMetadataClass(Map<String, Object> map);

    void insertMcMeasure(Map<String, Object> map);

    void insertMcDime(Map<String, Object> map);

    void insertMeasureMetadata(Map<String, Object> map);

    void insertDimeMetadata(Map<String, Object> map);

    void insertCubeMeasure(Map<String, Object> map);

    void insertCubeDime(Map<String, Object> map);

    String getMeasureClassId(@Param("PROVINCE_CODE") String PROVINCE_CODE);

    void insertMeasureClassId(Map<String, Object> map);

    String getDimeClassId(@Param("PROVINCE_CODE") String PROVINCE_CODE);

    void insertDimeClassId(Map<String, Object> map);

    List<Map> getClassInfo();

    Map getUserGroupInfo(String userGroupId);

    List<Map> getLabelUseLogById(String userGroupId);

    List<String> getCategory(@Param("loginId") String loginId, @Param("provinceCode") String provinceCode);

    String getTemplateLoginId(@Param("provinceCode") String provinceCode);

    List<Map<String,Object>> getLabelList(@Param("categoryIds") List<String> categoryIds, @Param("provinceCode") String provinceCode, @Param("fuzzyParameter") String fuzzyParameter);

    String existsExportTask(@Param("userGroupId") String userGroupId, @Param("creator") String creator, @Param("provinceCode") String provinceCode, @Param("status") Integer status);

    void saveExportTask(ExportUserGroupDTO exportUserGroupDTO);

    void resetExportTask(ExportUserGroupDTO exportUserGroupDTO);

    void updateExportTask(ExportUserGroupDTO exportUserGroupDTO);

    List<ExportUserGroupDTO> getExportTask(@Param("status") Integer status);

    String getOssUrl(@Param("userGroupId") String userGroupId, @Param("loginId") String loginId, @Param("provinceCode") String provinceCode, @Param("status") Integer status);

    String getPolicyName(@Param("provinceCode") String provinceCode);

    void zbExamineProvince();

    List<Map<String,Object>> getRulesPolicyChildren(@Param("provinceCode") String provinceCode, @Param("typeCode") String typeCode);

    List<Map<String,Object>> getRulesInfo(@Param("provinceCode") String provinceCode, @Param("typeCode") String typeCode);

    Map<String,Object> getRulesType(@Param("POLICY_CODE") String POLICY_CODE);

    String getTypeName(@Param("TYPE_CODE") String TYPE_CODE, @Param("PROVINCE_CODE") String PROVINCE_CODE);

    String getParentType(@Param("TYPE_CODE") String TYPE_CODE, @Param("PROVINCE_CODE") String PROVINCE_CODE);

    List<Map<String,Object>> getRulesProductInfo(@Param("provinceCode") String provinceCode, @Param("policyCode") String policyCode);

    List<Map<String,Object>> getRulesTemplateInfo(@Param("provinceCode") String provinceCode, @Param("commId") String commId);

    List<Map<String,Object>> getSmsPort(@Param("provinceCode") String provinceCode);

    List<Map<String,Object>> getSmsInfo(@Param("provinceCode") String provinceCode, @Param("smsPort") String smsPort);

    void saveRulesConfigTemplate(Map<String, Object> map);

    void saveRules(Map<String, Object> map);

    void updateRulesNum(@Param("TEMPLATE_ID") String TEMPLATE_ID);

    int checkRulesConfigTemplateName(@Param("TEMPLATE_NAME") String TEMPLATE_NAME);

    int checkRulesName(@Param("RULES_NAME") String RULES_NAME);

    int checkRulesConfigTemplateNameEdit(Map<String, Object> map);

    int checkRulesNameEdit(Map<String, Object> map);

    void updateRulesConfigTemplate(Map<String, Object> map);

    void deleteRulesConfigTemplate(@Param("TEMPLATE_ID") String TEMPLATE_ID);

    void deleteRules(@Param("TEMPLATE_ID") String TEMPLATE_ID);

    List<Map<String,Object>> getRulesConfigTemplateList(Map<String, Object> map);

    Integer getRulesConfigTemplateListCount(Map<String, Object> map);

    List<Map<String,Object>> getRulesList(Map<String, Object> map);

    Integer getRulesListCount(Map<String, Object> map);

    Map<String,Object> getTemplateInfo(@Param("TEMPLATE_ID") String TEMPLATE_ID);

    void saveDynamicImport(@Param("fileId") String fileId, @Param("creator") String creator, @Param("ossUrl") String ossUrl, @Param("provinceCode") String provinceCode);

    Map<String,Object> getModelBackInfo(@Param("MODEL_CODE") String MODEL_CODE);

    Map<String,Object> getCustomFieldDesc(@Param("MODEL_CODE") String MODEL_CODE);

    Map<String,Object> getDownloadControlStatus(@Param("PROVINCE_CODE") String PROVINCE_CODE);

    void saveLabelAsyncLog(Map<String, Object> mp);

    Map<String,Object> selectThirdModel(@Param("MODEL_CODE") String MODEL_CODE);

    void addThirdModel(Map<String, Object> map);

    List<String> getProvinceCode();

    void updateThirdShare(@Param("MODEL_CODE") String MODEL_CODE);

    Map<String, Object> getModelInfoByCode(@Param("modelCode") String modelCode);

    List<Map> getLabelSynchProvince();

    void addLabelDataHisory(Map addLabelMap);

    List<Map> getLabelTreeByProvince(@Param("provinceCode") String provinceCode, @Param("modelLoginName") String modelLoginName);

    Map getLabelModelInfo(String provinceCode);

    void addLabelCategory(Map firstLabelTree);

    List<Map<String,Object>> getLableNameByModel(@Param("MODEL_CODE") String MODEL_CODE);

    Map<String, Object> getDimeNameById(@Param("DIME_ID") String DIME_ID);

    List<Map> getLabelSynchType();

    void addDispatchInfo(Map<String, Object> map);

    void addDispatch(Map<String, Object> map);

    List<String> getModelCodeByOutterId(@Param("OUTTER_USERGROUP_ID") String OUTTER_USERGROUP_ID);

    List<String> isDispatchInfoExist(Map<String, Object> map);

    void updateDispatchInfo(Map<String, Object> map);

    Map<String, Object> getDispatchInfo(@Param("FILE_NAME") String FILE_NAME);

    void updateSignId(@Param("SIGN_ID") String SIGN_ID, @Param("MODEL_CODE") String MODEL_CODE);

    String getSignId(@Param("MODEL_CODE") String MODEL_CODE);

    String getUsergroupByStrategy(@Param("STRATEGY_ID") String STRATEGY_ID);

    List<String> getAllFileName(@Param("MODEL_CODE") String userGroupId);






//  labelDime getCompoundDime(String fubiaoqian);
//
//
//    labelMeasure getCompoundMeasure(String fuheBiaoqian);

    List<Map> getDrdsLabelIds(String offLineLabelCode);

    void offLineDrdsDimeLabels(String drdsLabelId);

    void offLineDrdsMeasureLabels(String drdsLabelId);

    void addSynchLabelLog(Map synchLabelLogMap);

    List<Map> getCaliberLabelId(String attrCode);

    void updateMeasureBussinessCaliber(@Param("labelIds") String labelIds, @Param("businessCaliber") String businessCaliber, @Param("labelName") String labelName);

    void updateDimeBussinessCaliber(@Param("labelIds") String labelIds, @Param("businessCaliber") String businessCaliber, @Param("labelName") String labelName);

    String getPartitionParam(@Param("provinceCode") String provinceCode);

    List<Map<String, Object>> getLabelListByNetType(@Param("categoryIds") List<String> categoryIds,
                                                    @Param("provinceCode") String provinceCode, @Param("netType") String netType,
                                                    @Param("dateType") String dateType, @Param("labelName") String labelName,
                                                    @Param("labelIds") List<String> labelIds);



    List<Map> getQiTa(String labelId);

    List<Map<String,Object>> getSignIdList(@Param("PROVINCE_CODE") String provinceCode);

    String getApiScreenStatus(@Param("PROVINCE_CODE") String provinceCode);

    /**
     * 通过groupid到更新文件的最新时间和文件名
     * @param userGroupId 用户群id
     * @return
     */
    Map<String,Object> getUpdateTimeAndFileNameWithGroupId(@Param("USERGROUP_ID") String userGroupId);

    /**
     * 往区间类动态客户群关系表存数据
     * @param map
     */
    void insertDynamicSectionRelation(Map<String, Object> map);

    Map<String,Object> getTimeTypeWithGroupId(@Param("MODEL_CODE") String modelCode);

    List<Map> getSubLabelsOfComp(String labelId);

    Map getDimeLabelDetailById(String labelId);

    Map queryMeasureDetail(String labelId);

    Map queryMeasurePath(String labelId);

    Map queryDimeDetail(String labelId);

    Map queryDimePath(String labelId);

    Map queryCompDetail(String labelId);

    Map queryCompPath(String labelId);

    List<Map> queryMainLabelInfo(String labelId);
    /**
     * 上传文件内容检验结果入库
     * @param map
     */
    void insertFileUploadInfo(Map<String, Object> map);

    /**
     * 文件上传结果明细
     * @return
     */
    List<Map<String,Object>> getFileUploadResult(Map<String, Object> map);

    /**
     * 根据model_code 拿到model_name
     * @param modelCode
     * @return
     */
    Map<String,Object> selectUserGroupNameById(@Param("MODEL_CODE") String modelCode);

    /**
     * 删除对应客户群上传的文件信息
     * @param modelName
     */
    void  deleteUploadFileInfoWithModelName(@Param("MODEL_NAME") String modelName);

}
