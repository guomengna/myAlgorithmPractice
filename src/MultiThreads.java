public class MultiThreads {
    public void call(){
        Num num = new Num();
        PrintOdd printOdd = new PrintOdd(num);
        PrintEven printEven = new PrintEven(num);
        Thread thread1 = new Thread(printOdd);
        Thread thread2 = new Thread(printEven);
        thread1.start();
        thread2.start();
    }
    public void callproduct(){
        Product product = new Product();
        Productor productor = new Productor(product);
        Customer customer = new Customer(product);
        Thread thread1 = new Thread(productor);
        Thread thread2 = new Thread(customer);
        thread1.start();
        thread2.start();
    }

    public void call2(){
        System.out.println("Start!");
        Object locka = new Object();
        Object lockb = new Object();
        ThreadA threadA = new ThreadA(locka, lockb);
        ThreadB threadB = new ThreadB(locka, lockb);
        threadA.start();
        threadB.start();
        System.out.println("End......");
    }
}
