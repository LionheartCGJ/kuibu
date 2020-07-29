package com.kuibu.spring.ioc.overview.container;

import com.kuibu.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @ClassName BeanFactoryAsIocContainer
 * <p>
 * BeanFactoryAsIocContainer Description
 * @Date 2020/07/17
 * @Author chenguangjin
 */
public class BeanFactoryAsIocContainer {
    public static void main(String[] args) {
        // 创建默认Bean Factory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        // 配置文件地址
        String location = "classpath:META-INF/dependency-injection-context.xml";

        // 加载配置文件
        int beanDefinitionsNumber = reader.loadBeanDefinitions(location);

        System.out.println(String.format("beanDefinitionsNumber : %s", beanDefinitionsNumber));

        lookupDependency(beanFactory);

    }

    public static void lookupDependency(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);

        System.out.println(String.format("user = %s", user));
    }
}
