package com.zhangrui.activemq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author ZhangRui
 */
@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = "com.zhangrui.activemq")
@MapperScan("com.zhangrui.activemq.*.repository.mapper")
public class ActiveApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiveApiApplication.class, args);
	}
}
