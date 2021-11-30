package com.at.ct.web.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

public class Dom4J_XML {
    public static void main(String[] args) throws DocumentException {

        String url="jdbc:mysql://localhost:3306/db_1?autoReconnect=true";//url是固定的 jdbc:mysql://localhost:3036/数据库名
        String user="root";//这里一般是root
        String password="root";//这是登陆数据库的密码，我的密码为空
        String word="insert into vip1(\n" +
                "classid            , \n" +
                "classname          , \n" +
                "CHNL_CODE          , \n" +
                "CHNL_NAME          , \n" +
                "CHNL_DESC          , \n" +
                "CHNL_ORG_ID        , \n" +
                "STATE              , \n" +
                "STATE_DESC         , \n" +
                "CHNL_KIND_ID       , \n" +
                "LOCAL_KIND_ID      , \n" +
                "CHNL_CLASS_ID      , \n" +
                "CHAIN_FLAG         , \n" +
                "IS_RWD_CNT         , \n" +
                "PAY_SCOPE          , \n" +
                "PAY_CHNL_CODE      , \n" +
                "SUPER_CHNL_CODE    , \n" +
                "SEFL_CHNL_CODE     , \n" +
                "RWD_CNT_DATE       , \n" +
                "PROVINCE_CODE      , \n" +
                "CITY_CODE          , \n" +
                "MANAGER_AREA_CODE  , \n" +
                "AREA_TYPE          , \n" +
                "CHNL_CHAIN_LEVEL   , \n" +
                "CHNL_LEVEL         , \n" +
                "IS_INPUT_SYSTEM    , \n" +
                "SYSTEM_NUM         , \n" +
                "IS_MINI_HALL       , \n" +
                "CHNL_AREA_KIND_ID  , \n" +
                "BANK_CODE          , \n" +
                "BANK_NO            , \n" +
                "BANK_ACCT_NAME     , \n" +
                "ADDRESS            , \n" +
                "CHNL_LINKMAN_NAME  , \n" +
                "CHNL_LINKMAN_SEX   , \n" +
                "CHNL_EMAIL         , \n" +
                "CHNL_FAX           , \n" +
                "CHNL_ADDR          , \n" +
                "CHNL_OFFICE_PHONE  , \n" +
                "CHNL_PHONE         , \n" +
                "CHNL_POSTALCODE    , \n" +
                "MANAGER_DEPT_CODE  , \n" +
                "MANAGER_STAFF_COD  , \n" +
                "MANAGER_PHONE      , \n" +
                "REMARK             , \n" +
                "AFFILIATETIME      , \n" +
                "CREATE_STAFF_CODE  , \n" +
                "CREATE_TIME        , \n" +
                "BSS_SYS_CODEg      , \n" +
                "BSS_SYS_CODE2      , \n" +
                "MANAGER_AREA_CODE1 , \n" +
                "PARA_ID            , \n" +
                "PARA_VALUE) \n" +
                " values(?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,     \n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?, \n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?,\n" +
                "?)" ;//问号是占位符
        try {
            Class.forName("com.mysql.jdbc.Driver");//加载驱动类
            Connection con= DriverManager.getConnection(url, user, password);//创建连接对象，来连接数据库
            PreparedStatement ps=con.prepareStatement(word);//创建执行对象
            long startTime = System.currentTimeMillis();
            File file = new File("D:\\wixinxiazai\\WeChat Files\\wxid_fitipucxga6z22\\FileStorage\\File\\2021-05\\Dom4J_XML\\C_B_95_BSDM_CHL_20210506_0001_A_1.XML");
//        File file1 = new File("C:\\Users\\85313\\Desktop\\test.XML");
            // 创建SAXReader实例
            SAXReader reader = new SAXReader();
            // read()读取指定的XML文档并形成DOM树
            Document doc = reader.read(file);
            // getRootElement()获取根节点
            Element ele = doc.getRootElement();
            //获取根节点名称   BSDM_ROOT
            String name_1 = ele.getName();
//        System.out.println(name);

            //获取根节点下子节点 UNI_BSS_BODY
            Iterator UNI_BSS_BODY = ele.elementIterator("UNI_BSS_BODY");

            // 遍历UNI_BSS_BODY节点
            while (UNI_BSS_BODY.hasNext()){
                Element second = (Element) UNI_BSS_BODY.next();
                //获取UNI_BSS_BODY节点节点下子节点 CHANNEL_INFO_REQ
                Iterator CHANNEL_INFO_REQ = second.elementIterator("CHANNEL_INFO_REQ");
                //遍历CHANNEL_INFO_REQ节点
                while (CHANNEL_INFO_REQ.hasNext()){
                    Element thrid = (Element) CHANNEL_INFO_REQ.next();
                    //获取CHANNEL_INFO_REQ节点节点下子节点 CHANNEL_INFO_LIST
                    Iterator CHANNEL_INFO_LIST = thrid.elementIterator("CHANNEL_INFO_LIST");
                    //遍历CHANNEL_INFO_LIST节点
                    while (CHANNEL_INFO_LIST.hasNext()){
                        Element four = (Element) CHANNEL_INFO_LIST.next();
                        //获取CHANNEL_INFO_LIST节点节点下子节点 CHANNEL_INFO
                        Iterator CHANNEL_INFO = four.elementIterator("CHANNEL_INFO");
                        //遍历CHANNEL_INFO节点
                        while (CHANNEL_INFO.hasNext()){
                            Element five = (Element) CHANNEL_INFO.next();

                            //拿到CHANNEL_INFO下的子节点的值
                            String CHNL_CODE = five.elementTextTrim("CHNL_CODE");
                            System.out.println("CHNL_CODE,"+CHNL_CODE);

                            String CHNL_NAME = five.elementTextTrim("CHNL_NAME");
                            System.out.println("CHNL_NAME,"+CHNL_NAME);

                            String CHNL_DESC = five.elementTextTrim("CHNL_DESC");
                            System.out.println("CHNL_DESC,"+CHNL_DESC);

                            String CHNL_ORG_ID = five.elementTextTrim("CHNL_ORG_ID");
                            System.out.println("CHNL_ORG_ID,"+CHNL_ORG_ID);

                            String STATE = five.elementTextTrim("STATE");
                            System.out.println("STATE,"+STATE);

                            String STATE_DESC = five.elementTextTrim("STATE_DESC");
                            System.out.println("STATE_DESC,"+STATE_DESC);

                            String CHNL_KIND_ID = five.elementTextTrim("CHNL_KIND_ID");
                            System.out.println("CHNL_KIND_ID,"+CHNL_KIND_ID);

                            String LOCAL_KIND_ID = five.elementTextTrim("LOCAL_KIND_ID");
                            System.out.println("LOCAL_KIND_ID,"+LOCAL_KIND_ID);

                            String CHNL_CLASS_ID = five.elementTextTrim("CHNL_CLASS_ID");
                            System.out.println("CHNL_CLASS_ID,"+CHNL_CLASS_ID);

                            String CHAIN_FLAG = five.elementTextTrim("CHAIN_FLAG");
                            System.out.println("CHAIN_FLAG,"+CHAIN_FLAG);

                            String IS_RWD_CNT = five.elementTextTrim("IS_RWD_CNT");
                            System.out.println("IS_RWD_CNT,"+IS_RWD_CNT);

                            String PAY_SCOPE = five.elementTextTrim("PAY_SCOPE");
                            System.out.println("PAY_SCOPE,"+PAY_SCOPE);

                            String PAY_CHNL_CODE = five.elementTextTrim("PAY_CHNL_CODE");
                            System.out.println("PAY_CHNL_CODE,"+PAY_CHNL_CODE);

                            String SUPER_CHNL_CODE = five.elementTextTrim("SUPER_CHNL_CODE");
                            System.out.println("SUPER_CHNL_CODE,"+SUPER_CHNL_CODE);

                            String SEFL_CHNL_CODE = five.elementTextTrim("SEFL_CHNL_CODE");
                            System.out.println("SEFL_CHNL_CODE,"+SEFL_CHNL_CODE);

                            String RWD_CNT_DATE = five.elementTextTrim("RWD_CNT_DATE");
                            System.out.println("RWD_CNT_DATE,"+RWD_CNT_DATE);

                            String PROVINCE_CODE = five.elementTextTrim("PROVINCE_CODE");
                            System.out.println("PROVINCE_CODE,"+PROVINCE_CODE);

                            String CITY_CODE = five.elementTextTrim("CITY_CODE");
                            System.out.println("CITY_CODE,"+CITY_CODE);

                            String MANAGER_AREA_CODE = five.elementTextTrim("MANAGER_AREA_CODE");
                            System.out.println("MANAGER_AREA_CODE,"+MANAGER_AREA_CODE);

                            String AREA_TYPE = five.elementTextTrim("AREA_TYPE");
                            System.out.println("AREA_TYPE,"+AREA_TYPE);

                            String CHNL_CHAIN_LEVEL = five.elementTextTrim("CHNL_CHAIN_LEVEL");
                            System.out.println("CHNL_CHAIN_LEVEL,"+CHNL_CHAIN_LEVEL);

                            String CHNL_LEVEL = five.elementTextTrim("CHNL_LEVEL");
                            System.out.println("CHNL_LEVEL,"+CHNL_LEVEL);

                            String IS_INPUT_SYSTEM = five.elementTextTrim("IS_INPUT_SYSTEM");
                            System.out.println("IS_INPUT_SYSTEM,"+IS_INPUT_SYSTEM);

                            String SYSTEM_NUM = five.elementTextTrim("SYSTEM_NUM");
                            System.out.println("SYSTEM_NUM,"+SYSTEM_NUM);

                            String IS_MINI_HALL = five.elementTextTrim("IS_MINI_HALL");
                            System.out.println("IS_MINI_HALL,"+IS_MINI_HALL);

                            String CHNL_AREA_KIND_ID = five.elementTextTrim("CHNL_AREA_KIND_ID");
                            System.out.println("CHNL_AREA_KIND_ID,"+CHNL_AREA_KIND_ID);

                            String BANK_CODE = five.elementTextTrim("BANK_CODE");
                            System.out.println("BANK_CODE,"+BANK_CODE);

                            String BANK_NO = five.elementTextTrim("BANK_NO");
                            System.out.println("BANK_NO,"+BANK_NO);

                            String BANK_ACCT_NAME = five.elementTextTrim("BANK_ACCT_NAME");
                            System.out.println("BANK_ACCT_NAME,"+BANK_ACCT_NAME);

                            String ADDRESS = five.elementTextTrim("ADDRESS");
                            System.out.println("ADDRESS,"+ADDRESS);

                            String CHNL_LINKMAN_NAME = five.elementTextTrim("CHNL_LINKMAN_NAME");
                            System.out.println("CHNL_LINKMAN_NAME,"+CHNL_LINKMAN_NAME);

                            String CHNL_LINKMAN_SEX = five.elementTextTrim("CHNL_LINKMAN_SEX");
                            System.out.println("CHNL_LINKMAN_SEX,"+CHNL_LINKMAN_SEX);

                            String CHNL_EMAIL = five.elementTextTrim("CHNL_EMAIL");
                            System.out.println("CHNL_EMAIL,"+CHNL_EMAIL);

                            String CHNL_FAX = five.elementTextTrim("CHNL_FAX");
                            System.out.println("CHNL_FAX,"+CHNL_FAX);

                            String CHNL_ADDR = five.elementTextTrim("CHNL_ADDR");
                            System.out.println("CHNL_ADDR,"+CHNL_ADDR);

                            String CHNL_OFFICE_PHONE = five.elementTextTrim("CHNL_OFFICE_PHONE");
                            System.out.println("CHNL_OFFICE_PHONE,"+CHNL_OFFICE_PHONE);

                            String CHNL_PHONE = five.elementTextTrim("CHNL_PHONE");
                            System.out.println("CHNL_PHONE,"+CHNL_PHONE);

                            String CHNL_POSTALCODE = five.elementTextTrim("CHNL_POSTALCODE");
                            System.out.println("CHNL_POSTALCODE,"+CHNL_POSTALCODE);

                            String MANAGER_DEPT_CODE = five.elementTextTrim("MANAGER_DEPT_CODE");
                            System.out.println("MANAGER_DEPT_CODE,"+MANAGER_DEPT_CODE);

                            String MANAGER_STAFF_CODE = five.elementTextTrim("MANAGER_STAFF_CODE");
                            System.out.println("MANAGER_STAFF_CODE,"+MANAGER_STAFF_CODE);

                            String MANAGER_PHONE = five.elementTextTrim("MANAGER_PHONE");
                            System.out.println("MANAGER_PHONE,"+MANAGER_PHONE);

                            String REMARK = five.elementTextTrim("REMARK");
                            System.out.println("REMARK,"+REMARK);

                            String AFFILIATETIME = five.elementTextTrim("AFFILIATETIME");
                            System.out.println("AFFILIATETIME,"+AFFILIATETIME);

                            String CREATE_STAFF_CODE = five.elementTextTrim("CREATE_STAFF_CODE");
                            System.out.println("CREATE_STAFF_CODE,"+CREATE_STAFF_CODE);

                            String CREATE_TIME = five.elementTextTrim("CREATE_TIME");
                            System.out.println("CREATE_TIME,"+CREATE_TIME);

                            String BSS_SYS_CODE = five.elementTextTrim("BSS_SYS_CODE");
                            System.out.println("BSS_SYS_CODE,"+BSS_SYS_CODE);

                            String BSS_SYS_CODE2 = five.elementTextTrim("BSS_SYS_CODE2");
                            System.out.println("BSS_SYS_CODE2,"+BSS_SYS_CODE2);

                            String MANAGER_AREA_CODE_1 = five.elementTextTrim("MANAGER_AREA_CODE");
                            System.out.println("MANAGER_AREA_CODE,"+MANAGER_AREA_CODE_1);

                            //获取CHANNEL_INFO节点节点下子节点 DEVLIST
                            Iterator DEVLIST = five.elementIterator("DEVLIST");
                            //遍历DEVLIST节点
                            while (DEVLIST.hasNext()){
                                Element six = (Element) DEVLIST.next();
                                //获取DEVLIST节点节点下子节点 DEVELOPER
                                Iterator DEVELOPER = six.elementIterator("DEVELOPER");
                                //遍历DEVELOPER节点
                                while (DEVELOPER.hasNext()){
                                    Element seven = (Element) DEVELOPER.next();
                                    //拿到DEVELOPER下的子节点的值
                                    String DEV_CODE = seven.elementTextTrim("DEV_CODE");
                                    System.out.println("DEV_CODE,"+DEV_CODE);

                                    String DEV_TYPE_ID  = seven.elementTextTrim("DEV_TYPE_ID");
                                    System.out.println("DEV_TYPE_ID,"+DEV_TYPE_ID);

                                    String DEV_NAME  = seven.elementTextTrim("DEV_NAME");
                                    System.out.println("DEV_NAME,"+DEV_NAME);

                                    String DEV_STAFF_CODE  = seven.elementTextTrim("DEV_STAFF_CODE");
                                    System.out.println("DEV_STAFF_CODE,"+DEV_STAFF_CODE);

                                    String USER_PID = seven.elementTextTrim("USER_PID");
                                    System.out.println("USER_PID,"+USER_PID);

                                    String LINKMAN_PHONE = seven.elementTextTrim("LINKMAN_PHONE");
                                    System.out.println("LINKMAN_PHONE,"+LINKMAN_PHONE);

                                    String LINKMAN_EMAIL = seven.elementTextTrim("LINKMAN_EMAIL");
                                    System.out.println("LINKMAN_EMAIL,"+LINKMAN_EMAIL);

                                    String GROUP_ACCT = seven.elementTextTrim("GROUP_ACCT");
                                    System.out.println("GROUP_ACCT,"+GROUP_ACCT);

                                    String LINKMAN_ADDR = seven.elementTextTrim("LINKMAN_ADDR");
                                    System.out.println("LINKMAN_ADDR,"+LINKMAN_ADDR);

                                    String LINKMAN_POSTCODE = seven.elementTextTrim("LINKMAN_POSTCODE");
                                    System.out.println("LINKMAN_POSTCODE,"+LINKMAN_POSTCODE);

                                    String REMARK_1 = seven.elementTextTrim("REMARK");
                                    System.out.println("REMARK,"+REMARK_1);

                                    String BSS_SYS_CODE_1 = seven.elementTextTrim("BSS_SYS_CODE");
                                    System.out.println("BSS_SYS_CODE,"+BSS_SYS_CODE_1);

                                    String BSS_SYS_CODE2_1 = seven.elementTextTrim("BSS_SYS_CODE2");
                                    System.out.println("BSS_SYS_CODE2,"+BSS_SYS_CODE2_1);







                                }

                            }

                            //获取CHANNEL_INFO节点节点下子节点 PARA
                            Iterator PARA = five.elementIterator("PARA");
                            //遍历PARA节点
                            while (PARA.hasNext()){
                                Element six_1 = (Element) PARA.next();
                                //获取PARA节点节点下值
                                String PARA_ID = six_1.elementTextTrim("PARA_ID");
                                System.out.println("PARA_ID,"+PARA_ID);

                                String PARA_VALUE = six_1.elementTextTrim("PARA_VALUE");
                                System.out.println("PARA_VALUE,"+PARA_VALUE);
                                ps.setString(1,"1");
                                ps.setString(2,"1");
                                ps.setString(3,CHNL_CODE);
                                ps.setString(4,CHNL_NAME);
                                ps.setString(5,CHNL_DESC);
                                ps.setString(6,CHNL_ORG_ID);
                                ps.setString(7,STATE);
                                ps.setString(8,STATE_DESC);
                                ps.setString(9,CHNL_KIND_ID);
                                ps.setString(10,LOCAL_KIND_ID);
                                ps.setString(11,CHNL_CLASS_ID);
                                ps.setString(12,CHAIN_FLAG);
                                ps.setString(13,IS_RWD_CNT);
                                ps.setString(14,PAY_SCOPE);
                                ps.setString(15,PAY_CHNL_CODE);
                                ps.setString(16,SUPER_CHNL_CODE);
                                ps.setString(17,SEFL_CHNL_CODE);
                                ps.setString(18,RWD_CNT_DATE);
                                ps.setString(19,PROVINCE_CODE);
                                ps.setString(20,CITY_CODE);
                                ps.setString(21,MANAGER_AREA_CODE);
                                ps.setString(22,AREA_TYPE);
                                ps.setString(23,CHNL_CHAIN_LEVEL);
                                ps.setString(24,CHNL_LEVEL);
                                ps.setString(25,IS_INPUT_SYSTEM);
                                ps.setString(26,SYSTEM_NUM);
                                ps.setString(27,IS_MINI_HALL);
                                ps.setString(28,CHNL_AREA_KIND_ID);
                                ps.setString(29,BANK_CODE);
                                ps.setString(30,BANK_NO);
                                ps.setString(31,BANK_ACCT_NAME);
                                ps.setString(32,ADDRESS);
                                ps.setString(33,CHNL_LINKMAN_NAME);
                                ps.setString(34,CHNL_LINKMAN_SEX);
                                ps.setString(35,CHNL_EMAIL);
                                ps.setString(36,CHNL_FAX);
                                ps.setString(37,CHNL_ADDR);
                                ps.setString(38,CHNL_OFFICE_PHONE);
                                ps.setString(39,CHNL_PHONE);
                                ps.setString(40,CHNL_POSTALCODE);
                                ps.setString(41,MANAGER_DEPT_CODE);
                                ps.setString(42,MANAGER_STAFF_CODE);
                                ps.setString(43,MANAGER_PHONE);
                                ps.setString(44,REMARK);
                                ps.setString(45,AFFILIATETIME);
                                ps.setString(46,CREATE_STAFF_CODE);
                                ps.setString(47,CREATE_TIME);
                                ps.setString(48,BSS_SYS_CODE);
                                ps.setString(49,BSS_SYS_CODE2);
                                ps.setString(50,MANAGER_AREA_CODE_1);
                                ps.setString(51,PARA_ID);
                                ps.setString(52,PARA_VALUE);
                                ps.executeUpdate();//执行sql命令

                            }


                            System.out.println("---------- ");


                            //获取CHANNEL_INFO节点节点下子节点 DEVLIST
                        }
                    }



                }
            }

            // elements()获取根节点的子节点
//        List<Element> CHANNEL_INFO_REQ = ele.elements();

            // 遍历子节点
//        for (Element CHANNEL_INFO_LIST: CHANNEL_INFO_REQ) {
            // element()获取子节点指定的子元素
//            Element CHANNEL_INFO = CHANNEL_INFO_LIST.element("CHANNEL_INFO");

            // getText()获取子元素的文本内容
//            String CHNL_CODE = CHANNEL_INFO.getText();
//            System.out.println();
            // elementText()直接获取元素的文本内容

            // attributeValue()直接获取元素的属性值
//        }
            long endTime = System.currentTimeMillis();
            System.out.println("\n");
            System.out.println("/**总耗时为："+(endTime-startTime)+"毫秒");
            ps.close();
            con.close();
        } catch (ClassNotFoundException e) {    //这里是错误捕捉，如果出错，计算机就会执行这段代码，下面的也是
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
