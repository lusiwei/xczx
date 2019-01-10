package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: lusiwei
 * @Date: 2019/1/7 21:49
 * @Description:
 */
public interface CategoryRepository extends JpaRepository<Category,String> {
}
