package com.sa.feign.service;

import com.sa.feign.domian.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("springboot")
public interface HelloService {

   @RequestMapping("/hello")
    String hello();

    @RequestMapping(value="/hello1", method= RequestMethod.GET)
    String hello(@RequestHeader String name);

    @RequestMapping(value="/hello2", method= RequestMethod.GET)
    User hello(@RequestHeader String name, @RequestHeader Integer age);

    @RequestMapping(value="/hello3", method=RequestMethod.POST)
    String hello(@RequestBody User user);
}
