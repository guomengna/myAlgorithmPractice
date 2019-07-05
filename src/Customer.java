public class Customer extends Thread{
    Product product;
    public Customer(Product product){
        this.product = product;
    }
    public void run(){
        while(true){
            synchronized (product){
                if(product.goods == 0){
                    try {
                        product.wait();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }else {
                    product.goods--;
                    product.empty++;
                    System.out.println("消费中----goods = " + product.goods + " and empty = " + product.empty);
                    product.notify();
                }
            }
        }
    }
}
