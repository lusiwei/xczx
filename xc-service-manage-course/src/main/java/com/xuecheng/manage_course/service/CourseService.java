package com.xuecheng.manage_course.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuecheng.framework.domain.course.CourseBase;
import com.xuecheng.framework.domain.course.CoursePic;
import com.xuecheng.framework.domain.course.Teachplan;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.ext.TeachplanNode;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_course.dao.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Author: lusiwei
 * @Date: 2019/1/7 15:33
 * @Description:
 */
@Service
public class CourseService {
    @Autowired
    TeachplanMapper teachplanMapper;
    @Autowired
    CourseBaseRepository courseBaseRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    TeachplanRepository teachplanRepository;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    CoursePicRepository coursePicRepository;

    public TeachplanNode findTeachplanList(String courseId){
        TeachplanNode teachplanNode = teachplanMapper.selectList(courseId);
        return teachplanNode;
    }

    public ResponseResult findCourseListPage(Integer page, Integer size, CourseListRequest courseListRequest) {
        page=page<0?1:page;
        size=size>5||size<0?7:size;
        PageHelper.startPage(page,size);
        List<CourseInfo> courseInfoList= courseMapper.findCourseListPage(courseListRequest);
        PageInfo courseInfoPageInfo = new PageInfo(courseInfoList);
        return ResponseResult.SUCCESS(courseInfoPageInfo);
    }

    @Transactional
    public ResponseResult addCourseBase(CourseBase courseBase) {
        //设置课程状态为未发布
        courseBase.setStatus("202001");
        CourseBase save = courseBaseRepository.save(courseBase);
        return ResponseResult.SUCCESS(save.getId());
    }


    public ResponseResult categoryFindList() {
        return ResponseResult.SUCCESS(categoryRepository.findAll());
    }
    //获取课程根节点，如果没有则添加根节点
    public String getTeachplanRoot(String courseId){
        //校验课程id
        Optional<CourseBase> byId = courseBaseRepository.findById(courseId);
        if (!byId.isPresent()) {
            return null;
        }
        CourseBase courseBase = byId.get();
        //取出课程计划根节点
        List<Teachplan> teachplanList = teachplanRepository.findByCourseidAndParentid(courseId, "0");
        if (teachplanList == null || teachplanList.size() == 0) {
            //新增一个根节点
            Teachplan teachplan = new Teachplan();
            teachplan.setCourseid(courseId);
            teachplan.setPname(courseBase.getName());
            teachplan.setParentid("0");
            teachplan.setGrade("1");
            teachplan.setStatus("0");
            teachplanRepository.save(teachplan);
        }
        Teachplan teachplan = teachplanList.get(0);
        return teachplan.getId();
    }
    //添加课程计划
    @Transactional
    public ResponseResult addTeachplan(Teachplan teachplan){
        //取出课程id
        String courseid = teachplan.getCourseid();
        //校验课程计划和课程id名称
        if (teachplan == null || StringUtils.isEmpty(courseid) || StringUtils.isEmpty(teachplan.getPname())) {
            return ResponseResult.FAIL("参数无效");
        }
        //取出父节点id
        String parentid = teachplan.getParentid();
        if (StringUtils.isEmpty(parentid)) {
            //如果父节点为空则获取根节点
            parentid=getTeachplanRoot(courseid);
        }
        //取出父节点信息
        Optional<Teachplan> byId = teachplanRepository.findById(parentid);
        if (!byId.isPresent()) {
            return ResponseResult.FAIL("参数异常");
        }
        //父节点
        Teachplan teachplanParent = byId.get();
        //父节点级别
        String grade = teachplanParent.getGrade();
        //设置父节点
        teachplan.setParentid(parentid);
        teachplan.setStatus("0");
        //子节点的级别,根据父节点来判断
        if ("1".equals(grade)) {
            teachplan.setGrade("2");
        } else if ("2".equals(grade)) {
            teachplan.setGrade("3");
        }
        //设置课程id
        teachplan.setCourseid(teachplanParent.getCourseid());
        teachplanRepository.save(teachplan);
        return ResponseResult.SUCCESS();
    }

    public ResponseResult getCourseBaseById(String courseId) {
        Optional<CourseBase> byId = courseBaseRepository.findById(courseId);
        if (!byId.isPresent()) {
            return ResponseResult.FAIL();
        }
        CourseBase courseBase = byId.get();
        return ResponseResult.SUCCESS(courseBase);
    }

    @Transactional
    public ResponseResult updateCoursebase(String courseId,CourseBase courseBase){
        //根据课程id查询课程是否存在
        ResponseResult<CourseBase> courseBaseById = getCourseBaseById(courseId);
        CourseBase data = courseBaseById.getData();
        if (data == null) {
            return ResponseResult.FAIL(CommonCode.FAIL);
        }
        data.setName(courseBase.getName());
        data.setDescription(courseBase.getDescription());
        data.setUsers(courseBase.getUsers());
        data.setMt(courseBase.getMt());
        data.setSt(courseBase.getSt());
        data.setGrade(courseBase.getGrade());
        data.setStudymodel(courseBase.getStudymodel());
        data.setTeachmode(courseBase.getTeachmode());
        data.setStatus(courseBase.getStatus());
        data.setCompanyId(courseBase.getCompanyId());
        data.setUserId(courseBase.getUserId());
        courseBaseRepository.save(data);
        return ResponseResult.SUCCESS();
    }

    //添加课程图片
    @Transactional
    public ResponseResult addCoursePic(String courseId, String pic) {
        //查询课程图片
        Optional<CoursePic> optionalCoursePic = coursePicRepository.findById(courseId);
        CoursePic coursePic=null;
        if (optionalCoursePic.isPresent()) {
            coursePic = optionalCoursePic.get();
        }
        //没有课程图片则新建对象
        if (coursePic == null) {
            coursePic=new CoursePic();
        }
        coursePic.setCourseid(courseId);
        coursePic.setPic(pic);
        coursePicRepository.save(coursePic);
        return ResponseResult.SUCCESS();
    }

    public ResponseResult findCoursePicById(String courseId) {
        Optional<CoursePic> optionalCoursePic = coursePicRepository.findById(courseId);
        if (optionalCoursePic.isPresent()) {
            CoursePic coursePic = optionalCoursePic.get();
            return ResponseResult.SUCCESS(coursePic);
        }
        return ResponseResult.FAIL();
    }

    @Transactional
    public ResponseResult delCourseById(String courseId) {
        Long aLong = coursePicRepository.deleteByCourseid(courseId);
        if (aLong > 0) {
            return ResponseResult.SUCCESS();
        }
        return ResponseResult.FAIL();
    }
}
