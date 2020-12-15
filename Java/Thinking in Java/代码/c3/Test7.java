package c3;
import java.util.Random;

public class Test7 {
    public static void main(String[] args) {
        for(int x=1;x<11;x++) {
            System.out.print("第" + x + "次扔硬币: ");
            Random rand = new Random(x);
            int i = rand.nextInt(100) + 1;
            if (i > 50) {
                System.out.println("正面");
            }else{
                System.out.println("反面");
            }
        }
    }
}
