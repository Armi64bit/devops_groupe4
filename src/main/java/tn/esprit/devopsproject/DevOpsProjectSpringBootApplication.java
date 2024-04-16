package tn.esprit.devopsproject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevOpsProjectSpringBootApplication {
    final static Logger logger = LoggerFactory.getLogger(DevOpsProjectSpringBootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DevOpsProjectSpringBootApplication.class, args);
    }
}
