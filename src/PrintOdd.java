public class PrintOdd extends Thread{
    Num num;
    public PrintOdd(Num num){
        this.num = num;
    }
    public void run(){
        while(num.index <= 100){
            synchronized (num){
                if(num.flag){
                    try{
                        num.wait();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }else {
                    System.out.println("奇数---------" + num.index);
                    num.index++;
                    num.flag = true;
                    num.notify();
                }
            }
        }
    }
}
