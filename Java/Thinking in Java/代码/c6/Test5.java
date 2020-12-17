package c6;

import c6.Test4.pp.Sam;

class All{
    public int a;
    private int b;
    protected int c;
    int d;
    public void aa(){
        System.out.println(a);
    }
    private void bb(){
        System.out.println(b);
    }
    protected void cc(){
        System.out.println(c);
    }
    void dd(){
        System.out.println(d);
    }
}
public class Test5 {
    public static void main(String[] args) {
        All it = new All();
        System.out.println(it.a);
//        System.out.println(it.b);  编译错误
        System.out.println(it.c);
        System.out.println(it.d);
        it.aa();
//        it.bb(); 编译错误
        it.cc();
        it.dd();
    }
}
