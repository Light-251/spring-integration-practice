package it.silvio.spring_integration_practice;

import java.time.Instant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.core.GenericHandler;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
public class SpringIntegrationPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationPracticeApplication.class, args);
    }

    @Bean
    MessageChannel atob() {
        return MessageChannels.direct().get();
    }

    @Bean
    IntegrationFlow flow() {
        return IntegrationFlow
                .from((MessageSource<String>) () -> MessageBuilder.withPayload("Hello World @ " + Instant.now())
                        .build())
                .channel(atob())
                .get();
    }

    @Bean
    IntegrationFlow integrationFlow() {
        return IntegrationFlow
                .from(atob())
                .handle(new GenericHandler<String>() {
                    @Override
                    public Object handle(String payload, MessageHeaders headers) {
                        System.out.println("The payload is " + payload);
                        return null;
                    }
                })
                .get();
    }

}
