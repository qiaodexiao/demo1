package com.at.ct.web.test;

import org.json.JSONArray;
import org.json.JSONObject;


public class XUDF {
    public static void main(String[] args) {
        // Json数组最外层要加"[]"

       String variable_json ="{\"account\":\"202009\",\"queryModel\":[{\"attrList\":[{\"attrAccount\":\"202009\",\"attrCode\":\"K000046\",\"attrType\":\"202009\",\"attrValue\":\"071\",\"condition\":\"or\",\"relation\":7}],\"groupCondition\":\"and\"},{\"attrList\":[{\"attrAccount\":\"202009\",\"attrCode\":\"H710078\",\"attrType\":\"202009\",\"attrValue\":\"480\",\"condition\":\"and\",\"relation\":2}],\"groupCondition\":\"and\"},{\"attrList\":[{\"attrAccount\":\"202009\",\"attrCode\":\"H710011\",\"attrType\":\"202009\",\"attrValue\":\"1\",\"condition\":\"or\",\"relation\":8},{\"attrAccount\":\"202009\",\"attrCode\":\"H710011\",\"attrType\":\"202009\",\"attrValue\":\"2\",\"condition\":\"or\",\"relation\":8},{\"attrAccount\":\"202009\",\"attrCode\":\"H710011\",\"attrType\":\"202009\",\"attrValue\":\"4\",\"condition\":\"or\",\"relation\":8},{\"attrAccount\":\"202009\",\"attrCode\":\"H710011\",\"attrType\":\"202009\",\"attrValue\":\"5\",\"condition\":\"or\",\"relation\":8}],\"groupCondition\":\"and\"},{\"attrList\":[{\"attrAccount\":\"202009\",\"attrCode\":\"H710125\",\"attrType\":\"202009\",\"attrValue\":\"0027\",\"condition\":\"or\",\"relation\":7}],\"groupCondition\":\"and\"},{\"attrList\":[{\"attrAccount\":\"202009\",\"attrCode\":\"H710126\",\"attrType\":\"202009\",\"attrValue\":\"M\",\"condition\":\"or\",\"relation\":7}],\"groupCondition\":\"and\"},{\"attrList\":[{\"attrAccount\":\"202009\",\"attrCode\":\"H710031\",\"attrType\":\"202009\",\"attrValue\":\"3\",\"condition\":\"and\",\"relation\":2}],\"groupCondition\":\"and\"}]}";
       JSONObject json = new JSONObject(variable_json);
       System.out.println(json);
        JSONArray queryModel = json.getJSONArray("queryModel");
        for (int i = 0; i < queryModel.length(); i++) {
            JSONObject jsonObject = queryModel.getJSONObject(i);
            JSONArray attrList = jsonObject.getJSONArray("attrList");
            for (int i1 = 0; i1 < attrList.length(); i1++) {
                JSONObject jsonObject1 = attrList.getJSONObject(i1);
                String attrCode = jsonObject1.getString("attrCode");
                System.out.println(attrCode);
            }
        }
    }
}
