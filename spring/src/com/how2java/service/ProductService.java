package com.how2java.service;

import org.springframework.stereotype.Component;

@Component("s")
public class ProductService {
    public void doSomeService(){
        System.out.println("doSomeService 1");
    }

    public void verify(){
        System.out.println("verify 1");
    }

}
