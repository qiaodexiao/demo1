package com.at.ct.web.test;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumerClient {

    public static void main(String[] args) {
        //构建PROP用于管理配置
        Properties props = new Properties();
        //指定Kafka的服务端地址
        props.put("bootstrap.servers", "hadoop101:9092,hadoop102:9092,hadoop103:9092");
        //指定消费者组的id
        props.put("group.id", "test");
        //是否让kafka自动提交消费的偏移量
        props.put("enable.auto.commit", "true");
        //按照固定时间间隔来记录的
        props.put("auto.commit.interval.ms", "1000");
        //反序列化
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        //构建一个Kafka消费者对象
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String,String>(props);
        //指定要消费的Topic
        consumer.subscribe(Arrays.asList("second"));
        //源源不断的进行消费
        while (true) {
            //消费者拉取对应Topic的数据
            ConsumerRecords<String, String> records = consumer.poll(100);
            //迭代取出每一条数据
            for (ConsumerRecord<String, String> record : records){
                //获取这条数据属于哪个Topic
                String topic = record.topic();
                //获取这条数据属于这个topic的哪个分区
                int partition = record.partition();
                //获取这个数据在这个分区中对应的偏移量
                long offset = record.offset();
                //获取Key
                String key = record.key();
                //获取value
                String value = record.value();
                System.out.println(topic+"\t"+partition+"\t"+offset+"\t"+key+"" + "\t"+value);
            }
        }
    }
}
