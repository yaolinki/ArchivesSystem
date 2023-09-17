import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class test3 {


    @Test
    public void test1() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.updateAndGet((value)->{
            value+=10;
          return value;
        });
    }

    @Test
    public void test2() throws InterruptedException {
        demo(
                ()-> new AtomicLong(0)
                ,
                (action)-> action.getAndIncrement()
        );
    }


    public <T> void demo(Supplier<T> add, Consumer<T> action) throws InterruptedException {
        T t = add.get();
        List<Thread> list = new ArrayList<>();
        for (int i=0;i<4;i++) {
            list.add(new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    action.accept(t);
                }

            }));
        }
        list.forEach(thread -> thread.start());
//        list.forEach(a->{
//            try {
//                a.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
        Thread.sleep(3000);
        System.out.println(((AtomicLong)t).get());
    }
}




class WaitRoom extends ReentrantLock{

    private int key;

    public void print(String name,int key, int next){

    }

    public WaitRoom(int key) {
        this.key = key;
    }
}
