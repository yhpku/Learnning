package comsumer;

import api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        context.start();

        for (int i=0; i<100; i++){
            DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
            String hello = demoService.sayHello("world"); // 执行远程方法
            System.out.println( hello ); // 显示调用结果
        }
    }
}
