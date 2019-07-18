package com.peng.wen.springbootstudy.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
/** 介绍：
 * 用户模型
 * @author liwpb
 */
@Setter
@Getter
@JsonIgnoreProperties("{password,age}")
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
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss a",locale = "zh", timezone = "GMT+8")
    private Date birthday;

    /**
     * 描述
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String desc;
}
