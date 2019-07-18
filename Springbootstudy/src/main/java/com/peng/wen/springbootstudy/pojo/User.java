package com.peng.wen.springbootstudy.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
/**
 * 用户模型
 *@author liwpb
 */
public class User {
    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 描述
     */
    private String desc;
}
