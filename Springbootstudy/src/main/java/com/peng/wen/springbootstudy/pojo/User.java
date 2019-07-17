package com.peng.wen.springbootstudy.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class User {
    private String name;

    private String password;

    private Integer age;

    private Date birthday;

    private String desc;
}
