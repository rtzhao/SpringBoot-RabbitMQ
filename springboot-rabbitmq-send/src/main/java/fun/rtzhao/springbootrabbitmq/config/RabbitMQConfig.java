package fun.rtzhao.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 邪王真眼是最强的
 * @Date 2021/9/12 08:46
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
    public Binding directBinding(Queue directQueue,DirectExchange directExchange){
        return BindingBuilder.bind(directQueue).to(directExchange).with("bootDirectRoutingKey");
    }

    //    配置交换机，确保fanoutExchange交换机一定存在
    @Bean
    public FanoutExchange fanoutExchange() {

        return new FanoutExchange("fanoutExchange");
    }

    //    配置交换机，确保topicExchange交换机一定存在
    @Bean
    public TopicExchange topicExchange() {

        return new TopicExchange("topicExchange");
    }
}
