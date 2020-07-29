package com.kuibu.spring.ioc.overview.lookup;

import com.kuibu.spring.ioc.overview.annotation.Super;
import com.kuibu.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @ClassName DependencyLookupDemo
 * <p>
 * DependencyLookupDemo Description
 * @Date 2020/07/16
 * @Author chenguangjin
 */
public class DependencyLookupDemo {
    public static void main(String[] args) {
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-lookup-context.xml");
        // 实时查找
        lookupInRealTime(beanFactory);
        // 延迟查找
        lookupInLazy(beanFactory);
        // 按照类型查找
        lookupByType(beanFactory);
        // 按照类型查找结合对象
        lookupCollectionByType(beanFactory);
        // 通过注解查找对象
         lookupByAnnotationType(beanFactory);
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            Map<String, User> users = (Map) ((ListableBeanFactory) beanFactory).getBeansWithAnnotation(Super.class);

            System.out.println(String.format("lookupCollectionByType : %s", users));
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            Map<String, User> users = ((ListableBeanFactory) beanFactory).getBeansOfType(User.class);

            System.out.println(String.format("lookupCollectionByType : %s", users));
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);

        System.out.println(String.format("lookupByType : %s", user));
    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();

        System.out.println(String.format("lookupInLazy : %s", user));
    }

    private static void lookupInRealTime (BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");

        System.out.println(String.format("lookupInRealTime : %s", user));
    }

}
