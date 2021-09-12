package fun.rtzhao.springbootrabbitmq.service;

/**
 * @Author 邪王真眼是最强的
 * @Date 2021/9/12 08:33
 * @Version 1.0
 */
public interface SendService {
    void sendMessage(String message);
    void sendFanoutMessage(String message);
    void sendTopicMessage(String message);
}
