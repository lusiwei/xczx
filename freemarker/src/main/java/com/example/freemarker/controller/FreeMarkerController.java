package com.example.freemarker.controller;

import com.xuecheng.framework.model.response.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Objects;


/**
 * @Author: lusiwei
 * @Date: 2018/12/29 10:18
 * @Description:
 */
@Controller
@RequestMapping("freemarker")
public class FreeMarkerController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("test")
    public String test(@ModelAttribute("name") String name) {
        return "hello";
    }
    @RequestMapping("/banner")
    public String index_banner(Map<String,String> map){
        String dataUrl = "http://localhost:31001/cms/config/getmodel/5a791725dd573c3574ee333f";
        ResponseEntity<Map> forEntity = restTemplate.getForEntity(dataUrl, Map.class);
        System.out.println(forEntity);
        Map body = forEntity.getBody();
        System.out.println(body);
        map.putAll(body);
        return "index_banner";
    }
}
