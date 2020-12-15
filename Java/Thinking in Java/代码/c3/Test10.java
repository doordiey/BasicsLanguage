package c3;

public class Test10 {
    public static void main(String[] args) {
        int a = 0x0a;
        int b = 0x05;
        System.out.println("a:"+Integer.toBinaryString(a));
        System.out.println("b:"+Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(a^b));
        System.out.println(Integer.toBinaryString(a&b));
        System.out.println(Integer.toBinaryString(a|b));
        System.out.println(Integer.toBinaryString(a^~b));
        System.out.println(Integer.toBinaryString(a&~b));
        System.out.println(Integer.toBinaryString(a|~b));
        System.out.println(Integer.toBinaryString(~a^b));
        System.out.println(Integer.toBinaryString(~a&b));
        System.out.println(Integer.toBinaryString(~a&b));
    }
}
