package com.xuecheng.api.course;

import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.CourseMarket;
import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: lusiwei
 * @Date: 2019/1/7 10:59
 * @Description:
 */
public interface CourserControllerApi {
    @ApiOperation("查询所有课程列表")
    ResponseResult findCourseList(@PathVariable("page") Integer page, @PathVariable("size") Integer size, CourseListRequest courseListRequest);

    @ApiOperation("查询课程分类")
    ResponseResult categoryFindList();

    @ApiOperation("添加课程")
    ResponseResult addCourseBase(CourseBase courseBase);
    @ApiOperation("根据课程id查询课程信息")
    ResponseResult getCourseBaseById(String courseId);

    @ApiOperation("修改课程信息")
    ResponseResult updateCourseBase(String courseId, CourseBase courseBase);

    @ApiOperation("课程计划查询")
    public ResponseResult findTeachplanById(String courserId);
    @ApiOperation(("添加课程计划"))
    ResponseResult addTeachplan(Teachplan teachplan);

    @ApiOperation(" 根据课程id查询课程营销信息")
    ResponseResult getCourseMarketById(String courseId);

    @ApiOperation("修改课程营销信息")
    ResponseResult updateCourseMarket(String courseId,CourseMarket courseMarket);

    @ApiOperation("添加课程图片")
    ResponseResult addCoursePic(String courseId,String pic);

    @ApiOperation("查询课程图片")
    ResponseResult findCoursePicById(String courseId);

    @ApiOperation("删除课程图片")
    ResponseResult delCoursePicById(String courseId);
}
