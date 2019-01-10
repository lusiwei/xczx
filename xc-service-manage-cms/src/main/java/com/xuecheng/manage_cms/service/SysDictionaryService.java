package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.system.SysDictionary;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.manage_cms.dao.SysDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: lusiwei
 * @Date: 2019/1/8 10:40
 * @Description:
 */
@Service
public class SysDictionaryService {
    @Autowired
    SysDictionaryRepository sysDictionaryRepository;
    public ResponseResult findByDtype(String dtype){
        SysDictionary sysDictionary = sysDictionaryRepository.findByDType(dtype);
        return ResponseResult.SUCCESS(sysDictionary);
    }
}
