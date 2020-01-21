package com.dhg.sell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//importResource的location配置是一String数组
@ImportResource(locations = {"classpath:beans.xml"})
public class SellApplication{

    public static void main(String[] args) {

        SpringApplication.run(SellApplication.class, args);

    }
}
