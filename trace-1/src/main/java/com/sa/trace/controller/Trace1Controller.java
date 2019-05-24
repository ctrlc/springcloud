package com.sa.trace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Trace1Controller {
    Logger logger = LoggerFactory.getLogger(Trace1Controller.class);

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @RequestMapping(value = "trace-1", method = RequestMethod.GET)
    public String trace(){
        logger.info("call --> trace1");
        return restTemplate().getForEntity("http://localhost:9081/trace-2",String.class).getBody();
    }
}
