package tn.esprit.devops_project;

import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;

public class DevOpsProjectSpringBootApplicationTest {

    public static void main(String[] args) {
        testStartApplication();
    }

    public static void testStartApplication() {
        SpringApplication springApplicationMock = Mockito.mock(SpringApplication.class);
        ApplicationStarter applicationStarter = new ApplicationStarter(springApplicationMock);
        String[] args = null; // Or String[] args = {};
        applicationStarter.startApplication(args);
        Mockito.verify(springApplicationMock, Mockito.times(1)).run(DevOpsProjectSpringBootApplication.class, args);
    }
}

