package com.at.ct.web.flume;

import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.Lists;
import org.apache.flume.*;
import org.apache.flume.conf.Configurable;
import org.apache.flume.sink.AbstractSink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class MysqlSink extends AbstractSink implements Configurable {

    private Logger LOG = LoggerFactory.getLogger(MysqlSink.class);
    private String hostname;
    private String port;
    private String databaseName;
    private String tableName;
    private String user;
    private String password;
    private PreparedStatement preparedStatement;
    private Connection conn;
    private int batchSize;

    public MysqlSink() {
        LOG.info("MysqlSink start...");
    }

    public void configure(Context context) {
        hostname = context.getString("hostname");
        Preconditions.checkNotNull(hostname, "hostname must be set!!");
        port = context.getString("port");
        Preconditions.checkNotNull(port, "port must be set!!");
        databaseName = context.getString("databaseName");
        Preconditions.checkNotNull(databaseName, "databaseName must be set!!");
        tableName = context.getString("tableName");
        Preconditions.checkNotNull(tableName, "tableName must be set!!");
        user = context.getString("user");
        Preconditions.checkNotNull(user, "user must be set!!");
        password = context.getString("password");
        Preconditions.checkNotNull(password, "password must be set!!");
        batchSize = context.getInteger("batchSize", 100);
        Preconditions.checkNotNull(batchSize > 0, "batchSize must be a positive number!!");
        System.out.println(hostname+port+databaseName+tableName+user+password);
    }

    @Override
    public void start() {
        super.start();
        try {
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://" + hostname + ":" + port + "/" + databaseName;
        //调用DriverManager对象的getConnection()方法，获得一个Connection对象
        System.out.println(hostname+port+databaseName+tableName+user+password+"---");
        System.out.println(url+"---");
        try {
            conn = DriverManager.getConnection(url, user, password);
            //conn.setAutoCommit(false);
            //创建一个Statement对象
            System.out.println("INSERT INTO t1 (content,create_by) values (?,?)");
            preparedStatement = conn.prepareStatement("INSERT INTO t1(content,create_by) values (?,?)");
            System.out.println("没毛病");
            System.out.println(preparedStatement);

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    @Override
    public void stop() {
        super.stop();
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Status process() throws EventDeliveryException {
        Status result = Status.READY;
        Channel channel = getChannel();
        Transaction transaction = channel.getTransaction();
        Event event;
        String content;


        List<Info> infos = Lists.newArrayList();
        transaction.begin();
        System.out.println(infos);
        try {
            for (int i = 0; i < batchSize; i++) {
                event = channel.take();
                if (event != null) {//对事件进行处理
                    //event 的 body 为   "exec tail$i , abel"
                    content = new String(event.getBody());
                    System.out.println(content);
                    Info info=new Info();
                    if (content.contains(",")) {
                        //存储 event 的 content
                        info.setContent(content.substring(0, content.indexOf(",")));
                        //存储 event 的 create  +1 是要减去那个 ","
                        info.setCreateBy(content.substring(content.indexOf(",")+1));
                    }else{
                        info.setContent(content);
                    }
                    infos.add(info);
                } else {
                    result = Status.BACKOFF;
                    break;
                }
            }
            for (Info temp1 : infos) {
                System.out.println(temp1.getContent());
                System.out.println(temp1.getCreateBy());
            }
            System.out.println(preparedStatement);
            if (infos.size() > 0) {
                preparedStatement.clearBatch();

                for (Info temp : infos) {
                    preparedStatement.setString(1, temp.getContent());
                    preparedStatement.setString(2, temp.getCreateBy());
                    preparedStatement.addBatch();

                }
                preparedStatement.executeBatch();
                conn.commit();
                System.out.println("没毛病2");
            }
            transaction.commit();
        } catch (Exception e) {
            try {
                transaction.rollback();
            } catch (Exception e2) {
                LOG.error("Exception in rollback. Rollback might not have been" +
                        "successful.", e2);
            }
            LOG.error("Failed to commit transaction." +
                    "Transaction rolled back.", e);
            Throwables.propagate(e);
        } finally {
            transaction.close();
        }
        return result;
    }
}
