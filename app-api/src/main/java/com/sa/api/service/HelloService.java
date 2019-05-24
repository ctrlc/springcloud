package com.sa.api.service;


import com.sa.api.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
@FeignClient("springboot")
public interface HelloService {
    String hello();

    String hello(String name);

    User hello(String name, Integer age);

    String hello(User user);
}
