import lombok.extern.slf4j.Slf4j;

//@Slf4j(topic = "test1")
@Slf4j
public class test1 {
    public static void main(String[] args) {
//        new test2((a)->{
//        return new Son();
//        });
//        DD dd = new DD();
//        new test2(dd::get);
       Thread t1= new Thread(()->{
           for (int i=0;i<100;i++) {
               log.info("========");
             //  System.out.println("=====");
           }
        },"t1");

       t1.start();


        Thread thread = new Thread();
        Thread t2 = new Thread();



    }
}
