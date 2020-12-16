package c5;

class Pa{
    String a;
    {
        a = "我困了";
    }
    void pr(){
        System.out.println(a);
    }
}
public class Test15 {
    public static void main(String[] args) {
        Pa it = new Pa();
        it.pr();
    }
}
