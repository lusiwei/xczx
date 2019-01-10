package com.xuecheng.framework.domain.cms.request;

import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: lusiwei
 * @Date: 2018/12/28 10:35
 * @Description:
 */
@Setter
public class TestDto implements Serializable {
    @NotNull(message = "id不能为空")
    private Integer id;
    @NotBlank(message = "名字不能为空")
    private String name;
    @NotNull(message = "age不能为空")
    private Integer age;
}
