package c5;

class Cut{
    static String a = "nihao";
    static String b;
    static {
        b = "nibuhao";
    }
    static void pr(){
        System.out.println(a);
        System.out.println(b);
    }

}

public class Test14 {
    public static void main(String[] args) {
        Cut.pr();
    }
}
