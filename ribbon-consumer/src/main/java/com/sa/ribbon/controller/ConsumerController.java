package com.sa.ribbon.controller;

import com.sa.ribbon.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @RequestMapping("/ribbon-consumer")
    public String consumer(){
        return consumerService.helloService();
    }
}
