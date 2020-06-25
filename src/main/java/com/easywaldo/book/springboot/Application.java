package com.easywaldo.book.springboot;

import com.easywaldo.book.springboot.domain.test.HelloWorldConfiguration;
import com.easywaldo.book.springboot.domain.test.HelloWorldMessageProvider;
import com.easywaldo.book.springboot.domain.test.MessageRenderer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@EnableCaching
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }



}
