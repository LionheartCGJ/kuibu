package com.kuibu.spring.ioc.overview.repository;

import com.kuibu.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName UserRepository
 * <p>
 * UserRepository Description
 * @Date 2020/07/17
 * @Author chenguangjin
 */
public class UserRepository {

    private Collection<User> userRepository;

    private BeanFactory beanFactory;

    private ObjectFactory<ApplicationContext> objectFactory;


    public Collection<User> getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(Collection<User> userRepository) {
        this.userRepository = userRepository;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    // 此处如果把泛型去掉注入的就是不同的类
    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "userRepository=" + userRepository +
                ", beanFactory=" + beanFactory +
                ", objectFactory=" + objectFactory +
                '}';
    }
}
