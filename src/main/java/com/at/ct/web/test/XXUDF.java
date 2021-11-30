package com.at.ct.web.test;

import org.json.JSONArray;
import org.json.JSONObject;

public class XXUDF {


    public static void main(String[] args) {
        String   variable_json ="{\"tagList\":[{\"attrList\":[{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20090005\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20090006\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20090007\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20090049\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20090050\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20902522\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20902533\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20902537\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20999697\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20999699\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20999700\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20874125\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20880731\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20997830\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20997832\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20997836\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20997840\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"20997857\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"21309165\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"21309175\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"21309179\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"21309180\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60003\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp编码\",\"attrType\":\"day\",\"attrValue\":\"21322588\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1}],\"groupCondition\":\"AND\"},{\"attrList\":[{\"attrAccount\":\"20201124\",\"attrCode\":\"A20012\",\"attrIsFile\":\"2\",\"attrName\":\"品牌\",\"attrType\":\"day\",\"attrValue\":\"A01\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1}],\"groupCondition\":\"AND\"},{\"attrList\":[{\"attrAccount\":\"20201124\",\"attrCode\":\"A20079\",\"attrIsFile\":\"2\",\"attrName\":\"移网产品\",\"attrType\":\"day\",\"attrValue\":\"M11\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1},{\"attrAccount\":\"20201124\",\"attrCode\":\"A20079\",\"attrIsFile\":\"2\",\"attrName\":\"移网产品\",\"attrType\":\"day\",\"attrValue\":\"M10\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":1}],\"groupCondition\":\"AND\"},{\"attrList\":[{\"attrAccount\":\"20201124\",\"attrCode\":\"AB60004\",\"attrIsFile\":\"2\",\"attrName\":\"资费与sp订购结束时间\",\"attrType\":\"day\",\"attrValue\":\"20201101\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":3}],\"groupCondition\":\"AND\"}]}";

        String  variable_json1="{\"attrList\":[{\"attrCode\":\"A40125\",\"attrName\":\"证件类别\",\"attrType\":\"month\",\"attrValue\":\"5\",\"attrValueType\":\"string\",\"condition\":\"or\",\"relation\":1}]}";
        String variable_json2="{\"tagList\":[{\"attrList\":[{\"attrAccount\":\"20200413\",\"attrCode\":\"A10001\",\"attrIsFile\":\"2\",\"attrName\":\"积分余额\",\"attrType\":\"day\",\"attrUnit\":\"U11444\",\"attrValue\":\"0\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":3},{\"attrAccount\":\"20200413\",\"attrCode\":\"A40018\",\"attrIsFile\":\"1\",\"attrName\":\"用户号码\",\"attrOssInfo\":\"A40018$1586875699952$test22.txt\",\"attrType\":\"day\",\"attrValue\":\"A40018$1586875699952$test22.txt\",\"attrValueType\":\"string\",\"condition\":\"OR\",\"relation\":7}],\"groupCondition\":\"AND\"}]}\n";
        JSONObject json = new JSONObject(variable_json2);
        System.out.println(json);
        String s = json.toString();
        boolean tagList = s.contains("tagList");
        if(tagList){
            JSONArray tagList1 = json.getJSONArray("tagList");
            System.out.println(tagList1);
            for (int i = 0; i < tagList1.length(); i++) {
                JSONObject jsonObject = tagList1.getJSONObject(i);
                JSONArray attrList = jsonObject.getJSONArray("attrList");
                for (int i1 = 0; i1 < attrList.length(); i1++) {
                    JSONObject attrList1 = attrList.getJSONObject(i1);

                    String attrCode = attrList1.getString("attrCode");
                    String attrName = attrList1.getString("attrName");
                    String attrType = attrList1.getString("attrType");
                    System.out.println(attrCode+"|"+attrName+"|"+attrType);
                }
            }
        }
        else{
            JSONArray attrList = json.getJSONArray("attrList");
            for (int i = 0; i < attrList.length(); i++) {
                JSONObject jsonObject = attrList.getJSONObject(i);
                    String attrCode = jsonObject.getString("attrCode");
                    String attrName = jsonObject.getString("attrName");
                    String attrType = jsonObject.getString("attrType");
                    System.out.println(attrCode+"|"+attrName+"|"+attrType);
                }
        }





    }


}
