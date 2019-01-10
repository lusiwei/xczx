package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author: lusiwei
 * @Date: 2019/1/7 11:09
 * @Description:
 */
@Mapper
@Component
public interface TeachplanMapper {
    TeachplanNode selectList(String courseId);
}
