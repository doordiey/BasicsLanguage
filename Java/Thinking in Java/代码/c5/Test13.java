package c5;

class Cup{
    Cup(int maker){
        System.out.println("Cup("+maker+")");
    }
    void f(int maker){
        System.out.println("f("+maker+")");
    }
}

class Cups{
    static Cup cup1;
    static Cup cup2;
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }
    Cups(){
        System.out.println("Cups");
    }
}

public class Test13 {
    public static void main(String[] args) {
        System.out.println("inside main");
        Cups.cup1.f(99);
    }
//    static Cups cups1 = new Cups();
//    static Cups cups2 = new Cups();
}
