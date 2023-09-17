import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;


@Slf4j
public class Test5 {

    @Test
    public void test1() {
        MyLock lock = new MyLock();
        new Thread(()->{
            lock.lock();
            try {
                log.info("hello");
            }finally {
                lock.unlock();
            }
        },"t1").start();

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(()->{

        });

        LockSupport.park();

        ReentrantReadWriteLock lock1 = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock1.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock1.writeLock();
        readLock.lock();
        writeLock.lock();

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.tryLock();
        reentrantLock.lock();
        Condition condition = reentrantLock.newCondition();
    }
}


@Slf4j
/*自定义锁*/
class MyLock implements Lock {

    //独占锁 同步器类
    class MySync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                //加上了锁 并设置owner为当前线程
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override //是否持有独占锁
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        public Condition newCondition(){
            return new ConditionObject();
        }
    }

    private MySync sync = new MySync();

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override //加锁，可打断
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}