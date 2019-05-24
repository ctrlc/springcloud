package com.sa.kafka.produce;

import com.alibaba.fastjson.JSON;
import com.sa.kafka.beans.KafkaMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class KafkaProduce {
    Logger log = LoggerFactory.getLogger(KafkaProduce.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    //发送消息方法
    public void send() {
        KafkaMessage message = new KafkaMessage();
        message.setId(System.currentTimeMillis());
        message.setMsg("hello kafka:" + UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("+++++++++++++++++++++  message = {}", JSON.toJSONString(message));
        kafkaTemplate.send("topic-sa", JSON.toJSONString(message));
    }
}
