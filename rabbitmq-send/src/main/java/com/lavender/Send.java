package com.lavender;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Hello world!
 *
 */
public class Send 
{
    private static final String QUEUE_NAME = "hello";
    public static void main(String[] args) throws IOException, TimeoutException
    {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("rabbitmq");
        try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel())
        {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            String message = String.join(" ", args);
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}
