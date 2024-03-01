package tn.esprit.devops_project;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplication;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DevOpsProjectSpringBootApplicationTest {

    @Mock
    private SpringApplication springApplicationMock;

    @InjectMocks
    private DevOpsProjectSpringBootApplication application;

    @Test
    public void main() {
        String[] args = {"arg1", "arg2"}; // Sample command line arguments

        // Call the main method
        application.main(args);

        // Verify that SpringApplication.run() was called with the correct arguments
        verify(springApplicationMock).run(DevOpsProjectSpringBootApplication.class, args);
    }
}
