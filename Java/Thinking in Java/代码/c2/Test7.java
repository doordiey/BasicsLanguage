package c2;

class StaticTest{
    static int i = 47;
}
class Incrementable{
    static void increment(){
        StaticTest.i++;
    }
}
public class Test7 {
    public static void main(String[] args){
        Incrementable.increment();
        System.out.print(StaticTest.i);
    }
}
