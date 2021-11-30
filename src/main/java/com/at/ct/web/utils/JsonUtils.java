package com.at.ct.web.utils;

import com.at.ct.web.bean.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class JsonUtils {
    public static void main(String[] args) {
   // Json数组最外层要加"[]"
                 String jsonData = "[{'name':'John', 'grade':[{'course':'English','score':100},{'course':'Math','score':78}]},{'name':'Tom', 'grade':[{'course':'English','score':86},{'course':'Math','score':90}]}]";

                 List<Student> students = parseJsonArrayWithGson(jsonData,
                                 Student.class);
                 System.out.println(students);

    }
    // 将Json数据解析成相应的映射对象
     public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {
              Gson gson = new Gson();
                T result = gson.fromJson(jsonData, type);
                return result;
    }
    // 将Json数组解析成相应的映射对象列表
     public static <T> List<T> parseJsonArrayWithGson(String jsonData,
                                                      Class<T> type) {
                 Gson gson = new Gson();
                 List<T> result = gson.fromJson(jsonData, new TypeToken<List<T>>() {
         }.getType());
                 return result;
             }

}
