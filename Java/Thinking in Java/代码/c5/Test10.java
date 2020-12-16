package c5;

class Dirty{
    protected void finalize(){
        System.out.println("自己定义的清理");
//        try{
//            super.finalize();
//        }catch (Throwable e){
//            e.printStackTrace();
//        }
    }
}
public class Test10 {
    public static void main(String[] args) {
        Dirty it = new Dirty();
//        it.finalize();
    }
}
