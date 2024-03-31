package tn.esprit.devopsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStarter {

    public ConfigurableApplicationContext startApplication(String[] args) {
        return SpringApplication.run(DevOpsProjectSpringBootApplication.class, args);
    }
}
