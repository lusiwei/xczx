package com.xuecheng.api.manage;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.domain.cms.response.CmsPageResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lusiwei
 * @Date: 2018/12/25 16:56
 * @Description:
 */
@Api(value = "cms页面管理接口", description = "cms页面管理接口，提供页面的增删改查")
public interface CmsPageControllerApi {
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams(
            {
                @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int"),
                @ApiImplicitParam(name = "size", value = "每页记录", required = true, paramType = "path", dataType = "int")
            })
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);

    @ApiOperation("添加页面")
    public CmsPageResult add(CmsPage cmsPage);

    @ApiOperation("根据id查找")
    ResponseResult findById(@PathVariable("id") String id);

    @ApiOperation("修改")
    CmsPageResult edit(@PathVariable("id") String id, @RequestBody CmsPage cmsPage);

    @ApiOperation("删除")
    ResponseResult delete(@PathVariable("id") String id);

    @ApiOperation("发布页面")
    public ResponseResult post(String pageId);


}
