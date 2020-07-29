package com.kuibu.spring.ioc.overview.domain;

/**
 * @ClassName User
 * <p>
 * User Description
 * @Date 2020/07/16
 * @Author chenguangjin
 */
public class User {
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
