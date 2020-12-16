package c5;

public class Test18 {
    public static void main(String[] args) {
        Pu[] it = new Pu[3];
        it[0] = new Pu("我");
        it[1] = new Pu("困");
        it[2] = new Pu("了");
        for(Pu a:it){
            System.out.println(a);
        }
    }
}
