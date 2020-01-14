package com.dhg.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class SellApplicationTests{
    /**搞那么多主要还是配置文件的问题*/
    @Test
    void contextLoads() {
        log.info("info...");
        log.debug("debug...");
        log.error("error...");
    }

}
