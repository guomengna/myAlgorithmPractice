public class Singleton {
    private Singleton(){}
    private static class SingletonHolder{
        private static final Singleton INSTACE = new Singleton();
    }
    public Singleton getInstance(){
        return SingletonHolder.INSTACE;
    }
}
