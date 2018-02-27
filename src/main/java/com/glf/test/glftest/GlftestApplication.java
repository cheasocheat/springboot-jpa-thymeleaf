package com.glf.test.glftest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaAuditing
public class GlftestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlftestApplication.class, args);
	}
}
