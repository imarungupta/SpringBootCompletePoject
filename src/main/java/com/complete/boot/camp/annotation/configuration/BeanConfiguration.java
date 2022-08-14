package com.complete.boot.camp.annotation.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan(basePackages = "demo.annotation.based.configuration")
public class BeanConfiguration {
    @Bean
    public Nurse nurse(){
        return new Nurse();
    }

}
