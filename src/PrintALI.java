//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.ReentrantLock;
//public class PrintALI {
//    private final ReentrantLock lock = new ReentrantLock();
//    private Condition printA = lock.newCondition();
//    private Condition printB = lock.newCondition();
//    private Condition printC = lock.newCondition();
//    private int flag = 0;
//
//    public void printA() {
//        for (int i = 0; i < 2; i++) {
//            lock.lock();
//            try {
//                while (flag != 0)
//                    printA.await();
//                System.out.print("A");
//                flag = 1;
//                printB.signal();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//        }
//    }
//
//    public void printL() {
//        for (int i = 0; i < 2; i++) {
//            lock.lock();
//            try {
//                while (flag != 1)
//                    printB.await();
//                System.out.print("L");
//                flag = 2;
//                printC.signal();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//        }
//    }
//
//    public void printI() {
//        for (int i = 0; i < 2; i++) {
//            lock.lock();
//            try {
//                while (flag != 2)
//                    printC.await();
//                System.out.print("I");
//                flag = 0;
//                printA.signal();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//        }
//    }
//}
//
//public class Main {
//    public static void main(String[] args) throws Exception {
//        final PrintALI printALI = new PrintALI();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                printALI.printA();
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                printALI.printI();
//
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                printALI.printL();
//            }
//        }).start();
//    }
//}
