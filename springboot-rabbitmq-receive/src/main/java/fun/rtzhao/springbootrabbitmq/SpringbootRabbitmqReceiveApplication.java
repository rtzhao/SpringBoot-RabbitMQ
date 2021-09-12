package fun.rtzhao.springbootrabbitmq;

import fun.rtzhao.springbootrabbitmq.service.ReceiveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootRabbitmqReceiveApplication {

    public static void main(String[] args) {
        ApplicationContext ac =SpringApplication.run(SpringbootRabbitmqReceiveApplication.class, args);
        ReceiveService service = (ReceiveService) ac.getBean("receiveService");
//        service.receive();
    }

}
