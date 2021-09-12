package fun.rtzhao.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 邪王真眼是最强的
 * @Date 2021/9/12 09:15
 * @Version 1.0
 */
@Configuration
public class RabbitMQConfig {
    //    配置交换机
    @Bean
    public DirectExchange directExchange() {

        return new DirectExchange("bootDirectExchange");
    }

    //配置队列
    @Bean
    public Queue directQueue() {
        return new Queue("bootDirectQueue");
    }

    /**
     *配置一个队列和交换机的绑定
     * @param directQueue
     * @param directExchange
     * @return
     */
    @Bean
    public Binding directBinding(Queue directQueue, DirectExchange directExchange){
        return BindingBuilder.bind(directQueue).to(directExchange).with("bootDirectRoutingKey");
    }
}

