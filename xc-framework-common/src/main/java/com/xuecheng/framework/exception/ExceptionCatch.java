package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Author: lusiwei
 * @Date: 2019/1/2 21:21
 * @Description:
 */
@ControllerAdvice
public class ExceptionCatch {
    private static final Logger LOGGER= LoggerFactory.getLogger(ExceptionCatch.class);
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseResult customException(CustomException e){
        LOGGER.error("catch exception:{}\r\nexception:",e.getMessage(),e);
        ResultCode resultCode = e.getResultCode();
        return new ResponseResult(resultCode);
    }

}
