package tn.esprit.devops_project;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DevOpsProjectSpringBootApplicationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        // Ensure that the application context loads successfully
        assertNotNull(restTemplate);

    }

    @Test
    public void homePageReturnsHello() {
        String url = "http://localhost:" + port + "/";
        String body = this.restTemplate.getForObject(url, String.class);
        Assertions.assertThat(body).isEqualTo("Hello World!");
    }
}