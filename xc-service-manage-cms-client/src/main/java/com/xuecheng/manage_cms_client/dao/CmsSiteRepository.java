package com.xuecheng.manage_cms_client.dao;

import com.xuecheng.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: lusiwei
 * @Date: 2019/1/6 15:53
 * @Description:
 */
public interface CmsSiteRepository extends MongoRepository<CmsSite,String> {
}
