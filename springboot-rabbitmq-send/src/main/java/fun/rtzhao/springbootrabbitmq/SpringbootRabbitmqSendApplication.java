package fun.rtzhao.springbootrabbitmq;

import fun.rtzhao.springbootrabbitmq.service.SendService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootRabbitmqSendApplication {

    public static void main(String[] args) {
        ApplicationContext ac=SpringApplication.run(SpringbootRabbitmqSendApplication.class, args);
        SendService sendService = (SendService) ac.getBean("sendService");
//        sendService.sendMessage("Boot的测试测试数据");
//        sendService.sendFanoutMessage("Fanout的测试数据");
        sendService.sendTopicMessage("Topic测试数据---key为---aa.bb.cc");
    }
}
