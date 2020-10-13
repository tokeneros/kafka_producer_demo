package com.kafka.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  SpringApplication.run(DemoApplication.class, args);
        KafkaSender sender = context.getBean(KafkaSender.class);

        while(true) {
            //调用消息发送类中的消息发送方法
//            sender.send();
//            sender.send1();
//            sender.send2();
            sender.sendLog();
//            sender.sendPlugin();
//            sender.sendReload();
//            sender.send3();
//            sender.sendFile();
            try {
                Thread.sleep(3000 * 10);
//                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
