package com.xuecheng.manage_course.service;

import com.xuecheng.framework.domain.course.CourseMarket;
import com.xuecheng.manage_course.dao.CourseMarketRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: lusiwei
 * @Date: 2019/1/8 14:49
 * @Description:
 */
@Service
public class CourseMarketService {
    @Autowired
    CourseMarketRepository courseMarketRepository;
    //根据课程id查询课程营销信息
    public CourseMarket findCourseMarketById(String courseId){
        Optional<CourseMarket> optionalCourseMarket = courseMarketRepository.findById(courseId);
        if (!optionalCourseMarket.isPresent()) {
            return null;
        }
        CourseMarket courseMarket = optionalCourseMarket.get();
        return courseMarket;
    }

    public void updateCourseMarket(String courseId,CourseMarket courseMarket) {
        //
        CourseMarket courseMarketById = findCourseMarketById(courseId);
        //如果为空，则为增加,不为空就修改
        if (courseMarketById == null) {
            courseMarketById = new CourseMarket();
            BeanUtils.copyProperties(courseMarket, courseMarketById);
            courseMarketRepository.save(courseMarketById);
        }else {
            courseMarketById.setCharge(courseMarket.getCharge());
            courseMarketById.setEndTime(courseMarket.getEndTime());
            //设置旧价格为原来的价格
            courseMarketById.setPrice_old(courseMarketById.getPrice());
            courseMarketById.setPrice(courseMarket.getPrice());
            courseMarketById.setQq(courseMarket.getQq());
            courseMarketById.setStartTime(courseMarket.getStartTime());
            courseMarketById.setValid(courseMarket.getValid());
            courseMarketRepository.save(courseMarketById);
        }
    }
}
