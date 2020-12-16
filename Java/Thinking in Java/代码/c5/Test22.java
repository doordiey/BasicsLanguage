package c5;

public class Test22 {
    public enum Money1{
        One,Two,Five,Ten,Fifth,Hundred
    }

    public static void main(String[] args) {
        for(Money1 a:Money1.values()){
            switch (a){
                case One:System.out.println("一元钱");
                    break;
                case Two:System.out.println("两元钱");
                    break;
                case Five:System.out.println("五元钱");
                    break;
                case Ten:System.out.println("十元钱");
                    break;
                case Fifth:System.out.println("五十元钱");
                    break;
                case Hundred:System.out.println("一百块");
            }
        }
    }
}
