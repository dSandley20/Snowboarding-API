package com.dsandley;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SnowboardApiApplication {

    /**
     * starts the main application.
     * @param args
     */
    public static void main(final String[] args) {
        SpringApplication.run(SnowboardApiApplication.class, args);
    }

//    /**
//     * Console logs all of the beans that are loaded -- only use for debugging purposes
//     * @param ctx
//     * @return returns all of the beans loaded
//     */
//    @Bean
//    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println(
//                    "Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//        };
//    }
}
