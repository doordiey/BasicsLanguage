package c5;

public class Test21 {
    public enum Money{
        One,Two,Five,Ten,Fifty,Hundred
    }

    public static void main(String[] args) {
        for(Money a:Money.values()){
            System.out.println(a+","+a.ordinal());
        }
    }
}
