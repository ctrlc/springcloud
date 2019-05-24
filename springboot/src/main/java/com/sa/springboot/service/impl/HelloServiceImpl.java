package com.sa.springboot.service.impl;

import com.sa.springboot.domain.User;
import com.sa.springboot.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Value("${server.port}")
    String port;

    public String hello() {
        logger.info("/hello 服务由: localhost:" + port + " 提供");
        return "Hello World";
    }

    public String hello(String name) {
        logger.info("/hello1 服务由: localhost:" + port + " 提供");
        return name;
    }

    public User hello(String name, Integer age) {
        logger.info("/hello2 服务由: localhost:" + port + " 提供");
        return new User(name, age);
    }

    public String hello(User user) {
        logger.info("/hello3 服务由: localhost:" + port + " 提供");
        return "name: "+ user.getName() + " age: "+ user.getAge();
    }
}
