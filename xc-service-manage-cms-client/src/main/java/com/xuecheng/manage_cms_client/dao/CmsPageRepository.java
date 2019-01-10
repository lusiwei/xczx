package com.xuecheng.manage_cms_client.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: lusiwei
 * @Date: 2019/1/6 15:51
 * @Description:
 */
public interface CmsPageRepository extends MongoRepository<CmsPage,String> {
}
