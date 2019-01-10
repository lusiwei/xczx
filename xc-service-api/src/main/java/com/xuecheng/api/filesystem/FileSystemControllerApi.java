package com.xuecheng.api.filesystem;

import com.xuecheng.framework.domain.filesystem.response.UploadFileResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: lusiwei
 * @Date: 2019/1/9 11:30
 * @Description:
 */
public interface FileSystemControllerApi {
    @ApiOperation("上传文件")
    UploadFileResult upload(MultipartFile multipartFile, String fileTag, String businesskey, String metadata);
}
