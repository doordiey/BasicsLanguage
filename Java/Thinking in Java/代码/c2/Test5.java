package c2;

class DateOnly {
    int i;
    double d;
    boolean b;
}
public class Test5 {
    public static void main(String[] args){
        DateOnly that = new DateOnly();
        that.i = 21;
        that.d = 2.1;
        that.b = true;
        System.out.println(that.i);
        System.out.println(that.d);
        System.out.println(that.b);
    }
}
