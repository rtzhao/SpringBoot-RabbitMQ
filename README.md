# SpringBoot-RabbitMQ

## 应用概述
🍃+🐰 SpringBoot 集成 RabbitMQ ，实现 Exchange 发送和接收 Queue 消息的direct、fanout、topic三种方式

## 特色功能

**Linux 运行 RabbitMQ**
```shell
#启动RabbitMQ
rabbitmq-server start &

#停止服务
rabbitmqctl stop
```

在项目配置文件中配置链接RabbitMQ的相关信息，建议先启用消息接受者，在启动发送者发送消息 <br/></br>

可在RabbitMQ面板中查看主要的 Exchange 和 Queue 信息，其中ip地址为本地Linuxi ip地址</br> 
http://192.168.52.128:15672/   

## 感谢
😘 感谢 @powernode 提供的教程支持
## License
开源，欢迎交流使用
