package c3;

public class Test11 {
    public static void main(String[] args) {
        int a = 0x19;
        System.out.println(Integer.toBinaryString(a));
        while(a !=0){
            a >>=1;
            System.out.println(Integer.toBinaryString(a));
        }
    }
}
