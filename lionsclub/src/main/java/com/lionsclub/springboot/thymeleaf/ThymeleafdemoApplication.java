package com.lionsclub.springboot.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
// extends SpringBootServletInitializer 
public class ThymeleafdemoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		
		SpringApplication.run(ThymeleafdemoApplication.class, args);
	}

/*	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ThymeleafdemoApplication.class);
    }*/
}
