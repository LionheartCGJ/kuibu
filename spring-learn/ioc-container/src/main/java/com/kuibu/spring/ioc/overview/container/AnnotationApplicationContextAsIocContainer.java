package com.kuibu.spring.ioc.overview.container;

import com.kuibu.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @ClassName AnnotationApplicationContextAsIocContainer
 * <p>
 * AnnotationApplicationContextAsIocContainer Description
 * @Date 2020/07/17
 * @Author chenguangjin
 */
@Configuration
public class AnnotationApplicationContextAsIocContainer {
    public static void main(String[] args) {
        // 创建applicationContext
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 接入配置类
        applicationContext.register(AnnotationApplicationContextAsIocContainer.class);
        // 启动applicationContext
        applicationContext.refresh();
        // 使用applicationContext
        lookupDependency(applicationContext);
        // 关闭applicationContext
        applicationContext.close();


    }

    @Bean
    public User user() {
        User user = new User();

        user.setId(12L);
        user.setName("kuibu");

        return user;
    }


    public static void lookupDependency(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory  = (ListableBeanFactory)beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);

            System.out.println(String.format("user : %s", users));
        }

    }
}
