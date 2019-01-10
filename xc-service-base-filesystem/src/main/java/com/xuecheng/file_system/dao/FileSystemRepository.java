package com.xuecheng.file_system.dao;

import com.xuecheng.framework.domain.filesystem.FileSystem;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: lusiwei
 * @Date: 2019/1/9 13:06
 * @Description:
 */
public interface FileSystemRepository extends MongoRepository<FileSystem, String> {
}
