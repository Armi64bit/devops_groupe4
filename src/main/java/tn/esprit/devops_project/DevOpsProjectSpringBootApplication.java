package tn.esprit.devops_project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DevOpsProjectSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevOpsProjectSpringBootApplication.class, args);
    }
}

@Component
class ApplicationStarter {

    private final SpringApplication springApplication;

    public ApplicationStarter(SpringApplication springApplication) {
        this.springApplication = springApplication;
    }
    public void startApplication(String[] args) {
        springApplication.run(DevOpsProjectSpringBootApplication.class, args);
    }
}

