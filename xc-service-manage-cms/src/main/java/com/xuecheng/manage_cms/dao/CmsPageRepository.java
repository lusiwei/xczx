package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: lusiwei
 * @Date: 2018/12/25 21:26
 * @Description:
 */
public interface CmsPageRepository extends MongoRepository<CmsPage,String> {
    CmsPage findByPageNameAndSiteIdAndPageWebPath(String pageName,String siteId,String pageWebPath);
}
