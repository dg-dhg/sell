package com.dhg.sell.repository;

import com.dhg.sell.domain.ProductCategory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * jdbc测试的类，jdbc分支
 * <p>
 * 三个方法：update 数据将发生变更
 * queryForObject 用于查询单条记录
 * query 查询结果列表返回list
 * @author dhg
 * 2020/01/22
 */
@Repository
public class ProductCategoryRepository{
    /*jdbc模板*/
    @Resource
    private JdbcTemplate jdbcTemplate;
    public void insertCategory(ProductCategory category) {
        jdbcTemplate.update
                ("INSERT into product_category(category_id,category_name,category_type,create_time,update_time) values(?,?,?,?,?)"
                        , category.getCategoryId()
                        , category.getCategoryName()
                        , category.getCategoryType()
                        , category.getCreateTime()
                        , category.getUpdateTime());
    }
    public void deleteCategoryById(Long id) {
        jdbcTemplate.update
                ("delete  from  product_category where category_id=?"
                        , id
                );
    }
    public void updateCategory(ProductCategory category) {
        jdbcTemplate.update(
                "update product_category SET category_type=?,category_name=?,create_time=?,update_time=? where category_id=?"
                , category.getCategoryType()
                , category.getCategoryName()
                , category.getCreateTime()
                , category.getUpdateTime()
                , category.getCategoryId());
    }
    public ProductCategory queryCategoryById(Long id) {
        return jdbcTemplate.queryForObject(
                "select * from product_category where category_id=?"
                , new Object[]{id}
                , new BeanPropertyRowMapper<>(ProductCategory.class));
    }
    public List<ProductCategory> queryAllCategories() {
        return jdbcTemplate.query(
                "select * from product_category"
                , new BeanPropertyRowMapper<>(ProductCategory.class));
    }
}

