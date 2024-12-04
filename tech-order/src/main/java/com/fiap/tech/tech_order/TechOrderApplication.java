package com.fiap.tech.tech_order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.fiap.tech.tech_order.repository.jpa"})
public class TechOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechOrderApplication.class, args);
    }

}
