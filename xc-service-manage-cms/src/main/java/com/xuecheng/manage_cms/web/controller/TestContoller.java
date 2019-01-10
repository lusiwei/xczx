package com.xuecheng.manage_cms.web.controller;

import com.xuecheng.framework.domain.cms.request.TestDto;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author: lusiwei
 * @Date: 2018/12/28 10:37
 * @Description:
 */
@RestController
public class TestContoller {
    @RequestMapping("save")
    public String save(@Valid TestDto testDto, BindingResult result) {
        System.out.println("1111111111111");
        System.out.println(testDto);
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError allError : allErrors) {
                System.out.println(allError.getDefaultMessage());
            }
            return "error";
        }
        return "success";
    }
}
