package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.system.SysDictionary;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: lusiwei
 * @Date: 2019/1/8 10:45
 * @Description:
 */
public interface SysDictionaryRepository extends MongoRepository<SysDictionary,String> {
    SysDictionary findByDType(String dtype);
}
