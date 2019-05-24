package com.sa.feign.controller;
import com.sa.feign.domian.User;
import com.sa.feign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value="/feign-consumer2", method= RequestMethod.GET)
    public String feignConsumer2(){
        return "lalal";
    }

   @RequestMapping(value="/feign-consumer", method= RequestMethod.GET)
    public String feignConsumer(){
        return helloService.hello();
    }

    @RequestMapping(value="/feign-consumer-hello", method= RequestMethod.GET)
    public String helloConsumer(){
        StringBuilder sb = new StringBuilder();
        sb.append("/hello: ").append(helloService.hello()).append("\n\r");
        sb.append("/hello1: ").append(helloService.hello("wow")).append("\n\r");
        sb.append("/hello2: ").append(helloService.hello("sa",30)).append("\n\r");
        sb.append("/hello3: ").append(helloService.hello(new User("liyan",30))).append("\n\r");
        return sb.toString();
    }
}
