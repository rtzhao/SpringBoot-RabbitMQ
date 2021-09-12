package fun.rtzhao.springbootrabbitmq.service.impl;

import fun.rtzhao.springbootrabbitmq.service.ReceiveService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 邪王真眼是最强的
 * @Date 2021/9/12 09:14
 * @Version 1.0
 */

@Service("receiveService")
public class ReceiveServiceImpl implements ReceiveService {
    @Resource
    private AmqpTemplate amqpTemplate;

    /**
     * 每执行一次才接收一次消息，不建议使用
     */
    @Override
    public void receive() {
        String message = (String) amqpTemplate.receiveAndConvert("bootDirectQueue");
        System.out.println(message);
    }

    @Override
    @RabbitListener(queues = {"bootDirectQueue"})
    public void directReceive(String message) {
        System.out.println("监听器接收消息" + message);
    }

    /**
     * @param message
     * @QueueBinding 完成交换机和队列的绑定
     * @Queue 创建一个队列，没有指定参数则表示创建一个随机的队列
     * @Exchange 创建一个交换机
     */
    @Override
    @RabbitListener(bindings =
            {@QueueBinding(
                    value = @Queue(),
                    exchange = @Exchange(name = "fanoutExchange", type = "fanout")
            )})
    public void fanoutReceive01(String message) {
        System.out.println("fanoutReceive01监听器接收消息" + message);
    }

    @Override
    @RabbitListener(bindings =
            {@QueueBinding(
                    value = @Queue(),
                    exchange = @Exchange(name = "fanoutExchange", type = "fanout")
            )})
    public void fanoutReceive02(String message) {
        System.out.println("fanoutReceive02监听器接收消息" + message);
    }

    @RabbitListener(bindings = {@QueueBinding(
            value = @Queue("topic01"),
            key = {"aa"},
            exchange = @Exchange(name = "topicExchange", type = "topic")
    )})
    public void topicReceive01(String message) {
        System.out.println("topic01消费者-----aa----"+message);
    }

    @RabbitListener(bindings = {@QueueBinding(
            value = @Queue("topic02"),
            key = {"aa.*"},
            exchange = @Exchange(name = "topicExchange", type = "topic")
    )})
    public void topicReceive02(String message) {
        System.out.println("topic02消费者-----aa.*----"+message);
    }

    @RabbitListener(bindings = {@QueueBinding(
            value = @Queue("topic03"),
            key = {"aa.#"},
            exchange = @Exchange(name = "topicExchange", type = "topic")
    )})
    public void topicReceive03(String message) {
        System.out.println("topic03消费者-----aa.#----"+message);
    }

}
