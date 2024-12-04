package br.com.postech.tech_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"br.com.postech.tech_client.repository.jpa"})
public class TechClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechClientApplication.class, args);
    }

}
