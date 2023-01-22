package com.lavender;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerApp {

    private static final String QUEUE_NAME = "my-queue";

    @Bean
    public Queue getQueue()
    {
        return new Queue(QUEUE_NAME, false);
    }

    @RabbitListener(queues = QUEUE_NAME)
    public void listen(String message)
    {
        System.out.println(" [x] Received '" + message + "'");
    }

    public static void main(String[] args)
    {
        SpringApplication.run(ConsumerApp.class, args);
    }
}
