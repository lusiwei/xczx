package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.Teachplan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: lusiwei
 * @Date: 2019/1/7 22:04
 * @Description:
 */
public interface TeachplanRepository extends JpaRepository<Teachplan,String> {
    public List<Teachplan> findByCourseidAndParentid(String courseId, String parentId);
}
