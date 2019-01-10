package com.xuecheng.manage_course.controller;

import com.xuecheng.api.course.CourserControllerApi;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.CourseMarket;
import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_course.service.CourseMarketService;
import com.xuecheng.manage_course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lusiwei
 * @Date: 2019/1/7 16:02
 * @Description:
 */
@RestController
@RequestMapping("/course")
public class CourseController implements CourserControllerApi {
    @Autowired
    CourseService courseService;
    @Autowired
    CourseMarketService courseMarketService;

    @Override
    @GetMapping("/coursebase/list/{page}/{size}")
    public ResponseResult findCourseList(@PathVariable("page") Integer page, @PathVariable("size") Integer size, CourseListRequest courseListRequest) {
        return courseService.findCourseListPage(page, size, courseListRequest);
    }

    @Override
    @GetMapping("/category/list")
    public ResponseResult categoryFindList() {
        return courseService.categoryFindList();

    }

    @Override
    @PostMapping("/coursebase/add")
    public ResponseResult addCourseBase(@RequestBody CourseBase courseBase) {
        return courseService.addCourseBase(courseBase);
    }
    @Override
    @GetMapping("/coursebase/get/{courseId}")
    public ResponseResult getCourseBaseById(@PathVariable("courseId") String courseId){
        return courseService.getCourseBaseById(courseId);
    }
    @Override
    @PutMapping("/coursebase/update/{courseId}")
    public ResponseResult updateCourseBase(@PathVariable("courseId") String courseId, @RequestBody CourseBase courseBase){
        return courseService.updateCoursebase(courseId, courseBase);
    }

    @Override
    @GetMapping("/teachplan/list/{courseId}")
    public ResponseResult findTeachplanById(@PathVariable("courseId") String courserId) {
        TeachplanNode teachplanList = courseService.findTeachplanList(courserId);
        System.out.println(teachplanList);
        return ResponseResult.SUCCESS(teachplanList);
    }

    @Override
    @PostMapping("/teachplan/add")
    public ResponseResult addTeachplan(@RequestBody Teachplan teachplan) {
        return courseService.addTeachplan(teachplan);
    }
    @Override
    @GetMapping("/coursemarket/get/{courseId}")
    public ResponseResult getCourseMarketById(@PathVariable String courseId){
        CourseMarket courseMarketById = courseMarketService.findCourseMarketById(courseId);
        return ResponseResult.SUCCESS(courseMarketById);
    }
    @Override
    @PutMapping("/coursemarket/update/{courseId}")
    public ResponseResult updateCourseMarket(@PathVariable("courseId") String courseId,@RequestBody CourseMarket courseMarket){
        courseMarketService.updateCourseMarket(courseId,courseMarket);
        return ResponseResult.SUCCESS();
    }

    @Override
    @RequestMapping("/coursepic/add")
    public ResponseResult addCoursePic(String courseId, String pic) {
        return courseService.addCoursePic(courseId, pic);
    }

    @Override
    @GetMapping("/coursepic/list/{courseId}")
    public ResponseResult findCoursePicById(@PathVariable("courseId") String courseId) {
        return courseService.findCoursePicById(courseId);
    }

    @Override
    @DeleteMapping("/coursepic/delete/{courseId}")
    public ResponseResult delCoursePicById(@PathVariable("courseId")String courseId) {
        return courseService.delCourseById(courseId);
    }
}
