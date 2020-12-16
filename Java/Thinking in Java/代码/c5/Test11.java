package c5;

class Dirty1{
    protected void finalize(){
        System.out.println("自己定义的清理");
    }
}

public class Test11 {
    public static void main(String[] args) {
        Dirty1 dirty = new Dirty1();
        dirty = null;
        System.gc();
    }
}
