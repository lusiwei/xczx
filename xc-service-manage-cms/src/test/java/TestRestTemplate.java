import com.xuecheng.manage_cms.ManageCmsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.util.Map;

/**
 * @Author: lusiwei
 * @Date: 2019/1/2 10:05
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManageCmsApplication.class)
public class TestRestTemplate {
    @Autowired
    private RestTemplate restTemplate;
    @Test
    public void testRestTemplate(){
        ResponseEntity<Map> forEntity = restTemplate.getForEntity("http://localhost:31001/cms/config/getmodel/5a791725dd573c3574ee333f", Map.class);
        System.out.println(forEntity);
    }
}
