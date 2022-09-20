package com.lastcivilization.userwriteservice.utils;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.lastcivilization.userwriteservice.domain.port.UserRepository;
import com.lastcivilization.userwriteservice.infrastructure.application.UserWriteServiceApplication;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(classes = UserWriteServiceApplication.class, webEnvironment = RANDOM_PORT, properties = "test.url=http://localhost:9561")
@Testcontainers
public class IntegrationBaseClass {

    @Container
    private static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:14-alpine")
            .withDatabaseName("test");
    @Container
    private static RabbitMQContainer rabbitMQContainer = new RabbitMQContainer("rabbitmq:3-management-alpine")
            .withQueue("keycloak.queue");
    @Autowired
    protected RabbitTemplate rabbitTemplate;

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    private WireMockServer wireMockServer;

    @BeforeEach
    void setUp() {
        FeignClientMocks.mockEquipment(wireMockServer);
        FeignClientMocks.mockPayments(wireMockServer);
        FeignClientMocks.mockStats(wireMockServer);
    }

    @DynamicPropertySource
    private static void init(DynamicPropertyRegistry registry){
        registry.add("spring.rabbitmq.host", rabbitMQContainer::getHost);
        registry.add("spring.rabbitmq.port", rabbitMQContainer::getAmqpPort);
        registry.add("spring.rabbitmq.username", rabbitMQContainer::getAdminUsername);
        registry.add("spring.rabbitmq.password", rabbitMQContainer::getAdminPassword);
        registry.add("spring.datasource.url", () -> "jdbc:tc:postgresql:14-alpine:///test");
        registry.add("eureka.client.register-with-eureka", () -> "false");
        registry.add("eureka.client.fetch-registry", () -> "false");
    }
}
