package com.xuecheng.framework.model.response;

import com.xuecheng.framework.exception.CustomException;

/**
 * @Author: lusiwei
 * @Date: 2019/1/2 21:19
 * @Description: 异常抛出类
 */
public class ExceptionCast {
    public static void cast(ResultCode resultCode) {
        throw new CustomException(resultCode);
    }
}
