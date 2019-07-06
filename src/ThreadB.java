public class ThreadB extends Thread{
    Object locka = new Object();
    Object lockb = new Object();
    public ThreadB(Object locka, Object lockb){
        this.locka = locka;
        this.lockb = lockb;
    }
    public void run(){
        System.out.println("B starting....");
        synchronized (lockb){
            try{
                ThreadB.sleep(100);
                synchronized (locka){
                    System.out.println("This is ThreadB");
                }
            }catch (Exception e){
                e.getMessage();
            }
        }
        System.out.println("A end....");
    }
}
