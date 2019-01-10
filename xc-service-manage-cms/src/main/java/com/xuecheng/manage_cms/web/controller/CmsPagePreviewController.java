package com.xuecheng.manage_cms.web.controller;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.web.BaseController;
import com.xuecheng.manage_cms.service.CmsPageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * @Author: lusiwei
 * @Date: 2019/1/2 22:34
 * @Description:
 */
@Controller
public class CmsPagePreviewController extends BaseController {
    @Autowired
    private CmsPageService cmsPageService;
    //接受页面id
    @GetMapping("/cms/preview/{pageId}")
    public void  preview(@PathVariable("pageId") String pageId){
        String pageHtml = cmsPageService.getPageHtml(pageId);
        System.out.println("------");
        System.out.println(pageHtml);
        if (StringUtils.isNotEmpty(pageHtml)) {
            try {
                response.getOutputStream().write(pageHtml.getBytes("utf-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
