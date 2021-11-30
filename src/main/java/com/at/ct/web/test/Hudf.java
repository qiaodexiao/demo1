package com.at.ct.web.test;

import java.io.PrintStream;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.json.JSONObject;

public class Hudf
        extends UDF
{
    public String evaluate(String variable_json, String variable_collect, String model_content)
    {
        JSONObject json = new JSONObject(variable_json);
        String[] vc = variable_collect.split(",");
        for (String str : vc) {
            if (str.equals("OTHERS"))
            {
                StringBuilder sb = new StringBuilder();
                String value = json.getString("OTHERS");
                if (!value.contains("月固定费"))
                {
                    String[] splits = value.split(":|;", 2);
                    System.out.println(splits.length);
                    System.out.println(value);
                    sb.append(splits[0])
                            .append(":")
                            .append("ww")
                            .append(splits[1])
                            .append("ww");
                }
                else
                {
                    String[] splits = value.split(":|;", 3);
                    sb.append(splits[0])
                            .append(":")
                            .append("ww")
                            .append(splits[1])
                            .append(";")
                            .append("ww")
                            .append(splits[2])
                            .append("ww");
                }
                model_content = model_content.replace("%OTHERS%", sb.toString());
            }
            else
            {
                String strr = "%" + str + "%";
                model_content = model_content.replace(strr, json.getString(str));
            }
        }
        return model_content;
    }
}