package com.xuecheng.manage_cms.conﬁg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;

/**
 * @Author: lusiwei
 * @Date: 2019/1/6 21:11
 * @Description:
 */
@Configuration
public class RabbitmqConfig {
    /**交换机的名称*/
    public static final String EX_ROUTING_CMS_POSTPAGE = "ex_routing_cms_post_page";
    @Bean(EX_ROUTING_CMS_POSTPAGE)
    public  Exchange exchange(){
        return ExchangeBuilder.directExchange(EX_ROUTING_CMS_POSTPAGE).durable(true).build();
    }
}
