package com.baby.babycareproductsshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@ConfigurationPropertiesScan
public class BabyCareProductsShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BabyCareProductsShopApplication.class, args);
    }

}
