import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_cms.ManageCmsApplication;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Author: lusiwei
 * @Date: 2018/12/27 14:40
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManageCmsApplication.class)
public class TestFindAll {
    @Autowired
    private CmsPageRepository cmsPageRepository;
    @Test
    public void testFinalAll(){
        //条件匹配器
        ExampleMatcher exampleMatcher=ExampleMatcher.matching();
        exampleMatcher.withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        //条件值
        CmsPage cmsPage=new CmsPage();
        //设置站点id
        cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");
        //模版id
        cmsPage.setTemplateId("5a962b52b00ffc514038faf7");
        //创建条件实例
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        Pageable pageable = PageRequest.of(0, 10);
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        System.out.println("===========================================");
        System.out.println(all.getTotalElements());
    }
}
