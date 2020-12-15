package c4;

public class Test5 {
    public static void main(String[] args) {
        int a = 0x0a;
        int b = 0x05;
        int ans = a^b;
        while(ans!=0){
            System.out.print(ans%2==1?1:0);
            ans = ans / 2;
        }
    }
}
