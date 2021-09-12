package fun.rtzhao.springbootrabbitmq.service;

/**
 * @Author 邪王真眼是最强的
 * @Date 2021/9/12 09:12
 * @Version 1.0
 */
public interface ReceiveService {
    void receive();

    void directReceive(String message);

    void fanoutReceive01(String message);

    void fanoutReceive02(String message);
}
