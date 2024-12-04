package com.fiap.tech.tech_product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.fiap.tech.tech_product.repository.jpa"})
public class TechProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechProductApplication.class, args);
    }

}
