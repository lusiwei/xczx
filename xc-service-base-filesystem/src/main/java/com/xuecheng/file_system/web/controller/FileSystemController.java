package com.xuecheng.file_system.web.controller;

import com.xuecheng.api.filesystem.FileSystemControllerApi;
import com.xuecheng.file_system.service.FileSystemService;
import com.xuecheng.framework.domain.filesystem.response.UploadFileResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: lusiwei
 * @Date: 2019/1/9 13:55
 * @Description:
 */
@RestController
@RequestMapping("/filesystem")
public class FileSystemController implements FileSystemControllerApi {
    @Autowired
    FileSystemService fileSystemService;
    @Override
    @RequestMapping("/upload")
    public UploadFileResult upload(@RequestParam(required = true) MultipartFile multipartFile, String fileTag, @RequestParam(required = false) String businesskey, @RequestParam(required = false) String metadata) {
        return fileSystemService.upload(multipartFile, fileTag, businesskey, metadata);
    }
}
