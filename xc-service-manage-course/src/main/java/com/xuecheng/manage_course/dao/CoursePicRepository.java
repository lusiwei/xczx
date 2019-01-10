package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.CoursePic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: lusiwei
 * @Date: 2019/1/9 16:03
 * @Description:
 */
public interface CoursePicRepository extends JpaRepository<CoursePic,String> {
    Long deleteByCourseid(String courseId);
}
