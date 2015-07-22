package com.fsnip.platform.module.console.entity;

import com.fsnip.platform.core.BaseEntity;

/**
 * Created by HY on 2015/7/21.
 * desc:
 */
public class TestVO extends BaseEntity {


    private static final long serialVersionUID = -55705001557511914L;

    private int id;
    private String name;
    private Integer age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
