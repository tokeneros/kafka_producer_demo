package com.kafka.example.demo.serializer;

import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 * @Author: eros
 * @Description:
 * @Date: Created in 2020/4/7 18:56
 * @Version: 1.0
 * @Modified By:
 */
public class FileSerializer implements Serializer<Map<?,?>> {

    @Override
    public byte[] serialize(String topic, Map<?, ?> data) {
        byte[] bytes = null;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutput out = new ObjectOutputStream(bos);) {
            out.writeObject(data);
            bytes = bos.toByteArray();
        } catch (IOException e) {
            System.out.println(String.format("%s : %s", "kafka发送文件byte有问题", e.getMessage()));
        }
        return bytes;
    }

}
