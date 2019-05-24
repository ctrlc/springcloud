package com.sa.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "errorFallback")
    public String helloService(){
        return restTemplate.getForEntity("http://SPRINGBOOT/hello",String.class).getBody();
    }

    public String errorFallback(){
        return "error (hystrix)";
    }
}
