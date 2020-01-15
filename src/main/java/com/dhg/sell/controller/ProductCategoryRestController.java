package com.dhg.sell.controller;

import com.dhg.sell.domain.ProductCategory;
import com.dhg.sell.domain.ajax.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
//@RestController
@Controller
@RequestMapping("/rest")
public class ProductCategoryRestController{
    /**
     * 资源/方法/格式
     * 增删改查（顺序）
     */
    @RequestMapping(value = "/productCategory", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    AjaxResponse saveCategory(@RequestBody ProductCategory category) {
        /*沿用c的格式*/
        log.info("saveCategory{}", category);
        return AjaxResponse.success(category);
    }
    /**这个占位符接收@pathVariable*/
    @RequestMapping(value = "/productCategory/{id}",method = RequestMethod.DELETE,produces = "application/json")
    public @ResponseBody
    AjaxResponse removeCategory(@PathVariable Long id) {
        /*沿用c的格式*/
        log.info("removeCategory{}",id);
        return AjaxResponse.success(id);
    }
    @RequestMapping(value = "/productCategory/{id}",method = RequestMethod.PUT,produces = "application/json")
    public @ResponseBody
    AjaxResponse putCategory(@PathVariable Long id, @RequestBody ProductCategory category) {
        category.setCategoryId(id);
        log.info(" putCategory{}", category);
        return AjaxResponse.success(category);
    }
    @RequestMapping(value = "/productCategory/{id}",method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody
    AjaxResponse getCategory(@PathVariable Long id) {
        /*无数据源，此处手动创建返回对象*/
        ProductCategory category=ProductCategory.builder().categoryId(id).categoryName("youngBeach").categoryType(123L).build();
        log.info("removeCategory{}", category);
        return AjaxResponse.success(category);
    }
}
