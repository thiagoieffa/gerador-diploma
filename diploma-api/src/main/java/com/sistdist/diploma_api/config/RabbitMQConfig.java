package com.sistdist.diploma_api.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value(("${rabbitmq.queue.response}"))
    private String queueResposta;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value(("${rabbitmq.routing.key}"))
    private String routingKey;

    @Bean
    public Queue queue() {
        return new Queue(queue);
    }

    @Bean
    public Queue queueResposta() {
        return new Queue(queueResposta);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding bind() {
        return BindingBuilder.bind(queue())
                .to(exchange())
                .with(routingKey);
    }

}
