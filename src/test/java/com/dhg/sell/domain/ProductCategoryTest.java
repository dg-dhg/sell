package com.dhg.sell.domain;

import com.dhg.sell.service.impl.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
//将模拟真实情况下的servlet
/*添加容器*/
@RunWith(SpringRunner.class)
/*自动配置mock*/
@AutoConfigureMockMvc
@SpringBootTest
public class ProductCategoryTest{
    @Resource
    private ProductCategoryService service;

    @Resource
    private MockMvc mockMvc;

    //    @Before
//    public void init(){
//        /*需要加载controller*/
//        mockMvc= MockMvcBuilders.standaloneSetup(new ProductCategoryRestController()).build();
//    }
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
        /*验证controller（接口）*/
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/productCategory")
                .contentType("application/json").content(productCategory))
                .andExpect(MockMvcResultMatchers.status().isOk())
                /*从data中获取field的值*/
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value("MockTest"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.type").value(3))
                .andDo(print())
                .andReturn();
        log.info(result.getResponse().getContentAsString());
        service.saveCategory(productCategory);
    }
    @Test
    public void saveCategory(){
       log.info("s e r v i c e 的 地 址 。 。 。"+service.toString());
    }
}