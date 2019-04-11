public class TestProduce {
    public void test(){
        Storage storage = new Storage();
        Producer p = new Producer(storage);
        Consumer c = new Consumer(storage);
        int i = 0;
        p.setNum(20);
        p.start();
        c.setNum(70);
        c.start();
    }
}
