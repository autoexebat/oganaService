package com.ogana;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ogana.mybatis")
public class OganaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OganaApplication.class, args);
	}

}
