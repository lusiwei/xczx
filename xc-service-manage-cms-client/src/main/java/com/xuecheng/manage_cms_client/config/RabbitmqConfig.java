package com.xuecheng.manage_cms_client.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: lusiwei
 * @Date: 2019/1/6 15:34
 * @Description: Rabbitmq 配置类
 */
@Configuration
public class RabbitmqConfig {
    /**
     * 队列bean的名称
     */
    private static final String QUEUE_CMS_POSTPAGE = "queue_cms_post_page";
    /**
     * 交换机的名称
     */
    private static final String EX_ROUTING_CMS_POSTPAGE = "ex_routing_cms_post_page";
    @Value("${xuecheng.mq.queue}")
    public String queueCmsPostPageName;
    @Value("${xuecheng.mq.routingKey}")
    public String routingKey;

    /**
     * 交换机配置使用direct类型
     */
    @Bean(EX_ROUTING_CMS_POSTPAGE)
    public Exchange exchange(){
        return ExchangeBuilder.directExchange(EX_ROUTING_CMS_POSTPAGE).durable(true).build();
    }
    /**
     * 声明队列
     */
    @Bean(QUEUE_CMS_POSTPAGE)
    public Queue queue(){
        return new Queue(queueCmsPostPageName);
    }

    /**
     * 绑定队列到交换机
     */
    @Bean
    public Binding binding(@Qualifier(QUEUE_CMS_POSTPAGE) Queue queue, @Qualifier(EX_ROUTING_CMS_POSTPAGE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey).noargs();
    }
}
