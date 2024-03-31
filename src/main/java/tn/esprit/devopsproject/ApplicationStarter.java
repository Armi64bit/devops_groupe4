package tn.esprit.devopsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStarter {

    public void startApplication(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DevOpsProjectSpringBootApplication.class, args);
        // You can perform additional operations with the context if needed
    }
}
