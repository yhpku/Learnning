package api;

public class DemoServiceImpl2 implements DemoService {
    public String sayHello(String name) {
        System.out.println("DemoServiceImpl2 begin...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("DemoServiceImpl2 begin...");

        return "Hello2 " + name;
    }

    public static void main(String [] args){
        new DemoServiceImpl2().sayHello("hello");
    }
}
