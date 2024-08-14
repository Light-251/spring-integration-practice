package it.silvio.spring_integration_practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel messageChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "discountedOrderChannel")
    public MessageHandler orderHandler() {
        return message -> {
            System.out.println("Elaborazione ordine: " + message.getPayload());
        };
    }

    // Test Commit Vs Code
}
