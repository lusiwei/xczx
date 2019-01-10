package com.xuecheng.manage_course.controller;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_course.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lusiwei
 * @Date: 2019/1/8 10:04
 * @Description:
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/list")
    public ResponseResult category_findList(){
        return categoryService.findCategoryList();
    }
}
