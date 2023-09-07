import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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
}

class WaitRoom extends ReentrantLock{

    private int key;

    public void print(String name,int key, int next){

    }

    public WaitRoom(int key) {
        this.key = key;
    }
}
