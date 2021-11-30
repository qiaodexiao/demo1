package com.at.ct.web.test;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class DengSengLin1 {
    public static void main(String[] args) {

        FileReader reader = null;
        BufferedReader bufferedReader = null;
        FileWriter fw =null;
        BufferedWriter bw =null;
        try {
            reader = new FileReader("D:\\\\zhuomian\\工作\\20210823\\邓森林\\新建文件夹\\tf_planning_cust_group_attrlist_rel.txt");
            bufferedReader = new BufferedReader(reader);



            String line = null;
            fw = new FileWriter("D:\\\\zhuomian\\工作\\20210823\\邓森林\\新建文件夹\\1.txt");
            bw = new BufferedWriter(fw);
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] s1 = line.split("\\|");
                String group_id=s1[0];
                String json_id=s1[1];
                JSONObject json = new JSONObject(json_id);
                String s = json.toString();
                boolean tagList = s.contains("tagList");
                if(tagList){
                    JSONArray tagList1 = json.getJSONArray("tagList");
                    //System.out.println(tagList1);
                    for (int i = 0; i < tagList1.length(); i++) {
                        JSONObject jsonObject = tagList1.getJSONObject(i);
                        JSONArray attrList = jsonObject.getJSONArray("attrList");
                        for (int i1 = 0; i1 < attrList.length(); i1++) {
                            JSONObject attrList1 = attrList.getJSONObject(i1);
                            String attrCode = attrList1.getString("attrCode");
                            String attrName = attrList1.getString("attrName");
                            String attrType = attrList1.getString("attrType");
                          String result=group_id+"|"+attrCode+"|"+attrName+"|"+attrType;
                          System.out.println(result);
                            bw.write(result+"\n");

                           // System.out.println(group_id+"|"+attrCode+"|"+attrName+"|"+attrType);

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
                        String result=group_id+"|"+attrCode+"|"+attrName+"|"+attrType;
                        System.out.println(result);
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



