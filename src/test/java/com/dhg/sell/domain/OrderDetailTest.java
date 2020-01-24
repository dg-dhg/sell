package com.dhg.sell.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailTest{

    @Test
    public void build() {
        OrderDetail detail = OrderDetail.builder().detailId("123").productName("helloWorld").build();
        System.out.println(detail);

    }

    @Test
    public void convertToStamp() {
        /*timestamp,日期类的子类*/
        Date date = new Date();
        long convert = date.getTime();
        java.sql.Timestamp timestamp = new Timestamp(convert);
        log.error("以下是输出结果");
        System.out.println(timestamp);

    }

}