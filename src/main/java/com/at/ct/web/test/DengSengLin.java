package com.at.ct.web.test;

//全量读取
import java.io.*;
public class DengSengLin {

    public static void main(String[] args)  {

        //文件路径
        String filePath = "D:\\\\zhuomian\\工作\\20210823\\tf_planning_cust_group_attrlist_rel.txt";
        File fil = new File(filePath);
        FileInputStream fis = null;
        int n = 0;//行号
        try {
            //输入字节流，FileInputStream主要用来操作文件输入流
            fis =new FileInputStream(fil);
            byte[] bytes = new byte[1024];

            while ((n = fis.read(bytes)) != -1) {
                //将字节转换成string
                //此时实例化s时,要注意指定编码格式,电脑上文档默认的是GBK,而我这边默认的是utf-8，
                //所以如果不指定格式的话,最后输出的中文会出现乱码
                String s = new String(bytes, 0, n,"UTF-8");
                System.out.print(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭文件流(关键)
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
