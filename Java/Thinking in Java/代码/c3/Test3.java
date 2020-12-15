package c3;

class What{
    float x = 3;
}
class DoWhat{
    static void doit(What it){
        it.x = 4;
    }
}
public class Test3 {
    public static void main(String[] args){
        What it = new What();
        System.out.println(it.x);
        DoWhat.doit(it);
        System.out.println(it.x);
    }
}
