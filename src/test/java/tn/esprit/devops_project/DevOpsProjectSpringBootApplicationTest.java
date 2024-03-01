package tn.esprit.devops_project;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class DevOpsProjectSpringBootApplicationTest {

    @Test
    public void applicationContextLoads() {
        // Mock the SpringApplication.run() method
        ConfigurableApplicationContext context = mock(ConfigurableApplicationContext.class);
        Mockito.when(SpringApplication.run(DevOpsProjectSpringBootApplication.class)).thenReturn(context);

        // Run the main method


        // Assert that the application context is not null
        assertNotNull(DevOpsProjectSpringBootApplication.main(new String[]{}););

        // Verify that SpringApplication.run() was called with the correct arguments
        Object SpringApplication;
        verify(SpringApplication, times(1)).run(DevOpsProjectSpringBootApplication.class);
    }
}
