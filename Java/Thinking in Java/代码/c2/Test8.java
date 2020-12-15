package c2;
public class Test8 {
    public static void main(String[] args){
        StaticTest that = new StaticTest();
        StaticTest th = new StaticTest();
        that.i ++;
        System.out.println(that.i);
        System.out.println(th.i);
    }
}
