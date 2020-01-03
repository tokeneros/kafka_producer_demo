package com.kafka.example.demo;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: eros
 * @Description:
 * @Date: Created in 2019/12/30 10:21
 * @Version: 1.0
 * @Modified By:
 */
@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //发送消息方法
    public void send() {
        kafkaTemplate.send(new ProducerRecord("test1","1111111111111111111"));
    }

    //发送消息方法
    public void send1() {
        kafkaTemplate.send(new ProducerRecord("test2","2222222222222222222"));
    }

    //发送消息方法
    public void send2() {
        kafkaTemplate.send(new ProducerRecord("test3","3333333333333333333"));
    }
}