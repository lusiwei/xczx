package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: lusiwei
 * @Date: 2019/1/2 21:48
 * @Description:
 */
public interface CmsTemplateRepository extends MongoRepository<CmsTemplate,String> {
}
