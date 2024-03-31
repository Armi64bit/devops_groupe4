package tn.esprit.devopsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DevOpsProjectSpringBootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DevOpsProjectSpringBootApplication.class, args);
        // You can perform additional operations with the context if needed
    }

    // Method to start the Spring Boot application
    public static ConfigurableApplicationContext startApplication(String[] args) {
        return SpringApplication.run(DevOpsProjectSpringBootApplication.class, args);
    }
}
