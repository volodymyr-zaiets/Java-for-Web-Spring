package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:application.properties")
public class Config {

    @Bean
    public Water water(){
        System.out.println("Called creating of bean \'water\'");
        return new Water();
    }

    @Bean
    public Vine vine(){
        System.out.println("Called creating of bean \'vine\'");
        return new Vine();
    }

    @Bean
    @Scope("prototype")
    public Tumbler tumbler(){
        System.out.println("Called creating of bean \'tumbler\'");
        return new Tumbler(water());
    }

    @Bean
    @Scope("singleton")
    public Person person(){
        System.out.println("Called creating of bean \'person\'");
        return new Person(tumbler());
    }
}
