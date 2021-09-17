package org.hillcresthighschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.hillcresthighschool")

public class IBApplication {
    public static void main(String[] args) {
        SpringApplication.run(IBApplication.class, args);
    }
}
