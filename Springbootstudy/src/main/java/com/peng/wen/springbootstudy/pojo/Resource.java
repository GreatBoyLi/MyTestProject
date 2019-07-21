package com.peng.wen.springbootstudy.pojo;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Resource类，用来接收resource.properties文件的属性
 * @author liwpb
 */
@Configuration //代表会引用资源文件的配置
@ConfigurationProperties(prefix="com.peng.wen.opensource")  //设置属性前缀
@PropertySource(value = "classpath:resource.properties")  //指定资源文件的地址
@Getter
@Setter
public class Resource {
    /**
     * 姓名
     */
    private String name;

    /**
     * 网址
     */
    private String website;

    /**
     * 语言
     */
    private String language;
}
