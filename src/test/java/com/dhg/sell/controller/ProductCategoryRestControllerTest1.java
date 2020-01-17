package com.dhg.sell.controller;

import com.dhg.sell.domain.ProductCategory;
import com.dhg.sell.service.impl.ProductCategoryRestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
/*限定某一个controller*/
@WebMvcTest(ProductCategoryRestController.class)
@Slf4j
@AutoConfigureMockMvc
public class ProductCategoryRestControllerTest1{
    @Resource
    MockMvc mockMvc;

    /*模拟service
    *
    * 打桩概念：当调用service方法的时候返回模拟的Service对象的方法的结果
    * */
    @MockBean
    ProductCategoryRestService service;



    @Test
    public void start() throws Exception {
        /*准备数据,请求的数据应该遵从别名*/
        String productCategory = "{\n" +
                "\"id\":1," +
                "\"name\":\"MockTest\"," +
                "\"type\":3," +
                "\"createTime\":\"1998-02-17 19:23:06\"," +
                "\"updateTime\":\"1998-02-17 19:23:06\"" +
                "\n}";


        ObjectMapper mapper=new ObjectMapper();
        ProductCategory categoryObj=mapper.readValue(productCategory,ProductCategory.class);

        /*打桩：测试术语，桩驱动,模拟返回的数据*/
        when(service.saveCategory(categoryObj)).thenReturn("Ok");

        /*验证controller（接口）,在此controller以变更，将调用*/
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/productCategory")
                .contentType("application/json").content(productCategory))
                .andExpect(MockMvcResultMatchers.status().isOk())
                /*从data中获取field的值*/
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value("MockTest"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.type").value(3))
                .andDo(print())
                .andReturn();
        log.info(result.getResponse().getContentAsString());

    }

    @Test
    public void saveCategory() {
        log.info("s e r v i c e 的 地 址 。 。 。" + service.toString());
    }
}