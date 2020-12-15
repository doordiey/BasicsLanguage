package c3;

class Accu{
    static int acv(int x, int t){
        return x/t;
    }
}
public class Test4 {
    public static void main(String[] args){
        System.out.println(Accu.acv(10,3));
        System.out.println(Accu.acv(13,3));
        System.out.println(Accu.acv(1,3));
    }
}
