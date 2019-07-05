public class PrintEven extends Thread{
    Num num;
    public PrintEven(Num num){
        this.num = num;
    }
    public void run(){
        while (num.index <= 100){
            synchronized (num){
                if(!num.flag){
                    try {
                        num.wait();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }else {
                    System.out.println("偶数------------" + num.index);
                    num.index++;
                    num.flag = false;
                    num.notify();
                }
            }
        }
    }
}
