package com.lavender;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerApp {

    private static final String QUEUE_NAME = "my-queue";
    private static String[] mainArgs;

    @Bean
    public Queue getQueue()
    {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    public ApplicationRunner runner(RabbitTemplate template)
    {
        return (args) -> template.convertAndSend(QUEUE_NAME, String.join(" ", mainArgs));
    }

    public static void main(String[] args)
    {
        mainArgs = args;
        SpringApplication.run(ProducerApp.class, args);
    }
}
