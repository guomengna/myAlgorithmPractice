public class Productor extends Thread{
    Product product;
    public Productor(Product product){
        this.product = product;
    }
    public void run(){
        while (true){
            synchronized (product){
                if(product.empty == 0){
                    try {
                        product.wait();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }else {
                    product.goods++;
                    product.empty--;
                    System.out.println("生产中----goods = " + product.goods + " and empty = " + product.empty);
                    product.notify();
                }
            }
        }
    }
}
