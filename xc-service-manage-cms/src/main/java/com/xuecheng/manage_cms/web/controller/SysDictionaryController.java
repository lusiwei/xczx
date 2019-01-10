package com.xuecheng.manage_cms.web.controller;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.service.SysDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lusiwei
 * @Date: 2019/1/8 10:54
 * @Description:
 */
@RestController
@RequestMapping("/sys/dictionary")
public class SysDictionaryController {
    @Autowired
    SysDictionaryService sysDictionaryService;
    @RequestMapping("/get/{dtype}")
    public ResponseResult getByDtype(@PathVariable("dtype") String dtype) {
        return sysDictionaryService.findByDtype(dtype);
    }
}
