package com.kuibu.spring.ioc.overview.injection;

import com.kuibu.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.lang.Nullable;

/**
 * @ClassName DependencyInjectionDemo
 * <p>
 * DependencyInjectionDemo Description
 * @Date 2020/07/17
 * @Author chenguangjin
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        // BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");
        //injectionByType(beanFactory);

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-injection-context.xml");

        // 依赖来源一 ： 自定义bean
        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        // 依来来源二 ： 內建依赖（非bean）
        System.out.println(String.format("非bean (內建依赖) : %s", userRepository.getBeanFactory()));
        // 依赖来源三 ： 容器內建bean
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println(String.format("容器內建bean Environment : %s", environment));




        System.out.println(userRepository.getObjectFactory().getObject() == applicationContext);

        // beanFactory.getBean(BeanFactory.class) // 抛出异常
        // BeanFactory无法通过依赖查找找到，但是依赖注入的时候却可以注入到一个bean中， 为什么？
        // ioc的依赖注入的依赖来源包括 自定义bean、 容器內建的bean、內建依赖（非bean，不能通过依赖查找找到）

    }

    private static void whoIsIoCContainer(UserRepository userRepository, ApplicationContext applicationContext) {


        // ClassPathXmlApplicationContext <- AbstractRefreshableApplicationContext <- ConfigurableApplicationContext <- ApplicationContext <- BeanFactory

        // ConfigurableApplicationContext#getBeanFactory()

        // AbstractRefreshableApplicationContext
        // private DefaultListableBeanFactory beanFactory

        // ClassPathXmlApplicationContext 是 BeanFactory的子类， 但是BeanFactory 是在AbstractRefreshableApplicationContext类
        // 中通过组合的方式将DefaultListableBeanFactory作为一个属性的，


        // 这个表达式为什么不会成立
        System.out.println(userRepository.getBeanFactory() == applicationContext);

        // ApplicationContext is BeanFactory

    }


    public static void injectionByType (BeanFactory beanFactory) {
        UserRepository userRepository = beanFactory.getBean(UserRepository.class);

        System.out.println(String.format("injectionByType : %s", userRepository));
    }
}
