package com.dhg.sell.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBeanServiceTest{
//    @Autowired
//    private TestBeanService service;
    //ioc容器,也是应用上下文,因为环境就是所有运行的bean
    @Autowired
    private ConfigurableApplicationContext ioc;
    /**
     * 添加了@service注解的情况下,输出true
     * 没有添加配置和@Service的情况下输出false
     * 在启动类添加了importResource注解之后true
     * 相当于有两种ioc的方法
     *
     * */
    @Test
    public void helloBean() {
        boolean exist = ioc.containsBean("testBeanService");
        System.out.println(exist);
    }

}