package fun.rtzhao.springbootrabbitmq.service.impl;

import fun.rtzhao.springbootrabbitmq.service.SendService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author 邪王真眼是最强的
 * @Date 2021/9/12 08:34
 * @Version 1.0
 */
@Service("sendService")
public class SendServiceImpl implements SendService {
    @Resource
    private AmqpTemplate amqpTemplate;

    @Override
    public void sendMessage(String message) {
        amqpTemplate.convertAndSend("bootDirectExchange","bootDirectRoutingKey",message);
    }

    @Override
    public void sendFanoutMessage(String message) {
        amqpTemplate.convertAndSend("fanoutExchange","",message);
    }

    @Override
    public void sendTopicMessage(String message) {
        amqpTemplate.convertAndSend("topicExchange","aa.bb.cc",message);
    }

}
