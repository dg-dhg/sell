package com.dhg.sell.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{
    /**将返回一个值作为relativeName*/
    @RequestMapping("/hello")
    public String hello(){
        return "helloWorld";
    }

}
