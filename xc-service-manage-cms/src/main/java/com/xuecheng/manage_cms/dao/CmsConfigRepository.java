package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: lusiwei
 * @Date: 2019/1/2 09:44
 * @Description:
 */
public interface CmsConfigRepository extends MongoRepository<CmsConfig,String> {
}
