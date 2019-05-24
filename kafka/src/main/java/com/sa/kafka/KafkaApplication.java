package com.sa.kafka;

import com.sa.kafka.produce.KafkaProduce;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KafkaApplication.class, args);

        KafkaProduce sender = context.getBean(KafkaProduce.class);
        for (int i = 0; i < 3; i++) {
            try {
                //调用消息发送类中的消息发送方法
                sender.send();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
