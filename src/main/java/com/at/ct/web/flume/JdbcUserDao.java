package com.at.ct.web.flume;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class JdbcUserDao  {
   public  static void  main(String[] args) {

       String driverClassName = "com.mysql.jdbc.Driver";	//启动驱动
       String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false";	//设置连接路径
       String username = "root";	//数据库用户名
       String password = "123456";	//数据库连接密码
       Connection con = null;		//连接
       PreparedStatement pstmt = null;	//使用预编译语句
       ResultSet rs = null;	//获取的结果集
       try {
           Class.forName(driverClassName); //执行驱动
           con = DriverManager.getConnection(url, username, password); //获取连接


           String sql = "INSERT INTO t1(content,create_by) VALUES(?,?)"; //设置的预编译语句格式
           pstmt = con.prepareStatement(sql);
           pstmt.setString(1, "我是你爸爸");
           pstmt.setString(2, "牛逼");
           pstmt.executeUpdate();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }finally {
           //关闭资源,倒关
           try {
               if(rs != null) rs.close();
               if(pstmt != null) pstmt.close();
               if(con != null) con.close();  //必须要关
           } catch (Exception e) {
           }
       }



   }


}
