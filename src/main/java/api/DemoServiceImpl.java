package api;

public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        System.out.println("DemoServiceImpl begin...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("DemoServiceImpl end...");

        return "Hello " + name;
    }

    public static void main(String [] args){
        new DemoServiceImpl().sayHello("hello");
    }
}
