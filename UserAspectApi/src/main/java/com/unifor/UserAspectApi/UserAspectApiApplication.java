package com.unifor.UserAspectApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class UserAspectApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAspectApiApplication.class, args);
	}

}
