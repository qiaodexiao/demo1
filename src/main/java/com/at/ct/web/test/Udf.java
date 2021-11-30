package com.at.ct.web.test;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.json.JSONObject;

public class Udf extends UDF {

    public  String evaluate(String variable_json, String variable_collect, String model_content) {

        JSONObject json = new JSONObject(variable_json);
        String[] vc = variable_collect.split(",");
        for (String str : vc) {
            if(str.equals("OTHERS")) {//如果key=OTHERS进行换行处理
                //"OTHERS":"其中：月固定费6.01元；其他消费36.99元；"
                StringBuilder sb = new StringBuilder();
                String value = json.getString("OTHERS");
                if("".equals(value) || ":".equals(value) ){

                }else {
                    if (!value.contains("月固定费")) {
                        String[] splits = value.split("：|；|，", 2);
                        System.out.println(splits.length);
                        System.out.println(value);
                        sb.append(splits[0])//其中
                                .append("：")

                                .append("■■")
                                .append("1.")
                                .append(splits[1])

                                .append("■■");


                    } else {

                        String[] splits = value.split("：|；|，", 3);
                        if ("".equals(splits[2])) {
                            sb.append(splits[0])
                                    .append("：")
                                    .append("■■")
                                    .append("1.")
                                    .append(splits[1])
                                    .append("；")
                                    .append("■■");
                        } else {
                            sb.append(splits[0])//其中
                                    .append("：")
                                    .append("■■")
                                    .append("1.")
                                    .append(splits[1])
                                    .append("；")
                                    .append("■■")
                                    .append("2.")
                                    .append(splits[2])
                                    .append("■■");
                        }
                    }
                }
                model_content = model_content.replace("%OTHERS%", sb.toString());



            }else{
                String strr = "%" + str + "%";
                model_content = model_content.replace(strr, json.getString(str));
            }




        }



        return model_content;
    }
}
