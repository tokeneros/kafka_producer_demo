package com.kafka.example.demo;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Autowired
    private KafkaTemplate<String, Map<String, Object>> kafkaMapTemplate;

    //发送消息方法
    public void send() {
        kafkaTemplate.send(new ProducerRecord("test1","1111111111111111111"));
    }

    //发送消息方法
    public void sendLog() {
//        kafkaTemplate.send(new ProducerRecord("network.log", "{\"host\":\"192.168.1.200\",\"deploymentId\":\"1\",\"tag\":\"network.local7.err\",\"time\":\"1584344951\",\"message\":\"1754824: -Process= \\\"TTY Background\\\", ipl= 6, pid= 26\",\"priority\":\"err\",\"facility\":\"local7\"}"));
        kafkaTemplate.send(new ProducerRecord("kafka_test2", "{\"message\":\"11982: 1w1d: %CDP-4-DUPLEX_MISMATCH: duplex mismatch discovered on FastEthernet0/14 (not half duplex), with Core Ethernet0/0 (half duplex).\",\"priority\":\"warn\",\"facility\":\"local7\",\"source\":\"192.168.1.200\",\"hostname\":\"cede6b26c3ea\",\"time\":"+ Instant.now().getEpochSecond() +",\"tag\":\"network.local7.warn\"}"));
    }

    //发送消息方法
    public void sendReload() {
//        kafkaTemplate.send(new ProducerRecord("network.log", "{\"host\":\"192.168.1.200\",\"deploymentId\":\"1\",\"tag\":\"network.local7.err\",\"time\":\"1584344951\",\"message\":\"1754824: -Process= \\\"TTY Background\\\", ipl= 6, pid= 26\",\"priority\":\"err\",\"facility\":\"local7\"}"));
        kafkaTemplate.send(new ProducerRecord("network.log", "{\"type\":\"event_reload\"}"));
    }

    //发送消息方法
    public void send1() {
        kafkaTemplate.send(new ProducerRecord("test2","2222222222222222222"));
    }

    //发送消息方法
    public void send2() {
        kafkaTemplate.send(new ProducerRecord("test3","3333333333333333333"));
    }

    public void send3() {
        kafkaTemplate.send(new ProducerRecord("INFO_FACILITY_TOPIC","3333333333333333333"));
    }

    public void sendFile() {
        File file = new File("G:\\workspace\\eros\\upper-hand\\kafka_producer_demo\\collection-common-plug-1.0.0.jar");
        try (
             ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length());
             BufferedInputStream in = new BufferedInputStream (new FileInputStream(file));){

            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len = 0;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            byte[] data = bos.toByteArray();
            Map<String, Object> map = new HashMap();
            map.put("fileName","collection-common-plug-1.0.0.jar");
            map.put("fileContent",data);
            kafkaMapTemplate.send("test1",map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendPlugin() {
        kafkaTemplate.send(new ProducerRecord("KAFKA-HANDLE","Hi Plugin"));
    }

}