package com.sa.springboot.controller;

import com.sa.springboot.domain.User;
import com.sa.springboot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return helloService.hello();
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestHeader String name) {
        return helloService.hello(name);
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return helloService.hello(name, age);
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        return helloService.hello(user);
    }

}
