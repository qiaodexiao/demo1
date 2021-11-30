package cn.com.bonc.xmlUdf;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.Iterator;
import java.util.List;


public class XMLtoUDF {

    public void XmltoUdf(File file1,File file2) throws DocumentException {
//1.创建Reader对象
        SAXReader saxReader = new SAXReader();
        //2.加载xml
        Document document = saxReader.read(file1);
        //3.获取根节点
        Element rootElement = document.getRootElement();
        Iterator iterator = rootElement.elementIterator();
        while (iterator.hasNext()) {
            Element stu = (Element) iterator.next();
            List<Attribute> attributes = stu.attributes();
          //  System.out.println("======获取属性值======");
            for (Attribute attribute : attributes) {
                System.out.println(attribute.getValue());
            }
           // System.out.println("======遍历子节点======");
            Iterator iterator1 = stu.elementIterator();
            while (iterator1.hasNext()) {
                Element stuChild = (Element) iterator1.next();
                String stringValue = stuChild.getStringValue();
              //  System.out.println("节点名：" + stuChild.getName() + "---节点值：" + stringValue);
                InputStream in = new ByteArrayInputStream(stringValue.getBytes());
                BufferedInputStream bips = new BufferedInputStream(in);
                int len;
                byte[] b = new byte[8192000];
                OutputStream out = null;
                try {
                    out = new FileOutputStream(new File(
                            "D:\\bonc\\bonc项目\\解析XML\\XML文件备份\\trans.txt"));
                    len = bips.read(b);
                    if (len > 0) {
                        out.write(b, 0, len);
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    out.close();
                    bips.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();


                }
            }
        }

        //文件路径
        String filePath = "D:\\bonc\\bonc项目\\解析XML\\XML文件备份\\trans.txt";

        File fil = new File(filePath);

        BufferedReader reader = null;//字符输入流进行读取操作读取
        BufferedWriter bfw = null;
        String tempString = null;//每一行的内容

        int line = 1;//行号

        try {
            //输入字节流，FileInputStream主要用来操作文件输入流
            FileInputStream intput = new FileInputStream(fil);
            // System.out.println("以行为单位读取文件内容，一次读一整行：")
            //InputStreamReader是转换流，将字节流转成字符流
            reader = new BufferedReader(new InputStreamReader(intput));
            //字符输出流
            bfw = new BufferedWriter(new FileWriter(file2));
            //计数器
            int count = 0;
            StringBuilder sb = new StringBuilder();
            while ((tempString = reader.readLine()) != null) {
                count ++;
                //   System.out.println(count);
                //  if (count ==4||count ==5||count ==6||count ==7||count ==8||count ==9||count ==10||count ==11||count ==12||count ==14||count ==16||count ==17||count ==18||count ==23||count ==24||){
                if (count ==4||count ==5||count ==6||count ==7||count ==8||count ==9||count ==10||count ==11||count ==12||count ==14||count ==16||count ==17||count ==18||count ==23){
                    sb.append(tempString).append("|");

                }
                else if (count==24){
                    sb.append(tempString);
                    count = -3;
                    bfw.write(sb.toString());
                    bfw.newLine();//写入一个换行符，具有平台兼容性
                    bfw.flush();//刷新
                    //  System.out.println(sb.toString());
                    sb.replace(0,sb.length(),"");
                }
                else
                {
                    //System.out.println("****************************************");
                }
                // System.out.println("第" + line + "行:" + tempString);
                line++;

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    bfw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
