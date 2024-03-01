package tn.esprit.devops_project;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DevOpsProjectSpringBootApplicationTest {

    @Test
    void main() {
        // Mock the SpringApplication class
        SpringApplication springApplicationMock = mock(SpringApplication.class);

        // Mock the SpringApplication.run() method to return a mock ConfigurableApplicationContext
        ConfigurableApplicationContext context = mock(ConfigurableApplicationContext.class);
        Mockito.when(springApplicationMock.run(DevOpsProjectSpringBootApplication.class)).thenReturn(context);

        // Run the main method
        DevOpsProjectSpringBootApplication.main(new String[]{});

        // Verify that SpringApplication.run() was called with the correct arguments
        verify(springApplicationMock, times(1)).run(DevOpsProjectSpringBootApplication.class);

        // Assert that the context is not null
        assertNotNull(context);
    }
}