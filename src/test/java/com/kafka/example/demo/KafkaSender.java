package com.kafka.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: eros
 * @Description:
 * @Date: Created in 2019/12/30 10:21
 * @Version: 1.0
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class KafkaSender {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String topic = "topic";

    @Test
    public void testSender(){
        for(int i = 0 ; i < 5 ; i++){
//            kafkaProducer.send(new ProducerRecord(topic,"kafkaProducer","ttttttttttttttttttttttt"));
            kafkaTemplate.send(topic,"kafkaProducer","ttttttttttttttttttttttt");
//            System.out.println(1111);
        }
    }

}
