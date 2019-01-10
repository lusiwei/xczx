package com.xuecheng.framework.domain.cms.request;

import com.xuecheng.framework.model.request.RequestData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: lusiwei
 * @Date: 2018/12/25 16:52
 * @Description:
 */
@Data
public class QueryPageRequest extends RequestData {
    @ApiModelProperty("站点id")
    private String siteId;
    @ApiModelProperty("页面id")
    private String pageId;
    @ApiModelProperty("页面名称")
    private String pageName;
    @ApiModelProperty("页面别名")
    private String pageAliases;
    @ApiModelProperty("模版id")
    private String templateId;
}
