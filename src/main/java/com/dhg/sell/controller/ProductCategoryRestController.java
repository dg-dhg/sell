package com.dhg.sell.controller;

import com.dhg.sell.domain.ProductCategory;
import com.dhg.sell.domain.ajax.AjaxResponse;
import com.dhg.sell.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
//@RestController
@Controller
@RequestMapping("/rest")
public class ProductCategoryRestController{
    /**
     * 资源/方法/格式
     * 增删改查（顺序）
     */
    @Resource(name = "productCategoryServiceImpl")
    private ProductCategoryService service;

    /*@ApiOperation(value = "添加类目", notes = "一次添加一个", tags = "ProductCategory", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code = 200, message = "success", response = ProductCategory.class),
            @ApiResponse(code = 400, message = "badRequest", response = ProductCategory.class),
            @ApiResponse(code = 500, message = "serverError", response = ProductCategory.class)
    })*/
//    @RequestMapping(value = "/productCategory", method = RequestMethod.POST, produces = "application/json")
    @PostMapping("/productCategory")
    public @ResponseBody
    AjaxResponse saveCategory(@RequestBody ProductCategory category) {
        service.insertCategory(category);
        return AjaxResponse.success(category);
    }

    /**
     * 这个占位符接收@pathVariable
     */

//    @RequestMapping(value = "/productCategory/{id}",method = RequestMethod.DELETE,produces = "application/json")
    @DeleteMapping("/productCategory/{id}")
    public @ResponseBody
    AjaxResponse deleteCategory(@PathVariable Long id) {
        service.deleteCategoryById(id);
        return AjaxResponse.success(id);
    }

    //    @RequestMapping(value = "/productCategory/{id}",method = RequestMethod.PUT,produces = "application/json")
    @PutMapping("/productCategory/{id}")
    public @ResponseBody
    AjaxResponse putCategory(@PathVariable Long id, @RequestBody ProductCategory category) {
        category.setCategoryId(id);
        service.updateCategory(category);
        return AjaxResponse.success(category);
    }

    //    @RequestMapping(value = "/productCategory/{id}",method = RequestMethod.GET,produces = "application/json")
    @GetMapping("/productCategory/{id}")
    public @ResponseBody
    AjaxResponse getCategory(@PathVariable Long id) {
        ProductCategory category = service.queryCategoryById(id);
        return AjaxResponse.success(category);
    }

    @GetMapping("/productCategory/all")
    public  @ResponseBody
    AjaxResponse getCategories() {
        List<ProductCategory> categories= service.queryAllCategories();
        return AjaxResponse.success(categories);
    }
}
