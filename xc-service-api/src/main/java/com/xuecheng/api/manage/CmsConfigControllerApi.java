package com.xuecheng.api.manage;

import com.xuecheng.framework.domain.cms.CmsConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Author: lusiwei
 * @Date: 2019/1/2 09:40
 * @Description:
 */
@Api(value = "cms配置管理接口",description = "cms配置管理接口，提供数据模型的管理，查询接口")
public interface CmsConfigControllerApi {

    @ApiOperation(value = "根据id查询cms配置信息")
    public CmsConfig getModel(String id);
}
