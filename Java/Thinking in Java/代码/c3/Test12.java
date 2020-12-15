package c3;

public class Test12 {
    public static void main(String[] args) {
        int a = 0xff;
        System.out.println(Integer.toBinaryString(a));
        a <<= 1;
        System.out.println(Integer.toBinaryString(a));
        while (a!=0){
            a>>>=1;
            System.out.println(Integer.toBinaryString(a));
        }
        System.out.println(Integer.toBinaryString(a));

    }
}
