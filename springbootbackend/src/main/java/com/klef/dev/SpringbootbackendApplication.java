package com.klef.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootbackendApplication extends SpringBootServletInitializer 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(SpringbootbackendApplication.class, args);
        System.out.println("Project Backend is Running Successfully ....");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // This is needed for WAR deployment
        return builder.sources(SpringbootbackendApplication.class);
    }
}
