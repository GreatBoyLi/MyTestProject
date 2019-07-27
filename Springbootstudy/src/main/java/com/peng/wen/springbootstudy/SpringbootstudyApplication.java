package com.peng.wen.springbootstudy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.peng.wen.springbootstudy.mapper")
@SpringBootApplication
public class SpringbootstudyApplication {

	/**
	 * 应用启动
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringbootstudyApplication.class, args);
	}

}
