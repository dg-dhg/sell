package com.dhg.sell.domain;

import com.dhg.sell.controller.ProductCategoryRestController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@SpringBootTest
public class ProductCategoryTest{
    private MockMvc mockMvc;
    @Before
    public void init(){
        /*需要加载controller*/
        mockMvc= MockMvcBuilders.standaloneSetup(new ProductCategoryRestController()).build();
    }
    @Test
    public void start() throws Exception{
        /*准备数据,请求的数据应该遵从别名*/
        String productCategory="{\n" +
                "\"id\":1,"+
                "\"name\":\"MockTest\","+
                "\"type\":3,"+
                "\"createTime\":\"1998-02-17 19:23:06\","+
                "\"updateTime\":\"1998-02-17 19:23:06\"" +
                "\n}";
        /*验证controller（接口）*/
        MvcResult result=mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST,"/rest/productCategory")
                .contentType("application/json").content(productCategory))
                .andExpect(MockMvcResultMatchers.status().isOk())
                /*从data中获取field的值*/
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value("MockTest"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.type").value(3))
                .andDo(print())
                .andReturn();
        log.info(result.getResponse().getContentAsString());
    }
}