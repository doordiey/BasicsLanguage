package c4;

import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        int x = 1;
        int a = 0;
        for (int i=0;i<25;i++){
            Random rand = new Random(a);
            x = rand.nextInt(100);
            if (x>a){
                System.out.println(x+"大于"+a);
            }else{
                if(x==a){
                    System.out.println(x+"等于"+a);
                }
                else{
                    System.out.println(x+"小于"+a);
                }
            }
            a = x;
        }
    }
}
