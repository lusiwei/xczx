package com.xuecheng.manage_course.service;

import com.xuecheng.framework.domain.course.ext.CategoryNode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_course.dao.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lusiwei
 * @Date: 2019/1/8 09:35
 * @Description:
 */
@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    public ResponseResult findCategoryList(){
        CategoryNode categoryNode = categoryMapper.selectList();
        return ResponseResult.SUCCESS(categoryNode);
    }
}
