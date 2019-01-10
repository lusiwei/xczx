package com.example.freemarker;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FreemarkerApplicationTests {

    @Autowired
    GridFsTemplate gridFsTemplate;


    @Test
    public void testGridFs() throws IOException {
        File file = new File("H:\\xuechengzaixian\\service\\freemarker\\src\\main\\resources\\templates\\index_banner.ftl");
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectId objectId = gridFsTemplate.store(fileInputStream, "存储的模版文件banner", "");
        String s = objectId.toString();
        System.out.println(s);
    }

}

