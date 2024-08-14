package it.silvio.spring_integration_practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

/**
 * Configuration class for Spring Integration.
 *
 * This class defines the configuration for the Spring Integration framework.
 */
@Configuration
public class IntegrationConfig {

    /**
     * Creates a direct message channel.
     *
     * This channel is used to send and receive messages within the application.
     *
     * @return a direct message channel
     */
    @Bean
    public MessageChannel messageChannel() {
        return new DirectChannel();
    }

    /**
     * Creates a message handler for processing orders.
     *
     * This handler is triggered when a message is sent to the
     * "discountedOrderChannel".
     * It prints a message to the console indicating that an order is being
     * processed.
     *
     * @return a message handler for processing orders
     */
    @Bean
    @ServiceActivator(inputChannel = "discountedOrderChannel")
    public MessageHandler orderHandler() {
        return message -> {
            System.out.println("Elaborazione ordine: " + message.getPayload());
        };
    }
}
