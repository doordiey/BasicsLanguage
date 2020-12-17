package c6.Test4;


import c6.Test4.pp.Sam;

class p2 extends Sam {
    public static void say(){
        am();
    }
}
public class Test4 {
    public static void main(String[] args) {
        p2 b = new p2();
        p2.say();
//        Sam.am();无法调用
    }
}
