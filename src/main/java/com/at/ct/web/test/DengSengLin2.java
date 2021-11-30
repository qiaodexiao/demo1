package com.at.ct.web.test;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DengSengLin2 {

    public static void main(String[] args) {

        FileReader reader = null;
        BufferedReader bufferedReader = null;
        FileWriter fw =null;
        BufferedWriter bw =null;
        try {
            reader = new FileReader("D:\\\\zhuomian\\工作\\20210823\\邓森林\\新建文件夹\\tf_planning_cust_group_province_attrlist_rel.txt");
            bufferedReader = new BufferedReader(reader);



            String line = null;
            fw = new FileWriter("D:\\\\zhuomian\\工作\\20210823\\邓森林\\新建文件夹\\2.txt");
            bw = new BufferedWriter(fw);
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] s1 = line.split("\\|");
                String group_id=s1[1];
                String prov_id=s1[0];
                String json_id=s1[2];

                JSONObject json = new JSONObject(json_id);
                String s = json.toString();
                    JSONArray queryModel = json.getJSONArray("queryModel");
                    for (int i = 0; i < queryModel.length(); i++) {
                        JSONObject jsonObject = queryModel.getJSONObject(i);
                        JSONArray attrList = jsonObject.getJSONArray("attrList");
                        for (int i1 = 0; i1 < attrList.length(); i1++) {
                            JSONObject jsonObject1 = attrList.getJSONObject(i1);
                            String attrCode = jsonObject1.getString("attrCode");
                            String result=group_id+"|"+prov_id+"|"+attrCode;
                            System.out.println(group_id+"|"+prov_id+"|"+attrCode);
                            bw.write(result+"\n");
                        }
                    }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bufferedReader.close();
                reader.close();
                bw.close();
                fw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
