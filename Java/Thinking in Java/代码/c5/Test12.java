package c5;

class Tank{
    boolean kong = true;
    String name;
    Tank(String s){
        this.name = s;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("清理开始" + this.name);
        if(kong){
            System.out.println(this.name + "被清理了");
            super.finalize();
        }
    }
}
public class Test12 {
    public static void main(String[] args) {
        Tank t1 = new Tank("t1");
        new Tank("t2");
        t1.kong = false;
        System.gc();
    }
}
