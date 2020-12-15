package c3;

class Bi{
    static void bijiao(String s1, String s2){
        System.out.println("s1:"+s1+" s2:"+ s2);
        System.out.println("s1==s2:"+s1==s2);
        System.out.println("s1!=s2:"+s1!=s2);
        System.out.println("s1.equals(s2):"+s1.equals(s2) +"\n");

    }
}
public class Test14 {
    public static void main(String[] args) {
        String a = new String("nihao");
        String b = new String("nihao");
        String c = "nihao";
        String d = a;
        String e = "ni";
        String f = new String("ni");
        Bi.bijiao(a, b);
        Bi.bijiao(a, c);
        Bi.bijiao(a, d);
        Bi.bijiao(a, e);
        Bi.bijiao(a, f);
    }
}
