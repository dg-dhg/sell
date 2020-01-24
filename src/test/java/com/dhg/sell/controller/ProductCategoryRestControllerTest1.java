package com.dhg.sell.controller;

import com.dhg.sell.domain.ProductCategory;
import com.dhg.sell.service.ProductCategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
/*限定某一个controller*/
//@WebMvcTest(ProductCategoryRestController.class)
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class ProductCategoryRestControllerTest1{
    @Resource
    MockMvc mockMvc;

    /*模拟service
     *
     * 打桩概念：当调用service方法的时候返回模拟的Service对象的方法的结果
     * */
    @MockBean(name = "productCategoryServiceImpl")
    ProductCategoryService service;

    @Test
    public void start() throws Exception {
        /*准备数据,请求的数据应该遵从别名*/
        String productCategory = "{\n" +
                "\"id\":13," +
                "\"name\":\"MockTest\"," +
                "\"type\":1," +
                "\"createTime\":\"1998-02-17 19:21:06\"," +
                "\"updateTime\":\"1998-02-17 19:22:06\"" +
                "\n}";
//        ObjectMapper mapper=new ObjectMapper();
//        ProductCategory categoryObj=mapper.readValue(productCategory,ProductCategory.class);
//        service.insertCategory(categoryObj);

        /*打桩：测试术语，桩驱动,模拟返回的数据,已经有service就不用再模拟了*/
//        when(service.insertCategory(categoryObj)).thenReturn();

        /*验证controller（接口）,在此controller以变更，将调用*/
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/productCategory")
                .contentType("application/json").content(productCategory))
                .andExpect(MockMvcResultMatchers.status().isOk())
                /*从data中获取field的值*/
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value("MockTest"))
                .andDo(print())
                .andReturn();
        String s = result.getResponse().getContentAsString();
        log.info("content：  " + s);
    }
}