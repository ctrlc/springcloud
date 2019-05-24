package com.sa.springboot.service;


import com.sa.springboot.domain.User;

public interface HelloService {
    String hello();

    String hello(String name);

    User hello(String name, Integer age);

    String hello(User user);
}
