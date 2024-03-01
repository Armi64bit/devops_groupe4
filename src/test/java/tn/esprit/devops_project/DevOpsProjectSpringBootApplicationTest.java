package tn.esprit.devops_project;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;

public class DevOpsProjectSpringBootApplicationTest {

    public static void main(String[] args) {
        SpringApplication springApplicationMock = Mockito.mock(SpringApplication.class);
        ApplicationStarter applicationStarter = new ApplicationStarter(springApplicationMock);
        applicationStarter.startApplication(args);
        Mockito.verify(springApplicationMock, Mockito.times(1));
        SpringApplication.run(DevOpsProjectSpringBootApplication.class, args);
    }
}


