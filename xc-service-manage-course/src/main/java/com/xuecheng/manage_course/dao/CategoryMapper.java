package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.ext.CategoryNode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author: lusiwei
 * @Date: 2019/1/8 09:34
 * @Description:
 */
@Mapper
@Component
public interface CategoryMapper {
    CategoryNode selectList();
}
