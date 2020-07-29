package com.kuibu.spring.ioc.overview.domain;

import com.kuibu.spring.ioc.overview.annotation.Super;

/**
 * @ClassName SuperUser
 * <p>
 * SuperUser Description
 * @Date 2020/07/16
 * @Author chenguangjin
 */
@Super
public class SuperUser extends User{
    private String address;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
