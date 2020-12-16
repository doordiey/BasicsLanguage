package c5;

class Sh1{
    String a = "ni";
    String b;//编译器会对其进行初始化为
    Sh1(){
        System.out.println("定义时就初始化了的a在调用构造器时的值："+this.a);
        System.out.println("构造器初始化的此时的b："+this.b);
        this.b = "ni";
        System.out.println("构造器定义后的b："+this.b);
    }
}
public class Test2 {
    public static void main(String[] args) {
        System.out.println("定义时初始化和构造器初始化的区别");
        Sh1 that1 = new Sh1();
    }
}
