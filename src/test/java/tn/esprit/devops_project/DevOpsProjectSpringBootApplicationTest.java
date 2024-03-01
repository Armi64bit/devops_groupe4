package tn.esprit.devops_project;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DevOpsProjectSpringBootApplicationTest {

    @Test
    void main() {
        // Run the main method and capture the application context
        ConfigurableApplicationContext context = SpringApplication.run(DevOpsProjectSpringBootApplication.class);

        // Assert that the application context is not null
        assertNotNull(context);

        // Close the application context after the test
        context.close();
    }
}
