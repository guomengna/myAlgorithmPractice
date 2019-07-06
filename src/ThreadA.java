/**
 * ThreadA/ThreadB/MultiThreads.call2()
 * 实现死锁
 */
public class ThreadA extends Thread{
    Object locka = new Object();
    Object lockb = new Object();
    public ThreadA(Object locka, Object lockb){
        this.locka = locka;
        this.lockb = lockb;
    }
    public void run(){
        System.out.println("A starting....");
        synchronized (locka){
            try{
                Thread.sleep(100);
                synchronized (lockb){
                    System.out.println("This is ThreadA");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("A end....");
    }
}
